package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.HomeApiService;
import com.deepsoft.haolifa.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"首页：待办事项&快捷入口"})
public class HomeController {

    @Autowired
    private HomeApiService homeApiService;
    @Autowired
    private RoleService roleService;

    @ApiOperation("获取发起流程的快捷入口")
    @GetMapping("/quick-start")
    public ResultBean getQuickStartMenu(){
        return ResultBean.success(homeApiService.getQuickStartMenu());
    }

    @ApiOperation("待办事项")
    @GetMapping("/todo")
    public ResultBean getTodoItems(){
        return ResultBean.success(homeApiService.getTodoItems());
    }

    @ApiOperation("采购员列表")
    @GetMapping("/buyers")
    public ResultBean getBuyerList(){
        return ResultBean.success(roleService.getBuyers());
    }


}
