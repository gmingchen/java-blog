package com.slipper.modules.article.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.modules.tag.model.dto.TagDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author gumingchen
 */
@Data
public class ArticleDto {

    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 文章内容类型 1-markdown 2-富文本
     */
    private Integer type;
    /**
     * 内容
     */
    private String content;
    /**
     * 简介描述
     */
    private String describe;
    /**
     * 封面图
     */
    private String cover;
    /**
     * 分类ID
     */
    @JsonProperty("category_id")
    private Integer categoryId;
    /**
     * 分类名称
     */
    @JsonProperty("category_name")
    private String categoryName;
    /**
     * 标签列表
     */
    private List<TagDto> tags;
    /**
     * 点赞数量
     */
    private Long praise;
    /**
     * 评论数量
     */
    private Long comment;
    /**
     * 阅读量
     */
    private Long read;
    /**
     * 是否推荐：0-否 1-是
     */
    private Integer recommended;
    /**
     * 是否可以评论：0-否 1-是
     */
    private Integer commentable;
    /**
     * 是否发布：0-否 1-是
     */
    private Integer published;
    /**
     * 发布时间
     */
    @JsonProperty("published_at")
    private Date publishedAt;
    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private Date createdAt;
    /**
     * 更新时间
     */
    @JsonProperty("updated_at")
    private Date updatedAt;
}
