package com.slipper.modules.comment.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.exception.RunException;
import com.slipper.common.utils.Constant;
import com.slipper.common.utils.Query;
import com.slipper.common.utils.RPage;
import com.slipper.modules.comment.dao.CommentReplyDao;
import com.slipper.modules.comment.entity.CommentEntity;
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
    public RPage<CommentReplyDto> queryPage(CommentReplyPageVo commentReplyPageVo) {
        Page<CommentReplyDto> page = new Query<CommentReplyDto>()
                .getPage(commentReplyPageVo.getCurrent(), commentReplyPageVo.getSize());

        return new RPage<>(
                baseMapper.queryPage(
                        page,
                        commentReplyPageVo.getId()
                )
        );
    }

    @Override
    public void create(CommentReplyEntity commentReplyEntity) {
        commentReplyEntity.setCreatedAt(new Date());
        this.save(commentReplyEntity);
    }

    @Override
    public void delete(Integer id, Integer userId) {
        CommentReplyEntity commentReplyEntity = this.getById(id);
        if (commentReplyEntity == null) {
            throw new RunException(Constant.WARNING_CODE, "该回复不存在!");
        }
        if (!userId.equals(commentReplyEntity.getFromUserId())) {
            throw new RunException(Constant.WARNING_CODE, "只能删除自己的回复!");
        }
        this.removeById(id);
    }

}