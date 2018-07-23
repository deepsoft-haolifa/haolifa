package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SupplierInfo;
import com.deepsoft.haolifa.model.domain.SupplierInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierInfoMapper {
    long countByExample(SupplierInfoExample example);

    int deleteByExample(SupplierInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SupplierInfo record);

    int insertSelective(SupplierInfo record);

    List<SupplierInfo> selectByExample(SupplierInfoExample example);

    SupplierInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SupplierInfo record, @Param("example") SupplierInfoExample example);

    int updateByExample(@Param("record") SupplierInfo record, @Param("example") SupplierInfoExample example);

    int updateByPrimaryKeySelective(SupplierInfo record);

    int updateByPrimaryKey(SupplierInfo record);
}