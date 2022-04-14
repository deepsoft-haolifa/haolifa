package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.domain.BizSubjects;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsAddDTO;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsAllRQDTO;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsRQDTO;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsRSDTO;
import com.deepsoft.haolifa.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResultBean<PageDTO<BizSubjectsRSDTO>> getSubjectsList(@RequestBody BizSubjectsRQDTO bizSubjectsDTO) {
        return subjectService.getList(bizSubjectsDTO);
    }

    @ApiOperation("获取全部节点列表-不分页")
    @GetMapping("/getSubjectsListAll")
    public ResultBean<List<BizSubjectsRSDTO>> getSubjectsListAll() {
        return subjectService.getSubjectsListAll();
    }

    @ApiOperation("获取全部节点列表-不分页(有查询条件)")
    @PostMapping("/getSubjectsListAllP")
    public ResultBean<List<BizSubjectsRSDTO>> getSubjectsListAllP(@RequestBody BizSubjectsAllRQDTO bizSubjectsDTO) {
        return subjectService.getSubjectsListAllP(bizSubjectsDTO);
    }


}
