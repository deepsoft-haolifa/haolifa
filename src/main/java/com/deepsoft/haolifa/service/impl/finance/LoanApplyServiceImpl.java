package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizLoanApplyMapper;
import com.deepsoft.haolifa.model.domain.BizLoanApply;
import com.deepsoft.haolifa.model.domain.BizLoanApplyExample;
import com.deepsoft.haolifa.model.dto.FlowInstanceDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyAddDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyUpDTO;
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

import java.util.Date;
import java.util.List;
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

    @Override
    public ResultBean save(LoanApplyAddDTO model) {
        log.info("BankBillService saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }

        BizLoanApply loanApply = new BizLoanApply();
        BeanUtils.copyProperties(model, loanApply);

        loanApply.setCreateTime(new Date());
        loanApply.setUpdateTime(new Date());
        loanApply.setCreateUser(sysUserService.selectLoginUser().getId());
        loanApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        int insertId = bizLoanApplyMapper.insertSelective(loanApply);
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean delete(Integer id) {
        //int delete = bizLoanApplyMapper.deleteByPrimaryKey(id);

        BizLoanApply billBank = new BizLoanApply();
        billBank.setId(id);
        billBank.setDelFlag("1");
        billBank.setUpdateTime(new Date());
        billBank.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizLoanApplyMapper.updateByPrimaryKeySelective(billBank);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean update(LoanApplyUpDTO loanApplyUpDTO) {

        BizLoanApply loanApply = new BizLoanApply();
        BeanUtils.copyProperties(loanApplyUpDTO, loanApply);
        BizLoanApply selectByPrimaryKey = bizLoanApplyMapper.selectByPrimaryKey(loanApplyUpDTO.getId());

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
    public ResultBean getList(LoanApplyRQDTO model) {
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


        List<LoanApplyRSDTO> loanApplyRSDTOList = pageData.getResult().stream()
            .map(loanApply -> {
                LoanApplyRSDTO loanApplyRSDTO = new LoanApplyRSDTO();
                BeanUtils.copyProperties(loanApply, loanApplyRSDTO);
                return loanApplyRSDTO;
            })
            .collect(Collectors.toList());
        pageDTO.setList(loanApplyRSDTOList);
        return ResultBean.success(pageDTO);
    }


    @Override
    public ResultBean approve(Integer id) {

        // 查询&修改 付款申请
        BizLoanApply loanApply = bizLoanApplyMapper.selectByPrimaryKey(id);
        //审核状态：1 待审批 2 审批中 3 付款中 4 审批不通过 5 付款完成
        loanApply.setApplyStatus("1");
        loanApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        loanApply.setUpdateTime(new Date());
        bizLoanApplyMapper.updateByPrimaryKeySelective(loanApply);


        // 添加申请流程
        FlowInstanceDTO flowInstanceDTO = buildFlowInstanceDTO(loanApply);
        flowInstanceService.create(flowInstanceDTO);
        return ResultBean.success(1);
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
