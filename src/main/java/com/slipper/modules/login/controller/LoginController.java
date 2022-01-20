package com.slipper.modules.login.controller;

import com.slipper.common.utils.R;
import com.slipper.modules.login.model.vo.LoginVo;
import com.slipper.modules.login.model.vo.RegisterVo;
import com.slipper.modules.login.service.LoginService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录 / 注册
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
@RequestMapping("/client")
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 登录
     *
     * @api {POST} /client/login
     * @apiDescription 登录
     * @apiVersion 1.0.0
     * @apiGroup Login
     * @apiName login
     * @apiParamExample 请求参数示例
     * {
     *     username: '', // 帐号
     *     password: '', // 密码
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: '' // 凭证 token
     * }
     */
    @PostMapping("/login")
    public R login(@RequestBody @Validated LoginVo loginVo) {
        return R.success(loginService.login(loginVo));
    }

    /**
     * 登录
     *
     * @api {POST} /client/register
     * @apiDescription 登录
     * @apiVersion 1.0.0
     * @apiGroup Login
     * @apiName login
     * @apiParamExample 请求参数示例
     * {
     *     username: '', // 帐号
     *     password: '', // 密码
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/register")
    public R register(@RequestBody @Validated RegisterVo registerVo) {
        loginService.register(registerVo);
        return R.success();
    }

}
