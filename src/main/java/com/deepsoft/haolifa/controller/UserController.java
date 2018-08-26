package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.UserBaseDTO;
import com.deepsoft.haolifa.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaozhihong
 * @create 2018-07-11 15:33
 * @desc
 **/
@Api(tags = {"人事管理"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService userService;

    @GetMapping("/auth")
    @ApiOperation("获取当前用户权限列表")
    public ResultBean index() {
        return ResultBean.success(userService.selectLoginUser());
    }


    @GetMapping("")
    @ApiOperation("获取用户列表")
    public ResultBean users(@RequestParam(name = "pageNum", defaultValue = "0")
                            Integer pageNum,
                            @RequestParam(name = "pageSize", defaultValue = "10")
                            Integer pageSize){
        return ResultBean.success(userService.getUserList(pageNum, pageSize));
    }

    @GetMapping("/{id}")
    @ApiOperation("获取单个用户")
    public ResultBean getUser(@PathVariable("id") Integer id){
        return ResultBean.success(userService.getSysUser(id));
    }

    @GetMapping("/all")
    @ApiOperation("获取所有用户")
    public ResultBean getUser(@RequestParam(name = "pageNum", defaultValue = "1")Integer pageNum,
                              @RequestParam(name = "pageSize", defaultValue = "10")Integer pageSize){
        return ResultBean.success(userService.getUserList(pageNum, pageSize));
    }


    @PostMapping("")
    @ApiOperation("添加员工")
    public ResultBean user(UserBaseDTO userBase){
        return ResultBean.success(userService.insertSysUser(userBase));
    }


    @PutMapping("")
    @ApiOperation("修改用户")
    public ResultBean updateUser(UserBaseDTO userBase){
        return ResultBean.success(userService.updateSysUser(userBase));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除用户")
    public ResultBean deleteUser(@PathVariable("id") Integer id){
        return ResultBean.success(deleteUser(id));
    }

}
