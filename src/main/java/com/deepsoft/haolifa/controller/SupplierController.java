package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SupplierRequestDTO;
import com.deepsoft.haolifa.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"供应商管理"})
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping("/save")
    @ApiOperation("添加供应商信息")
    public ResultBean save(@RequestBody SupplierRequestDTO model) {
        return supplierService.saveInfo(model);
    }

    @PostMapping("/update")
    @ApiOperation("更新供应商信息")
    public ResultBean update(@RequestBody SupplierRequestDTO model) {
        return supplierService.updateInfo(model);
    }

    @GetMapping("/delete")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "供应商唯一标示id", name = "id", dataType = "string", paramType = "query"),
    })
    @ApiOperation("删除供应商")
    public ResultBean delete(@RequestParam Integer id) {
        return supplierService.deleteInfo(id);
    }

    @GetMapping("/info")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "供应商唯一标示id", name = "id", dataType = "string", paramType = "query"),
    })
    @ApiOperation("获取供应商详情")
    public ResultBean getInfo(@RequestParam Integer id) {
        return supplierService.getInfo(id);
    }

    @GetMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "供应商编号", name = "supplierNo", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "供应商名称", name = "supplierName", dataType = "string", paramType = "query"),
            @ApiImplicitParam(required = true, value = "页码", name = "currentPage", dataType = "int", paramType = "query"),
            @ApiImplicitParam(required = true, value = "展示数量", name = "pageSize", dataType = "int", paramType = "query")
    })
    @ApiOperation("获取供应商列表")
    public ResultBean getList(@RequestParam Integer currentPage,@RequestParam Integer pageSize,String supplierNo,String supplierName) {
        return supplierService.getList(currentPage,pageSize,supplierName,supplierNo);
    }

}
