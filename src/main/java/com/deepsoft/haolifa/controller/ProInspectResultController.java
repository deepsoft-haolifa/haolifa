package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.MaterialInspectResListDTO;
import com.deepsoft.haolifa.model.dto.ProInspectResDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.ProInspectResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"成品送检报告"})
@RestController
@RequestMapping("pro-inspect-res")
public class ProInspectResultController {

    @Autowired
    private ProInspectResultService proInspectResultService;

    @ApiOperation("创建成品送检报告")
    @PostMapping("save")
    public ResultBean save(@RequestBody ProInspectResDTO model) {
        return proInspectResultService.save(model);
    }

    @ApiOperation("删除成品送检报告")
    @GetMapping("delete/{id}")
    public ResultBean delte(@PathVariable Integer id) {
        return proInspectResultService.delete(id);
    }

    @ApiOperation("修改成品送检报告")
    @PostMapping("update")
    public ResultBean update(@RequestBody ProInspectResDTO model) {
        return proInspectResultService.update(model);
    }

    @ApiOperation("查询成品送检报告")
    @GetMapping("info/{inspectNo}")
    public ResultBean getInfo(@PathVariable String inspectNo) {
        return proInspectResultService.getInfo(inspectNo);
    }

    @ApiOperation("查询成品送检报告列表")
    @GetMapping("list")
    public ResultBean getList(@RequestBody MaterialInspectResListDTO model) {
        return proInspectResultService.getList(model);
    }

    @ApiOperation("发起审批(流程初始化)--接口未实现")
    @GetMapping("initiateApproval/{id}")
    public ResultBean initiateApproval(@PathVariable("id") Integer id){
        return null;
    }

    @ApiOperation("撤销审批--接口未实现")
    @GetMapping("cancelApproval/{id}")
    public ResultBean cancelApproval(@PathVariable("id") String id){
        return null;
    }



}
