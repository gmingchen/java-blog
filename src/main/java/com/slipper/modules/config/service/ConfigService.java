package com.slipper.modules.config.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.vo.StatusVo;
import com.slipper.modules.config.entity.ConfigEntity;
import com.slipper.modules.config.model.vo.ConfigVo;

import java.util.List;
import java.util.Map;

/**
 * 配置
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface ConfigService extends IService<ConfigEntity> {
    /**
     * 通过 ID 查询值
     * @param id ID
     * @return
     */
    String queryValueById(int id);

    /**
     * 编辑键值信息
     * @param configVo
     */
    void update(ConfigVo configVo);

    /**
     * 启用
     * @param statusVo
     */
    void status(StatusVo<Integer, Integer> statusVo);

    /**
     * 通过 key 查询启用的值
     * @param key 键
     * @return
     */
    Map<String, Object> queryValueByKey(String key);
}

