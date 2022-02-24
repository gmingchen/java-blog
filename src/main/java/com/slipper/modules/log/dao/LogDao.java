package com.slipper.modules.log.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageBasicDto;
import com.slipper.modules.log.entity.LogEntity;
import com.slipper.modules.log.model.dto.LogBasicDto;
import com.slipper.modules.log.model.dto.LogDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 日志
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Mapper
public interface LogDao extends BaseMapper<LogEntity> {

    /**
     * 分页
     * @param page 分页参数
     * @param start 开始时间
     * @param end 结束时间
     * @param name 用户名 / 昵称
     * @param ip ip地址
     * @param operation 操作
     * @return
     */
    IPage<LogDto> queryPage(
            Page<LogDto> page,
            @Param("start") String start,
            @Param("end") String end,
            @Param("name") String name,
            @Param("ip") String ip,
            @Param("operation") String operation);


    /**
     * 清空日志
     */
    void truncate ();

    /**
     * 获取最近操作日志
     * @param limit 数量
     * @return
     */
    List<LogBasicDto> queryLatest(@Param("limit") int limit);
	
}
