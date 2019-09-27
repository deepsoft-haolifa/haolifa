package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.InspectHistoryDto;
import com.deepsoft.haolifa.model.dto.InspectDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.InspectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"零件送检管理"})
@RestController
@RequestMapping("material-inspect")
public class InspectController {

    @Autowired
    private InspectService inspectService;

    @ApiOperation("创建送检单")
    @PostMapping("save")
    public ResultBean save(@RequestBody InspectDTO model) {
        return inspectService.save(model);
    }

    @ApiOperation("删除送检单")
    @GetMapping("delete/{inspectId}")
    public ResultBean delete(@ApiParam("送检单id") @PathVariable("inspectId") Integer inspectId) {
        return inspectService.delete(inspectId);
    }

    @ApiOperation("更新送检单")
    @PostMapping("update/{inspectId}")
    public ResultBean update(@ApiParam("送检单id") @PathVariable("inspectId") Integer inspectId,
                             @RequestBody InspectDTO model) {
        return inspectService.update(inspectId, model);
    }

    @ApiOperation("查询送检单详情")
    @GetMapping("info/{inspectId}")
    public ResultBean getInfo(@PathVariable("inspectId") Integer inspectId) {
        return inspectService.getInfo(inspectId);
    }

    @ApiOperation("查询送检单列表(采购员、质检员、库管员)")
    @GetMapping("purchase-list/{type}")
    public ResultBean purchaseList(@ApiParam("查询类型 0 采购员 1 质检员 2 库管员") @PathVariable("type") Integer type,
                                   @ApiParam("页码") @RequestParam(defaultValue = "1") Integer pageNum,
                                   @ApiParam("展示数量") @RequestParam(defaultValue = "10") Integer pageSize,
                                   @ApiParam("送检单单号") String inspectNo,
                                   @ApiParam("采购合同号") String purchaseOrderNo) {
        return inspectService.getList(type, pageNum, pageSize, inspectNo, purchaseOrderNo);
    }

    @ApiOperation("更新送检单状态")
    @PostMapping("updateStatus/{inspectId}")
    public ResultBean updateStatus(@ApiParam("送检单id") @PathVariable("inspectId") Integer inspectId,
                                   @ApiParam("发起质检：2 质检完成：3,发起入库：4 入库完成: 5") @RequestParam Integer status) {
        return inspectService.updateStatus(inspectId, status);
    }

    @ApiOperation("添加质检记录")
    @PostMapping("history/save")
    public ResultBean historySave(@RequestBody InspectHistoryDto model) {
        return inspectService.historySave(model);
    }

    @ApiOperation("删除质检记录")
    @GetMapping("history/delete/{id}")
    public ResultBean historyDelete(@PathVariable("id") Integer id) {
        return inspectService.historyDelete(id);
    }

    @ApiOperation("质检记录列表")
    @GetMapping("history/list/{inspectNo}")
    public ResultBean historyList(@PathVariable("inspectNo") String inspectNo) {
        return inspectService.historyList(inspectNo);
    }

    @ApiOperation("质检记录列表-分页")
    @GetMapping("history/page-list")
    public ResultBean historyList(@ApiParam("页码") @RequestParam(defaultValue = "1") Integer pageNum,
                                  @ApiParam("展示数量") @RequestParam(defaultValue = "10") Integer pageSize,
                                  @ApiParam("搜索条件：状态 0 全部 1 待入库 2 已入库") Integer status) {
        return inspectService.historyList(pageNum, pageSize, status);
    }

    @ApiOperation("更新质检记录状态")
    @PutMapping("updateHistoryStatus/{historyId}")
    public ResultBean updateHistoryStatus(@ApiParam("记录标示") @PathVariable("historyId") Integer historyId) {
        return inspectService.updateHistoryStatus(historyId);
    }

    @ApiOperation("获取质检记录状态")
    @GetMapping("history-info/{historyId}")
    public ResultBean getHistoryStatus(@ApiParam("记录标示") @PathVariable("historyId") Integer historyId) {
        return ResultBean.success(inspectService.getHistoryInfo(historyId));
    }

}
