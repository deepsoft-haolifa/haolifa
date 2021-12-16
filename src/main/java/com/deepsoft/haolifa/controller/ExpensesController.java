package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.domain.Expenses;
import com.deepsoft.haolifa.model.dto.ExpensesDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.expenses.ExpensesConditionDTO;
import com.deepsoft.haolifa.service.ExpensesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"费用管理(2021-12-hd)"})
@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    @ApiOperation("添加费用记录")
    @PostMapping("save")
    public ResultBean save(@RequestBody ExpensesDTO model) {

        return expensesService.save(model);
    }

    @ApiOperation("查询费用记录详情")
    @GetMapping("/info/{id}")
    public ResultBean info(@PathVariable("id") Integer id) {
        return expensesService.info(id);
    }

    @ApiOperation("删除费用记录")
    @GetMapping("delete/{id}")
    public ResultBean delete(@PathVariable("id") Integer id) {
        return expensesService.delete(id);
    }

    @ApiOperation("更新费用记录")
    @PostMapping("update")
    public ResultBean update(@RequestBody ExpensesDTO model) {
        return expensesService.update(model);
    }


    @ApiOperation("查询费用记录列表(2021-12-hd)")
    @PostMapping("list")
    public ResultBean<PageDTO<Expenses>> getList( @RequestBody ExpensesConditionDTO expensesDTO) {
        return expensesService.getList(expensesDTO);
    }

    @ApiOperation("查询费用汇总(2021-12-hd)")
    @PostMapping("list-summary")
    public ResultBean<String> listSummary(@RequestBody ExpensesConditionDTO expensesDTO) {
        return ResultBean.success(expensesService.listSummary(expensesDTO));
    }


    @ApiOperation("费用类别")
    @GetMapping("/classify")
    public ResultBean classify(@RequestParam(defaultValue = "0") Integer pId) {
        return expensesService.classify(pId);
    }

}
