package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.SysLoginLog;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.SysLogConditionDTO;

public interface SysLogService {

    /**
     * 添加系统登录日志
     *
     * @param sysLoginLog
     */
    void saveLogin(SysLoginLog sysLoginLog);

    /**
     * 获取分页列表
     *
     * @return
     */
    PageDTO<SysLoginLog> pageLoginList(SysLogConditionDTO sysLogConditionDTO);

}
