package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.rejectMaterialRecord;
import com.deepsoft.haolifa.model.domain.rejectMaterialRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface rejectMaterialRecordMapper {
    int countByExample(rejectMaterialRecordExample example);

    int deleteByExample(rejectMaterialRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(rejectMaterialRecord record);

    int insertSelective(rejectMaterialRecord record);

    List<rejectMaterialRecord> selectByExample(rejectMaterialRecordExample example);

    rejectMaterialRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") rejectMaterialRecord record, @Param("example") rejectMaterialRecordExample example);

    int updateByExample(@Param("record") rejectMaterialRecord record, @Param("example") rejectMaterialRecordExample example);

    int updateByPrimaryKeySelective(rejectMaterialRecord record);

    int updateByPrimaryKey(rejectMaterialRecord record);
}