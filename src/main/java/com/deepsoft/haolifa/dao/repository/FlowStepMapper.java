package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.FlowStep;
import com.deepsoft.haolifa.model.domain.FlowStepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowStepMapper {
    long countByExample(FlowStepExample example);

    int deleteByExample(FlowStepExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowStep record);

    int insertSelective(FlowStep record);

    List<FlowStep> selectByExample(FlowStepExample example);

    FlowStep selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlowStep record, @Param("example") FlowStepExample example);

    int updateByExample(@Param("record") FlowStep record, @Param("example") FlowStepExample example);

    int updateByPrimaryKeySelective(FlowStep record);

    int updateByPrimaryKey(FlowStep record);
}