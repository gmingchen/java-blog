package com.slipper.modules.login.model.vo;

import com.slipper.common.utils.Regular;
import com.slipper.common.validator.group.Create;
import com.slipper.common.validator.group.Update;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author gumingchen
 */
@Data
public class LoginVo {
    /**
     * 帐号
     */
    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = Regular.USERNAME, message = "用户名由6-12位数字、字母、下横线、中横线组成")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = Regular.PASSWORD, message = "密码由8-12位数字、字母、下横线、中横线组成")
    private String password;
}
