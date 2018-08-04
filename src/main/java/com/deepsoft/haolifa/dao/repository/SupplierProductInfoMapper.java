package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SupplierProductInfo;
import com.deepsoft.haolifa.model.domain.SupplierProductInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierProductInfoMapper {
    long countByExample(SupplierProductInfoExample example);

    int deleteByExample(SupplierProductInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SupplierProductInfo record);

    int insertSelective(SupplierProductInfo record);

    List<SupplierProductInfo> selectByExample(SupplierProductInfoExample example);

    SupplierProductInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SupplierProductInfo record, @Param("example") SupplierProductInfoExample example);

    int updateByExample(@Param("record") SupplierProductInfo record, @Param("example") SupplierProductInfoExample example);

    int updateByPrimaryKeySelective(SupplierProductInfo record);

    int updateByPrimaryKey(SupplierProductInfo record);
}