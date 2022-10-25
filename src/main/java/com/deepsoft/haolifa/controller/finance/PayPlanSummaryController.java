package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanSummaryRQDTO;
import com.deepsoft.haolifa.service.finance.PayPlanService;
import com.deepsoft.haolifa.service.finance.SumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 应付汇总
 */
@RestController
@RequestMapping("/finance")
@Api(tags = {"好利财务-应付汇总管理"})
public class PayPlanSummaryController {
    @Autowired
    private PayPlanService payPlanService;

    @Autowired
    private SumService sumService;


    @ApiOperation("获取节点列表")
    @PostMapping("/payplansummary/getPayPlanList")
    public ResultBean getPayPlanList(@RequestBody BizPayPlanSummaryRQDTO rqdto) {
        return payPlanService.getPayPlanSummaryList(rqdto);
    }


}
