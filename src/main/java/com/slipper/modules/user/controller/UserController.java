package com.slipper.modules.user.controller;

import com.slipper.common.utils.R;
import com.slipper.common.vo.StatusVo;
import com.slipper.modules.user.entity.UserEntity;
import com.slipper.modules.user.model.vo.UserPageVo;
import com.slipper.modules.user.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
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
     *     status: 'success',
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
    @GetMapping("/console/user/page")
    public R page(UserPageVo userPageVo){
        return R.success(userService.queryPage(userPageVo));
    }

    /**
     * 基础信息
     *
     * @api {GET} /slipper/console/user/info info
     * @apiDescription 用户基础信息
     * @apiVersion 1.0.0
     * @apiGroup User
     * @apiName info
     * @apiParamExample 请求参数示例
     * {
     *     id: '', // 用户ID
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: {
     *         id: '', // ID
     *         username: '', // 用户名
     *         nickname: '', // 昵称
     *         sex: '', // 性别 0-女 1-男 2-保密
     *         avatar: '', // 头像
     *         mobile: '', // 手机号
     *         author: '', // 是否是作者 0-否 1-是
     *         created_at: '' // 创建时间
     *     }
     * }
     */
    @GetMapping("/console/user/info")
    public R info(Integer id){
        return R.success(userService.queryInfo(id));
    }

    /**
     * 启用 / 禁用
     *
     * @api {POST} /slipper/console/user/status status
     * @apiDescription 是否禁用
     * @apiVersion 1.0.0
     * @apiGroup User
     * @apiName status
     * @apiParamExample 请求参数示例
     * {
     *     key: '', // ID
     *     value: '' // 0：禁用 1：启用
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!'
     * }
     */
    @PostMapping("/console/user/status")
    public R status(@RequestBody @Validated StatusVo<Integer, Integer> statusVo){
        UserEntity user = new UserEntity();
        user.setId(statusVo.getKey());
        user.setStatus(statusVo.getValue());

        userService.updateById(user);

        return R.success();
    }

}
