package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ProInspectResult;
import com.deepsoft.haolifa.model.domain.ProInspectResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProInspectResultMapper {
    long countByExample(ProInspectResultExample example);

    int deleteByExample(ProInspectResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProInspectResult record);

    int insertSelective(ProInspectResult record);

    List<ProInspectResult> selectByExample(ProInspectResultExample example);

    ProInspectResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProInspectResult record, @Param("example") ProInspectResultExample example);

    int updateByExample(@Param("record") ProInspectResult record, @Param("example") ProInspectResultExample example);

    int updateByPrimaryKeySelective(ProInspectResult record);

    int updateByPrimaryKey(ProInspectResult record);
}