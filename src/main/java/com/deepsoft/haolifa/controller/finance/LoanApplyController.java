package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillUpDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.*;
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


    @ApiOperation("添加节点(借款申請列表使用)")
    @PostMapping("/save")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean save(@RequestBody LoanApplyAddDTO model) {
        return loanApplyService.save(model);
    }

    @ApiOperation("删除节点(借款申請列表使用)")
    @GetMapping("/delete/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean delete(@PathVariable("id") int id) {
        return loanApplyService.delete(id);
    }

    @ApiOperation("更新节点(借款申請列表使用)")
    @PostMapping("/updateLoan")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean updateLoan(@RequestBody LoanApplyUpDTO model) {
        return loanApplyService.update(model);
    }

    @ApiOperation("获取节点列表(借款申請列表&出纳付款列表共用)")
    @PostMapping("/getLoanList")
    public ResultBean<PageDTO<LoanApplyRSDTO>> getBankBillList(@RequestBody LoanApplyRQDTO model) {
        return loanApplyService.getList(model);
    }

    @ApiOperation("发起审批(借款申請列表使用)")
    @GetMapping("/approve/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean approve(@ApiParam("借款申请ID") @PathVariable("id") Integer id) {
        return loanApplyService.approve(id);
    }

//    @ApiOperation("查询审批记录(借款申請列表&出纳付款列表共用)")
//    @GetMapping("/selectFlowInfo/{id}")
//    @Transactional(rollbackFor = Exception.class)
//    public ResultBean selectFlowInfo(@PathVariable("id") int id) {
//        return loanApplyService.delete(id);
//    }

    @ApiOperation("付款(出纳付款列表使用)")
    @PostMapping("/pay")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean pay(@RequestBody  LoanApplyPayDTO loanApplyPayDTO) {
        return loanApplyService.pay(loanApplyPayDTO);
    }




}
