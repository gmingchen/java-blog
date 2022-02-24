package com.slipper.modules.log.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志信息
 * @author gumingchen
 */
@Data
public class LogDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 操作
     */
    private String operation;
    /**
     * 请求URL
     */
    private String url;
    /**
     * 请求方式
     */
    private String method;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 类名和方法名
     */
    @JsonProperty("class_name")
    private String className;
    /**
     * 执行时长
     */
    private Long times;
    /**
     * ip地址
     */
    private String ip;
    /**
     * 用户代理
     */
    private String agent;
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
