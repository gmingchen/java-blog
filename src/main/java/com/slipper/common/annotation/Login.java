package com.slipper.common.annotation;

import java.lang.annotation.*;

/**
 * 登录校验
 * @author gumingchen
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
