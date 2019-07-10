package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PressureInspectRecord;
import com.deepsoft.haolifa.model.domain.PressureInspectRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PressureInspectRecordMapper {
    int countByExample(PressureInspectRecordExample example);

    int deleteByExample(PressureInspectRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PressureInspectRecord record);

    int insertSelective(PressureInspectRecord record);

    List<PressureInspectRecord> selectByExample(PressureInspectRecordExample example);

    PressureInspectRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PressureInspectRecord record, @Param("example") PressureInspectRecordExample example);

    int updateByExample(@Param("record") PressureInspectRecord record, @Param("example") PressureInspectRecordExample example);

    int updateByPrimaryKeySelective(PressureInspectRecord record);

    int updateByPrimaryKey(PressureInspectRecord record);
}