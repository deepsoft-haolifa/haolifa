package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@Api(tags = {"角色管理"})
public class RoleController {

    @RequestMapping("/{userId}")
    public ResultBean getRoles(){
        return null;
    }

}