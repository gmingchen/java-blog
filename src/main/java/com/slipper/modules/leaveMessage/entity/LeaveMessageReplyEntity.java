package com.slipper.modules.leaveMessage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.common.validator.group.Create;
import com.slipper.common.validator.group.Update;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;

/**
 * 留言回复
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Data
@TableName(value = "leave_message__reply")
public class LeaveMessageReplyEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ID不能为空")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 内容
     */
    @Length(min = 1, max = 200, message = "内容由1-200位字符组成")
    private String content;
    /**
     * 留言ID
     */
    @NotNull(message = "留言ID不能为空")
    @JsonProperty("leave_message_id")
    private Integer leaveMessageId;
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
    @JsonProperty("leave_message_reply_id")
    private Integer leaveMessageReplyId;
    /**
     * 类型 0-回复 1-回复的回复
     */
    @Min(value = 0, message = "请选择正确的类型")
    @Max(value = 1, message = "请选择正确的类型")
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
