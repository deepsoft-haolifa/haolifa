package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SupplierPorductDTO;
import com.deepsoft.haolifa.service.SupplierProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @PostMapping("list")
    public ResultBean getList(@ApiParam(required = true, value = "页码", defaultValue = "1") @RequestParam Integer currentPage,
                              @ApiParam(required = true, value = "显示数量", defaultValue = "10") @RequestParam Integer pageSize,
                              @ApiParam(required = true, value = "产品类型：0 供货原料 1 其他原料",allowableValues = "0,1") Integer materialType,
                              @ApiParam(value = "产品名称") String materialName) {
        return supplierProductService.getList(currentPage, pageSize, materialType, materialName);
    }

}
