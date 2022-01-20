package com.slipper.modules.login.service;

import com.slipper.modules.login.model.vo.LoginVo;
import com.slipper.modules.login.model.vo.RegisterVo;

/**
 * 登录
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface LoginService {

    /**
     * 登录
     * @param loginVo 登录参数
     * @return
     */
    String login(LoginVo loginVo);

    /**
     * 注册
     * @param registerVo 注册参数
     * @return
     */
    void register(RegisterVo registerVo);

}
