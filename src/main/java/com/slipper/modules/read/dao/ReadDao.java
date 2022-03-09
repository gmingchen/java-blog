package com.slipper.modules.read.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.slipper.modules.read.entity.ReadEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章阅读
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Mapper
public interface ReadDao extends BaseMapper<ReadEntity> {

}
