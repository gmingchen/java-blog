package com.slipper.modules.dashboard.model.dto;

import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class QuantityStatisticsDto {
    /**
     * 文章数量
     */
    private Long article;
    /**
     * 文章发布数量
     */
    private Long release;
    /**
     * 评论数量
     */
    private Long comment;
    /**
     * 点赞数量
     */
    private Long praise;
    /**
     * 阅读数量
     */
    private Long read;
    /**
     * 留言数量
     */
    private Long message;
}
