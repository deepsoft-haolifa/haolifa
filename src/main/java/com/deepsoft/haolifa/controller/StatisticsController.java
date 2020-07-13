package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.InvoiceListDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderConditionDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.order.OrderConditionDTO;
import com.deepsoft.haolifa.model.dto.order.OrderStatisticDTO;
import com.deepsoft.haolifa.model.vo.OrderAmountStatisticVo;
import com.deepsoft.haolifa.model.vo.PurchaseAmountStatisticVo;
import com.deepsoft.haolifa.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"统计类管理"})
@RestController
@RequestMapping("statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @ApiOperation("库房零件总金额")
    @GetMapping("/money/inventory")
    public ResultBean totalInventory() {
        return statisticsService.totalInventory();
    }

    @ApiOperation("生产订单总金额")
    @PostMapping("/money/orders")
    public ResultBean<OrderAmountStatisticVo> totalOrders(@RequestBody OrderConditionDTO model) {
        return ResultBean.success(statisticsService.totalOrders(model));
    }

    @ApiOperation("采购订单总金额")
    @PostMapping("/money/purchase")
    public ResultBean<PurchaseAmountStatisticVo> totalPurchase(@RequestBody PurchaseOrderConditionDTO model) {
        return ResultBean.success(statisticsService.totalPurchase(model));
    }


    @ApiOperation("发票总金额(1.经管；2. 财务)")
    @PostMapping("/money/invoice/{type}")
    public ResultBean totalInvoice(@PathVariable Byte type, @RequestBody InvoiceListDTO dto) {
        return ResultBean.success(statisticsService.totalInvoice(type, dto));
    }

    @ApiOperation("订单列表头部统计")
    @PostMapping("/order-product")
    public ResultBean totalOrderProduct(@RequestBody OrderStatisticDTO dto) {
        return ResultBean.success(statisticsService.totalOrderProduct(dto));
    }
}
