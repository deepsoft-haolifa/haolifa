package com.deepsoft.haolifa.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.model.domain.Supplier;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SupplierListDTO;
import com.deepsoft.haolifa.model.dto.SupplierRequestDTO;
import com.deepsoft.haolifa.service.SupplierService;
import io.swagger.annotations.*;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = {"供应商管理"})
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping("/save")
    @ApiOperation("添加供应商信息")
    @ApiResponses({
            @ApiResponse(code = 0000,message = "success",response = Integer.class,reference = "code 码为0000"),
            @ApiResponse(code = 0001,message = "fail",response = ResultBean.class,reference = "code 码为0001")
    })
    public ResultBean save(@RequestBody SupplierRequestDTO model) {
        return supplierService.saveInfo(model);
    }

    @PostMapping("/update")
    @ApiOperation("更新供应商信息")
    @ApiResponses({
            @ApiResponse(code = 0000,message = "success",response = Integer.class,reference = "code 码为0000"),
            @ApiResponse(code = 0001,message = "fail",response = ResultBean.class,reference = "code 码为0001")
    })
    public ResultBean update(@RequestBody SupplierRequestDTO model) {
        return supplierService.updateInfo(model);
    }

    @GetMapping("/delete")
    @ApiOperation("删除供应商")
    @ApiImplicitParam(name = "id",value = "唯一标示",dataType = "int",paramType = "query",required = true)
    @ApiResponses({
            @ApiResponse(code = 0000,message = "success",response = Integer.class,reference = "code 码为0000"),
            @ApiResponse(code = 0001,message = "fail",response = ResultBean.class,reference = "code 码为0001")
    })
    public ResultBean delete(@RequestParam Integer id) {
        return supplierService.deleteInfo(id);
    }

    @GetMapping("/info")
    @ApiOperation("获取供应商详情")
    @ApiImplicitParam(name = "id",value = "唯一标示",dataType = "int",paramType = "query",required = true)
    @ApiResponses({
            @ApiResponse(code = 0000,message = "success",response = Supplier.class,reference = "code 码为0000"),
            @ApiResponse(code = 0001,message = "fail",response = ResultBean.class,reference = "code 码为0001"),
            @ApiResponse(code = 0002,message = "参数错误",response = ResultBean.class,reference = "code 码为0002"),
            @ApiResponse(code = 3404,message = "资源不存在",response = ResultBean.class)
    })
    public ResultBean getInfo(@RequestParam Integer id) {
        return supplierService.getInfo(id);
    }

    @PostMapping("/list")
    @ApiResponses({
            @ApiResponse(code = 0000,message = "success",response = Supplier.class,reference = "code 码为0000"),
            @ApiResponse(code = 0001,message = "fail",response = ResultBean.class,reference = "code 码为0001")
    })
    @ApiOperation("获取供应商列表")
    public ResultBean getList(@RequestBody SupplierListDTO model) {
        return supplierService.getList(model);
    }

    @GetMapping("/list-all")
    @ApiOperation("查询供应商列表")
    public ResultBean listByName() {
        return supplierService.listByName();
    }

    @PostMapping("/approve/{supplierNo}")
    @ApiOperation("发起合格审批")
    public ResultBean approve(@PathVariable("supplierNo") String supplierNo) {
        return supplierService.approve(supplierNo);
    }

    @GetMapping("/evaluation/records")
    @ApiOperation("供应商合格审批记录")
    public ResultBean evaluationRecords(@RequestParam String supplierNo) {
        return supplierService.evaluationRecords(supplierNo);
    }



}
