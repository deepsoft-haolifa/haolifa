package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.MaterialClassifyRequestDTO;
import com.deepsoft.haolifa.model.dto.MaterialRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.material.MaterialConditionDTO;
import com.deepsoft.haolifa.model.dto.material.MaterialListDTO;
import com.deepsoft.haolifa.service.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"零件管理"})
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @ApiOperation("新增零件类别")
    @PostMapping("/classify/save")
    public ResultBean saveClassify(@RequestBody MaterialClassifyRequestDTO model) {
        return materialService.saveClassify(model);
    }

    @ApiOperation("更新零件类别")
    @PutMapping("/classify/update")
    public ResultBean updateClassify(@RequestBody MaterialClassifyRequestDTO model) {
        return materialService.updateClassify(model);
    }

    @ApiOperation("删除零件类别")
    @DeleteMapping("/classify/delete/{id}")
    @ApiImplicitParam(name = "id", value = "分类id", dataType = "int", paramType = "path", required = true)
    public ResultBean deleteClassify(@PathVariable int id) {
        return materialService.deleteClassify(id);
    }


    @ApiOperation("零件类别详情")
    @GetMapping("/classify/getInfo/{id}")
    @ApiImplicitParam(name = "id", value = "分类id", dataType = "int", paramType = "path", required = true)
    public ResultBean listClassify(@PathVariable int id) {
        return ResultBean.success(materialService.getClassifyInfo(id));
    }

    @ApiOperation("零件类别列表")
    @GetMapping("/classify/list")
    public ResultBean listClassify() {
        return ResultBean.success(materialService.listClassify());
    }


    @ApiOperation("零件类别分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "当前页面", name = "currentPage", dataType = "int", paramType = "query"),
            @ApiImplicitParam(required = true, value = "每页数量", name = "pageSize", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "分类名称", name = "classifyNameLike", dataType = "string", paramType = "query")
    })
    @GetMapping("/classify/pageInfo")
    public ResultBean pageInfoClassify(@RequestParam(defaultValue = "1") Integer currentPage,
                                       @RequestParam(defaultValue = "20") Integer pageSize,
                                       @RequestParam(required = false) String classifyNameLike) {
        return materialService.pageInfoClassify(currentPage, pageSize, classifyNameLike);
    }


    @ApiOperation("新增零件")
    @PostMapping("/save")
    public ResultBean save(@RequestBody MaterialRequestDTO model) {
        return materialService.save(model);
    }


    @ApiOperation("更新零件")
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

    @ApiOperation("零件详情")
    @GetMapping("/getInfo/{id}")
    @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", paramType = "path", required = true)
    public ResultBean getInfo(@PathVariable int id) {
        return ResultBean.success(materialService.getInfoById(id));
    }


    @ApiOperation("根据零件分类Id获取零件列表")
    @GetMapping("/getListByClassifyId/{classifyId}")
    @ApiImplicitParam(name = "classifyId", value = "分类Id", dataType = "int", paramType = "path", required = true)
    public ResultBean getListByClassifyId(@PathVariable int classifyId) {
        return ResultBean.success(materialService.getListByClassifyId(classifyId));
    }

    @ApiOperation("零件分页列表")
    @PostMapping("/pageInfo")
    public ResultBean pageInfo(@RequestBody MaterialConditionDTO conditionDTO) {
        return materialService.pageInfo(conditionDTO);
    }


    @ApiOperation("库存告警列表")
    @PostMapping("/store-alarm")
    public ResultBean storeAlarmList(@RequestBody MaterialConditionDTO model) {
        return materialService.getMaterialAlarmList(model);
    }


    @ApiOperation("根据条件获取零件列表")
    @PostMapping("/graphNo-list")
    public ResultBean graphNoList(@RequestBody MaterialListDTO materialListDTO) {
        return ResultBean.success(materialService.getGraphNoList(materialListDTO));
    }


}
