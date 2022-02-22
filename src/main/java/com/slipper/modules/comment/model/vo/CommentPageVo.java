package com.slipper.modules.comment.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slipper.common.vo.PageDateVo;
import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class CommentPageVo extends PageDateVo {
    /**
     * 文章ID
     */
    private Integer id;
    /**
     * 用户名 / 昵称
     */
    private String name;
}
