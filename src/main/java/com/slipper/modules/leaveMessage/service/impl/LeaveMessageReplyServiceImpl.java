package com.slipper.modules.leaveMessage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.utils.Query;
import com.slipper.common.utils.RPage;
import com.slipper.modules.leaveMessage.dao.LeaveMessageReplyDao;
import com.slipper.modules.leaveMessage.entity.LeaveMessageReplyEntity;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageDto;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageReplyDto;
import com.slipper.modules.leaveMessage.model.vo.LeaveMessagePageVo;
import com.slipper.modules.leaveMessage.model.vo.LeaveMessageReplyPageVo;
import com.slipper.modules.leaveMessage.service.LeaveMessageReplyService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author gumingchen
 */
@Service("leaveMessageReplyService")
public class LeaveMessageReplyServiceImpl extends ServiceImpl<LeaveMessageReplyDao, LeaveMessageReplyEntity> implements LeaveMessageReplyService {

    @Override
    public RPage<LeaveMessageReplyDto> queryPage(LeaveMessageReplyPageVo leaveMessageReplyPageVo) {
        Page<LeaveMessageReplyDto> page = new Query<LeaveMessageReplyDto>()
                .getPage(leaveMessageReplyPageVo.getCurrent(), leaveMessageReplyPageVo.getSize());

        return new RPage<>(
                baseMapper.queryPage(
                        page,
                        leaveMessageReplyPageVo.getId()
                )
        );
    }

    @Override
    public void create(LeaveMessageReplyEntity leaveMessageReplyEntity) {
        leaveMessageReplyEntity.setCreatedAt(new Date());
        this.save(leaveMessageReplyEntity);
    }

}