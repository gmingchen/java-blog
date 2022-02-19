package com.slipper.modules.article.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.common.validator.group.Create;
import com.slipper.common.validator.group.Update;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.List;

/**
 * @author gumingchen
 */
@Data
public class ArticleVo {

    @NotNull(message = "ID不能为空", groups = Update.class)
    private Integer id;
    /**
     * 标题
     */
    @Length(min = 1, max = 20, message = "标题由1-20位字符组成", groups = {Create.class, Update.class})
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
    @Length(min = 1, max = 100, message = "描述由1-100位字符组成", groups = {Create.class, Update.class})
    private String describe;
    /**
     * 分类ID
     */
    @NotNull(message = "分类ID不能为空", groups = {Create.class, Update.class})
    @JsonProperty("category_id")
    private Integer categoryId;
    /**
     * 标签列表
     */
    @Size(min = 1, message = "标签不能为空", groups = {Create.class, Update.class})
    private List<Integer> tags;
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
}
