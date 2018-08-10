package com.deepsoft.haolifa.dao.repository.extend;


import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.model.domain.SysPermission;
import com.deepsoft.haolifa.model.domain.SysRole;
import com.deepsoft.haolifa.model.dto.CustomPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Mapper
public interface MyPermissionMapper {

    Set<SysRole> findRolesByUserId(long userId);

    Set<CustomPermission> findPermissiosByRoles(@Param("roles") List<String> roles);

}