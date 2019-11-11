package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.dto.export.ExportpPurchaseDTO;

import java.util.List;

public interface PurchaseReportMapper {
    List<ExportpPurchaseDTO> selectBySupplierName(String supplierName);
    List<ExportpPurchaseDTO> selectPurchase();

}