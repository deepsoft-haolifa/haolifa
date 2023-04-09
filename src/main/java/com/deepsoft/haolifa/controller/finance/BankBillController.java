package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.domain.BizBankBill;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillRSDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillUpDTO;
import com.deepsoft.haolifa.service.finance.BankBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 银行日记账
 */
@RestController
@RequestMapping("/finance/bankbill")
@Api(tags = {"好利财务-银行日记账管理"})
public class BankBillController {
    @Autowired
    private BankBillService bankBillService;


    @ApiOperation("添加节点")
    @PostMapping("/save")
    public ResultBean save(@RequestBody BizBankBillAddDTO model) {
        return bankBillService.save(model);
    }

    @ApiOperation("删除节点")
    @GetMapping("/delete/{bankBillId}")
    public ResultBean delete(@PathVariable("bankBillId") int id) {
        return bankBillService.delete(id);
    }

    @ApiOperation("更新节点")
    @PostMapping("/updateBankBill")
    public ResultBean updateBankBill(@RequestBody BizBankBillUpDTO bankBill) {
        return bankBillService.update(bankBill);
    }

    @ApiOperation("获取节点列表")
    @PostMapping("/getBankBillList")
    public ResultBean<PageDTO<BizBankBillRSDTO>> getBankBillList(@RequestBody BizBankBillDTO bankBillDTO) {
        return bankBillService.getList(bankBillDTO);
    }


}
