package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.payplan.*;
import com.deepsoft.haolifa.service.finance.PayPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @Transactional(rollbackFor = Exception.class)
    public ResultBean updatePayPlan(@RequestBody BizPayPlanPayDTO payPlan) {
        return payPlanService.update(payPlan);
    }

    @ApiOperation("获取节点列表")
    @PostMapping("/getPayPlanList")
    public ResultBean<BizPayPlanRSDTO> getPayPlanList(@RequestBody BizPayPlanRQDTO payPlanDTO) {
        return payPlanService.getList(payPlanDTO);
    }

    @ApiOperation("获取应付汇总节点列表")
    @PostMapping("/summary/getPayPlanList")
    public ResultBean<BizPayPlanSummaryRSDTO> getPayPlanSummaryList(@RequestBody BizPayPlanSummaryRQDTO payPlanDTO) {
        return payPlanService.getPayPlanSummaryList(payPlanDTO);
    }


    //
    @ApiOperation("获取所有支付方式节点列表")
    @GetMapping("/getAllPayWayList")
    public ResultBean<BookingTypeRSDTO> getAllPayWayList() {
        return payPlanService.getAllPayWayList();
    }


}
