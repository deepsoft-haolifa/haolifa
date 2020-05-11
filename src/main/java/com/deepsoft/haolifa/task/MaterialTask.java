package com.deepsoft.haolifa.task;

import com.deepsoft.haolifa.util.DistributedLocker;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 零件相关定时任务
 */
@Component
public class MaterialTask {
    @Resource
    private DistributedLocker distributedLocker;

    /**
     * 计算期初库存数据
     */
//    @Scheduled(cron = "0 0 0/1 * * ?")
    public void task() {
        String task = distributedLocker.lock("task", 3);
        if (!StringUtils.isEmpty(task)) {
         //do task
        }
    }


}
