package com.deepsoft.haolifa.controller.finance;


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
@RequestMapping("/finance/subjects")
@Api(tags = {"好利财务-科目管理"})
public class SubjectsController {
    @Autowired
    private SubjectService subjectService;


    @ApiOperation("添加科目节点")
    @PostMapping("/save")
    public ResultBean save(@RequestBody BizSubjectsAddDTO model) {
        return subjectService.save(model);
    }

    @ApiOperation("删除科目节点")
    @GetMapping("/delete/{subjectsId}")
    public ResultBean delete(@PathVariable("subjectsId") int id) {
        return subjectService.delete(id);
    }

    @ApiOperation("更新科目节点")
    @PostMapping("/updateSubjects")
    public ResultBean updateSubjects(@RequestBody BizSubjects bizSubjects) {
        return subjectService.update(bizSubjects);
    }

    @ApiOperation("获取节点列表")
    @PostMapping("/getSubjectsList")
    public ResultBean getSubjectsList(@RequestBody BizSubjectsDTO bizSubjectsDTO) {
        return subjectService.getList(bizSubjectsDTO);
    }


}
