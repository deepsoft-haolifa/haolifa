package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetAddDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetRQDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetRSDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetUpDTO;
import com.deepsoft.haolifa.service.finance.ProjectBudgetService;
import com.deepsoft.haolifa.service.finance.ProjectBudgetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
