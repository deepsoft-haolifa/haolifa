package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.SysUser;

import java.util.List;

/**
 * @description: Demo
 **/
public interface DemoService {

    List<SysUser> list();

    int add(SysUser sysUser);

    int update(SysUser sysUser);

    SysUser sysUserInfo(String loginName);

}
