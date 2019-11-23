package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.ExportSaleDTO;
import io.swagger.models.auth.In;

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
  //获取目前合同总金额总数量
  List<ExportSaleDTO> selectAllContract();
  //根据月份获取合同总金额 总数量
  List<ExportSaleDTO> selectByMonthContract(String startTime,String endTime);

  //根据产品型号合同获取金额数量
  List<ExportSaleDTO> selectByModelContract();


  //根据加工类型查询加工质量报表
  QualityEntrustReport selectByType(Integer type);
  //p喷涂质量报表
  QualitySprayReport selectSpray();
  //压力质量报表
  QualityPressureReport selectPressure();
  //更换料报表
  List<QualityAuditReport> selectAudit();
  //零件采购质量报表
  QualityInspectReport selectInspect();

}
