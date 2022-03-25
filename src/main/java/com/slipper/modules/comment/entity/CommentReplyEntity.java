package com.slipper.modules.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章评论回复
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Data
@TableName(value = "comment__reply")
public class CommentReplyEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 内容
     */
    @Length(min = 1, max = 500, message = "内容由1-500位字符组成")
    private String content;
    /**
     * 文章评论ID
     */
    @NotNull(message = "文章评论ID不能为空")
    @JsonProperty("comment_id")
    private Integer commentId;
    /**
     * 回复用户的ID
     */
    @JsonProperty("from_user_id")
    private Integer fromUserId;
    /**
     * 目标用户的ID
     */
    @NotNull(message = "目标用户ID不能为空")
    @JsonProperty("to_user_id")
    private Integer toUserId;
    /**
     * 回复的ID
     */
    @JsonProperty("comment_reply_id")
    private Integer commentReplyId;
    /**
     * 类型 0-回复 1-回复的回复
     */
    @Min(value = 0, message = "请选择正确的类型")
    @Max(value = 1, message = "请选择正确的类型")
    @NotNull(message = "请选择正确的类型")
    private Integer type;
    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private Date createdAt;
    /**
     *
     */
    @TableLogic
    private Integer deleted;
}
