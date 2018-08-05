package com.deepsoft.haolifa.task;

import com.deepsoft.haolifa.util.DistributedLocker;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author zhaozhihong
 * @create 2018-07-05 21:35
 * @desc
 **/
@Component
public class DemoTask {
    @Resource
    private DistributedLocker distributedLocker;

    /**
     * 示例定时任务
     */
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void task() {
        String task = distributedLocker.lock("task", 3);
        if (!StringUtils.isEmpty(task)) {
         //do task
        }
    }
}