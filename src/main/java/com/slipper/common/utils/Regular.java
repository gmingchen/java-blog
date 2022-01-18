package com.slipper.common.utils;

/**
 * 正则
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public class Regular {
    /**
     * 用户名：6-12位数字、字母、下横线、中横线组成
     */
    public static final String USERNAME = "^[a-zA-Z0-9_-]{6,12}$";
    /**
     * 密码：8-12位数字、字母、下横线、中横线组成
     */
    public static final String PASSWORD = "^[a-zA-Z0-9_-]{8,12}$";
    /**
     * 手机号：1开头 11位数字
     */
    public static final String MOBILE = "^1[0-9]{10}$";


}
