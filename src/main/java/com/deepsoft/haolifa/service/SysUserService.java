package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.UserBaseDTO;

public interface SysUserService {

    /**
     * 获取当前用户的认证信息，角色 权限等
     * @return
     */
    CustomUser selectLoginUser();

    /**
     * 获取用户详细信息
     * @param userId
     * @return
     */
    SysUser getSysUser(Integer userId);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertSysUser(UserBaseDTO user);

}
