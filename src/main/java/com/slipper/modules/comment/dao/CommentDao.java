package com.slipper.modules.comment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slipper.modules.comment.entity.CommentEntity;
import com.slipper.modules.comment.model.dto.CommentBasicDto;
import com.slipper.modules.comment.model.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章评论
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Mapper
public interface CommentDao extends BaseMapper<CommentEntity> {
    /**
     * 分页
     * @param page 分页参数
     * @param id 文章ID
     * @param start 开始时间
     * @param end 结束时间
     * @param name 用户名 / 昵称
     * @return
     */
    IPage<CommentDto> queryPage(Page<CommentDto> page,
                                @Param("id") Integer id,
                                @Param("start") String start,
                                @Param("end") String end,
                                @Param("name") String name);

    /**
     * 获取最近收到的文章评论
     * @param limit 数量
     * @return
     */
    List<CommentBasicDto> queryLatest(@Param("limit") int limit);
}
