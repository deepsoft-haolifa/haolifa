package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.MaterialInspectResDTO;
import com.deepsoft.haolifa.model.dto.MaterialInspectResListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.MaterialInspectResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"原料送检报告"})
@RestController
@RequestMapping("material-inspect-res")
public class MaterialInspectResultController {

    @Autowired
    private MaterialInspectResultService materialInspectResultService;

    @ApiOperation("创建原料送检报告")
    @PostMapping("save")
    public ResultBean save(@RequestBody MaterialInspectResDTO model) {
        return materialInspectResultService.save(model);
    }

    @ApiOperation("删除原料送检报告(功能待定)")
    @PostMapping("delete/{id}")
    public ResultBean delete(@PathVariable("id") Integer id) {
        return materialInspectResultService.delete(id);
    }

    @ApiOperation("更新原料送检报告")
    @PostMapping("update")
    public ResultBean update(@RequestBody MaterialInspectResDTO model) {
        return materialInspectResultService.update(model);
    }

    @ApiOperation("查询原料送检报告")
    @GetMapping("info/{inspectNo}")
    public ResultBean getInfo(@PathVariable("inspectNo") String inspectNo) {
        return materialInspectResultService.getInfo(inspectNo);
    }

    @ApiOperation("查询原料送检报告列表")
    @GetMapping("list")
    public ResultBean getList(@RequestBody MaterialInspectResListDTO model) {
        return materialInspectResultService.getList(model);
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
