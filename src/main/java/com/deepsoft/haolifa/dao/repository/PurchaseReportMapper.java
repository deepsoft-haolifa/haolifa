package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.dto.export.ExportpPurchaseDTO;

import java.util.List;
import java.util.Map;

public interface PurchaseReportMapper {
    List<ExportpPurchaseDTO> selectBySupplierName(Map<String, String> paramMap);
    List<ExportpPurchaseDTO> selectPurchase(Map<String, String> paramMap);

}
