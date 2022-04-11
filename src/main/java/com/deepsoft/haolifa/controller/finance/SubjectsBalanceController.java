package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.domain.BizSubjects;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsRSDTO;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsAddDTO;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsRQDTO;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsRSDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceRQDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceRSDTO;
import com.deepsoft.haolifa.service.SubjectService;
import com.deepsoft.haolifa.service.finance.SubjectBalanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finance/subjectsbalance")
@Api(tags = {"好利财务-科目余额管理"})
public class SubjectsBalanceController {
    @Autowired
    private SubjectBalanceService subjectBalanceService;


    @ApiOperation("获取节点列表")
    @PostMapping("/getSubjectsBalanceList")
    public ResultBean<PageDTO<BizSubjectsBalanceRSDTO>> getSubjectsList(@RequestBody BizSubjectsBalanceRQDTO bizSubjectsDTO) {
        return subjectBalanceService.getList(bizSubjectsDTO);
    }

    @ApiOperation("获取全部节点列表-不分页")
    @GetMapping("/getSubjectsBalanceListAll")
    public ResultBean<List<BizSubjectsBalanceRSDTO>> getSubjectsListAll() {
        return subjectBalanceService.getSubjectsListAll();
    }

    @ApiOperation("获取当前用户科目预算余额节点")
    @GetMapping("/subjects/getCurUserSubjectsBalance/{subjectId}")
    public ResultBean<BizSubjectsBalanceRSDTO> getCurUserSubjectsBalance(@PathVariable("subjectId") Integer subjectId) {
        return subjectBalanceService.getCurUserSubjectsBalance(subjectId);
    }


}
