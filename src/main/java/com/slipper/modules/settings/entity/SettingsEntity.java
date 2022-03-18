package com.slipper.modules.settings.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 系统设置
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Data
@TableName(value = "settings")
public class SettingsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

//    @NotNull(message = "ID不能为空")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    @Length(min = 1, max = 20, message = "名称由1-20位字符组成")
    private String name;
    /**
     * 头像
     */
    @NotBlank(message = "头像不能为空")
    private String avatar;
    /**
     * 签名
     */
    @Length(min = 1, max = 100, message = "签名由1-100位字符组成")
    private String signature;
    /**
     * 地址
     */
    @NotBlank(message = "地址不能为空")
    private String address;
    /**
     * QQ
     */
    @NotBlank(message = "QQ不能为空")
    private String qq;
    /**
     * Wechat
     */
    @NotBlank(message = "Wechat不能为空")
    private String wechat;
    /**
     * github
     */
    @NotBlank(message = "Github不能为空")
    private String github;
    /**
     * 微信公众号图片
     */
    @JsonProperty("official_account")
    private String officialAccount;
    /**
     * 微信群图片
     */
    @JsonProperty("wechat_group")
    private String wechatGroup;
    /**
     * QQ群图片
     */
    @JsonProperty("qq_group")
    private String qqGroup;
    /**
     * Logo
     */
    @NotBlank(message = "Logo不能为空")
    private String logo;
    /**
     * 网站标题
     */
    @NotBlank(message = "网站标题不能为空")
    private String title;
    /**
     * 网站备案号
     */
    @JsonProperty("record_number")
    @NotBlank(message = "网站备案号不能为空")
    private String recordNumber;
    /**
     * 备案号跳转链接
     */
    @JsonProperty("record_number_link")
    @NotBlank(message = "备案号跳转链接不能为空")
    private String recordNumberLink;
    /**
     * 站点链接
     */
    @NotBlank(message = "站点链接不能为空")
    private String link;
    /**
     * 站点描述
     */
    @TableField("`describe`")
    private String describe;
    /**
     * 邮箱
     */
    private String email;
}
