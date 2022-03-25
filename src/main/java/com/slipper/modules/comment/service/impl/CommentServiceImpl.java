package com.slipper.modules.comment.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.exception.RunException;
import com.slipper.common.utils.Constant;
import com.slipper.common.utils.Query;
import com.slipper.common.utils.RPage;
import com.slipper.modules.article.entity.ArticleEntity;
import com.slipper.modules.article.service.ArticleService;
import com.slipper.modules.comment.dao.CommentDao;
import com.slipper.modules.comment.entity.CommentEntity;
import com.slipper.modules.comment.model.dto.CommentAndReplyDto;
import com.slipper.modules.comment.model.dto.CommentBasicDto;
import com.slipper.modules.comment.model.dto.CommentDto;
import com.slipper.modules.comment.model.vo.CommentPageVo;
import com.slipper.modules.comment.model.vo.CommentVo;
import com.slipper.modules.comment.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author gumingchen
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, CommentEntity> implements CommentService {

    @Resource
    private ArticleService articleService;

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

    @Override
    public void create(CommentVo commentVo) {
        ArticleEntity articleEntity = articleService.getById(commentVo.getArticleId());
        if (articleEntity == null) {
            throw new RunException(Constant.WARNING_CODE, "该文章不存在!");
        }
        if (articleEntity.getCommentable() != 1) {
            throw new RunException(Constant.WARNING_CODE, "该文章未开启评论功能!");
        }
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setContent(commentVo.getContent());
        commentEntity.setArticleId(commentVo.getArticleId());
        commentEntity.setUserId(commentVo.getUserId());
        commentEntity.setCreatedAt(new Date());
        this.save(commentEntity);
    }

    @Override
    public RPage<CommentAndReplyDto> queryPageByArticleId(CommentPageVo commentPageVo) {
        Page<CommentAndReplyDto> page = new Query<CommentAndReplyDto>()
                .getPage(commentPageVo.getCurrent(), commentPageVo.getSize());

        return new RPage<>(
                baseMapper.queryPageByArticleId(page, commentPageVo.getId())
        );
    }

}