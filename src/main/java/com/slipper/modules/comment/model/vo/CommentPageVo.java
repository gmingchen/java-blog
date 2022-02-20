package com.slipper.modules.comment.model.vo;

import com.slipper.common.vo.PageDateVo;
import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class CommentPageVo extends PageDateVo {
    /**
     * 用户名 / 昵称
     */
    private String name;
}
