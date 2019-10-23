package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.InvoiceListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.vo.InvoiceStatisticVo;

public interface StatisticsService {

  ResultBean totalInventory();

  ResultBean totalOrders();

  InvoiceStatisticVo totalInvoice(Byte type);
}
