package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.dao.repository.PurchaseOrderMapper;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractListRQDTO;
import com.deepsoft.haolifa.service.finance.BankBillService;
import com.deepsoft.haolifa.service.finance.BillContractService;
import com.deepsoft.haolifa.service.finance.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * 分解审核->>查银行日记账&其他货币日记账
 * 申请借款 报销的 报销 出纳
 * 分解审核
 */
@RestController
@RequestMapping("/finance/billContract")
@Api(tags = {"好利财务-分解审核"})
public class BillContractController {

    @Autowired
    private BillContractService billContractService;


    @ApiOperation("获取日记账数据列表")
    @PostMapping("/list")
    public  ResultBean list(@RequestBody ContractBillRQDTO billDTO) {
        return billContractService.getBillContractList(billDTO);
    }

    @ApiOperation("获取该日记账下所属合同列表")
    @PostMapping("/contractList")
    public ResultBean contractList(@RequestBody ContractListRQDTO contractListRQDTO) {

       return billContractService.contractList(contractListRQDTO);
    }
//
//    @ApiOperation("获取节点列表")
//    @PostMapping("/selectBizBillChildList")
//    public TableDataInfo selectBizBillChildList(BizBillContract billContract) {
//        BizBillContract queryBizBill = new BizBillContract();
//        queryBizBill.setDataId(billContract.getDataId());
//        queryBizBill.setBillId(billContract.getBillId());
//        List<BizBillContract> bizProcessChildList = bizBillContractService.selectBizBillContractList(queryBizBill);
//        return getDataTable(bizProcessChildList);
//    }


}
