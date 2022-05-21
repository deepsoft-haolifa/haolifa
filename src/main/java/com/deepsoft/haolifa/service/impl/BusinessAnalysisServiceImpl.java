package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.deepsoft.haolifa.dao.repository.BusinessAnalysisRecordMapper;
import com.deepsoft.haolifa.model.domain.BusinessAnalysisRecord;
import com.deepsoft.haolifa.model.domain.BusinessAnalysisRecordExample;
import com.deepsoft.haolifa.model.domain.CustomerInfo;
import com.deepsoft.haolifa.model.dto.businessAnalysis.BusinessAnalysisDTO;
import com.deepsoft.haolifa.model.dto.export.BusinessAnalysisSaleAmountDTO;
import com.deepsoft.haolifa.model.dto.report.ReportOrderConditionDTO;
import com.deepsoft.haolifa.model.dto.report.ReportPurchaseConditionDTO;
import com.deepsoft.haolifa.service.BusinessAnalysisService;
import com.deepsoft.haolifa.service.ReportExtendService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

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
        BusinessAnalysisSaleAmountDTO yearSaleAmountDTO = reportExtendService.selectBusinessAnalysis(saleDto);
        saleDto = new ReportOrderConditionDTO();
        String monthPattern = DateUtil.format(new Date(), DatePattern.NORM_DATE_PATTERN);
        saleDto.setStartDate(monthPattern);
        saleDto.setEndDate(monthPattern);
        BusinessAnalysisSaleAmountDTO currentMonthSaleAmountDTO = reportExtendService.selectBusinessAnalysis(saleDto);

        // TODO 获取采购单相关数据

        // 应收账款=开票金额-回款金额
        record.setTotalAccountsReceivable(yearSaleAmountDTO.getInvoiceAmount().subtract(yearSaleAmountDTO.getCollectAmount()));

        // 应付账款总额=回票金额-付款金额

        // 产值
        record.setTotalOutputValue(yearSaleAmountDTO.getOutPutAmount());

        // 当月产值
        record.setCurrentMonthOutputValue(currentMonthSaleAmountDTO.getOutPutAmount());

        // 订货
        record.setTotalOrder(yearSaleAmountDTO.getSaleAmount());

        // 当月订货
        record.setCurrentMonthTotalOrder(currentMonthSaleAmountDTO.getSaleAmount());




        businessAnalysisRecordMapper.insertSelective(record);

    }

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


}
