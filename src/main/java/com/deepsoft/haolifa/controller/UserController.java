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
@Api(tags = {"人员管理"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService userService;


    @GetMapping("")
    @ApiOperation("获取用户列表")
    public ResultBean users(@RequestParam(name = "pageNum", defaultValue = "1")
                                    Integer pageNum,
                            @RequestParam(name = "pageSize", defaultValue = "10")
                                    Integer pageSize) {
        return ResultBean.success(userService.getUserList(pageNum, pageSize));
    }

    @GetMapping("/{id}")
    @ApiOperation("获取单个用户")
    public ResultBean getUser(@PathVariable("id") Integer id) {
        return ResultBean.success(userService.getSysUser(id));
    }


    @PostMapping("")
    @ApiOperation("添加员工")
    public ResultBean user(@RequestBody UserBaseDTO userBase) {
        return ResultBean.success(userService.insertSysUser(userBase));
    }


    @PutMapping("")
    @ApiOperation("修改用户")
    public ResultBean updateUser(@RequestBody UserBaseDTO userBase) {
        return ResultBean.success(userService.updateSysUser(userBase));
    }

    @PutMapping("/{id}/pwd")
    @ApiOperation("重置用户密码")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResultBean initUserPwd(@PathVariable("id") Integer id) {
        return ResultBean.success(userService.initPwd(id));
    }


    @PutMapping("/{id}/changePwd")
    @ApiOperation("修改用户密码")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResultBean changeUserPwd(@PathVariable("id") Integer id, @RequestParam("newPassword") String newPassword) {
        return ResultBean.success(userService.changePwd(id, newPassword));
    }


    @DeleteMapping("/{id}")
    @ApiOperation("删除用户")
    public ResultBean deleteUser(@PathVariable("id") Integer id) {
        return ResultBean.success(userService.deleteSysUser(id));
    }


    @PutMapping("/{id}")
    @ApiOperation("禁用/启用用户")
    public ResultBean closeUser(@PathVariable("id") Integer id) {
        return ResultBean.success(userService.closeUser(id));
    }


    @PostMapping("/{userId}/role")
    @ApiOperation("给用户分配角色")
    public ResultBean insertUserRole(@PathVariable("userId") Integer userId, @RequestBody Integer[] roleIds) {
        return ResultBean.success(userService.insertUserRole(userId, roleIds));
    }

}
