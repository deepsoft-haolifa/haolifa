package com.deepsoft.haolifa.listener;

import com.deepsoft.haolifa.model.domain.SysLoginLog;
import com.deepsoft.haolifa.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步监听事件
 *
 * @author: murphy.he
 **/
@Component
@Slf4j
public class SyncEventListener {

    @Autowired
    private SysLogService sysLogService;


    /**
     * 异步添加登录操作 日志
     */
    @EventListener
    @Async
    public void addLoginLog(SysLoginLog sysLoginLog) {
        sysLogService.saveLogin(sysLoginLog);
    }

}
