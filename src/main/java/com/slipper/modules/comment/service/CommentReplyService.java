package com.slipper.modules.comment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.utils.RPage;
import com.slipper.modules.comment.entity.CommentReplyEntity;
import com.slipper.modules.comment.model.dto.CommentReplyDto;
import com.slipper.modules.comment.model.vo.CommentReplyPageVo;

/**
 * 留言回复
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface CommentReplyService extends IService<CommentReplyEntity> {

    /**
     * 分页
     * @param leaveMessagePageVo 分页参数
     * @return
     */
    RPage<CommentReplyDto> queryPage(CommentReplyPageVo leaveMessagePageVo);

    /**
     * 留言回复
     * @param leaveMessageReplyEntity 留言回复
     */
    void create(CommentReplyEntity leaveMessageReplyEntity);

}

