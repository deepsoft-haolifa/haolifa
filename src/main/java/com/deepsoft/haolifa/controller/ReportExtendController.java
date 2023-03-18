package com.deepsoft.haolifa.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.*;
import com.deepsoft.haolifa.model.dto.order.OrderListRespDTO;
import com.deepsoft.haolifa.model.dto.report.ReportOrderConditionDTO;
import com.deepsoft.haolifa.model.dto.report.ReportPurchaseConditionDTO;
import com.deepsoft.haolifa.service.ReportExtendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import static com.deepsoft.haolifa.constant.Constant.EXPORT_MAX_SIZE;

@Api(tags = {"报表扩展(2021-12-hd)"})
@RestController
@RequestMapping("/report-extend")
public class ReportExtendController {
    @Autowired
    private ReportExtendService reportExtendService;

    @ApiOperation("订单列表展示--用于销售报表-订货（2021-12-hd）")
    @PostMapping("/report-order-list")
    public ResultBean<PageDTO<OrderListRespDTO>> reportOrderList(@RequestBody ReportOrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportOrderList(dto));
    }

    @ApiOperation("订单列表总额汇总--用于销售报表-订货（2021-12-hd）")
    @PostMapping("/report-order-summary")
    public ResultBean<BigDecimal> reportOrderSummary(@RequestBody ReportOrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportOrderSummary(dto));
    }

    @ApiOperation("回款订单列表展示--用于销售报表-回款（2021-12-hd）")
    @PostMapping("/report-collect-order-list")
    public ResultBean<PageDTO<PaymentRespDTO>> reportCollectOrderList(@RequestBody ReportOrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportCollectOrderList(dto));
    }

    @ApiOperation("回款订单金额汇总--用于销售报表-回款（2021-12-hd）")
    @PostMapping("/report-collect-order-summary")
    public ResultBean<TotalAmountDTO> reportCollectOrderSummary(@RequestBody ReportOrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportCollectOrderSummary(dto));
    }

    @ApiOperation("按照需方统计展示--用于销售报表（2021-12-hd）")
    @PostMapping("/report-sale-demand-list")
    public ResultBean<PageDTO<DemandSaleAmountRespDTO>> reportSaleDemandList(@RequestBody ReportOrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportSaleByDemandList(dto));
    }

    @ApiOperation("按照需方统计展示--用于销售报表-导出")
    @GetMapping("/report-sale-demand-list-export")
    public void reportSaleDemandListExport(@RequestBody ReportOrderConditionDTO dto, HttpServletResponse response) {
        dto.setPageSize(EXPORT_MAX_SIZE);
        PageDTO<DemandSaleAmountRespDTO> demandSaleAmountRespDTOPageDTO = reportExtendService.reportSaleByDemandList(dto);
        List<DemandSaleAmountRespDTO> rows = demandSaleAmountRespDTOPageDTO.getList();
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("demandName", "客户名称");
        writer.addHeaderAlias("orderNo", "订单号");
        writer.addHeaderAlias("saleAmount", "订货金额");
        writer.addHeaderAlias("deliveryAmount", "发货金额");
        writer.addHeaderAlias("invoiceAmount", "开票金额");
        writer.addHeaderAlias("collectAmount", "回款金额");
        writer.addHeaderAlias("oweMoneyAmount", "欠款金额");
        writer.addHeaderAlias("oweTicketAmount", "欠票金额");

         // 默认的，未添加alias的属性也会写出，如果想只写出加了别名的字段，可以调用此方法排除之
        writer.setOnlyAlias(true);


        writer.write(rows, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=销售报表-需方统计.xlsx");
        OutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writer.flush(out, true);
        writer.close();
        IoUtil.close(out);
    }

    @ApiOperation("按照需方统计汇总--用于销售报表（2021-12-hd）")
    @PostMapping("/report-sale-demand-summary")
    public ResultBean<DemandSaleAmountRespDTO> reportSaleDemandSummary(@RequestBody ReportOrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportSaleByDemandSummary(dto));
    }

    @ApiOperation("每月产值总额统计--用于销售报表（2021-12-hd）")
    @PostMapping("/report-sale-output-list")
    public ResultBean<PageDTO<SaleOutputRespDTO>> reportSaleOutputList(@RequestBody ReportOrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportSaleOutputList(dto));
    }

    @ApiOperation("每月产值总额汇总--用于销售报表（2021-12-hd）")
    @PostMapping("/report-sale-output-summary")
    public ResultBean<BigDecimal> reportSaleOutputSummary(@RequestBody ReportOrderConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportSaleOutputSummary(dto));
    }


    @ApiOperation("采购统计列表--用于采购报表（2021-12-hd）")
    @PostMapping("/report-purchase-list")
    public ResultBean<PageDTO<ExportPurchaseDTO>> reportPurchaseList(@RequestBody ReportPurchaseConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportPurchaseList(dto));
    }

    @ApiOperation("采购统计汇总--用于采购报表（2021-12-hd）")
    @PostMapping("/report-purchase-summary")
    public ResultBean<ExportPurchaseDTO> reportPurchaseSummary(@RequestBody ReportPurchaseConditionDTO dto) {
        return ResultBean.success(reportExtendService.reportPurchaseSummary(dto));
    }
}
