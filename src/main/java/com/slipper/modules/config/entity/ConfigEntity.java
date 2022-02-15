package com.slipper.modules.config.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.common.utils.Regular;
import com.slipper.common.validator.group.Create;
import com.slipper.common.validator.group.Update;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 配置
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Data
@TableName(value = "config")
public class ConfigEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 键值
     */
    @JsonProperty("json_key")
    private String jsonKey;
    /**
     * 值-json字符串
     */
    @JsonProperty("json_value")
    private String jsonValue;
    /**
     * 状态 0：禁用 1：正常
     */
    private Integer status;
    /**
     * 状态：1-本地 2-七牛云
     */
    private Integer type;
    /**
     * 备注
     */
    private String remark;
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
}
