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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
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


//    @PostMapping("/addContract")
//    @ResponseBody
//    @Transactional(rollbackFor = Exception.class)
//    public AjaxResult addContract() {
//        String bcId = getRequest().getParameter("bcId");
//        String dataId = getRequest().getParameter("dataId");//合同id
//        String billId = getRequest().getParameter("billId");//业务数据id
//        String remark = getRequest().getParameter("remark");
//        String amount = getRequest().getParameter("amount");
//
//
//        //一.判断合同的金额是否够分
//        // 1. 查询合同的总价
//        BizProcessData bizProcessData = bizProcessDataService.selectBizProcessDataById(Long.parseLong(dataId));
//        Double contractAmount = bizProcessData.getPrice1();
//        // 2. 查询该合同已经分解的金额
//        BizBillContract query = new BizBillContract();
//        query.setDataId(Long.parseLong(dataId));
//        List<BizBillContract> bizBillContractList = bizBillContractService.selectBizBillContractList(query);
//        double dataAmount = bizBillContractList.stream().mapToDouble(BizBillContract::getAmount).sum();
//        double splitAmount = dataAmount + Double.parseDouble(amount);
//        logger.info("add contract v:{},dataAmount:{},dataId:{}", splitAmount, dataAmount, dataId);
//        if (splitAmount > contractAmount) {
//            return error("此合同的已付金额+这次分解的金额 大于合同金额");
//        }
//
//
//        //二.判断银行日记账的金额是否够分
//        // 1. 查询银行日记账的总价
//        BizBankBill bizBankBill = bizBankBillService.selectBizBankBillById(Long.parseLong(billId));
//        Double collectionMoney = bizBankBill.getCollectionMoney();
//        // 2. 查询该合同已经分解的金额
//        BizBillContract query1 = new BizBillContract();
//        query1.setBillId(Long.parseLong(billId));
//        List<BizBillContract> bizBillContracts = bizBillContractService.selectBizBillContractList(query1);
//        double alreadyAmount = bizBillContracts.stream().mapToDouble(BizBillContract::getAmount).sum();
//        double totalAmount = alreadyAmount + Double.parseDouble(amount);
//        logger.info("add contract totalAmount:{},dataAmount:{},billId:{}", totalAmount, alreadyAmount, billId);
//        if (totalAmount > collectionMoney) {
//            return error("已分配金额+这次分解的金额 大于此笔收款金额");
//        }
//
//
//        BizBillContract bizBillContract = new BizBillContract();
//        if (!"0".equals(bcId) && StringUtils.isNotEmpty(bcId)) {
//            bizBillContract = bizBillContractService.selectBizBillContractById(Long.parseLong(bcId));
//        }
//        bizBillContract.setBillId(Long.parseLong(billId));
//        bizBillContract.setDataId(Long.parseLong(dataId));
//        bizBillContract.setAmount(Double.parseDouble(amount));
//        bizBillContract.setBookKeeper(ShiroUtils.getUserId().toString());
//        bizBillContract.setRemark(remark);
//        if ("0".equals(bcId) || StringUtils.isEmpty(bcId)) {
//            bizBillContract.setCreateTime(new Date());
//            bizBillContract.setCreateBy(ShiroUtils.getUserId().toString());
//            bizBillContractService.insertBizBillContract(bizBillContract);
//        } else {
//            bizBillContractService.updateBizBillContract(bizBillContract);
//        }
//
//        //判断合同分解是否完成
//        BizBankBill updateBill = new BizBankBill();
//        if (totalAmount >= collectionMoney) {
//            // 将分解状态更改为分解完成
//            updateBill.setContractStatus("1");
//        } else {
//            updateBill.setContractStatus("0");
//        }
//        updateBill.setContractUser(ShiroUtils.getSysUser().getUserName());
//        updateBill.setBillId(bizBankBill.getBillId());
//        bizBankBillService.updateBizBankBill(updateBill);
//
//        // 更新合同的回款状态
//        BizProcessData updateProcessData = new BizProcessData();
//        updateProcessData.setDataId(Long.parseLong(dataId));
//        if (new BigDecimal(splitAmount).compareTo(new BigDecimal(contractAmount)) < 0) {
//            updateProcessData.setString17(Constant.collectionStatus.PART);
//        } else {
//            updateProcessData.setString17(Constant.collectionStatus.ALREADY);
//        }
//        bizProcessDataService.updateBizProcessData(updateProcessData);
//        return toAjax(1);
//    }

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
