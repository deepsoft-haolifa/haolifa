package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.ProductMaterial;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className: ProductMaterialExtendMapper
 * @description:
 * @author: hedong@ibeesaas.com
 * @date: 2018-10-15 12:36
 **/
public interface ProductMaterialExtendMapper {

    void insertBatch(@Param("list") List<ProductMaterial> list);

}
