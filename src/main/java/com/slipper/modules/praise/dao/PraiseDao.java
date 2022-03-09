package com.slipper.modules.praise.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.slipper.modules.praise.entity.PraiseEntity;
import com.slipper.modules.tag.entity.TagEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章点赞
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Mapper
public interface PraiseDao extends BaseMapper<PraiseEntity> {

}
