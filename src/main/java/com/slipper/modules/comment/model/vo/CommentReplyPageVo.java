package com.slipper.modules.comment.model.vo;

import com.slipper.common.vo.PageDateVo;
import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class CommentReplyPageVo extends PageDateVo {
    /**
     * 留言ID
     */
    private Integer id;
}
