package com.slipper.modules.log.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.common.utils.RPage;
import com.slipper.modules.log.entity.LogEntity;
import com.slipper.modules.log.model.dto.LogBasicDto;
import com.slipper.modules.log.model.dto.LogDto;
import com.slipper.modules.log.model.vo.LogPageVo;

import java.util.List;

/**
 * 日志
 *
 * @author gumingchen
 * @email 1240235512@qq.com
 * @date 1995-08-30 00:00:00
 */
public interface LogService extends IService<LogEntity> {

    /**
     * 分页
     * @param logPageVo 分页参数
     * @return
     */
    RPage<LogDto> queryPage(LogPageVo logPageVo);

    /**
     * 日志清理
     */
    void truncate ();

    /**
     * 获取最近操作日志
     * @param limit 数量
     * @return
     */
    List<LogBasicDto> queryLatest(int limit);

}

