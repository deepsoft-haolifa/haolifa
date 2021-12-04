package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizBankBillMapper;
import com.deepsoft.haolifa.model.domain.BizBankBill;
import com.deepsoft.haolifa.model.domain.BizBankBillExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillDTO;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.BankBillService;
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
public class BankBillServiceImpl implements BankBillService {

    @Autowired
    private BizBankBillMapper bizBankBillMapper;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public ResultBean save(BizBankBillAddDTO model) {
        log.info("BankBillService saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        BizBankBill billBank = new BizBankBill();
        BeanUtils.copyProperties(model, billBank);
        billBank.setCreateTime(new Date());
        billBank.setUpdateTime(new Date());
        billBank.setCreateUser(sysUserService.selectLoginUser().getId());
        billBank.setUpdateUser(sysUserService.selectLoginUser().getId());
        int insertId = bizBankBillMapper.insertSelective(billBank);
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean delete(Integer id) {
        //int delete = bizBankBillMapper.deleteByPrimaryKey(id);

        BizBankBill billBank = new BizBankBill();
        billBank.setId(id);
        billBank.setDelFlag("1");
        billBank.setUpdateTime(new Date());
        billBank.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizBankBillMapper.updateByPrimaryKeySelective(billBank);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean update(BizBankBill billBank) {
        billBank.setUpdateTime(new Date());
        billBank.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizBankBillMapper.updateByPrimaryKeySelective(billBank);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        BizBankBill billBank = bizBankBillMapper.selectByPrimaryKey(id);
        return ResultBean.success(billBank);
    }

    @Override
    public ResultBean getList(BizBankBillDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizBankBillExample bizBankBillExample = new BizBankBillExample();
        BizBankBillExample.Criteria criteria = bizBankBillExample.createCriteria();
        criteria.andDelFlagEqualTo("0");




        // 凭证号 ==
        if (StringUtils.isNotEmpty(model.getCertificateNumber())) {
            criteria.andCertificateNumberEqualTo(model.getCertificateNumber());
        }
        //收付款银行：下拉选框
        if (StringUtils.isNotEmpty(model.getPayAccount())) {
            criteria.andPayAccountEqualTo(model.getPayAccount());
        }
        //记账类别：下拉选框 收款 付款
        if (StringUtils.isNotEmpty(model.getType())) {
            criteria.andTypeEqualTo(model.getType());
        }
        //开始时间
        //结束时间
        if (model.getOperateDateStart()!=null && model.getOperateDateEnd()!=null) {
            // 区间
            criteria.andOperateDateBetween(model.getOperateDateStart(),model.getOperateDateEnd());
        }else if (model.getOperateDateStart()!=null ) {
            // 大于
            criteria.andOperateDateGreaterThanOrEqualTo(model.getOperateDate());
        }else if (model.getOperateDateEnd()!=null ) {
            // 小于
            criteria.andOperateDateLessThanOrEqualTo(model.getOperateDateEnd());
        }

        //收款单位：like
        if (StringUtils.isNotEmpty(model.getCollectCompany())) {
            criteria.andCollectCompanyLike(model.getCollectCompany());
        }
        //付款单位：like
        if (StringUtils.isNotEmpty(model.getPaymentType())) {
            criteria.andPaymentTypeEqualTo(model.getPaymentType());
        }

        // 付款类型 ==
        if (StringUtils.isNotEmpty(model.getPaymentType())) {
            criteria.andPaymentTypeEqualTo(model.getPaymentType());
        }

        bizBankBillExample.setOrderByClause("id desc");
        Page<BizBankBill> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizBankBillMapper.selectByExample(bizBankBillExample);
            });
        PageDTO<BizBankBill> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }
}
