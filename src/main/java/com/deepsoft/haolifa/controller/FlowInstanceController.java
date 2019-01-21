package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.FlowHandleStepDTO;
import com.deepsoft.haolifa.model.dto.FlowInstanceDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.FlowInstanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flowInstance")
@Api(tags = {"流程创建以及流转"})
public class FlowInstanceController {

    @Autowired
    private FlowInstanceService flowInstanceService;

    @PostMapping("create")
    @ApiOperation("创建流程")
    public ResultBean createFlowInstance(@RequestBody FlowInstanceDTO model) {
        return flowInstanceService.create(model);
    }

    @PostMapping("handleStep")
    @ApiOperation("节点审核")
    public ResultBean handleStep(@RequestBody FlowHandleStepDTO model) {
        return flowInstanceService.handleStep(model);
    }

    @GetMapping("flow-history/{instanceId}")
    @ApiOperation("当前流程实例审核历史信息")
    public ResultBean flowInstanceHistory(@PathVariable("instanceId") Integer instanceId) {
        return flowInstanceService.flowInstanceHistory(instanceId);
    }

    @GetMapping("backSteps/{instanceId}")
    @ApiOperation("获取当前实例可退回节点的列表")
    public ResultBean backSteps(@PathVariable("instanceId") Integer instanceId) {
        return flowInstanceService.backSteps(instanceId);
    }

    @GetMapping("flow/progress")
    @ApiOperation("获取流程审批的进度信息")
    public ResultBean flowProgress(@RequestParam String formNo) {
        return flowInstanceService.flowProgress(formNo);
    }

}
