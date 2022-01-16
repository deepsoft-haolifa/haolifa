package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractAddOrUpDTO;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractListRQDTO;
import com.deepsoft.haolifa.service.finance.BillContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
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


    @ApiOperation("查询合同分解列表-日记账数据列表")
    @PostMapping("/billList")
    public ResultBean billList(@RequestBody ContractBillRQDTO billDTO) {
        return billContractService.getBillContractList(billDTO);
    }

    @ApiOperation("查询合同分解-合同列表")
    @PostMapping("/orderContractList")
    public ResultBean contractList(@RequestBody ContractListRQDTO contractListRQDTO) {
        return billContractService.orderContractList(contractListRQDTO);
    }

    @ApiOperation("查询合同分解-分解详情")
    @PostMapping("/selectBizBillChildList")
    public ResultBean selectBizBillChildList(@RequestBody BillContractRQDTO billContract) {
        return billContractService.selectBizBillContractList(billContract);
    }


    @PostMapping("/addOrUpContract")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public ResultBean addOrUpContract(@RequestBody BillContractAddOrUpDTO billContract) {
        return billContractService.addOrUpContract(billContract);
    }

//
//    @PostMapping("/auditContract")
//    @ResponseBody
//    public AjaxResult auditContract(BizBillContract billContract) {
//        return toAjax(bizBillContractService.updateBizBillContract(billContract));
//    }
//
//    @PostMapping("/removeContract")
//    @ResponseBody
//    public AjaxResult removeTest() {
//        String bcId = getRequest().getParameter("bcId");
//        String billId = getRequest().getParameter("billId");//业务数据id
//        if ("0".equals(bcId)) {
//            return toAjax(1);
//        }
//        bizBillContractService.deleteBizBillContractById(Long.parseLong(bcId));
//        BizBankBill updateBill = new BizBankBill();
//        updateBill.setBillId(Long.parseLong(billId));
//        bizBankBillService.updateBizBankBill(updateBill);
//        updateBill.setContractStatus("0");
//        return toAjax(1);
//    }
//


}
