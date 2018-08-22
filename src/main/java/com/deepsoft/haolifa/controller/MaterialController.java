package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.MaterialClassifyRequestDTO;
import com.deepsoft.haolifa.model.dto.MaterialRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"零件相关管理"})
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @ApiOperation("新增零件类别信息")
    @PostMapping("/saveClassify")
    public ResultBean saveClassify(@RequestBody MaterialClassifyRequestDTO model) {
        return materialService.saveClassify(model);
    }

    @ApiOperation("删除零件类别")
    @DeleteMapping("/deleteClassify/{id}")
    @ApiImplicitParam(name = "id", value = "分类id", dataType = "int", paramType = "path", required = true)
    public ResultBean deleteClassify(@PathVariable int id) {
        return materialService.deleteClassify(id);
    }

    @ApiOperation("零件类别列表")
    @GetMapping("/listClassify")
    public ResultBean listClassify() {
        return ResultBean.success(materialService.listClassify());
    }


    @ApiOperation("获取零件类别分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "当前页面", name = "currentPage", dataType = "int", paramType = "query"),
            @ApiImplicitParam(required = true, value = "每页数量", name = "pageSize", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "分类名称", name = "classifyNameLike", dataType = "string", paramType = "query")
    })
    @GetMapping("/pageClassify")
    public ResultBean pageClassify(@RequestParam(defaultValue = "1") Integer currentPage,
                                   @RequestParam(defaultValue = "20") Integer pageSize,
                                   @RequestParam(required = false) String classifyNameLike) {
        return materialService.pageInfoClassify(currentPage, pageSize, classifyNameLike);
    }


    @ApiOperation("新增零件信息")
    @PostMapping("/save")
    public ResultBean save(@RequestBody MaterialRequestDTO model) {
        return materialService.save(model);
    }


    @ApiOperation("更新零件信息")
    @PutMapping("/update")
    public ResultBean update(@RequestBody MaterialRequestDTO model) {
        return materialService.update(model);
    }

    @ApiOperation("删除零件")
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", paramType = "path", required = true)
    public ResultBean delete(@PathVariable int id) {
        return materialService.delete(id);
    }

    @ApiOperation("根据主键ID获取零件详情")
    @GetMapping("/getInfo/{id}")
    @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", paramType = "path", required = true)
    public ResultBean getInfo(@PathVariable int id) {
        return ResultBean.success(materialService.getInfoById(id));
    }

    @ApiOperation("获取零件类别分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "当前页面", name = "currentPage", dataType = "int", paramType = "query"),
            @ApiImplicitParam(required = true, value = "每页数量", name = "pageSize", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "分类名称", name = "classifyNameLike", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "零件名称", name = "nameLike", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "零件图号", name = "graphNoLike", dataType = "string", paramType = "query")
    })
    @GetMapping("/pageInfo")
    public ResultBean pageInfo(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "20") Integer pageSize,
                               @RequestParam(required = false) String classifyNameLike,
                               @RequestParam(required = false) String nameLike,
                               @RequestParam(required = false) String graphNoLike) {
        return materialService.pageInfo(currentPage, pageSize, classifyNameLike, nameLike, graphNoLike);
    }


}
