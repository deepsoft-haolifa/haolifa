package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.EquipmentInfo;
import com.deepsoft.haolifa.model.domain.EquipmentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentInfoMapper {
    long countByExample(EquipmentInfoExample example);

    int deleteByExample(EquipmentInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentInfo record);

    int insertSelective(EquipmentInfo record);

    List<EquipmentInfo> selectByExample(EquipmentInfoExample example);

    EquipmentInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EquipmentInfo record, @Param("example") EquipmentInfoExample example);

    int updateByExample(@Param("record") EquipmentInfo record, @Param("example") EquipmentInfoExample example);

    int updateByPrimaryKeySelective(EquipmentInfo record);

    int updateByPrimaryKey(EquipmentInfo record);
}