package com.slipper.modules.article.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.common.vo.PageVo;
import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class ArticleSearchVo extends PageVo {
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 分类ID
     */
    private Integer category;
}
