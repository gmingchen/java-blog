package com.slipper.modules.comment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.utils.RPage;
import com.slipper.modules.comment.entity.CommentEntity;
import com.slipper.modules.comment.model.dto.CommentDto;
import com.slipper.modules.comment.model.vo.CommentPageVo;

/**
 * 文章评论
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface CommentService extends IService<CommentEntity> {

    /**
     * 分页
     * @param leaveMessagePageVo 分页参数
     * @return
     */
    RPage<CommentDto> queryPage(CommentPageVo leaveMessagePageVo);

}

