package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.domain.PurchaseOrder;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.ApplyBuyService;
import com.deepsoft.haolifa.service.PurcahseOrderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(tags = {"采购订单管理"})
@RestController
@RequestMapping("purchase-order")
public class PurchaseOrderController {

    @Autowired
    private PurcahseOrderService purcahseOrderService;
    @Autowired
    private ApplyBuyService applyBuyService;

    @ApiOperation("创建采购订单")
    @PostMapping("save/{orderType}")
    public ResultBean save(@RequestBody PurchaseOrderDTO model, @PathVariable("orderType") Integer orderType) {
        return purcahseOrderService.save(model, orderType);
    }

    @ApiOperation("删除采购订单")
    @GetMapping("delete/{purchaseOrderNo}")
    public ResultBean save(@PathVariable("purchaseOrderNo") String purchaseOrderNo) {
        return purcahseOrderService.delete(purchaseOrderNo);
    }

    @ApiOperation("删除采购订单单项")
    @GetMapping("deleteItem/{purchaseOrderNo}/{materialGraphNo}")
    public ResultBean deleteItem(@PathVariable("purchaseOrderNo") String purchaseOrderNo,
                                 @PathVariable("materialGraphNo") String materialGraphNo) {
        return purcahseOrderService.deleteItem(purchaseOrderNo, materialGraphNo);
    }

    @ApiOperation("修改采购订单,待完善")
    @PostMapping("update")
    public ResultBean update(@RequestBody PurchaseOrderDTO model) {
        return purcahseOrderService.update(model);
    }

    @ApiOperation("查询订单详情")
    @GetMapping("info/{formId}")
    public ResultBean getInfo(@PathVariable("formId") Integer id) {
        return purcahseOrderService.getInfo(id);
    }

    @ApiOperation("查询采购订单列表")
    @GetMapping("list/{orderType}")
    public ResultBean<PageDTO<PurchaseOrder>> list(@ApiParam("页码") @RequestParam(defaultValue = "1") int pageNum,
                                                   @ApiParam("展示条数") @RequestParam(defaultValue = "10") int pageSize,
                                                   String orderNo, int createUserId, int status,
                                                   @PathVariable("orderType") Integer orderType,
                                                   String supplierName,
                                                   String startDate,
                                                   String endDate) {
        return purcahseOrderService.list(pageNum, pageSize, orderNo, createUserId, status, orderType, supplierName, startDate, endDate);
    }

    @ApiOperation("查询采购订单列表（采购付款专用）")
    @PostMapping("/payPlanlist")
    public ResultBean<PageDTO<PurchaseOrderRSDTO>> payPlanlist(@RequestBody PurchaseOrderRQParam param) {
        return purcahseOrderService.payPlanlist(param);
    }

    @ApiOperation("采购完成")
    @PostMapping("complete")
    public ResultBean complete(@RequestBody PurchaseOrderCompleteDTO model) {
        return purcahseOrderService.complete(model);
    }

    @ApiOperation("发起审批")
    @GetMapping("approve/{orderNo}/{orderType}")
    public ResultBean approve(@ApiParam("订单号") @PathVariable("orderNo") String orderNo,
                              @ApiParam("订单类型") @PathVariable("orderType") Integer orderType) {
        return purcahseOrderService.approve(orderNo, orderType);
    }

    @ApiOperation("生成报检单")
    @GetMapping("createInspect/{formId}")
    public ResultBean createInspect(@PathVariable("formId") Integer formId) {
        return purcahseOrderService.createInspect(formId);
    }

    @ApiOperation("合并待采购之后进行创建采购订单--applyBuyIds表示待采购列表等id 多个逗号分隔")
    @PostMapping("save/{orderType}/{applyBuyIds}")
    public ResultBean save(@RequestBody PurchaseOrderDTO model, @PathVariable("orderType") Integer orderType, @PathVariable("applyBuyIds") String applyBuyIds) {
        String[] strings = applyBuyIds.split(",");
        for (String string : strings) {
            Integer itemId = Integer.parseInt(string);
            applyBuyService.updateStatus(itemId);
        }
        return purcahseOrderService.save(model, orderType);
    }

    @ApiOperation("获取采购订单详情")
    @GetMapping("/details")
    @ApiImplicitParam(name = "purchaseOrderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    public ResultBean details(String purchaseOrderNo) {
        return ResultBean.success(purcahseOrderService.details(purchaseOrderNo));
    }
}
