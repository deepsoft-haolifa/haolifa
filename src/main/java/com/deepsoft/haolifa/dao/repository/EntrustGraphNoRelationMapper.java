package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.EntrustGraphNoRelation;
import com.deepsoft.haolifa.model.domain.EntrustGraphNoRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntrustGraphNoRelationMapper {
    int countByExample(EntrustGraphNoRelationExample example);

    int deleteByExample(EntrustGraphNoRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EntrustGraphNoRelation record);

    int insertSelective(EntrustGraphNoRelation record);

    List<EntrustGraphNoRelation> selectByExample(EntrustGraphNoRelationExample example);

    EntrustGraphNoRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EntrustGraphNoRelation record, @Param("example") EntrustGraphNoRelationExample example);

    int updateByExample(@Param("record") EntrustGraphNoRelation record, @Param("example") EntrustGraphNoRelationExample example);

    int updateByPrimaryKeySelective(EntrustGraphNoRelation record);

    int updateByPrimaryKey(EntrustGraphNoRelation record);
}