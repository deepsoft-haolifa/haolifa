package com.deepsoft.haolifa.controller.finance;

import cn.hutool.json.JSON;
import com.deepsoft.haolifa.enums.CostBudgetTypeEnum;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.costbudget.CostBudgetQuery;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptAddUpDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptRQDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptTree;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptUpDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.*;
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


    @ApiOperation("部门科目预算")
    @PostMapping("/dept/t")
    public ResultBean tDeptBudget(@RequestBody CostBudgetQuery model) {
        return costBudgetService.selectCostBudget(model);
    }



    //--- 部门
    @ApiOperation("添加或修改部门预算节点")
    @PostMapping("/dept/saveOrUp")
    public ResultBean saveDeptBudget(@RequestBody CostBudgetDeptAddUpDTO model) {
        return costBudgetService.saveOrUpDeptBudget(model);
    }

    @ApiOperation("删除部门预算节点")
    @GetMapping("/dept/delete/{deptId}")
    public ResultBean deleteDeptBudget(@PathVariable("deptId") int deptId) {
        return costBudgetService.deleteDeptBudget(deptId);
    }


//    @ApiOperation("更新部门预算节点")
//    @PostMapping("/dept/updateDeptBudget")
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
    public ResultBean deleteSubjectsBudgetBatch(@RequestBody CostBudgetSubjectsDelBatchDTO costBudgetSubjectsDelBatchDTO) {
        return costBudgetService.deleteSubjectsBudgetBatch(costBudgetSubjectsDelBatchDTO.getIds());
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
