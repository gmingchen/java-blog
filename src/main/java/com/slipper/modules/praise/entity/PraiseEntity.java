package com.slipper.modules.praise.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.common.validator.group.Create;
import com.slipper.common.validator.group.Update;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章点赞
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Data
@TableName(value = "praise")
public class PraiseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ID不能为空", groups = Update.class)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 文章ID
     */
    @JsonProperty("article_id")
    @NotNull(message = "文章ID不能为空", groups = Update.class)
    private Integer articleId;
    /**
     * 用户ID
     */
    @JsonProperty("user_id")
    @NotNull(message = "用户ID不能为空", groups = Update.class)
    private Integer userId;
    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private Date createdAt;
}
