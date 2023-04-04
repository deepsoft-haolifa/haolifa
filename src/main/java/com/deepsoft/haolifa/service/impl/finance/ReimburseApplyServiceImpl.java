package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.enums.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.finance.FileUrlDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetDecDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetQueryBO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.*;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost.ReimburseCostDetailAddDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost.ReimburseCostDetailRSDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost.ReimburseCostDetailUpDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.travel.ReimburseTravelDetailAddDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.travel.ReimburseTravelDetailRSDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.travel.ReimburseTravelDetailUpDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceUpDTO;
import com.deepsoft.haolifa.service.ExpensesService;
import com.deepsoft.haolifa.service.FlowInstanceService;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.*;
import com.deepsoft.haolifa.service.impl.finance.helper.RemiburseHelper;
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
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReimburseApplyServiceImpl implements ReimburseApplyService {

    @Resource
    private LoanApplyService loanApplyService;
    @Resource
    private BizLoanApplyMapper bizLoanApplyMapper;
    @Resource
    private BizReimburseApplyMapper bizReimburseApplyMapper;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private BizBillMapper bizBillMapper;
    @Resource
    private BizBankBillMapper bizBankBillMapper;
    @Resource
    private BizOtherBillMapper bizOtherBillMapper;
    @Lazy
    @Resource
    private FlowInstanceService flowInstanceService;
    @Resource
    private BizReimburseTravelDetailMapper bizReimburseTravelDetailMapper;
    @Resource
    private BizReimburseCostDetailMapper bizReimburseCostDetailMapper;
    @Resource
    private SysDepartmentMapper departmentMapper;
    @Resource
    private BizSubjectsMapper bizSubjectsMapper;

    @Resource
    private BizCostBudgetSubjectsMapper bizCostBudgetSubjectsMapper;

    @Resource
    private SysDictService sysDictService;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private OtherBillService otherBillService;

    @Resource
    private BillService billService;
    @Resource
    private BankBillService bankBillService;
    @Resource
    private SubjectBalanceService subjectBalanceService;
    @Resource
    private ExpensesService expensesService;
    @Resource
    private ProjectBudgetService projectBudgetService;

    @Resource
    private BizProjectBudgetMapper bizProjectBudgetMapper;

    @Resource
    private RemiburseHelper remiburseHelper;


    //
    @Override
    public ResultBean save(ReimburseApplyAddDTO model) {
        log.info("ReimburseApplyService save start|{}", JSONObject.toJSON(model));
        ResultBean<Object> PARAM_ERROR = remiburseHelper.validate(model);
        if (PARAM_ERROR != null) {
            return PARAM_ERROR;
        }

        CustomUser customUser = sysUserService.selectLoginUser();
        SysUser sysUser = sysUserService.getSysUser(customUser.getId());

        // 报销详情里的总金额
        BigDecimal totalAmount = remiburseHelper.getTotalAmount(model);

        // 如果是借款冲抵 需要减去冲抵金额
        if (StringUtils.equalsIgnoreCase("2", model.getReimburseType())) {

            BizLoanApplyExample loanApplyExample = new BizLoanApplyExample();
            BizLoanApplyExample.Criteria loanApplyExampleCriteria = loanApplyExample.createCriteria();
            loanApplyExampleCriteria.andIdIn(model.getLoanIdList());
//            loanApplyExampleCriteria.andPaymentAmountGreaterThan(BigDecimal.ZERO);
//            loanApplyExampleCriteria.andPayStatusEqualTo("3");

            List<BizLoanApply> bizLoanApplyList = bizLoanApplyMapper.selectByExample(
                loanApplyExample);

            // 总借款
            BigDecimal totalLoanAmount = bizLoanApplyList.stream()
                .map(BizLoanApply::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

            // 总还款
            BigDecimal totalPaymentAmount = bizLoanApplyList.stream()
                .map(b -> b.getPaymentAmount() == null ? BigDecimal.ZERO : b.getPaymentAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

            // 总欠款
            BigDecimal totalOwingAmount = totalLoanAmount.subtract(totalPaymentAmount);
            if (model.getOffsetAmount().compareTo(totalOwingAmount) > 0) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,
                    "总冲抵金额不能大于总欠款金额");
            }
            totalAmount = totalAmount.subtract(model.getOffsetAmount());
        }

        // 只有报销金额大于0 才校验项目
        if (totalAmount.doubleValue() > 0) {
            if (StringUtils.isEmpty(model.getProjectCode())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "项目编号");
            }
            ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
            queryBO.setCode(model.getProjectCode());
            queryBO.setDeptId(sysUser.getDepartId());
            queryBO.setDate(new Date());
            // 校验当月项目预算
            BizProjectBudget bizProjectBudget = projectBudgetService.queryCurMonthBudget(queryBO);
            //  当月未维护
            if (ObjectUtil.isNull(bizProjectBudget)) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "当月项目预算未维护");
            }
            // 金额不足
            if (bizProjectBudget.getBalanceQuota().compareTo(totalAmount) < 0) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,
                    "当月项目预算金额不足");
            }
        }

        // 1 添加主数据
        String ser = "FP" + DateUtils.dateTimeNow() + RandomStringUtils.randomNumeric(3);
        BizReimburseApply reimburseApply = remiburseHelper.buildBizReimburseApply(model, customUser,
            sysUser, totalAmount, ser);
        int insertId = bizReimburseApplyMapper.insertSelective(reimburseApply);

        // 2 根据类型添加子数据 校验
        ReimburseTypeEnum reimburseTypeEnum = ReimburseTypeEnum.valueOfCode(model.getType());
        switch (reimburseTypeEnum) {
            case travle: {
                if (CollectionUtil.isNotEmpty(model.getReimburseTravelDetailAddDTOList())) {
                    for (ReimburseTravelDetailAddDTO reimburseTravelDetailAddDTO : model.getReimburseTravelDetailAddDTOList()) {
                        BizReimburseTravelDetail record = remiburseHelper.buildBizReimburseTravelDetail(
                            customUser, ser, reimburseApply, reimburseTravelDetailAddDTO);
                        int i = bizReimburseTravelDetailMapper.insertSelective(record);
                    }
                }
                break;
            }
            case cost: {
                if (CollectionUtil.isNotEmpty(model.getReimburseCostDetailAddDTOList())) {
                    for (ReimburseCostDetailAddDTO reimburseCostDetailAddDTO : model.getReimburseCostDetailAddDTOList()) {
                        BizReimburseCostDetail record = remiburseHelper.buildBizReimburseCostDetail(
                            customUser, ser, reimburseApply, reimburseCostDetailAddDTO);
                        int i = bizReimburseCostDetailMapper.insertSelective(record);
                    }
                }
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + reimburseTypeEnum);
        }
        return ResultBean.success(insertId);
    }


    @Override
    public ResultBean<BigDecimal> calculateAmount(ReimburseApplyAmountDTO model) {
        // 报销详情里的总金额
        BigDecimal totalAmount = remiburseHelper.getTotalAmount(model);
        // 如果是借款冲抵 需要减去冲抵金额
        if (StringUtils.equalsIgnoreCase("2", model.getReimburseType())) {
            totalAmount = totalAmount.subtract(model.getOffsetAmount());
        }
        return ResultBean.success(totalAmount);
    }

    @Override
    public ResultBean delete(Integer id) {
        //int delete = bizReimburseApplyMapper.deleteByPrimaryKey(id);

        BizReimburseApply reimburseApply = bizReimburseApplyMapper.selectByPrimaryKey(id);

        BizReimburseApply billBank = new BizReimburseApply();
        billBank.setId(id);
        billBank.setDelFlag("1");
        billBank.setUpdateTime(new Date());
        billBank.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizReimburseApplyMapper.updateByPrimaryKeySelective(billBank);

        if (StringUtils.isNotEmpty(reimburseApply.getProjectCode())) {
            remiburseHelper.backProjectAmount(reimburseApply);
        }

        return ResultBean.success(update);
    }

    @Override
    public ResultBean update(ReimburseApplyUpDTO model) {

        BizReimburseApply reimburseApply = new BizReimburseApply();
        BeanUtils.copyProperties(model, reimburseApply);
        BizReimburseApply selectByPrimaryKey = bizReimburseApplyMapper.selectByPrimaryKey(
            model.getId());

        if (StringUtils.equalsIgnoreCase(ReimburseApplyStatusEnum.APPROVAL_FAILED.getCode(),
            selectByPrimaryKey.getApplyStatus())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,
                "审批拒绝状态不允许修改，请删除后重新提交！");
        }

        // 1 作废
        {
            if (StringUtils.isNotEmpty(selectByPrimaryKey.getProjectCode())) {
                remiburseHelper.backProjectAmount(selectByPrimaryKey);
            }

            ReimburseTypeEnum reimburseTypeEnum = ReimburseTypeEnum.valueOfCode(
                selectByPrimaryKey.getType());
            switch (reimburseTypeEnum) {
                case travle: {
                    BizReimburseTravelDetailExample example = new BizReimburseTravelDetailExample();
                    BizReimburseTravelDetailExample.Criteria criteria = example.createCriteria();
                    criteria.andReimburseIdEqualTo(selectByPrimaryKey.getId());
                    bizReimburseTravelDetailMapper.deleteByExample(example);
                    break;
                }
                case cost: {
                    BizReimburseCostDetailExample example = new BizReimburseCostDetailExample();
                    BizReimburseCostDetailExample.Criteria criteria = example.createCriteria();
                    criteria.andReimburseIdEqualTo(selectByPrimaryKey.getId());
                    bizReimburseCostDetailMapper.deleteByExample(example);
                    break;
                }
            }
        }

        // 2 新增
        CustomUser customUser = sysUserService.selectLoginUser();
        SysUser sysUser = sysUserService.getSysUser(customUser.getId());

        // 报销详情里的总金额
        BigDecimal totalAmount = remiburseHelper.getTotalAmount(model);

        ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
        queryBO.setCode(model.getProjectCode());
        queryBO.setDeptId(sysUser.getDepartId());
        queryBO.setDate(new Date());
        // 校验当月项目预算
        BizProjectBudget bizProjectBudget = projectBudgetService.queryCurMonthBudget(queryBO);
        //  当月未维护
        if (ObjectUtil.isNull(bizProjectBudget)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "当月项目预算未维护");
        }
        // 金额不足
        if (bizProjectBudget.getBalanceQuota().compareTo(totalAmount) < 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "当月项目预算金额不足");
        }

        // 如果是借款冲抵 需要减去冲抵金额
        if (StringUtils.equalsIgnoreCase("2", model.getReimburseType())) {
            //
            BizLoanApply bizLoanApply = bizLoanApplyMapper.selectByPrimaryKey(model.getLoanId());
            // 已经还款金额
            BigDecimal paymentAmount = bizLoanApply.getPaymentAmount() == null ? BigDecimal.ZERO
                : bizLoanApply.getPaymentAmount();
            BigDecimal addAmount = model.getOffsetAmount().add(paymentAmount);

            if (addAmount.compareTo(bizLoanApply.getAmount()) > 0) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,
                    "总冲抵金额不能大于借款金额");
            }
            totalAmount = totalAmount.subtract(model.getOffsetAmount());
        }

        // 1 添加主数据 todo
        reimburseApply.setAmount(totalAmount);
        reimburseApply.setUpdateTime(new Date());
        reimburseApply.setUpdateUser(sysUserService.selectLoginUser().getId());

        // 2 根据类型添加子数据 校验
        ReimburseTypeEnum reimburseTypeEnum = ReimburseTypeEnum.valueOfCode(model.getType());
        switch (reimburseTypeEnum) {
            case travle: {
                if (CollectionUtil.isNotEmpty(model.getReimburseTravelDetailAddDTOList())) {
                    for (ReimburseTravelDetailUpDTO reimburseTravelDetailAddDTO : model.getReimburseTravelDetailAddDTOList()) {
                        BizReimburseTravelDetail record = remiburseHelper.buildBizReimburseTravelDetail(
                            customUser, selectByPrimaryKey.getSerialNo(), selectByPrimaryKey,
                            reimburseTravelDetailAddDTO);
                        int i = bizReimburseTravelDetailMapper.insertSelective(record);
                    }
                }
                break;
            }
            case cost: {
                if (CollectionUtil.isNotEmpty(model.getReimburseCostDetailAddDTOList())) {
                    for (ReimburseCostDetailUpDTO reimburseCostDetailAddDTO : model.getReimburseCostDetailAddDTOList()) {
                        BizReimburseCostDetail record = remiburseHelper.buildBizReimburseCostDetail(
                            customUser, selectByPrimaryKey.getSerialNo(), selectByPrimaryKey,
                            reimburseCostDetailAddDTO);
                        int i = bizReimburseCostDetailMapper.insertSelective(record);
                    }
                }
                break;
            }
        }

        //上传到7牛文件服务器
        if (CollectionUtil.isNotEmpty(model.getFileUrlList())) {
            String fileUrl = "";
//            List<String> fileUrlList = new ArrayList<>();
//            for (FileDTO fileDTO:model.getFileDTOList()){
//                fileUrlList.add(QiniuUtil.uploadFile(fileDTO.getBase64Source(), fileDTO.getFileName()));
//            }
            fileUrl = JSON.toJSONString(model.getFileUrlList());
            reimburseApply.setFileUrl(fileUrl);
        }

        int update = bizReimburseApplyMapper.updateByPrimaryKeySelective(reimburseApply);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean<ReimburseApplyDetailDTO> getInfo(Integer id) {
        BizReimburseApply reimburseApply = bizReimburseApplyMapper.selectByPrimaryKey(id);

        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(
            new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream()
            .collect(Collectors.toMap(SysDepartment::getId, Function.identity()));

        // 查询系统用户
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andIdEqualTo(reimburseApply.getReimburseUser());
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        Map<Integer, SysUser> finalSysUserMap = sysUsers.stream()
            .collect(Collectors.toMap(SysUser::getId, Function.identity()));

        // 查询部门预算
        BizCostBudgetSubjectsExample bizCostBudgetExample = new BizCostBudgetSubjectsExample();
        BizCostBudgetSubjectsExample.Criteria criteria = bizCostBudgetExample.createCriteria();
        criteria.andDeptIdEqualTo(reimburseApply.getDeptId());
        List<BizCostBudgetSubjects> costBudgetSubjectsList = bizCostBudgetSubjectsMapper.selectByExample(
            bizCostBudgetExample);
        Map<Integer, String> costBudgetSubjectsMap = costBudgetSubjectsList.stream()
            .collect(Collectors.toMap(BizCostBudgetSubjects::getSubjectsId,
                BizCostBudgetSubjects::getName));

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
        ReimburseApplyStatusEnum applyStatusEnum = ReimburseApplyStatusEnum.valueOfCode(
            reimburseApply.getApplyStatus());

        reimburseApplyRSDTO.setApplyStatusCN(applyStatusEnum == null ?
            ReimburseApplyStatusEnum.PENDING_APPROVAL.getDesc() : applyStatusEnum.getDesc());

        ReimbursePayStatusEnum payStatusEnum = ReimbursePayStatusEnum.valueOfCode(
            reimburseApply.getPayStatus());
        reimburseApplyRSDTO.setPayStatusCN(
            payStatusEnum == null ? ReimbursePayStatusEnum.un_pay.getDesc()
                : payStatusEnum.getDesc());

        ReimburseTypeEnum reimburseTypeEnum = ReimburseTypeEnum.valueOfCode(
            reimburseApply.getType());
        reimburseApplyRSDTO.setTypeCN(reimburseTypeEnum == null ? ReimburseTypeEnum.travle.getDesc()
            : reimburseTypeEnum.getDesc());

        // 支付类型 1 对公 2 对私
        String payTypeCN = "未知";
        if (StringUtils.equalsIgnoreCase(reimburseApply.getPayType(), "1")) {
            payTypeCN = "对公";
        } else if (StringUtils.equalsIgnoreCase(reimburseApply.getPayType(), "2")) {
            payTypeCN = "对私";
        }
        reimburseApplyRSDTO.setPayTypeCN(payTypeCN);

        // 报销方式	1普通报销 2借款冲抵
        String reimburseTypeCN = "";
        if (StringUtils.equalsIgnoreCase(reimburseApply.getReimburseType(), "1")) {
            reimburseTypeCN = "普通报销";
        } else if (StringUtils.equalsIgnoreCase(reimburseApply.getReimburseType(), "2")) {
            List<Integer> loanIdList = Arrays.stream(reimburseApply.getLoanIdStr().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
            BizLoanApplyExample loanApplyExample = new BizLoanApplyExample();
            BizLoanApplyExample.Criteria loanApplyExampleCriteria = loanApplyExample.createCriteria();
            loanApplyExampleCriteria.andIdIn(loanIdList);
            List<BizLoanApply> bizLoanApplyList = bizLoanApplyMapper.selectByExample(loanApplyExample);
            String loanAmount = bizLoanApplyList.stream()
                .map(l -> l.getAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toString())
                .collect(Collectors.joining(","));
            reimburseApplyRSDTO.setLoanAmount(loanAmount);
            reimburseTypeCN = "借款冲抵";
        }
        reimburseApplyRSDTO.setReimburseTypeCN(reimburseTypeCN);

        // 差旅
        if (StringUtils.equalsIgnoreCase(reimburseTypeEnum.getCode(),
            ReimburseTypeEnum.travle.getCode())) {
            BizReimburseTravelDetailExample bizReimburseTravelDetailExample = new BizReimburseTravelDetailExample();
            bizReimburseTravelDetailExample.createCriteria().andReimburseIdEqualTo(id);
            List<BizReimburseTravelDetail> reimburseTravelDetailList =
                bizReimburseTravelDetailMapper.selectByExample(bizReimburseTravelDetailExample);

            Map<String, String> vehicle_type_map = sysDictService.getSysDictByTypeCode(
                    DictEnum.VEHICLE_TYPE.getCode()).stream()
                .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

            Map<String, String> project_type_map = sysDictService.getSysDictByTypeCode(
                    DictEnum.PROJECT_TYPE.getCode()).stream()
                .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

            List<ReimburseTravelDetailRSDTO> reimburseTravelDetailRSDTOList = reimburseTravelDetailList.stream()
                .map(reimburseTravelDetail -> {
                    ReimburseTravelDetailRSDTO reimburseTravelDetailRSDTO = new ReimburseTravelDetailRSDTO();
                    BeanUtils.copyProperties(reimburseTravelDetail, reimburseTravelDetailRSDTO);
                    reimburseTravelDetailRSDTO.setVehicleCN(
                        vehicle_type_map.getOrDefault(reimburseTravelDetail.getVehicle() + "", ""));

                    reimburseTravelDetailRSDTO.setProjectTypeCN(
                        project_type_map.getOrDefault(reimburseTravelDetail.getProjectType() + "",
                            ""));
                    return reimburseTravelDetailRSDTO;
                })
                .collect(Collectors.toList());
            reimburseApplyRSDTO.setReimburseTravelDetailRSDTOList(reimburseTravelDetailRSDTOList);
            // 费用
        } else if (StringUtils.equalsIgnoreCase(reimburseTypeEnum.getCode(),
            ReimburseTypeEnum.cost.getCode())) {
            Map<String, String> subjects_type_map = sysDictService.getSysDictByTypeCode(
                    DictEnum.SUBJECTS_TYPE.getCode()).stream()
                .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

            BizReimburseCostDetailExample bizReimburseCostDetailExample = new BizReimburseCostDetailExample();
            bizReimburseCostDetailExample.createCriteria().andReimburseIdEqualTo(id);
            List<BizReimburseCostDetail> reimburseCostDetailList = bizReimburseCostDetailMapper.selectByExample(
                bizReimburseCostDetailExample);
            List<ReimburseCostDetailRSDTO> reimburseCostDetailRSDTOList = reimburseCostDetailList.stream()
                .map(reimburseCostDetail -> {
                    ReimburseCostDetailRSDTO reimburseCostDetailRSDTO = new ReimburseCostDetailRSDTO();
                    BeanUtils.copyProperties(reimburseCostDetail, reimburseCostDetailRSDTO);
                    String subjectsMapOrDefault = costBudgetSubjectsMap.getOrDefault(
                        reimburseCostDetail.getSubject(), "");
                    reimburseCostDetailRSDTO.setSubjectCN(subjectsMapOrDefault);

                    BizSubjects bizSubjects = bizSubjectsMapper.selectByPrimaryKey(
                        reimburseCostDetail.getSubject());

                    reimburseCostDetailRSDTO.setSubjectsType(
                        bizSubjects != null ? bizSubjects.getType() : "");
                    reimburseCostDetailRSDTO.setSubjectsTypeName(
                        bizSubjects != null ? subjects_type_map.get(bizSubjects.getType()) : "");

                    BigDecimal balanceAmount = subjectsBalanceAll.getOrDefault(
                        reimburseApply.getDeptId() + "_" + reimburseCostDetail.getSubject(),
                        BigDecimal.ZERO);
                    reimburseCostDetailRSDTO.setBalanceAmount(balanceAmount);
                    return reimburseCostDetailRSDTO;
                })
                .collect(Collectors.toList());
            reimburseApplyRSDTO.setReimburseCostDetailRSDTOList(reimburseCostDetailRSDTOList);
        }

        if (StringUtils.isNotEmpty(reimburseApplyRSDTO.getProjectCode())) {
            BizProjectBudget projectBudget = bizProjectBudgetMapper.getProjectBudgetByCode(
                reimburseApplyRSDTO.getProjectCode());
            reimburseApplyRSDTO.setProjectCodeName(projectBudget.getName());
        }

        if (StringUtils.isNotEmpty(reimburseApply.getFileUrl())) {
            reimburseApplyRSDTO.setFileUrlList(
                JSON.parseArray(reimburseApply.getFileUrl(), FileUrlDTO.class));
        } else {
            reimburseApplyRSDTO.setFileUrlList(new ArrayList<>());
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

        // 查询当前用户的角色
        CustomUser customUser = sysUserService.selectLoginUser();
        List<CustomGrantedAuthority> customGrantedAuthorityList = customUser.getAuthorities()
            .stream()
            .map(a -> (CustomGrantedAuthority) a)
            .collect(Collectors.toList());

        //当前角色是否为出纳
        boolean lookAll = customGrantedAuthorityList.stream()
            .anyMatch(grantedAuthority -> {
                return StringUtils.equalsIgnoreCase(grantedAuthority.getRole(),
                    RoleEnum.ROLE_ADMIN.getCode()) ||
                    StringUtils.equalsIgnoreCase(grantedAuthority.getRole(),
                        RoleEnum.ROLE_ZJL.getCode()) ||
                    StringUtils.equalsIgnoreCase(grantedAuthority.getRole(),
                        RoleEnum.ROLE_CWGLZXFZR.getCode()) ||
                    StringUtils.equalsIgnoreCase(grantedAuthority.getRole(),
                        RoleEnum.ROLE_ZGKJ.getCode()) ||
                    StringUtils.equalsIgnoreCase(grantedAuthority.getRole(),
                        RoleEnum.ROLE_CN.getCode());
            });

        // 借款审批列表
        if (StringUtils.equalsIgnoreCase("1", model.getMyself()) && !lookAll) {
            criteria.andCreateUserEqualTo(sysUserService.selectLoginUser().getId());
        } else if (!StringUtils.equalsIgnoreCase("1", model.getMyself())) {
            criteria.andApplyStatusEqualTo(ReimburseApplyStatusEnum.IN_PAYMENT.getCode());
        }

        // 状态 1 代办 2 已办
        if (StringUtils.isNotEmpty(model.getType())) {
            criteria.andTypeEqualTo(model.getType());
        }

        //借款部门名称
        if (StringUtils.isNotEmpty(model.getDeptName())) {
            SysDepartmentExample departmentExample = new SysDepartmentExample();
            departmentExample.createCriteria().andDeptNameLike("%" + model.getDeptName() + "%");
            List<SysDepartment> sysDepartments = departmentMapper.selectByExample(
                departmentExample);
            if (CollectionUtil.isNotEmpty(sysDepartments)) {
                List<Integer> integerList = sysDepartments.stream().map(SysDepartment::getId)
                    .collect(Collectors.toList());
                criteria.andDeptIdIn(integerList);
            }
        }
        //借款人名称
        if (StringUtils.isNotEmpty(model.getReimburseUser())) {
            SysUserExample sysUserExample = new SysUserExample();
            sysUserExample.createCriteria().andRealNameLike("%" + model.getReimburseUser() + "%");
            List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
            List<Integer> userIdList = sysUsers.stream()
                .map(SysUser::getId)
                .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(userIdList)) {
                criteria.andReimburseUserIn(userIdList);
            }
        }
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

        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(
            new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream()
            .collect(Collectors.toMap(SysDepartment::getId, Function.identity()));

        List<Integer> reimburseUserIdList = pageData.getResult().stream()
            .map(BizReimburseApply::getReimburseUser)
            .distinct()
            .collect(Collectors.toList());

        List<SysUser> sysUserList = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(reimburseUserIdList)) {
            sysUserList = sysUserService.getSysUserList(reimburseUserIdList);
        }
        Map<Integer, SysUser> sysUserMap = sysUserList.stream()
            .collect(Collectors.toMap(SysUser::getId, Function.identity(), (a, b) -> a));

        //当前角色是否为出纳
        boolean iscn = customGrantedAuthorityList.stream()
            .anyMatch(grantedAuthority -> StringUtils.equalsIgnoreCase(grantedAuthority.getRole(),
                RoleEnum.ROLE_CN.getCode()));

        List<String> projectCodeList = pageData.getResult().stream()
            .map(l -> {
                return l.getProjectCode();
            })
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
        Map<String, String> projectCodeMap = new HashMap<>();
        if (CollectionUtil.isNotEmpty(projectCodeList)) {
            BizProjectBudgetExample bizProjectBudgetExample = new BizProjectBudgetExample();
            BizProjectBudgetExample.Criteria criteriaBizProjectBudgetExample = bizProjectBudgetExample.createCriteria();
            criteriaBizProjectBudgetExample.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
            criteriaBizProjectBudgetExample.andCodeIn(projectCodeList);
            projectCodeMap = bizProjectBudgetMapper.selectByExample(bizProjectBudgetExample)
                .stream()
                .collect(Collectors.toMap(BizProjectBudget::getCode, BizProjectBudget::getName,
                    (a, b) -> a));
        }

        Map<String, String> finalProjectCodeMap = projectCodeMap;
        List<ReimburseApplyRSDTO> reimburseApplyRSDTOList = pageData.getResult().stream()
            .map(reimburseApply -> {
                ReimburseApplyRSDTO reimburseApplyRSDTO = new ReimburseApplyRSDTO();
                BeanUtils.copyProperties(reimburseApply, reimburseApplyRSDTO);

                ReimburseApplyStatusEnum applyStatusEnum = ReimburseApplyStatusEnum.valueOfCode(
                    reimburseApply.getApplyStatus());

                reimburseApplyRSDTO.setApplyStatusCN(applyStatusEnum == null ?
                    ReimburseApplyStatusEnum.PENDING_APPROVAL.getDesc()
                    : applyStatusEnum.getDesc());

                ReimbursePayStatusEnum payStatusEnum = ReimbursePayStatusEnum.valueOfCode(
                    reimburseApply.getPayStatus());
                reimburseApplyRSDTO.setPayStatusCN(
                    payStatusEnum == null ? ReimbursePayStatusEnum.un_pay.getDesc()
                        : payStatusEnum.getDesc());

                ReimburseTypeEnum reimburseTypeEnum = ReimburseTypeEnum.valueOfCode(
                    reimburseApply.getType());
                reimburseApplyRSDTO.setTypeCN(
                    reimburseTypeEnum == null ? ReimburseTypeEnum.travle.getDesc()
                        : reimburseTypeEnum.getDesc());

                // 报销方式	1普通报销 2借款冲抵
                String reimburseTypeCN = "";
                if (StringUtils.equalsIgnoreCase(reimburseApply.getReimburseType(), "1")) {
                    reimburseTypeCN = "普通报销";
                } else if (StringUtils.equalsIgnoreCase(reimburseApply.getReimburseType(), "2")) {
                    reimburseTypeCN = "借款冲抵";
                }
                reimburseApplyRSDTO.setReimburseTypeCN(reimburseTypeCN);

                SysDepartment sysDepartment = sysDepartmentMap.get(reimburseApplyRSDTO.getDeptId());
                reimburseApplyRSDTO.setDeptName(
                    sysDepartment == null ? "" : sysDepartment.getDeptName());

                SysUser sysUser = sysUserMap.get(reimburseApply.getReimburseUser());
                reimburseApplyRSDTO.setReimburseUserName(
                    sysUser == null ? "" : sysUser.getRealName());

                // 角色 == 出纳 && 支付状态 == 0（未付款）&& 确认状态 == 1（出纳付款）
                boolean canPay = iscn
                    && StringUtils.equalsIgnoreCase(reimburseApply.getApplyStatus(),
                    ReimburseApplyStatusEnum.IN_PAYMENT.getCode())
                    && (
                    StringUtils.equalsIgnoreCase(reimburseApply.getPayStatus(),
                        ReimbursePayStatusEnum.un_pay.getCode())
                        || StringUtils.equalsIgnoreCase(reimburseApply.getPayStatus(),
                        ReimbursePayStatusEnum.partial_pay.getCode())
                );
                // canPay = true;
                reimburseApplyRSDTO.setCanPay(canPay);

                if (StringUtils.isNotEmpty(reimburseApply.getFileUrl())) {
                    reimburseApplyRSDTO.setFileUrlList(
                        JSON.parseArray(reimburseApply.getFileUrl(), FileUrlDTO.class));
                } else {
                    reimburseApplyRSDTO.setFileUrlList(new ArrayList<>());
                }
                reimburseApplyRSDTO.setProjectCodeName(
                    finalProjectCodeMap.getOrDefault(reimburseApplyRSDTO.getProjectCode(), ""));
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
        List<BizReimburseApply> bizLoanApplies = bizReimburseApplyMapper.selectByExample(
            reimburseApplyExample);

        BizReimburseApply reimburseApply = bizLoanApplies.get(0);
        if (reimburseApply == null) {
            log.error("auditReplaceMaterial 无该条记录,id:{}", item_id);
            return 0;
        }

        BizReimburseApply reimburseApplyUp = new BizReimburseApply();
        reimburseApplyUp.setId(reimburseApply.getId());
        reimburseApplyUp.setApplyStatus(auditResult.getCode());
        reimburseApplyUp.setUpdateTime(new Date());
        reimburseApplyUp.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizReimburseApplyMapper.updateByPrimaryKeySelective(reimburseApplyUp);

        // 审核拒绝 回退金额
        if (ReimburseApplyStatusEnum.APPROVAL_FAILED.getCode()
            .equalsIgnoreCase(auditResult.getCode())) {
            if (StringUtils.isNotEmpty(reimburseApply.getProjectCode())) {
                remiburseHelper.backProjectAmount(reimburseApply);
            }
        }
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

        if (reimburseApply.getAmount().doubleValue() > 0) {
            ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
            queryBO.setCode(reimburseApply.getProjectCode());
            queryBO.setDeptId(reimburseApply.getDeptId());
            queryBO.setDate(reimburseApply.getCreateTime());
            // 校验当月项目预算
            BizProjectBudget bizProjectBudget = projectBudgetService.queryCurMonthBudget(queryBO);
            // 金额不足
            if (bizProjectBudget.getBalanceQuota().compareTo(reimburseApply.getAmount()) < 0) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,
                    "当月项目预算金额不足");
            }
            // 扣减预算 todo 扣减日志
            ProjectBudgetDecDTO budgetUpDTO = new ProjectBudgetDecDTO();
            budgetUpDTO.setId(bizProjectBudget.getId());
            budgetUpDTO.setBalanceQuota(
                bizProjectBudget.getBalanceQuota().subtract(reimburseApply.getAmount()));
            projectBudgetService.decrement(budgetUpDTO);
        }
        // 添加申请流程
        FlowInstanceDTO flowInstanceDTO = remiburseHelper.buildFlowInstanceDTO(reimburseApply);
        flowInstanceService.create(flowInstanceDTO);
        return ResultBean.success(1);
    }

    /***
     * 冲抵80 报销10 交款70
     * @param payDTO
     * @return
     */
    @Override
    public ResultBean<Integer> pay(ReimburseApplyPayDTO payDTO) {
        BizReimburseApply bizReimburseApplyS = bizReimburseApplyMapper.selectByPrimaryKey(
            payDTO.getId());
        // 幂等校验 有些状态不能付款
        LoanrPayStatusEnum statusEnum = LoanrPayStatusEnum.valueOfCode(
            bizReimburseApplyS.getPayStatus());
        if (LoanrPayStatusEnum.all_pay.getCode().equalsIgnoreCase(statusEnum.getCode())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,
                statusEnum.getDesc() + "该笔状态已付款");
        }

        SysUser sysUser = sysUserService.getSysUser(bizReimburseApplyS.getReimburseUser());

        // 费用报销详情
        BizReimburseCostDetailExample bizReimburseCostDetailExample = new BizReimburseCostDetailExample();
        bizReimburseCostDetailExample.createCriteria().andReimburseIdEqualTo(payDTO.getId());
        List<BizReimburseCostDetail> reimburseCostDetailList = bizReimburseCostDetailMapper.selectByExample(
            bizReimburseCostDetailExample);

        // 差旅报销详情
        //        BizReimburseTravelDetailExample bizReimburseTravelDetailExample = new BizReimburseTravelDetailExample();
        //        bizReimburseTravelDetailExample.createCriteria().andReimburseIdEqualTo(payDTO.getId());
        //        List<BizReimburseTravelDetail> reimburseTravelDetailList = bizReimburseTravelDetailMapper.selectByExample(bizReimburseTravelDetailExample);

        // 支付金额 -100 0 100 扣除冲抵之后的
        BigDecimal applySAmount = bizReimburseApplyS.getAmount();

        // 全部金额
        BigDecimal totalAmount = bizReimburseApplyS.getAmount();

        // 如果是借款冲抵
        if (StringUtils.equalsIgnoreCase("2", bizReimburseApplyS.getReimburseType())) {
            BizLoanApplyExample loanApplyExample = new BizLoanApplyExample();
            BizLoanApplyExample.Criteria loanApplyExampleCriteria = loanApplyExample.createCriteria();
            List<Integer> loanIdList = Arrays.stream(bizReimburseApplyS.getLoanIdStr().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
            loanApplyExampleCriteria.andIdIn(loanIdList);
//            loanApplyExampleCriteria.andPaymentAmountGreaterThan(BigDecimal.ZERO);
//            loanApplyExampleCriteria.andPayStatusEqualTo("3");

            List<BizLoanApply> bizLoanApplyList = bizLoanApplyMapper.selectByExample(
                    loanApplyExample).stream()
                .sorted(Comparator.comparing(l -> l.getAmount().subtract(l.getPaymentAmount())))
                .collect(Collectors.toList());

            BigDecimal offsetAmount = bizReimburseApplyS.getOffsetAmount();
            for (int i = 0; i < bizLoanApplyList.size(); i++) {
                BizLoanApply bizLoanApply = bizLoanApplyList.get(i);
                BigDecimal amount = bizLoanApply.getAmount();
                BigDecimal paymentAmount = bizLoanApply.getPaymentAmount();
                BigDecimal owingAmount = amount.subtract(paymentAmount);
                Pair<Integer, BigDecimal> pair = null;
                if (offsetAmount.compareTo(owingAmount) <= 0) {
                    offsetAmount = BigDecimal.ZERO;
                    pair = new Pair<>(bizLoanApply.getId(), owingAmount);
                } else {
                    offsetAmount = offsetAmount.subtract(owingAmount);
                    pair = new Pair<>(bizLoanApply.getId(), owingAmount);
                }
                ResultBean<Integer> integerResultBean = loanApplyService.repaymentAmount(
                    pair.getKey(), pair.getValue());
                if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                    integerResultBean.getCode())) {
                    log.error("报销支付：", integerResultBean.getMessage());
                    throw new BaseException(integerResultBean.getMessage());
                }
            }
        }

        // 记账
        if (bizReimburseApplyS.getAmount().compareTo(BigDecimal.ZERO) > 0) {
            // 支出记账（1現金 2銀行 3 其他貨幣）
            if (StringUtils.equalsIgnoreCase("1", payDTO.getBillNature())) {
                //   扣减日记账金额
                BizBillAddDTO bizBill = remiburseHelper.buildBizBillAddDTO(payDTO, applySAmount,
                    sysUser, bizReimburseApplyS);
                ResultBean save = billService.save(bizBill);
                if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                    save.getCode())) {
                    log.error("报销支付：", save.getMessage());
                    throw new BaseException(save.getMessage());
                }
            } else if (StringUtils.equalsIgnoreCase("2", payDTO.getBillNature())) {
                BizBankBillAddDTO bizBankBill = remiburseHelper.buildBizBankBillAddDTO(payDTO,
                    applySAmount, bizReimburseApplyS);
                ResultBean save = bankBillService.save(bizBankBill);
                if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                    save.getCode())) {
                    log.error("报销支付：", save.getMessage());
                    throw new BaseException(save.getMessage());
                }
            } else if (StringUtils.equalsIgnoreCase("3", payDTO.getBillNature())) {
                BizOtherBillAddDTO otherBillAddDTO = remiburseHelper.buildBizOtherBillAddDTO(payDTO,
                    bizReimburseApplyS);
                ResultBean save = otherBillService.save(otherBillAddDTO);
                if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                    save.getCode())) {
                    log.error("报销支付：", save.getMessage());
                    throw new BaseException(save.getMessage());
                }
            }
        } else {
            // 增加-银行日记账
            BizBankBillAddDTO bizBankBillAddDTO = remiburseHelper.buildBizBankBillAddDTO(
                bizReimburseApplyS, sysUser, payDTO);
            ResultBean save = bankBillService.save(bizBankBillAddDTO);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                save.getCode())) {
                log.error("报销支付：", save.getMessage());
                throw new BaseException(save.getMessage());
            }
        }

        // 扣款科目余额
        if (StringUtils.equalsIgnoreCase("2", bizReimburseApplyS.getType())) {
            reimburseCostDetailList.forEach(reimburseCostDetail -> {
                BizSubjectsBalanceUpDTO bizSubjects = remiburseHelper.buildBizSubjectsBalanceUpDTO(
                    bizReimburseApplyS, reimburseCostDetail);
                ResultBean resultBean = subjectBalanceService.decreaseAmount(bizSubjects);
                if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                    resultBean.getCode())) {
                    log.error("报销支付：", resultBean.getMessage());
                    throw new BaseException(resultBean.getMessage());
                }
            });
        } else {
            //reimburse_user
            BizSubjectsBalanceUpDTO bizSubjects = remiburseHelper.buildBizSubjectsBalanceUpDTO(
                bizReimburseApplyS, totalAmount);
            ResultBean resultBean = subjectBalanceService.decreaseAmount(bizSubjects);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                resultBean.getCode())) {
                log.error("报销支付：", resultBean.getMessage());
                throw new BaseException(resultBean.getMessage());
            }
        }

        // 财务管理->费用管理
        ExpensesDTO expensesDTO = remiburseHelper.buildExpensesDTO(bizReimburseApplyS, totalAmount,
            reimburseCostDetailList);
        ResultBean save = expensesService.save(expensesDTO);
        if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, save.getCode())) {
            log.error("报销支付：", save.getMessage());
            throw new BaseException(save.getMessage());
        }

        // update pay_status
        Integer update = bizReimburseApplyMapper.updateByPrimaryKeySelective(
            remiburseHelper.buildBizReimburseApply(payDTO));

        return ResultBean.success(update);
    }


    @Override
    public ResultBean<Integer> fallbackPayStatus(Integer id) {
        BizReimburseApply bizReimburseApplyS = bizReimburseApplyMapper.selectByPrimaryKey(id);
        // 幂等校验
        LoanrPayStatusEnum statusEnum = LoanrPayStatusEnum.valueOfCode(
            bizReimburseApplyS.getPayStatus());
        if (LoanrPayStatusEnum.un_pay.getCode().equalsIgnoreCase(statusEnum.getCode())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR,
                statusEnum.getDesc() + "该笔状态未付款");
        }

        SysUser sysUser = sysUserService.getSysUser(bizReimburseApplyS.getReimburseUser());

        // 费用报销详情
        BizReimburseCostDetailExample bizReimburseCostDetailExample = new BizReimburseCostDetailExample();
        bizReimburseCostDetailExample.createCriteria().andReimburseIdEqualTo(id);
        List<BizReimburseCostDetail> reimburseCostDetailList = bizReimburseCostDetailMapper.selectByExample(
            bizReimburseCostDetailExample);

        // 如果是借款冲抵
        if (StringUtils.equalsIgnoreCase("2", bizReimburseApplyS.getReimburseType())) {
            ResultBean<Integer> integerResultBean = loanApplyService.fallbackRepaymentAmount(
                bizReimburseApplyS.getLoanId(), bizReimburseApplyS.getOffsetAmount());
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                integerResultBean.getCode())) {
                log.error("回退 报销支付：", integerResultBean.getMessage());
                throw new BaseException(integerResultBean.getMessage());
            }
        }

        // 记账
        if (bizReimburseApplyS.getAmount().compareTo(BigDecimal.ZERO) > 0) {

            // 1現金
            BizBillExample bizBillExample = buildBizBillExample(bizReimburseApplyS, sysUser);
            List<BizBill> bizBillList = bizBillMapper.selectByExample(bizBillExample);

            // 2銀行
            BizBankBillExample bizBankBillExample = buildBizBankBillExample(bizReimburseApplyS);
            List<BizBankBill> bankBillList = bizBankBillMapper.selectByExample(bizBankBillExample);

            // 其他貨幣
            BizOtherBillExample bizOtherBillExample = buildBizOtherBillExample(bizReimburseApplyS);
            List<BizOtherBill> otherBillList = bizOtherBillMapper.selectByExample(
                bizOtherBillExample);

            if (bizBillList.size() + bankBillList.size() + otherBillList.size() != 1) {
                throw new BaseException("");
            }

            if (bizBillList.size() == 1) {
                //  回退  扣减日记账金额
                BizBillAddDTO bizBill = remiburseHelper.buildFallbackBizBillAddDTO(sysUser,
                    bizReimburseApplyS);
                ResultBean save = billService.save(bizBill);
                if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                    save.getCode())) {
                    log.error("回退报销支付：", save.getMessage());
                    throw new BaseException(save.getMessage());
                }
            } else if (bankBillList.size() == 1) {
                BizBankBillAddDTO bizBankBill = remiburseHelper.buildFallbackBizBankBillAddDTO(
                    bizReimburseApplyS);
                ResultBean save = bankBillService.save(bizBankBill);
                if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                    save.getCode())) {
                    log.error("回退报销支付：", save.getMessage());
                    throw new BaseException(save.getMessage());
                }
            } else if (otherBillList.size() == 1) {
                BizOtherBillAddDTO otherBillAddDTO = remiburseHelper.buildFallbackBizOtherBillAddDTO(
                    bizReimburseApplyS);
                ResultBean save = otherBillService.save(otherBillAddDTO);
                if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                    save.getCode())) {
                    log.error("回退报销支付：", save.getMessage());
                    throw new BaseException(save.getMessage());
                }
            }

        } else {
            // 增加-银行日记账
            BizBankBillAddDTO bizBankBillAddDTO = remiburseHelper.buildFallbackBizBankBillAddDTO(
                bizReimburseApplyS, sysUser);
            ResultBean save = bankBillService.save(bizBankBillAddDTO);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                save.getCode())) {
                log.error("回退报销支付：", save.getMessage());
                throw new BaseException(save.getMessage());
            }
        }

        // 扣款科目余额
        if (StringUtils.equalsIgnoreCase("2", bizReimburseApplyS.getType())) {
            reimburseCostDetailList.forEach(reimburseCostDetail -> {
                BizSubjectsBalanceUpDTO bizSubjects = remiburseHelper.buildBizSubjectsBalanceUpDTO(
                    bizReimburseApplyS, reimburseCostDetail);
                ResultBean resultBean = subjectBalanceService.increaseAmount(bizSubjects);
                if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                    resultBean.getCode())) {
                    log.error("回退报销支付：", resultBean.getMessage());
                    throw new BaseException(resultBean.getMessage());
                }
            });
        } else {
            //reimburse_user
            BizSubjectsBalanceUpDTO bizSubjects = remiburseHelper.buildBizSubjectsBalanceUpDTO(
                bizReimburseApplyS, bizReimburseApplyS.getAmount());
            ResultBean resultBean = subjectBalanceService.increaseAmount(bizSubjects);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code,
                resultBean.getCode())) {
                log.error("回退报销支付：", resultBean.getMessage());
                throw new BaseException(resultBean.getMessage());
            }
        }

        // 财务管理->费用管理
        ExpensesDTO expensesDTO = remiburseHelper.buildExpensesDTO(bizReimburseApplyS,
            bizReimburseApplyS.getAmount().negate(), reimburseCostDetailList);
        ResultBean save = expensesService.save(expensesDTO);
        if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, save.getCode())) {
            log.error("回退报销支付：", save.getMessage());
            throw new BaseException(save.getMessage());
        }

        // 回退项目预算
        if (StringUtils.isNotEmpty(bizReimburseApplyS.getProjectCode())
            && bizReimburseApplyS.getAmount().doubleValue() > 0) {
            remiburseHelper.backProjectAmount(bizReimburseApplyS);
        }
        // update pay_status
        Integer update = bizReimburseApplyMapper.updateByPrimaryKeySelective(
            remiburseHelper.buildFallbackBizReimburseApply(bizReimburseApplyS));

        return ResultBean.success(update);
    }


    private BizOtherBillExample buildBizOtherBillExample(BizReimburseApply bizReimburseApplyS) {
        BizOtherBillExample bizOtherBillExample = new BizOtherBillExample();
        BizOtherBillExample.Criteria criteria = bizOtherBillExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
        criteria.andTypeEqualTo("2");
        criteria.andCompanyEqualTo(bizReimburseApplyS.getPayCompany());
        criteria.andCertificateNumberEqualTo("");
        criteria.andDeptIdEqualTo(bizReimburseApplyS.getDeptId());
        criteria.andPayWayEqualTo(PayWayEnum.money_order_pay.getDesc());
        criteria.andPaymentTypeEqualTo(PayWayEnum.money_order_pay.getDesc());
        criteria.andPaymentEqualTo(bizReimburseApplyS.getAmount());
        criteria.andRemarkEqualTo("报销付款 " + bizReimburseApplyS.getAmount());
        criteria.andPayCompanyEqualTo(bizReimburseApplyS.getPayCompany());
        criteria.andPayAccountEqualTo(bizReimburseApplyS.getPayAccount());
        criteria.andCollectCompanyEqualTo(bizReimburseApplyS.getAccountName());
        return bizOtherBillExample;
    }

    private BizBankBillExample buildBizBankBillExample(BizReimburseApply bizReimburseApplyS) {
        BizBankBillExample bizBankBillExample = new BizBankBillExample();
        BizBankBillExample.Criteria criteria = bizBankBillExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
        criteria.andTypeEqualTo("2");
        criteria.andCompanyEqualTo(bizReimburseApplyS.getPayCompany());
        criteria.andCertificateNumberEqualTo("");
        criteria.andDeptIdEqualTo(bizReimburseApplyS.getDeptId());
        criteria.andPayWayEqualTo(PayWayEnum.check_pay.getDesc());
        criteria.andPaymentTypeEqualTo(PayWayEnum.check_pay.getDesc());
        criteria.andPaymentEqualTo(bizReimburseApplyS.getAmount());
        criteria.andRemarkEqualTo("报销付款 " + bizReimburseApplyS.getAmount());
        criteria.andPayCompanyEqualTo(bizReimburseApplyS.getPayCompany());
        criteria.andPayAccountEqualTo(bizReimburseApplyS.getPayAccount());
        criteria.andCollectCompanyEqualTo(bizReimburseApplyS.getAccountName());
        return bizBankBillExample;
    }

    private BizBillExample buildBizBillExample(BizReimburseApply bizReimburseApplyS,
        SysUser sysUser) {
        BizBillExample bizBillExample = new BizBillExample();
        BizBillExample.Criteria criteria = bizBillExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
        //criteria.andDEqualTo()
        criteria.andTypeEqualTo(BookingTypeEnum.cash_bill.getCode());
        criteria.andCertificateNumberEqualTo(bizReimburseApplyS.getPayAccount());
        criteria.andDeptIdEqualTo(bizReimburseApplyS.getDeptId() + "");
        criteria.andPaymentTypeEqualTo(PayWayEnum.cash_pay.getDesc());
        criteria.andPaymentEqualTo(bizReimburseApplyS.getAmount());
        criteria.andRemarkEqualTo("报销付款 " + bizReimburseApplyS.getAmount());
        criteria.andString1EqualTo(sysUser.getRealName());
        criteria.andString2EqualTo(bizReimburseApplyS.getPayCompany());
        return bizBillExample;
    }


}
