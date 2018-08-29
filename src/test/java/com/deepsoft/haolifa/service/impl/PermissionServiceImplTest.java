package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.BaseApplicationTests;
import com.deepsoft.haolifa.service.PermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class PermissionServiceImplTest extends BaseApplicationTests {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void getMenu() {
        System.out.println(permissionService.getMenu());
    }
}