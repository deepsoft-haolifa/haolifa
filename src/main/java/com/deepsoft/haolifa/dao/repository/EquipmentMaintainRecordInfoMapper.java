package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.EquipmentMaintainRecordInfo;
import com.deepsoft.haolifa.model.domain.EquipmentMaintainRecordInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentMaintainRecordInfoMapper {
    long countByExample(EquipmentMaintainRecordInfoExample example);

    int deleteByExample(EquipmentMaintainRecordInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentMaintainRecordInfo record);

    int insertSelective(EquipmentMaintainRecordInfo record);

    List<EquipmentMaintainRecordInfo> selectByExample(EquipmentMaintainRecordInfoExample example);

    EquipmentMaintainRecordInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EquipmentMaintainRecordInfo record, @Param("example") EquipmentMaintainRecordInfoExample example);

    int updateByExample(@Param("record") EquipmentMaintainRecordInfo record, @Param("example") EquipmentMaintainRecordInfoExample example);

    int updateByPrimaryKeySelective(EquipmentMaintainRecordInfo record);

    int updateByPrimaryKey(EquipmentMaintainRecordInfo record);
}