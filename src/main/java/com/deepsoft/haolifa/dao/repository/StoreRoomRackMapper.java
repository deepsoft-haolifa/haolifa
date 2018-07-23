package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.StoreRoomRack;
import com.deepsoft.haolifa.model.domain.StoreRoomRackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreRoomRackMapper {
    long countByExample(StoreRoomRackExample example);

    int deleteByExample(StoreRoomRackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreRoomRack record);

    int insertSelective(StoreRoomRack record);

    List<StoreRoomRack> selectByExample(StoreRoomRackExample example);

    StoreRoomRack selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreRoomRack record, @Param("example") StoreRoomRackExample example);

    int updateByExample(@Param("record") StoreRoomRack record, @Param("example") StoreRoomRackExample example);

    int updateByPrimaryKeySelective(StoreRoomRack record);

    int updateByPrimaryKey(StoreRoomRack record);
}