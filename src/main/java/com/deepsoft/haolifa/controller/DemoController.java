package com.deepsoft.haolifa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: DemoController
 * @description: demo 示例
 * @author: hedong@ibeesaas.com
 * @date: 2018-07-09 21:02
 **/
@Api("demo信息管理")
@RestController
public class DemoController {

    @ApiOperation("获取列表")
    @GetMapping("list")
    public List userList() {
        List<String> userList = new ArrayList<>();
        userList.add("abc");
        return userList;
    }
}
