package com.deepsoft.haolifa.dao.repository.extend;


import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.model.domain.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyPermissionMapper {

    List<SysPermission> findAll();

    List<CustomGrantedAuthority> findByAdminUserId(long userId);

}