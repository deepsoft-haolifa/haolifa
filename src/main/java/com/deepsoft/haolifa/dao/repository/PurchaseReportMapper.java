package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.dto.export.ExportPurchaseDTO;

import java.util.List;
import java.util.Map;

public interface PurchaseReportMapper {
    List<ExportPurchaseDTO> selectBySupplierName(Map<String, Object> paramMap);
    List<ExportPurchaseDTO> selectPurchase(Map<String, Object> paramMap);

}
