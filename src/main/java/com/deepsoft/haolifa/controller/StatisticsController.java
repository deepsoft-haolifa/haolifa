package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("statistics")
public class StatisticsController {

  @Autowired
  private StatisticsService statisticsService;

  @GetMapping("/money/inventory")
  public ResultBean totalInventory() {
    return statisticsService.totalInventory();
  }

  @GetMapping("/money/orders")
  public ResultBean totalOrders(){
    return statisticsService.totalOrders();
  }




}
