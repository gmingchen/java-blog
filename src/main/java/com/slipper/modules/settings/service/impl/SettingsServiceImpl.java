package com.slipper.modules.settings.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.modules.settings.dao.SettingsDao;
import com.slipper.modules.settings.entity.SettingsEntity;
import com.slipper.modules.settings.service.SettingsService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("settingsService")
public class SettingsServiceImpl extends ServiceImpl<SettingsDao, SettingsEntity> implements SettingsService {

}