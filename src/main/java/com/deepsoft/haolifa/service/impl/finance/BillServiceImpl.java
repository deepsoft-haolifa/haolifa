package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizBillMapper;
import com.deepsoft.haolifa.model.domain.BizBill;
import com.deepsoft.haolifa.model.domain.BizBillExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillDTO;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.BillService;
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
public class BillServiceImpl implements BillService {

    @Autowired
    private BizBillMapper bizBillMapper;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public ResultBean save(BizBillAddDTO model) {
        log.info("BizBill saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        BizBill bizBill = new BizBill();
        BeanUtils.copyProperties(model, bizBill);
        bizBill.setCreateTime(new Date());
        bizBill.setUpdateTime(new Date());
        bizBill.setCreateUser(sysUserService.selectLoginUser().getId());
        bizBill.setUpdateUser(sysUserService.selectLoginUser().getId());
        int insertId = bizBillMapper.insertSelective(bizBill);
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean delete(Integer id) {
//        int delete = bizBillMapper.deleteByPrimaryKey(id);
//        return ResultBean.success(delete);
        BizBill bizBill = new BizBill();
        bizBill.setId(id);
        bizBill.setDelFlag("1");
        bizBill.setUpdateTime(new Date());
        bizBill.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizBillMapper.updateByPrimaryKeySelective(bizBill);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean update(BizBill bizBill) {
        bizBill.setUpdateTime(new Date());
        bizBill.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizBillMapper.updateByPrimaryKeySelective(bizBill);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        BizBill bizBill = bizBillMapper.selectByPrimaryKey(id);
        return ResultBean.success(bizBill);
    }

    @Override
    public ResultBean getList(BizBillDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizBillExample bizBillExample = new BizBillExample();
        BizBillExample.Criteria criteria = bizBillExample.createCriteria();
        criteria.andDelFlagEqualTo("0");
        // 凭证号 ==
        if (StringUtils.isNotEmpty(model.getCertificateNumber())) {
            criteria.andCertificateNumberEqualTo(model.getCertificateNumber());
        }
        // 付款类型 ==
        if (StringUtils.isNotEmpty(model.getPaymentType())) {
            criteria.andPaymentTypeEqualTo(model.getPaymentType());
        }
        //  收款单位 like
        if (StringUtils.isNotEmpty(model.getPaymentType())) {
            criteria.andPaymentTypeEqualTo(model.getPaymentType());
        }
        // 付款单位 like
        if (StringUtils.isNotEmpty(model.getCollectionCompany())) {
            criteria.andString2Like(model.getCollectionCompany());
        }
        // 部门 like todo

        // 凭证号 付款类别 收款单位 付款单位 部门

        bizBillExample.setOrderByClause("id desc");
        Page<BizBill> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizBillMapper.selectByExample(bizBillExample);
            });
        PageDTO<BizBill> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }
}
