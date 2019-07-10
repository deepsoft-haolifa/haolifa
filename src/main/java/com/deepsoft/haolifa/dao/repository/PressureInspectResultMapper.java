package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PressureInspectResult;
import com.deepsoft.haolifa.model.domain.PressureInspectResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PressureInspectResultMapper {
    long countByExample(PressureInspectResultExample example);

    int deleteByExample(PressureInspectResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PressureInspectResult record);

    int insertSelective(PressureInspectResult record);

    List<PressureInspectResult> selectByExample(PressureInspectResultExample example);

    PressureInspectResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PressureInspectResult record, @Param("example") PressureInspectResultExample example);

    int updateByExample(@Param("record") PressureInspectResult record, @Param("example") PressureInspectResultExample example);

    int updateByPrimaryKeySelective(PressureInspectResult record);

    int updateByPrimaryKey(PressureInspectResult record);
}