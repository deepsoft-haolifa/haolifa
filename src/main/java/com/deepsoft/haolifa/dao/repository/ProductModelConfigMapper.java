package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ProductModelConfig;
import com.deepsoft.haolifa.model.domain.ProductModelConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductModelConfigMapper {
    long countByExample(ProductModelConfigExample example);

    int deleteByExample(ProductModelConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductModelConfig record);

    int insertSelective(ProductModelConfig record);

    List<ProductModelConfig> selectByExample(ProductModelConfigExample example);

    ProductModelConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductModelConfig record, @Param("example") ProductModelConfigExample example);

    int updateByExample(@Param("record") ProductModelConfig record, @Param("example") ProductModelConfigExample example);

    int updateByPrimaryKeySelective(ProductModelConfig record);

    int updateByPrimaryKey(ProductModelConfig record);
}