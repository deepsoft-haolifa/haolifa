package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizBankBillMapper;
import com.deepsoft.haolifa.model.domain.BizBankBill;
import com.deepsoft.haolifa.model.domain.BizBankBillExample;
import com.deepsoft.haolifa.model.domain.BizBill;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillUpDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRSDTO;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.BankBillService;
import com.deepsoft.haolifa.service.finance.SubjectBalanceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BankBillServiceImpl implements BankBillService {

    @Autowired
    private BizBankBillMapper bizBankBillMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SubjectBalanceService subjectBalanceService;

    @Override
    public ResultBean save(BizBankBillAddDTO model) {
        log.info("BankBillService saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }

        BizBankBill bizBankBill = new BizBankBill();
        BeanUtils.copyProperties(model,bizBankBill);


        // 设置公司和账户，用来统计余额
        if (bizBankBill.getType().equals("1")) {
            bizBankBill.setCompany(bizBankBill.getCollectCompany());
            bizBankBill.setAccount(bizBankBill.getPayAccount());
        } else if (bizBankBill.getType().equals("2")) {
            bizBankBill.setCompany(bizBankBill.getPayCompany());
            bizBankBill.setAccount(bizBankBill.getPayAccount());
        }
        String companyQuery = bizBankBill.getCompany();
        String accountQuery = bizBankBill.getAccount();
        // 设置上月结转
       // bizBankBill.setPreMonthMoney(bizBillAmountService.getPreMonthAmount(1, companyQuery, accountQuery));

        // 设置余额 start
        // 查找最新一条记录的余额
        BizBankBill lastRecord = bizBankBillMapper.getLastRecord(companyQuery, accountQuery);
        BigDecimal lastBalance = lastRecord == null || lastRecord.getBalance() == null
            ? BigDecimal.ZERO : lastRecord.getBalance();

        // 收款，上次余额 + 本次收款
        if (bizBankBill.getType().equals("1")) {
            BigDecimal collectionMoney = bizBankBill.getCollectionMoney();
            BigDecimal add = collectionMoney.add(lastBalance);
            bizBankBill.setBalance(add);
        } else if (bizBankBill.getType().equals("2")) {
            // 付款 , 上次余额 - 本次付款
            BigDecimal payment = bizBankBill.getPayment();
            BigDecimal subtract = lastBalance.subtract(payment);
            if (subtract.compareTo(BigDecimal.ZERO) < 0) {
                throw new BaseException("银行日记账余额不足以付款");
            }
            bizBankBill.setBalance(subtract);
        }
        // 设置余额 end

        bizBankBill.setCreateTime(new Date());
        bizBankBill.setUpdateTime(new Date());
        bizBankBill.setCreateUser(sysUserService.selectLoginUser().getId());
        bizBankBill.setUpdateUser(sysUserService.selectLoginUser().getId());
        int insertId = bizBankBillMapper.insertSelective(bizBankBill);


        // 存入余额 费用 借款 货款
        // 1
        //2
        //3
        if (bizBankBill.getType().equals("1") && "123".contains(model.getCollectionType())) {
            subjectBalanceService.increaseAmountBatch(model.getDeptId(),model.getCollectionMoney());
        } else if (bizBankBill.getType().equals("2")) {
            subjectBalanceService.decreaseAmountBatch(model.getDeptId(),model.getCollectionMoney());
        }

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
    public ResultBean update(BizBankBillUpDTO billBank) {

        BizBankBill bizBankBill = new BizBankBill();
        BeanUtils.copyProperties(billBank,bizBankBill);
        BizBankBill selectByPrimaryKey = bizBankBillMapper.selectByPrimaryKey(billBank.getId());

        switch (bizBankBill.getType()){
            case "1":
                BigDecimal collectionMoney = bizBankBill.getCollectionMoney().subtract(selectByPrimaryKey.getCollectionMoney());
                BigDecimal balance = selectByPrimaryKey.getBalance().add(collectionMoney);
                bizBankBill.setBalance(balance);
                break;
            case "2":
                BigDecimal payment = bizBankBill.getPayment().subtract(selectByPrimaryKey.getPayment());
                BigDecimal bigDecimal = selectByPrimaryKey.getBalance().add(payment);
                bizBankBill.setBalance(bigDecimal);
                break;
        }

        bizBankBill.setUpdateTime(new Date());
        bizBankBill.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizBankBillMapper.updateByPrimaryKeySelective(bizBankBill);
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
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        // 凭证号 ==
        if (StringUtils.isNotEmpty(model.getCertificateNumber())) {
            criteria.andCertificateNumberEqualTo(model.getCertificateNumber());
        }
        //收付款账户：下拉选框
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
            criteria.andOperateDateGreaterThanOrEqualTo(model.getOperateDateStart());
        }else if (model.getOperateDateEnd()!=null ) {
            // 小于
            criteria.andOperateDateLessThanOrEqualTo(model.getOperateDateEnd());
        }

        //收款单位：like
        if (StringUtils.isNotEmpty(model.getCollectCompany())) {
            criteria.andCollectCompanyLike(model.getCollectCompany());
        }
        //付款单位：like
        if (StringUtils.isNotEmpty(model.getPayCompany())) {
            criteria.andPayCompanyLike(model.getPayCompany());
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
