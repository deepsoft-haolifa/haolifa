package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.dto.SupplierProductListDTO;
import com.deepsoft.haolifa.model.dto.SupplierProductResDTO;
import java.util.List;

public interface SupplierProductExtendMapper {

  List<SupplierProductResDTO> getSupplierProList(SupplierProductListDTO params);

}
