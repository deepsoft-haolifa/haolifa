package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SprayColorRelation;
import com.deepsoft.haolifa.model.domain.SprayColorRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SprayColorRelationMapper {
    int countByExample(SprayColorRelationExample example);

    int deleteByExample(SprayColorRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SprayColorRelation record);

    int insertSelective(SprayColorRelation record);

    List<SprayColorRelation> selectByExample(SprayColorRelationExample example);

    SprayColorRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SprayColorRelation record, @Param("example") SprayColorRelationExample example);

    int updateByExample(@Param("record") SprayColorRelation record, @Param("example") SprayColorRelationExample example);

    int updateByPrimaryKeySelective(SprayColorRelation record);

    int updateByPrimaryKey(SprayColorRelation record);
}