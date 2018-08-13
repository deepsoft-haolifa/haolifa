package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.MaterialClassifyRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"原料相关管理"})
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @ApiOperation("新增原料类别信息")
    @PostMapping("/saveClassify")
    public ResultBean saveClassify(@RequestBody MaterialClassifyRequestDTO model) {
        return materialService.saveClassify(model);
    }

    @ApiOperation("删除原料类别")
    @GetMapping("/deleteClassify/{id}")
    @ApiImplicitParam(name = "id", value = "分类id", dataType = "int", paramType = "path", required = true)
    public ResultBean deleteRack(@PathVariable int id) {
        return materialService.deleteClassify(id);
    }

    @ApiOperation("原料类别列表")
    @GetMapping("/listClassify")
    public ResultBean listClassify() {
        return ResultBean.success(materialService.listClassify());
    }


    @ApiOperation("获取原料类别分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "当前页面", name = "currentPage", dataType = "int", paramType = "query"),
            @ApiImplicitParam(required = true, value = "每页数量", name = "pageSize", dataType = "int", paramType = "query")
    })
    @GetMapping("/pageRackInfo")
    public ResultBean pageRackInfo(@RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        return materialService.pageInfoClassify(currentPage, pageSize);
    }



}
