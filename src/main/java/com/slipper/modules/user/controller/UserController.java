package com.slipper.modules.user.controller;

import com.slipper.core.common.utils.R;
import com.slipper.core.modules.user.model.vo.UserPageVo;
import com.slipper.core.modules.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户侧
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
@RequestMapping("/console/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 分页列表
     *
     * @api {GET} /slipper/console/user/page page
     * @apiDescription 用户分页列表
     * @apiVersion 1.0.0
     * @apiGroup User
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
     *     message: '成功!',
     *     data: {
     *         current: 1, // 当前页
     *         size: 1, // 页面大小
     *         total: 1, // 总条数
     *         pages: 1, // 总页数
     *         list: [{
     *         	   id: '', // ID
     *         	   username: '', // 用户名
     *         	   nickname: '', // 昵称
     *         	   sex: '', // 性别 0-女 1-男 2-保密
     *         	   avatar: '', // 头像
     *         	   mobile: '', // 手机号
     *         	   author: '', // 是否是作者 0-否 1-是
     *             created_at: '' // 创建时间
     *         }]
     *     }
     * }
     */
    @GetMapping("/page")
    public R selfInfo(@RequestParam UserPageVo userPageVo){
        return R.success(userService.queryPage(userPageVo));
    }

}
