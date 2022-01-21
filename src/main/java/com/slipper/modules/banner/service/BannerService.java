package com.slipper.modules.banner.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.utils.RPage;
import com.slipper.modules.banner.entity.BannerEntity;
import com.slipper.modules.banner.model.vo.BannerPageVo;

/**
 * 轮播图
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface BannerService extends IService<BannerEntity> {

    /**
     * 分页
     * @param bannerPageVo 分页参数
     * @return
     */
    RPage<BannerEntity> queryPage(BannerPageVo bannerPageVo);

    /**
     * 新增
     * @param bannerEntity 轮播图
     */
    void create(BannerEntity bannerEntity);

    /**
     * 新增
     * @param bannerEntity 轮播图
     */
    void update(BannerEntity bannerEntity);

}

