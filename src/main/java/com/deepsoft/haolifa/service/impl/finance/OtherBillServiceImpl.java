package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.dao.repository.BizOtherBillMapper;
import com.deepsoft.haolifa.enums.DictEnum;
import com.deepsoft.haolifa.model.domain.BizBankBill;
import com.deepsoft.haolifa.model.domain.BizOtherBill;
import com.deepsoft.haolifa.model.domain.BizOtherBillExample;
import com.deepsoft.haolifa.model.domain.SysDict;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillUpDTO;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.OtherBillService;
import com.deepsoft.haolifa.util.DateUtils;
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
import java.util.stream.Collectors;

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
        // 设置公司和账户，用来统计余额
        if (billOther.getType().equals("1")) {
            billOther.setCompany(billOther.getCollectCompany());
            billOther.setAccount(billOther.getPayAccount());
        } else if (billOther.getType().equals("2")) {
            billOther.setCompany(billOther.getPayCompany());
            billOther.setAccount(billOther.getPayAccount());
        }
        String companyQuery = billOther.getCompany();
        String accountQuery = billOther.getAccount();

        // 设置余额 start
        // 查找最新一条记录的余额
        BizOtherBill lastRecord = bizOtherBillMapper.getLastRecord(companyQuery, accountQuery);
        BigDecimal lastBalance = lastRecord == null || lastRecord.getBalance() == null
            ? BigDecimal.ZERO : lastRecord.getBalance();
        // 设置上月结转
        billOther.setPreMonthMoney(lastRecord == null || lastRecord.getPreMonthMoney() == null ? BigDecimal.ZERO : lastRecord.getPreMonthMoney());

        // 收款，上次余额 + 本次收款
        if (billOther.getType().equals("1")) {
            BigDecimal collectionMoney = billOther.getCollectionMoney();
            BigDecimal add = collectionMoney.add(lastBalance);
            billOther.setBalance(add);
        } else if (billOther.getType().equals("2")) {
            // 付款 , 上次余额 - 本次付款
            BigDecimal payment = billOther.getPayment();
            BigDecimal subtract = lastBalance.subtract(payment);
            if (subtract.compareTo(BigDecimal.ZERO) < 0) {
                throw new BaseException("其他货币日记账余额不足以付款");
            }
            billOther.setBalance(subtract);
        }
        // 设置余额 end

        billOther.setCreateTime(new Date());
        billOther.setUpdateTime(new Date());
        billOther.setCreateUser(sysUserService.selectLoginUser().getId());
        billOther.setUpdateUser(sysUserService.selectLoginUser().getId());
        int insertId = bizOtherBillMapper.insertSelective(billOther);

        return ResultBean.success(insertId);
    }

    @Autowired
    private SysDictService sysDictService;

    @Override
    public ResultBean savePreMonthMoney() {

        BizOtherBill billOther = new BizOtherBill();
        // 设置公司和账户，用来统计余额
        List<String> stringList = sysDictService.getSysDictByTypeCode(DictEnum.PAY_ACCOUNT.getCode()).stream()
            .map(SysDict::getName)
            .collect(Collectors.toList());

        String companyQuery = Constant.company;
        for (String accountQuery :stringList){
            // 设置余额 start
            // 查找最新一条记录的余额
            BizOtherBill lastRecord = bizOtherBillMapper.getLastRecord(companyQuery, accountQuery);
            BigDecimal lastBalance = lastRecord == null || lastRecord.getBalance() == null
                ? BigDecimal.ZERO : lastRecord.getBalance();
            billOther.setType("1");
            billOther.setCompany(companyQuery);
            billOther.setAccount(accountQuery);
            billOther.setAccount(accountQuery);
            billOther.setPayAccount(accountQuery);
            billOther.setPayCompany(companyQuery);
            billOther.setCollectCompany(companyQuery);
            billOther.setOperateDate(new Date());
            // 设置上月结转
            billOther.setPreMonthMoney(lastBalance);
            billOther.setBalance(lastBalance);
            billOther.setRemark(DateUtils.getDate()+"月结");
            billOther.setCreateTime(new Date());
            billOther.setUpdateTime(new Date());
            int insertId = bizOtherBillMapper.insertSelective(billOther);
        }

        return ResultBean.success(1);
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
    public ResultBean update(BizOtherBillUpDTO otherBillUpDTO) {

        BizOtherBill billOther = new BizOtherBill();
        BeanUtils.copyProperties(otherBillUpDTO,billOther);
        BizOtherBill selectByPrimaryKey = bizOtherBillMapper.selectByPrimaryKey(otherBillUpDTO.getId());

        switch (billOther.getType()){
            case "1":
                BigDecimal collectionMoney = billOther.getCollectionMoney().subtract(selectByPrimaryKey.getCollectionMoney());
                BigDecimal balance = selectByPrimaryKey.getBalance().add(collectionMoney);
                billOther.setBalance(balance);
                break;
            case "2":
                BigDecimal payment = billOther.getPayment().subtract(selectByPrimaryKey.getPayment());
                BigDecimal bigDecimal = selectByPrimaryKey.getBalance().add(payment);
                billOther.setBalance(bigDecimal);
                break;
        }

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
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);


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
