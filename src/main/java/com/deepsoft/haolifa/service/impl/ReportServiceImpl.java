package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.dao.repository.extend.QualityReportMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.*;
import com.deepsoft.haolifa.model.dto.report.ReportBaseDTO;
import com.deepsoft.haolifa.service.ReportService;
import com.deepsoft.haolifa.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Struct;
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
    @Autowired
    private QualityReportMapper qualityReportMapper;

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
                List<String> collect = exportPurchaseDTOS1.stream().filter(e -> e.getCreateTime().equals(i.getCreateTime())).map(ExportPurchaseDTO::getTotal).collect(Collectors.toList());
                if (CollUtil.isNotEmpty(collect)) {
                    i.setRegistered(collect.get(0));
                }
            }
        }
        return ResultBean.success(exportPurchaseDTOS);
    }

    @Override
    public ResultBean selectPurchase(String year, String month) {
        Map<String, Object> paramMap = CommonUtil.packMapParam(year, month);
        List<ExportPurchaseDTO> exportPurchaseDTOS = purchaseReportMapper.selectPurchase(paramMap);
        paramMap.put("status", 5);
        List<ExportPurchaseDTO> exportPurchaseDTOS1 = purchaseReportMapper.selectPurchase(paramMap);

        if (CollUtil.isNotEmpty(exportPurchaseDTOS)) {
            for (ExportPurchaseDTO i : exportPurchaseDTOS) {
                List<String> collect = exportPurchaseDTOS1.stream().filter(e -> e.getSupplierName().equals(i.getSupplierName())).map(ExportPurchaseDTO::getTotal).collect(Collectors.toList());
                if (CollUtil.isNotEmpty(collect)) {
                    i.setRegistered(collect.get(0));
                }
            }
        }
        return ResultBean.success(exportPurchaseDTOS);
    }

    @Override
    public ResultBean selectAllPurchase(String year) {
        Map<String, Object> paramMap = new HashMap<>();
        if (StrUtil.isNotBlank(year)) {
            paramMap.put("year", year);
        }
        // 查询合同总金额和已付总金额
        List<ExportPurchaseDTO> exportPurchaseDTOS = purchaseReportMapper.selectAllPurchase(paramMap);
        paramMap.put("status", 5);
        // 查询已挂账金额
        List<ExportPurchaseDTO> exportPurchaseDTOS1 = purchaseReportMapper.selectAllPurchase(paramMap);
        // 查询已回款金额
        List<ExportPurchaseDTO> exportPurchaseDTOS2 = purchaseReportMapper.selectInvoicePurchase(paramMap);
        if (CollUtil.isNotEmpty(exportPurchaseDTOS)) {
            for (ExportPurchaseDTO i : exportPurchaseDTOS) {
                List<String> collect = exportPurchaseDTOS1.stream().filter(e -> e.getCreateTime().equals(i.getCreateTime())).map(ExportPurchaseDTO::getTotal).collect(Collectors.toList());
                if (CollUtil.isNotEmpty(collect)) {
                    i.setRegistered(collect.get(0));
                }
                List<String> collect1 = exportPurchaseDTOS2.stream().filter(e -> e.getCreateTime().equals(i.getCreateTime())).map(ExportPurchaseDTO::getCollected).collect(Collectors.toList());
                if (CollUtil.isNotEmpty(collect1)) {
                    i.setCollected(collect1.get(0));
                }
            }
        }
        return ResultBean.success(exportPurchaseDTOS);
    }

    @Override
    public List<ExportSaleDTO> selectAll(String year) {
        return saleReportMapper.selectAll(year);
    }

    @Override
    public String selectByMonth(String startTime, String endTime) {
        return saleReportMapper.selectByMonth(startTime, endTime);
    }

    @Override
    public Map<String, List<ExportContractDTO>> selectContractByDemandName(String year) {
        Map<String, Object> packMapParam = CommonUtil.packYearMapParam(year);
        List<ExportContractDTO> exportContractDTOS = saleReportMapper.selectContractByDemandName(packMapParam);

        Map<String, Object> lastYearPackMapParam = CommonUtil.packYearMapParam(year);
        List<ExportContractDTO> lastYearExportContractDTOS = saleReportMapper.selectContractByDemandName(lastYearPackMapParam);

        exportContractDTOS.addAll(lastYearExportContractDTOS);
        return exportContractDTOS.stream().collect(Collectors.groupingBy(ExportContractDTO::getYear));

    }

    @Override
    public List<ExportContractDTO> selectContractByDemandNameByMonth(ReportBaseDTO baseDTO){
        Map<String, Object> paramMap = CommonUtil.packYearMonthMapParam(baseDTO.getStartDate(), baseDTO.getEndDate());
        return saleReportMapper.selectContractByDemandNameMonth(paramMap);
    }
    @Override
    public List<ExportContractDTO> selectshouhuiContractByDemandName(String year, String month) {
        Map<String, Object> packMapParam = CommonUtil.packMapParam(year, month);
        return saleReportMapper.selectshouhuiContractByDemandName(packMapParam);
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
        List<ExportContractDTO> refund = this.selectshouhuiContractByDemandName(year, "");
        Map<String, Object> packMapParam = CommonUtil.packYearMapParam(year);
        List<ExportContractDTO> sale  = saleReportMapper.selectContractByDemandName(packMapParam);

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
    public List<ReportAssemblingReasonDto> assemblingReason() {
        List<String> list = qualityReportMapper.selectAssemblingReason();

        Map<String, Integer> haspMap = new HashMap<>();
        for (String s : list) {
            boolean b = JSONUtil.isJsonArray(s);
            if (!b) {
                continue;
            }
            JSONArray jsonArray = JSONUtil.parseArray(s);
            for (Object o : jsonArray) {
                JSONObject jsonObject = JSONUtil.parseObj(o);
                String reason = jsonObject.getStr("reason");
                if (reason.contains(",")) {
                    String[] split = reason.split(",");
                    reason = split[0];
                }
                if (StrUtil.isBlank(reason)) {
                    continue;
                }
                Integer number = jsonObject.getInt("number");
                if (!haspMap.containsKey(reason)) {
                    haspMap.put(reason, number);
                } else {
                    Integer num = haspMap.get(reason);
                    haspMap.put(reason, num + number);
                }
            }
        }
        List<ReportAssemblingReasonDto> resultList = new ArrayList<>();

        Iterator it = haspMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            Integer number = (Integer) entry.getValue();
            ReportAssemblingReasonDto reportAssemblingReasonDto = new ReportAssemblingReasonDto();
            reportAssemblingReasonDto.setReason(key);
            reportAssemblingReasonDto.setQty(number);
            resultList.add(reportAssemblingReasonDto);
        }
        return resultList;
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

    @Override
    public QualityProductReport selectInspectByType(int type) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("type", type);
        return qualityReportMapper.selectInspectHistoryByType(paramMap);
    }

    @Override
    public List<TotalQualityReportDto> selectAllQuality(String year) {
        List<TotalQualityReportDto> list = new ArrayList<>();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("year", year);
        List<QualityProductReport> purchasePass = qualityReportMapper.selectPurchasePassByMonth(paramMap);
        List<QualityProductReport> inspectPass = qualityReportMapper.selectInspectPassByMonth(paramMap);
        List<QualityProductReport> sparyPass = qualityReportMapper.selectSparyPassByMonth(paramMap);
        List<QualityProductReport> proInspectPass = qualityReportMapper.selectProInspectPassByMonth(paramMap);
        Set<String> createTime = purchasePass.stream().map(QualityProductReport::getCreateTime).collect(Collectors.toSet());
        Set<String> createTime1 = inspectPass.stream().map(QualityProductReport::getCreateTime).collect(Collectors.toSet());
        Set<String> createTime2 = sparyPass.stream().map(QualityProductReport::getCreateTime).collect(Collectors.toSet());
        Set<String> createTime3 = proInspectPass.stream().map(QualityProductReport::getCreateTime).collect(Collectors.toSet());
        if (CollUtil.isEmpty(createTime)) {
            createTime = new HashSet<>();
        }
        createTime.addAll(createTime1);
        createTime.addAll(createTime2);
        createTime.addAll(createTime3);
        for (String month : createTime) {
            TotalQualityReportDto totalQualityReportDto = new TotalQualityReportDto();
            totalQualityReportDto.setCreateTime(month);
            List<QualityProductReport> collect1 = purchasePass.stream().filter(e -> e.getCreateTime().equals(month)).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(collect1)) {
                totalQualityReportDto.setPurchasePass(collect1.get(0));
            }
            List<QualityProductReport> collect2 = inspectPass.stream().filter(e -> e.getCreateTime().equals(month)).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(collect2)) {
                totalQualityReportDto.setInspectPass(collect2.get(0));
            }
            List<QualityProductReport> collect3 = sparyPass.stream().filter(e -> e.getCreateTime().equals(month)).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(collect3)) {
                totalQualityReportDto.setSprayPass(collect3.get(0));
            }
            List<QualityProductReport> collect4 = proInspectPass.stream().filter(e -> e.getCreateTime().equals(month)).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(collect4)) {
                totalQualityReportDto.setProInspectPass(collect4.get(0));
            }
            list.add(totalQualityReportDto);
        }
        list.sort(Comparator.comparing(TotalQualityReportDto::getCreateTime));
        return list;
    }

}
