package com.slipper.modules.category.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.utils.RPage;
import com.slipper.modules.category.entity.CategoryEntity;
import com.slipper.modules.category.model.vo.CategoryPageVo;

/**
 * 分类
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface CategoryService extends IService<CategoryEntity> {

    /**
     * 分页
     * @param categoryPageVo 分页参数
     * @return
     */
    RPage<CategoryEntity> queryPage(CategoryPageVo categoryPageVo);

    /**
     * 新增
     * @param categoryEntity 分类
     */
    void create(CategoryEntity categoryEntity);

    /**
     * 新增
     * @param categoryEntity 分类
     */
    void update(CategoryEntity categoryEntity);

}

