package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.SysLog;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.SysLogConditionDTO;

public interface SysLogService {

    /**
     * 添加系统日志
     *
     * @param sysLog
     */
    void save(SysLog sysLog);

    /**
     * 获取分页列表
     *
     * @return
     */
    PageDTO<SysLog> pageList(SysLogConditionDTO sysLogConditionDTO);

}
