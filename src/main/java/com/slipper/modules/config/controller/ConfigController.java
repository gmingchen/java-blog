package com.slipper.modules.config.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.slipper.common.utils.R;
import com.slipper.common.vo.StatusVo;
import com.slipper.modules.config.entity.ConfigEntity;
import com.slipper.modules.config.model.vo.ConfigVo;
import com.slipper.modules.config.service.ConfigService;
import com.slipper.modules.user.entity.UserEntity;
import com.slipper.modules.user.model.vo.UserPageVo;
import com.slipper.modules.user.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 配置
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class ConfigController {
    @Resource
    private ConfigService configService;

    /**
     * 列表
     *
     * @api {GET} /slipper/console/config/list list
     * @apiDescription 配置列表
     * @apiVersion 1.0.0
     * @apiGroup Config
     * @apiName list
     * @apiParamExample 请求参数示例
     * {}
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: [{
     *         id: '', // ID
     *         name: '', // 名称
     *         json_key: '', // 键值
     *         json_value: '', // 值-json字符串
     *         status: '', // 状态 0：禁用 1：正常
     *         remark: '', // 备注
     *         created_at: '', // 创建时间
     *         updated_at: '' // 更新时间
     *     }]
     * }
     */
    @GetMapping("/console/config/list")
    public R list(){
        LambdaQueryWrapper<ConfigEntity> wrapper = new LambdaQueryWrapper<ConfigEntity>()
                .orderByDesc(ConfigEntity::getStatus);
        return R.success(configService.list(wrapper));
    }

    /**
     * 信息
     *
     * @api {GET} /slipper/console/config/info info
     * @apiDescription 配置值信息
     * @apiVersion 1.0.0
     * @apiGroup Config
     * @apiName info
     * @apiParamExample 请求参数示例
     * {
     *     id: '', // ID
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: { // json 值
     *     }
     * }
     */
    @GetMapping("/console/config/info")
    public R info(Integer id){
        return R.success(configService.queryValueById(id));
    }

    /**
     * 编辑
     *
     * @api {POST} /slipper/console/config/update update
     * @apiDescription 编辑配置值信息
     * @apiVersion 1.0.0
     * @apiGroup Config
     * @apiName update
     * @apiParamExample 请求参数示例
     * {
     *     id: '', // ID
     *     value: '', // json 字符串
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/config/update")
    public R update(@RequestBody ConfigVo configVo) {
        configService.update(configVo);
        return R.success();
    }

    /**
     * 启用配置 同一个键只能启用一个
     *
     * @api {POST} /slipper/console/config/status status
     * @apiDescription 编辑配置值信息
     * @apiVersion 1.0.0
     * @apiGroup Config
     * @apiName status
     * @apiParamExample 请求参数示例
     * {
     *     key: '', // ID
     *     value: '', // 0：禁用 1：启用
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/config/status")
    public R status(@RequestBody StatusVo<Integer, Integer> statusVo) {
        configService.status(statusVo);
        return R.success();
    }

}
