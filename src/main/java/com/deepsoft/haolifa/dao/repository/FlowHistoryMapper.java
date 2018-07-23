package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.FlowHistory;
import com.deepsoft.haolifa.model.domain.FlowHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowHistoryMapper {
    long countByExample(FlowHistoryExample example);

    int deleteByExample(FlowHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowHistory record);

    int insertSelective(FlowHistory record);

    List<FlowHistory> selectByExample(FlowHistoryExample example);

    FlowHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlowHistory record, @Param("example") FlowHistoryExample example);

    int updateByExample(@Param("record") FlowHistory record, @Param("example") FlowHistoryExample example);

    int updateByPrimaryKeySelective(FlowHistory record);

    int updateByPrimaryKey(FlowHistory record);
}