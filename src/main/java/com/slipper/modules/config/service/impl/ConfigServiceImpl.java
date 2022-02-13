package com.slipper.modules.config.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.modules.config.dao.ConfigDao;
import com.slipper.modules.config.entity.ConfigEntity;
import com.slipper.modules.config.model.vo.ConfigVo;
import com.slipper.modules.config.service.ConfigService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author gumingchen
 */
@Service("configService")
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, ConfigEntity> implements ConfigService {

    @Override
    public Map<String, Object> queryValueById(int id) {
        return JSON.parseObject(baseMapper.queryValueById(id));
    }

    @Override
    public void update(ConfigVo configVo) {
        ConfigEntity configEntity = new ConfigEntity();
        configEntity.setId(configEntity.getId());
        configEntity.setJsonValue(configVo.getValue());
        configEntity.setUpdatedAt(new Date());

        this.updateById(configEntity);
    }

    @Override
    public Map<String, Object> queryValueByKey(String key) {
        return JSON.parseObject(baseMapper.queryValueByKey(key));
    }
}