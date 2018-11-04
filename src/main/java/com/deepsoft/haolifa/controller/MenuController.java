package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.vo.MenuVO;
import com.deepsoft.haolifa.service.MenuService;
import com.deepsoft.haolifa.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaozhihong
 * @create 2018-08-15 13:39
 * @desc 菜单
 **/
@Api(tags = {"菜单相关"})
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private MenuService menuService;

    @ApiOperation("获取当前用户菜单")
    @GetMapping("")
    public ResultBean getMenu(){
        return ResultBean.success(permissionService.getMenu("m"));
    }


    @ApiOperation("获取菜单列表")
    @GetMapping("/list")
    public ResultBean getAllMenus(){
        return ResultBean.success(menuService.getMenuList("m"));
    }


    @ApiOperation("获取单个菜单")
    @GetMapping("/{id}")
    public ResultBean getMenuById(@PathVariable("id")Integer id){
        return ResultBean.success(menuService.getMenusById(id, "m"));
    }

    @ApiOperation("删除菜单")
    @DeleteMapping("/{id}")
    public ResultBean deleteMenu(@PathVariable("id")Integer id){
        return ResultBean.success(menuService.deleteMenu(id));
    }

    @ApiOperation("添加菜单")
    @PostMapping("")
    public ResultBean addMenu(@RequestBody MenuVO menuVO){
        return ResultBean.success(menuService.insertMenu(menuVO));
    }

    @ApiOperation("修改菜单")
    @PutMapping("")
    public ResultBean updateMenu(@RequestBody MenuVO menuVO){
        return ResultBean.success(menuService.updateMenu(menuVO));
    }

}
