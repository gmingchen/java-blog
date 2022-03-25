package com.slipper.modules.comment.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.common.vo.PageDateVo;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author gumingchen
 */
@Data
public class CommentVo {
    /**
     * 内容
     */
    @Length(min = 1, max = 500, message = "内容由1-500位字符组成")
    private String content;
    /**
     * 文章ID
     */
    @JsonProperty("article_id")
    private Integer articleId;
    /**
     * 用户ID
     */
    @JsonProperty("user_id")
    private Integer userId;
}
