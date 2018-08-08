package com.deepsoft.haolifa.dao.repository.extend;


import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.model.domain.SysPermission;
import com.deepsoft.haolifa.model.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface MyPermissionMapper {

    List<SysRole> findRolesByUserId(long userId);

    int findPermissiosByRoles(@Param("roles") List<String> roles,
                                              @Param("url") String url, @Param("permName") String permName);

}