package com.slipper.modules.comment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.utils.RPage;
import com.slipper.modules.comment.entity.CommentEntity;
import com.slipper.modules.comment.model.dto.CommentAndReplyDto;
import com.slipper.modules.comment.model.dto.CommentBasicDto;
import com.slipper.modules.comment.model.dto.CommentDto;
import com.slipper.modules.comment.model.vo.CommentPageVo;
import com.slipper.modules.comment.model.vo.CommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * @param commentPageVo 分页参数
     * @return
     */
    RPage<CommentDto> queryPage(CommentPageVo commentPageVo);

    /**
     * 获取最近收到的文章评论
     * @param limit 数量
     * @return
     */
    List<CommentBasicDto> queryLatest(int limit);

    /**
     * 用户端-用户评论文章
     * @param commentVo 评论参数
     */
    void create(CommentVo commentVo);

    /**
     * 用户端-文章评论分页
     * @param commentPageVo 分页参数
     * @return
     */
    RPage<CommentAndReplyDto> queryPageByArticleId(CommentPageVo commentPageVo);

}

