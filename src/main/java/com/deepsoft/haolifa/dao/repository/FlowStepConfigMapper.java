package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.FlowStepConfig;
import com.deepsoft.haolifa.model.domain.FlowStepConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowStepConfigMapper {
    long countByExample(FlowStepConfigExample example);

    int deleteByExample(FlowStepConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowStepConfig record);

    int insertSelective(FlowStepConfig record);

    List<FlowStepConfig> selectByExample(FlowStepConfigExample example);

    FlowStepConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlowStepConfig record, @Param("example") FlowStepConfigExample example);

    int updateByExample(@Param("record") FlowStepConfig record, @Param("example") FlowStepConfigExample example);

    int updateByPrimaryKeySelective(FlowStepConfig record);

    int updateByPrimaryKey(FlowStepConfig record);
}