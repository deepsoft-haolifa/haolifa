package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.BaseApplicationTests;
import com.deepsoft.haolifa.service.SysUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class SysUserServiceImplTest extends BaseApplicationTests {

    @Autowired
    private SysUserService userService;

    @Test
    public void getSysUser() {
        System.out.println(JSON.toJSONString(userService.getSysUser(1)));
    }
}