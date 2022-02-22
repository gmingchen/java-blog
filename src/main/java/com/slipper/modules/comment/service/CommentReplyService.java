package com.slipper.modules.comment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.utils.RPage;
import com.slipper.modules.comment.entity.CommentReplyEntity;
import com.slipper.modules.comment.model.dto.CommentReplyDto;
import com.slipper.modules.comment.model.vo.CommentReplyPageVo;

/**
 * 文章评论回复
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface CommentReplyService extends IService<CommentReplyEntity> {

    /**
     * 分页
     * @param commentReplyPageVo 分页参数
     * @return
     */
    RPage<CommentReplyDto> queryPage(CommentReplyPageVo commentReplyPageVo);

    /**
     * 文章评论回复
     * @param commentReplyEntity 文章评论回复实体
     */
    void create(CommentReplyEntity commentReplyEntity);

}

