package com.slipper.modules.comment.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.utils.Query;
import com.slipper.common.utils.RPage;
import com.slipper.modules.comment.dao.CommentDao;
import com.slipper.modules.comment.entity.CommentEntity;
import com.slipper.modules.comment.model.dto.CommentBasicDto;
import com.slipper.modules.comment.model.dto.CommentDto;
import com.slipper.modules.comment.model.vo.CommentPageVo;
import com.slipper.modules.comment.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gumingchen
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, CommentEntity> implements CommentService {

    @Override
    public RPage<CommentDto> queryPage(CommentPageVo commentPageVo) {
        Page<CommentDto> page = new Query<CommentDto>()
                .getPage(commentPageVo.getCurrent(), commentPageVo.getSize());

        return new RPage<>(
                baseMapper.queryPage(
                        page,
                        commentPageVo.getId(),
                        commentPageVo.getStart(),
                        commentPageVo.getEnd(),
                        commentPageVo.getName()
                )
        );
    }

    @Override
    public List<CommentBasicDto> queryLatest(int limit) {
        return baseMapper.queryLatest(limit);
    }

}