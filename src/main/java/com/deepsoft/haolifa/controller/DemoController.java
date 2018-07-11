package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: DemoController
 * @description: demo 示例
 * @author: hedong@ibeesaas.com
 * @date: 2018-07-09 21:02
 **/
@Api("demo信息管理")
@RestController
@RequestMapping(value = "/demo")
public class DemoController {
    @Resource
    private DemoService demoService;

    @ApiOperation("获取列表")
    @GetMapping("/list")
    public ResultBean userList() {
        List<SysUser> list = demoService.list();
        return ResultBean.success(list);
    }

    @ApiOperation("新增用户")
    @PostMapping("/save")
    public ResultBean save(SysUser user) {
        int add = demoService.add(user);
        return ResultBean.success(add);
    }

    @ApiOperation("更新用户")
    @ApiImplicitParam(name = "user", value = "单个用户信息", dataType = "SysUser")
    @PutMapping("/update")
    public ResultBean update(SysUser user) {
        int update = demoService.update(user);
        return ResultBean.success(update);
    }

/*    @ApiOperation("根据登录名获取用户信息")
    @GetMapping("/user-info")
    public ResultBean userInfo(String loginName) {
        SysUser sysUser = demoService.sysUserInfo(loginName);
        return ResultBean.success(sysUser);
    }*/

}
