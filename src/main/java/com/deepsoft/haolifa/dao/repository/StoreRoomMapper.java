package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.StoreRoom;
import com.deepsoft.haolifa.model.domain.StoreRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreRoomMapper {
    long countByExample(StoreRoomExample example);

    int deleteByExample(StoreRoomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreRoom record);

    int insertSelective(StoreRoom record);

    List<StoreRoom> selectByExample(StoreRoomExample example);

    StoreRoom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreRoom record, @Param("example") StoreRoomExample example);

    int updateByExample(@Param("record") StoreRoom record, @Param("example") StoreRoomExample example);

    int updateByPrimaryKeySelective(StoreRoom record);

    int updateByPrimaryKey(StoreRoom record);
}