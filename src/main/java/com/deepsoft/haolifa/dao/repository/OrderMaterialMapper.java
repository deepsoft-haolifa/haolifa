package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.OrderMaterial;
import com.deepsoft.haolifa.model.domain.OrderMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMaterialMapper {
    long countByExample(OrderMaterialExample example);

    int deleteByExample(OrderMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderMaterial record);

    int insertSelective(OrderMaterial record);

    List<OrderMaterial> selectByExample(OrderMaterialExample example);

    OrderMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderMaterial record, @Param("example") OrderMaterialExample example);

    int updateByExample(@Param("record") OrderMaterial record, @Param("example") OrderMaterialExample example);

    int updateByPrimaryKeySelective(OrderMaterial record);

    int updateByPrimaryKey(OrderMaterial record);
}