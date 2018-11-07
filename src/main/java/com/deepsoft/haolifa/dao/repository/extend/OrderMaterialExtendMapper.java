package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.OrderMaterial;
import com.deepsoft.haolifa.model.domain.ProductMaterial;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMaterialExtendMapper {

    void insertBatch(@Param("list") List<OrderMaterial> list);

}
