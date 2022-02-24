package com.slipper.modules.leaveMessage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slipper.modules.comment.model.dto.CommentBasicDto;
import com.slipper.modules.leaveMessage.entity.LeaveMessageEntity;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageBasicDto;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 留言
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Mapper
public interface LeaveMessageDao extends BaseMapper<LeaveMessageEntity> {
    /**
     * 分页
     * @param page 分页参数
     * @param start 开始时间
     * @param end 结束时间
     * @param name 用户名 / 昵称
     * @return
     */
    IPage<LeaveMessageDto> queryPage(Page<LeaveMessageDto> page, @Param("start") String start, @Param("end") String end, @Param("name") String name);

    /**
     * 获取最近收到的留言
     * @param limit 数量
     * @return
     */
    List<LeaveMessageBasicDto> queryLatest(@Param("limit") int limit);
}
