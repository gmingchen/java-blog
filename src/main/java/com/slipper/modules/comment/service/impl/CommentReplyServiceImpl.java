package com.slipper.modules.comment.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.utils.Query;
import com.slipper.common.utils.RPage;
import com.slipper.modules.comment.dao.CommentReplyDao;
import com.slipper.modules.comment.entity.CommentReplyEntity;
import com.slipper.modules.comment.model.dto.CommentReplyDto;
import com.slipper.modules.comment.model.vo.CommentReplyPageVo;
import com.slipper.modules.comment.service.CommentReplyService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author gumingchen
 */
@Service("commentReplyService")
public class CommentReplyServiceImpl extends ServiceImpl<CommentReplyDao, CommentReplyEntity> implements CommentReplyService {

    @Override
    public RPage<CommentReplyDto> queryPage(CommentReplyPageVo leaveMessageReplyPageVo) {
        Page<CommentReplyDto> page = new Query<CommentReplyDto>()
                .getPage(leaveMessageReplyPageVo.getCurrent(), leaveMessageReplyPageVo.getSize());

        return new RPage<>(
                baseMapper.queryPage(
                        page,
                        leaveMessageReplyPageVo.getId()
                )
        );
    }

    @Override
    public void create(CommentReplyEntity leaveMessageReplyEntity) {
        leaveMessageReplyEntity.setCreatedAt(new Date());
        this.save(leaveMessageReplyEntity);
    }

}