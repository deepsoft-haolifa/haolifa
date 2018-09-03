package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.SysRole;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> getRoles();

    List<RoleDTO> getRolesByUserId(Integer userId);

    int deleteRole(Integer id);

    int insertRole(RoleDTO role);

    int updateRole(RoleDTO role);

}
