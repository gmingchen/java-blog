package com.slipper.modules.config.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.slipper.modules.config.entity.ConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 配置
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
@Mapper
public interface ConfigDao extends BaseMapper<ConfigEntity> {
    /**
     * 通过 ID 查询值
     * @param id ID
     * @return
     */
	String queryValueById(@Param("id") int id);
    /**
     * 通过 key 查询 启用的值
     * @param key 键
     * @return
     */
	String queryValueByKey(@Param("key") String key);
}
