package com.slipper.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.core.common.utils.RPage;
import com.slipper.core.modules.user.model.dto.UserBasicDto;
import com.slipper.core.modules.user.entity.UserEntity;
import com.slipper.core.modules.user.model.vo.UserPageVo;

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

}

