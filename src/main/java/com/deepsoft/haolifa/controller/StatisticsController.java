package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
