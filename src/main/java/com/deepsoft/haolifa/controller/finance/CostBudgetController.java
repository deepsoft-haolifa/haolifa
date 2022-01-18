package com.deepsoft.haolifa.controller.finance;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptAddDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptRQDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptTree;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptUpDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsAddDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsRQDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsRSDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsUpDTO;
import com.deepsoft.haolifa.service.finance.CostBudgetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 费用预算
 */
@RestController
@RequestMapping("/finance/costbudget")
@Api(tags = {"好利财务-费用预算账管理"})
public class CostBudgetController {
    @Autowired
    private CostBudgetService costBudgetService;


    //--- 部门
    @ApiOperation("添加部门预算节点")
    @PostMapping("/dept/save")
    public ResultBean saveDeptBudget(@RequestBody CostBudgetDeptAddDTO model) {
        return costBudgetService.saveDeptBudget(model);
    }

    @ApiOperation("删除部门预算节点")
    @GetMapping("/dept/delete/{id}")
    public ResultBean deleteDeptBudget(@PathVariable("id") int id) {
        return costBudgetService.deleteDeptBudget(id);
    }


    @ApiOperation("更新部门预算节点")
    @PostMapping("/dept/updateDeptBudget")
    public ResultBean updateDeptBudget(@RequestBody CostBudgetDeptUpDTO model) {
        return costBudgetService.updateDeptBudget(model);
    }

    @ApiOperation("获取部门预算节点列表")
    @PostMapping("/dept/getDeptBudgetList")
    public  ResultBean<List<CostBudgetDeptTree>>  getDeptBudgetList(@RequestBody CostBudgetDeptRQDTO model) {
        return costBudgetService.getDeptBudgetListTree(model);
    }


    //--- 科目

    @ApiOperation("添加科目预算节点")
    @PostMapping("/subjects/saveSubjectsBudget")
    public ResultBean saveSubjectsBudget(@RequestBody CostBudgetSubjectsAddDTO model) {
        return costBudgetService.saveSubjectsBudget(model);
    }

    @ApiOperation("删除科目预算节点")
    @GetMapping("/subjects/deleteSubjectsBudget/{id}")
    public ResultBean deleteSubjectsBudget(@PathVariable("id") int id) {
        return costBudgetService.deleteSubjectsBudget(id);
    }

    @ApiOperation("批量删除科目预算节点")
    @PostMapping("/subjects/deleteSubjectsBudgetBatch")
    public ResultBean deleteSubjectsBudgetBatch(@RequestBody List<Integer> ids) {
        return costBudgetService.deleteSubjectsBudgetBatch(ids);
    }

    @ApiOperation("更新科目预算节点")
    @PostMapping("/subjects/updateSubjectsBudget")
    public ResultBean updateSubjectsBudget(@RequestBody CostBudgetSubjectsUpDTO model) {
        return costBudgetService.updateSubjectsBudget(model);
    }

    @ApiOperation("获取科目预算节点列表")
    @PostMapping("/subjects/getSubjectsBudgetList")
    public ResultBean<PageDTO<CostBudgetSubjectsRSDTO>> getSubjectsBudgetList(@RequestBody CostBudgetSubjectsRQDTO model) {
        return costBudgetService.getSubjectsBudgetList(model);
    }

}
