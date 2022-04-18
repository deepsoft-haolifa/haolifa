package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Pair;
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
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyInfoRSDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.*;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost.ReimburseCostDetailAddDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost.ReimburseCostDetailRSDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.travel.ReimburseTravelDetailAddDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.travel.ReimburseTravelDetailRSDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceUpDTO;
import com.deepsoft.haolifa.service.FlowInstanceService;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.BankBillService;
import com.deepsoft.haolifa.service.finance.BillService;
import com.deepsoft.haolifa.service.finance.ReimburseApplyService;
import com.deepsoft.haolifa.service.finance.SubjectBalanceService;
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

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.deepsoft.haolifa.constant.CommonEnum.FlowId.REIMBURSE_APP_FLOW;
import static com.deepsoft.haolifa.constant.CommonEnum.FormType.REIMBURSE_APP_TYPE;

@Service
@Slf4j
public class ReimburseApplyServiceImpl implements ReimburseApplyService {

    @Autowired
    private BizLoanApplyMapper bizLoanApplyMapper;
    @Autowired
    private BizReimburseApplyMapper bizReimburseApplyMapper;
    @Autowired
    private SysUserService sysUserService;

    @Lazy
    @Autowired
    private FlowInstanceService flowInstanceService;
    @Autowired
    private BizReimburseTravelDetailMapper bizReimburseTravelDetailMapper;
    @Autowired
    private BizReimburseCostDetailMapper bizReimburseCostDetailMapper;
    @Autowired
    private SysDepartmentMapper departmentMapper;
    @Autowired
    private BizSubjectsMapper bizSubjectsMapper;

    @Autowired
    private BizCostBudgetSubjectsMapper bizCostBudgetSubjectsMapper;

    @Autowired
    private SysDictService sysDictService;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private BizPaymentHistoryMapper bizPaymentHistoryMapper;

    @Autowired
    private BillService billService;
    @Autowired
    private BankBillService bankBillService;
    @Autowired
    private SubjectBalanceService subjectBalanceService;

    //
    @Override
    public ResultBean save(ReimburseApplyAddDTO model) {
        log.info("BankBillService saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }

        CustomUser customUser = sysUserService.selectLoginUser();
        SysUser sysUser = sysUserService.getSysUser(customUser.getId());
        // 1 添加主数据

        // todo 如果使用了借款冲抵


        BizReimburseApply reimburseApply = new BizReimburseApply();
        BeanUtils.copyProperties(model, reimburseApply);
        String ser = "FP" + DateUtils.dateTimeNow() + RandomStringUtils.randomNumeric(3);
        reimburseApply.setSerialNo(ser);

        BigDecimal totalAmount = BigDecimal.ZERO;
        {
            ReimburseTypeEnum reimburseTypeEnum = ReimburseTypeEnum.valueOfCode(model.getType());
            switch (reimburseTypeEnum) {
                case travle: {
                    if (CollectionUtil.isNotEmpty(model.getReimburseTravelDetailAddDTOList())) {
                        totalAmount = model.getReimburseTravelDetailAddDTOList().stream()
                            .map(ReimburseTravelDetailAddDTO::getProjectAmount)
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
        }
        // 如果是借款冲抵
        if (StringUtils.equalsIgnoreCase("2", model.getReimburseType())) {
            //
            Integer loanId = model.getLoanId();
            BizLoanApply bizLoanApply = bizLoanApplyMapper.selectByPrimaryKey(loanId);

            // 已经还款金额
            BigDecimal paymentAmount = bizLoanApply.getPaymentAmount() == null ? BigDecimal.ZERO : bizLoanApply.getPaymentAmount();
            BigDecimal addAmount = model.getOffsetAmount().add(paymentAmount);

            if (addAmount.compareTo(bizLoanApply.getAmount()) > 0) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "总冲抵金额不能大于借款金额");
            }

            totalAmount = totalAmount.subtract(model.getOffsetAmount());
        }

        reimburseApply.setAmount(totalAmount);
        reimburseApply.setCreateTime(new Date());
        reimburseApply.setUpdateTime(new Date());
        //reimburseApply.setApplyStatus(ReimburseApplyStatusEnum.PENDING_APPROVAL.getCode());
        reimburseApply.setPayStatus(ReimbursePayStatusEnum.un_pay.getCode());
        reimburseApply.setDeptId(sysUser.getDepartId());
        reimburseApply.setReimburseUser(customUser.getId());
        reimburseApply.setCreateUser(customUser.getId());
        reimburseApply.setUpdateUser(customUser.getId());
        int insertId = bizReimburseApplyMapper.insertSelective(reimburseApply);


        // 2 根据类型添加子数据
        ReimburseTypeEnum reimburseTypeEnum = ReimburseTypeEnum.valueOfCode(model.getType());
        switch (reimburseTypeEnum) {
            case travle: {
                if (CollectionUtil.isNotEmpty(model.getReimburseTravelDetailAddDTOList())) {
                    model.getReimburseTravelDetailAddDTOList().stream()
                        .forEach(reimburseTravelDetailAddDTO -> {
                            BizReimburseTravelDetail record = new BizReimburseTravelDetail();
                            BeanUtils.copyProperties(reimburseTravelDetailAddDTO, record);
                            record.setSerialNo(ser);
                            record.setReimburseId(reimburseApply.getId());
                            record.setPayStatus(ReimbursePayStatusEnum.un_pay.getCode());
                            record.setCreateTime(new Date());
                            record.setUpdateTime(new Date());
                            record.setCreateUser(customUser.getId());
                            record.setUpdateUser(customUser.getId());
                            int i = bizReimburseTravelDetailMapper.insertSelective(record);
                        });
                }
                break;
            }
            case cost: {
                if (CollectionUtil.isNotEmpty(model.getReimburseCostDetailAddDTOList())) {
                    model.getReimburseCostDetailAddDTOList().stream()
                        .forEach(reimburseCostDetailAddDTO -> {
                            BizReimburseCostDetail record = new BizReimburseCostDetail();
                            BeanUtils.copyProperties(reimburseCostDetailAddDTO, record);
                            record.setSerialNo(ser);
                            record.setReimburseId(reimburseApply.getId());
                            record.setPayStatus(ReimbursePayStatusEnum.un_pay.getCode());
                            record.setCreateTime(new Date());
                            record.setUpdateTime(new Date());
                            record.setCreateUser(customUser.getId());
                            record.setUpdateUser(customUser.getId());
                            int i = bizReimburseCostDetailMapper.insertSelective(record);
                        });
                }
                break;
            }
        }
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean delete(Integer id) {
        //int delete = bizReimburseApplyMapper.deleteByPrimaryKey(id);

        BizReimburseApply billBank = new BizReimburseApply();
        billBank.setId(id);
        billBank.setDelFlag("1");
        billBank.setUpdateTime(new Date());
        billBank.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizReimburseApplyMapper.updateByPrimaryKeySelective(billBank);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean update(ReimburseApplyUpDTO reimburseApplyUpDTO) {

        BizReimburseApply reimburseApply = new BizReimburseApply();
        BeanUtils.copyProperties(reimburseApplyUpDTO, reimburseApply);
        BizReimburseApply selectByPrimaryKey = bizReimburseApplyMapper.selectByPrimaryKey(reimburseApplyUpDTO.getId());

        reimburseApply.setUpdateTime(new Date());
        reimburseApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizReimburseApplyMapper.updateByPrimaryKeySelective(reimburseApply);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean<ReimburseApplyDetailDTO> getInfo(Integer id) {
        BizReimburseApply reimburseApply = bizReimburseApplyMapper.selectByPrimaryKey(id);

        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));

        // 查询系统用户
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andIdEqualTo(reimburseApply.getReimburseUser());
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        Map<Integer, SysUser> finalSysUserMap = sysUsers.stream().collect(Collectors.toMap(SysUser::getId, Function.identity()));


        // 查询部门预算
        BizCostBudgetSubjectsExample bizCostBudgetExample = new BizCostBudgetSubjectsExample();
        BizCostBudgetSubjectsExample.Criteria criteria = bizCostBudgetExample.createCriteria();
        criteria.andDeptIdEqualTo(reimburseApply.getDeptId());
        List<BizCostBudgetSubjects> costBudgetSubjectsList = bizCostBudgetSubjectsMapper.selectByExample(bizCostBudgetExample);
        Map<Integer, String> costBudgetSubjectsMap = costBudgetSubjectsList.stream()
            .collect(Collectors.toMap(BizCostBudgetSubjects::getId, BizCostBudgetSubjects::getName));

        // 查询当前余额
        Map<String, BigDecimal> subjectsBalanceAll = subjectBalanceService.getSubjectsBalanceAll();

        ReimburseApplyDetailDTO reimburseApplyRSDTO = new ReimburseApplyDetailDTO();
        BeanUtils.copyProperties(reimburseApply, reimburseApplyRSDTO);
        SysDepartment sysDepartment = sysDepartmentMap.get(reimburseApply.getDeptId());
        if (sysDepartment != null) {
            reimburseApplyRSDTO.setDeptName(sysDepartment.getDeptName());
        }
        SysUser sysUser = finalSysUserMap.get(reimburseApply.getReimburseUser());
        if (sysUser != null) {
            reimburseApplyRSDTO.setReimburseUserName(sysUser.getRealName());
        }
        ReimburseApplyStatusEnum applyStatusEnum = ReimburseApplyStatusEnum.valueOfCode(reimburseApply.getApplyStatus());

        reimburseApplyRSDTO.setApplyStatusCN(applyStatusEnum == null ?
            ReimburseApplyStatusEnum.PENDING_APPROVAL.getDesc() : applyStatusEnum.getDesc());

        ReimbursePayStatusEnum payStatusEnum = ReimbursePayStatusEnum.valueOfCode(reimburseApply.getPayStatus());
        reimburseApplyRSDTO.setPayStatusCN(payStatusEnum == null ? ReimbursePayStatusEnum.un_pay.getDesc() : payStatusEnum.getDesc());

        ReimburseTypeEnum reimburseTypeEnum = ReimburseTypeEnum.valueOfCode(reimburseApply.getType());
        reimburseApplyRSDTO.setTypeCN(reimburseTypeEnum == null ? ReimburseTypeEnum.travle.getDesc() : reimburseTypeEnum.getDesc());

        // 差旅
        if (StringUtils.equalsIgnoreCase(reimburseTypeEnum.getCode(), ReimburseTypeEnum.travle.getCode())) {
            BizReimburseTravelDetailExample bizReimburseTravelDetailExample = new BizReimburseTravelDetailExample();
            bizReimburseTravelDetailExample.createCriteria().andReimburseIdEqualTo(id);
            List<BizReimburseTravelDetail> reimburseTravelDetailList =
                bizReimburseTravelDetailMapper.selectByExample(bizReimburseTravelDetailExample);

            Map<String, String> vehicle_type_map = sysDictService.getSysDictByTypeCode(DictEnum.VEHICLE_TYPE.getCode()).stream()
                .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

            Map<String, String> project_type_map = sysDictService.getSysDictByTypeCode(DictEnum.PROJECT_TYPE.getCode()).stream()
                .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

            List<ReimburseTravelDetailRSDTO> reimburseTravelDetailRSDTOList = reimburseTravelDetailList.stream()
                .map(reimburseTravelDetail -> {
                    ReimburseTravelDetailRSDTO reimburseTravelDetailRSDTO = new ReimburseTravelDetailRSDTO();
                    BeanUtils.copyProperties(reimburseTravelDetail, reimburseTravelDetailRSDTO);
                    reimburseTravelDetailRSDTO.setVehicleCN(vehicle_type_map.getOrDefault(reimburseTravelDetail.getVehicle() + "", ""));

                    reimburseTravelDetailRSDTO.setProjectTypeCN(project_type_map.getOrDefault(reimburseTravelDetail.getProjectType() + "", ""));
                    return reimburseTravelDetailRSDTO;
                })
                .collect(Collectors.toList());
            reimburseApplyRSDTO.setReimburseTravelDetailRSDTOList(reimburseTravelDetailRSDTOList);
            // 费用
        } else if (StringUtils.equalsIgnoreCase(reimburseTypeEnum.getCode(), ReimburseTypeEnum.cost.getCode())) {
            Map<String, String> subjects_type_map = sysDictService.getSysDictByTypeCode(DictEnum.SUBJECTS_TYPE.getCode()).stream()
                .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));


            BizReimburseCostDetailExample bizReimburseCostDetailExample = new BizReimburseCostDetailExample();
            bizReimburseCostDetailExample.createCriteria().andReimburseIdEqualTo(id);
            List<BizReimburseCostDetail> reimburseCostDetailList = bizReimburseCostDetailMapper.selectByExample(bizReimburseCostDetailExample);
            List<ReimburseCostDetailRSDTO> reimburseCostDetailRSDTOList = reimburseCostDetailList.stream()
                .map(reimburseCostDetail -> {
                    ReimburseCostDetailRSDTO reimburseCostDetailRSDTO = new ReimburseCostDetailRSDTO();
                    BeanUtils.copyProperties(reimburseCostDetail, reimburseCostDetailRSDTO);
                    String subjectsMapOrDefault = costBudgetSubjectsMap.getOrDefault(reimburseCostDetail.getSubject(), "");
                    reimburseCostDetailRSDTO.setSubjectCN(subjectsMapOrDefault);

                    BizSubjects bizSubjects = bizSubjectsMapper.selectByPrimaryKey(reimburseCostDetail.getSubject());

                    reimburseCostDetailRSDTO.setSubjectsType(bizSubjects != null ? bizSubjects.getType() : "");
                    reimburseCostDetailRSDTO.setSubjectsTypeName(bizSubjects != null ? subjects_type_map.get(bizSubjects.getType()) : "");

                    BigDecimal balanceAmount = subjectsBalanceAll.getOrDefault(reimburseApply.getDeptId() + "_" + reimburseCostDetail.getSubject(), BigDecimal.ZERO);
                    reimburseCostDetailRSDTO.setBalanceAmount(balanceAmount);
                    return reimburseCostDetailRSDTO;
                })
                .collect(Collectors.toList());
            reimburseApplyRSDTO.setReimburseCostDetailRSDTOList(reimburseCostDetailRSDTOList);
        }

        return ResultBean.success(reimburseApplyRSDTO);
    }

    @Override
    public ResultBean<PageDTO<ReimburseApplyRSDTO>> getList(ReimburseApplyRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizReimburseApplyExample reimburseApplyExample = new BizReimburseApplyExample();
        BizReimburseApplyExample.Criteria criteria = reimburseApplyExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        // 借款审批列表
        if (StringUtils.equalsIgnoreCase("1", model.getMyself())) {
//            criteria.andCreateUserEqualTo(sysUserService.selectLoginUser().getId());
        } else {
            criteria.andApplyStatusEqualTo(ReimburseApplyStatusEnum.IN_PAYMENT.getCode());
        }

        // 状态 1 代办 2 已办
        if (StringUtils.isNotEmpty(model.getType())) {
            criteria.andTypeEqualTo(model.getType());
        }


        //借款部门名称
        if (StringUtils.isNotEmpty(model.getDeptName())) {
            SysDepartmentExample departmentExample = new SysDepartmentExample();
            departmentExample.createCriteria().andDeptNameLike(model.getDeptName());
            List<SysDepartment> sysDepartments = departmentMapper.selectByExample(departmentExample);
            if (CollectionUtil.isNotEmpty(sysDepartments)) {
                List<Integer> integerList = sysDepartments.stream().map(SysDepartment::getId).collect(Collectors.toList());
                criteria.andDeptIdIn(integerList);
            }
        }
        //借款人名称
//        if (StringUtils.isNotEmpty(model.getReimburseUser())) {
//            criteria.andTypeEqualTo(model.getType());
//        }
        // 编号
        if (StringUtils.isNotEmpty(model.getSerialNo())) {
            criteria.andSerialNoLike(model.getSerialNo());
        }

        reimburseApplyExample.setOrderByClause("id desc");
        Page<BizReimburseApply> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizReimburseApplyMapper.selectByExample(reimburseApplyExample);
            });
        PageDTO<ReimburseApplyRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);

        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));


        List<Integer> reimburseUserIdList = pageData.getResult().stream()
            .map(BizReimburseApply::getReimburseUser)
            .distinct()
            .collect(Collectors.toList());

        List<SysUser> sysUserList = sysUserService.getSysUserList(reimburseUserIdList);
        Map<Integer, SysUser> sysUserMap = sysUserList.stream()
            .collect(Collectors.toMap(SysUser::getId, Function.identity(), (a, b) -> a));

        // 查询当前用户的角色
        CustomUser customUser = sysUserService.selectLoginUser();
        List<CustomGrantedAuthority> customGrantedAuthorityList = customUser.getAuthorities().stream()
            .map(a -> (CustomGrantedAuthority) a)
            .collect(Collectors.toList());

        //当前角色是否为出纳
        boolean iscn = customGrantedAuthorityList.stream()
            .anyMatch(grantedAuthority -> StringUtils.equalsIgnoreCase(grantedAuthority.getRole(), RoleEnum.ROLE_CN.getCode()));

        List<ReimburseApplyRSDTO> reimburseApplyRSDTOList = pageData.getResult().stream()
            .map(reimburseApply -> {
                ReimburseApplyRSDTO reimburseApplyRSDTO = new ReimburseApplyRSDTO();
                BeanUtils.copyProperties(reimburseApply, reimburseApplyRSDTO);

                ReimburseApplyStatusEnum applyStatusEnum = ReimburseApplyStatusEnum.valueOfCode(reimburseApply.getApplyStatus());

                reimburseApplyRSDTO.setApplyStatusCN(applyStatusEnum == null ?
                    ReimburseApplyStatusEnum.PENDING_APPROVAL.getDesc() : applyStatusEnum.getDesc());

                ReimbursePayStatusEnum payStatusEnum = ReimbursePayStatusEnum.valueOfCode(reimburseApply.getPayStatus());
                reimburseApplyRSDTO.setPayStatusCN(payStatusEnum == null ? ReimbursePayStatusEnum.un_pay.getDesc() : payStatusEnum.getDesc());

                ReimburseTypeEnum reimburseTypeEnum = ReimburseTypeEnum.valueOfCode(reimburseApply.getType());
                reimburseApplyRSDTO.setTypeCN(reimburseTypeEnum == null ? ReimburseTypeEnum.travle.getDesc() : reimburseTypeEnum.getDesc());


                SysDepartment sysDepartment = sysDepartmentMap.get(reimburseApplyRSDTO.getDeptId());
                reimburseApplyRSDTO.setDeptName(sysDepartment == null ? "" : sysDepartment.getDeptName());

                SysUser sysUser = sysUserMap.get(reimburseApply.getReimburseUser());
                reimburseApplyRSDTO.setReimburseUserName(sysUser == null ? "" : sysUser.getRealName());

                // 角色 == 出纳 && 支付状态 == 0（未付款）&& 确认状态 == 1（出纳付款）
                boolean canPay = iscn
                    && StringUtils.equalsIgnoreCase(reimburseApply.getApplyStatus(), ReimburseApplyStatusEnum.IN_PAYMENT.getCode())
                    && (
                    StringUtils.equalsIgnoreCase(reimburseApply.getPayStatus(), ReimbursePayStatusEnum.un_pay.getCode())
                        || StringUtils.equalsIgnoreCase(reimburseApply.getPayStatus(), ReimbursePayStatusEnum.partial_pay.getCode())
                );
                reimburseApplyRSDTO.setCanPay(canPay);
                return reimburseApplyRSDTO;
            })
            .collect(Collectors.toList());
        pageDTO.setList(reimburseApplyRSDTOList);
        return ResultBean.success(pageDTO);
    }

    @Override
    public int auditReplaceMaterial(String item_id, ReimburseApplyStatusEnum auditResult) {
        BizReimburseApplyExample reimburseApplyExample = new BizReimburseApplyExample();
        BizReimburseApplyExample.Criteria criteria = reimburseApplyExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
        criteria.andSerialNoEqualTo(item_id);
        List<BizReimburseApply> bizLoanApplies = bizReimburseApplyMapper.selectByExample(reimburseApplyExample);

        BizReimburseApply loanApplyS = bizLoanApplies.get(0);
        if (loanApplyS == null) {
            log.error("auditReplaceMaterial 无该条记录,id:{}", item_id);
            return 0;
        }

        BizReimburseApply reimburseApply = new BizReimburseApply();
        reimburseApply.setId(loanApplyS.getId());
        reimburseApply.setApplyStatus(auditResult.getCode());
        reimburseApply.setUpdateTime(new Date());
        reimburseApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizReimburseApplyMapper.updateByPrimaryKeySelective(reimburseApply);
        return update;
    }

    @Override
    public ResultBean approve(Integer id) {

        // 查询&修改 付款申请
        BizReimburseApply reimburseApply = bizReimburseApplyMapper.selectByPrimaryKey(id);

        //审核状态：
        reimburseApply.setApplyStatus(ReimburseApplyStatusEnum.UNDER_APPROVAL.getCode());
        reimburseApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        reimburseApply.setUpdateTime(new Date());
        bizReimburseApplyMapper.updateByPrimaryKeySelective(reimburseApply);

        // 添加申请流程
        FlowInstanceDTO flowInstanceDTO = buildFlowInstanceDTO(reimburseApply);
        flowInstanceService.create(flowInstanceDTO);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean pay(ReimburseApplyPayDTO payDTO) {
        BizReimburseApply bizReimburseApplyS = bizReimburseApplyMapper.selectByPrimaryKey(payDTO.getId());

        BigDecimal applySAmount = bizReimburseApplyS.getAmount();


        // 有些状态不能付款
        LoanrPayStatusEnum statusEnum = LoanrPayStatusEnum.valueOfCode(bizReimburseApplyS.getPayStatus());
        if (LoanrPayStatusEnum.all_pay.getCode().equalsIgnoreCase(statusEnum.getCode())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, statusEnum.getDesc() + "该笔状态已付款");
        }

        // 如果是借款冲抵
        if (StringUtils.equalsIgnoreCase("2", bizReimburseApplyS.getReimburseType())) {
            //
            Integer loanId = bizReimburseApplyS.getLoanId();
            BizLoanApply bizLoanApply = bizLoanApplyMapper.selectByPrimaryKey(loanId);

            BigDecimal paymentAmount = bizLoanApply.getPaymentAmount() == null ? BigDecimal.ZERO : bizLoanApply.getPaymentAmount();
            BigDecimal addAmount = bizReimburseApplyS.getOffsetamount().add(paymentAmount);

            if (addAmount.compareTo(bizLoanApply.getAmount()) > 0) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "总冲抵金额不能大于借款金额");
            }

            BizPaymentHistory paymentHistory = buildBizPaymentHistory(bizReimburseApplyS, bizLoanApply);
            bizPaymentHistoryMapper.insertSelective(paymentHistory);

            BizLoanApply bizLoanApplyUp = new BizLoanApply();
            bizLoanApplyUp.setId(bizLoanApply.getId());
            bizLoanApplyUp.setPaymentAmount(addAmount);
            if (addAmount.compareTo(bizLoanApply.getAmount()) == 0) {
                bizLoanApplyUp.setPaymentStatus(LoanrPaymentStatusEnum.all_pay.getCode());
            } else {
                bizLoanApplyUp.setPaymentStatus(LoanrPaymentStatusEnum.partial_pay.getCode());
            }
            bizLoanApplyMapper.updateByPrimaryKeySelective(bizLoanApplyUp);
        }

        // 记账方式（1現金 2銀行 3 其他貨幣）
        if (StringUtils.equalsIgnoreCase("1", payDTO.getBillNature())) {
            SysUser sysUser = sysUserService.getSysUser(bizReimburseApplyS.getReimburseUser());
            // todo 扣减日记账金额
            BizBillAddDTO bizBill = new BizBillAddDTO();
            bizBill.setType(BookingTypeEnum.cash_bill.getCode());
            bizBill.setCertificateNumber(payDTO.getPayAccount());
            bizBill.setD(new Date());
            bizBill.setPaymentType(PayWayEnum.cash_pay.getDesc());
            bizBill.setPayment(applySAmount);
            bizBill.setRemark("借款付款 " + applySAmount);
            bizBill.setString1(sysUser.getRealName());
            bizBill.setString2(payDTO.getPayCompany());
            billService.save(bizBill);
        } else {
            BizBankBillAddDTO bizBankBill = new BizBankBillAddDTO();
            // 付款
            bizBankBill.setType("2");
            bizBankBill.setCompany(payDTO.getPayCompany());
            bizBankBill.setCertificateNumber("");
            bizBankBill.setOperateDate(new Date());
            bizBankBill.setPayWay(PayWayEnum.cash_pay.getDesc());
            bizBankBill.setPaymentType(PayWayEnum.cash_pay.getDesc());
            bizBankBill.setPayment(applySAmount);
            bizBankBill.setRemark("报销付款 " + applySAmount);
            bizBankBill.setPayCompany(payDTO.getPayCompany());
            bizBankBill.setPayAccount(payDTO.getPayAccount());
            bizBankBill.setCollectCompany("");
            bankBillService.save(bizBankBill);
        }


        BizReimburseApply apply = new BizReimburseApply();
        BeanUtils.copyProperties(payDTO, apply);
        apply.setPayStatus(LoanrPayStatusEnum.all_pay.getCode());
        apply.setPayTime(new Date());
        apply.setUpdateTime(new Date());
        apply.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizReimburseApplyMapper.updateByPrimaryKeySelective(apply);

        // 余额扣款
        if (StringUtils.equalsIgnoreCase("2", bizReimburseApplyS.getType())) {
            BizReimburseCostDetailExample bizReimburseCostDetailExample = new BizReimburseCostDetailExample();
            bizReimburseCostDetailExample.createCriteria().andReimburseIdEqualTo(payDTO.getId());
            List<BizReimburseCostDetail> reimburseCostDetailList = bizReimburseCostDetailMapper.selectByExample(bizReimburseCostDetailExample);
            for (BizReimburseCostDetail reimburseCostDetail : reimburseCostDetailList) {
                BizSubjectsBalanceUpDTO bizSubjects = new BizSubjectsBalanceUpDTO();
                bizSubjects.setSubjectsId(reimburseCostDetail.getSubject());
                bizSubjects.setDeptId(bizReimburseApplyS.getDeptId());
                bizSubjects.setAmount(applySAmount);
                subjectBalanceService.decreaseAmount(bizSubjects);
            }
        }

        return ResultBean.success(update);
    }

    private BizPaymentHistory buildBizPaymentHistory(BizReimburseApply bizReimburseApplyS, BizLoanApply bizLoanApply) {
        BizPaymentHistory paymentHistory = new BizPaymentHistory();
        paymentHistory.setAmount(bizReimburseApplyS.getOffsetamount());
        paymentHistory.setLoanId(bizReimburseApplyS.getLoanId());
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

    private FlowInstanceDTO buildFlowInstanceDTO(BizReimburseApply reimburseApply) {
        FlowInstanceDTO flowInstanceDTO = new FlowInstanceDTO();
        flowInstanceDTO.setFlowId(REIMBURSE_APP_FLOW.id);
        flowInstanceDTO.setSummary("报销申请审批");
        flowInstanceDTO.setFormType(REIMBURSE_APP_TYPE.code);
        flowInstanceDTO.setFormNo(reimburseApply.getSerialNo());
        flowInstanceDTO.setFormId(reimburseApply.getId());
        return flowInstanceDTO;
    }
}
