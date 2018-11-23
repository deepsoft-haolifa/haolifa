package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.RoleDTO;
import com.deepsoft.haolifa.model.vo.UserPageVO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> getRoles();

    List<RoleDTO> getRolesByUserId(Integer userId);

    int deleteRole(Integer id);

    int insertRole(RoleDTO role);

    int updateRole(RoleDTO role);

    List<UserPageVO> getBuyers();

}
