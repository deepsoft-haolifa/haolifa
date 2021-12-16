package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayOrderUserRelationProcedureDTO;
import com.deepsoft.haolifa.model.dto.pay.PayWorkingProcedureDTO;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.PayOrderUserRelationProcedureService;
import com.deepsoft.haolifa.service.PayWorkingProcedureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private OrderProductService orderProductService;
    @Resource
    private PayOrderUserRelationProcedureService payOrderUserRelationProcedureService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestBody PayWorkingProcedureDTO model) {
        return payWorkingProcedureService.pageInfo(model);
    }

    @ApiOperation("获取所有列表")
    @PostMapping("/getAllList")
    public ResultBean getAllList(@RequestBody PayWorkingProcedureDTO model) {
        return payWorkingProcedureService.getAllList(model);
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


    @ApiOperation("获取订单的产品列表（只包含产品）")
    @GetMapping("/product-list")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    public ResultBean productList(String orderNo) {
        return ResultBean.success(orderProductService.getOrderProductList(orderNo));
    }

    @ApiOperation("分配任务按钮")
    @GetMapping(value = "assignTask/{orderNo}")
    public ResultBean assignTask(@PathVariable String orderNo) {
        return payWorkingProcedureService.assignTask(orderNo);
    }

    @ApiOperation("分配任务保存按钮")
    @PostMapping(value = "/saveTask")
    public ResultBean saveTask (@RequestBody PayOrderUserRelationProcedureDTO procedure) {
        return payOrderUserRelationProcedureService.insertSelective(procedure);
    }


}
