package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.StoreRoomRecord;
import com.deepsoft.haolifa.model.domain.StoreRoomRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreRoomRecordMapper {
    long countByExample(StoreRoomRecordExample example);

    int deleteByExample(StoreRoomRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreRoomRecord record);

    int insertSelective(StoreRoomRecord record);

    List<StoreRoomRecord> selectByExample(StoreRoomRecordExample example);

    StoreRoomRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreRoomRecord record, @Param("example") StoreRoomRecordExample example);

    int updateByExample(@Param("record") StoreRoomRecord record, @Param("example") StoreRoomRecordExample example);

    int updateByPrimaryKeySelective(StoreRoomRecord record);

    int updateByPrimaryKey(StoreRoomRecord record);
}