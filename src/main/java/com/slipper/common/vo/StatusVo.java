package com.slipper.common.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class StatusVo<K, V> {
    /**
     * 键值
     */
    @NotNull(message = "Key不能为空")
    private K key;
    /**
     * 值
     */
    @NotNull(message = "Value不能为空")
    private V value;
}
