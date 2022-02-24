package com.slipper.modules.leaveMessage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.utils.RPage;
import com.slipper.modules.leaveMessage.entity.LeaveMessageEntity;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageBasicDto;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageDto;
import com.slipper.modules.leaveMessage.model.vo.LeaveMessagePageVo;

import java.util.List;

/**
 * 留言
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface LeaveMessageService extends IService<LeaveMessageEntity> {

    /**
     * 分页
     * @param leaveMessagePageVo 分页参数
     * @return
     */
    RPage<LeaveMessageDto> queryPage(LeaveMessagePageVo leaveMessagePageVo);

    /**
     * 获取最近收到的留言
     * @param limit 数量
     * @return
     */
    List<LeaveMessageBasicDto> queryLatest(int limit);

}

