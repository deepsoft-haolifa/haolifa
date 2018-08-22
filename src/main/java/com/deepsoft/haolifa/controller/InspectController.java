package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.InspectDTO;
import com.deepsoft.haolifa.model.dto.InspectListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.InspectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"送检管理"})
@RestController
@RequestMapping("inspect")
public class InspectController {

    @Autowired
    private InspectService inspectService;

    @ApiOperation("创建送检单")
    @PostMapping("save")
    public ResultBean save(@RequestBody List<InspectDTO> modelList) {
        return inspectService.save(modelList);
    }

    @ApiOperation("删除送检单")
    @GetMapping("delete/{inspectNo}")
    public ResultBean delete(@PathVariable("inspectNo") String inspectNo, String materialGraphNo, String productModel) {
        return inspectService.delete(inspectNo, materialGraphNo, productModel);
    }

    @ApiOperation("更新送检单")
    @PostMapping("update")
    public ResultBean update(@RequestBody InspectDTO model) {
        return inspectService.update(model);
    }

    @ApiOperation("查询送检单详情")
    @GetMapping("info/{inspectNo}")
    public ResultBean getInfo(@PathVariable("inspectNo") String inspectNo) {
        return inspectService.getInfo(inspectNo);
    }

    @ApiOperation("查询送检单列表")
    @PostMapping("list")
    public ResultBean getList(@RequestBody InspectListDTO model) {
        return inspectService.getList(model);
    }

    @ApiOperation("更新送检单状态")
    @GetMapping("updateStatus")
    public ResultBean updateStatus(@RequestParam String inspectNo, @RequestParam Integer status) {
        return inspectService.updateStatus(inspectNo, status);
    }

}
