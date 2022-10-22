package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.enums.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.finance.FileUrlDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.*;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetQueryBO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetUpDTO;
import com.deepsoft.haolifa.service.FlowInstanceService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.*;
import com.deepsoft.haolifa.service.impl.finance.helper.LoanApplyHelper;
import com.deepsoft.haolifa.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LoanApplyServiceImpl implements LoanApplyService {

    @Resource
    private BizLoanApplyMapper bizLoanApplyMapper;
    @Resource
    private SysUserService sysUserService;
    @Lazy
    @Resource
    private FlowInstanceService flowInstanceService;

    @Resource
    private SysDepartmentMapper departmentMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private BillService billService;
    @Resource
    private BankBillService bankBillService;
    @Resource
    private OtherBillService otherBillService;

    @Resource
    private PayUserMapper payUserMapper;

    @Resource
    private ProjectBudgetService projectBudgetService;


    @Resource
    private BizProjectBudgetMapper bizProjectBudgetMapper;

    @Resource
    private BizPaymentHistoryMapper bizPaymentHistoryMapper;

    @Resource
    private LoanApplyHelper loanApplyHelper;


    @Override
    public ResultBean save(LoanApplyAddDTO model) {
//        log.info("BankBillService saveInfo start|{}", JSONObject.toJSON(model));
        ResultBean<Object> PARAM_ERROR = loanApplyHelper.validate(model);
        if (PARAM_ERROR != null) {
            return PARAM_ERROR;
        }
        CustomUser customUser = sysUserService.selectLoginUser();
        SysUser sysUser = sysUserService.getSysUser(customUser.getId());
        PayUser payUser = payUserMapper.selectByPhoneOrIdCard(sysUser.getPhone(), sysUser.getIdCard());

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
        if (bizProjectBudget.getBalanceQuota().compareTo(model.getAmount()) < 0) {
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


        //上传到7牛文件服务器
        String fileUrl = "";
        String fileName = "";
        if (CollectionUtil.isNotEmpty(model.getFileUrlList())) {
//            List<String> fileUrlList = new ArrayList<>();
//            for (FileDTO fileDTO : model.getFileDTOList()) {
//                fileUrlList.add(QiniuUtil.uploadFile(fileDTO.getBase64Source(), fileDTO.getFileName()));
//            }
            fileUrl = JSON.toJSONString(model.getFileUrlList());
        }
        loanApply.setFileUrl(fileUrl);
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


        if (StringUtils.isNotEmpty(selectByPrimaryKey.getProjectCode())) {
            ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
            queryBO.setCode(selectByPrimaryKey.getProjectCode());
            queryBO.setDeptId(selectByPrimaryKey.getDeptId());
            queryBO.setDate(new Date());
            // 校验当月项目预算
            BizProjectBudget bizProjectBudget = projectBudgetService.queryCurMonthBudget(queryBO);

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

        //上传到7牛文件服务器
        if (CollectionUtil.isNotEmpty(loanApplyUpDTO.getFileUrlList())) {
            String fileUrl = "";
//            List<String> fileUrlList = new ArrayList<>();
//            for (FileDTO fileDTO : loanApplyUpDTO.getFileDTOList()) {
//                fileUrlList.add(QiniuUtil.uploadFile(fileDTO.getBase64Source(), fileDTO.getFileName()));
//            }
            fileUrl = JSON.toJSONString(loanApplyUpDTO.getFileUrlList());

            loanApply.setFileUrl(fileUrl);
        }
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

        if (StringUtils.isNotEmpty(loanApplyRSDTO.getProjectCode())) {
            BizProjectBudget projectBudget = bizProjectBudgetMapper.getProjectBudgetByCode(loanApplyRSDTO.getProjectCode());
            loanApplyRSDTO.setProjectCodeName(projectBudget.getName());
        }

        if (StringUtils.isNotEmpty(loanApply.getFileUrl())) {
            loanApplyRSDTO.setFileUrlList(JSON.parseArray(loanApply.getFileUrl(), FileUrlDTO.class));
        } else {
            loanApplyRSDTO.setFileUrlList(new ArrayList<>());
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

        // 1 待审批 2 审批中 3 付款中 4 审批不通过
        if (StringUtils.isNotEmpty(model.getApplyStatus())) {
            criteria.andApplyStatusIn(Arrays.asList(model.getApplyStatus().split(",").clone()));
        }

        // 借款审批列表 todo 是否只展示自己申请的记录
        if (StringUtils.equalsIgnoreCase("1", type) && !lookAll) {
            //审核状态
            criteria.andCreateUserEqualTo(sysUserService.selectLoginUser().getId());
            // 出纳付款列表
        } else if (StringUtils.equalsIgnoreCase("2", type)) {
            //审核状态
            // 2 审批中 3 付款中 4 审批不通过 5 付款完成
            criteria.andApplyStatusIn(Arrays.asList("3", "5"));
        }


        // 状态 1 代办 2 已办
        if (model.getStatus() != null) {
//            criteria.andCertificateNumberEqualTo(model.getCertificateNumber());
        }
        //借款部门名称
        if (StringUtils.isNotEmpty(model.getDeptName())) {
            SysDepartmentExample departmentExample = new SysDepartmentExample();
            departmentExample.createCriteria().andDeptNameLike("%" + model.getDeptName() + "%");
            List<SysDepartment> sysDepartments = departmentMapper.selectByExample(departmentExample);
            if (CollectionUtil.isNotEmpty(sysDepartments)) {
                List<Integer> integerList = sysDepartments.stream().map(SysDepartment::getId).collect(Collectors.toList());
                criteria.andDeptIdIn(integerList);
            }
        }
        //借款人名称
        if (StringUtils.isNotEmpty(model.getLoanUserName())) {
            SysUserExample sysUserExample = new SysUserExample();
            sysUserExample.createCriteria().andUsernameLike("%" + model.getLoanUserName() + "%");
            List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
            List<Integer> idList = sysUsers.stream()
                .map(SysUser::getId)
                .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(idList)) {
                criteria.andLoanUserIn(idList);
            }
        }

        //付款单位
        if (StringUtils.isNotEmpty(model.getPayCompany())) {
            criteria.andPayCompanyLike("%" + model.getPayCompany() + "%");
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
            projectCodeMap = bizProjectBudgetMapper.selectByExample(bizProjectBudgetExample).stream()
                .collect(Collectors.toMap(BizProjectBudget::getCode, BizProjectBudget::getName, (a, b) -> a));
        }


        Map<String, String> finalProjectCodeMap = projectCodeMap;
        List<LoanApplyRSDTO> loanApplyRSDTOList = pageData.getResult().stream()
            .map(loanApply -> {
                LoanApplyRSDTO loanApplyRSDTO = loanApplyHelper.convertLoanApplyRSDTO(finalProjectCodeMap, sysDepartmentMap, iscn, finalSysUserMap, loanApply);
                if (StringUtils.isNotEmpty(loanApply.getFileUrl())) {
                    loanApplyRSDTO.setFileUrlList(JSON.parseArray(loanApply.getFileUrl(), FileUrlDTO.class));
                } else {
                    loanApplyRSDTO.setFileUrlList(new ArrayList<>());
                }
                return loanApplyRSDTO;
            })
            .collect(Collectors.toList());
        pageDTO.setList(loanApplyRSDTOList);
        return ResultBean.success(pageDTO);
    }


    @Override
    public ResultBean<List<LoanApplyRSDTO>> getLoanApplyList(LoanApplyRQDTO model) {
        BizLoanApplyExample loanApplyExample = loanApplyHelper.buildBizLoanApplyExample(model);
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

        List<String> projectCodeList = bizLoanApplyList.stream()
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
            projectCodeMap = bizProjectBudgetMapper.selectByExample(bizProjectBudgetExample).stream()
                .collect(Collectors.toMap(BizProjectBudget::getCode, BizProjectBudget::getName, (a, b) -> a));
        }

        Map<String, String> finalProjectCodeMap = projectCodeMap;
        List<LoanApplyRSDTO> loanApplyRSDTOList = bizLoanApplyList.stream()
            .map(loanApply -> {
                LoanApplyRSDTO loanApplyRSDTO = loanApplyHelper.convertLoanApplyRSDTO(finalProjectCodeMap, sysDepartmentMap, iscn, finalSysUserMap, loanApply);
                return loanApplyRSDTO;
            })
            .filter(dto -> dto.getOwedAmount().compareTo(BigDecimal.ZERO) > 0)
            .collect(Collectors.toList());

        return ResultBean.success(loanApplyRSDTOList);
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
        if (ReimburseApplyStatusEnum.APPROVAL_FAILED.getCode().equalsIgnoreCase(auditResult.getCode())) {
            if (StringUtils.isNotEmpty(loanApplyS.getProjectCode())) {
                ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
                queryBO.setCode(loanApplyS.getProjectCode());
                queryBO.setDeptId(loanApplyS.getDeptId());
                queryBO.setDate(new Date());
                // 校验当月项目预算
                BizProjectBudget bizProjectBudget = projectBudgetService.queryCurMonthBudget(queryBO);

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
        queryBO.setDate(new Date());
        // 校验当月项目预算
        BizProjectBudget bizProjectBudget = projectBudgetService.queryCurMonthBudget(queryBO);
        // 金额不足
        if (bizProjectBudget.getBalanceQuota().compareTo(selectByPrimaryKey.getAmount()) < 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "当月项目预算金额不足");
        }
        // 扣减预算 todo 扣减日志
        ProjectBudgetUpDTO budgetUpDTO = new ProjectBudgetUpDTO();
        budgetUpDTO.setId(bizProjectBudget.getId());
        budgetUpDTO.setBalanceQuota(bizProjectBudget.getBalanceQuota().subtract(selectByPrimaryKey.getAmount()));
        projectBudgetService.update(budgetUpDTO);


        BizLoanApply bizLoanApply = bizLoanApplyMapper.selectByPrimaryKey(id);
        // 添加申请流程
        FlowInstanceDTO flowInstanceDTO = loanApplyHelper.buildFlowInstanceDTO(bizLoanApply);
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

        // 记账方式（1現金 2銀行 3 其他貨幣）
        if (StringUtils.equalsIgnoreCase("1", loanApplyPayDTO.getBillNature())) {
            BizBillAddDTO bizBill = loanApplyHelper.buildBizBillAddDTO(loanApplyPayDTO, selectByPrimaryKey, sysUser);
            ResultBean save = billService.save(bizBill);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, save.getCode())) {
                throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
            }
        } else if (StringUtils.equalsIgnoreCase("2", loanApplyPayDTO.getBillNature())) {
            BizBankBillAddDTO bizBankBill = loanApplyHelper.buildBizBankBillAddDTO(loanApplyPayDTO, selectByPrimaryKey, sysUser);
            ResultBean save = bankBillService.save(bizBankBill);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, save.getCode())) {
                throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
            }
        } else if (StringUtils.equalsIgnoreCase("3", loanApplyPayDTO.getBillNature())) {
            BizOtherBillAddDTO otherBillAddDTO = loanApplyHelper.buildBizOtherBillAddDTO(loanApplyPayDTO, selectByPrimaryKey, sysUser);
            ResultBean save = otherBillService.save(otherBillAddDTO);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, save.getCode())) {
                throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
            }
        }

        BizLoanApply loanApply = loanApplyHelper.buildBizLoanApply(loanApplyPayDTO);
        int update = bizLoanApplyMapper.updateByPrimaryKeySelective(loanApply);
        return ResultBean.success(update);
    }


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
        BizPaymentHistory paymentHistory = loanApplyHelper.buildBizPaymentHistory(loanId, offsetAmount, bizLoanApply);
        bizPaymentHistoryMapper.insertSelective(paymentHistory);
        // 借款
        BizLoanApply bizLoanApplyUp = loanApplyHelper.buildBizLoanApply(bizLoanApply, addAmount);
        bizLoanApplyMapper.updateByPrimaryKeySelective(bizLoanApplyUp);
        return ResultBean.success(1);
    }


}
