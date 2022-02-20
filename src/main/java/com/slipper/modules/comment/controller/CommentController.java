package com.slipper.modules.comment.controller;

import com.slipper.common.utils.R;
import com.slipper.modules.comment.model.vo.CommentPageVo;
import com.slipper.modules.comment.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章评论
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class CommentController {
    @Resource
    private CommentService commentService;

    /**
     * 分页列表
     *
     * @api {GET} /slipper/console/comment/page page
     * @apiDescription 文章评论分页列表
     * @apiVersion 1.0.0
     * @apiGroup Comment
     * @apiName page
     * @apiParamExample 请求参数示例
     * {
     *     page: 1, // 当前页
     *     size: 10, // 页面大小
     *     name: '', // 用户名 / 昵称
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
     *         	   article_id: '', // 用户ID
     *         	   user_id: '', // 用户ID
     *             created_at: '', // 创建时间
     *             username: '', // 用户名
     *             nickname: '', // 昵称
     *             avatar: '', // 头像
     *             sex: '' // 性别：0-女 1-男 2-保密
     *         }]
     *     }
     * }
     */
    @GetMapping("/console/comment/page")
    public R page(CommentPageVo commentPageVo){
        return R.success(commentService.queryPage(commentPageVo));
    }

    /**
     * 批量删除
     *
     * @api {POST} /slipper/console/comment/delete delete
     * @apiDescription 文章评论批量删除
     * @apiVersion 1.0.0
     * @apiGroup Comment
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
    @PostMapping("/console/comment/delete")
    public R delete(@RequestBody List<Integer> ids) {
        commentService.removeBatchByIds(ids);
        return R.success();
    }

}
