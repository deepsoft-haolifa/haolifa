package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.ExpensesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
    @GetMapping("/expense/classifyBySecondDepartment")
    public ResultBean classifyBySecondDepartment() {
        return expensesService.classifyByDepartment();
    }

    @ApiOperation("费用整体分类汇总")
    @GetMapping("/expense/getAllClassify")
    public ResultBean getAllClassify() {
        return expensesService.getAllClassify();
    }
    @ApiOperation("费用整体部门汇总")
    @GetMapping("/expense/classifyByDepartmentAll")
    public ResultBean classifyByDepartmentAll() {
        return expensesService.classifyByDepartmentAll();
    }
    @ApiOperation("某个部门下面的分类统计")
    @RequestMapping(value = "/expense/getAllClassifyWithDepartment",method = RequestMethod.GET)
    public ResultBean getAllClassifyWithDepartment(@RequestParam(value ="department") String department) {
        return expensesService.getAllClassifyWithDepartment(department);
    }
    @ApiOperation("每项费用中费用二级占比")
    @RequestMapping(value = "/expense/getAllClassifyWithFirstClassify",method = RequestMethod.GET)
    public ResultBean getAllClassifyWithFirstClassify(@RequestParam(value ="classify") String classify) {
        System.out.println(classify);
        return expensesService.getAllClassifyWithFirstClassify(classify);
    }
}
