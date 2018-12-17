package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.InspectHistory;
import com.deepsoft.haolifa.model.domain.InspectHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InspectHistoryMapper {
    long countByExample(InspectHistoryExample example);

    int deleteByExample(InspectHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InspectHistory record);

    int insertSelective(InspectHistory record);

    List<InspectHistory> selectByExample(InspectHistoryExample example);

    InspectHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InspectHistory record, @Param("example") InspectHistoryExample example);

    int updateByExample(@Param("record") InspectHistory record, @Param("example") InspectHistoryExample example);

    int updateByPrimaryKeySelective(InspectHistory record);

    int updateByPrimaryKey(InspectHistory record);
}