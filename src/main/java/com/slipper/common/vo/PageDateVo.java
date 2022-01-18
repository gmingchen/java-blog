package com.slipper.common.vo;

import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class PageDateVo {
    /**
     * 当前页
     */
    public Integer current;
    /**
     * 分页大小
     */
    public Integer size;
    /**
     * 开始时间
     */
    public String start;
    /**
     * 结束时间
     */
    private String end;
}
