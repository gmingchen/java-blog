package com.slipper.modules.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.exception.RunException;
import com.slipper.common.utils.*;
import com.slipper.modules.article.dao.ArticleDao;
import com.slipper.modules.article.entity.ArticleEntity;
import com.slipper.modules.article.entity.ArticleTagEntity;
import com.slipper.modules.article.model.dto.ArticleBasicDto;
import com.slipper.modules.article.model.dto.ArticleDto;
import com.slipper.modules.article.model.vo.ArticlePageVo;
import com.slipper.modules.article.model.vo.ArticleVo;
import com.slipper.modules.article.service.ArticleService;
import com.slipper.modules.article.service.ArticleTagService;
import com.slipper.modules.read.entity.ReadEntity;
import com.slipper.modules.read.service.ReadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author gumingchen
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, ArticleEntity> implements ArticleService {
    @Resource
    private ArticleTagService articleTagService;
    @Resource
    private ReadService readService;

    @Override
    public RPage<ArticleDto> queryPage(ArticlePageVo articlePageVo) {
        Page<ArticleDto> page = new Query<ArticleDto>().getPage(articlePageVo.getCurrent(), articlePageVo.getSize());
        return new RPage<>(
                baseMapper.queryPage(
                        page,
                        articlePageVo.getStart(),
                        articlePageVo.getEnd(),
                        articlePageVo.getTitle(),
                        articlePageVo.getCategoryIds(),
                        articlePageVo.getTagIds(),
                        articlePageVo.getRecommended(),
                        articlePageVo.getCommentable(),
                        articlePageVo.getPublished()
                )
        );
    }

    @Override
    public ArticleDto queryInfo(int id) {
        return baseMapper.queryInfo(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer create(ArticleVo articleVo) {
        ArticleEntity articleEntity = getArticle(articleVo);
        articleEntity.setCreatedAt(new Date());
        this.save(articleEntity);

        List<ArticleTagEntity> articleTagList = getArticleTag(articleEntity.getId(), articleVo.getTags());
        articleTagService.saveBatch(articleTagList);
        return articleEntity.getId();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(ArticleVo articleVo) {
        ArticleEntity articleEntity = getArticle(articleVo);
        articleEntity.setUpdatedAt(new Date());
        this.updateById(articleEntity);

        LambdaQueryWrapper<ArticleTagEntity> wrapper = new LambdaQueryWrapper<ArticleTagEntity>()
                .eq(ArticleTagEntity::getArticleId, articleVo.getId());
        articleTagService.remove(wrapper);

        List<ArticleTagEntity> articleTagList = getArticleTag(articleVo.getId(), articleVo.getTags());
        articleTagService.saveBatch(articleTagList);
    }

    @Override
    public Long queryCount(Integer published) {
        LambdaQueryWrapper<ArticleEntity> wrapper = new LambdaQueryWrapper<ArticleEntity>()
                .eq(null != published, ArticleEntity::getPublished, published);

        return this.count(wrapper);
    }

    @Override
    public List<ArticleBasicDto> queryLatest(int limit) {
        return baseMapper.queryLatest(limit);
    }

    @Override
    public Long queryAllRead() {
        return baseMapper.queryAllRead();
    }

    @Override
    public List<ArticleDto> queryLatestPublished(int limit) {
        return baseMapper.queryLatestPublished(limit);
    }

    @Override
    public List<ArticleBasicDto> queryRecommended(int limit) {
        return baseMapper.queryRecommended(limit);
    }

    @Override
    public List<ArticleBasicDto> queryRead(int limit) {
        return baseMapper.queryRead(limit);
    }

    @Override
    public List<ArticleBasicDto> querySearchSuggest(String keyword, int limit) {
        if (StringUtils.isNotBlank(keyword)) {
            return baseMapper.querySearchSuggest(keyword, limit);
        }
        return new ArrayList<>();
    }

    @Transactional
    @Override
    public ArticleDto queryDetails(int id, Integer userId) {
        ArticleDto articleDto = baseMapper.queryDetails(id);
        if (articleDto == null) {
            throw new RunException(Constant.WARNING_CODE, "该文章不存在！");
        }

        String ip = HttpContextUtils.getIp();
        String today = DateUtils.format(new Date(), DateUtils.DATE_FORMAT);
        LambdaQueryWrapper<ReadEntity> queryWrapper = new LambdaQueryWrapper<ReadEntity>()
                .and((wrapper) -> {
                    wrapper.eq(userId != null, ReadEntity::getUserId, userId)
                            .or().eq(StringUtils.isNotBlank(ip), ReadEntity::getIp, ip);
                })
                .eq(ReadEntity::getArticleId, id)
                .ge(ReadEntity::getCreatedAt, today + " 00:00:00")
                .le(ReadEntity::getCreatedAt, today + " 23:59:59");
        long count = readService.count(queryWrapper);
        if (count == 0) {
            ReadEntity readEntity = new ReadEntity();
            readEntity.setArticleId(id);
            readEntity.setUserId(userId);
            readEntity.setIp(ip);
            readEntity.setCreatedAt(new Date());
            readService.save(readEntity);
            baseMapper.readingPlusOne(id);
        }

        articleDto = baseMapper.queryDetails(id);

        return articleDto;
    }

    /**
     * 设置 文章
     * @param articleVo 文章入参
     * @return
     */
    private ArticleEntity getArticle(ArticleVo articleVo) {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setId(articleVo.getId());
        articleEntity.setTitle(articleVo.getTitle());
        articleEntity.setType(articleVo.getType());
        if (articleVo.getPublished() == 1) {
            articleEntity.setPublishedAt(new Date());
        }
        try {
            articleEntity.setContent(URLDecoder.decode(articleVo.getContent(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        articleEntity.setDescribe(articleVo.getDescribe());
        articleEntity.setCategoryId(articleVo.getCategoryId());
        articleEntity.setCover(articleVo.getCover());
        articleEntity.setRecommended(articleVo.getRecommended());
        articleEntity.setCommentable(articleVo.getCommentable());
        articleEntity.setPublished(articleVo.getPublished());
        return articleEntity;
    }

    /**
     * 设置 文章标签
     * @param articleId 文章ID
     * @param tagIds 标签ID
     * @return
     */
    private List<ArticleTagEntity> getArticleTag(int articleId, List<Integer> tagIds) {
        List<ArticleTagEntity> articleTagList = new ArrayList<>();
        for (int tagId : tagIds) {
            ArticleTagEntity articleTagEntity = new ArticleTagEntity();
            articleTagEntity.setArticleId(articleId);
            articleTagEntity.setTagId(tagId);
            articleTagList.add(articleTagEntity);
        }
        return articleTagList;
    }
}