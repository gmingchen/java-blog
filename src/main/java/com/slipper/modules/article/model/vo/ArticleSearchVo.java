package com.slipper.modules.article.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.common.vo.PageDateVo;
import lombok.Data;

import java.util.List;

/**
 * @author gumingchen
 */
@Data
public class ArticleSearchVo extends PageDateVo {
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 分类ID
     */
    @JsonProperty("category_id")
    private Integer categoryId;
}
