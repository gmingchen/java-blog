package com.slipper.modules.leaveMessage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 留言
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Data
@TableName(value = "leave_message")
public class LeaveMessageEntity implements Serializable {
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
     *
     */
    @TableLogic
    private Integer deleted;
}
