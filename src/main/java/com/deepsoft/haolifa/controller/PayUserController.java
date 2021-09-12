package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayUserDTO;
import com.deepsoft.haolifa.service.PayUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author liuyaofei
 * @Date create in 上午11:37 2021/9/11
 * @description 人员管理
 */
@Api(tags = "人员管理")
@RestController
@RequestMapping("/pay-user")
public class PayUserController {

    @Resource
    private PayUserService payUserService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestBody PayUserDTO model) {
        return payUserService.pageInfo(model);
    }


    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayUserDTO model) {
        return payUserService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{userId}")
    public ResultBean getInfo(@PathVariable("userId") Integer userId) {
        return payUserService.getInfo(userId);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayUserDTO model) {
        return payUserService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{userId}")
    public ResultBean del(@PathVariable("userId") Integer userId) {
        return payUserService.delete(userId);
    }

}
