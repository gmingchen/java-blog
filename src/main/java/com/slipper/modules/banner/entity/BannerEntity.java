package com.slipper.modules.banner.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.common.validator.group.Create;
import com.slipper.common.validator.group.Update;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 轮播图
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Data
@TableName(value = "banner")
public class BannerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ID不能为空", groups = Update.class)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标题
     */
    @Length(min = 1, max = 20, message = "标题由1-20位字符组成", groups = {Create.class, Update.class})
    private String title;
    /**
     * 图片
     */
    @NotBlank(message = "图片不能为空", groups = {Create.class, Update.class})
    private String image;
    /**
     * 水印图片
     */
    @NotBlank(message = "水印图片不能为空", groups = {Create.class, Update.class})
    private String watermark;
    /**
     * 跳转路径
     */
    private String url;
    /**
     * 类型 0-http 1-路由
     */
    @Min(value = 0, message = "请选择正确的类型", groups = {Create.class, Update.class})
    @Max(value = 1, message = "请选择正确的类型", groups = {Create.class, Update.class})
    private Integer type;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态 0-禁用 1-启用
     */
    @Min(value = 0, message = "请选择正确的状态", groups = {Create.class, Update.class})
    @Max(value = 1, message = "请选择正确的状态", groups = {Create.class, Update.class})
    private Integer status;
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
