package com.slipper.modules.read.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.modules.read.dao.ReadDao;
import com.slipper.modules.read.entity.ReadEntity;
import com.slipper.modules.read.service.ReadService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("readService")
public class ReadServiceImpl extends ServiceImpl<ReadDao, ReadEntity> implements ReadService {

}