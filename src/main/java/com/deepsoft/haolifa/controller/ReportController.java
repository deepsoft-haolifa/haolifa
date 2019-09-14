package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.ExpensesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"报表"})
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ExpensesService expensesService;

    @ApiOperation("费用每月汇总--一级部门")
    @GetMapping("/expense/classify")
    public ResultBean getcClassify() {
        return expensesService.getClassify();
    }
    @ApiOperation("费用每月汇总--部门明细")
    @GetMapping("/expense/classifyByDepartment")
    public ResultBean classifyByDepartment() {
        return expensesService.classifyByDepartment();
    }
    @ApiOperation("费用每月汇总--二级部门")
    @GetMapping("/expense/classifyByDepartment")
    public ResultBean classifyBySecondDepartment() {
        return expensesService.classifyByDepartment();
    }
}
