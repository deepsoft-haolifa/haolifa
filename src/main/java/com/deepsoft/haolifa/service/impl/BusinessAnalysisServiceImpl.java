package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.deepsoft.haolifa.dao.repository.BusinessAnalysisRecordMapper;
import com.deepsoft.haolifa.model.domain.BusinessAnalysisRecord;
import com.deepsoft.haolifa.model.domain.BusinessAnalysisRecordExample;
import com.deepsoft.haolifa.model.dto.businessAnalysis.BusinessAnalysisDTO;
import com.deepsoft.haolifa.model.dto.businessAnalysis.BusinessAnalysisPurchaseAmountDTO;
import com.deepsoft.haolifa.model.dto.businessAnalysis.BusinessAnalysisSaleAmountDTO;
import com.deepsoft.haolifa.model.dto.report.ReportOrderConditionDTO;
import com.deepsoft.haolifa.model.dto.report.ReportPurchaseConditionDTO;
import com.deepsoft.haolifa.service.BusinessAnalysisService;
import com.deepsoft.haolifa.service.ReportExtendService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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

    @Override
    public BusinessAnalysisDTO get(String year) {
        BusinessAnalysisDTO businessAnalysisDTO = new BusinessAnalysisDTO();
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
            return businessAnalysisDTO;
        }
        BusinessAnalysisRecord businessAnalysisRecord = pageList.get(0);
        BeanUtil.copyProperties(businessAnalysisRecord, businessAnalysisDTO);
        return businessAnalysisDTO;
    }


    @Override
    public void generate(String year) {
        // 判断year是否有值，没值，默认就是当年
        if (StrUtil.isEmpty(year)) {
            year = String.valueOf(DateUtil.year(new Date()));
        }

        BusinessAnalysisRecord record = new BusinessAnalysisRecord();
        record.setYear(year);


        // 获取销售单相关数据，当年及当月
        ReportOrderConditionDTO saleDto = new ReportOrderConditionDTO();
        saleDto.setYear(year);
        BusinessAnalysisSaleAmountDTO yearSaleAmountDTO = reportExtendService.selectBusinessAnalysisForSale(saleDto);
        saleDto = new ReportOrderConditionDTO();
        String monthPattern = DateUtil.format(new Date(), DatePattern.NORM_DATE_PATTERN);
        saleDto.setStartDate(monthPattern);
        saleDto.setEndDate(monthPattern);
        BusinessAnalysisSaleAmountDTO currentMonthSaleAmountDTO = reportExtendService.selectBusinessAnalysisForSale(saleDto);

        // 获取采购单相关数据
        ReportPurchaseConditionDTO purchaseDto = new ReportPurchaseConditionDTO();
        purchaseDto.setYear(year);
        BusinessAnalysisPurchaseAmountDTO yearPurchaseAmountDTO = reportExtendService.selectBusinessAnalysisForPurchase(purchaseDto);


        // 应收账款=开票金额-回款金额
        record.setTotalAccountsReceivable(yearSaleAmountDTO.getInvoiceAmount().subtract(yearSaleAmountDTO.getCollectAmount()));

        // 应付账款总额=回票金额-付款金额
        record.setTotalAccountsPayable(yearPurchaseAmountDTO.getReturnTicketAmount().subtract(yearPurchaseAmountDTO.getPaidTotal()));

        // 产值
        record.setTotalOutputValue(yearSaleAmountDTO.getOutPutAmount());

        // 当月产值
        record.setCurrentMonthOutputValue(currentMonthSaleAmountDTO.getOutPutAmount());

        // 订货额
        record.setTotalOrder(yearSaleAmountDTO.getSaleAmount());

        // 当月订货额
        record.setCurrentMonthTotalOrder(currentMonthSaleAmountDTO.getSaleAmount());


        businessAnalysisRecordMapper.insertSelective(record);

    }


    private void packageTotalProfit(BusinessAnalysisRecord record) {
//        利润总额=毛利-费用合计
//        毛利=产值-成本费用
//        成本费用=采购费用下的运费科目+当月出库的所有零件的总金额（不包括带M和带J图号的零件）+能耗费用下的所用费用+生产费用下的委托加费和维修费+工资费用下的各个事业部的工资总额
//        费用合计=工资费用下的除各个事业部的工资以外的其它部门的工资总额+管理费用下的所有费用+财务费用下的所有费用+质量费用下的所有费用+销售费用下的所有费用+税金下的所有费用
        record.setTotalProfit(null);
    }


}
