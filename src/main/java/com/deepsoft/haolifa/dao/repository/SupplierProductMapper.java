package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.Equipment;
import com.deepsoft.haolifa.model.domain.SupplierProduct;
import com.deepsoft.haolifa.model.domain.SupplierProductExample;
import java.util.List;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface SupplierProductMapper {
    long countByExample(SupplierProductExample example);

    int deleteByExample(SupplierProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SupplierProduct record);

    int insertSelective(SupplierProduct record);

    List<SupplierProduct> selectByExample(SupplierProductExample example);

    SupplierProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SupplierProduct record, @Param("example") SupplierProductExample example);

    int updateByExample(@Param("record") SupplierProduct record, @Param("example") SupplierProductExample example);

    int updateByPrimaryKeySelective(SupplierProduct record);

    int updateByPrimaryKey(SupplierProduct record);

    Page<SupplierProduct> selectListByPage(@Param("materialType") Integer materialType,@Param("materialName") String materialName);
}