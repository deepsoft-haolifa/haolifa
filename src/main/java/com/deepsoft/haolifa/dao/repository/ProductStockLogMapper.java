package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ProductStockLog;
import com.deepsoft.haolifa.model.domain.ProductStockLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductStockLogMapper {
    int countByExample(ProductStockLogExample example);

    int deleteByExample(ProductStockLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductStockLog record);

    int insertSelective(ProductStockLog record);

    List<ProductStockLog> selectByExample(ProductStockLogExample example);

    ProductStockLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductStockLog record, @Param("example") ProductStockLogExample example);

    int updateByExample(@Param("record") ProductStockLog record, @Param("example") ProductStockLogExample example);

    int updateByPrimaryKeySelective(ProductStockLog record);

    int updateByPrimaryKey(ProductStockLog record);
}