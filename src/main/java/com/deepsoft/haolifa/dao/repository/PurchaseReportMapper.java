package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.dto.export.ExportPurchaseDTO;

import java.util.List;
import java.util.Map;

public interface PurchaseReportMapper {
    List<ExportPurchaseDTO> selectBySupplierName(Map<String, Object> paramMap);
    List<ExportPurchaseDTO> selectPurchase(Map<String, Object> paramMap);

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
}
