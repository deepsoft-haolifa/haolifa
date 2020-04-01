package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.DemandAmountDto;
import com.deepsoft.haolifa.model.dto.export.ExportContractDTO;
import com.deepsoft.haolifa.model.dto.export.ExportPurchaseDTO;
import com.deepsoft.haolifa.model.dto.export.ExportSaleDTO;
import com.deepsoft.haolifa.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public ResultBean selectBySupplierName(String supplierName, String year) {
        Map<String, Object> paramMap = new HashMap<>();
        if (StrUtil.isNotBlank(supplierName)) {
            paramMap.put("supplierName", supplierName);
        }
        if (StrUtil.isNotBlank(year)) {
            paramMap.put("year", year);
        }
        List<ExportPurchaseDTO> exportPurchaseDTOS = purchaseReportMapper.selectBySupplierName(paramMap);
        paramMap.put("status", 5);
        List<ExportPurchaseDTO> exportPurchaseDTOS1 = purchaseReportMapper.selectPurchase(paramMap);
        if (CollUtil.isNotEmpty(exportPurchaseDTOS)) {
            for (ExportPurchaseDTO i : exportPurchaseDTOS) {
                String stringStream = exportPurchaseDTOS1.stream().filter(e -> e.getCreateTime().equals(i.getCreateTime())).map(ExportPurchaseDTO::getTotal).collect(Collectors.joining());
                i.setRegistered(stringStream);
            }
        }
        return ResultBean.success(exportPurchaseDTOS);
    }

    @Override
    public ResultBean selectPurchase(String year) {
        Map<String, Object> paramMap = new HashMap<>();
        if (StrUtil.isNotBlank(year)) {
            paramMap.put("year", year);
        }
        List<ExportPurchaseDTO> exportPurchaseDTOS = purchaseReportMapper.selectPurchase(paramMap);
        paramMap.put("status", 5);
        List<ExportPurchaseDTO> exportPurchaseDTOS1 = purchaseReportMapper.selectPurchase(paramMap);

        if (CollUtil.isNotEmpty(exportPurchaseDTOS)) {
            for (ExportPurchaseDTO i : exportPurchaseDTOS) {
                String stringStream = exportPurchaseDTOS1.stream().filter(e -> e.getSupplierName().equals(i.getSupplierName())).map(ExportPurchaseDTO::getTotal).collect(Collectors.joining());
                i.setRegistered(stringStream);
            }
        }
        return ResultBean.success(exportPurchaseDTOS);
    }

    @Override
    public List<ExportSaleDTO> selectAll(String year) {
        return saleReportMapper.selectAll(year);
    }

    @Override
    public List<ExportSaleDTO> selectByMonth(String startTime, String endTime) {
        return saleReportMapper.selectByMonth(startTime, endTime);
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
    public List<ExportContractDTO> selectInvoiceAmountByDemandName(String year) {
        return saleReportMapper.selectInvoiceAmountByDemandName(year);
    }

    @Override
    public List<ExportContractDTO> selectDeliveryAmountByDemandName(String year) {
        return saleReportMapper.selectDeliveryAmountByDemandName(year);
    }

    @Override
    public List<DemandAmountDto> selectAllAmountByDemandName(@Param("year") String year) {
        List<DemandAmountDto> list = new ArrayList<>();
        List<ExportContractDTO> invoice = saleReportMapper.selectInvoiceAmountByDemandName(year);
        List<ExportContractDTO> delivery = saleReportMapper.selectDeliveryAmountByDemandName(year);
        List<ExportContractDTO> refund = saleReportMapper.selectshouhuiContractByDemandName(year);
        List<ExportContractDTO> sale = saleReportMapper.selectContractByDemandName(year);

        Set<String> demandSet = invoice.stream().map(ExportContractDTO::getDemandName).collect(Collectors.toSet());
        Set<String> demand1Set = delivery.stream().map(ExportContractDTO::getDemandName).collect(Collectors.toSet());
        Set<String> demand2Set = refund.stream().map(ExportContractDTO::getDemandName).collect(Collectors.toSet());
        Set<String> demand3Set = sale.stream().map(ExportContractDTO::getDemandName).collect(Collectors.toSet());
        demandSet.addAll(demand1Set);
        demandSet.addAll(demand2Set);
        demandSet.addAll(demand3Set);

        for (String demandName : demandSet) {
            DemandAmountDto demandAmountDto = new DemandAmountDto();
            demandAmountDto.setDemandName(demandName);
            demandAmountDto.setYear(year);
            demandAmountDto.setSaleAmount(sale.stream().filter(e -> e.getDemandName().equals(demandName)).mapToDouble(ExportContractDTO::getTotalPrice).sum());
            demandAmountDto.setInvoiceAmount(invoice.stream().filter(e -> e.getDemandName().equals(demandName)).mapToDouble(ExportContractDTO::getTotalPrice).sum());
            demandAmountDto.setRefundAmount(refund.stream().filter(e -> e.getDemandName().equals(demandName)).mapToDouble(ExportContractDTO::getTotalPrice).sum());
            demandAmountDto.setDeliveryAmount(delivery.stream().filter(e -> e.getDemandName().equals(demandName)).mapToDouble(ExportContractDTO::getTotalPrice).sum());
            list.add(demandAmountDto);
        }
        return list;
    }

    @Override
    public List<ExportSaleDTO> selectByModel(String year) {
        return saleReportMapper.selectByModel(year);
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
    public List<ExportSaleDTO> selectAllContract(String year) {
        return saleReportMapper.selectAllContract(year);
    }

    @Override
    public List<ExportSaleDTO> selectByMonthContract(String startTime, String endTime) {
        return saleReportMapper.selectByMonthContract(startTime, endTime);
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
