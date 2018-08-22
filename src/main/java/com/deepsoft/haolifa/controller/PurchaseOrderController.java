package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.PurchaseOrderDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PurcahseOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"采购订单管理"})
@RestController
@RequestMapping("purchase-order")
public class PurchaseOrderController {

    @Autowired
    private PurcahseOrderService purcahseOrderService;

    @ApiOperation("创建采购订单")
    @PostMapping("save")
    public ResultBean save(@RequestBody PurchaseOrderDTO model){
        return purcahseOrderService.save(model);
    }

    @ApiOperation("删除采购订单")
    @GetMapping("delete/{purchaseOrderNo}")
    public ResultBean save(@PathVariable("purchaseOrderNo") String purchaseOrderNo){
        return purcahseOrderService.delete(purchaseOrderNo);
    }

    @ApiOperation("删除采购订单单项(功能是否需要待定)")
    @GetMapping("deleteItem/{purchaseOrderNo}/{materialGraphNo}")
    public ResultBean deleteItem(@PathVariable("purchaseOrderNo") String purchaseOrderNo,@PathVariable("materialGraphNo") String materialGraphNo){
        return purcahseOrderService.deleteItem(purchaseOrderNo,materialGraphNo);
    }

    @ApiOperation("修改采购订单")
    @PostMapping("update")
    public ResultBean update(@RequestBody PurchaseOrderDTO model){
        return purcahseOrderService.update(model);
    }

    @ApiOperation("查询订单详情")
    @GetMapping("info/{purchaseOrderNo}")
    public ResultBean getInfo(@PathVariable("purchaseOrderNo") String purchaseOrderNo){
        return purcahseOrderService.getInfo(purchaseOrderNo);
    }

    @ApiOperation("查询订单列表")
    @PostMapping("list")
    public ResultBean getInfo(@RequestBody PurchaseOrderListDTO model){
        return purcahseOrderService.getList(model);
    }
}
