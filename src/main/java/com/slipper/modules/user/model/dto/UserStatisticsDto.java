package com.slipper.modules.user.model.dto;

import lombok.Data;

/**
 * 用户统计
 * @author gumingchen
 */
@Data
public class UserStatisticsDto {
    /**
     * 日期
     */
    private String date;
    /**
     * 新增用户数量
     */
    private Long count;
}
