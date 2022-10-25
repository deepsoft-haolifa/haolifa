package com.deepsoft.haolifa.task;

import com.deepsoft.haolifa.service.finance.AssetsService;
import com.deepsoft.haolifa.service.finance.BankBillService;
import com.deepsoft.haolifa.service.finance.BillService;
import com.deepsoft.haolifa.service.finance.OtherBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AssetsTask {

    @Autowired
    private AssetsService assetsService;


    @Scheduled(cron = "0 0 0 26 * ?") //每月26号0点触发
    public void scheduleBill() {
        System.out.println("**触发JDK 定时器***");
        //
        assetsService.job();
    }


}
