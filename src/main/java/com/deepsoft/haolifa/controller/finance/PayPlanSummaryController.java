package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanRQDTO;
import com.deepsoft.haolifa.service.finance.PayPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 应付汇总 todo  未完成
 */
@RestController
@RequestMapping("/finance/payplansummary")
@Api(tags = {"好利财务-应付汇总管理"})
public class PayPlanSummaryController {
    @Autowired
    private PayPlanService payPlanService;


    @ApiOperation("获取节点列表")
    @PostMapping("/getPayPlanList")
    public ResultBean getPayPlanList(@RequestBody BizPayPlanRQDTO payPlanDTO) {
        return payPlanService.getList(payPlanDTO);
    }


}
