package com.slipper.modules.settings.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.slipper.modules.settings.entity.SettingsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统设置
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Mapper
public interface SettingsDao extends BaseMapper<SettingsEntity> {

}
