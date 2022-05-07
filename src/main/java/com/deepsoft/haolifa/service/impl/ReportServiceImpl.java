package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
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
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
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
    public ResultBean selectBySupplierName(ReportSupplierConditionDTO model) {
        //如果传入2021年，则查2020-12-26 至 2021-12-25
        if (StrUtil.isNotBlank(model.getYear())) {
            Map<String, Object> param = CommonUtil.packYearMapParam(model.getYear());
            model.setStartDate(MapUtil.getStr(param, "startDate"));
            model.setEndDate(MapUtil.getStr(param, "endDate"));
        }
        if (null != model.getStartDate()) {
            model.setStartDate(CommonUtil.packYearMonthMapParamStart(model.getStartDate()));
        }
        if (null != model.getEndDate()) {
            model.setEndDate(CommonUtil.packYearMonthMapParamEnd(model.getEndDate()));
        }
        List<ExportPurchaseDTO> exportPurchaseDTOS = purchaseReportMapper.selectBySupplierName(model);
        return ResultBean.success(exportPurchaseDTOS);
    }

    @Override
    public ResultBean selectPurchase(ReportSupplierConditionDTO model) {
        //如果传入2021年，则查2020-12-26 至 2021-12-25
        if (StrUtil.isNotBlank(model.getYear())) {
            Map<String, Object> param = CommonUtil.packYearMapParam(model.getYear());
            model.setStartDate(MapUtil.getStr(param, "startDate"));
            model.setEndDate(MapUtil.getStr(param, "endDate"));
        }
        if (StrUtil.isNotBlank(model.getMonth()) && StrUtil.isNotBlank(model.getYear())) {
            String yearMonth = String.format("%s-%s", model.getYear(), model.getMonth());
            model.setStartDate(CommonUtil.packYearMonthMapParamStart(yearMonth));
            model.setEndDate(CommonUtil.packYearMonthMapParamEnd(yearMonth));
        } else {
            if (null != model.getStartDate()) {
                model.setStartDate(CommonUtil.packYearMonthMapParamStart(model.getStartDate()));
            }
            if (null != model.getEndDate()) {
                model.setEndDate(CommonUtil.packYearMonthMapParamEnd(model.getEndDate()));
            }
        }
        List<ExportPurchaseDTO> exportPurchaseDTOS = purchaseReportMapper.selectPurchase(model);
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
    public List<ExportSaleMapDTO> selectContractByDemandName(String year) {
        Set<String> demandSet = new HashSet<>();
        Map<String, Object> packMapParam = CommonUtil.packYearMapParam(year);
        List<ExportContractDTO> exportContractDTOS = saleReportMapper.selectContractByDemandName(packMapParam);
        String lastYear = CommonUtil.getLastYear(year);
        Map<String, Object> lastYearPackMapParam = CommonUtil.packYearMapParam(lastYear);
        List<ExportContractDTO> lastYearExportContractDTOS = saleReportMapper.selectContractByDemandName(lastYearPackMapParam);

        // 将今年和往年的客户集合起来
        Set<String> demandNameSet = exportContractDTOS.stream().map(ExportContractDTO::getDemandName).collect(Collectors.toSet());
        Set<String> lastDemandNameSet = lastYearExportContractDTOS.stream().map(ExportContractDTO::getDemandName).collect(Collectors.toSet());
        demandSet.addAll(demandNameSet);
        demandSet.addAll(lastDemandNameSet);

        List<ExportSaleMapDTO> resultList = new ArrayList<>();
        demandSet.forEach((demandName) -> {
            ExportSaleMapDTO exportSaleMapDTO = new ExportSaleMapDTO();
            exportSaleMapDTO.setCompanyName(demandName);
            List<ExportSaleMapDTO.ValueRespVo> valueRespVoList = new ArrayList<>();
            ExportSaleMapDTO.ValueRespVo valueRespVo = new ExportSaleMapDTO.ValueRespVo();
            valueRespVo.setYear(year);
            BigDecimal yearAmount = exportContractDTOS.stream().filter(e -> e.getDemandName().equals(demandName) && null != e.getTotalPrice()).map(ExportContractDTO::getTotalPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
            valueRespVo.setAmount(yearAmount);
            valueRespVoList.add(valueRespVo);

            ExportSaleMapDTO.ValueRespVo valueRespVo1 = new ExportSaleMapDTO.ValueRespVo();
            valueRespVo1.setYear(lastYear);
            BigDecimal lastYearAmount = lastYearExportContractDTOS.stream().filter(e -> e.getDemandName().equals(demandName) && null != e.getTotalPrice()).map(ExportContractDTO::getTotalPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
            valueRespVo1.setAmount(lastYearAmount);
            valueRespVoList.add(valueRespVo1);

            exportSaleMapDTO.setValue(valueRespVoList);
            resultList.add(exportSaleMapDTO);
        });
        return resultList;
    }

    @Override
    public List<ExportContractDTO> selectContractByDemandNameByMonth(ReportBaseDTO baseDTO) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startDate", CommonUtil.packYearMonthMapParamStart(baseDTO.getStartDate()));
        paramMap.put("endDate", CommonUtil.packYearMonthMapParamEnd(baseDTO.getEndDate()));
        return saleReportMapper.selectContractByDemandNameMonth(paramMap);
    }

    @Override
    public List<ExportSaleMapDTO> selectshouhuiContractByDemandName(String year) {
        Set<String> demandSet = new HashSet<>();
        Map<String, Object> packMapParam = CommonUtil.packYearMapParam(year);
        List<ExportContractDTO> exportContractDTOS = saleReportMapper.selectshouhuiContractByDemandName(packMapParam);
        String lastYear = CommonUtil.getLastYear(year);
        Map<String, Object> lastYearPackMapParam = CommonUtil.packYearMapParam(lastYear);
        List<ExportContractDTO> lastYearExportContractDTOS = saleReportMapper.selectshouhuiContractByDemandName(lastYearPackMapParam);

        // 将今年和往年的客户集合起来
        Set<String> demandNameSet = exportContractDTOS.stream().map(ExportContractDTO::getDemandName).collect(Collectors.toSet());
        Set<String> lastDemandNameSet = lastYearExportContractDTOS.stream().map(ExportContractDTO::getDemandName).collect(Collectors.toSet());
        demandSet.addAll(demandNameSet);
        demandSet.addAll(lastDemandNameSet);

        List<ExportSaleMapDTO> resultList = new ArrayList<>();
        demandSet.forEach((demandName) -> {
            ExportSaleMapDTO exportSaleMapDTO = new ExportSaleMapDTO();
            exportSaleMapDTO.setCompanyName(demandName);
            List<ExportSaleMapDTO.ValueRespVo> valueRespVoList = new ArrayList<>();
            ExportSaleMapDTO.ValueRespVo valueRespVo = new ExportSaleMapDTO.ValueRespVo();
            valueRespVo.setYear(year);
            BigDecimal yearAmount = exportContractDTOS.stream().filter(e -> e.getDemandName().equals(demandName) && null != e.getTotalPrice()).map(ExportContractDTO::getTotalPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
            valueRespVo.setAmount(yearAmount);
            valueRespVoList.add(valueRespVo);

            ExportSaleMapDTO.ValueRespVo valueRespVo1 = new ExportSaleMapDTO.ValueRespVo();
            valueRespVo1.setYear(lastYear);
            BigDecimal lastYearAmount = lastYearExportContractDTOS.stream().filter(e -> e.getDemandName().equals(demandName) && null != e.getTotalPrice()).map(ExportContractDTO::getTotalPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
            valueRespVo1.setAmount(lastYearAmount);
            valueRespVoList.add(valueRespVo1);

            exportSaleMapDTO.setValue(valueRespVoList);
            resultList.add(exportSaleMapDTO);
        });
        return resultList;
    }

    @Override
    public List<ExportContractDTO> selectshouhuiContractByDemandNameByMonth(ReportBaseDTO baseDTO) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startDate", CommonUtil.packYearMonthMapParamStart(baseDTO.getStartDate()));
        paramMap.put("endDate", CommonUtil.packYearMonthMapParamEnd(baseDTO.getEndDate()));
        return saleReportMapper.selectshouhuiContractByDemandNameMonth(paramMap);
    }

    @Override
    public List<ExportContractDTO> selectInvoiceAmountByDemandName(String year) {
        Map<String, Object> packMapParam = new HashMap<>();
        packMapParam.put("year", year);
        return saleReportMapper.selectInvoiceAmountByDemandName(packMapParam);
    }

    @Override
    public List<ExportContractDTO> selectDeliveryAmountByDemandName(String year) {
        Map<String, Object> packMapParam = new HashMap<>();
        packMapParam.put("year", year);
        return saleReportMapper.selectDeliveryAmountByDemandName(packMapParam);
    }

    @Override
    public List<DemandAmountDto> selectAllAmountByDemandName(ReportBaseDTO baseDTO) {
        Map<String, Object> packMapParam = new HashMap<>();
        packMapParam.put("startDate", CommonUtil.packYearMonthMapParamStart(baseDTO.getStartDate()));
        packMapParam.put("endDate", CommonUtil.packYearMonthMapParamEnd(baseDTO.getEndDate()));

        List<DemandAmountDto> list = new ArrayList<>();
        List<ExportContractDTO> invoice = saleReportMapper.selectInvoiceAmountByDemandName(packMapParam);
        List<ExportContractDTO> delivery = saleReportMapper.selectDeliveryAmountByDemandName(packMapParam);
        List<ExportContractDTO> sale = saleReportMapper.selectContractByDemandName(packMapParam);
        List<ExportContractDTO> refund = saleReportMapper.selectshouhuiContractByDemandName(packMapParam);

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
            demandAmountDto.setSaleAmount(sale.stream().filter(e -> e.getDemandName().equals(demandName) && null != e.getTotalPrice()).map(ExportContractDTO::getTotalPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
            demandAmountDto.setInvoiceAmount(invoice.stream().filter(e -> e.getDemandName().equals(demandName) && null != e.getTotalPrice()).map(ExportContractDTO::getTotalPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
            demandAmountDto.setRefundAmount(refund.stream().filter(e -> e.getDemandName().equals(demandName) && null != e.getTotalPrice()).map(ExportContractDTO::getTotalPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
            demandAmountDto.setDeliveryAmount(delivery.stream().filter(e -> e.getDemandName().equals(demandName) && null != e.getTotalPrice()).map(ExportContractDTO::getTotalPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
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
