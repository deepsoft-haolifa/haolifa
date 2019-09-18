package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.GraphNoRel;
import com.deepsoft.haolifa.model.domain.GraphNoRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GraphNoRelMapper {
    int countByExample(GraphNoRelExample example);

    int deleteByExample(GraphNoRelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GraphNoRel record);

    int insertSelective(GraphNoRel record);

    List<GraphNoRel> selectByExample(GraphNoRelExample example);

    GraphNoRel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GraphNoRel record, @Param("example") GraphNoRelExample example);

    int updateByExample(@Param("record") GraphNoRel record, @Param("example") GraphNoRelExample example);

    int updateByPrimaryKeySelective(GraphNoRel record);

    int updateByPrimaryKey(GraphNoRel record);
}