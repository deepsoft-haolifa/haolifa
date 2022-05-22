package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.dto.PurchaseOrderConditionDTO;
import com.deepsoft.haolifa.model.dto.export.DemandSaleAmountRespDTO;
import com.deepsoft.haolifa.model.dto.export.ExportPurchaseDTO;
import com.deepsoft.haolifa.model.dto.export.ReportSupplierConditionDTO;
import com.deepsoft.haolifa.model.dto.order.OrderConditionDTO;
import com.deepsoft.haolifa.model.dto.report.ReportPurchaseConditionDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface PurchaseReportMapper {
    List<ExportPurchaseDTO> selectBySupplierName(ReportSupplierConditionDTO model);
    List<ExportPurchaseDTO> selectPurchase(ReportSupplierConditionDTO model);

    /**
     *  统计公司采购数据（合同金额，挂账金额，已付金额）
     * @param paramMap
     * @return
     */
    List<ExportPurchaseDTO> selectAllPurchase(Map<String, Object> paramMap);

    /**
     *  统计公司采购数据（已回款金额）
     * @param paramMap
     * @return
     */
    List<ExportPurchaseDTO> selectInvoicePurchase(Map<String, Object> paramMap);


    List<ExportPurchaseDTO> reportPurchaseList(ReportPurchaseConditionDTO model);

    ExportPurchaseDTO reportPurchaseSummary(ReportPurchaseConditionDTO model);

    /**
     * 获取采购的回票金额
     * @param model
     * @return
     */
    BigDecimal selectInvoice(ReportPurchaseConditionDTO model);

    /**
     * 获取采购的已付金额
     * @param model
     * @return
     */
    BigDecimal selectPaid(ReportPurchaseConditionDTO model);


}
