package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.domain.Equipment;
import com.deepsoft.haolifa.model.dto.SupplierEquipmentRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.EquipmentService;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("supplierEquip")
@Api(tags = {"供应商设备管理"})
public class SupplierEquipController {

    @Autowired
    EquipmentService equipmentService;

    @ApiOperation("设备添加")
    @PostMapping("/save")
    public ResultBean save(@RequestBody SupplierEquipmentRequestDTO model) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(model, equipment);
        // TODO
        equipment.setCreateUserId(1);
        return equipmentService.save(equipment);
    }

    @ApiOperation("删除设备信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "设备唯一标示id", name = "id", dataType = "string", paramType = "query"),
    })
    @GetMapping("/delete/{id}")
    public ResultBean delete(@PathVariable("id") Integer id) {
        return equipmentService.delete(id);
    }

    @ApiOperation("更新设备信息")
    @PostMapping("update")
    public ResultBean update(@RequestBody SupplierEquipmentRequestDTO model) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(model, equipment);
        return equipmentService.update(equipment);
    }

    @ApiOperation("查询设备详情")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "设备唯一标示id", name = "id", dataType = "string", paramType = "query"),
    })
    @GetMapping("getInfo/{id}")
    public ResultBean getInfo(@PathVariable("id") Integer id) {
        return equipmentService.getInfo(id);
    }

    @ApiOperation("获取设备列表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "设备名称", name = "name", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "设备编号", name = "equipmentNo", dataType = "string", paramType = "query"),
            @ApiImplicitParam(required = true, value = "页码", name = "currentPage", dataType = "int", paramType = "query"),
            @ApiImplicitParam(required = true, value = "展示数量", name = "pageSize", dataType = "int", paramType = "query")
    })
    @GetMapping("getList")
    public ResultBean getList(@RequestParam Integer currentPage, @RequestParam Integer pageSize, String name, String equipmentNo) {
        return equipmentService.getList(currentPage, pageSize, name, equipmentNo);
    }

}
