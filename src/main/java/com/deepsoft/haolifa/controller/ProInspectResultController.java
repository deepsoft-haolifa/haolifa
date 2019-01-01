package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.model.dto.MaterialInspectResListDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectResDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.ProInspectResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"成品质检/压力测试质检"})
@RestController
@RequestMapping("pro-inspect-res")
public class ProInspectResultController {

    @Autowired
    private ProInspectResultService proInspectResultService;

    @ApiOperation("新增")
    @PostMapping("save")
    public ResultBean save(@RequestBody ProInspectResDTO model) {
        return proInspectResultService.save(model);
    }

    @ApiOperation("删除")
    @GetMapping("delete/{id}")
    public ResultBean delte(@PathVariable Integer id) {
        return proInspectResultService.delete(id);
    }

    @ApiOperation("修改")
    @PostMapping("update")
    public ResultBean update(@RequestBody ProInspectResDTO model) {
        return proInspectResultService.update(model);
    }

    @ApiOperation("详情（带不合格检验品）")
    @GetMapping("info/{inspectNo}")
    public ResultBean getInfo(@PathVariable String inspectNo) {
        return proInspectResultService.getInfo(inspectNo);
    }

    @ApiOperation("分页列表")
    @PostMapping("pageInfo")
    public ResultBean getList(@RequestBody ProInspectConditionDTO model) {
        return proInspectResultService.pageInfo(model);
    }


    @ApiOperation("更新质检单入库状态")
    @PostMapping("updateStorageStatus")
    @ApiImplicitParams({
            @ApiImplicitParam( value = "质检单号", name = "inspectNo", dataType = "String", paramType = "query"),
            @ApiImplicitParam( value = "入库状态（1待入库；2已入库）", name = "storageStatus", dataType = "int", paramType = "query"),
           })
    public ResultBean updateStorageStatus(@RequestParam String inspectNo, @RequestParam byte storageStatus) {
        return ResultBean.success(proInspectResultService.updateStorageStatus(inspectNo, storageStatus));
    }

    @ApiOperation("成品不合格原因列表")
    @GetMapping("reasonList")
    public ResultBean reasonList() {
        String[] split = Constant.INSPECT_UNQUALIFIED_REASON.split(",");
        return ResultBean.success(split);
    }

    @ApiOperation("压力测试不合格原因列表")
    @GetMapping("pressure_reasonList")
    public ResultBean pressureReasonList() {
        String[] split = Constant.PRESSURE_UNQUALIFIED_REASON.split(",");
        return ResultBean.success(split);
    }
}
