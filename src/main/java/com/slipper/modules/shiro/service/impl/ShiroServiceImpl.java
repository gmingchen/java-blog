package com.slipper.modules.shiro.service.impl;

import com.slipper.modules.shiro.service.ShiroService;
import com.slipper.modules.user.model.dto.UserBasicDto;
import com.slipper.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * shiro
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {

    @Resource
    UserService userService;

    @Override
    public UserBasicDto queryUserById(int id) {
        return userService.queryInfo(id);
    }
}