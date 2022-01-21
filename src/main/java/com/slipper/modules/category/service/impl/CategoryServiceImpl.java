package com.slipper.modules.category.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.utils.Query;
import com.slipper.common.utils.RPage;
import com.slipper.modules.category.dao.CategoryDao;
import com.slipper.modules.category.entity.CategoryEntity;
import com.slipper.modules.category.model.vo.CategoryPageVo;
import com.slipper.modules.category.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author gumingchen
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public RPage<CategoryEntity> queryPage(CategoryPageVo categoryPageVo) {
        Page<CategoryEntity> page = new Query<CategoryEntity>().getPage(categoryPageVo.getCurrent(), categoryPageVo.getSize());

        LambdaQueryWrapper<CategoryEntity> wrapper = new LambdaQueryWrapper<CategoryEntity>()
                .eq(StringUtils.isNotBlank(categoryPageVo.getName()), CategoryEntity::getName, categoryPageVo.getName())
                .orderByDesc(CategoryEntity::getCreatedAt);

        return new RPage<>(this.page(page, wrapper));
    }

    @Override
    public void create(CategoryEntity categoryEntity) {
        categoryEntity.setCreatedAt(new Date());
        this.save(categoryEntity);
    }

    @Override
    public void update(CategoryEntity categoryEntity) {
        categoryEntity.setUpdatedAt(new Date());
        this.updateById(categoryEntity);
    }

}