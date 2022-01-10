package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.AutoControlEntryOutRecord;
import com.deepsoft.haolifa.model.domain.AutoControlEntryOutRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoControlEntryOutRecordMapper {
    int countByExample(AutoControlEntryOutRecordExample example);

    int deleteByExample(AutoControlEntryOutRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AutoControlEntryOutRecord record);

    int insertSelective(AutoControlEntryOutRecord record);

    List<AutoControlEntryOutRecord> selectByExample(AutoControlEntryOutRecordExample example);

    AutoControlEntryOutRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AutoControlEntryOutRecord record, @Param("example") AutoControlEntryOutRecordExample example);

    int updateByExample(@Param("record") AutoControlEntryOutRecord record, @Param("example") AutoControlEntryOutRecordExample example);

    int updateByPrimaryKeySelective(AutoControlEntryOutRecord record);

    int updateByPrimaryKey(AutoControlEntryOutRecord record);
}