package com.slipper.modules.article.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.slipper.modules.article.entity.ArticleTagEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章--标签
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Mapper
public interface ArticleTagDao extends BaseMapper<ArticleTagEntity> {

}
