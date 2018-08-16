package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    SysUserService sysUserService;
    /**
     * 获取登录用户id
     *
     * @return
     */
    protected int getLoginUserId() {
        CustomUser customUser = sysUserService.selectLoginUser();
        return customUser != null ? customUser.getId() : 1;
    }
}
