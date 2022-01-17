package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizReimburseApplyMapper;
import com.deepsoft.haolifa.model.domain.BizLoanApply;
import com.deepsoft.haolifa.model.domain.BizReimburseApply;
import com.deepsoft.haolifa.model.domain.BizReimburseApplyExample;
import com.deepsoft.haolifa.model.dto.FlowInstanceDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.ReimburseApplyAddDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.ReimburseApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.ReimburseApplyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.ReimburseApplyUpDTO;
import com.deepsoft.haolifa.service.FlowInstanceService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.ReimburseApplyService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.deepsoft.haolifa.constant.CommonEnum.FlowId.LOAN_APP_FLOW;
import static com.deepsoft.haolifa.constant.CommonEnum.FlowId.REIMBURSE_APP_FLOW;
import static com.deepsoft.haolifa.constant.CommonEnum.FormType.LOAN_APP_TYPE;
import static com.deepsoft.haolifa.constant.CommonEnum.FormType.REIMBURSE_APP_TYPE;

@Service
@Slf4j
public class ReimburseApplyServiceImpl implements ReimburseApplyService {

    @Autowired
    private BizReimburseApplyMapper bizReimburseApplyMapper;
    @Autowired
    private SysUserService sysUserService;
    @Lazy
    @Autowired
    private FlowInstanceService flowInstanceService;

    @Override
    public ResultBean save(ReimburseApplyAddDTO model) {
        log.info("BankBillService saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }

        BizReimburseApply reimburseApply = new BizReimburseApply();
        BeanUtils.copyProperties(model, reimburseApply);

        reimburseApply.setCreateTime(new Date());
        reimburseApply.setUpdateTime(new Date());
        reimburseApply.setCreateUser(sysUserService.selectLoginUser().getId());
        reimburseApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        int insertId = bizReimburseApplyMapper.insertSelective(reimburseApply);
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
    public ResultBean getInfo(Integer id) {
        BizReimburseApply reimburseApply = bizReimburseApplyMapper.selectByPrimaryKey(id);
        return ResultBean.success(reimburseApply);
    }

    @Override
    public ResultBean getList(ReimburseApplyRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizReimburseApplyExample reimburseApplyExample = new BizReimburseApplyExample();
        BizReimburseApplyExample.Criteria criteria = reimburseApplyExample.createCriteria();
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

        reimburseApplyExample.setOrderByClause("id desc");
        Page<BizReimburseApply> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizReimburseApplyMapper.selectByExample(reimburseApplyExample);
            });
        PageDTO<ReimburseApplyRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);


        List<ReimburseApplyRSDTO> reimburseApplyRSDTOList = pageData.getResult().stream()
            .map(reimburseApply -> {
                ReimburseApplyRSDTO reimburseApplyRSDTO = new ReimburseApplyRSDTO();
                BeanUtils.copyProperties(reimburseApply, reimburseApplyRSDTO);
                return reimburseApplyRSDTO;
            })
            .collect(Collectors.toList());
        pageDTO.setList(reimburseApplyRSDTOList);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean approve(Integer id) {

        // 查询&修改 付款申请
        BizReimburseApply reimburseApply = bizReimburseApplyMapper.selectByPrimaryKey(id);
        //审核状态：
        reimburseApply.setApplyStatus("1");
        reimburseApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        reimburseApply.setUpdateTime(new Date());
        bizReimburseApplyMapper.updateByPrimaryKeySelective(reimburseApply);


        // 添加申请流程
        FlowInstanceDTO flowInstanceDTO = buildFlowInstanceDTO(reimburseApply);
        flowInstanceService.create(flowInstanceDTO);
        return ResultBean.success(1);
    }

    private FlowInstanceDTO buildFlowInstanceDTO(BizReimburseApply reimburseApply ) {
        FlowInstanceDTO flowInstanceDTO = new FlowInstanceDTO();
        flowInstanceDTO.setFlowId(REIMBURSE_APP_FLOW.id);
        flowInstanceDTO.setSummary("报销申请审批");
        flowInstanceDTO.setFormType(REIMBURSE_APP_TYPE.code);
        flowInstanceDTO.setFormNo(reimburseApply.getSerialNo());
        flowInstanceDTO.setFormId(reimburseApply.getId());
        return flowInstanceDTO;
    }
}
