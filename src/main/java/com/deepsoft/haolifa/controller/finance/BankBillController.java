package com.deepsoft.haolifa.controller.finance;


import cn.hutool.core.util.ObjectUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.BizBankBill;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.*;
import com.deepsoft.haolifa.service.finance.BankBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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


    @ApiOperation("转账")
    @PostMapping("/transfer")
    public ResultBean transfer(@RequestBody BizBankBillTransferDTO model) {

            if (ObjectUtil.isEmpty(model.getSourceAccount())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"来源账户必填");
            }
            if (StringUtils.equals("2",model.getTransferType())||StringUtils.equals("3",model.getTransferType())){
                if (StringUtils.isEmpty(model.getTargetAccount())) {
                    return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"目标账户必填");
                }
            }
            if (StringUtils.isEmpty(model.getTransferType())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"转出方式必填");
            }
            if (null == model.getPayment()) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"付款必填");
            }
        return bankBillService.transfer(model);
    }

    @ApiOperation("添加节点")
    @PostMapping("/save")
    public ResultBean save(@RequestBody BizBankBillAddDTO model) {
        if (model.getType().equals("2")) {
            if (StringUtils.isEmpty(model.getProjectCode())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"项目编号必填");
            }
            if (ObjectUtil.isEmpty(model.getOperateDate())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"日期必填");
            }
            if (StringUtils.isEmpty(model.getCollectCompany())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"收款单位必填");
            }
            if (StringUtils.isEmpty(model.getPayWay())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"付款方式必填");
            }
            if (StringUtils.isEmpty(model.getPayAccount())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"付款账户必填");
            }
            if (ObjectUtil.isEmpty(model.getSubject())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"科目必填");
            }
            if (StringUtils.isEmpty(model.getPaymentType())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"付款类别必填");
            }
            if (null == model.getPayment()) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,"付款必填");
            }
        }
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
