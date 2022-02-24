package com.slipper.modules.article.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slipper.modules.article.entity.ArticleEntity;
import com.slipper.modules.article.model.dto.ArticleBasicDto;
import com.slipper.modules.article.model.dto.ArticleDto;
import com.slipper.modules.user.model.dto.UserBasicDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Mapper
public interface ArticleDao extends BaseMapper<ArticleEntity> {

    /**
     * 分页
     * @param page 分页参数
     * @param start 开始时间
     * @param end 结束时间
     * @param title 标题
     * @param categoryIds 分类ID列表
     * @param tagIds 标签ID列表
     * @param recommended 是否推荐：0-否 1-是
     * @param commentable 否可以评论：0-否 1-是
     * @param published 是否发布：0-否 1-是
     * @return
     */
    IPage<ArticleDto> queryPage(
            Page<ArticleDto> page,
            @Param("start") String start,
            @Param("end") String end,
            @Param("title") String title,
            @Param("categoryIds") List categoryIds,
            @Param("tagIds") List tagIds,
            @Param("recommended") Integer recommended,
            @Param("commentable") Integer commentable,
            @Param("published") Integer published
    );

    /**
     * 信息
     * @param id ID
     * @return
     */
    ArticleDto queryInfo(@Param("id") int id);

    /**
     * 获取最近发布的文章
     * @param limit 数量
     * @return
     */
    List<ArticleBasicDto> queryLatest(@Param("limit") int limit);
}
