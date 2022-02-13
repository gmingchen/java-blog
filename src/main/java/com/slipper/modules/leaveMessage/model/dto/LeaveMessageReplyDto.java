package com.slipper.modules.leaveMessage.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

/**
 * @author gumingchen
 */
@Data
public class LeaveMessageReplyDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 内容
     */
    private String content;
    /**
     * 留言ID
     */
    @JsonProperty("leave_message_id")
    private Integer leaveMessageId;
    /**
     * 回复的ID
     */
    @JsonProperty("leave_message_reply_id")
    private Integer leaveMessageReplyId;
    /**
     * 类型 0-回复 1-回复的回复
     */
    private Integer type;
    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private Date createdAt;
    /**
     * 回复用户的ID
     */
    @JsonProperty("from_user_id")
    private Integer fromUserId;
    /**
     * 回复用户的用户名
     */
    @JsonProperty("from_username")
    private String fromUsername;
    /**
     * 回复用户的昵称
     */
    @JsonProperty("from_nickname")
    private String fromNickname;
    /**
     * 回复用户的头像
     */
    @JsonProperty("from_avatar")
    private String fromAvatar;
    /**
     * 回复用户的性别：0-女 1-男 2-保密
     */
    @JsonProperty("from_sex")
    private Integer fromSex;
    /**
     * 目标用户的ID
     */
    @JsonProperty("to_user_id")
    private Integer toUserId;
    /**
     * 目标用户的用户名
     */
    @JsonProperty("to_username")
    private String toUsername;
    /**
     * 目标用户的昵称
     */
    @JsonProperty("to_nickname")
    private String toNickname;
    /**
     * 目标用户的头像
     */
    @JsonProperty("to_avatar")
    private String toAvatar;
    /**
     * 目标用户的性别：0-女 1-男 2-保密
     */
    @JsonProperty("to_sex")
    private Integer toSex;
}
