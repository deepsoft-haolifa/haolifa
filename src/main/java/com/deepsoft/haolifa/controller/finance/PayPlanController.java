package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.domain.BizPayPlan;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanAddDTO;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanDTO;
import com.deepsoft.haolifa.service.finance.PayPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 付款计划
 */
@RestController
@RequestMapping("/finance/payplan")
@Api(tags = {"付款计划管理"})
public class PayPlanController {
    @Autowired
    private PayPlanService payPlanService;


    @ApiOperation("添加节点")
    @PostMapping("/save")
    public ResultBean save(@RequestBody BizPayPlanAddDTO model) {
        return payPlanService.save(model);
    }

    @ApiOperation("删除节点")
    @GetMapping("/delete/{payPlanId}")
    public ResultBean delete(@PathVariable("payPlanId") int id) {
        return payPlanService.delete(id);
    }

    @ApiOperation("更新节点")
    @PostMapping("/updatePayPlan")
    public ResultBean updatePayPlan(@RequestBody BizPayPlan payPlan) {
        return payPlanService.update(payPlan);
    }

    @ApiOperation("获取节点列表")
    @PostMapping("/getPayPlanList")
    public ResultBean getPayPlanList(@RequestBody BizPayPlanDTO payPlanDTO) {
        return payPlanService.getList(payPlanDTO);
    }


}
