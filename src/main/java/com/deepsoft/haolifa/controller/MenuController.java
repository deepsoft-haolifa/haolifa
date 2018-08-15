package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.PermissionNode;
import com.deepsoft.haolifa.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhaozhihong
 * @create 2018-08-15 13:39
 * @desc 菜单
 **/
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private PermissionService permissionService;


    @GetMapping("/auth/menu")
    public List<PermissionNode> getMenu(){
        return permissionService.getMenu();
    }

}
