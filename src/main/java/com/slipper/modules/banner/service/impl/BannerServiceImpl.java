package com.slipper.modules.banner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.utils.Query;
import com.slipper.common.utils.RPage;
import com.slipper.modules.banner.dao.BannerDao;
import com.slipper.modules.banner.entity.BannerEntity;
import com.slipper.modules.banner.service.BannerService;
import com.slipper.modules.banner.model.vo.BannerPageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author gumingchen
 */
@Service("bannerService")
public class BannerServiceImpl extends ServiceImpl<BannerDao, BannerEntity> implements BannerService {

    @Override
    public RPage<BannerEntity> queryPage(BannerPageVo bannerPageVo) {
        Page<BannerEntity> page = new Query<BannerEntity>().getPage(bannerPageVo.getCurrent(), bannerPageVo.getSize());

        LambdaQueryWrapper<BannerEntity> wrapper = new LambdaQueryWrapper<BannerEntity>()
                .eq(StringUtils.isNotBlank(bannerPageVo.getTitle()), BannerEntity::getTitle, bannerPageVo.getTitle())
                .orderByDesc(BannerEntity::getCreatedAt);

        return new RPage<>(this.page(page, wrapper));
    }

    @Override
    public void create(BannerEntity bannerEntity) {
        bannerEntity.setCreatedAt(new Date());
        this.save(bannerEntity);
    }

    @Override
    public void update(BannerEntity bannerEntity) {
        bannerEntity.setUpdatedAt(new Date());
        this.updateById(bannerEntity);
    }

}