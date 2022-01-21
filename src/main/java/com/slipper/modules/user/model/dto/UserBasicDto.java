package com.slipper.modules.user.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户基础信息
 * @author gumingchen
 */
@Data
public class UserBasicDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别：0-女 1-男 0-保密
     */
    private Integer sex;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 手机
     */
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
