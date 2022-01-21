package com.slipper.modules.leaveMessage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slipper.modules.leaveMessage.entity.LeaveMessageReplyEntity;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageReplyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 留言回复
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Mapper
public interface LeaveMessageReplyDao extends BaseMapper<LeaveMessageReplyEntity> {
    /**
     * 分页
     * @param page 分页参数
     * @param id 留言ID
     * @return
     */
    IPage<LeaveMessageReplyDto> queryPage(Page<LeaveMessageReplyDto> page, @Param("id") int id);
}
