package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.BaseApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.*;


public class CustomUserServiceImplTest extends BaseApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void loadUserByUsername() {
        System.out.println(passwordEncoder.encode("admin"));
    }
}