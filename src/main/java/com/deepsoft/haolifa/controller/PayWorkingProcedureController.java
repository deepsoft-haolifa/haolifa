package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWorkingProcedureDTO;
import com.deepsoft.haolifa.service.PayWorkingProcedureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author liuyaofei
 * @Date create in 上午11:27 2021/10/16
 * @description 工序明细管理
 */
@Api(tags = "绩效工序明细管理")
@RestController
@RequestMapping("/pay-working-procedure")
public class PayWorkingProcedureController {

    @Resource
    private PayWorkingProcedureService payWorkingProcedureService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestBody PayWorkingProcedureDTO model) {
        return payWorkingProcedureService.pageInfo(model);
    }

    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayWorkingProcedureDTO model) {
        return payWorkingProcedureService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{id}")
    public ResultBean getInfo(@PathVariable("id") Integer id) {
        return payWorkingProcedureService.getInfo(id);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayWorkingProcedureDTO model) {
        return payWorkingProcedureService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{id}")
    public ResultBean del(@PathVariable("id") Integer id) {
        return payWorkingProcedureService.delete(id);
    }


    @ApiOperation("分配任务")
    @GetMapping(value = "assignTask/{productId}")
    public ResultBean assignTask(@PathVariable Integer productId) {
        return payWorkingProcedureService.assignTask(productId);
    }

}
