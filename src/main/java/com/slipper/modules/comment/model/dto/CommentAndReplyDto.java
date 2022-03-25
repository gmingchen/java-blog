package com.slipper.modules.comment.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author gumingchen
 */
@Data
public class CommentAndReplyDto implements Serializable {
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
     * 用户ID
     */
    @JsonProperty("user_id")
    private Integer userId;
    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private Date createdAt;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别：0-女 1-男 2-保密
     */
    private Integer sex;
    /**
     * 是否是作者 0-否 1-是
     */
    private Integer author;
    /**
     * 回复消息列表
     */
    private List<CommentReplyDto> replies;
}
