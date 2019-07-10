package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.model.domain.PressureInspectRecord;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectRecordDTO;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectResDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectRecordDTO;
import com.deepsoft.haolifa.service.PressureInspectService;
import com.deepsoft.haolifa.service.ProInspectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"压力测试质检"})
@RestController
@RequestMapping("/pressure-inspect")
public class PressureInspectController {

    @Autowired
    private PressureInspectService pressureInspectService;

    @ApiOperation("新增")
    @PostMapping("/save")
    public ResultBean save(@RequestBody PressureInspectRecordDTO model) {
        return pressureInspectService.save(model);
    }

    @ApiOperation("删除")
    @GetMapping("/delete/{id}")
    public ResultBean delete(@PathVariable Integer id) {
        return pressureInspectService.delete(id);
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public ResultBean update(@RequestBody PressureInspectRecordDTO model) {
        return pressureInspectService.update(model);
    }
    @ApiOperation("分页列表")
    @PostMapping("/pageInfo")
    public ResultBean getList(@RequestBody PressureInspectConditionDTO model) {
        return pressureInspectService.pageInfo(model);
    }

    @ApiOperation("压力测试不合格原因列表")
    @GetMapping("/pressure_reasonList")
    public ResultBean pressureReasonList() {
        String[] split = Constant.PRESSURE_UNQUALIFIED_REASON.split(",");
        return ResultBean.success(split);
    }
}
