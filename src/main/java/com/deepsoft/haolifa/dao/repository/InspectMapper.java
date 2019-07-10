package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.Inspect;
import com.deepsoft.haolifa.model.domain.InspectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InspectMapper {
    int countByExample(InspectExample example);

    int deleteByExample(InspectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Inspect record);

    int insertSelective(Inspect record);

    List<Inspect> selectByExample(InspectExample example);

    Inspect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Inspect record, @Param("example") InspectExample example);

    int updateByExample(@Param("record") Inspect record, @Param("example") InspectExample example);

    int updateByPrimaryKeySelective(Inspect record);

    int updateByPrimaryKey(Inspect record);
}