package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.RoleDTO;
import com.deepsoft.haolifa.service.MenuService;
import com.deepsoft.haolifa.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@Api(tags = {"角色管理"})
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @GetMapping("/{userId}")
    @ApiOperation("根据用户id获取某用户的所有角色")
    public ResultBean getRoles(@PathVariable("userId")Integer userId){
        return ResultBean.success(roleService.getRolesByUserId(userId));
    }

    @GetMapping("")
    @ApiOperation("获取所有角色")
    public ResultBean getRoles(){
        return ResultBean.success(roleService.getRoles());
    }

    @PostMapping("")
    @ApiOperation("添加角色")
    public ResultBean insertRole(@RequestBody RoleDTO roleDTO){
        return ResultBean.success(roleService.insertRole(roleDTO));
    }

    @DeleteMapping("/{roleId}")
    @ApiOperation("删除角色")
    public ResultBean deleteRole(@PathVariable("roleId")Integer roleId){
        return ResultBean.success(roleService.deleteRole(roleId));
    }

    @PutMapping("")
    @ApiOperation("修改角色")
    public ResultBean updateRole(@RequestBody RoleDTO roleDTO){
        return ResultBean.success(roleService.updateRole(roleDTO));
    }

    @ApiOperation("获取角色的菜单")
    @GetMapping("/{roleId}/menu")
    public ResultBean getMenuesByRole(@PathVariable("roleId")Integer id){
        return ResultBean.success(menuService.selectByRoleId(id));
    }

    @ApiOperation("给角色分配菜单")
    @PostMapping("/{roleId}/menu")
    public ResultBean getMenuesByRole(@PathVariable("roleId")Integer id, @RequestBody Integer[] menuIds){
        return ResultBean.success(menuService.insertRoleMenu(id, menuIds));
    }


    @ApiOperation("角色树状结构")
    @PostMapping("/roleTree")
    public ResultBean roleTree(){
        return ResultBean.success(roleService.roleTree());
    }

}