package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SupplierPorductDTO;
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
    @PostMapping("info/{id}")
    public ResultBean getInfo(@PathVariable("id") Integer id) {
        return supplierProductService.getInfo(id);
    }

    @ApiOperation("查询产品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "产品类型：0 供货原料 1 其他原料", name = "materialType", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "产品名称", name = "materialName", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "页码", name = "currentPage", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "展示数量", name = "pageSize", dataType = "int", paramType = "query")
    })
    @PostMapping("list")
    public ResultBean getList(@RequestParam Integer currentPage, @RequestParam Integer pageSize, Integer materialType, String materialName) {
        return supplierProductService.getList(currentPage, pageSize, materialType, materialName);
    }

}
