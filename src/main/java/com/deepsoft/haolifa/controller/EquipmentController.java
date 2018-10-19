package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.Equipment;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.EquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"资产管理"})
@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;


    @ApiOperation("好利阀设备添加")
    @PostMapping("/save")
    public ResultBean save(@RequestBody EquipmentRequestDTO model) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(model, equipment);
        equipment.setSupplierNo("0");
        return equipmentService.save(equipment);
    }

    @ApiOperation("供应商设备添加")
    @PostMapping("/supplier-save")
    public ResultBean save(@RequestBody SupplierEquipmentRequestDTO model) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(model, equipment);
        if(StringUtils.isEmpty(model.getSupplierNo()) || "0".equals(model.getSupplierNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.SUPPLIER_NO_WRONG);
        }
        return equipmentService.save(equipment);
    }

    @ApiOperation("删除设备信息")
    @GetMapping("/delete/{id}")
    public ResultBean delete(@PathVariable("id") Integer id) {
        return equipmentService.delete(id);
    }

    @ApiOperation("更新好利阀设备信息")
    @PostMapping("update")
    public ResultBean update(@RequestBody EquipmentRequestDTO model) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(model, equipment);
        return equipmentService.update(equipment);
    }

    @ApiOperation("更新供应商设备信息")
    @PostMapping("supplier-update")
    public ResultBean update(@RequestBody SupplierEquipmentRequestDTO model) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(model, equipment);
        if(StringUtils.isEmpty(model.getSupplierNo()) || "0".equals(model.getSupplierNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.SUPPLIER_NO_WRONG);
        }
        return equipmentService.update(equipment);
    }

    @ApiOperation("查询设备详情")
    @GetMapping("getInfo/{id}")
    public ResultBean getInfo(@PathVariable(value = "id") Integer id) {
        return equipmentService.getInfo(id);
    }

    @ApiOperation("获取设备列表")
    @PostMapping("getList")
    public ResultBean getList(@RequestBody EquipmentListDTO model) {
        return equipmentService.getList(model);
    }

    @ApiOperation("添加维修记录")
    @PostMapping("saveMaintainRecord")
    public ResultBean saveMaintainRecord(@RequestBody EquipRepairedRecordDTO model) {
        return equipmentService.saveMaintainRecord(model);
    }

    @ApiOperation("查询维修记录列表")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "设备编号", name = "equipmentNo", dataType = "string", paramType = "query"),
    })
    @GetMapping("getMaintainRecordList/{equipmentNo}")
    public ResultBean getMaintainRecordList(@PathVariable String equipmentNo) {
        return equipmentService.getMaintainRecordList(equipmentNo);
    }


}
