package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SysRoleUser;
import com.deepsoft.haolifa.model.domain.SysRoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleUserMapper {
    long countByExample(SysRoleUserExample example);

    int deleteByExample(SysRoleUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleUser record);

    int insertSelective(SysRoleUser record);

    List<SysRoleUser> selectByExample(SysRoleUserExample example);

    SysRoleUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleUser record, @Param("example") SysRoleUserExample example);

    int updateByExample(@Param("record") SysRoleUser record, @Param("example") SysRoleUserExample example);

    int updateByPrimaryKeySelective(SysRoleUser record);

    int updateByPrimaryKey(SysRoleUser record);
}