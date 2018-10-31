package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.FlowInstance;
import com.deepsoft.haolifa.model.domain.FlowInstanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowInstanceMapper {
    long countByExample(FlowInstanceExample example);

    int deleteByExample(FlowInstanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowInstance record);

    int insertSelective(FlowInstance record);

    List<FlowInstance> selectByExample(FlowInstanceExample example);

    FlowInstance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlowInstance record, @Param("example") FlowInstanceExample example);

    int updateByExample(@Param("record") FlowInstance record, @Param("example") FlowInstanceExample example);

    int updateByPrimaryKeySelective(FlowInstance record);

    int updateByPrimaryKey(FlowInstance record);
}