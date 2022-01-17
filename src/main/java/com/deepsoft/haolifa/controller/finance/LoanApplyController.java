package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillUpDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyAddDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyUpDTO;
import com.deepsoft.haolifa.service.finance.BankBillService;
import com.deepsoft.haolifa.service.finance.LoanApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 借款申请
 */
@RestController
@RequestMapping("/finance/loanapply")
@Api(tags = {"好利财务-借款申请管理"})
public class LoanApplyController {
    @Autowired
    private LoanApplyService loanApplyService;


    @ApiOperation("添加节点")
    @PostMapping("/save")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean save(@RequestBody LoanApplyAddDTO model) {
        return loanApplyService.save(model);
    }

    @ApiOperation("删除节点")
    @GetMapping("/delete/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean delete(@PathVariable("id") int id) {
        return loanApplyService.delete(id);
    }

    @ApiOperation("更新节点")
    @PostMapping("/updateLoan")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean updateLoan(@RequestBody LoanApplyUpDTO model) {
        return loanApplyService.update(model);
    }

    @ApiOperation("获取节点列表")
    @PostMapping("/getLoanList")
    public ResultBean getBankBillList(@RequestBody LoanApplyRQDTO model) {
        return loanApplyService.getList(model);
    }

    @ApiOperation("发起审批")
    @GetMapping("/approve/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean approve(@ApiParam("借款申请ID") @PathVariable("id") Integer id) {
        return loanApplyService.approve(id);
    }



}
