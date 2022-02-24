package com.slipper.modules.log.model.vo;

import com.slipper.common.vo.PageDateVo;
import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class LogPageVo extends PageDateVo {
    /**
     * 用户名 / 昵称
     */
    private String name;
    /**
     * 操作
     */
    private String operation;
    /**
     * ip地址
     */
    private String ip;
}
