package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectResDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectRecordDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectResDTO;
import com.deepsoft.haolifa.service.ProInspectResultService;
import com.deepsoft.haolifa.service.ProInspectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"成品质检"})
@RestController
@RequestMapping("/pro-inspect")
public class ProInspectController {

    @Autowired
    private ProInspectService proInspectService;

    @ApiOperation("新增")
    @PostMapping("/save")
    public ResultBean save(@RequestBody ProInspectRecordDTO model) {
        return proInspectService.save(model);
    }

    @ApiOperation("删除")
    @GetMapping("/delete/{id}")
    public ResultBean delete(@PathVariable Integer id) {
        return proInspectService.delete(id);
    }
    @ApiOperation("修改")
    @PostMapping("/update")
    public ResultBean update(@RequestBody ProInspectRecordDTO model) {
        return proInspectService.update(model);
    }

    @ApiOperation("分页列表")
    @PostMapping("/pageInfo")
    public ResultBean getList(@RequestBody ProInspectConditionDTO model) {
        return proInspectService.pageInfo(model);
    }


    @ApiOperation("更新质检单入库状态")
    @PostMapping("/updateStorageStatus")
    @ApiImplicitParams({
            @ApiImplicitParam( value = "质检id", name = "id", dataType = "int", paramType = "query"),
            @ApiImplicitParam( value = "入库状态（1待入库；2已入库）", name = "storageStatus", dataType = "int", paramType = "query"),
           })
    public ResultBean updateStorageStatus(@RequestParam int id, @RequestParam byte storageStatus) {
        return ResultBean.success(proInspectService.updateStorageStatus(id, storageStatus));
    }

    @ApiOperation("成品不合格原因列表")
    @GetMapping("/reasonList")
    public ResultBean reasonList() {
        String[] split = Constant.INSPECT_UNQUALIFIED_REASON.split(",");
        return ResultBean.success(split);
    }


}
