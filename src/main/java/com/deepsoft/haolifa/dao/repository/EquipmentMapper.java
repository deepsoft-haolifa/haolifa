package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.Equipment;
import com.deepsoft.haolifa.model.domain.EquipmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentMapper {
    int countByExample(EquipmentExample example);

    int deleteByExample(EquipmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    List<Equipment> selectByExample(EquipmentExample example);

    Equipment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Equipment record, @Param("example") EquipmentExample example);

    int updateByExample(@Param("record") Equipment record, @Param("example") EquipmentExample example);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
}