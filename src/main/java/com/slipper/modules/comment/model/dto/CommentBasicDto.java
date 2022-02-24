package com.slipper.modules.comment.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gumingchen
 */
@Data
public class CommentBasicDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 内容
     */
    private String content;
    /**
     * 文章ID
     */
    @JsonProperty("article_id")
    private Integer articleId;
    /**
     * 文章标题
     */
    @JsonProperty("article_title")
    private String articleTitle;
    /**
     * 用户ID
     */
    @JsonProperty("user_id")
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private Date createdAt;

}
