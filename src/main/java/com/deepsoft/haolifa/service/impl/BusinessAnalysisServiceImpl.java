package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.deepsoft.haolifa.dao.repository.BusinessAnalysisRecordMapper;
import com.deepsoft.haolifa.dao.repository.extend.EntryOutRecordExtendMapper;
import com.deepsoft.haolifa.dao.repository.extend.ExpensesExtendMapper;
import com.deepsoft.haolifa.model.domain.BusinessAnalysisRecord;
import com.deepsoft.haolifa.model.domain.BusinessAnalysisRecordExample;
import com.deepsoft.haolifa.model.dto.businessAnalysis.BusinessAnalysisDTO;
import com.deepsoft.haolifa.model.dto.businessAnalysis.BusinessAnalysisRespDTO;
import com.deepsoft.haolifa.model.dto.businessAnalysis.BusinessAnalysisPurchaseAmountDTO;
import com.deepsoft.haolifa.model.dto.businessAnalysis.BusinessAnalysisSaleAmountDTO;
import com.deepsoft.haolifa.model.dto.expenses.ExpensesConditionDTO;
import com.deepsoft.haolifa.model.dto.report.ReportOrderConditionDTO;
import com.deepsoft.haolifa.model.dto.report.ReportPurchaseConditionDTO;
import com.deepsoft.haolifa.service.BusinessAnalysisService;
import com.deepsoft.haolifa.service.ReportExtendService;
import com.deepsoft.haolifa.util.CommonUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 经营分析
 *
 * @author murphy.he
 **/
@Service
@Slf4j
public class BusinessAnalysisServiceImpl implements BusinessAnalysisService {

    @Resource
    private BusinessAnalysisRecordMapper businessAnalysisRecordMapper;
    @Resource
    private ReportExtendService reportExtendService;
    @Resource
    private ExpensesExtendMapper expensesExtendMapper;
    @Resource
    private EntryOutRecordExtendMapper entryOutRecordExtendMapper;

    @Override
    public BusinessAnalysisRespDTO get(String year) {

        BusinessAnalysisRespDTO businessAnalysisRespDTO = new BusinessAnalysisRespDTO();
        BusinessAnalysisRecordExample example = new BusinessAnalysisRecordExample();
        BusinessAnalysisRecordExample.Criteria criteria = example.createCriteria();
        // 判断year是否有值，没值，默认就是当年
        if (StrUtil.isEmpty(year)) {
            year = String.valueOf(DateUtil.year(new Date()));
        }
        criteria.andYearEqualTo(year);
        Page<BusinessAnalysisRecord> pageList = PageHelper.startPage(0, 1, "id desc")
            .doSelectPage(() -> businessAnalysisRecordMapper.selectByExample(example));
        if (CollectionUtil.isEmpty(pageList)) {
            return businessAnalysisRespDTO;
        }
        BusinessAnalysisRecord businessAnalysisRecord = pageList.get(0);
        BeanUtil.copyProperties(businessAnalysisRecord, businessAnalysisRespDTO);
        return businessAnalysisRespDTO;
    }


    @Override
    public void generate(String year) {
        BusinessAnalysisDTO analysisDTO = new BusinessAnalysisDTO();
        // 判断year是否有值，没值，默认就是当年
        if (StrUtil.isEmpty(year)) {
            year = String.valueOf(DateUtil.year(new Date()));
        }
        analysisDTO.setYear(year);
        preGetData(analysisDTO);

        BusinessAnalysisRecord record = new BusinessAnalysisRecord();
        record.setYear(year);
        // 应收账款=开票金额-回款金额
        record.setTotalAccountsReceivable(analysisDTO.getYearSaleAmountDTO().getInvoiceAmount().subtract(analysisDTO.getYearSaleAmountDTO().getCollectAmount()));

        // 应付账款总额=回票金额-付款金额
        record.setTotalAccountsPayable(analysisDTO.getYearPurchaseAmountDTO().getReturnTicketAmount().subtract(analysisDTO.getYearPurchaseAmountDTO().getPaidTotal()));

        // 产值
        record.setTotalOutputValue(analysisDTO.getYearSaleAmountDTO().getOutPutAmount());

        // 当月产值
        record.setCurrentMonthOutputValue(analysisDTO.getCurrentMonthSaleAmountDTO().getSaleAmount());

        // 订货额
        record.setTotalOrder(analysisDTO.getYearSaleAmountDTO().getSaleAmount());

        // 当月订货额
        record.setCurrentMonthTotalOrder(analysisDTO.getCurrentMonthSaleAmountDTO().getOutPutAmount());

        // 利润总额=毛利-费用合计
        //毛利=产值-成本费用
        //成本费用=采购费用下的运费科目+当月出库的所有零件的总金额（不包括带M和带J图号的零件）+能耗费用下的所用费用+生产费用下的委托加费和维修费+工资费用下的各个事业部的工资总额
        //费用合计=工资费用下的除各个事业部的工资以外的其它部门的工资总额+管理费用下的所有费用+财务费用下的所有费用+质量费用下的所有费用+销售费用下的所有费用+税金下的所有费用
        record.setCost(analysisDTO.getCost());
        record.setTotalExpenses(analysisDTO.getTotalExpenses());
        record.setTotalProfit(analysisDTO.getYearSaleAmountDTO().getSaleAmount().subtract(analysisDTO.getCost()).subtract(analysisDTO.getTotalExpenses()));

        // 各项费用支出总额=管理费用+销售费用+质量费用+财务费用+税金，这几大费用类别下的全部费用明细总额
        record.setVariousExpenses(analysisDTO.getMangeExpenseAmount().add(analysisDTO.getSaleExpenseAmount()).add(analysisDTO.getQualityExpenseAmount()).add(analysisDTO.getFinanceExpenseAmount()).add(analysisDTO.getTaxesExpenseAmount()));

        //销售利润率=利润总额/销售收入
        if (analysisDTO.getYearSaleAmountDTO().getDeliveryAmount().compareTo(BigDecimal.ZERO) > 0) {
            record.setSalesProfitMargin(record.getTotalProfit().divide(analysisDTO.getYearSaleAmountDTO().getDeliveryAmount(), 3, BigDecimal.ROUND_HALF_UP));
        }

        // 成本费用利用率=利润总额/(成本费用+费用合计）
        BigDecimal costExpense = record.getCost().add(record.getTotalExpenses());
        if (costExpense.compareTo(BigDecimal.ZERO) > 0) {
            record.setCostUtilization(record.getTotalProfit().divide(costExpense, 3, BigDecimal.ROUND_HALF_UP));
        }

        // 现金流量(现金日记账+银行日记账+其它货币日记账的余额总和)
        record.setCashFlow(analysisDTO.getBankBalanceAmount().add(analysisDTO.getCashBalanceAmount()).add(analysisDTO.getOtherBalanceAmount()));

        // 制造成本占比(制造成本/产值总额)
        // 管理成本占比（管理成本/产值总额）
        if (record.getTotalOutputValue().compareTo(BigDecimal.ZERO) > 0) {
            record.setManufacturingCost(record.getCost().divide(record.getTotalOutputValue(), 3, BigDecimal.ROUND_HALF_UP));
            record.setManageCost(record.getTotalExpenses().divide(record.getTotalOutputValue(), 3, BigDecimal.ROUND_HALF_UP));
        }
        businessAnalysisRecordMapper.insertSelective(record);

    }

    /**
     * 预处理，获取需要的数据
     *
     * @param analysisDTO
     */
    private void preGetData(BusinessAnalysisDTO analysisDTO) {
        String year = analysisDTO.getYear();
        // 获取销售单相关数据，当年及当月
        ReportOrderConditionDTO saleDto = new ReportOrderConditionDTO();
        saleDto.setYear(year);
        BusinessAnalysisSaleAmountDTO yearSaleAmountDTO = reportExtendService.selectBusinessAnalysisForSale(saleDto);
        analysisDTO.setYearSaleAmountDTO(yearSaleAmountDTO);

        saleDto = new ReportOrderConditionDTO();
        String monthPattern = DateUtil.format(new Date(), DatePattern.NORM_DATE_PATTERN);
        saleDto.setStartDate(monthPattern);
        saleDto.setEndDate(monthPattern);
        BusinessAnalysisSaleAmountDTO currentMonthSaleAmountDTO = reportExtendService.selectBusinessAnalysisForSale(saleDto);
        analysisDTO.setCurrentMonthSaleAmountDTO(currentMonthSaleAmountDTO);

        // 获取采购单相关数据
        ReportPurchaseConditionDTO purchaseDto = new ReportPurchaseConditionDTO();
        purchaseDto.setYear(year);
        BusinessAnalysisPurchaseAmountDTO yearPurchaseAmountDTO = reportExtendService.selectBusinessAnalysisForPurchase(purchaseDto);
        analysisDTO.setYearPurchaseAmountDTO(yearPurchaseAmountDTO);

        // 获取成本费用
        analysisDTO.setCost(getCostAmount(year));

        // 获取费用合计
        analysisDTO.setTotalExpenses(getExpenseAmount(year, analysisDTO));

        //现金日记账+银行日记账+其它货币日记账的余额总和(最新一条记录的余额)
        analysisDTO.setBankBalanceAmount(expensesExtendMapper.bankBalance());
        analysisDTO.setCashBalanceAmount(expensesExtendMapper.cashBalance());
        analysisDTO.setOtherBalanceAmount(expensesExtendMapper.otherBalance());
    }

    /**
     * 成本费用=采购费用下的运费科目+能耗费用下的所用费用+生产费用下的委托加费和维修费+工资费用下的各个事业部的工资总额+出库的所有零件的总金额（不包括带M和带J图号的零件）
     */
    private BigDecimal getCostAmount(String year) {
        ExpensesConditionDTO expensesDTO = new ExpensesConditionDTO();
        expensesDTO.setYear(year);
        expensesDTO.setClassifyName("采购费用");
        expensesDTO.setSecondClassifyName("运输费");
        BigDecimal amount1 = expensesExtendMapper.listSummary(expensesDTO);

        expensesDTO.setClassifyName("能耗费用");
        expensesDTO.setSecondClassifyName(null);
        BigDecimal amount2 = expensesExtendMapper.listSummary(expensesDTO);


        expensesDTO.setClassifyName("生产费用");
        expensesDTO.setSecondClassifyName(null);
        expensesDTO.setSecondClassifyNameList(Stream.of("委托加工费", "维修费").collect(Collectors.toList()));
        BigDecimal amount3 = expensesExtendMapper.listSummary(expensesDTO);

        expensesDTO.setClassifyName("工资");
        expensesDTO.setSecondClassifyNameList(Stream.of("橡胶事业部", "装配事业部", "覆层事业部", "控制阀事业部", "机加事业部").collect(Collectors.toList()));
        BigDecimal amount4 = expensesExtendMapper.listSummary(expensesDTO);

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startDate", CommonUtil.packYearMapParam(year));
        paramMap.put("endDate", CommonUtil.packYearMapParam(year));
        BigDecimal amount5 = entryOutRecordExtendMapper.costMaterialNotMJB(paramMap);

        return amount1.add(amount2).add(amount3).add(amount4).add(amount5);
    }

    /**
     * 费用合计 =工资费用下的除各个事业部的工资以外的其它部门的工资总额+管理费用下的所有费用+财务费用下的所有费用+质量费用下的所有费用+销售费用下的所有费用+税金下的所有费用
     */
    private BigDecimal getExpenseAmount(String year, BusinessAnalysisDTO analysisDTO) {
        ExpensesConditionDTO expensesDTO = new ExpensesConditionDTO();
        expensesDTO.setYear(year);
        expensesDTO.setClassifyName("管理费用");
        BigDecimal amount1 = expensesExtendMapper.listSummary(expensesDTO);
        analysisDTO.setMangeExpenseAmount(amount1);

        expensesDTO.setClassifyName("财务费用");
        BigDecimal amount2 = expensesExtendMapper.listSummary(expensesDTO);
        analysisDTO.setFinanceExpenseAmount(amount2);

        expensesDTO.setClassifyName("质量费用");
        BigDecimal amount3 = expensesExtendMapper.listSummary(expensesDTO);
        analysisDTO.setQualityExpenseAmount(amount3);

        expensesDTO.setClassifyName("销售费用");
        BigDecimal amount4 = expensesExtendMapper.listSummary(expensesDTO);
        analysisDTO.setSaleExpenseAmount(amount4);

        expensesDTO.setClassifyName("税金");
        BigDecimal amount5 = expensesExtendMapper.listSummary(expensesDTO);
        analysisDTO.setTaxesExpenseAmount(amount5);

        expensesDTO.setClassifyName("工资");
        expensesDTO.setExcludeSecondClassifyNameList(Stream.of("橡胶事业部", "装配事业部", "覆层事业部", "控制阀事业部", "机加事业部").collect(Collectors.toList()));
        BigDecimal amount6 = expensesExtendMapper.listSummary(expensesDTO);

        return amount1.add(amount2).add(amount3).add(amount4).add(amount5).add(amount6);
    }

}
