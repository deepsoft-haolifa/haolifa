package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SupplierEquipmentInfo;
import com.deepsoft.haolifa.model.domain.SupplierEquipmentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierEquipmentInfoMapper {
    long countByExample(SupplierEquipmentInfoExample example);

    int deleteByExample(SupplierEquipmentInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SupplierEquipmentInfo record);

    int insertSelective(SupplierEquipmentInfo record);

    List<SupplierEquipmentInfo> selectByExample(SupplierEquipmentInfoExample example);

    SupplierEquipmentInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SupplierEquipmentInfo record, @Param("example") SupplierEquipmentInfoExample example);

    int updateByExample(@Param("record") SupplierEquipmentInfo record, @Param("example") SupplierEquipmentInfoExample example);

    int updateByPrimaryKeySelective(SupplierEquipmentInfo record);

    int updateByPrimaryKey(SupplierEquipmentInfo record);
}