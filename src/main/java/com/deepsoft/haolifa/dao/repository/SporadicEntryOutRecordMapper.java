package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SporadicEntryOutRecord;
import com.deepsoft.haolifa.model.domain.SporadicEntryOutRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SporadicEntryOutRecordMapper {
    int countByExample(SporadicEntryOutRecordExample example);

    int deleteByExample(SporadicEntryOutRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SporadicEntryOutRecord record);

    int insertSelective(SporadicEntryOutRecord record);

    List<SporadicEntryOutRecord> selectByExample(SporadicEntryOutRecordExample example);

    SporadicEntryOutRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SporadicEntryOutRecord record, @Param("example") SporadicEntryOutRecordExample example);

    int updateByExample(@Param("record") SporadicEntryOutRecord record, @Param("example") SporadicEntryOutRecordExample example);

    int updateByPrimaryKeySelective(SporadicEntryOutRecord record);

    int updateByPrimaryKey(SporadicEntryOutRecord record);
}