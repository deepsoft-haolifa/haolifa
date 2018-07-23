package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SysPermissionRole;
import com.deepsoft.haolifa.model.domain.SysPermissionRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionRoleMapper {
    long countByExample(SysPermissionRoleExample example);

    int deleteByExample(SysPermissionRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPermissionRole record);

    int insertSelective(SysPermissionRole record);

    List<SysPermissionRole> selectByExample(SysPermissionRoleExample example);

    SysPermissionRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPermissionRole record, @Param("example") SysPermissionRoleExample example);

    int updateByExample(@Param("record") SysPermissionRole record, @Param("example") SysPermissionRoleExample example);

    int updateByPrimaryKeySelective(SysPermissionRole record);

    int updateByPrimaryKey(SysPermissionRole record);
}