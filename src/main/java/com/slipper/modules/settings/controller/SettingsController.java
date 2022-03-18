package com.slipper.modules.settings.controller;

import com.slipper.common.utils.R;
import com.slipper.common.validator.group.Update;
import com.slipper.modules.settings.entity.SettingsEntity;
import com.slipper.modules.settings.service.SettingsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统设置
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class SettingsController {
    @Resource
    private SettingsService settingsService;

    /**
     * 信息
     *
     * @api {GET} /slipper/console/settings/info info
     * @apiDescription 系统设置信息
     * @apiVersion 1.0.0
     * @apiGroup Settings
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
     *     data: {
     *         id: '', // ID
     *         name: '', // 名称
     *         avatar: '', // 头像
     *         signature: '', // 签名
     *         address: '', // 地址
     *         qq: '', // QQ图片
     *         wechat: '', // 微信图片
     *         github: '', // Github主页
     *         official_account: '', // 微信公众号图片
     *         wechat_group: '', // 微信群图片
     *         qq_group: '', // QQ群图片
     *         logo: '', // Logo
     *         title: '', // 网站标题
     *         record_number: '', // 网站备案号
     *         record_number_link: '', // 备案号跳转链接
     *         link: '', // 站点链接
     *         describe: '', // 站点描述
     *         email: '', // 邮箱
     *     }
     * }
     */
    @GetMapping("/console/settings/info")
    public R info(){
        return R.success(settingsService.getById(1));
    }

    /**
     * 编辑
     *
     * @api {POST} /slipper/console/settings/update update
     * @apiDescription 系统编辑
     * @apiVersion 1.0.0
     * @apiGroup Settings
     * @apiName update
     * @apiParamExample 请求参数示例
     * {
     *     id: '', // ID
     *     name: '', // 名称
     *     avatar: '', // 头像
     *     signature: '', // 签名
     *     address: '', // 地址
     *     qq: '', // QQ图片
     *     wechat: '', // 微信图片
     *     github: '', // Github主页
     *     official_account: '', // 微信公众号图片
     *     wechat_group: '', // 微信群图片
     *     qq_group: '', // QQ群图片
     *     logo: '', // Logo
     *     title: '', // 网站标题
     *     record_number: '', // 网站备案号
     *     record_number_link: '', // 备案号跳转链接
     *     link: '', // 站点链接
     *     describe: '', // 站点描述
     *     email: '', // 邮箱
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/settings/update")
    public R update(@RequestBody @Validated SettingsEntity settingsEntity){
        settingsEntity.setId(1);
        settingsService.updateById(settingsEntity);
        return R.success();
    }

    /**
     * 信息
     *
     * @api {GET} /slipper/client/settings/info info
     * @apiDescription 系统设置信息
     * @apiVersion 1.0.0
     * @apiGroup Settings
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
     *     data: {
     *         id: '', // ID
     *         name: '', // 名称
     *         avatar: '', // 头像
     *         signature: '', // 签名
     *         address: '', // 地址
     *         qq: '', // QQ图片
     *         wechat: '', // 微信图片
     *         github: '', // Github主页
     *         official_account: '', // 微信公众号图片
     *         wechat_group: '', // 微信群图片
     *         qq_group: '', // QQ群图片
     *         logo: '', // Logo
     *         title: '', // 网站标题
     *         record_number: '', // 网站备案号
     *         record_number_link: '', // 备案号跳转链接
     *         link: '', // 站点链接
     *         describe: '', // 站点描述
     *         email: '', // 邮箱
     *     }
     * }
     */
    @GetMapping("/client/settings/info")
    public R clientInfo(){
        return R.success(settingsService.getById(1));
    }

}
