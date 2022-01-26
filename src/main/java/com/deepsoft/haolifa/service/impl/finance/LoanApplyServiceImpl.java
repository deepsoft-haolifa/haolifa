package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizLoanApplyMapper;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.dao.repository.SysUserMapper;
import com.deepsoft.haolifa.enums.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.FlowInstanceDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.loanapply.*;
import com.deepsoft.haolifa.service.FlowInstanceService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.LoanApplyService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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

    @Override
    public ResultBean save(LoanApplyAddDTO model) {
        log.info("BankBillService saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        // todo 校验金额是否满足


        BizLoanApply loanApply = new BizLoanApply();
        BeanUtils.copyProperties(model, loanApply);
        loanApply.setApplyStatus(LoanApplyStatusEnum.PENDING_APPROVAL.getCode());
        loanApply.setPayStatus(LoanrPayStatusEnum.un_pay.getCode());
        loanApply.setLoanUser(sysUserService.selectLoginUser().getId());
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
    public ResultBean getInfo(Integer id) {
        BizLoanApply loanApply = bizLoanApplyMapper.selectByPrimaryKey(id);
        return ResultBean.success(loanApply);
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

        Map<Integer, SysUser> finalSysUserMap = sysUserMap;
        List<LoanApplyRSDTO> loanApplyRSDTOList = pageData.getResult().stream()
            .map(loanApply -> {
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

                LoanBillTypeEnum billTypeEnum = LoanBillTypeEnum.valueOfCode(loanApply.getBillNature());
                loanApplyRSDTO.setBillNatureCN(billTypeEnum == null ? null : billTypeEnum.getDesc());

                LoanrPayStatusEnum payStatusEnum = LoanrPayStatusEnum.valueOfCode(loanApply.getPayStatus());
                loanApplyRSDTO.setPayStatusCN(payStatusEnum == null ? LoanrPayStatusEnum.un_pay.getDesc() : payStatusEnum.getDesc());

                return loanApplyRSDTO;
            })
            .collect(Collectors.toList());
        pageDTO.setList(loanApplyRSDTOList);
        return ResultBean.success(pageDTO);
    }



    @Override
    public int auditReplaceMaterial(String item_id, LoanApplyStatusEnum auditResult) {
        BizLoanApplyExample loanApplyExample = new BizLoanApplyExample();
        BizLoanApplyExample.Criteria criteria = loanApplyExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
        criteria.andSerialNoEqualTo(item_id);
        List<BizLoanApply> bizLoanApplies = bizLoanApplyMapper.selectByExample(loanApplyExample);

        BizLoanApply  loanApplyS = bizLoanApplies.get(0);
        if (loanApplyS == null){
            log.error("auditReplaceMaterial 无该条记录,id:{}",item_id);
            return 0;
        }

        BizLoanApply loanApply = new BizLoanApply();
        loanApply.setApplyStatus(auditResult.getCode());
        loanApply.setUpdateTime(new Date());
        loanApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizLoanApplyMapper.updateByPrimaryKeySelective(loanApply);
        return 1;
    }

    ;
    @Override
    public ResultBean approve(Integer id) {
        BizLoanApply loanApply = new BizLoanApply();
        loanApply.setId(id);
        loanApply.setApplyStatus(LoanApplyStatusEnum.PENDING_APPROVAL.getCode());
        loanApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        loanApply.setUpdateTime(new Date());

        bizLoanApplyMapper.updateByPrimaryKeySelective(loanApply);

        // 添加申请流程
        FlowInstanceDTO flowInstanceDTO = buildFlowInstanceDTO(loanApply);
        flowInstanceService.create(flowInstanceDTO);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean pay(LoanApplyPayDTO loanApplyPayDTO) {
        BizLoanApply selectByPrimaryKey = bizLoanApplyMapper.selectByPrimaryKey(loanApplyPayDTO.getId());

        // 有些状态不能付款
        LoanrPayStatusEnum statusEnum = LoanrPayStatusEnum.valueOfCode(selectByPrimaryKey.getPayStatus());
        if (!LoanrPayStatusEnum.all_pay.getCode().equalsIgnoreCase(statusEnum.getCode())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, statusEnum.getDesc() + "该笔状态已付款");
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

    private FlowInstanceDTO buildFlowInstanceDTO(BizLoanApply loanApply) {
        FlowInstanceDTO flowInstanceDTO = new FlowInstanceDTO();
        flowInstanceDTO.setFlowId(LOAN_APP_FLOW.id);
        flowInstanceDTO.setSummary("借款申请审批");
        flowInstanceDTO.setFormType(LOAN_APP_TYPE.code);
        flowInstanceDTO.setFormNo(loanApply.getSerialNo());
        flowInstanceDTO.setFormId(loanApply.getId());
        return flowInstanceDTO;
    }
}
