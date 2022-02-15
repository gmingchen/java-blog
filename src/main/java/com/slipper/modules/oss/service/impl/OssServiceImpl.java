package com.slipper.modules.oss.service.impl;

import com.slipper.common.exception.RunException;
import com.slipper.common.utils.Constant;
import com.slipper.common.utils.FileUtils;
import com.slipper.common.utils.Watermark;
import com.slipper.modules.config.entity.ConfigEntity;
import com.slipper.modules.config.service.ConfigService;
import com.slipper.modules.oss.service.OssService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

/**
 * @author gumingchen
 */
@Service("ossService")
public class OssServiceImpl implements OssService {

    @Resource
    private ConfigService configService;

    @Override
    public String upload(MultipartFile file, Boolean watermark) {
        Map<String, Object> options = configService.queryValueByKey("CLOUD_STORAGE");
        String path = (String)options.get("path");
        String domain = (String)options.get("domain");
        String prefix = (String)options.get("prefix");
        Integer type = (Integer)options.get("type");

        // 文件名称
        String fileName = file.getOriginalFilename();
        // 文件扩展名
        String extension = fileName.substring(fileName.lastIndexOf("."));
        // 存储文件名称
        String name = UUID.randomUUID() + extension;
        // 文件完整路径
        String fullPath = path + "/" + name;
        // 资源统一定位符
        String url = domain + "/" + (StringUtils.isNotBlank(prefix) ? prefix : "" ) + "/" + name;

        boolean result = true;
        switch (type) {
            // 本地
            case 1:
                result = FileUtils.upload(file, fullPath);
                if (watermark != null && watermark) {
                    Watermark.printText(fullPath, "@拖孩-1250235512@qq.com");
                }
                break;
            // 七牛云
            case 2:
                String accessKey = (String)options.get("access");
                String secretKey = (String)options.get("secret");
                String bucket = (String)options.get("bucket");
                String key = (StringUtils.isNotBlank(prefix) ? prefix + "/" : "") + name;
                result = FileUtils.upload(file, accessKey, secretKey, bucket, key);
                break;
            default:
                break;
        }

        if (!result) {
            throw new RunException(Constant.WARNING_CODE, "上传失败");
        }

        return url;
    }
}