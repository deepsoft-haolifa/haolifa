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
import org.springframework.stereotype.Component;

@Component
public class BillTask {

    @Autowired
    private BillService billService;

    @Autowired
    private BankBillService bankBillService;

    @Autowired
    private OtherBillService otherBillService;

    //    @Scheduled(cron = "0 0 0 26 * ? *") //每月26号0点触发
    public void scheduleGetUserList() {
        System.out.println("**触发JDK 定时器***");
//
//        // 现金日记账
//        BizBillAddDTO bizBill = buildBizBillAddDTO(bizPayPlan, payWayDTO, bookingTypeEnum);
//        billService.save(bizBill);
//
//        // 银行日记账
//        BizBankBillAddDTO bizBankBillAddDTO = buildBizBankBillAddDTO(bizPayPlan, payWayDTO, bookingTypeEnum);
//        bankBillService.save(bizBankBillAddDTO);
//
//        // 其他货币日记账
//        BizOtherBillAddDTO bizBillAddDTO = buildBizOtherBillAddDTO(bizPayPlan, payWayDTO, bookingTypeEnum);
//        otherBillService.save(bizBillAddDTO);
    }


    private BizOtherBillAddDTO buildBizOtherBillAddDTO(BizPayPlan bizPayPlan, BizPayPlanPayDTO.PayWayDTO payWayDTO, BookingTypeEnum bookingTypeEnum) {
        BizOtherBillAddDTO otherBillAddDTO = new BizOtherBillAddDTO();
        // 付款
        otherBillAddDTO.setType("2");
        otherBillAddDTO.setCompany(bizPayPlan.getPayCompany());
        otherBillAddDTO.setAccount(bizPayPlan.getPayAccount());
        otherBillAddDTO.setCertificateNumber(bizPayPlan.getApplyNo());
        otherBillAddDTO.setOperateDate(bizPayPlan.getPayDate());
        otherBillAddDTO.setPayWay(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        otherBillAddDTO.setPaymentType(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        otherBillAddDTO.setPayment(payWayDTO.getAmount());
        otherBillAddDTO.setRemark(bizPayPlan.getRemark());
        otherBillAddDTO.setPayCompany(bizPayPlan.getPayCompany());
        otherBillAddDTO.setPayAccount(bizPayPlan.getPayAccount());
        otherBillAddDTO.setCollectCompany(bizPayPlan.getApplyCollectionCompany());
        return otherBillAddDTO;
    }

    private BizBankBillAddDTO buildBizBankBillAddDTO(BizPayPlan bizPayPlan, BizPayPlanPayDTO.PayWayDTO payWayDTO, BookingTypeEnum bookingTypeEnum) {
        BizBankBillAddDTO bizBankBill = new BizBankBillAddDTO();
        // 付款
        bizBankBill.setType("2");
        bizBankBill.setCompany(bizPayPlan.getPayCompany());
        bizBankBill.setAccount(bizPayPlan.getPayAccount());
        bizBankBill.setCertificateNumber(bizPayPlan.getApplyNo());
        bizBankBill.setOperateDate(bizPayPlan.getPayDate());
        bizBankBill.setPayWay(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        bizBankBill.setPaymentType(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        bizBankBill.setPayment(payWayDTO.getAmount());
        bizBankBill.setRemark(bizPayPlan.getRemark());
        bizBankBill.setPayCompany(bizPayPlan.getPayCompany());
        bizBankBill.setPayAccount(bizPayPlan.getPayAccount());
        bizBankBill.setCollectCompany(bizPayPlan.getApplyCollectionCompany());
        return bizBankBill;
    }

    private BizBillAddDTO buildBizBillAddDTO(BizPayPlan bizPayPlan, BizPayPlanPayDTO.PayWayDTO payWayDTO, BookingTypeEnum bookingTypeEnum) {
        BizBillAddDTO bizBill = new BizBillAddDTO();
        bizBill.setType(bookingTypeEnum.getCode());
        bizBill.setCertificateNumber(bizPayPlan.getApplyNo());
        bizBill.setD(bizPayPlan.getPayDate());
        // todo
        bizBill.setPaymentType(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        bizBill.setPayment(payWayDTO.getAmount());
        bizBill.setRemark(bizPayPlan.getRemark());
        bizBill.setString1(bizPayPlan.getApplyCollectionCompany());
        bizBill.setString2(bizPayPlan.getPayCompany());
        return bizBill;
    }

}
