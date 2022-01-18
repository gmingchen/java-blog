package com.slipper.modules.user.model.vo;

import com.slipper.core.common.vo.DateVo;
import com.slipper.core.common.vo.PageVo;
import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class UserPageVo extends PageVo{
    /**
     * 用户名 / 昵称
     */
    private String name;
}
