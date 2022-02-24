package com.slipper.modules.dashboard.service;

import com.slipper.modules.article.model.dto.ArticleBasicDto;
import com.slipper.modules.comment.model.dto.CommentBasicDto;
import com.slipper.modules.dashboard.model.dto.QuantityStatisticsDto;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageBasicDto;
import com.slipper.modules.log.model.dto.LogBasicDto;
import com.slipper.modules.user.model.dto.UserStatisticsDto;

import java.util.List;

/**
 * 仪表盘
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface DashboardService {

    /**
     * 数据统计
     * @return
     */
    QuantityStatisticsDto queryQuantityStatistics();

    /**
     * 增加用户统计
     * @param day 最近天数
     * @return
     */
    List<UserStatisticsDto> queryUserStatistics(int day);

    /**
     * 获取最近发布的文章
     * @param limit 数量
     * @return
     */
    List<ArticleBasicDto> queryLatestArticle(int limit);

    /**
     * 获取最近收到的文章评论
     * @param limit 数量
     * @return
     */
    List<CommentBasicDto> queryLatestComment(int limit);

    /**
     * 获取最近收到的留言
     * @param limit 数量
     * @return
     */
    List<LeaveMessageBasicDto> queryLatestLeaveMessage(int limit);

    /**
     * 获取最近操作日志
     * @param limit
     * @return
     */
    List<LogBasicDto> queryLatestLog(int limit);
}

