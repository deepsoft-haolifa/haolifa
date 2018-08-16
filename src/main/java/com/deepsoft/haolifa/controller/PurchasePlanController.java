package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.PurchasePlanDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PurchasePlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"采购计划管理"})
@RestController
@RequestMapping("purchase-plan")
public class PurchasePlanController {

    @Autowired
    private PurchasePlanService purchasePlanService;

    @ApiOperation("创建采购计划")
    @PostMapping("save")
    public ResultBean createPurchasePlan(@RequestBody PurchasePlanDTO model) {
        return purchasePlanService.save(model);
    }

    @ApiOperation("删除采购计划")
    @GetMapping("delete/{purchasePlanNo}")
    public ResultBean delete(@PathVariable("purchasePlanNo") String purchasePlanNo) {
        return purchasePlanService.delete(purchasePlanNo);
    }

    @ApiOperation("删除采购计划单项")
    @GetMapping("deleteItem/{purchasePlanNo}/{materialGraphNo}")
    public ResultBean deleteItem(@PathVariable("purchasePlanNo") String purchasePlanNo, @PathVariable("materialGraphNo") String materialGraphNo) {
        return purchasePlanService.deleteItem(purchasePlanNo,materialGraphNo);
    }

    @ApiOperation("更新采购计划时间")
    @PostMapping("updateExpectedTime")
    public ResultBean updateExpectedTime(@RequestBody PurchasePlanDTO model) {
        return purchasePlanService.updateExpectedTime(model);
    }

    @ApiOperation("更新采购计划单项")
    @PostMapping("updatePurchaseItem")
    public ResultBean updatePurchaseItem(@RequestBody PurchasePlanDTO model) {
        return purchasePlanService.updatePurchaseItem(model);
    }

    @ApiOperation("查询采购计划列表")
    @GetMapping("list")
    public ResultBean getList(@RequestParam Integer currentPage, @RequestParam Integer pageSize, String productOrderNo) {
        return purchasePlanService.getList(currentPage, pageSize, productOrderNo);
    }

    @ApiOperation("查询采购计划详情")
    @GetMapping("info/{purchasePlanNo}")
    public ResultBean getInfo(@PathVariable("purchasePlanNo") String purchasePlanNo) {
        return purchasePlanService.getInfo(purchasePlanNo);
    }

    // TODO 涉及流程初始化
    @ApiOperation("发起审批")
    @GetMapping("initiateApproval/{purchasePlanNo}")
    public ResultBean initiateApproval(@PathVariable("purchasePlanNo") String purchasePlanNo){
        return null;
    }

    @ApiOperation("撤销审批")
    @GetMapping("cancelApproval/{purchasePlanNo}")
    public ResultBean cancelApproval(@PathVariable("purchasePlanNo") String purchasePlanNo){
        return null;
    }

}
