package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ProInspectUnqualified;
import com.deepsoft.haolifa.model.domain.ProInspectUnqualifiedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProInspectUnqualifiedMapper {
    long countByExample(ProInspectUnqualifiedExample example);

    int deleteByExample(ProInspectUnqualifiedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProInspectUnqualified record);

    int insertSelective(ProInspectUnqualified record);

    List<ProInspectUnqualified> selectByExample(ProInspectUnqualifiedExample example);

    ProInspectUnqualified selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProInspectUnqualified record, @Param("example") ProInspectUnqualifiedExample example);

    int updateByExample(@Param("record") ProInspectUnqualified record, @Param("example") ProInspectUnqualifiedExample example);

    int updateByPrimaryKeySelective(ProInspectUnqualified record);

    int updateByPrimaryKey(ProInspectUnqualified record);
}