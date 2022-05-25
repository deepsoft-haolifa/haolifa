package com.deepsoft.haolifa.task;

import com.deepsoft.haolifa.enums.BookingTypeEnum;
import com.deepsoft.haolifa.enums.PayWayEnum;
import com.deepsoft.haolifa.model.domain.BizPayPlan;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanPayDTO;
import com.deepsoft.haolifa.service.finance.BankBillService;
import com.deepsoft.haolifa.service.finance.BillService;
import com.deepsoft.haolifa.service.finance.OtherBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BillTask {

    @Autowired
    private BillService billService;

    @Autowired
    private BankBillService bankBillService;

    @Autowired
    private OtherBillService otherBillService;

    @Scheduled(cron = "0 0 0 26 * ?") //每月26号0点触发
    public void scheduleBill() {
        System.out.println("**触发JDK 定时器***");
        // 现金日记账
        billService.savePreMonthMoney();
        // 银行日记账
        bankBillService.savePreMonthMoney();
        // 其他货币日记账
        otherBillService.savePreMonthMoney();
    }


}
