package com.slipper.modules.leaveMessage.controller;

import com.slipper.common.utils.R;
import com.slipper.modules.leaveMessage.model.vo.LeaveMessagePageVo;
import com.slipper.modules.leaveMessage.service.LeaveMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 留言
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class LeaveMessageController {
    @Resource
    private LeaveMessageService leaveMessageService;

    /**
     * 分页列表
     *
     * @api {GET} /slipper/console/leaveMessage/page page
     * @apiDescription 留言分页列表
     * @apiVersion 1.0.0
     * @apiGroup Tag
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
    @GetMapping("/console/leaveMessage/page")
    public R page(LeaveMessagePageVo leaveMessagePageVo){
        return R.success(leaveMessageService.queryPage(leaveMessagePageVo));
    }

    /**
     * 批量删除
     *
     * @api {POST} /slipper/console/leaveMessage/delete delete
     * @apiDescription 留言批量删除
     * @apiVersion 1.0.0
     * @apiGroup Tag
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
    @PostMapping("/console/leaveMessage/delete")
    public R delete(@RequestBody List<Integer> ids) {
        leaveMessageService.removeBatchByIds(ids);
        return R.success();
    }

}
