package com.slipper.modules.log.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author gumingchen
 */
@Data
public class LogBasicDto {

    private Integer id;
    /**
     * 操作
     */
    private String operation;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 用户ID
     */
    @JsonProperty("user_id")
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private Date createdAt;
}
