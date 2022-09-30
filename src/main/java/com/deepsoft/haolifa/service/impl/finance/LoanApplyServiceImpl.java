package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.enums.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.FlowInstanceDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.*;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanPayDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetQueryBO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetUpDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.ReimburseApplyAddDTO;
import com.deepsoft.haolifa.service.FlowInstanceService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.*;
import com.deepsoft.haolifa.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.deepsoft.haolifa.constant.CommonEnum.FlowId.LOAN_APP_FLOW;
import static com.deepsoft.haolifa.constant.CommonEnum.FormType.LOAN_APP_TYPE;

@Service
@Slf4j
public class LoanApplyServiceImpl implements LoanApplyService {

    @Autowired
    private BizLoanApplyMapper bizLoanApplyMapper;
    @Autowired
    private SysUserService sysUserService;
    @Lazy
    @Autowired
    private FlowInstanceService flowInstanceService;

    @Autowired
    private SysDepartmentMapper departmentMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private BillService billService;
    @Autowired
    private BankBillService bankBillService;
    @Autowired
    private OtherBillService otherBillService;

    @Autowired
    private PayUserMapper payUserMapper;

    @Autowired
    private ProjectBudgetService projectBudgetService;



    @Resource
    private BizProjectBudgetMapper bizProjectBudgetMapper;

    @Override
    public ResultBean save(LoanApplyAddDTO model) {
//        log.info("BankBillService saveInfo start|{}", JSONObject.toJSON(model));
        ResultBean<Object> PARAM_ERROR = validate(model);
        if (PARAM_ERROR != null) {
            return PARAM_ERROR;
        }
        CustomUser customUser = sysUserService.selectLoginUser();
        SysUser sysUser = sysUserService.getSysUser(customUser.getId());
        PayUser payUser = payUserMapper.selectByPhoneOrIdCard(sysUser.getPhone(),sysUser.getIdCard());

        ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
        queryBO.setCode(model.getProjectCode());
        queryBO.setDeptId(sysUser.getDepartId());
        queryBO.setYear(DateUtils.getSysYear());
        queryBO.setMonth(DateUtil.format(new Date(),"MM"));
        // 校验当月项目预算
        BizProjectBudget bizProjectBudget =   projectBudgetService.queryCurMonthBudget(queryBO);
        //  当月未维护
        if (ObjectUtil.isNull(bizProjectBudget) ){
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "当月项目预算未维护");
        }
        // 金额不足
        if (bizProjectBudget.getBalanceQuota().compareTo(model.getAmount())<0){
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "当月项目预算金额不足");
        }


        BizLoanApply loanApply = new BizLoanApply();
        BeanUtils.copyProperties(model, loanApply);
        loanApply.setSerialNo("BP" + DateUtils.dateTimeNow() + RandomStringUtils.randomNumeric(3));
        loanApply.setApplyStatus(LoanApplyStatusEnum.PENDING_APPROVAL.getCode());
        loanApply.setPayStatus(LoanrPayStatusEnum.un_pay.getCode());
        loanApply.setPaymentStatus(LoanrPaymentStatusEnum.partial_pay.getCode());
        loanApply.setPaymentAmount(BigDecimal.ZERO);
        loanApply.setLoanUser(sysUserService.selectLoginUser().getId());
//        loanApply.setLoanUserNo(payUser.getUserNo());
        loanApply.setCreateTime(new Date());
        loanApply.setUpdateTime(new Date());
        loanApply.setCreateUser(sysUserService.selectLoginUser().getId());
        loanApply.setUpdateUser(sysUserService.selectLoginUser().getId());

        int insertId = bizLoanApplyMapper.insertSelective(loanApply);
        return ResultBean.success(insertId);
    }


    @Override
    public ResultBean delete(Integer id) {

        BizLoanApply selectByPrimaryKey = bizLoanApplyMapper.selectByPrimaryKey(id);
        // 有些状态不能删除
        LoanApplyStatusEnum statusEnum = LoanApplyStatusEnum.valueOfCode(selectByPrimaryKey.getApplyStatus());
        if (!LoanApplyStatusEnum.PENDING_APPROVAL.getCode().equalsIgnoreCase(statusEnum.getCode())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, statusEnum.getDesc() + "状态不允许删除");
        }
        int delete = bizLoanApplyMapper.deleteByPrimaryKey(id);
//        BizLoanApply billBank = new BizLoanApply();
//        billBank.setId(id);
//        billBank.setDelFlag("1");
//        billBank.setUpdateTime(new Date());
//        billBank.setUpdateUser(sysUserService.selectLoginUser().getId());
//        int update = bizLoanApplyMapper.updateByPrimaryKeySelective(billBank);



        if (StringUtils.isNotEmpty(selectByPrimaryKey.getProjectCode())){
            ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
            queryBO.setCode(selectByPrimaryKey.getProjectCode());
            queryBO.setDeptId(selectByPrimaryKey.getDeptId());
            queryBO.setYear(DateUtil.format(selectByPrimaryKey.getCreateTime(),"yyyy"));
            queryBO.setMonth(DateUtil.format(selectByPrimaryKey.getCreateTime(),"MM"));
            // 校验当月项目预算
            BizProjectBudget bizProjectBudget =   projectBudgetService.queryCurMonthBudget(queryBO);

            // 回退
            ProjectBudgetUpDTO budgetUpDTO = new ProjectBudgetUpDTO();
            budgetUpDTO.setId(bizProjectBudget.getId());
            budgetUpDTO.setBalanceQuota(bizProjectBudget.getBalanceQuota().add(selectByPrimaryKey.getAmount()));
            projectBudgetService.update(budgetUpDTO);
        }

        return ResultBean.success(delete);
    }

    @Override
    public ResultBean update(LoanApplyUpDTO loanApplyUpDTO) {
        BizLoanApply selectByPrimaryKey = bizLoanApplyMapper.selectByPrimaryKey(loanApplyUpDTO.getId());

        // 有些状态不能删除
        LoanApplyStatusEnum statusEnum = LoanApplyStatusEnum.valueOfCode(selectByPrimaryKey.getApplyStatus());
        if (!LoanApplyStatusEnum.PENDING_APPROVAL.getCode().equalsIgnoreCase(statusEnum.getCode())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, statusEnum.getDesc() + "状态不允许修改");
        }

        BizLoanApply loanApply = new BizLoanApply();
        BeanUtils.copyProperties(loanApplyUpDTO, loanApply);
        loanApply.setUpdateTime(new Date());
        loanApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizLoanApplyMapper.updateByPrimaryKeySelective(loanApply);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean<LoanApplyInfoRSDTO> getInfo(Integer id) {
        BizLoanApply loanApply = bizLoanApplyMapper.selectByPrimaryKey(id);

        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));

        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andIdEqualTo(loanApply.getLoanUser());
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        Map<Integer, SysUser> finalSysUserMap = sysUsers.stream().collect(Collectors.toMap(SysUser::getId, Function.identity()));


        LoanApplyInfoRSDTO loanApplyRSDTO = new LoanApplyInfoRSDTO();
        BeanUtils.copyProperties(loanApply, loanApplyRSDTO);
        SysDepartment sysDepartment = sysDepartmentMap.get(loanApply.getDeptId());
        if (sysDepartment != null) {
            loanApplyRSDTO.setDeptName(sysDepartment.getDeptName());
        }
        SysUser sysUser = finalSysUserMap.get(loanApply.getLoanUser());
        if (sysUser != null) {
            loanApplyRSDTO.setLoanUserName(sysUser.getRealName());
        }

        // 支付类型 1 对公 2 对私
        String payTypeCN = "未知";
        if (StringUtils.equalsIgnoreCase(loanApply.getPayType(), "1")) {
            payTypeCN = "对公";
        } else if (StringUtils.equalsIgnoreCase(loanApply.getPayType(), "2")) {
            payTypeCN = "对私";
        }
        loanApplyRSDTO.setPayTypeCN(payTypeCN);

        // 是否差旅借款 1 是 2 否
        String travelFlagCN = "未知";
        if (StringUtils.equalsIgnoreCase(loanApply.getPayType(), "1")) {
            travelFlagCN = "是";
        } else if (StringUtils.equalsIgnoreCase(loanApply.getPayType(), "2")) {
            travelFlagCN = "否";
        }
        loanApplyRSDTO.setTravelFlagCN(travelFlagCN);

        LoanApplyStatusEnum applyStatusEnum = LoanApplyStatusEnum.valueOfCode(loanApply.getApplyStatus());

        loanApplyRSDTO.setApplyStatusCN(applyStatusEnum == null ?
            LoanApplyStatusEnum.PENDING_APPROVAL.getDesc() : applyStatusEnum.getDesc());
        LoanPayWayEnum payWayEnum = LoanPayWayEnum.valueOfCode(loanApply.getAmountType());
        loanApplyRSDTO.setAmountTypeCN(payWayEnum == null ? null : payWayEnum.getDesc());

        LoanBillTypeEnum billTypeEnum = LoanBillTypeEnum.valueOfCode(loanApply.getBillNature());
        loanApplyRSDTO.setBillNatureCN(billTypeEnum == null ? null : billTypeEnum.getDesc());

        LoanrPayStatusEnum payStatusEnum = LoanrPayStatusEnum.valueOfCode(loanApply.getPayStatus());
        loanApplyRSDTO.setPayStatusCN(payStatusEnum == null ? LoanrPayStatusEnum.un_pay.getDesc() : payStatusEnum.getDesc());

        if(StringUtils.isNotEmpty(loanApplyRSDTO.getProjectCode())){
            BizProjectBudget projectBudget =  bizProjectBudgetMapper.getProjectBudgetByCode(loanApplyRSDTO.getProjectCode());
            loanApplyRSDTO.setProjectCodeName(projectBudget.getName());
        }

        return ResultBean.success(loanApplyRSDTO);
    }

    @Override
    public ResultBean<PageDTO<LoanApplyRSDTO>> getList(LoanApplyRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizLoanApplyExample loanApplyExample = new BizLoanApplyExample();
        BizLoanApplyExample.Criteria criteria = loanApplyExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        String type = model.getType();

        // 查询当前用户的角色
        CustomUser customUser = sysUserService.selectLoginUser();
        List<CustomGrantedAuthority> customGrantedAuthorityList = customUser.getAuthorities().stream()
            .map(a -> (CustomGrantedAuthority) a)
            .collect(Collectors.toList());

        //当前角色是否为出纳
        boolean lookAll = customGrantedAuthorityList.stream()
            .anyMatch(grantedAuthority -> {
                return StringUtils.equalsIgnoreCase(grantedAuthority.getRole(), RoleEnum.ROLE_ADMIN.getCode()) ||
                    StringUtils.equalsIgnoreCase(grantedAuthority.getRole(), RoleEnum.ROLE_ZJL.getCode()) ||
                    StringUtils.equalsIgnoreCase(grantedAuthority.getRole(), RoleEnum.ROLE_ZGKJ.getCode()) ||
                    StringUtils.equalsIgnoreCase(grantedAuthority.getRole(), RoleEnum.ROLE_CWGLZXFZR.getCode()) ||
                    StringUtils.equalsIgnoreCase(grantedAuthority.getRole(), RoleEnum.ROLE_CN.getCode());
            });

        // 借款审批列表 todo 是否只展示自己申请的记录
        if (StringUtils.equalsIgnoreCase("1", type) && !lookAll) {
            //审核状态
            if (StringUtils.isNotEmpty(model.getApplyStatus())) {
                criteria.andApplyStatusIn(Arrays.asList(model.getApplyStatus().split(",").clone()));
            }
            criteria.andCreateUserEqualTo(sysUserService.selectLoginUser().getId());
            // 出纳付款列表
        } else if (StringUtils.equalsIgnoreCase("2", type)) {
            //审核状态
            if (StringUtils.isNotEmpty(model.getApplyStatus())) {
                criteria.andApplyStatusIn(Arrays.asList(model.getApplyStatus().split(",").clone()));
            } else {
                // 2 审批中 3 付款中 4 审批不通过 5 付款完成
                criteria.andApplyStatusIn(Arrays.asList("3", "5"));
            }
        }


        // 状态 1 代办 2 已办
        if (model.getStatus() != null) {
//            criteria.andCertificateNumberEqualTo(model.getCertificateNumber());
        }
        //借款部门名称
        if (StringUtils.isNotEmpty(model.getDeptName())) {
//            criteria.andPayAccountEqualTo(model.getPayAccount());
        }
        //借款人名称
        if (StringUtils.isNotEmpty(model.getLoanUserName())) {
//            criteria.andTypeEqualTo(model.getType());
        }

        //付款单位
        if (StringUtils.isNotEmpty(model.getPayCompany())) {
            criteria.andPayCompanyLike(model.getPayCompany());
        }
        //付款状态（1未付款 2付款中 3付款完成
        if (StringUtils.isNotEmpty(model.getPayStatus())) {
            criteria.andPayStatusEqualTo(model.getPayStatus());
        }


        loanApplyExample.setOrderByClause("id desc");
        Page<BizLoanApply> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizLoanApplyMapper.selectByExample(loanApplyExample);
            });
        PageDTO<LoanApplyRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);


        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));

        Map<Integer, SysUser> sysUserMap = new HashMap<>();
        List<Integer> loadUserIdList = pageData.getResult().stream().map(BizLoanApply::getLoanUser).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(loadUserIdList)) {
            SysUserExample sysUserExample = new SysUserExample();
            sysUserExample.createCriteria().andIdIn(loadUserIdList);
            List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
            sysUserMap = sysUsers.stream().collect(Collectors.toMap(SysUser::getId, Function.identity()));
        }

        //当前角色是否为出纳
        boolean iscn = customGrantedAuthorityList.stream()
            .anyMatch(grantedAuthority -> StringUtils.equalsIgnoreCase(grantedAuthority.getRole(), RoleEnum.ROLE_CN.getCode()));

        Map<Integer, SysUser> finalSysUserMap = sysUserMap;
        List<LoanApplyRSDTO> loanApplyRSDTOList = pageData.getResult().stream()
            .map(loanApply -> {
                LoanApplyRSDTO loanApplyRSDTO = convertLoanApplyRSDTO(sysDepartmentMap, iscn, finalSysUserMap, loanApply);
                return loanApplyRSDTO;
            })
            .collect(Collectors.toList());
        pageDTO.setList(loanApplyRSDTOList);
        return ResultBean.success(pageDTO);
    }


    @Override
    public ResultBean<List<LoanApplyRSDTO>> getLoanApplyList(LoanApplyRQDTO model) {
        BizLoanApplyExample loanApplyExample = buildBizLoanApplyExample(model);
        List<BizLoanApply> bizLoanApplyList = bizLoanApplyMapper.selectByExample(loanApplyExample);


        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));

        Map<Integer, SysUser> sysUserMap = new HashMap<>();
        List<Integer> loadUserIdList = bizLoanApplyList.stream().map(BizLoanApply::getLoanUser).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(loadUserIdList)) {
            SysUserExample sysUserExample = new SysUserExample();
            sysUserExample.createCriteria().andIdIn(loadUserIdList);
            List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
            sysUserMap = sysUsers.stream().collect(Collectors.toMap(SysUser::getId, Function.identity()));
        }

        // 查询当前用户的角色

        CustomUser customUser = sysUserService.selectLoginUser();

        List<CustomGrantedAuthority> customGrantedAuthorityList = customUser.getAuthorities().stream()
            .map(a -> (CustomGrantedAuthority) a)
            .collect(Collectors.toList());

        //当前角色是否为出纳
        boolean iscn = customGrantedAuthorityList.stream()
            .anyMatch(grantedAuthority -> StringUtils.equalsIgnoreCase(grantedAuthority.getRole(), RoleEnum.ROLE_CN.getCode()));

        Map<Integer, SysUser> finalSysUserMap = sysUserMap;
        List<LoanApplyRSDTO> loanApplyRSDTOList = bizLoanApplyList.stream()
            .map(loanApply -> {
                LoanApplyRSDTO loanApplyRSDTO = convertLoanApplyRSDTO(sysDepartmentMap, iscn, finalSysUserMap, loanApply);
                return loanApplyRSDTO;
            })
            .filter(dto -> dto.getOwedAmount().compareTo(BigDecimal.ZERO) > 0)
            .collect(Collectors.toList());

        return ResultBean.success(loanApplyRSDTOList);
    }

    private LoanApplyRSDTO convertLoanApplyRSDTO(Map<Integer, SysDepartment> sysDepartmentMap, boolean iscn, Map<Integer, SysUser> finalSysUserMap, BizLoanApply loanApply) {
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


//        loanApplyRSDTO.setProjectCode();
        return loanApplyRSDTO;
    }

    private BizLoanApplyExample buildBizLoanApplyExample(LoanApplyRQDTO model) {
        BizLoanApplyExample loanApplyExample = new BizLoanApplyExample();
        BizLoanApplyExample.Criteria criteria = loanApplyExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        criteria.andCreateUserEqualTo(sysUserService.selectLoginUser().getId());
        //付款状态（1未付款 2付款中 3付款完成
        criteria.andPayStatusEqualTo(model.getPayStatus());

        loanApplyExample.setOrderByClause("id desc");
        return loanApplyExample;
    }


    @Override
    public int auditReplaceMaterial(String item_id, LoanApplyStatusEnum auditResult) {
        BizLoanApplyExample loanApplyExample = new BizLoanApplyExample();
        BizLoanApplyExample.Criteria criteria = loanApplyExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
        criteria.andSerialNoEqualTo(item_id);
        List<BizLoanApply> bizLoanApplies = bizLoanApplyMapper.selectByExample(loanApplyExample);

        BizLoanApply loanApplyS = bizLoanApplies.get(0);
        if (loanApplyS == null) {
//            log.error("auditReplaceMaterial 无该条记录,id:{}", item_id);
            return 0;
        }

        BizLoanApply loanApply = new BizLoanApply();
        loanApply.setId(loanApplyS.getId());
        loanApply.setApplyStatus(auditResult.getCode());
        loanApply.setUpdateTime(new Date());
        loanApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizLoanApplyMapper.updateByPrimaryKeySelective(loanApply);

        // 审核拒绝 回退金额
        if (ReimburseApplyStatusEnum.APPROVAL_FAILED.getCode().equalsIgnoreCase(auditResult.getCode())){
            if (StringUtils.isNotEmpty(loanApplyS.getProjectCode())){
                ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
                queryBO.setCode(loanApplyS.getProjectCode());
                queryBO.setDeptId(loanApplyS.getDeptId());
                queryBO.setYear(DateUtil.format(loanApplyS.getCreateTime(),"yyyy"));
                queryBO.setMonth(DateUtil.format(loanApplyS.getCreateTime(),"MM"));
                // 校验当月项目预算
                BizProjectBudget bizProjectBudget =   projectBudgetService.queryCurMonthBudget(queryBO);

                // 回退
                ProjectBudgetUpDTO budgetUpDTO = new ProjectBudgetUpDTO();
                budgetUpDTO.setId(bizProjectBudget.getId());
                budgetUpDTO.setBalanceQuota(bizProjectBudget.getBalanceQuota().add(loanApplyS.getAmount()));
                projectBudgetService.update(budgetUpDTO);
            }
        }

        return update;
    }


    @Override
    public ResultBean approve(Integer id) {

        BizLoanApply selectByPrimaryKey = bizLoanApplyMapper.selectByPrimaryKey(id);

        BizLoanApply loanApply = new BizLoanApply();
        loanApply.setId(id);
        loanApply.setApplyStatus(LoanApplyStatusEnum.UNDER_APPROVAL.getCode());
        loanApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        loanApply.setUpdateTime(new Date());

        bizLoanApplyMapper.updateByPrimaryKeySelective(loanApply);


        ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
        queryBO.setCode(selectByPrimaryKey.getProjectCode());
        queryBO.setDeptId(selectByPrimaryKey.getDeptId());
        queryBO.setYear(DateUtil.format(selectByPrimaryKey.getCreateTime(),"yyyy"));
        queryBO.setMonth(DateUtil.format(selectByPrimaryKey.getCreateTime(),"MM"));
        // 校验当月项目预算
        BizProjectBudget bizProjectBudget =   projectBudgetService.queryCurMonthBudget(queryBO);
        // 金额不足
        if (bizProjectBudget.getBalanceQuota().compareTo(selectByPrimaryKey.getAmount())<0){
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "当月项目预算金额不足");
        }
        // 扣减预算 todo 扣减日志
        ProjectBudgetUpDTO budgetUpDTO = new ProjectBudgetUpDTO();
        budgetUpDTO.setId(bizProjectBudget.getId());
        budgetUpDTO.setBalanceQuota(bizProjectBudget.getBalanceQuota().subtract(selectByPrimaryKey.getAmount()));
        projectBudgetService.update(budgetUpDTO);



        BizLoanApply bizLoanApply = bizLoanApplyMapper.selectByPrimaryKey(id);
        // 添加申请流程
        FlowInstanceDTO flowInstanceDTO = buildFlowInstanceDTO(bizLoanApply);
        flowInstanceService.create(flowInstanceDTO);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean pay(LoanApplyPayDTO loanApplyPayDTO) {
        BizLoanApply selectByPrimaryKey = bizLoanApplyMapper.selectByPrimaryKey(loanApplyPayDTO.getId());

        // 有些状态不能付款
        LoanrPayStatusEnum statusEnum = LoanrPayStatusEnum.valueOfCode(selectByPrimaryKey.getPayStatus());
        if (LoanrPayStatusEnum.all_pay.getCode().equalsIgnoreCase(statusEnum.getCode())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, statusEnum.getDesc() + "该笔状态已付款");
        }


        SysUser sysUser = sysUserService.getSysUser(selectByPrimaryKey.getLoanUser());
        // todo 扣减日记账金额

        // 记账方式（1現金 2銀行 3 其他貨幣）
        if (StringUtils.equalsIgnoreCase("1", loanApplyPayDTO.getBillNature())) {
            BizBillAddDTO bizBill = buildBizBillAddDTO(loanApplyPayDTO, selectByPrimaryKey, sysUser);
            ResultBean save = billService.save(bizBill);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,save.getCode())){
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
            }

        } else if (StringUtils.equalsIgnoreCase("2", loanApplyPayDTO.getBillNature())) {
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
            ResultBean save = bankBillService.save(bizBankBill);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,save.getCode())){
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
            }
        } else if (StringUtils.equalsIgnoreCase("3", loanApplyPayDTO.getBillNature())) {
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
            ResultBean save = otherBillService.save(otherBillAddDTO);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,save.getCode())){
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
            }
        }


        BizLoanApply loanApply = new BizLoanApply();
        BeanUtils.copyProperties(loanApplyPayDTO, loanApply);
        loanApply.setPayStatus(LoanrPayStatusEnum.all_pay.getCode());
        loanApply.setPayTime(new Date());
        loanApply.setUpdateTime(new Date());
        loanApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizLoanApplyMapper.updateByPrimaryKeySelective(loanApply);
        return ResultBean.success(update);
    }

    private BizBillAddDTO buildBizBillAddDTO(LoanApplyPayDTO loanApplyPayDTO, BizLoanApply selectByPrimaryKey, SysUser sysUser) {
        BizBillAddDTO bizBill = new BizBillAddDTO();
        bizBill.setType(BookingTypeEnum.cash_bill.getCode());
        bizBill.setCertificateNumber(loanApplyPayDTO.getPayAccount());
        bizBill.setD(new Date());
        bizBill.setDeptId(selectByPrimaryKey.getDeptId()+"");
        bizBill.setPaymentType(PayWayEnum.cash_pay.getDesc());
        bizBill.setPayment(selectByPrimaryKey.getAmount());
        bizBill.setRemark("借款付款 " + selectByPrimaryKey.getAmount());
        bizBill.setString1(sysUser.getRealName());
        bizBill.setString2(loanApplyPayDTO.getPayCompany());
        return bizBill;
    }

    private FlowInstanceDTO buildFlowInstanceDTO(BizLoanApply loanApply) {
        FlowInstanceDTO flowInstanceDTO = new FlowInstanceDTO();
        flowInstanceDTO.setFlowId(LOAN_APP_FLOW.id);
        flowInstanceDTO.setSummary("借款申请审批");
        flowInstanceDTO.setFormType(LOAN_APP_TYPE.code);
        flowInstanceDTO.setFormNo(loanApply.getSerialNo());
        flowInstanceDTO.setFormId(loanApply.getId());
        return flowInstanceDTO;
    }


    @Autowired
    private BizPaymentHistoryMapper bizPaymentHistoryMapper;


    // 报销冲抵-还款
    @Override
    public ResultBean<Integer> repaymentAmount(Integer loanId, BigDecimal offsetAmount) {
        //
        BizLoanApply bizLoanApply = bizLoanApplyMapper.selectByPrimaryKey(loanId);
        BigDecimal paymentAmount = bizLoanApply.getPaymentAmount() == null ? BigDecimal.ZERO : bizLoanApply.getPaymentAmount();
        BigDecimal addAmount = offsetAmount.add(paymentAmount);
        if (addAmount.compareTo(bizLoanApply.getAmount()) > 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "总冲抵金额不能大于借款金额");
        }

        // 还款操作
        // 流水
        BizPaymentHistory paymentHistory = buildBizPaymentHistory(loanId, offsetAmount, bizLoanApply);
        bizPaymentHistoryMapper.insertSelective(paymentHistory);
        // 借款
        BizLoanApply bizLoanApplyUp = buildBizLoanApply(bizLoanApply, addAmount);
        bizLoanApplyMapper.updateByPrimaryKeySelective(bizLoanApplyUp);
        return ResultBean.success(1);
    }

    private BizLoanApply buildBizLoanApply(BizLoanApply bizLoanApply, BigDecimal addAmount) {
        BizLoanApply bizLoanApplyUp = new BizLoanApply();
        bizLoanApplyUp.setId(bizLoanApply.getId());
        bizLoanApplyUp.setPaymentAmount(addAmount);
        if (addAmount.compareTo(bizLoanApply.getAmount()) == 0) {
            bizLoanApplyUp.setPaymentStatus(LoanrPaymentStatusEnum.all_pay.getCode());
        } else {
            bizLoanApplyUp.setPaymentStatus(LoanrPaymentStatusEnum.partial_pay.getCode());
        }
        return bizLoanApplyUp;
    }

    private BizPaymentHistory buildBizPaymentHistory(Integer loanId, BigDecimal offsetAmount, BizLoanApply bizLoanApply) {
        BizPaymentHistory paymentHistory = new BizPaymentHistory();
        paymentHistory.setAmount(offsetAmount);
        paymentHistory.setLoanId(loanId);
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

    private ResultBean<Object> validate(LoanApplyAddDTO model) {
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
