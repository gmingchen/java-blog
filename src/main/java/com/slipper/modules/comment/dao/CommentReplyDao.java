package com.slipper.modules.comment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slipper.modules.comment.entity.CommentReplyEntity;
import com.slipper.modules.comment.model.dto.CommentReplyDto;
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
public interface CommentReplyDao extends BaseMapper<CommentReplyEntity> {
    /**
     * 分页
     * @param page 分页参数
     * @param id 留言ID
     * @return
     */
    IPage<CommentReplyDto> queryPage(Page<CommentReplyDto> page, @Param("id") int id);
}
