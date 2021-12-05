package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizOtherBillMapper;
import com.deepsoft.haolifa.model.domain.BizOtherBill;
import com.deepsoft.haolifa.model.domain.BizOtherBillExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillDTO;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.OtherBillService;
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
public class OtherBillServiceImpl implements OtherBillService {

    @Autowired
    private BizOtherBillMapper bizOtherBillMapper;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public ResultBean save(BizOtherBillAddDTO model) {
        log.info("OtherBillService saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        BizOtherBill billOther = new BizOtherBill();
        BeanUtils.copyProperties(model, billOther);
        billOther.setCreateTime(new Date());
        billOther.setUpdateTime(new Date());
        billOther.setCreateUser(sysUserService.selectLoginUser().getId());
        billOther.setUpdateUser(sysUserService.selectLoginUser().getId());
        int insertId = bizOtherBillMapper.insertSelective(billOther);
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean delete(Integer id) {
        //int delete = bizOtherBillMapper.deleteByPrimaryKey(id);

        BizOtherBill billOther = new BizOtherBill();
        billOther.setId(id);
        billOther.setDelFlag("1");
        billOther.setUpdateTime(new Date());
        billOther.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizOtherBillMapper.updateByPrimaryKeySelective(billOther);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean update(BizOtherBill billOther) {
        billOther.setUpdateTime(new Date());
        billOther.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizOtherBillMapper.updateByPrimaryKeySelective(billOther);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        BizOtherBill billOther = bizOtherBillMapper.selectByPrimaryKey(id);
        return ResultBean.success(billOther);
    }

    @Override
    public ResultBean getList(BizOtherBillDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizOtherBillExample bizOtherBillExample = new BizOtherBillExample();
        BizOtherBillExample.Criteria criteria = bizOtherBillExample.createCriteria();
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
        if (model.getOperateDateStart() != null && model.getOperateDateEnd() != null) {
            // 区间
            criteria.andOperateDateBetween(model.getOperateDateStart(), model.getOperateDateEnd());
        } else if (model.getOperateDateStart() != null) {
            // 大于
            criteria.andOperateDateGreaterThanOrEqualTo(model.getOperateDate());
        } else if (model.getOperateDateEnd() != null) {
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

        // 分解状态
        if (StringUtils.isNotEmpty(model.getContractStatus())) {
            criteria.andContractStatusEqualTo(model.getContractStatus());
        }


        bizOtherBillExample.setOrderByClause("id desc");
        Page<BizOtherBill> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizOtherBillMapper.selectByExample(bizOtherBillExample);
            });
        PageDTO<BizOtherBill> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }


}
