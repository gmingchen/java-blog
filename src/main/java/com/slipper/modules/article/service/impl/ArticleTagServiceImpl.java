package com.slipper.modules.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.modules.article.dao.ArticleTagDao;
import com.slipper.modules.article.entity.ArticleTagEntity;
import com.slipper.modules.article.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagDao, ArticleTagEntity> implements ArticleTagService {


}