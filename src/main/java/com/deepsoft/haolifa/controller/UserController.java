package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.UserBaseDTO;
import com.deepsoft.haolifa.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaozhihong
 * @create 2018-07-11 15:33
 * @desc
 **/
@Api("用户信息")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService userService;

    @GetMapping("/auth")
    @ApiOperation("获取权限列表")
    @PreAuthorize("hasPermission('/auth','r')")
    public ResultBean index() {
        return ResultBean.success(userService.selectLoginUser());
    }


    @PostMapping("/")
    @ApiOperation("添加用户")
    public ResultBean user(UserBaseDTO userBase){
        return ResultBean.success(userService.insertSysUser(userBase));
    }

}
