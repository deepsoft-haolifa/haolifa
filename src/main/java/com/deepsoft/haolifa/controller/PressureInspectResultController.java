package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectResDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectResDTO;
import com.deepsoft.haolifa.service.PressureInspectResultService;
import com.deepsoft.haolifa.service.ProInspectResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"压力测试质检"})
@RestController
@RequestMapping("/pressure-inspect-res")
public class PressureInspectResultController {

    @Autowired
    private PressureInspectResultService pressureInspectResultService;

    @ApiOperation("新增")
    @PostMapping("/save")
    public ResultBean save(@RequestBody PressureInspectResDTO model) {
        return pressureInspectResultService.save(model);
    }

    @ApiOperation("删除")
    @GetMapping("/delete/{id}")
    public ResultBean delte(@PathVariable Integer id) {
        return pressureInspectResultService.delete(id);
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public ResultBean update(@RequestBody PressureInspectResDTO model) {
        return pressureInspectResultService.update(model);
    }

    @ApiOperation("详情（带不合格检验品）")
    @GetMapping("/info/{inspectNo}")
    public ResultBean getInfo(@PathVariable String inspectNo) {
        return pressureInspectResultService.getInfo(inspectNo);
    }

    @ApiOperation("分页列表")
    @PostMapping("/pageInfo")
    public ResultBean getList(@RequestBody PressureInspectConditionDTO model) {
        return pressureInspectResultService.pageInfo(model);
    }

    @ApiOperation("压力测试不合格原因列表")
    @GetMapping("/pressure_reasonList")
    public ResultBean pressureReasonList() {
        String[] split = Constant.PRESSURE_UNQUALIFIED_REASON.split(",");
        return ResultBean.success(split);
    }
}
