package com.slipper.modules.article.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.common.validator.group.Create;
import com.slipper.common.validator.group.Update;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Data
@TableName(value = "article")
public class ArticleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ID不能为空", groups = Update.class)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标题
     */
    @Length(min = 1, max = 50, message = "标题由1-50位字符组成", groups = {Create.class, Update.class})
    private String title;
    /**
     * 文章内容类型 1-markdown 2-富文本
     */
    @Min(value = 1, message = "请选择正确的类型", groups = {Create.class, Update.class})
    @Max(value = 2, message = "请选择正确的类型", groups = {Create.class, Update.class})
    private Integer type;
    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空", groups = {Create.class, Update.class})
    private String content;
    /**
     * 简介描述
     */
    @Length(min = 1, max = 200, message = "描述由1-200位字符组成", groups = {Create.class, Update.class})
    @TableField("`describe`")
    private String describe;
    /**
     * 分类ID
     */
    @NotNull(message = "分类ID不能为空", groups = {Create.class, Update.class})
    @JsonProperty("category_id")
    private Integer categoryId;
    /**
     * 封面图
     */
    private String cover;
    /**
     * 是否推荐：0-否 1-是
     */
    private Integer recommended;
    /**
     * 是否可以评论：0-否 1-是
     */
    private Integer commentable;
    /**
     * 是否发布：0-否 1-是
     */
    private Integer published;
    /**
     * 阅读量
     */
    private Long read;
    /**
     * 发布时间
     */
    @JsonProperty("published_at")
    private Date publishedAt;
    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private Date createdAt;
    /**
     * 更新时间
     */
    @JsonProperty("updated_at")
    private Date updatedAt;
    /**
     *
     */
    @TableLogic
    private Integer deleted;
}
