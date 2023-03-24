package com.deepsoft.haolifa.service.impl.finance.helper;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.dao.repository.BizSubjectsMapper;
import com.deepsoft.haolifa.dao.repository.PayUserMapper;
import com.deepsoft.haolifa.enums.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetDecDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetQueryBO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetUpDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.ReimburseApplyAddDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.ReimburseApplyPayDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.ReimburseApplyUpDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost.ReimburseCostDetailAddDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost.ReimburseCostDetailUpDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.travel.ReimburseTravelDetailAddDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.travel.ReimburseTravelDetailUpDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceUpDTO;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.CostBudgetService;
import com.deepsoft.haolifa.service.finance.ProjectBudgetService;
import com.deepsoft.haolifa.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.deepsoft.haolifa.constant.CommonEnum.FlowId.REIMBURSE_APP_FLOW;
import static com.deepsoft.haolifa.constant.CommonEnum.FormType.REIMBURSE_APP_TYPE;

@Component
public class RemiburseHelper {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private DepartmentService departmentService;

    @Resource
    private BizSubjectsMapper bizSubjectsMapper;

    @Resource
    private SysDictService sysDictService;

    @Resource
    private PayUserMapper payUserMapper;

    @Resource
    private ProjectBudgetService projectBudgetService;

    @Resource
    private CostBudgetService costBudgetService;


    public ResultBean<Object> validate(ReimburseApplyAddDTO model) {
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }


        if (StringUtils.isEmpty(model.getType())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "报销类型必传");
        }
        if (StringUtils.equalsIgnoreCase(model.getType(), "1") && StringUtils.isEmpty(model.getTravelUserName())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "差旅报销出差人必传");
        }
        if (StringUtils.isEmpty(model.getReimburseType())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "报销方式必传");
        }
        if (StringUtils.equalsIgnoreCase("2", model.getReimburseType())) {
//            if (model.getLoanId() == null) {
//                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "请选择冲抵借款");
//            }
            if (model.getOffsetAmount() == null || model.getOffsetAmount().compareTo(BigDecimal.ZERO) <= 0) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "冲抵金额不可为空");
            }
        }

        if (ObjectUtil.isEmpty(model.getReimburseDate())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "报销日期必传");
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
        if (CollectionUtil.isEmpty(model.getReimburseCostDetailAddDTOList()) && CollectionUtil.isEmpty(model.getReimburseTravelDetailAddDTOList())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "报销明细必传");
        }
        // 费用报销
        if (StringUtils.equalsIgnoreCase(model.getType(), "2")) {
            for (ReimburseCostDetailAddDTO reimburseCostDetailAddDTO : model.getReimburseCostDetailAddDTOList()) {
                if (reimburseCostDetailAddDTO.getAmount() == null) {
                    return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "明细金额必传");
                }
                if (reimburseCostDetailAddDTO.getDocNum() == null) {
                    return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "明细单据张数必传");
                }
                if (reimburseCostDetailAddDTO.getTime() == null) {
                    return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "明细日期必传");
                }
                if (reimburseCostDetailAddDTO.getSubject() == null) {
                    return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "明细报销科目必传");
                }
            }
        }
        if (CollectionUtil.isEmpty(model.getFileUrlList())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "报销附件必传");
        }

        return null;
    }

    public BizReimburseCostDetail buildBizReimburseCostDetail(CustomUser customUser, String ser, BizReimburseApply reimburseApply, ReimburseCostDetailAddDTO reimburseCostDetailAddDTO) {
        BizReimburseCostDetail record = new BizReimburseCostDetail();
        BeanUtils.copyProperties(reimburseCostDetailAddDTO, record);
        record.setSerialNo(ser);
        record.setReimburseId(reimburseApply.getId());
        record.setPayStatus(ReimbursePayStatusEnum.un_pay.getCode());
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateUser(customUser.getId());
        record.setUpdateUser(customUser.getId());
        return record;
    }

    public BizReimburseCostDetail buildBizReimburseCostDetail(CustomUser customUser, String ser, BizReimburseApply reimburseApply, ReimburseCostDetailUpDTO reimburseCostDetailAddDTO) {
        BizReimburseCostDetail record = new BizReimburseCostDetail();
        BeanUtils.copyProperties(reimburseCostDetailAddDTO, record);
        record.setSerialNo(ser);
        record.setReimburseId(reimburseApply.getId());
        record.setPayStatus(ReimbursePayStatusEnum.un_pay.getCode());
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateUser(customUser.getId());
        record.setUpdateUser(customUser.getId());
        return record;
    }

    public BizReimburseTravelDetail buildBizReimburseTravelDetail(CustomUser customUser, String ser, BizReimburseApply reimburseApply, ReimburseTravelDetailAddDTO reimburseTravelDetailAddDTO) {
        BizReimburseTravelDetail record = new BizReimburseTravelDetail();
        BeanUtils.copyProperties(reimburseTravelDetailAddDTO, record);
        record.setSerialNo(ser);
        record.setReimburseId(reimburseApply.getId());
        record.setPayStatus(ReimbursePayStatusEnum.un_pay.getCode());
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateUser(customUser.getId());
        record.setUpdateUser(customUser.getId());
        return record;
    }

    public BizReimburseTravelDetail buildBizReimburseTravelDetail(CustomUser customUser, String ser, BizReimburseApply reimburseApply, ReimburseTravelDetailUpDTO reimburseTravelDetailAddDTO) {
        BizReimburseTravelDetail record = new BizReimburseTravelDetail();
        BeanUtils.copyProperties(reimburseTravelDetailAddDTO, record);
        record.setSerialNo(ser);
        record.setReimburseId(reimburseApply.getId());
        record.setPayStatus(ReimbursePayStatusEnum.un_pay.getCode());
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateUser(customUser.getId());
        record.setUpdateUser(customUser.getId());
        return record;
    }

    public BizReimburseApply buildBizReimburseApply(ReimburseApplyAddDTO model, CustomUser customUser, SysUser sysUser, BigDecimal totalAmount, String ser) {
        PayUser payUser = payUserMapper.selectByPhoneOrIdCard(sysUser.getPhone(), sysUser.getIdCard());

        BizReimburseApply reimburseApply = new BizReimburseApply();
        BeanUtils.copyProperties(model, reimburseApply);
//        reimburseApply.setReimburseUserNo(payUser.getUserNo());

        reimburseApply.setSerialNo(ser);
        reimburseApply.setAmount(totalAmount);
        reimburseApply.setCreateTime(new Date());
        reimburseApply.setUpdateTime(new Date());
        //reimburseApply.setApplyStatus(ReimburseApplyStatusEnum.PENDING_APPROVAL.getCode());
        reimburseApply.setPayStatus(ReimbursePayStatusEnum.un_pay.getCode());
        reimburseApply.setDeptId(sysUser.getDepartId());
        reimburseApply.setReimburseUser(customUser.getId());
        reimburseApply.setCreateUser(customUser.getId());
        reimburseApply.setUpdateUser(customUser.getId());

        //上传到7牛文件服务器
        String fileUrl = "";
        if (CollectionUtil.isNotEmpty(model.getFileUrlList())) {
            fileUrl = JSON.toJSONString(model.getFileUrlList());
        }
        reimburseApply.setFileUrl(fileUrl);

        String loanIdStr = model.getLoanIdList().stream()
            .map(i -> i + "")
            .collect(Collectors.joining(","));
        reimburseApply.setLoanIdStr(loanIdStr);
        return reimburseApply;
    }

    public BigDecimal getTotalAmount(ReimburseApplyAddDTO model) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        ReimburseTypeEnum reimburseTypeEnum = ReimburseTypeEnum.valueOfCode(model.getType());
        switch (reimburseTypeEnum) {
            case travle: {
                if (CollectionUtil.isNotEmpty(model.getReimburseTravelDetailAddDTOList())) {
                    totalAmount = model.getReimburseTravelDetailAddDTOList()
                        .stream()
                        .map(o -> {
                            BigDecimal projectAmount = o.getProjectAmount();
                            BigDecimal travelSubsidyAmount = o.getTravelSubsidyAmount().multiply(BigDecimal.valueOf(o.getTravelDays()));
                            BigDecimal vehicleAmount = o.getVehicleAmount();
                            BigDecimal add = projectAmount.add(travelSubsidyAmount).add(vehicleAmount);
                            return add;
                        })
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                }
                break;
            }
            case cost: {
                if (CollectionUtil.isNotEmpty(model.getReimburseCostDetailAddDTOList())) {
                    totalAmount = model.getReimburseCostDetailAddDTOList().stream()
                        .map(ReimburseCostDetailAddDTO::getAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                }
                break;
            }
        }


        return totalAmount;
    }

    public BigDecimal getTotalAmount(ReimburseApplyUpDTO model) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        ReimburseTypeEnum reimburseTypeEnum = ReimburseTypeEnum.valueOfCode(model.getType());
        switch (reimburseTypeEnum) {
            case travle: {
                if (CollectionUtil.isNotEmpty(model.getReimburseTravelDetailAddDTOList())) {
                    totalAmount = model.getReimburseTravelDetailAddDTOList()
                        .stream()
                        .map(o -> {
                            BigDecimal projectAmount = o.getProjectAmount();
                            BigDecimal travelSubsidyAmount = o.getTravelSubsidyAmount().multiply(BigDecimal.valueOf(o.getTravelDays()));
                            BigDecimal vehicleAmount = o.getVehicleAmount();
                            BigDecimal add = projectAmount.add(travelSubsidyAmount).add(vehicleAmount);
                            return add;
                        })
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                }
                break;
            }
            case cost: {
                if (CollectionUtil.isNotEmpty(model.getReimburseCostDetailAddDTOList())) {
                    totalAmount = model.getReimburseCostDetailAddDTOList().stream()
                        .map(ReimburseCostDetailUpDTO::getAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                }
                break;
            }
        }


        return totalAmount;
    }


    public void backProjectAmount(BizReimburseApply selectByPrimaryKey) {
        ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
        queryBO.setCode(selectByPrimaryKey.getProjectCode());
        queryBO.setDeptId(selectByPrimaryKey.getDeptId());
        queryBO.setDate(selectByPrimaryKey.getCreateTime());
        // 校验当月项目预算
        BizProjectBudget bizProjectBudget = projectBudgetService.queryCurMonthBudget(queryBO);

        // 回退
        ProjectBudgetDecDTO budgetUpDTO = new ProjectBudgetDecDTO();
        budgetUpDTO.setId(bizProjectBudget.getId());
        budgetUpDTO.setBalanceQuota(bizProjectBudget.getBalanceQuota().add(selectByPrimaryKey.getAmount()));
        projectBudgetService.decrement(budgetUpDTO);
    }


    public BizSubjectsBalanceUpDTO buildBizSubjectsBalanceUpDTO(BizReimburseApply bizReimburseApplyS, BizReimburseCostDetail reimburseCostDetail) {
        BizSubjectsBalanceUpDTO bizSubjects = new BizSubjectsBalanceUpDTO();
        bizSubjects.setSubjectsId(reimburseCostDetail.getSubject());
        bizSubjects.setDeptId(bizReimburseApplyS.getDeptId());
        bizSubjects.setAmount(reimburseCostDetail.getAmount());
        return bizSubjects;
    }


    public BizBankBillAddDTO buildBizBankBillAddDTO(ReimburseApplyPayDTO payDTO, BigDecimal applySAmount, BizReimburseApply bizReimburseApplyS) {
        BizBankBillAddDTO bizBankBill = new BizBankBillAddDTO();
        // 付款
        bizBankBill.setType("2");
        bizBankBill.setCompany(payDTO.getPayCompany());
        bizBankBill.setCertificateNumber("");
        bizBankBill.setOperateDate(new Date());
        bizBankBill.setDeptId(bizReimburseApplyS.getDeptId());
        bizBankBill.setPayWay(PayWayEnum.check_pay.getDesc());
        bizBankBill.setPaymentType(PayWayEnum.check_pay.getDesc());
        bizBankBill.setPayment(applySAmount);
        bizBankBill.setRemark("报销付款 " + applySAmount);
        bizBankBill.setPayCompany(payDTO.getPayCompany());
        bizBankBill.setPayAccount(payDTO.getPayAccount());
        bizBankBill.setCollectCompany(bizReimburseApplyS.getAccountName());


        return bizBankBill;
    }


    public BizBankBillAddDTO buildFallbackBizBankBillAddDTO(BizReimburseApply bizReimburseApplyS) {
        BizBankBillAddDTO bizBankBill = new BizBankBillAddDTO();
        // 付款
        bizBankBill.setType("1");
        bizBankBill.setCompany(bizReimburseApplyS.getPayCompany());
        bizBankBill.setCertificateNumber("");
        bizBankBill.setOperateDate(new Date());
        bizBankBill.setDeptId(bizReimburseApplyS.getDeptId());
        bizBankBill.setPayWay(PayWayEnum.check_pay.getDesc());
        bizBankBill.setCollectionType(PayWayEnum.check_pay.getDesc());
        bizBankBill.setCollectionMoney(bizReimburseApplyS.getAmount());
        bizBankBill.setRemark("回退 报销付款 " + bizReimburseApplyS.getAmount());
        bizBankBill.setPayCompany(bizReimburseApplyS.getAccountName());
        bizBankBill.setPayAccount(bizReimburseApplyS.getPayAccount());
        bizBankBill.setCollectCompany(bizReimburseApplyS.getPayCompany());


        return bizBankBill;
    }

    public BizBillAddDTO buildBizBillAddDTO(ReimburseApplyPayDTO payDTO, BigDecimal applySAmount, SysUser sysUser, BizReimburseApply bizReimburseApplyS) {
        BizBillAddDTO bizBill = new BizBillAddDTO();
        bizBill.setType(BookingTypeEnum.cash_bill.getCode());
        bizBill.setCertificateNumber(payDTO.getPayAccount());
        bizBill.setD(new Date());
        bizBill.setDeptId(bizReimburseApplyS.getDeptId() + "");
        bizBill.setPaymentType(PayWayEnum.cash_pay.getDesc());
        bizBill.setPayment(applySAmount);
        bizBill.setRemark("报销付款 " + applySAmount);
        bizBill.setString1(sysUser.getRealName());
        bizBill.setString2(payDTO.getPayCompany());

        return bizBill;
    }

    public BizBillAddDTO buildFallbackBizBillAddDTO(SysUser sysUser, BizReimburseApply bizReimburseApplyS) {
        BizBillAddDTO bizBill = new BizBillAddDTO();
        bizBill.setType(BookingTypeEnum.cash_bill.getCode());
        bizBill.setCertificateNumber(bizReimburseApplyS.getPayAccount());
        bizBill.setD(new Date());
        bizBill.setDeptId(bizReimburseApplyS.getDeptId() + "");
        bizBill.setCollectionType(PayWayEnum.cash_pay.getDesc());
        bizBill.setPayment(bizReimburseApplyS.getAmount());
        bizBill.setRemark("回退 报销付款 " + bizReimburseApplyS.getAmount());
        bizBill.setString1(sysUser.getRealName());
        bizBill.setString2(bizReimburseApplyS.getPayCompany());

        return bizBill;
    }


    public ExpensesDTO buildExpensesDTO(BizReimburseApply bizReimburseApplyS, BigDecimal totalAmount, List<BizReimburseCostDetail> reimburseCostDetailList) {
        ExpensesDTO expensesDTO = new ExpensesDTO();


        // "费用类别"
        String expensesClassify = "";
        // "二级费用类别"
        String secondClassify = "";
        Map<String, String> dictByTypeCodeMap = sysDictService.getSysDictByTypeCode(DictEnum.SUBJECTS_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));
        // 科目
        if (StringUtils.equalsIgnoreCase("2", bizReimburseApplyS.getType())) {
            BizReimburseCostDetail bizReimburseCostDetail = reimburseCostDetailList.get(0);
            BizSubjects subject = bizSubjectsMapper.selectByPrimaryKey(bizReimburseCostDetail.getSubject());
            expensesClassify = dictByTypeCodeMap.getOrDefault(subject.getType(), "");
            secondClassify = subject.getName();
        } else {
//            BizSubjectsBalance bizSubjectsBalance = costBudgetService.getSubjectsBudgetByUserId(bizReimburseApplyS.getReimburseUser(), null, "差旅费");
//            BizSubjects subject = bizSubjectsMapper.selectByPrimaryKey(bizSubjectsBalance.getSubjectsId());
//            expensesClassify = dictByTypeCodeMap.getOrDefault(subject.getType(), "");
//            secondClassify = subject.getName();
            expensesClassify = FinanceConstant.clf_cn;
            secondClassify = FinanceConstant.clf_cn;
        }

        expensesDTO.setExpensesClassify(expensesClassify);
        expensesDTO.setSecondClassify(secondClassify);
        expensesDTO.setVoucherNo(bizReimburseApplyS.getSerialNo());

        BigDecimal b = BigDecimal.ZERO;
        if (ObjectUtil.isNotNull(bizReimburseApplyS.getOffsetAmount())) {
            b = totalAmount.add(bizReimburseApplyS.getOffsetAmount()).setScale(2, 4);
        }

        expensesDTO.setTotalAmount(b);

        SysUser sysUser = sysUserService.getSysUser(bizReimburseApplyS.getReimburseUser());
        expensesDTO.setCommitUser(sysUser.getRealName());
        DepartmentDTO departmentDTO = departmentService.selectDepartmentById(sysUser.getDepartId());
        expensesDTO.setDepartment(departmentDTO.getDeptName());

        expensesDTO.setSummary(bizReimburseApplyS.getRemark());
        expensesDTO.setRemark(bizReimburseApplyS.getRemark());
        expensesDTO.setDataDate(DateUtils.getDate());
        return expensesDTO;
    }

    public BizReimburseApply buildBizReimburseApply(ReimburseApplyPayDTO payDTO) {
        BizReimburseApply apply = new BizReimburseApply();
        BeanUtils.copyProperties(payDTO, apply);
        apply.setPayStatus(LoanrPayStatusEnum.all_pay.getCode());
        apply.setPayTime(new Date());
        apply.setUpdateTime(new Date());
        apply.setUpdateUser(sysUserService.selectLoginUser().getId());
        return apply;
    }

    public BizReimburseApply buildFallbackBizReimburseApply(BizReimburseApply bizReimburseApplyS) {
        BizReimburseApply apply = new BizReimburseApply();
        apply.setId(bizReimburseApplyS.getId());
        apply.setPayCompany("");
        apply.setPayAccount("");
        apply.setApplyStatus(ReimburseApplyStatusEnum.APPROVAL_FAILED.getCode());
        apply.setPayStatus(LoanrPayStatusEnum.un_pay.getCode());
        apply.setPayTime(new Date());
        apply.setUpdateTime(new Date());
        apply.setUpdateUser(sysUserService.selectLoginUser().getId());
        apply.setRemark(bizReimburseApplyS.getRemark() + " 回退");
        return apply;
    }

    public BizBankBillAddDTO buildBizBankBillAddDTO(BizReimburseApply bizReimburseApplyS, SysUser sysUser, ReimburseApplyPayDTO payDTO) {
        BizBankBillAddDTO bizBankBill = new BizBankBillAddDTO();
        // 收款
        bizBankBill.setType("1");
        bizBankBill.setCompany(Constant.company);
        bizBankBill.setAccount(payDTO.getPayAccount());
        bizBankBill.setDeptId(bizReimburseApplyS.getDeptId());
        bizBankBill.setCertificateNumber(bizReimburseApplyS.getSerialNo());
        bizBankBill.setOperateDate(new Date());
        bizBankBill.setPayWay(PayWayEnum.cash_pay.getDesc());
        bizBankBill.setPaymentType(PayWayEnum.cash_pay.getDesc());
        // 负数的绝对值
        bizBankBill.setCollectionMoney(bizReimburseApplyS.getAmount().abs());
        bizBankBill.setRemark("报销冲抵");
        bizBankBill.setPayCompany(sysUser.getRealName());
        bizBankBill.setPayAccount(payDTO.getPayAccount());
        bizBankBill.setCollectCompany(Constant.company);
        // 1	费用
        //2	货款
        //3	借款
        //4	其他
        //1	费用
        //2	货款
        //3	借款
        //4	其他
        bizBankBill.setCollectionType("3");
        return bizBankBill;
    }

    public BizBankBillAddDTO buildFallbackBizBankBillAddDTO(BizReimburseApply bizReimburseApplyS, SysUser sysUser) {
        BizBankBillAddDTO bizBankBill = new BizBankBillAddDTO();
        // 付款
        bizBankBill.setType("2");
        bizBankBill.setCompany(Constant.company);
        bizBankBill.setAccount(bizReimburseApplyS.getPayAccount());
        bizBankBill.setDeptId(bizReimburseApplyS.getDeptId());
        bizBankBill.setCertificateNumber(bizReimburseApplyS.getSerialNo());
        bizBankBill.setOperateDate(new Date());
        bizBankBill.setPayWay(PayWayEnum.cash_pay.getDesc());
        bizBankBill.setPaymentType(PayWayEnum.cash_pay.getDesc());
        // 负数的绝对值
        bizBankBill.setPayment(bizReimburseApplyS.getAmount().abs());
        bizBankBill.setRemark("回退 报销冲抵" + bizReimburseApplyS.getAmount());
        bizBankBill.setPayCompany(sysUser.getRealName());
        bizBankBill.setPayAccount(bizReimburseApplyS.getPayAccount());
        bizBankBill.setCollectCompany(Constant.company);

        return bizBankBill;
    }

    public FlowInstanceDTO buildFlowInstanceDTO(BizReimburseApply reimburseApply) {
        FlowInstanceDTO flowInstanceDTO = new FlowInstanceDTO();
        flowInstanceDTO.setFlowId(REIMBURSE_APP_FLOW.id);
        flowInstanceDTO.setSummary("报销申请审批");
        flowInstanceDTO.setFormType(REIMBURSE_APP_TYPE.code);
        flowInstanceDTO.setFormNo(reimburseApply.getSerialNo());
        flowInstanceDTO.setFormId(reimburseApply.getId());
        return flowInstanceDTO;
    }

    public BizOtherBillAddDTO buildBizOtherBillAddDTO(ReimburseApplyPayDTO payDTO, BizReimburseApply bizReimburseApplyS) {
        BizOtherBillAddDTO otherBillAddDTO = new BizOtherBillAddDTO();
        // 付款
        otherBillAddDTO.setType("2");
        otherBillAddDTO.setDeptId(bizReimburseApplyS.getDeptId());
        otherBillAddDTO.setCompany(payDTO.getPayCompany());
        otherBillAddDTO.setCertificateNumber("");
        otherBillAddDTO.setOperateDate(new Date());
        otherBillAddDTO.setPayWay(PayWayEnum.money_order_pay.getDesc());
        otherBillAddDTO.setPaymentType(PayWayEnum.money_order_pay.getDesc());
        otherBillAddDTO.setPayment(bizReimburseApplyS.getAmount());
        otherBillAddDTO.setRemark("报销付款 " + bizReimburseApplyS.getAmount());
        otherBillAddDTO.setPayCompany(payDTO.getPayCompany());
        otherBillAddDTO.setPayAccount(payDTO.getPayAccount());
        otherBillAddDTO.setCollectCompany(bizReimburseApplyS.getAccountName());
        return otherBillAddDTO;
    }

    public BizOtherBillAddDTO buildFallbackBizOtherBillAddDTO(BizReimburseApply bizReimburseApplyS) {
        BizOtherBillAddDTO otherBillAddDTO = new BizOtherBillAddDTO();
        // 付款
        otherBillAddDTO.setType("1");
        otherBillAddDTO.setDeptId(bizReimburseApplyS.getDeptId());
        otherBillAddDTO.setCompany(bizReimburseApplyS.getPayCompany());
        otherBillAddDTO.setCertificateNumber("");
        otherBillAddDTO.setOperateDate(new Date());
        otherBillAddDTO.setPayWay(PayWayEnum.money_order_pay.getDesc());
        otherBillAddDTO.setCollectionType(PayWayEnum.money_order_pay.getDesc());
        otherBillAddDTO.setCollectionMoney(bizReimburseApplyS.getAmount());
        otherBillAddDTO.setRemark("报销付款 " + bizReimburseApplyS.getAmount());
        otherBillAddDTO.setPayCompany(bizReimburseApplyS.getAccountName());
        otherBillAddDTO.setPayAccount(bizReimburseApplyS.getPayAccount());
        otherBillAddDTO.setCollectCompany(bizReimburseApplyS.getPayCompany());
        return otherBillAddDTO;
    }

    public BizSubjectsBalanceUpDTO buildBizSubjectsBalanceUpDTO(BizReimburseApply bizReimburseApplyS, BigDecimal totalAmount) {
        BizSubjectsBalance bizSubjectsBalance = costBudgetService.getSubjectsBudgetByUserId(
            bizReimburseApplyS.getReimburseUser(), null, FinanceConstant.clf_cn);
        // 扣除差旅费科目余额
        BizSubjectsBalanceUpDTO bizSubjects = new BizSubjectsBalanceUpDTO();
        bizSubjects.setSubjectsId(bizSubjectsBalance.getSubjectsId());
        bizSubjects.setDeptId(bizReimburseApplyS.getDeptId());
        bizSubjects.setAmount(totalAmount);
        return bizSubjects;
    }

}
