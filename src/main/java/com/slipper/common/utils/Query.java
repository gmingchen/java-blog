package com.slipper.common.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 分页参数处理工具类
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 * @param <T>
 */
public class Query<T> {

    public Page<T> getPage(Integer c, Integer s) {
        long current = c != null ? c : 1;
        long size = s != null ? s : 10;

        Page<T> page = new Page<>(current, size);
        return page;
    }
}
