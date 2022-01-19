package com.slipper.modules.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slipper.modules.user.entity.UserEntity;
import com.slipper.modules.user.model.dto.UserBasicDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    /**
     * 分页查询基础用户信息
     * @param page
     * @param name
     * @return
     */
    IPage<UserBasicDto> queryPage(Page<UserBasicDto> page, @Param("name") String name);

//    IPage<AdminDto> queryAllPage(Page<AdminDto> page, @Param("username") String username, @Param("nickname") String nickname);
//
//    IPage<AdminDto> queryByCreatorPage(Page<AdminDto> page, @Param("creator") Long creator, @Param("username") String username, @Param("nickname") String nickname);
//
//    AdminDto queryById (@Param("id") Long id);
//
//    AdminDto queryByUsername (@Param("username") String username);
	
}
