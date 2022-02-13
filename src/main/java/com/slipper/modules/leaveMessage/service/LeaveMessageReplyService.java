package com.slipper.modules.leaveMessage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.utils.RPage;
import com.slipper.modules.leaveMessage.entity.LeaveMessageEntity;
import com.slipper.modules.leaveMessage.entity.LeaveMessageReplyEntity;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageDto;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageReplyDto;
import com.slipper.modules.leaveMessage.model.vo.LeaveMessagePageVo;
import com.slipper.modules.leaveMessage.model.vo.LeaveMessageReplyPageVo;

/**
 * 留言回复
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface LeaveMessageReplyService extends IService<LeaveMessageReplyEntity> {

    /**
     * 分页
     * @param leaveMessagePageVo 分页参数
     * @return
     */
    RPage<LeaveMessageReplyDto> queryPage(LeaveMessageReplyPageVo leaveMessagePageVo);

    /**
     * 留言回复
     * @param leaveMessageReplyEntity 留言回复
     */
    void create(LeaveMessageReplyEntity leaveMessageReplyEntity);

}

