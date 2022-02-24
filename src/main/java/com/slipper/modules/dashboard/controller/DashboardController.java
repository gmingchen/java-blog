package com.slipper.modules.dashboard.controller;

import com.slipper.common.utils.R;
import com.slipper.modules.dashboard.service.DashboardService;
import com.slipper.modules.user.model.dto.UserStatisticsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 仪表盘
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@RestController
public class DashboardController {
    @Resource
    private DashboardService dashboardService;

    /**
     * 数据统计
     *
     * @api {GET} /slipper/console/dashboard/quantityStatistics quantityStatistics
     * @apiDescription 数据统计
     * @apiVersion 1.0.0
     * @apiGroup Dashboard
     * @apiName quantityStatistics
     * @apiParamExample 请求参数示例
     * {}
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: {
     *         article: '', // 文章数量
     *         release: '', // 文章发布数量
     *         comment: '', // 文章评论数量
     *         read: '', // 文章阅读数量
     *         message: '' // 留言数量
     *     }
     * }
     */
    @GetMapping("/console/dashboard/quantityStatistics")
    public R queryQuantityStatistics(){
        return R.success(dashboardService.queryQuantityStatistics());
    }

    /**
     * 增加用户统计
     *
     * @api {GET} /slipper/console/dashboard/userStatistics userStatistics
     * @apiDescription 增加用户统计
     * @apiVersion 1.0.0
     * @apiGroup Dashboard
     * @apiName userStatistics
     * @apiParamExample 请求参数示例
     * {}
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: [{
     *         date: '', // 日期
     *         count: '', // 数量
     *     }]
     * }
     */
    @GetMapping("/console/dashboard/userStatistics")
    public R userQuantityStatistics(int day){
        return R.success(dashboardService.queryUserStatistics(day));
    }

    /**
     * 获取最近发布的文章
     *
     * @api {GET} /slipper/console/dashboard/latestArticle latestArticle
     * @apiDescription 获取最近发布的文章
     * @apiVersion 1.0.0
     * @apiGroup Dashboard
     * @apiName latestArticle
     * @apiParamExample 请求参数示例
     * {
     *     limit: '' // 数量
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: [{
     *         id: '', // ID
     *         title: '', // 标题
     *         published_at: '', // 发布时间
     *         created_at: '', // 创建时间
     *         updated_at: '', // 更新时间
     *     }]
     * }
     */
    @GetMapping("/console/dashboard/latestArticle")
    public R latestArticle(int limit){
        return R.success(dashboardService.queryLatestArticle(limit));
    }

    /**
     * 获取最近收到的文章评论
     *
     * @api {GET} /slipper/console/dashboard/latestComment latestComment
     * @apiDescription 获取最近发布的文章
     * @apiVersion 1.0.0
     * @apiGroup Dashboard
     * @apiName latestComment
     * @apiParamExample 请求参数示例
     * {
     *     limit: '' // 数量
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: [{
     *         id: '', // ID
     *         content: '', // 内容
     *         article_id: '', // 文章ID
     *         article_title: '', // 文章标题
     *         user_id: '', // 用户ID
     *         username: '', // 用户名
     *         nickname: '', // 昵称
     *         created_at: '', // 创建时间
     *     }]
     * }
     */
    @GetMapping("/console/dashboard/latestComment")
    public R latestComment(int limit){
        return R.success(dashboardService.queryLatestComment(limit));
    }

    /**
     * 获取最近收到的留言
     *
     * @api {GET} /slipper/console/dashboard/latestMessage latestMessage
     * @apiDescription 获取最近收到的留言
     * @apiVersion 1.0.0
     * @apiGroup Dashboard
     * @apiName latestMessage
     * @apiParamExample 请求参数示例
     * {
     *     limit: '' // 数量
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: [{
     *         id: '', // ID
     *         content: '', // 内容
     *         user_id: '', // 用户ID
     *         username: '', // 用户名
     *         nickname: '', // 昵称
     *         created_at: '', // 创建时间
     *     }]
     * }
     */
    @GetMapping("/console/dashboard/latestMessage")
    public R latestMessage(int limit){
        return R.success(dashboardService.queryLatestLeaveMessage(limit));
    }

    /**
     * 获取最近操作日志
     *
     * @api {GET} /slipper/console/dashboard/latestLog latestLog
     * @apiDescription 获取最近操作日志
     * @apiVersion 1.0.0
     * @apiGroup Dashboard
     * @apiName latestLog
     * @apiParamExample 请求参数示例
     * {
     *     limit: '' // 数量
     * }
     * @apiSuccessExample 响应结果示例
     * {
     *     code: 0,
     *     status: 'success',
     *     message: '成功!',
     *     data: [{
     *         id: '', // ID
     *         operation: '', // 操作
     *         ip: '', // IP地址
     *         user_id: '', // 用户ID
     *         username: '', // 用户名
     *         nickname: '', // 昵称
     *         created_at: '', // 创建时间
     *     }]
     * }
     */
    @GetMapping("/console/dashboard/latestLog")
    public R latestLog(int limit){
        return R.success(dashboardService.queryLatestLog(limit));
    }

}
