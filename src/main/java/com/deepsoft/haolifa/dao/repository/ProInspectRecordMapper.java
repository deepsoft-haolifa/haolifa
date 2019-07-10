package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ProInspectRecord;
import com.deepsoft.haolifa.model.domain.ProInspectRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProInspectRecordMapper {
    int countByExample(ProInspectRecordExample example);

    int deleteByExample(ProInspectRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProInspectRecord record);

    int insertSelective(ProInspectRecord record);

    List<ProInspectRecord> selectByExample(ProInspectRecordExample example);

    ProInspectRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProInspectRecord record, @Param("example") ProInspectRecordExample example);

    int updateByExample(@Param("record") ProInspectRecord record, @Param("example") ProInspectRecordExample example);

    int updateByPrimaryKeySelective(ProInspectRecord record);

    int updateByPrimaryKey(ProInspectRecord record);
}