package com.deepsoft.haolifa.finance;

import com.deepsoft.haolifa.BaseTest;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.enums.OrderPayStatusEnum;
import com.deepsoft.haolifa.enums.PayApplyPayStatusEnum;
import com.deepsoft.haolifa.model.domain.BizPayApply;
import com.deepsoft.haolifa.model.domain.BizPayPlan;
import com.deepsoft.haolifa.model.domain.BizPayPlanExample;
import com.deepsoft.haolifa.model.domain.PurchaseOrder;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.BankBillService;
import com.deepsoft.haolifa.service.finance.BillService;
import com.deepsoft.haolifa.service.finance.OtherBillService;
import com.deepsoft.haolifa.service.finance.PayPlanService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PayPlanServiceTest extends BaseTest {
    @Autowired
    private BizPayPlanMapper bizPayPlanMapper;
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private SysDictService sysDictService;

    @Autowired
    private BizPayPlanPayLogMapper bizPayPlanPayLogMapper;

    @Autowired
    private BizBillMapper bizBillMapper;

    @Autowired
    private BizBankBillMapper bizBankBillMapper;

    @Autowired
    private BizOtherBillMapper bizOtherBillMapper;

    @Autowired
    private BillService billService;

    @Autowired
    private BankBillService bankBillService;

    @Autowired
    private OtherBillService otherBillService;
    @Autowired
    private BizPayApplyDetailMapper bizPayApplyDetailMapper;
    @Autowired
    private BizPayApplyMapper bizPayApplyMapper;
    @Autowired
    private PayPlanService payPlanService;

    @Test
    public void t1() {
        BizPayApply bizPayApply = bizPayApplyMapper.selectByPrimaryKey(25);

        BizPayPlanExample bizPayPlanExample = new BizPayPlanExample();
        BizPayPlanExample.Criteria criteria = bizPayPlanExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
        // 申请编号 ==
        criteria.andPayDataIdEqualTo(25L);
        List<BizPayPlan> bizPayPlanList = bizPayPlanMapper.selectByExample(bizPayPlanExample);
        BigDecimal bigDecimal = bizPayPlanList.stream()
            .map(BizPayPlan::getApplyAmount)
            .reduce(BigDecimal::add)
            .get();

        boolean match = bizPayPlanList.stream().allMatch(p -> StringUtils.equalsIgnoreCase(p.getStatus(), "2"));
        if (match){
            BizPayApply payApply = new BizPayApply();
            payApply.setStatus(PayApplyPayStatusEnum.PAYMENT_COMPLETED.getCode());
            payApply.setId(bizPayApply.getId());
//            bizPayApplyMapper.updateByPrimaryKeySelective(payApply);
        }
    }
    @Test
    public void t2() {

        List<Integer> id = new ArrayList<>();
        id.add(10);
        ResultBean resultBean = payPlanService.updateDateStatus(id);


        System.out.println(1);
    }

}
