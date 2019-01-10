package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PressureInspectUnqualified;
import com.deepsoft.haolifa.model.domain.PressureInspectUnqualifiedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PressureInspectUnqualifiedMapper {
    long countByExample(PressureInspectUnqualifiedExample example);

    int deleteByExample(PressureInspectUnqualifiedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PressureInspectUnqualified record);

    int insertSelective(PressureInspectUnqualified record);

    List<PressureInspectUnqualified> selectByExample(PressureInspectUnqualifiedExample example);

    PressureInspectUnqualified selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PressureInspectUnqualified record, @Param("example") PressureInspectUnqualifiedExample example);

    int updateByExample(@Param("record") PressureInspectUnqualified record, @Param("example") PressureInspectUnqualifiedExample example);

    int updateByPrimaryKeySelective(PressureInspectUnqualified record);

    int updateByPrimaryKey(PressureInspectUnqualified record);
}