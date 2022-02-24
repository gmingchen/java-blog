package com.slipper.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.utils.Query;
import com.slipper.common.utils.RPage;
import com.slipper.modules.user.dao.UserDao;
import com.slipper.modules.user.entity.UserEntity;
import com.slipper.modules.user.model.dto.UserBasicDto;
import com.slipper.modules.user.model.dto.UserStatisticsDto;
import com.slipper.modules.user.model.vo.UserPageVo;
import com.slipper.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gumingchen
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public RPage<UserBasicDto> queryPage(UserPageVo userPageVo) {
        Page<UserBasicDto> page = new Query<UserBasicDto>().getPage(userPageVo.getCurrent(), userPageVo.getSize());
        return new RPage<>(
                baseMapper.queryPage(
                        page,
                        userPageVo.getStart(),
                        userPageVo.getEnd(),
                        userPageVo.getName()
                )
        );
    }

    @Override
    public UserBasicDto queryInfo(int id) {
        return baseMapper.queryInfo(id);
    }

    @Override
    public UserEntity queryInfoByUsername(String username) {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<UserEntity>()
                .eq(UserEntity::getUsername, username);
        return this.getOne(wrapper);
    }

    @Override
    public List<UserStatisticsDto> queryUserStatistics(int day) {
        return baseMapper.queryUserStatistics(day);
    }
}