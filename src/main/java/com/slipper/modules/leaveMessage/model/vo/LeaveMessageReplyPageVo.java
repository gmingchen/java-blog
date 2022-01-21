package com.slipper.modules.leaveMessage.model.vo;

import com.slipper.common.vo.PageDateVo;
import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class LeaveMessageReplyPageVo extends PageDateVo {
    /**
     * 留言ID
     */
    private Integer id;
}
