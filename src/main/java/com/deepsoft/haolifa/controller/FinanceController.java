package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.FinanceDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.FinanceService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"财务管理"})
@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    FinanceService financeService;

    @ApiOperation("添加财务记录")
    @PostMapping("save")
    public ResultBean save(@RequestBody FinanceDTO model){

        return financeService.save(model);
    }


    @ApiOperation("删除财务记录")
    @GetMapping("delete/{id}")
    public ResultBean delete(@PathVariable("id") Integer id){
        return financeService.delete(id);
    }

    @ApiOperation("更新财务记录")
    @PostMapping("update")
    public ResultBean update(@RequestBody FinanceDTO model){
        return financeService.update(model);
    }


    @ApiOperation("查询财务记录列表")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "页码",name = "currentPage",dataType = "int" ,paramType = "query"),
            @ApiImplicitParam(required = true, value = "显示数量",name = "pageSize",dataType = "int" ,paramType = "query"),
            @ApiImplicitParam(value = "合同编号",name = "orderNo",dataType = "string" ,paramType = "query")
    })
    @GetMapping("list")
    public ResultBean getList(@RequestParam Integer currentPage, @RequestParam Integer pageSize, String orderNo){
        return financeService.getList(currentPage,pageSize,orderNo);
    }


}
