package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.service.SysUserService;
import org.springframework.security.core.context.SecurityContextHolder;

public class SysUserServiceImpl implements SysUserService {

    @Override
    public CustomUser selectLoginUser() {
        return (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
