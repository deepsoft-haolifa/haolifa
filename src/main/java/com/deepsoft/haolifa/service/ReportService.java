package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.ExportSaleDTO;

import java.util.List;

public interface ReportService {

//获取采购合同报表
  ResultBean selectBySupplierName(String purchase);
  ResultBean selectPurchase();
  //销售报表
  //获取目前总金额总数量
  List<ExportSaleDTO> selectAll();
  //根据月份获取总金额 总数量
  List<ExportSaleDTO> selectByMonth(String startTime,String endTime);

  //根据产品型号获取金额数量
  List<ExportSaleDTO> selectByModel();

}
