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
     * 分页查询用户基础信息
     * @param page 分页参数
     * @param start 开始时间
     * @param end 结束时间
     * @param name 用户名 / 昵称
     * @return
     */
    IPage<UserBasicDto> queryPage(Page<UserBasicDto> page, @Param("start") String start, @Param("end") String end, @Param("name") String name);

    /**
     * 查询用户基础信息
     * @param id 用户ID
     * @return
     */
    UserBasicDto queryInfo(@Param("id") int id);
	
}
