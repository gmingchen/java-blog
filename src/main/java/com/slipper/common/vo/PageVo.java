package com.slipper.common.vo;

import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class PageVo {
    /**
     * 当前页
     */
    public Integer current;
    /**
     * 分页大小
     */
    public Integer size;
}
