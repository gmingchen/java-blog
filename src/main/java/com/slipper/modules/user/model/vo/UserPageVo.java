package com.slipper.modules.user.model.vo;

import com.slipper.common.vo.PageDateVo;
import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class UserPageVo extends PageDateVo {
    /**
     * 用户名 / 昵称
     */
    private String name;
}
