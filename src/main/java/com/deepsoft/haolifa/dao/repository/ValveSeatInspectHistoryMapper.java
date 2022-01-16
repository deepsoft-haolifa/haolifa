package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ValveSeatInspectHistory;
import com.deepsoft.haolifa.model.domain.ValveSeatInspectHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ValveSeatInspectHistoryMapper {
    int countByExample(ValveSeatInspectHistoryExample example);

    int deleteByExample(ValveSeatInspectHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ValveSeatInspectHistory record);

    int insertSelective(ValveSeatInspectHistory record);

    List<ValveSeatInspectHistory> selectByExample(ValveSeatInspectHistoryExample example);

    ValveSeatInspectHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ValveSeatInspectHistory record, @Param("example") ValveSeatInspectHistoryExample example);

    int updateByExample(@Param("record") ValveSeatInspectHistory record, @Param("example") ValveSeatInspectHistoryExample example);

    int updateByPrimaryKeySelective(ValveSeatInspectHistory record);

    int updateByPrimaryKey(ValveSeatInspectHistory record);
}