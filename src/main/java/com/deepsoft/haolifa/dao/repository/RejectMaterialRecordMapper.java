package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.RejectMaterialRecord;
import com.deepsoft.haolifa.model.domain.RejectMaterialRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RejectMaterialRecordMapper {
    int countByExample(RejectMaterialRecordExample example);

    int deleteByExample(RejectMaterialRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RejectMaterialRecord record);

    int insertSelective(RejectMaterialRecord record);

    List<RejectMaterialRecord> selectByExample(RejectMaterialRecordExample example);

    RejectMaterialRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RejectMaterialRecord record, @Param("example") RejectMaterialRecordExample example);

    int updateByExample(@Param("record") RejectMaterialRecord record, @Param("example") RejectMaterialRecordExample example);

    int updateByPrimaryKeySelective(RejectMaterialRecord record);

    int updateByPrimaryKey(RejectMaterialRecord record);
}