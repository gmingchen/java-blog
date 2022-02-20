package com.slipper.modules.comment.controller;

import com.slipper.common.utils.Constant;
import com.slipper.common.utils.R;
import com.slipper.modules.AbstractController;
import com.slipper.modules.comment.entity.CommentReplyEntity;
import com.slipper.modules.comment.model.vo.CommentReplyPageVo;
import com.slipper.modules.comment.service.CommentReplyService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章评论回复
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class CommentReplyController extends AbstractController {
    @Resource
    private CommentReplyService commentReplyService;

    /**
     * 分页列表
     *
     * @api {GET} /slipper/console/commentReply/page page
     * @apiDescription 文章评论回复分页列表
     * @apiVersion 1.0.0
     * @apiGroup CommentReply
     * @apiName page
     * @apiParamExample 请求参数示例
     * {
     *     page: 1, // 当前页
     *     size: 10, // 页面大小
     *     id: '', // 留言ID
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: {
     *         current: 1, // 当前页
     *         size: 1, // 页面大小
     *         total: 1, // 总条数
     *         pages: 1, // 总页数
     *         list: [{
     *         	   id: '', // ID
     *         	   content: '', // 内容
     *         	   comment_id: '', // 留言ID
     *         	   comment_reply_id: '', // 回复的ID
     *         	   type: '', // 类型 0-回复 1-回复的回复
     *         	   created_at: '', // 创建时间
     *         	   from_user_id: '', // 回复用户的ID
     *         	   from_username: '', // 回复用户的用户名
     *         	   from_nickname: '', // 回复用户的昵称
     *         	   from_avatar: '', // 回复用户的头像
     *         	   from_sex: '', // 回复用户的性别：0-女 1-男 2-保密
     *         	   to_user_id: '', // 目标用户的ID
     *         	   to_username: '', // 目标用户的用户名
     *         	   to_nickname: '', // 目标用户的昵称
     *         	   to_avatar: '', // 目标用户的头像
     *         	   to_sex: '', // 目标用户的性别：0-女 1-男 2-保密
     *         }]
     *     }
     * }
     */
    @GetMapping("/console/commentReply/page")
    public R page(CommentReplyPageVo commentReplyPageVo){
        return R.success(commentReplyService.queryPage(commentReplyPageVo));
    }

    /**
     * 文章评论回复
     *
     * @api {POST} /slipper/console/commentReply/create create
     * @apiDescription 文章评论回复
     * @apiVersion 1.0.0
     * @apiGroup CommentReply
     * @apiName create
     * @apiParamExample 请求参数示例
     * {
     *     content: '', // 内容
     *     comment_id: '', // 留言ID
     *     to_user_id: '', // 目标用户的ID
     *     type: '', // 类型 0-回复 1-回复的回复
     *     comment_reply_id: '' // 回复的ID type为 1 时须该字段
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/commentReply/create")
    public R create(@RequestBody @Validated CommentReplyEntity commentReplyEntity) {
        if (commentReplyEntity.getType() == 1 && commentReplyEntity.getCommentReplyId() == null) {
            return R.error(Constant.VERIFICATION_ERROR_CODE, Constant.VERIFICATION_ERROR + "comment_reply_id-留言ID不能为空");
        }
        commentReplyEntity.setFromUserId(getUserId());
        commentReplyService.create(commentReplyEntity);
        return R.success();
    }

    /**
     * 批量删除
     *
     * @api {POST} /slipper/console/commentReply/delete delete
     * @apiDescription 文章评论回复批量删除
     * @apiVersion 1.0.0
     * @apiGroup CommentReply
     * @apiName delete
     * @apiParamExample 请求参数示例
     * {
     *     ids: '' // ID
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/commentReply/delete")
    public R delete(@RequestBody List<Integer> ids) {
        commentReplyService.removeBatchByIds(ids);
        return R.success();
    }

}
