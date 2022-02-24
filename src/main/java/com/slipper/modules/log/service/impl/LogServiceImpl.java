package com.slipper.modules.log.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.common.utils.Query;
import com.slipper.common.utils.RPage;
import com.slipper.modules.log.dao.LogDao;
import com.slipper.modules.log.entity.LogEntity;
import com.slipper.modules.log.model.dto.LogBasicDto;
import com.slipper.modules.log.model.dto.LogDto;
import com.slipper.modules.log.model.vo.LogPageVo;
import com.slipper.modules.log.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gumingchen
 */
@Service("logService")
public class LogServiceImpl extends ServiceImpl<LogDao, LogEntity> implements LogService {

    @Override
    public RPage<LogDto> queryPage(LogPageVo logPageVo) {
        Page<LogDto> page = new Query<LogDto>().getPage(logPageVo.getCurrent(), logPageVo.getSize());
        return new RPage<>(
                baseMapper.queryPage(
                        page,
                        logPageVo.getStart(),
                        logPageVo.getEnd(),
                        logPageVo.getName(),
                        logPageVo.getIp(),
                        logPageVo.getOperation()
                )
        );
    }

    @Override
    public void truncate() {
        baseMapper.truncate();
    }

    @Override
    public List<LogBasicDto> queryLatest(int limit) {
        return baseMapper.queryLatest(limit);
    }
}