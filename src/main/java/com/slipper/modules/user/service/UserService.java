package com.slipper.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.utils.RPage;
import com.slipper.modules.user.entity.UserEntity;
import com.slipper.modules.user.model.dto.UserBasicDto;
import com.slipper.modules.user.model.vo.UserPageVo;

/**
 * 用户
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 查询系统管理员
     * @param userPageVo 分页参数
     * @return
     */
    RPage<UserBasicDto> queryPage(UserPageVo userPageVo);

    /**
     * 查询用户基础信息
     * @param id 用户ID
     * @return
     */
    UserBasicDto queryInfo(int id);

    /**
     * 用户名查询用户信息
     * @param username 用户名
     * @return
     */
    UserEntity queryInfoByUsername(String username);

}

