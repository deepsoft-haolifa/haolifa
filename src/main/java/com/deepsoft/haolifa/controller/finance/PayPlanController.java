package com.deepsoft.haolifa.controller.finance;


import cn.hutool.core.convert.Convert;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.expenses.ExpensesConditionDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsRSDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsTypeRSDTO;
import com.deepsoft.haolifa.model.dto.finance.payplan.*;
import com.deepsoft.haolifa.service.finance.CostBudgetService;
import com.deepsoft.haolifa.service.finance.PayPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 付款计划
 */
@RestController
@RequestMapping("/finance/payplan")
@Api(tags = {"好利财务-付款计划管理"})
public class PayPlanController {
    @Autowired
    private PayPlanService payPlanService;


    @ApiOperation("添加节点")
    @PostMapping("/save")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean save(@RequestBody BizPayPlanAddDTO model) {
        return payPlanService.save(model);
    }

    @ApiOperation("删除节点")
    @GetMapping("/delete/{payPlanId}")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean delete(@PathVariable("payPlanId") int id) {
        return payPlanService.delete(id);
    }

    @ApiOperation("更新节点")
    @PostMapping("/updatePayPlan")
    public ResultBean updatePayPlan(@RequestBody BizPayPlanPayDTO payPlan) {
        return payPlanService.pay(payPlan);
    }

    @ApiOperation("获取节点列表")
    @PostMapping("/getPayPlanList")
    public ResultBean<BizPayPlanRSDTO> getPayPlanList(@RequestBody BizPayPlanRQDTO payPlanDTO) {
        return payPlanService.getList(payPlanDTO);
    }
    @ApiOperation("查询付款计划费用汇总(2023-03-20修改)")
    @PostMapping("/list-summary")
    public ResultBean<BigDecimal> listSummary(@RequestBody BizPayPlanRQDTO payPlanDTO) {
        return ResultBean.success(payPlanService.listSummary(payPlanDTO));
    }


    //
    @ApiOperation("获取所有支付方式节点列表")
    @GetMapping("/getAllPayWayList")
    public ResultBean<List<BookingTypeRSDTO>> getAllPayWayList() {
        return payPlanService.getAllPayWayList();
    }



    /**
     * 付款计划（确认）
     */
    @ApiOperation("付款计划（确认）")
    @PostMapping("/confirm")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean updateDateStatus(@RequestBody BizPayPlanConfirmRQDTO ids) {
        return payPlanService.updateDateStatus(ids.getIds());
    }




}
