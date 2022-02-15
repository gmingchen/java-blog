package com.slipper.modules.oss.controller;

import com.slipper.common.utils.R;
import com.slipper.modules.oss.service.OssService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Oss 对象存储
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class OssController {
    @Resource
    private OssService ossService;

    /**
     * 文件上传
     *
     * @api {POST} /slipper/console/oss/upload upload
     * @apiDescription 上传文件
     * @apiVersion 1.0.0
     * @apiGroup Oss
     * @apiName upload
     * @apiParamExample 请求参数示例
     * {
     *     file: (binary), // 文件流
     *     watermark: true, // 是否加水印
     *     params: {} // 自定义参数
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     *     data: {
     *         url: '', // 统一资源定位符
     *         params: {} // 自定义参数
     *     }
     * }
     */
    @PostMapping("/console/oss/upload")
    public R upload(MultipartFile file, Boolean watermark, Map<String, Object> params){
        Map<String, Object> map = new HashMap(2);
        map.put("url", ossService.upload(file, watermark));
        map.put("params", params);

        return R.success(map);
    }

}
