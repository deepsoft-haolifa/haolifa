package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.domain.BizSubjects;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.BizSubjectsAddDTO;
import com.deepsoft.haolifa.model.dto.finance.BizSubjectsDTO;
import com.deepsoft.haolifa.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/finance")
@Api(tags = {"财务模块"})
public class FinanceController {
    @Autowired
    private SubjectService subjectService;


    @ApiOperation("添加科目节点")
    @PostMapping("/subjects/save")
    public ResultBean save(@RequestBody BizSubjectsAddDTO model) {
        return subjectService.save(model);
    }

    @ApiOperation("删除科目节点")
    @GetMapping("/subjects/delete/{subjectsId}")
    public ResultBean delete(@PathVariable("subjectsId") int id) {
        return subjectService.delete(id);
    }

    @ApiOperation("更新科目节点")
    @PostMapping("/subjects/updateSubjects")
    public ResultBean updateSubjects(@RequestBody BizSubjects bizSubjects) {
        return subjectService.update(bizSubjects);
    }

    @ApiOperation("获取节点列表")
    @GetMapping("/subjects/getSubjectsList")
    public ResultBean getSubjectsList(@RequestBody BizSubjectsDTO bizSubjectsDTO) {
        return subjectService.getList(bizSubjectsDTO);
    }


}
