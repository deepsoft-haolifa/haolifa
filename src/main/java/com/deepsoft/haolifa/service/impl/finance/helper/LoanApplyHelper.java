package com.deepsoft.haolifa.service.impl.finance.helper;

import cn.hutool.core.util.ObjectUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.enums.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.FlowInstanceDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyAddDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyPayDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import static com.deepsoft.haolifa.constant.CommonEnum.FlowId.LOAN_APP_FLOW;
import static com.deepsoft.haolifa.constant.CommonEnum.FormType.LOAN_APP_TYPE;


@Component
public class LoanApplyHelper {

    @Resource
    private SysUserService sysUserService;

    public BizBillAddDTO buildBizBillAddDTO(LoanApplyPayDTO loanApplyPayDTO, BizLoanApply selectByPrimaryKey, SysUser sysUser) {
        BizBillAddDTO bizBill = new BizBillAddDTO();
        bizBill.setType(BookingTypeEnum.cash_bill.getCode());
        bizBill.setCertificateNumber(loanApplyPayDTO.getPayAccount());
        bizBill.setD(new Date());
        bizBill.setDeptId(selectByPrimaryKey.getDeptId() + "");
        bizBill.setPaymentType(PayWayEnum.cash_pay.getDesc());
        bizBill.setPayment(selectByPrimaryKey.getAmount());
        bizBill.setRemark("借款付款 " + selectByPrimaryKey.getAmount());
        bizBill.setString1(sysUser.getRealName());
        bizBill.setString2(loanApplyPayDTO.getPayCompany());
        return bizBill;
    }

    public FlowInstanceDTO buildFlowInstanceDTO(BizLoanApply loanApply) {
        FlowInstanceDTO flowInstanceDTO = new FlowInstanceDTO();
        flowInstanceDTO.setFlowId(LOAN_APP_FLOW.id);
        flowInstanceDTO.setSummary("借款申请审批");
        flowInstanceDTO.setFormType(LOAN_APP_TYPE.code);
        flowInstanceDTO.setFormNo(loanApply.getSerialNo());
        flowInstanceDTO.setFormId(loanApply.getId());
        return flowInstanceDTO;
    }

    public LoanApplyRSDTO convertLoanApplyRSDTO(Map<String, String> projectCodeMap, Map<Integer, SysDepartment> sysDepartmentMap, boolean iscn, Map<Integer, SysUser> finalSysUserMap, BizLoanApply loanApply) {
        LoanApplyRSDTO loanApplyRSDTO = new LoanApplyRSDTO();
        BeanUtils.copyProperties(loanApply, loanApplyRSDTO);
        SysDepartment sysDepartment = sysDepartmentMap.get(loanApply.getDeptId());
        if (sysDepartment != null) {
            loanApplyRSDTO.setDeptName(sysDepartment.getDeptName());
        }
        SysUser sysUser = finalSysUserMap.get(loanApply.getLoanUser());
        if (sysUser != null) {
            loanApplyRSDTO.setLoanUserName(sysUser.getRealName());
        }
        LoanApplyStatusEnum applyStatusEnum = LoanApplyStatusEnum.valueOfCode(loanApply.getApplyStatus());

        loanApplyRSDTO.setApplyStatusCN(applyStatusEnum == null ?
            LoanApplyStatusEnum.PENDING_APPROVAL.getDesc() : applyStatusEnum.getDesc());
        LoanPayWayEnum payWayEnum = LoanPayWayEnum.valueOfCode(loanApply.getAmountType());
        loanApplyRSDTO.setAmountTypeCN(payWayEnum == null ? null : payWayEnum.getDesc());

        BigDecimal amount = loanApply.getAmount() == null ? BigDecimal.ZERO : loanApply.getAmount();
        BigDecimal paymentAmount = loanApply.getPaymentAmount() == null ? BigDecimal.ZERO : loanApply.getPaymentAmount();
        loanApplyRSDTO.setOwedAmount(amount.subtract(paymentAmount));
        LoanBillTypeEnum billTypeEnum = LoanBillTypeEnum.valueOfCode(loanApply.getBillNature());
        loanApplyRSDTO.setBillNatureCN(billTypeEnum == null ? null : billTypeEnum.getDesc());

        LoanrPayStatusEnum payStatusEnum = LoanrPayStatusEnum.valueOfCode(loanApply.getPayStatus());
        loanApplyRSDTO.setPayStatusCN(payStatusEnum == null ? LoanrPayStatusEnum.un_pay.getDesc() : payStatusEnum.getDesc());

        // 角色 == 出纳 && 支付状态 == 0（未付款）&& 确认状态 == 1（出纳付款）
        boolean canPay = iscn
            && StringUtils.equalsIgnoreCase(loanApply.getApplyStatus(), LoanApplyStatusEnum.IN_PAYMENT.getCode())
            && (
            StringUtils.equalsIgnoreCase(loanApply.getPayStatus(), LoanrPayStatusEnum.un_pay.getCode())
                || StringUtils.equalsIgnoreCase(loanApply.getPayStatus(), LoanrPayStatusEnum.partial_pay.getCode())
        );
//        canPay = true;
        loanApplyRSDTO.setCanPay(canPay);

        loanApplyRSDTO.setProjectCodeName(projectCodeMap.getOrDefault(loanApplyRSDTO.getProjectCode(), ""));
        return loanApplyRSDTO;
    }

    public BizLoanApplyExample buildBizLoanApplyExample(LoanApplyRQDTO model) {
        BizLoanApplyExample loanApplyExample = new BizLoanApplyExample();
        BizLoanApplyExample.Criteria criteria = loanApplyExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        criteria.andCreateUserEqualTo(sysUserService.selectLoginUser().getId());
        //付款状态（1未付款 2付款中 3付款完成
        criteria.andPayStatusEqualTo(model.getPayStatus());

        loanApplyExample.setOrderByClause("id desc");
        return loanApplyExample;
    }

    public BizLoanApply buildBizLoanApply(BizLoanApply bizLoanApply, BigDecimal payAmount) {
        BizLoanApply bizLoanApplyUp = new BizLoanApply();
        bizLoanApplyUp.setId(bizLoanApply.getId());
        bizLoanApplyUp.setPaymentAmount(payAmount);
        if (payAmount.compareTo(bizLoanApply.getAmount()) == 0) {
            bizLoanApplyUp.setPaymentStatus(LoanrPaymentStatusEnum.all_pay.getCode());
        } else if (payAmount.compareTo(BigDecimal.ZERO) == 0){
            bizLoanApplyUp.setPaymentStatus(LoanrPaymentStatusEnum.un_pay.getCode());
        }else {
            bizLoanApplyUp.setPaymentStatus(LoanrPaymentStatusEnum.partial_pay.getCode());
        }
        return bizLoanApplyUp;
    }

    public BizPaymentHistory buildBizPaymentHistory(BigDecimal offsetAmount, BizLoanApply bizLoanApply) {
        BizPaymentHistory paymentHistory = new BizPaymentHistory();
        paymentHistory.setAmount(offsetAmount);
        paymentHistory.setLoanId(bizLoanApply.getId());
        paymentHistory.setLoanSerialNo(bizLoanApply.getSerialNo());
        paymentHistory.setLoanUser(bizLoanApply.getLoanUser());
        paymentHistory.setLoanDate(bizLoanApply.getLoanDate());
        paymentHistory.setAmountType(bizLoanApply.getAmountType());
        paymentHistory.setBillNature("4");
        paymentHistory.setRepaymentUser(sysUserService.selectLoginUser().getId());
        paymentHistory.setRepaymentDate(new Date());
        paymentHistory.setRemark("报销冲抵");
        return paymentHistory;
    }

    public BizPaymentHistory buildFallbackBizPaymentHistory(BigDecimal offsetAmount, BizLoanApply bizLoanApply) {
        BizPaymentHistory paymentHistory = new BizPaymentHistory();
        paymentHistory.setAmount(offsetAmount.negate());
        paymentHistory.setLoanId(bizLoanApply.getId());
        paymentHistory.setLoanSerialNo(bizLoanApply.getSerialNo());
        paymentHistory.setLoanUser(bizLoanApply.getLoanUser());
        paymentHistory.setLoanDate(bizLoanApply.getLoanDate());
        paymentHistory.setAmountType(bizLoanApply.getAmountType());
        paymentHistory.setBillNature("4");
        paymentHistory.setRepaymentUser(sysUserService.selectLoginUser().getId());
        paymentHistory.setRepaymentDate(new Date());
        paymentHistory.setRemark("报销冲抵 回退");
        return paymentHistory;
    }

    public BizLoanApply buildBizLoanApply(LoanApplyPayDTO loanApplyPayDTO) {
        BizLoanApply loanApply = new BizLoanApply();
        BeanUtils.copyProperties(loanApplyPayDTO, loanApply);
        loanApply.setPayStatus(LoanrPayStatusEnum.all_pay.getCode());
        loanApply.setPayTime(new Date());
        loanApply.setUpdateTime(new Date());
        loanApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        return loanApply;
    }

    public BizOtherBillAddDTO buildBizOtherBillAddDTO(LoanApplyPayDTO loanApplyPayDTO, BizLoanApply selectByPrimaryKey, SysUser sysUser) {
        BizOtherBillAddDTO otherBillAddDTO = new BizOtherBillAddDTO();
        // 付款
        otherBillAddDTO.setType("2");
        otherBillAddDTO.setDeptId(selectByPrimaryKey.getDeptId());
        otherBillAddDTO.setCompany(loanApplyPayDTO.getPayCompany());
        otherBillAddDTO.setCertificateNumber("");
        otherBillAddDTO.setOperateDate(new Date());
        otherBillAddDTO.setPayWay(PayWayEnum.acceptance_pay.getDesc());
        otherBillAddDTO.setPaymentType(PayWayEnum.acceptance_pay.getDesc());
        otherBillAddDTO.setPayment(selectByPrimaryKey.getAmount());
        otherBillAddDTO.setRemark("借款付款 " + selectByPrimaryKey.getAmount());
        otherBillAddDTO.setPayCompany(loanApplyPayDTO.getPayCompany());
        otherBillAddDTO.setPayAccount(loanApplyPayDTO.getPayAccount());
        otherBillAddDTO.setCollectCompany(sysUser.getRealName());
        return otherBillAddDTO;
    }

    public BizBankBillAddDTO buildBizBankBillAddDTO(LoanApplyPayDTO loanApplyPayDTO, BizLoanApply selectByPrimaryKey, SysUser sysUser) {
        BizBankBillAddDTO bizBankBill = new BizBankBillAddDTO();
        // 付款
        bizBankBill.setType("2");
        bizBankBill.setCompany(loanApplyPayDTO.getPayCompany());
        bizBankBill.setCertificateNumber("");
        bizBankBill.setOperateDate(new Date());
        bizBankBill.setDeptId(selectByPrimaryKey.getDeptId());
        bizBankBill.setPayWay(PayWayEnum.check_pay.getDesc());
        bizBankBill.setPaymentType(PayWayEnum.check_pay.getDesc());
        bizBankBill.setPayment(selectByPrimaryKey.getAmount());
        bizBankBill.setRemark("借款付款 " + selectByPrimaryKey.getAmount());
        bizBankBill.setPayCompany(loanApplyPayDTO.getPayCompany());
        bizBankBill.setPayAccount(loanApplyPayDTO.getPayAccount());
        bizBankBill.setCollectCompany(sysUser.getRealName());
        return bizBankBill;
    }

    public ResultBean<Object> validate(LoanApplyAddDTO model) {
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }

        if (StringUtils.isEmpty(model.getProjectCode())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "项目编号必传");
        }
        if (StringUtils.isEmpty(model.getPayType())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "支付类型必传");
        }
        if (StringUtils.isEmpty(model.getTravelFlag())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "是否差旅借款必传");
        }

        if (StringUtils.equalsIgnoreCase("1", model.getTravelFlag())) {
            if (model.getTravelDays() == null) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "出差天数必传");
            }
            if (model.getTravelPeoNum() == null) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "出差人数必传");
            }
            if (StringUtils.isEmpty(model.getTravelArrAddress())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "出差地点必传");
            }
        }

        if (ObjectUtil.isEmpty(model.getLoanDate())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "借款日期必传");
        }
        if (ObjectUtil.isEmpty(model.getExpectRepaymentDate())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "预计还款日期必传");
        }
        if (ObjectUtil.isEmpty(model.getAmount())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "借款金额必传");
        }
        if (StringUtils.isEmpty(model.getPurpose())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "用途必传");
        }
        if (StringUtils.isEmpty(model.getAccountName())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "户名必传");
        }
        if (StringUtils.isEmpty(model.getCardNumber())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "卡号必传");
        }
        if (StringUtils.isEmpty(model.getBankOfDeposit())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "开户行必传");
        }

        return null;
    }


}
