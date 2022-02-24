package com.slipper.modules.log.controller;

import com.slipper.common.utils.R;
import com.slipper.common.vo.StatusVo;
import com.slipper.modules.log.model.vo.LogPageVo;
import com.slipper.modules.log.service.LogService;
import com.slipper.modules.user.entity.UserEntity;
import com.slipper.modules.user.model.vo.UserPageVo;
import com.slipper.modules.user.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 日志
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class LogController {
    @Resource
    private LogService logService;

    /**
     * 分页列表
     *
     * @api {GET} /slipper/console/log/page page
     * @apiDescription 日志分页列表
     * @apiVersion 1.0.0
     * @apiGroup Log
     * @apiName page
     * @apiParamExample 请求参数示例
     * {
     *     page: 1, // 当前页
     *     size: 10, // 页面大小
     *     start: '', // 开始时间
     *     end: '', // 结束时间
     *     name: '', // 用户名 / 昵称
     *     ip: '', // ip地址
     *     operation: '', // 操作
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
     *         	   operation: '', // 操作
     *         	   url: '', // 请求URL
     *         	   method: '', // 请求方式
     *         	   params: '', // 请求参数
     *         	   class_name: '', // 类名和方法名
     *         	   times: '', // 执行时长
     *         	   ip: '', // ip地址
     *         	   agent: '', // 用户代理
     *         	   user_id: '', // 用户ID
     *         	   username: '', // 用户名
     *         	   nickname: '', // 昵称
     *             created_at: '' // 创建时间
     *         }]
     *     }
     * }
     */
    @GetMapping("/console/log/page")
    public R page(LogPageVo logPageVo){
        return R.success(logService.queryPage(logPageVo));
    }

    /**
     * 清理操作日志
     *
     * @api {POST} /slipper/console/log/truncate truncate
     * @apiDescription 清理操作日志
     * @apiVersion 1.0.0
     * @apiGroup Log
     * @apiName truncate
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     * }
     */
    @PostMapping("/console/log/truncate")
    public R truncate(){
        logService.truncate();
        return R.success();
    }

}
