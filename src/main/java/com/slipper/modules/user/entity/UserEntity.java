package com.slipper.modules.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.common.utils.Regular;
import com.slipper.common.validator.group.Create;
import com.slipper.common.validator.group.Update;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Data
@TableName(value = "user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ID不能为空", groups = Update.class)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空", groups = {Create.class, Update.class})
    @Pattern(regexp = Regular.USERNAME, message = "用户名由6-12位数字、字母、下横线、中横线组成")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空", groups = {Create.class})
    @Pattern(regexp = Regular.PASSWORD, message = "密码由8-12位数字、字母、下横线、中横线组成")
    private String password;
    /**
     * 盐
     */
    private String salt;
    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空", groups = {Create.class, Update.class})
    private String nickname;
    /**
     * 性别：0-女 1-男 2-保密
     */
    @Min(value = 0, message = "请选择正确的性别")
    @Max(value = 2, message = "请选择正确的性别")
    private Integer sex;
    /**
     * 头像
     */
    @NotBlank(message = "昵称不能为空", groups = {Create.class, Update.class})
    private String avatar;
    /**
     * 手机
     */
    @Pattern(regexp = Regular.MOBILE, message = "请输入正确的手机号")
    private String mobile;
    /**
     * 是否是作者 0-否 1-是
     */
    private Integer author;
    /**
     * 状态 0：禁用 1：正常
     */
    private Integer status;
    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private Date createdAt;
}
