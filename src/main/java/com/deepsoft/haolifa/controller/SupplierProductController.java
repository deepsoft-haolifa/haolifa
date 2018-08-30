package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SupplierPorductDTO;
import com.deepsoft.haolifa.model.dto.SupplierProductListDTO;
import com.deepsoft.haolifa.service.SupplierProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"供应商产品管理"})
@RestController
@RequestMapping("/supplier-pro")
public class SupplierProductController {

    @Autowired
    SupplierProductService supplierProductService;

    @ApiOperation("产品添加")
    @PostMapping("save")
    public ResultBean save(@RequestBody SupplierPorductDTO model) {
        return supplierProductService.save(model);
    }

    @ApiOperation("删除产品")
    @GetMapping("delete/{id}")
    public ResultBean delete(@PathVariable("id") Integer id) {
        return supplierProductService.delete(id);
    }

    @ApiOperation("修改产品信息")
    @PostMapping("update")
    public ResultBean update(@RequestBody SupplierPorductDTO model) {
        return supplierProductService.update(model);
    }

    @ApiOperation("查询产品信息")
    @GetMapping("info/{id}")
    public ResultBean getInfo(@PathVariable("id") Integer id) {
        return supplierProductService.getInfo(id);
    }

    @ApiOperation("查询产品列表")
    @PostMapping("list")
    public ResultBean getList(@RequestBody SupplierProductListDTO model) {
        return supplierProductService.getList(model);
    }

}
