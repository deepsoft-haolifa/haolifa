package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.collection.CollectionUtil;
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
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyInfoRSDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.*;
import com.deepsoft.haolifa.service.FlowInstanceService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.ReimburseApplyService;
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
    private SysUserMapper sysUserMapper;

    //
    @Override
    public ResultBean save(ReimburseApplyAddDTO model) {
        log.info("BankBillService saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        // 1 添加主数据

        // todo 如果使用了借款冲抵


        BizReimburseApply reimburseApply = new BizReimburseApply();
        BeanUtils.copyProperties(model, reimburseApply);
        String ser = "FP" + DateUtils.dateTimeNow() + RandomStringUtils.randomNumeric(3);
        reimburseApply.setSerialNo(ser);
        reimburseApply.setCreateTime(new Date());
        reimburseApply.setUpdateTime(new Date());
        reimburseApply.setCreateUser(sysUserService.selectLoginUser().getId());
        reimburseApply.setUpdateUser(sysUserService.selectLoginUser().getId());
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
                            record.setCreateUser(sysUserService.selectLoginUser().getId());
                            record.setUpdateUser(sysUserService.selectLoginUser().getId());
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
                            record.setCreateUser(sysUserService.selectLoginUser().getId());
                            record.setUpdateUser(sysUserService.selectLoginUser().getId());
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
    public ResultBean<ReimburseApplyInfoRSDTO> getInfo(Integer id) {
        BizReimburseApply reimburseApply = bizReimburseApplyMapper.selectByPrimaryKey(id);

        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));

        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andIdEqualTo(reimburseApply.getReimburseUser());
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        Map<Integer, SysUser> finalSysUserMap = sysUsers.stream().collect(Collectors.toMap(SysUser::getId, Function.identity()));

        ReimburseApplyInfoRSDTO loanApplyRSDTO = new ReimburseApplyInfoRSDTO();
        BeanUtils.copyProperties(reimburseApply, loanApplyRSDTO);
        SysDepartment sysDepartment = sysDepartmentMap.get(reimburseApply.getDeptId());
        if (sysDepartment != null) {
            loanApplyRSDTO.setDeptName(sysDepartment.getDeptName());
        }
        SysUser sysUser = finalSysUserMap.get(reimburseApply.getReimburseUser());
        if (sysUser != null) {
            loanApplyRSDTO.setReimburseUserName(sysUser.getRealName());
        }
        ReimburseApplyStatusEnum applyStatusEnum = ReimburseApplyStatusEnum.valueOfCode(reimburseApply.getApplyStatus());

        loanApplyRSDTO.setApplyStatusCN(applyStatusEnum == null ?
            ReimburseApplyStatusEnum.PENDING_APPROVAL.getDesc() : applyStatusEnum.getDesc());

        ReimbursePayStatusEnum payStatusEnum = ReimbursePayStatusEnum.valueOfCode(reimburseApply.getPayStatus());
        loanApplyRSDTO.setPayStatusCN(payStatusEnum == null ? ReimbursePayStatusEnum.un_pay.getDesc() : payStatusEnum.getDesc());

        return ResultBean.success(loanApplyRSDTO);
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


        String type = model.getType();
        // 借款审批列表
        if (StringUtils.equalsIgnoreCase("1", type)) {
            criteria.andCreateUserEqualTo(sysUserService.selectLoginUser().getId());
        }

        // 状态 1 代办 2 已办
        if (model.getType() != null) {
            criteria.andTypeEqualTo(model.getType());
        }


        //借款部门名称
        if (model.getDeptName() != null) {
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
        if (model.getSerialNo() != null) {
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


        List<ReimburseApplyRSDTO> reimburseApplyRSDTOList = pageData.getResult().stream()
            .map(reimburseApply -> {
                ReimburseApplyRSDTO reimburseApplyRSDTO = new ReimburseApplyRSDTO();
                BeanUtils.copyProperties(reimburseApply, reimburseApplyRSDTO);

                ReimburseApplyStatusEnum applyStatusEnum = ReimburseApplyStatusEnum.valueOfCode(reimburseApply.getApplyStatus());

                reimburseApplyRSDTO.setApplyStatusCN(applyStatusEnum == null ?
                    LoanApplyStatusEnum.PENDING_APPROVAL.getDesc() : applyStatusEnum.getDesc());

                ReimbursePayStatusEnum payStatusEnum = ReimbursePayStatusEnum.valueOfCode(reimburseApply.getPayStatus());
                reimburseApplyRSDTO.setPayStatusCN(payStatusEnum == null ? LoanrPayStatusEnum.un_pay.getDesc() : payStatusEnum.getDesc());

                ReimburseTypeEnum reimburseTypeEnum = ReimburseTypeEnum.valueOfCode(reimburseApply.getType());
                reimburseApplyRSDTO.setTypeCN(payStatusEnum == null ? ReimburseTypeEnum.travle.getDesc() : reimburseTypeEnum.getDesc());

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

        // 有些状态不能付款
        LoanrPayStatusEnum statusEnum = LoanrPayStatusEnum.valueOfCode(bizReimburseApplyS.getPayStatus());
        if (!LoanrPayStatusEnum.all_pay.getCode().equalsIgnoreCase(statusEnum.getCode())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, statusEnum.getDesc() + "该笔状态已付款");
        }

//        SysUser sysUser = sysUserService.getSysUser(selectByPrimaryKey.getLoanUser());
//        // todo 扣减日记账金额
//        BizBillAddDTO bizBill = new BizBillAddDTO();
//        bizBill.setType(BookingTypeEnum.cash_bill.getCode());
//        bizBill.setCertificateNumber(loanApplyPayDTO.getPayAccount());
//        bizBill.setD(new Date());
//        bizBill.setPaymentType(PayWayEnum.cash_pay.getDesc());
//        bizBill.setPayment(selectByPrimaryKey.getAmount());
//        bizBill.setRemark("借款付款 "+selectByPrimaryKey.getAmount());
//        bizBill.setString1(sysUser.getRealName());
//        bizBill.setString2(loanApplyPayDTO.getPayCompany());
//        ResultBean save = billService.save(bizBill);

        BizReimburseApply apply = new BizReimburseApply();
        BeanUtils.copyProperties(payDTO, apply);
        apply.setPayStatus(LoanrPayStatusEnum.all_pay.getCode());
        apply.setPayTime(new Date());
        apply.setUpdateTime(new Date());
        apply.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizReimburseApplyMapper.updateByPrimaryKeySelective(apply);
        return ResultBean.success(update);
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
