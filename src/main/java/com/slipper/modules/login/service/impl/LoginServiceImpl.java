package com.slipper.modules.login.service.impl;

import com.slipper.common.exception.RunException;
import com.slipper.common.utils.Constant;
import com.slipper.common.utils.JwtUtils;
import com.slipper.modules.login.model.vo.LoginVo;
import com.slipper.modules.login.model.vo.RegisterVo;
import com.slipper.modules.login.service.LoginService;
import com.slipper.modules.user.entity.UserEntity;
import com.slipper.modules.user.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 登录
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserService userService;
    @Resource
    private JwtUtils jwt;

    @Override
    public String login(LoginVo loginVo) {
        UserEntity user = userService.queryInfoByUsername(loginVo.getUsername());

        if (user == null) {
            throw new RunException(Constant.WARNING_CODE, "账户不存在！");
        }
        if (user.getStatus() == 0) {
            throw new RunException(Constant.WARNING_CODE, "账户已被冻结！");
        }
        if (!user.getPassword().equals(new Sha256Hash(loginVo.getPassword(), user.getSalt()).toHex())) {
            throw new RunException(Constant.WARNING_CODE, "密码不正确！");
        }

        return jwt.generate(user.getId());
    }

    @Override
    public void register(RegisterVo registerVo) {
        UserEntity user = userService.queryInfoByUsername(registerVo.getUsername());

        if (user != null) {
            throw new RunException(Constant.WARNING_CODE, "该账户已存在，请重新注册！");
        }

        String salt = RandomStringUtils.randomAlphanumeric(20);
        String password = new Sha256Hash(registerVo.getPassword(), salt).toHex();
        user.setUsername(registerVo.getUsername());
        user.setPassword(password);
        user.setSalt(salt);
        user.setCreatedAt(new Date());

        userService.save(user);
    }

}
