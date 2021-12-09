package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillDTO;
import com.deepsoft.haolifa.service.finance.BankBillService;
import com.deepsoft.haolifa.service.finance.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * 分解审核->>查银行日记账
 * 申请借款 报销的 报销 出纳
 * 分解审核
 */
@RestController
@RequestMapping("/finance/billContract")
@Api(tags = {"分解审核"})
public class BillContractController {
    @Autowired
    private BillService billService;

    @ApiOperation("获取节点列表")
    @PostMapping("/getBankBillList")
    public ResultBean getBankBillList(@RequestBody BizBillDTO billDTO) {
        return billService.getList(billDTO);
    }

    @ApiOperation("获取节点列表")
    @PostMapping("/detail/{billId}")
    public ResultBean detailList(@PathVariable("billId") int id) {
        return billService.getBillContractDetailByBillId(id);
    }


}
