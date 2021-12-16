package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.deepsoft.haolifa.dao.repository.SaleReportMapper;
import com.deepsoft.haolifa.dao.repository.extend.OrderExtendMapper;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.export.DemandSaleAmountRespDTO;
import com.deepsoft.haolifa.model.dto.export.PaymentRespDTO;
import com.deepsoft.haolifa.model.dto.export.TotalAmountDTO;
import com.deepsoft.haolifa.model.dto.order.OrderConditionDTO;
import com.deepsoft.haolifa.model.dto.order.OrderListRespDTO;
import com.deepsoft.haolifa.service.ReportExtendService;
import com.deepsoft.haolifa.service.ReportService;
import com.deepsoft.haolifa.util.CommonUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author murphy.he
 **/
@Service
@Slf4j
public class ReportExtendServiceImpl extends BaseService implements ReportExtendService {

    @Autowired
    private SaleReportMapper saleReportMapper;
    @Autowired
    private OrderExtendMapper orderExtendMapper;

    @Override
    public PageDTO<OrderListRespDTO> reportOrderList(OrderConditionDTO model) {
        this.packQueryParam(model);
        Page<OrderListRespDTO> materials = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> orderExtendMapper.reportOrderList(model));
        PageDTO<OrderListRespDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(materials, pageDTO);
        pageDTO.setList(materials);
        return pageDTO;
    }

    @Override
    public BigDecimal reportOrderSummary(OrderConditionDTO dto) {
        this.packQueryParam(dto);
        return orderExtendMapper.reportOrderSummary(dto);
    }

    @Override
    public PageDTO<PaymentRespDTO> reportCollectOrderList(OrderConditionDTO model) {
        this.packQueryParam(model);
        Page<PaymentRespDTO> materials = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> saleReportMapper.selectSaleCollectionList(model));
        PageDTO<PaymentRespDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(materials, pageDTO);
        pageDTO.setList(materials);
        return pageDTO;
    }

    @Override
    public TotalAmountDTO reportCollectOrderSummary(OrderConditionDTO model) {
        this.packQueryParam(model);
        return saleReportMapper.reportCollectOrderSummary(model);
    }

    @Override
    public PageDTO<DemandSaleAmountRespDTO> reportSaleByDemandList(OrderConditionDTO model) {
        this.packQueryParam(model);
        Page<DemandSaleAmountRespDTO> materials = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> saleReportMapper.reportSaleByDemandList(model));
        PageDTO<DemandSaleAmountRespDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(materials, pageDTO);
        pageDTO.setList(materials);
        return pageDTO;
    }

    @Override
    public DemandSaleAmountRespDTO reportSaleByDemandSummary(OrderConditionDTO model) {
        this.packQueryParam(model);
        return saleReportMapper.reportSaleByDemandSummary(model);
    }

    private void packQueryParam(OrderConditionDTO model){
        //如果传入2021年，则查2020-12-26 至 2021-12-25
        if (StrUtil.isNotBlank(model.getYear())) {
            Map<String, Object> param = CommonUtil.packYearMapParam(model.getYear());
            model.setStartDate(cn.hutool.core.date.DateUtil.parseDate(MapUtil.getStr(param,"startDate")));
            model.setEndDate(cn.hutool.core.date.DateUtil.parseDate(MapUtil.getStr(param,"endDate")));
        }
        //如果传入2021-09 ，则查2021-08-26 至 2021-09-25
        if (null != model.getStartDate()) {
            model.setStartDate(cn.hutool.core.date.DateUtil.parseDate(CommonUtil.packYearMonthMapParam(cn.hutool.core.date.DateUtil.format(model.getStartDate(), "yy-MM"))));
        }
        if (null != model.getEndDate()) {
            model.setEndDate(cn.hutool.core.date.DateUtil.parseDate(CommonUtil.packYearMonthMapParam(cn.hutool.core.date.DateUtil.format(model.getEndDate(), "yy-MM"))));
        }
    }
}
