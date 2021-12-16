package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.DemandSaleAmountRespDTO;
import com.deepsoft.haolifa.model.dto.export.PaymentRespDTO;
import com.deepsoft.haolifa.model.dto.export.TotalAmountDTO;
import com.deepsoft.haolifa.model.dto.order.OrderConditionDTO;
import com.deepsoft.haolifa.model.dto.order.OrderListRespDTO;
import com.deepsoft.haolifa.service.ReportExtendService;
import com.deepsoft.haolifa.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Api(tags = {"报表扩展(2021-12-hd)"})
@RestController
@RequestMapping("/report-extend")
public class ReportExtendController {
    @Autowired
    private ReportExtendService reportExtendService;

    @ApiOperation("订单列表展示--用于销售报表-订货（2021-12-hd）")
    @PostMapping("/report-order-list")
    public ResultBean<PageDTO<OrderListRespDTO>> reportOrderList(@RequestBody OrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportOrderList(dto));
    }
    @ApiOperation("订单列表总额汇总--用于销售报表-订货（2021-12-hd）")
    @PostMapping("/report-order-summary")
    public ResultBean<BigDecimal> reportOrderSummary(@RequestBody OrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportOrderSummary(dto));
    }

    @ApiOperation("回款订单列表展示--用于销售报表-回款（2021-12-hd）")
    @PostMapping("/report-collect-order-list")
    public ResultBean<PageDTO<PaymentRespDTO>> reportCollectOrderList(@RequestBody OrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportCollectOrderList(dto));
    }
    @ApiOperation("回款订单金额汇总--用于销售报表-回款（2021-12-hd）")
    @PostMapping("/report-collect-order-summary")
    public ResultBean<TotalAmountDTO> reportCollectOrderSummary(@RequestBody OrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportCollectOrderSummary(dto));
    }
    @ApiOperation("按照需方统计展示--用于销售报表（2021-12-hd）")
    @PostMapping("/report-sale-demand-list")
    public ResultBean<PageDTO<DemandSaleAmountRespDTO>> reportSaleDemandList(@RequestBody OrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportSaleByDemandList(dto));
    }
    @ApiOperation("按照需方统计汇总--用于销售报表（2021-12-hd）")
    @PostMapping("/report-sale-demand-summary")
    public ResultBean<DemandSaleAmountRespDTO> reportSaleDemandSummary(@RequestBody OrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportSaleByDemandSummary(dto));
    }

    @ApiOperation("每月产值总额统计--用于销售报表（2021-12-hd）")
    @PostMapping("/report-sale-month-list")
    public ResultBean<PageDTO<DemandSaleAmountRespDTO>> reportSaleMonthList(@RequestBody OrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportSaleByDemandList(dto));
    }
    @ApiOperation("每月产值总额汇总--用于销售报表（2021-12-hd）")
    @PostMapping("/report-sale-month-summary")
    public ResultBean<DemandSaleAmountRespDTO> reportSaleMonthSummary(@RequestBody OrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportSaleByDemandSummary(dto));
    }
}
