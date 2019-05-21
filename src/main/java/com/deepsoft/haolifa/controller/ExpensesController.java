package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.ExpensesDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.ExpensesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"费用管理"})
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


    @ApiOperation("查询费用记录列表")
    @GetMapping("list")
    public ResultBean getList(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize) {
        return expensesService.getList(pageNum, pageSize);
    }

   @ApiOperation("费用类别")
    @GetMapping("/classify")
    public ResultBean classify(@RequestParam(defaultValue = "0") Integer pId) {
        return expensesService.classify(pId);
   }

}
