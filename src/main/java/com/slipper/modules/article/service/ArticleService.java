package com.slipper.modules.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.utils.RPage;
import com.slipper.modules.article.entity.ArticleEntity;
import com.slipper.modules.article.model.dto.ArticleBasicDto;
import com.slipper.modules.article.model.dto.ArticleDto;
import com.slipper.modules.article.model.vo.ArticleVo;
import com.slipper.modules.article.model.vo.ArticlePageVo;

import java.util.List;

/**
 * 文章
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface ArticleService extends IService<ArticleEntity> {

    /**
     * 分页
     * @param articlePageVo 分页参数
     * @return
     */
    RPage<ArticleDto> queryPage(ArticlePageVo articlePageVo);

    /**
     * 信息
     * @param id ID
     * @return
     */
    ArticleDto queryInfo(int id);

    /**
     * 新增
     * @param articleVo 实体
     */
    Integer create(ArticleVo articleVo);

    /**
     * 编辑
     * @param articleVo 实体
     */
    void update(ArticleVo articleVo);

    /**
     * 查询文章数量
     * @param published 0-未发布 1-发布 null-发布和未发布
     * @return
     */
    Long queryCount(Integer published);

    /**
     * 获取最近发布的文章
     * @param limit 数量
     * @return
     */
    List<ArticleBasicDto> queryLatest(int limit);

}

