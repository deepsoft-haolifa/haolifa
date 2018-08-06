package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.EquipmentMaintainRecord;
import com.deepsoft.haolifa.model.domain.EquipmentMaintainRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentMaintainRecordMapper {
    long countByExample(EquipmentMaintainRecordExample example);

    int deleteByExample(EquipmentMaintainRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentMaintainRecord record);

    int insertSelective(EquipmentMaintainRecord record);

    List<EquipmentMaintainRecord> selectByExample(EquipmentMaintainRecordExample example);

    EquipmentMaintainRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EquipmentMaintainRecord record, @Param("example") EquipmentMaintainRecordExample example);

    int updateByExample(@Param("record") EquipmentMaintainRecord record, @Param("example") EquipmentMaintainRecordExample example);

    int updateByPrimaryKeySelective(EquipmentMaintainRecord record);

    int updateByPrimaryKey(EquipmentMaintainRecord record);
}