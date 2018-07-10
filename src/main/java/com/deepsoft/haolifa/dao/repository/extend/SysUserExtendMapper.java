package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @description: 用户额外Mapper
 **/
public interface SysUserExtendMapper {

   SysUser selectByLoginName(@Param("loginName")String loginName);
}
