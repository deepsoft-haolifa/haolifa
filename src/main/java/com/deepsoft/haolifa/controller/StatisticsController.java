package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.InvoiceListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
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
  @GetMapping("/money/orders")
  public ResultBean totalOrders(){
    return statisticsService.totalOrders();
  }


  @ApiOperation("发票总金额(1.经管；2. 财务)")
  @GetMapping("/money/invoice/{type}")
  public ResultBean totalInvoice(@PathVariable Byte type){
    return ResultBean.success(statisticsService.totalInvoice(type));
  }

}
