package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.domain.Equipment;
import com.deepsoft.haolifa.model.dto.EquipRepairedRecordDTO;
import com.deepsoft.haolifa.model.dto.EquipmentRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.EquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"好利阀设备管理"})
@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;


    @ApiOperation("设备添加")
    @PostMapping("/save")
    public ResultBean save(@RequestBody EquipmentRequestDTO model) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(model, equipment);
        // TODO 需替换为真实userId
        equipment.setCreateUserId(1);
        return equipmentService.save(equipment);
    }

    @ApiOperation("删除设备信息")
    @GetMapping("/delete/{id}")
    public ResultBean delete(@PathVariable("id") Integer id) {
        return equipmentService.delete(id);
    }

    @ApiOperation("更新设备信息")
    @PostMapping("update")
    public ResultBean update(@RequestBody EquipmentRequestDTO model) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(model, equipment);
        return equipmentService.update(equipment);
    }

    @ApiOperation("查询设备详情")
    @GetMapping("getInfo/{id}")
    public ResultBean getInfo(@PathVariable("id") Integer id) {
        return equipmentService.getInfo(id);
    }

    @ApiOperation("获取设备列表")
    @GetMapping("getList")
    public ResultBean getList(@RequestParam Integer currentPage, @RequestParam Integer pageSize, String name, String equipmentNo) {
        return equipmentService.getList(currentPage, pageSize, name, equipmentNo);
    }

    @ApiOperation("添加维修记录")
    @PostMapping("saveMaintainRecord")
    public ResultBean saveMaintainRecord(@RequestBody EquipRepairedRecordDTO model) {
        return equipmentService.saveMaintainRecord(model);
    }

    @ApiOperation("查询维修记录列表")
    @GetMapping("getMaintainRecordList/{equipmentNo}")
    public ResultBean getMaintainRecordList(@PathVariable String equipmentNo) {
        return equipmentService.getMaintainRecordList(equipmentNo);
    }


}
