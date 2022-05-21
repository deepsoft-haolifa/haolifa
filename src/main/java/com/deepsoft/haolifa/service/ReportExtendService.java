package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderConditionDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.*;
import com.deepsoft.haolifa.model.dto.order.OrderConditionDTO;
import com.deepsoft.haolifa.model.dto.order.OrderListRespDTO;
import com.deepsoft.haolifa.model.dto.report.ReportOrderConditionDTO;
import com.deepsoft.haolifa.model.dto.report.ReportPurchaseConditionDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author murphy.he
 **/
public interface ReportExtendService {

    /**
     * 用于报表展示订单列表数据
     *
     * @param dto
     * @return
     */
    PageDTO<OrderListRespDTO> reportOrderList(ReportOrderConditionDTO dto);

    /**
     * 用于报表累计订货额显示
     *
     * @param dto
     * @return
     */
    BigDecimal reportOrderSummary(ReportOrderConditionDTO dto);

    /**
     * 用于报表展示回款列表数据
     *
     * @param dto
     * @return
     */
    PageDTO<PaymentRespDTO> reportCollectOrderList(ReportOrderConditionDTO dto);

    /**
     * 用于报表回款订货额显示
     *
     * @param dto
     * @return
     */
    TotalAmountDTO reportCollectOrderSummary(ReportOrderConditionDTO dto);

    /**
     * 销售报表-按需方统计-列表数据
     *
     * @param model
     * @return
     */
    PageDTO<DemandSaleAmountRespDTO> reportSaleByDemandList(ReportOrderConditionDTO model);

    /**
     * 销售报表-按需方统计-统计
     *
     * @param model
     * @return
     */
    DemandSaleAmountRespDTO reportSaleByDemandSummary(ReportOrderConditionDTO model);

    PageDTO<SaleOutputRespDTO> reportSaleOutputList(ReportOrderConditionDTO dto);

    BigDecimal reportSaleOutputSummary(ReportOrderConditionDTO dto);

    PageDTO<ExportPurchaseDTO> reportPurchaseList(ReportPurchaseConditionDTO dto);

    ExportPurchaseDTO reportPurchaseSummary(ReportPurchaseConditionDTO dto);


    /**
     *  经营分析-查询销售报表相关数据
     */
    BusinessAnalysisSaleAmountDTO selectBusinessAnalysis(ReportOrderConditionDTO dto);


}
