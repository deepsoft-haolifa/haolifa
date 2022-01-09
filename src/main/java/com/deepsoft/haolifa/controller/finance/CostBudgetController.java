package com.deepsoft.haolifa.controller.finance;

import com.deepsoft.haolifa.model.domain.BizCostBudget;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.costbudget.BizCostBudgetAddDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.BizCostBudgetDTO;
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


    @ApiOperation("添加节点")
    @PostMapping("/save")
    public ResultBean save(@RequestBody BizCostBudgetAddDTO model) {
        return costBudgetService.save(model);
    }

    @ApiOperation("删除节点")
    @GetMapping("/delete/{costBudgetId}")
    public ResultBean delete(@PathVariable("costBudgetId") int id) {
        return costBudgetService.delete(id);
    }

    @ApiOperation("批量删除节点")
    @PostMapping("/deleteBatch")
    public ResultBean deleteBatch(@RequestBody List<Integer> ids) {
        return costBudgetService.deleteBatch(ids);
    }

    @ApiOperation("更新节点")
    @PostMapping("/updateCostBudget")
    public ResultBean updateCostBudget(@RequestBody BizCostBudget costBudget) {
        return costBudgetService.update(costBudget);
    }

    @ApiOperation("获取节点列表")
    @PostMapping("/getCostBudgetList")
    public ResultBean getCostBudgetList(@RequestBody BizCostBudgetDTO costBudgetDTO) {
        return costBudgetService.getList(costBudgetDTO);
    }

}
