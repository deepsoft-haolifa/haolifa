package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.enums.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.payplan.*;
import com.deepsoft.haolifa.model.dto.finance.payplanlog.BizPayPlanPayLogDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetQueryBO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetUpDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceRSDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceUpDTO;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.service.ExpensesService;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.*;
import com.deepsoft.haolifa.service.impl.finance.helper.FinanceConstant;
import com.deepsoft.haolifa.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PayPlanServiceImpl implements PayPlanService {

    @Autowired
    private BizPayPlanMapper bizPayPlanMapper;
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private SysDictService sysDictService;

    @Autowired
    private BizPayPlanPayLogMapper bizPayPlanPayLogMapper;

    @Autowired
    private BizBillMapper bizBillMapper;

    @Autowired
    private BizBankBillMapper bizBankBillMapper;

    @Autowired
    private BizOtherBillMapper bizOtherBillMapper;

    @Autowired
    private BillService billService;

    @Autowired
    private BankBillService bankBillService;

    @Autowired
    private OtherBillService otherBillService;
    @Autowired
    private BizPayApplyDetailMapper bizPayApplyDetailMapper;
    @Autowired
    private BizPayApplyMapper bizPayApplyMapper;
    @Autowired
    private SubjectBalanceService subjectBalanceService;
    @Autowired
    private ExpensesService expensesService;
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ProjectBudgetService projectBudgetService;

    @Override
    public ResultBean save(BizPayPlanAddDTO model) {
        log.info("PayPlanService saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        BizPayPlan billBank = new BizPayPlan();
        BeanUtils.copyProperties(model, billBank);
        billBank.setCreateTime(new Date());
        billBank.setUpdateTime(new Date());
        billBank.setCreateUser(sysUserService.selectLoginUser().getId());
        billBank.setUpdateUser(sysUserService.selectLoginUser().getId());
        int insertId = bizPayPlanMapper.insertSelective(billBank);
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean delete(Integer id) {
        //int delete = bizPayPlanMapper.deleteByPrimaryKey(id);

        BizPayPlan billBank = new BizPayPlan();
        billBank.setId(id);
        billBank.setDelFlag("1");
        billBank.setUpdateTime(new Date());
        billBank.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizPayPlanMapper.updateByPrimaryKeySelective(billBank);
        return ResultBean.success(update);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultBean update(BizPayPlanPayDTO planPayDTO) {


        log.info("出纳付款 rq={}", JSON.toJSONString(planPayDTO));

        BizPayPlan bizPayPlan = bizPayPlanMapper.selectByPrimaryKey(planPayDTO.getId());
        if (StringUtils.equalsIgnoreCase(PayPlanPayStatusEnum.paid.getCode(), bizPayPlan.getStatus())) {
            throw new BaseException("当前付款计划以付款");
        }

        // 当前用户
        CustomUser customUser = sysUserService.selectLoginUser();

        // todo  支付状态必须是已付款  金额必须和申请金额一样
        BigDecimal bigDecimal = planPayDTO.getPayWayList().stream()
            .map(BizPayPlanPayDTO.PayWayDTO::getAmount)
            .reduce(BigDecimal::add)
            .get();
        if (bizPayPlan.getApplyAmount().doubleValue() != bigDecimal.doubleValue()) {
            throw new BaseException("当前付款金额与申请金额不一致");
        }

        BizPayPlan record = buildBizPayPlan(planPayDTO, customUser);
        int update = bizPayPlanMapper.updateByPrimaryKeySelective(record);
        if (update < 1) {
            throw new BaseException("修改状态异常");
        }

        bizPayPlan = bizPayPlanMapper.selectByPrimaryKey(planPayDTO.getId());

        PurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(Integer.parseInt(bizPayPlan.getContractId()));

        // 1 支付日志
        {
            for (BizPayPlanPayDTO.PayWayDTO payWayDTO : planPayDTO.getPayWayList()) {
                BizPayPlanPayLog payPlanPayLog = buildBizPayPlanPayLog(customUser, bizPayPlan, purchaseOrder, payWayDTO);
                bizPayPlanPayLogMapper.insert(payPlanPayLog);
            }
        }
        // 2 记账方式
        {
            for (BizPayPlanPayDTO.PayWayDTO payWayDTO : planPayDTO.getPayWayList()) {
                BookingTypeEnum bookingTypeEnum = BookingTypeEnum.valueOfCode(payWayDTO.getBookingType());
                switch (bookingTypeEnum) {
                    case cash_bill:
                        BizBillAddDTO bizBill = buildBizBillAddDTO(bizPayPlan, payWayDTO, bookingTypeEnum);
                        ResultBean billSave = billService.save(bizBill);
                        if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, billSave.getCode())) {
                            throw new BaseException(billSave.getMessage());
                        }
                        break;
                    case bank_bill:
                        BizBankBillAddDTO bizBankBillAddDTO = buildBizBankBillAddDTO(bizPayPlan, payWayDTO, bookingTypeEnum);
                        ResultBean bankSave = bankBillService.save(bizBankBillAddDTO);
                        if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, bankSave.getCode())) {
                            throw new BaseException(bankSave.getMessage());
                        }
                        break;
                    case other_bill:
                        BizOtherBillAddDTO bizBillAddDTO = buildBizOtherBillAddDTO(bizPayPlan, payWayDTO, bookingTypeEnum);
                        ResultBean otherSave = otherBillService.save(bizBillAddDTO);
                        if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, otherSave.getCode())) {
                            throw new BaseException(otherSave.getMessage());
                        }
                        break;
                }
            }

        }
        // 3 付款完成后，将采购订单的状态更新为已付款
        {
            PurchaseOrder purchaseOrderU = new PurchaseOrder();
            purchaseOrderU.setId(Integer.parseInt(bizPayPlan.getContractId()));
            //  支付状态 1 未付款 2 部分付款 3 付款完成
            BigDecimal currentPaid = purchaseOrder.getPaidAccount().add(bizPayPlan.getApplyAmount());

            BigDecimal totalPrice = purchaseOrder.getTotalPrice();
            Byte payStatus = null;
            if (totalPrice.doubleValue() >= currentPaid.doubleValue()) {
                payStatus = Byte.valueOf(OrderPayStatusEnum.all_pay.getCode());
            } else {
                payStatus = Byte.valueOf(OrderPayStatusEnum.partial_pay.getCode());
            }
            purchaseOrderU.setPayStatus(payStatus);
            purchaseOrderU.setPaidAccount(currentPaid);
            int selective = purchaseOrderMapper.updateByPrimaryKeySelective(purchaseOrderU);
        }

        // 4 付款申请支付状态改变
        {
            BizPayApply bizPayApply = bizPayApplyMapper.selectByPrimaryKey(Math.toIntExact(bizPayPlan.getPayDataId()));

            BizPayPlanExample bizPayPlanExample = new BizPayPlanExample();
            BizPayPlanExample.Criteria criteria = bizPayPlanExample.createCriteria();
            criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
            // 申请编号 ==
            criteria.andPayDataIdEqualTo(bizPayPlan.getPayDataId());
            List<BizPayPlan> bizPayPlanList = bizPayPlanMapper.selectByExample(bizPayPlanExample);
            boolean match = bizPayPlanList.stream()
                .allMatch(p -> StringUtils.equalsIgnoreCase(p.getStatus(), PayPlanPayStatusEnum.paid.getCode()));
            if (match) {
                BizPayApply payApply = new BizPayApply();
                payApply.setStatus(PayApplyPayStatusEnum.PAYMENT_COMPLETED.getCode());
                payApply.setId(bizPayApply.getId());
                bizPayApplyMapper.updateByPrimaryKeySelective(payApply);
            }
        }

        // 余额扣款
        {
            BizSubjectsBalanceUpDTO bizSubjects = new BizSubjectsBalanceUpDTO();
            bizSubjects.setSubjectsId(SubjectEnum.clf_id.getCode());
            bizSubjects.setDeptId(bizPayPlan.getDeptId());
            bizSubjects.setAmount(bigDecimal);
            subjectBalanceService.decreaseAmount(bizSubjects);

            ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
            queryBO.setName(FinanceConstant.cai_liao_f_cn);
            queryBO.setDeptId(bizPayPlan.getDeptId());
            queryBO.setDate(new Date());
            // 校验当月项目预算
            BizProjectBudget bizProjectBudget = projectBudgetService.queryCurMonthBudget(queryBO);
            //  当月未维护
            if (ObjectUtil.isNull(bizProjectBudget)) {
                throw new BaseException("当月项目预算未维护");
            }
            // 金额不足
            if (bizProjectBudget.getBalanceQuota().compareTo(bigDecimal) < 0) {
                throw new BaseException("当月项目预算金额不足");
            }

            // 扣减预算
            ProjectBudgetUpDTO budgetUpDTO = new ProjectBudgetUpDTO();
            budgetUpDTO.setId(bizProjectBudget.getId());
            budgetUpDTO.setDeptId(bizPayPlan.getDeptId());
            budgetUpDTO.setBalanceQuota(bizProjectBudget.getBalanceQuota().subtract(bigDecimal));
            ResultBean resultBean = projectBudgetService.update(budgetUpDTO);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, resultBean.getCode())) {
                throw new BaseException(resultBean.getMessage());
            }
        }

        // 费用管理
        ExpensesDTO expensesDTO = new ExpensesDTO();
        expensesDTO.setExpensesClassify(FinanceConstant.cai_liao_f_cn);
        expensesDTO.setSecondClassify("其他");
        expensesDTO.setVoucherNo(bizPayPlan.getApplyNo());
        expensesDTO.setTotalAmount(bizPayPlan.getApplyAmount());
        SysUser sysUser = sysUserService.getSysUser(bizPayPlan.getCreateUser());
        expensesDTO.setCommitUser(sysUser.getRealName());
        DepartmentDTO departmentDTO = departmentService.selectDepartmentById(sysUser.getDepartId());
        expensesDTO.setDepartment(departmentDTO.getDeptName());
        expensesDTO.setRemark("收款单位：" + bizPayPlan.getApplyCollectionCompany());
        expensesDTO.setDataDate(DateUtils.getDate());
        ResultBean resultBean = expensesService.save(expensesDTO);
        if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, resultBean.getCode())) {
            throw new BaseException(resultBean.getMessage());
        }
        return ResultBean.success(update);
    }

    private BizOtherBillAddDTO buildBizOtherBillAddDTO(BizPayPlan bizPayPlan, BizPayPlanPayDTO.PayWayDTO payWayDTO, BookingTypeEnum bookingTypeEnum) {
        BizOtherBillAddDTO otherBillAddDTO = new BizOtherBillAddDTO();
        // 付款
        otherBillAddDTO.setType("2");
        otherBillAddDTO.setCompany(bizPayPlan.getPayCompany());
        otherBillAddDTO.setAccount(bizPayPlan.getPayAccount());
        otherBillAddDTO.setCertificateNumber(bizPayPlan.getApplyNo());
        otherBillAddDTO.setOperateDate(bizPayPlan.getPayDate());
        otherBillAddDTO.setPayWay(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        otherBillAddDTO.setPaymentType(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        otherBillAddDTO.setPayment(payWayDTO.getAmount());
        otherBillAddDTO.setDeptId(bizPayPlan.getDeptId());
        otherBillAddDTO.setRemark("付款计划："+bizPayPlan.getRemark()+"  付款："+payWayDTO.getAmount());
        otherBillAddDTO.setPayCompany(bizPayPlan.getPayCompany());
        otherBillAddDTO.setPayAccount(bizPayPlan.getPayAccount());
        otherBillAddDTO.setCollectCompany(bizPayPlan.getApplyCollectionCompany());
        return otherBillAddDTO;
    }

    private BizBankBillAddDTO buildBizBankBillAddDTO(BizPayPlan bizPayPlan, BizPayPlanPayDTO.PayWayDTO payWayDTO, BookingTypeEnum bookingTypeEnum) {
        BizBankBillAddDTO bizBankBill = new BizBankBillAddDTO();
        // 付款
        bizBankBill.setType("2");
        bizBankBill.setCompany(bizPayPlan.getPayCompany());
        bizBankBill.setAccount(bizPayPlan.getPayAccount());
        bizBankBill.setCertificateNumber(bizPayPlan.getApplyNo());
        bizBankBill.setOperateDate(bizPayPlan.getPayDate());
        bizBankBill.setPayWay(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        bizBankBill.setPaymentType(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        bizBankBill.setPayment(payWayDTO.getAmount());
        bizBankBill.setDeptId(bizPayPlan.getDeptId());
        bizBankBill.setRemark("付款计划："+bizPayPlan.getRemark()+"  付款："+payWayDTO.getAmount());
        bizBankBill.setPayCompany(bizPayPlan.getPayCompany());
        bizBankBill.setPayAccount(bizPayPlan.getPayAccount());
        bizBankBill.setCollectCompany(bizPayPlan.getApplyCollectionCompany());
        return bizBankBill;
    }

    private BizBillAddDTO buildBizBillAddDTO(BizPayPlan bizPayPlan, BizPayPlanPayDTO.PayWayDTO payWayDTO, BookingTypeEnum bookingTypeEnum) {
        BizBillAddDTO bizBill = new BizBillAddDTO();
        bizBill.setType(bookingTypeEnum.getCode());
        bizBill.setCertificateNumber(bizPayPlan.getApplyNo());
        bizBill.setD(bizPayPlan.getPayDate());
        // todo
        bizBill.setPaymentType(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        bizBill.setPayment(payWayDTO.getAmount());
        bizBill.setDeptId(bizPayPlan.getDeptId()+"");
        bizBill.setRemark("付款计划："+bizPayPlan.getRemark()+"  付款："+payWayDTO.getAmount());
        bizBill.setString1(bizPayPlan.getApplyCollectionCompany());
        bizBill.setString2(bizPayPlan.getPayCompany());
        return bizBill;
    }

    private BizPayPlan buildBizPayPlan(BizPayPlanPayDTO planPayDTO, CustomUser customUser) {
        // 1 更新付款计划状态
        BizPayPlan record = new BizPayPlan();
        BeanUtils.copyProperties(planPayDTO, record);

        record.setStatus("2");
        //  添加付款方式日志表
        record.setPayWay(JSON.toJSONString(planPayDTO.getPayWayList()));

        String bookingType = planPayDTO.getPayWayList().stream()
            .map(BizPayPlanPayDTO.PayWayDTO::getBookingType)
            .distinct()
            .collect(Collectors.joining(","));
        record.setBookingType(bookingType);
        record.setUpdateTime(new Date());
        record.setUpdateUser(customUser.getId());
        return record;
    }

    private BizPayPlanPayLog buildBizPayPlanPayLog(CustomUser customUser, BizPayPlan bizPayPlan, PurchaseOrder purchaseOrder, BizPayPlanPayDTO.PayWayDTO payWayDTO) {
        BizPayPlanPayLog payPlanPayLog = new BizPayPlanPayLog();
        payPlanPayLog.setPayPlanId((long) bizPayPlan.getId());
        payPlanPayLog.setPayWay(payWayDTO.getCode());
        payPlanPayLog.setApplyAmount(payWayDTO.getAmount());
        payPlanPayLog.setBookingType(payWayDTO.getBookingType());
        payPlanPayLog.setContractId(purchaseOrder.getId().toString());
        payPlanPayLog.setContractNo(purchaseOrder.getPurchaseOrderNo());
        payPlanPayLog.setCreateTime(new Date());
        payPlanPayLog.setCreateUser(customUser.getId());
        return payPlanPayLog;
    }

    @Override
    public ResultBean getInfo(Integer id) {
        BizPayPlan billBank = bizPayPlanMapper.selectByPrimaryKey(id);
        return ResultBean.success(billBank);
    }

    @Override
    public ResultBean getList(BizPayPlanRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }

        // 查询当前用户的角色

        CustomUser customUser = sysUserService.selectLoginUser();

        List<CustomGrantedAuthority> customGrantedAuthorityList = customUser.getAuthorities().stream()
            .map(a -> (CustomGrantedAuthority) a)
            .collect(Collectors.toList());

        //当前角色是否为出纳
        boolean iscn = customGrantedAuthorityList.stream()
            .anyMatch(grantedAuthority -> StringUtils.equalsIgnoreCase(grantedAuthority.getRole(), RoleEnum.ROLE_CN.getCode()));
        //当前角色是否主管会计
        boolean iszjkj = customGrantedAuthorityList.stream()
            .anyMatch(grantedAuthority -> StringUtils.equalsIgnoreCase(grantedAuthority.getRole(), RoleEnum.ROLE_ZGKJ.getCode()));

        // 构造查询条件
        BizPayPlanExample bizPayPlanExample = this.buildBizPayPlanExample(model);
        Page<BizPayPlan> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizPayPlanMapper.selectByExample(bizPayPlanExample);
            });

        Map<Long, List<BizPayPlanPayLog>> bizPayPlanPayLogListMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(pageData.getResult())) {
            List<Long> idList = pageData.getResult().stream().map(bizPayPlan -> (long) bizPayPlan.getId()).collect(Collectors.toList());
            BizPayPlanPayLogExample bizPayPlanPayLogExample = new BizPayPlanPayLogExample();
            BizPayPlanPayLogExample.Criteria planPayLogExampleCriteria = bizPayPlanPayLogExample.createCriteria();
            planPayLogExampleCriteria.andPayPlanIdIn(idList);
            List<BizPayPlanPayLog> bizPayPlanPayLogs = bizPayPlanPayLogMapper.selectByExample(bizPayPlanPayLogExample);
            bizPayPlanPayLogListMap = bizPayPlanPayLogs.stream().collect(Collectors.groupingBy(BizPayPlanPayLog::getPayPlanId));
        }


        PageDTO<BizPayPlanRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);

        Map<Long, List<BizPayPlanPayLog>> finalBizPayPlanPayLogListMap = bizPayPlanPayLogListMap;
        List<BizPayPlanRSDTO> payApplyRSDTOList = pageData.getResult().stream()
            .map(bizPayApply -> {
                BizPayPlanRSDTO payApply = new BizPayPlanRSDTO();
                BeanUtils.copyProperties(bizPayApply, payApply);

                List<BizPayPlanPayLogDTO> bizPayPlanPayLogDTOS = this.convertBizPayPlanPayLogDTOList(finalBizPayPlanPayLogListMap, payApply);
                payApply.setPayWayList(bizPayPlanPayLogDTOS);

                List<String> asList = this.convertBoolingTypeList(payApply);
                payApply.setBookingTypeList(asList);

                // 角色 == 出纳 && 支付状态 == 0（未付款）&& 确认状态 == 1（出纳付款）
                boolean canPay = iscn
                    && StringUtils.equalsIgnoreCase(bizPayApply.getStatus(), PayPlanPayStatusEnum.un_pay.getCode())
                    && StringUtils.equalsIgnoreCase(bizPayApply.getDataStatus(), PayPlanConfirmStatusEnum.CN_CONFIRM.getCode());

                // 角色 == 会计主管 && 审核状态 == 3（付款中）&& 确认状态 == 0（待主管会计确认）
                boolean canConfirm = iszjkj
                    && StringUtils.equalsIgnoreCase(bizPayApply.getDataStatus(), PayPlanConfirmStatusEnum.ZGKJ_CONFIRM.getCode())
                    && StringUtils.equalsIgnoreCase(bizPayApply.getApplyStatus(), PayApplyPayStatusEnum.IN_PAYMENT.getCode());
                payApply.setIsCN(canPay);
                payApply.setCanConfirm(canConfirm);
                BizPayPlanRSDTO.Permission permission = new BizPayPlanRSDTO.Permission();
                permission.setCanPay(canPay);
                permission.setCanConfirm(canConfirm);
                payApply.setPermission(permission);
                return payApply;
            })
            .collect(Collectors.toList());

        pageDTO.setList(payApplyRSDTOList);
        return ResultBean.success(pageDTO);
    }

    private List<String> convertBoolingTypeList(BizPayPlanRSDTO payApply) {
        List<String> asList = new ArrayList<>();
        if (StringUtils.isNotEmpty(payApply.getBookingType())) {
            asList = Arrays.asList(payApply.getBookingType().split(",").clone()).stream()
                .map(o -> BookingTypeEnum.valueOfCode(o).getDesc())
                .collect(Collectors.toList());
        }
        return asList;
    }

    private List<BizPayPlanPayLogDTO> convertBizPayPlanPayLogDTOList(Map<Long, List<BizPayPlanPayLog>> finalBizPayPlanPayLogListMap, BizPayPlanRSDTO payApply) {
        List<BizPayPlanPayLog> payPlanPayLogList = finalBizPayPlanPayLogListMap.get((long) payApply.getId());

        List<BizPayPlanPayLogDTO> bizPayPlanPayLogDTOS = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(payPlanPayLogList)) {
            bizPayPlanPayLogDTOS = payPlanPayLogList.stream()
                .map(bizPayPlanPayLog -> {
                    BizPayPlanPayLogDTO payPlanPayLogDTO = new BizPayPlanPayLogDTO();
                    BeanUtils.copyProperties(bizPayPlanPayLog, payPlanPayLogDTO);
                    payPlanPayLogDTO.setPayWay(PayWayEnum.valueOfCode(payPlanPayLogDTO.getPayWay()).getDesc());
                    payPlanPayLogDTO.setBookingType(BookingTypeEnum.valueOfCode(payPlanPayLogDTO.getBookingType()).getDesc());
                    return payPlanPayLogDTO;
                })
                .collect(Collectors.toList());
        }
        return bizPayPlanPayLogDTOS;
    }

    private BizPayPlanExample buildBizPayPlanExample(BizPayPlanRQDTO model) {
        BizPayPlanExample bizPayPlanExample = new BizPayPlanExample();
        BizPayPlanExample.Criteria criteria = bizPayPlanExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);


        // 申请编号 ==
        if (StringUtils.isNotEmpty(model.getApplyNo())) {
            criteria.andApplyNoEqualTo(model.getApplyNo());
        }
        //开始时间
        //结束时间
        if (model.getApplyDateStart() != null && model.getApplyDateEnd() != null) {
            // 区间
            criteria.andApplyDateBetween(model.getApplyDateStart(), model.getApplyDateEnd());
        } else if (model.getApplyDateStart() != null) {
            // 大于
            criteria.andApplyDateGreaterThanOrEqualTo(model.getApplyDateStart());
        } else if (model.getApplyDateEnd() != null) {
            // 小于
            criteria.andApplyDateLessThanOrEqualTo(model.getApplyDateEnd());
        }
        //采购合同号
        if (StringUtils.isNotEmpty(model.getContractNo())) {
            criteria.andContractNoEqualTo(model.getContractNo());
        }

        //收款单位：like
        if (StringUtils.isNotEmpty(model.getApplyCollectionCompany())) {
            criteria.andApplyCollectionCompanyLike(model.getApplyCollectionCompany());
        }
        //付款单位：like
        if (StringUtils.isNotEmpty(model.getPaymentType())) {
            criteria.andPaymentTypeEqualTo(model.getPaymentType());
        }

        // 付款类型 ==
        if (StringUtils.isNotEmpty(model.getPaymentType())) {
            criteria.andPaymentTypeEqualTo(model.getPaymentType());
        }


        //付款状态
        if (StringUtils.isNotEmpty(model.getStatus())) {
            criteria.andStatusEqualTo(model.getStatus());
        }
        //数据状态 2 审核中  3 出纳付款
        if (StringUtils.isNotEmpty(model.getDataStatus())) {
            criteria.andDataStatusEqualTo(model.getDataStatus());
        }
        criteria.andApplyStatusIn(Arrays.asList("3", "5"));

        bizPayPlanExample.setOrderByClause("id desc");
        return bizPayPlanExample;
    }

    @Override
    public ResultBean<PageDTO<BizPayPlanSummaryRSDTO>> getPayPlanSummaryList(BizPayPlanSummaryRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        Page<BizPayPlanSummaryRSDTO> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizPayPlanMapper.selectListGroupBy(model);
            });
        PageDTO<BizPayPlanSummaryRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean<List<BookingTypeRSDTO>> getAllPayWayList() {

        Map<BookingTypeEnum, List<PayWayEnum>> typeEnumPayWayEnumMap = Arrays.stream(PayWayEnum.values())
            .collect(Collectors.groupingBy(PayWayEnum::getBookingTypeEnum));

        List<BookingTypeRSDTO> bookingTypeRSDTOList = typeEnumPayWayEnumMap.entrySet().stream()
            .map(entry -> {
                BookingTypeEnum bookingTypeEnum = entry.getKey();

                BookingTypeRSDTO bookingTypeRSDTO = new BookingTypeRSDTO();
                bookingTypeRSDTO.setCode(bookingTypeEnum.getCode());
                bookingTypeRSDTO.setDesc(bookingTypeEnum.getDesc());

                List<BookingTypeRSDTO.PayWay> payWayList = entry.getValue().stream()
                    .map(payWayEnum -> {
                        BookingTypeRSDTO.PayWay payWay = new BookingTypeRSDTO.PayWay();
                        payWay.setCode(payWayEnum.getCode());
                        payWay.setDesc(payWayEnum.getDesc());
                        return payWay;
                    })
                    .collect(Collectors.toList());
                bookingTypeRSDTO.setWayList(payWayList);

                return bookingTypeRSDTO;
            })
            .collect(Collectors.toList());

        return ResultBean.success(bookingTypeRSDTOList);
    }

    @Override
    public ResultBean updateDateStatus(List<Integer> ids) {
        BizPayPlanExample bizPayPlanExample = new BizPayPlanExample();
        BizPayPlanExample.Criteria criteria = bizPayPlanExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
        criteria.andIdIn(ids);
        List<BizPayPlan> bizPayPlans = bizPayPlanMapper.selectByExample(bizPayPlanExample);
        Set<String> dataStatusSet = bizPayPlans.stream().map(BizPayPlan::getDataStatus).collect(Collectors.toSet());
        if (dataStatusSet.size() > 1) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "不同数据状态的数据不能同时确认");
        }
        String next = dataStatusSet.iterator().next();
        if (StringUtils.isEmpty(next)) {
            next = "1";
        }
        int nextInt = Integer.parseInt(next);
        if (nextInt >= 1) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "此状态不能确认");
        }
        String dataStatus = String.valueOf(nextInt + 1);

        BizPayPlan payPlan = new BizPayPlan();
        payPlan.setDataStatus(dataStatus);

        Integer c = bizPayPlanMapper.updateByExampleSelective(payPlan, bizPayPlanExample);
        return ResultBean.success(c);
    }


}
