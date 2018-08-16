package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.PermissionNode;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = {"菜单相关"})
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation("获取当前用户菜单")
    @GetMapping("")
    public ResultBean getMenu(){
        return ResultBean.success(permissionService.getMenu());
    }

}
