package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.EntryOutStoreRecord;
import com.deepsoft.haolifa.model.domain.EntryOutStoreRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntryOutStoreRecordMapper {
    int countByExample(EntryOutStoreRecordExample example);

    int deleteByExample(EntryOutStoreRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EntryOutStoreRecord record);

    int insertSelective(EntryOutStoreRecord record);

    List<EntryOutStoreRecord> selectByExample(EntryOutStoreRecordExample example);

    EntryOutStoreRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EntryOutStoreRecord record, @Param("example") EntryOutStoreRecordExample example);

    int updateByExample(@Param("record") EntryOutStoreRecord record, @Param("example") EntryOutStoreRecordExample example);

    int updateByPrimaryKeySelective(EntryOutStoreRecord record);

    int updateByPrimaryKey(EntryOutStoreRecord record);
}