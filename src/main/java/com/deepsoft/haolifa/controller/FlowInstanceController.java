package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.FlowHandleStepDTO;
import com.deepsoft.haolifa.model.dto.FlowInstanceDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.FlowInstanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @PostMapping("flow-history/{instaceId}")
    @ApiOperation("当前流程实例审核历史信息")
    public ResultBean flowInstanceHistory(@PathVariable("instaceId") Integer instaceId) {
        return flowInstanceService.flowInstanceHistory(instaceId);
    }


}
