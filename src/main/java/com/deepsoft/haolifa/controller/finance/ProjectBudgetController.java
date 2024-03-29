package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.*;
import com.deepsoft.haolifa.service.finance.ProjectBudgetService;
import com.deepsoft.haolifa.service.finance.ProjectBudgetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目管理
 */
@RestController
@RequestMapping("/finance/projectbudget")
@Api(tags = {"好利财务-项目管理"})
public class ProjectBudgetController {
    @Autowired
    private ProjectBudgetService projectBudgetService;


    @ApiOperation("添加项目管理")
    @PostMapping("/save")
    public ResultBean save(@RequestBody ProjectBudgetAddDTO model) {
        return projectBudgetService.save(model);
    }

    @ApiOperation("删除项目管理")
    @GetMapping("/delete/{id}")
    public ResultBean delete(@PathVariable("id") int id) {
        return projectBudgetService.delete(id);
    }

    @ApiOperation("更新项目管理")
    @PostMapping("/updateProjectBudget")
    public ResultBean updateProjectBudget(@RequestBody ProjectBudgetUpDTO assetsUpDTO) {
        return projectBudgetService.update(assetsUpDTO);
    }

    @ApiOperation("获取项目管理列表")
    @PostMapping("/getProjectBudgetList")
    public ResultBean<PageDTO<ProjectBudgetRSDTO>> getProjectBudgetList(@RequestBody ProjectBudgetRQDTO assetsRQDTO) {
        return projectBudgetService.getList(assetsRQDTO);
    }


    @ApiOperation("获取项目管理列表（报销借款列表用-只能查询当前用户的部门）")
    @PostMapping("/getCurUserProjectBudgetList")
    public ResultBean<PageDTO<ProjectBudgetRSDTO>> getCurUserProjectBudgetList(@RequestBody ProjectBudgetRQDTO assetsRQDTO) {
        return projectBudgetService.getCurUserProjectBudgetList(assetsRQDTO);
    }


    @ApiOperation("获取项目管理列表（日记账付款专用-必须传选择的部门）")
    @PostMapping("/getCurProjectBudgetList")
    public ResultBean<List<ProjectBudgetRSDTO>> getCurProjectBudgetList(@RequestBody ProjectBudgetRQBillDTO assetsRQDTO) {
        return projectBudgetService.getCurProjectBudgetList(assetsRQDTO);
    }


}
