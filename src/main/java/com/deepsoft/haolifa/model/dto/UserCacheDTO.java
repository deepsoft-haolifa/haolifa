package com.deepsoft.haolifa.model.dto;

import com.deepsoft.haolifa.model.domain.SysUser;
import lombok.Data;

import java.util.List;

@Data
public class UserCacheDTO extends SysUser {

    /**
     * 角色列表
     */
    private List<RoleDTO> roles;

}
