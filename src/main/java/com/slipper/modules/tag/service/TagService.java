package com.slipper.modules.tag.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.utils.RPage;
import com.slipper.modules.tag.entity.TagEntity;
import com.slipper.modules.tag.model.vo.TagPageVo;

/**
 * 标签
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface TagService extends IService<TagEntity> {

    /**
     * 查询系统管理员
     * @param userPageVo 分页参数
     * @return
     */
    RPage<TagEntity> queryPage(TagPageVo userPageVo);

    /**
     * 新增
     * @param tagEntity 标签
     */
    void create(TagEntity tagEntity);

    /**
     * 新增
     * @param tagEntity 标签
     */
    void update(TagEntity tagEntity);

}

