package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.replaceMaterial.ReplaceMaterialAuditDTO;
import com.deepsoft.haolifa.model.dto.replaceMaterial.ReplaceMaterialDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.replaceMaterial.ReplaceMaterialConditionDTO;
import com.deepsoft.haolifa.service.ReplaceMaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"更换料"})
@RestController
@RequestMapping("/replace-material")
public class ReplaceMaterialController {
    @Autowired
    ReplaceMaterialService replaceMaterialService;


    @ApiOperation("添加")
    @PostMapping("/save")
    public ResultBean save(@RequestBody ReplaceMaterialDTO model) {
        return replaceMaterialService.save(model);
    }


    @ApiOperation("详情")
    @GetMapping("/info/{id}")
    public ResultBean info(@PathVariable("id") int id) {
        return ResultBean.success(replaceMaterialService.getInfoById(id));
    }

    @ApiOperation("更新(只有状态为未审核状态才能修改)")
    @PostMapping("/update")
    public ResultBean update(@RequestBody ReplaceMaterialDTO model) {
        return replaceMaterialService.update(model);
    }

    @ApiOperation("删除(只有状态为未审核状态才能删除)")
    @GetMapping("/del/{id}")
    public ResultBean del(@PathVariable("id") int id) {
        return replaceMaterialService.delete(id);
    }

    @ApiOperation("技术审核")
    @PostMapping("/audit")
    public ResultBean checkReplaceMaterial(@RequestBody ReplaceMaterialAuditDTO model) {
        return replaceMaterialService.checkReplaceMaterial(model);
    }

    @ApiOperation("列表（分页）")
    @PostMapping("/pageInfo")
    public ResultBean pageInfo(@RequestBody ReplaceMaterialConditionDTO model) {
        return replaceMaterialService.pageInfo(model);
    }


}
