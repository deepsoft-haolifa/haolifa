package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.domain.PurchaseOrder;
import com.deepsoft.haolifa.model.dto.PurchaseOrderCompleteDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PurcahseOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"采购订单管理"})
@RestController
@RequestMapping("purchase-order")
public class PurchaseOrderController {

  @Autowired
  private PurcahseOrderService purcahseOrderService;

  @ApiOperation("创建采购订单")
  @PostMapping("save/{orderType}")
  public ResultBean save(@RequestBody PurchaseOrderDTO model,@PathVariable("orderType") Integer orderType) {
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
  public ResultBean list(@ApiParam("页码") @RequestParam(defaultValue = "1") int pageNum,
      @ApiParam("展示条数") @RequestParam(defaultValue = "10") int pageSize,
      String orderNo, int createUserId, int status,
      @PathVariable("orderType") Integer orderType) {
    return purcahseOrderService.list(pageNum, pageSize, orderNo, createUserId,status,orderType);
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
}
