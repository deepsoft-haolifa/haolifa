package com.deepsoft.haolifa.dao.repository.extend;


import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.model.domain.SysPermission;
import com.deepsoft.haolifa.model.domain.SysRole;
import com.deepsoft.haolifa.model.dto.CustomPermission;
import com.deepsoft.haolifa.model.vo.MenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Mapper
public interface MyPermissionMapper {

    Set<SysRole> findRolesByUserId(long userId);

    List<CustomPermission> findPermissiosByRoles(@Param("roles") List<String> roles);

    List<MenuVO> findPermissiosByRoleId(Integer roleId);

    int inserRoleMenu(@Param("roleId") Integer roleId, @Param("menuIds") Integer[] menuIds);

}