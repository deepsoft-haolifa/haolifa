package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.Supplier;
import com.deepsoft.haolifa.model.dto.SupplierProductListDTO;
import com.deepsoft.haolifa.model.dto.SupplierProductResDTO;
import com.deepsoft.haolifa.model.dto.SupplierReqDTO;
import com.deepsoft.haolifa.model.dto.SupplierRespDTO;

import java.util.List;

public interface SupplierProductExtendMapper {

  List<SupplierProductResDTO> getSupplierProList(SupplierProductListDTO params);

  List<SupplierRespDTO> getSupplierList(SupplierReqDTO params);
}
