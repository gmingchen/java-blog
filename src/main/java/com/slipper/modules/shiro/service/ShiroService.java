package com.slipper.modules.shiro.service;


import com.slipper.modules.user.model.dto.UserBasicDto;

import java.util.Set;

/**
 * 菜单
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface ShiroService {

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    UserBasicDto queryUserById(int id);

}

