package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;

public interface StatisticsService {

  ResultBean totalInventory();

  ResultBean totalOrders();

  Double totalInvoice();
}
