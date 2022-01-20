package com.slipper.modules.tag.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.slipper.modules.tag.entity.TagEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 标签
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Mapper
public interface TagDao extends BaseMapper<TagEntity> {

}
