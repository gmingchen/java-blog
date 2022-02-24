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
public class ArticleBasicDto {

    private Integer id;
    /**
     * 标题
     */
    private String title;
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
