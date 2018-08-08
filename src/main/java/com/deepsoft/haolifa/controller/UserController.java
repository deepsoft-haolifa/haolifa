package com.deepsoft.haolifa.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaozhihong
 * @create 2018-07-11 15:33
 * @desc
 **/
@RestController
public class UserController {

    @RequestMapping("/")
    @PreAuthorize("hasPermission('/','r')")
    public List<GrantedAuthority> index() {
        return new ArrayList<>(SecurityContextHolder
                .getContext().getAuthentication().getAuthorities());
    }
}
