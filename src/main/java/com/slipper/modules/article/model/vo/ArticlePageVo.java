package com.slipper.modules.article.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.common.vo.PageDateVo;
import lombok.Data;

import java.util.List;

/**
 * @author gumingchen
 */
@Data
public class ArticlePageVo extends PageDateVo {
    /**
     * 标题
     */
    private String title;
    /**
     * 分类ID列表
     */
    @JsonProperty("category_ids")
    private List<Integer> categoryIds;
    /**
     * 标签ID列表
     */
    @JsonProperty("tag_ids")
    private List<Integer> tagIds;
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

}
