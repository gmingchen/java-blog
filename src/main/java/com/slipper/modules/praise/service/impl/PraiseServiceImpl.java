package com.slipper.modules.praise.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.modules.praise.dao.PraiseDao;
import com.slipper.modules.praise.entity.PraiseEntity;
import com.slipper.modules.praise.service.PraiseService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("praiseService")
public class PraiseServiceImpl extends ServiceImpl<PraiseDao, PraiseEntity> implements PraiseService {

}