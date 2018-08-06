package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.MaterialInspectResult;
import com.deepsoft.haolifa.model.domain.MaterialInspectResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialInspectResultMapper {
    long countByExample(MaterialInspectResultExample example);

    int deleteByExample(MaterialInspectResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MaterialInspectResult record);

    int insertSelective(MaterialInspectResult record);

    List<MaterialInspectResult> selectByExample(MaterialInspectResultExample example);

    MaterialInspectResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MaterialInspectResult record, @Param("example") MaterialInspectResultExample example);

    int updateByExample(@Param("record") MaterialInspectResult record, @Param("example") MaterialInspectResultExample example);

    int updateByPrimaryKeySelective(MaterialInspectResult record);

    int updateByPrimaryKey(MaterialInspectResult record);
}