package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"登陆登出"})
@RestController
public class LoginController {

    @Autowired
    private SysUserService userService;

    @ApiOperation("登陆")
    @PostMapping("/login")
    public ResultBean login(String username, String password){
        return ResultBean.success(userService.selectUserInfo());
    }

    @ApiOperation("登出")
    @PostMapping("/logout")
    public ResultBean logout(){
        return ResultBean.success("注销成功");
    }

}
