package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;

public interface ReportService {

//获取采购合同报表
  ResultBean selectBySupplierName(String purchase);
  ResultBean selectPurchase();

}
