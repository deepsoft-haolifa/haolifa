package com.deepsoft.haolifa.task;

import com.deepsoft.haolifa.service.BusinessAnalysisService;
import com.deepsoft.haolifa.util.DistributedLocker;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 首页的数据统计
 */
@Component
public class BusinessAnalysisTask {
    @Resource
    private DistributedLocker distributedLocker;
    @Resource
    private BusinessAnalysisService businessAnalysisService;

    /**
     * 计算期初库存数据
     */
    @Scheduled(cron = "0 0 0/2 * * ?")
    public void task() {
        String task = distributedLocker.lock("BusinessAnalysisTask", 100);
        if (!StringUtils.isEmpty(task)) {
            //do task
            businessAnalysisService.get(null);
        }
    }


}
