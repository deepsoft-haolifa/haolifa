package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.ExportContractDTO;
import com.deepsoft.haolifa.model.dto.export.ExportSaleDTO;
import com.deepsoft.haolifa.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReportServiceImpl extends BaseService implements ReportService {

  @Autowired
  private PurchaseReportMapper purchaseReportMapper;
  @Autowired
  private SaleReportMapper saleReportMapper;
  @Autowired
  private QualityEntrustReportMapper qualityEntrustReportMapper;
  @Autowired
  private QualityPressureReportMapper qualityPressureReportMapper;
  @Autowired
  private QualitySprayReportMapper qualitySprayReportMapper;
  @Autowired
  private QualityAuditReportMapper qualityAuditReportMapper;
  @Autowired
  private QualityInspecReportMapper qualityInspecReportMapper;
  @Autowired
  private QualityProductReportMapper qualityProductReportMapper;
  @Override
  public ResultBean selectBySupplierName(String supplierName){
    return  ResultBean.success(purchaseReportMapper.selectBySupplierName(supplierName));
  }
  @Override
  public ResultBean selectPurchase(){
    return  ResultBean.success(purchaseReportMapper.selectPurchase());
  }

  @Override
  public List<ExportSaleDTO> selectAll(String year) {
    return saleReportMapper.selectAll(year);
  }

  @Override
  public List<ExportSaleDTO> selectByMonth(String startTime, String endTime) {
    return saleReportMapper.selectByMonth(startTime,endTime);
  }

    @Override
    public List<ExportContractDTO> selectContractByDemandName(String year) {
        return saleReportMapper.selectContractByDemandName(year);
    }
    @Override
    public List<ExportContractDTO> selectshouhuiContractByDemandName(String year) {
        return saleReportMapper.selectshouhuiContractByDemandName(year);
    }
    @Override
  public List<ExportSaleDTO> selectByModel() {
    return saleReportMapper.selectByModel();
  }

  @Override
  public QualityEntrustReport selectByType(Integer type) {
    return qualityEntrustReportMapper.selectByType(type);
  }

  @Override
  public QualitySprayReport selectSpray() {
    return qualitySprayReportMapper.selectSpray();
  }

  @Override
  public QualityPressureReport selectPressure() {
    return qualityPressureReportMapper.selectPressure();
  }
  @Override
  public List<QualityPressureReport> selectPressureByReason() {
    return qualityPressureReportMapper.selectPressureByReason();
  }

  @Override
  public List<QualityAuditReport> selectAudit() {
    return qualityAuditReportMapper.selectAudit();
  }

  @Override
  public QualityInspectReport selectInspect() {
    return qualityInspecReportMapper.selectInspect();
  }
  @Override
  public List<QualityInspectReport> selectInspectBySupplierName() {
    return qualityInspecReportMapper.selectInspectBySupplierName();
  }
  @Override
  public List<QualityInspectReport> selectInspectByMaterialName() {
    return qualityInspecReportMapper.selectInspectByMaterialName();
  }
  @Override
  public List<ExportSaleDTO> selectAllContract() {
    return saleReportMapper.selectAllContract();
  }

  @Override
  public List<ExportSaleDTO> selectByMonthContract(String startTime, String endTime) {
    return saleReportMapper.selectByMonthContract(startTime,endTime);
  }

  @Override
  public List<ExportSaleDTO> selectByModelContract() {
    return saleReportMapper.selectByModelContract();
  }

    @Override
    public QualityProductReport selectProduct() {
        return qualityProductReportMapper.selectProduct();
    }
}
