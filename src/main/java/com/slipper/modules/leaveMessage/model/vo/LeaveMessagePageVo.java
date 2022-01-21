package com.slipper.modules.leaveMessage.model.vo;

import com.slipper.common.vo.PageDateVo;
import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class LeaveMessagePageVo extends PageDateVo {
    /**
     * 用户名 / 昵称
     */
    private String name;
}
