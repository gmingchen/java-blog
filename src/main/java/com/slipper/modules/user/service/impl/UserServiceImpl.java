package com.slipper.modules.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.utils.Query;
import com.slipper.common.utils.RPage;
import com.slipper.modules.user.dao.UserDao;
import com.slipper.modules.user.entity.UserEntity;
import com.slipper.modules.user.model.dto.UserBasicDto;
import com.slipper.modules.user.model.vo.UserPageVo;
import com.slipper.modules.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public RPage<UserBasicDto> queryPage(UserPageVo userPageVo) {
        Page<UserBasicDto> page = new Query<UserBasicDto>().getPage(userPageVo.getCurrent(), userPageVo.getSize());
        return new RPage<>(baseMapper.queryPage(page, userPageVo.getName()));
    }
}