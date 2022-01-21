package com.slipper.modules.tag.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.utils.Query;
import com.slipper.common.utils.RPage;
import com.slipper.modules.tag.dao.TagDao;
import com.slipper.modules.tag.entity.TagEntity;
import com.slipper.modules.tag.model.vo.TagPageVo;
import com.slipper.modules.tag.service.TagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author gumingchen
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagDao, TagEntity> implements TagService {

    @Override
    public RPage<TagEntity> queryPage(TagPageVo tagPageVo) {
        Page<TagEntity> page = new Query<TagEntity>().getPage(tagPageVo.getCurrent(), tagPageVo.getSize());

        LambdaQueryWrapper<TagEntity> wrapper = new LambdaQueryWrapper<TagEntity>()
                .eq(StringUtils.isNotBlank(tagPageVo.getName()), TagEntity::getName, tagPageVo.getName())
                .orderByDesc(TagEntity::getCreatedAt);

        return new RPage<>(this.page(page, wrapper));
    }

    @Override
    public void create(TagEntity tagEntity) {
        tagEntity.setCreatedAt(new Date());
        this.save(tagEntity);
    }

    @Override
    public void update(TagEntity tagEntity) {
        tagEntity.setUpdatedAt(new Date());
        this.updateById(tagEntity);
    }

}