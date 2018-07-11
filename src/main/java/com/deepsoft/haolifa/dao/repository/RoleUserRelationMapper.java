package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.RoleUserRelation;
import com.deepsoft.haolifa.model.domain.RoleUserRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleUserRelationMapper {
    long countByExample(RoleUserRelationExample example);

    int deleteByExample(RoleUserRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleUserRelation record);

    int insertSelective(RoleUserRelation record);

    List<RoleUserRelation> selectByExample(RoleUserRelationExample example);

    RoleUserRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleUserRelation record, @Param("example") RoleUserRelationExample example);

    int updateByExample(@Param("record") RoleUserRelation record, @Param("example") RoleUserRelationExample example);

    int updateByPrimaryKeySelective(RoleUserRelation record);

    int updateByPrimaryKey(RoleUserRelation record);
}