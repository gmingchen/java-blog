package com.slipper.modules.config.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.exception.RunException;
import com.slipper.common.vo.StatusVo;
import com.slipper.modules.config.dao.ConfigDao;
import com.slipper.modules.config.entity.ConfigEntity;
import com.slipper.modules.config.model.vo.ConfigVo;
import com.slipper.modules.config.service.ConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * @author gumingchen
 */
@Service("configService")
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, ConfigEntity> implements ConfigService {

    @Override
    public String queryValueById(int id) {
        return baseMapper.queryValueById(id);
    }

    @Override
    public void update(ConfigVo configVo) {
        ConfigEntity configEntity = new ConfigEntity();
        configEntity.setId(configVo.getId());
        configEntity.setJsonValue(configVo.getValue());
        configEntity.setUpdatedAt(new Date());

        this.updateById(configEntity);
    }

    @Override
    @Transactional(rollbackFor = RunException.class)
    public void status(StatusVo<Integer, Integer> statusVo) {
        ConfigEntity configEntity = this.getById(statusVo.getKey());
        configEntity.setStatus(statusVo.getValue());

        LambdaUpdateWrapper<ConfigEntity> wrapper = new LambdaUpdateWrapper<ConfigEntity>()
                .set(ConfigEntity::getStatus, 0)
                .eq(ConfigEntity::getJsonKey, configEntity.getJsonKey())
                .eq(ConfigEntity::getStatus, 1);

        this.update(wrapper);
        this.updateById(configEntity);
    }

    @Override
    public Map<String, Object> queryValueByKey(String key) {
        LambdaQueryWrapper<ConfigEntity> wrapper = new LambdaQueryWrapper<ConfigEntity>()
                .eq(ConfigEntity::getJsonKey, key)
                .eq(ConfigEntity::getStatus, 1);
        ConfigEntity configEntity = this.getOne(wrapper);

        Map<String, Object> map = JSON.parseObject(baseMapper.queryValueByKey(key));
        map.put("type", configEntity.getType());

        return map;
    }
}