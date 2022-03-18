package com.slipper.modules.dashboard.service.impl;

import com.slipper.modules.article.model.dto.ArticleBasicDto;
import com.slipper.modules.article.service.ArticleService;
import com.slipper.modules.comment.model.dto.CommentBasicDto;
import com.slipper.modules.comment.service.CommentService;
import com.slipper.modules.dashboard.model.dto.QuantityStatisticsDto;
import com.slipper.modules.dashboard.service.DashboardService;
import com.slipper.modules.leaveMessage.model.dto.LeaveMessageBasicDto;
import com.slipper.modules.leaveMessage.service.LeaveMessageService;
import com.slipper.modules.log.model.dto.LogBasicDto;
import com.slipper.modules.log.service.LogService;
import com.slipper.modules.praise.service.PraiseService;
import com.slipper.modules.user.model.dto.UserStatisticsDto;
import com.slipper.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gumingchen
 */
@Service("dashboardService")
public class DashboardServiceImpl implements DashboardService {
    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;
    @Resource
    private LeaveMessageService leaveMessageService;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;
    @Resource
    private PraiseService praiseService;

    @Override
    public QuantityStatisticsDto queryQuantityStatistics() {
        QuantityStatisticsDto quantityStatisticsDto = new QuantityStatisticsDto();
        quantityStatisticsDto.setArticle(articleService.queryCount(null));
        quantityStatisticsDto.setRelease(articleService.queryCount(1));
        quantityStatisticsDto.setComment(commentService.count());
        quantityStatisticsDto.setPraise(praiseService.count());
        quantityStatisticsDto.setRead(articleService.queryAllRead());
        quantityStatisticsDto.setMessage(leaveMessageService.count());
        return quantityStatisticsDto;
    }

    @Override
    public List<UserStatisticsDto> queryUserStatistics(int day) {
        return userService.queryUserStatistics(day);
    }

    @Override
    public List<ArticleBasicDto> queryLatestArticle(int limit) {
        return articleService.queryLatest(limit);
    }

    @Override
    public List<CommentBasicDto> queryLatestComment(int limit) {
        return commentService.queryLatest(limit);
    }

    @Override
    public List<LeaveMessageBasicDto> queryLatestLeaveMessage(int limit) {
        return leaveMessageService.queryLatest(limit);
    }

    @Override
    public List<LogBasicDto> queryLatestLog(int limit) {
        return logService.queryLatest(limit);
    }
}