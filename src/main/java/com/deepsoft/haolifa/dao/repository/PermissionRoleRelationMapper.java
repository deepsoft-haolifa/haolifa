package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PermissionRoleRelation;
import com.deepsoft.haolifa.model.domain.PermissionRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionRoleRelationMapper {
    long countByExample(PermissionRoleRelationExample example);

    int deleteByExample(PermissionRoleRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PermissionRoleRelation record);

    int insertSelective(PermissionRoleRelation record);

    List<PermissionRoleRelation> selectByExample(PermissionRoleRelationExample example);

    PermissionRoleRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PermissionRoleRelation record, @Param("example") PermissionRoleRelationExample example);

    int updateByExample(@Param("record") PermissionRoleRelation record, @Param("example") PermissionRoleRelationExample example);

    int updateByPrimaryKeySelective(PermissionRoleRelation record);

    int updateByPrimaryKey(PermissionRoleRelation record);
}