package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.DepartmentDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"部门管理"})
@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation("添加部门")
    @PostMapping("")
    public ResultBean insertDepartment(@RequestBody DepartmentDTO departmentDTO){
        return ResultBean.success(departmentService.insertDepartment(departmentDTO));
    }

    @ApiOperation("获取部门")
    @GetMapping("/{id}")
    public ResultBean getDapartment(@PathVariable("id") Integer id){
        return ResultBean.success(departmentService.selectDepartmentById(id));
    }

    @ApiOperation("部门列表")
    @GetMapping("/list")
    public ResultBean getDepartments(){
        return ResultBean.success(departmentService.getDepartments());
    }

    @ApiOperation("修改部门")
    @PutMapping("")
    public ResultBean updateDepartment(@RequestBody DepartmentDTO departmentDTO){
        return ResultBean.success(departmentService.updateDepartment(departmentDTO));
    }

    @ApiOperation("删除部门")
    @DeleteMapping("/{id}")
    public ResultBean deleteDapartment(@PathVariable("id") Integer id){
        return ResultBean.success(departmentService.deleteDepartment(id));
    }

    @ApiOperation("获取部门树状结构")
    @GetMapping("/departmentTree")
    public ResultBean departmentTree(){
        return ResultBean.success(departmentService.departmentTree());
    }

}
