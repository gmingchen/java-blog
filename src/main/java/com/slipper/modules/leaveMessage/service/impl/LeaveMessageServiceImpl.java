package com.slipper.modules.leaveMessage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.utils.Query;
import com.slipper.common.utils.RPage;
import com.slipper.modules.leaveMessage.dao.LeaveMessageDao;
import com.slipper.modules.leaveMessage.entity.LeaveMessageEntity;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageBasicDto;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageDto;
import com.slipper.modules.leaveMessage.model.vo.LeaveMessagePageVo;
import com.slipper.modules.leaveMessage.service.LeaveMessageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gumingchen
 */
@Service("leaveMessageService")
public class LeaveMessageServiceImpl extends ServiceImpl<LeaveMessageDao, LeaveMessageEntity> implements LeaveMessageService {

    @Override
    public RPage<LeaveMessageDto> queryPage(LeaveMessagePageVo leaveMessagePageVo) {
        Page<LeaveMessageDto> page = new Query<LeaveMessageDto>()
                .getPage(leaveMessagePageVo.getCurrent(), leaveMessagePageVo.getSize());

        return new RPage<>(
                baseMapper.queryPage(
                        page,
                        leaveMessagePageVo.getStart(),
                        leaveMessagePageVo.getEnd(),
                        leaveMessagePageVo.getName()
                )
        );
    }

    @Override
    public List<LeaveMessageBasicDto> queryLatest(int limit) {
        return baseMapper.queryLatest(limit);
    }

}