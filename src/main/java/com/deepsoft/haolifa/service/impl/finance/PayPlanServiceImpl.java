package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizPayPlanMapper;
import com.deepsoft.haolifa.model.domain.BizPayPlan;
import com.deepsoft.haolifa.model.domain.BizPayPlanExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanAddDTO;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanRQDTO;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanSummaryRQDTO;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanSummaryRSDTO;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.PayPlanService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class PayPlanServiceImpl implements PayPlanService {

    @Autowired
    private BizPayPlanMapper bizPayPlanMapper;
    @Autowired
    private SysUserService sysUserService;

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
    public ResultBean update(BizPayPlan billBank) {
        billBank.setUpdateTime(new Date());
        billBank.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizPayPlanMapper.updateByPrimaryKeySelective(billBank);
        return ResultBean.success(update);
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
        //数据状态
        if (StringUtils.isNotEmpty(model.getDataStatus())) {
            criteria.andDataStatusEqualTo(model.getDataStatus());
        }

        bizPayPlanExample.setOrderByClause("id desc");
        Page<BizPayPlan> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizPayPlanMapper.selectByExample(bizPayPlanExample);
            });
        PageDTO<BizPayPlan> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean<BizPayPlanSummaryRSDTO> getPayPlanSummaryList(BizPayPlanSummaryRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
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
        if (StringUtils.isNotEmpty(model.getApplyPayCompany())) {
            criteria.andApplyPayCompanyLike(model.getApplyPayCompany());
        }

        // 付款方式 ==
        if (StringUtils.isNotEmpty(model.getPayWay())) {
            criteria.andPayWayEqualTo(model.getPayWay());
        }

        //付款状态
        if (StringUtils.isNotEmpty(model.getStatus())) {
            criteria.andStatusEqualTo(model.getStatus());
        }
        //数据状态
        if (StringUtils.isNotEmpty(model.getDataStatus())) {
            criteria.andDataStatusEqualTo(model.getDataStatus());
        }

        bizPayPlanExample.setOrderByClause("id desc");

        Page<BizPayPlan> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizPayPlanMapper.selectByExample(bizPayPlanExample);
            });
        PageDTO<BizPayPlan> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }


}
