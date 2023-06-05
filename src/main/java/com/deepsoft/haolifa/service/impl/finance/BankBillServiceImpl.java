package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.dao.repository.BizBankBillMapper;
import com.deepsoft.haolifa.dao.repository.BizProjectBudgetMapper;
import com.deepsoft.haolifa.dao.repository.BizSubjectsMapper;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.enums.BookingTypeEnum;
import com.deepsoft.haolifa.enums.DictEnum;
import com.deepsoft.haolifa.enums.PayWayEnum;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.*;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.service.ExpensesService;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.*;
import com.deepsoft.haolifa.service.impl.finance.helper.BillHelper;
import com.deepsoft.haolifa.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BankBillServiceImpl implements BankBillService {

    @Resource
    private BizBankBillMapper bizBankBillMapper;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SubjectBalanceService subjectBalanceService;
    @Resource
    private ProjectBudgetService projectBudgetService;
    @Resource
    private ExpensesService expensesService;
    @Resource
    private SysDictService sysDictService;

    @Resource
    private BizSubjectsMapper bizSubjectsMapper;

    @Resource
    private SysDepartmentMapper departmentMapper;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private BillHelper billHelper;
    @Resource
    private BizProjectBudgetMapper bizProjectBudgetMapper;
    @Resource
    private BillService billService;
    @Resource
    private OtherBillService otherBillService;

    @Override
    @Transactional
    public ResultBean save(BizBankBillAddDTO model) {
        log.info("BankBillService saveInfo start|{}", JSONObject.toJSON(model));
        if (model.getDeptId() == null) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "部门必填");
        }
        BizBankBill bizBankBill = new BizBankBill();
        BeanUtils.copyProperties(model, bizBankBill);


        // 设置公司和账户，用来统计余额
        // 收款
        if (bizBankBill.getType().equals("1")) {
            bizBankBill.setCompany(bizBankBill.getCollectCompany());
            bizBankBill.setAccount(bizBankBill.getPayAccount());
            //   `pay_company` varchar(64) DEFAULT '' COMMENT '付款单位',
            String payCompany = bizBankBill.getPayCompany();
            if (StringUtils.isEmpty(payCompany)) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "收款时付款单位不能为空");
            }
            if (StringUtils.isEmpty(model.getCollectionType())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "收款类别必填");
            }
            if (null == model.getCollectionMoney()) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "收款必填");
            }
            // 付款
        } else if (bizBankBill.getType().equals("2")) {
            if (StringUtils.isEmpty(model.getCollectCompany())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "收款单位必填");
            }
            if (StringUtils.isEmpty(model.getPayWay())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "付款方式必填");
            }
            if (StringUtils.isEmpty(model.getPayAccount())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "付款账户必填");
            }

            if (StringUtils.isEmpty(model.getPaymentType())) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "付款类别必填");
            }
            if (null == model.getPayment()) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "付款必填");
            }
            String payCompany = bizBankBill.getPayCompany();
            bizBankBill.setCompany(payCompany);
            bizBankBill.setAccount(bizBankBill.getPayAccount());

            //
            if (ObjectUtil.isNotEmpty(model.getProjectCode()) && ObjectUtil.isNotEmpty(model.getSubject())) {
                 billHelper.decreact(model.getProjectCode(), model.getDeptId(), model.getSubject(),
                    model.getRemark(), model.getSerialNo(), bizBankBill.getPayment());
            }

        }
        String companyQuery = bizBankBill.getCompany();
        String accountQuery = bizBankBill.getAccount();

        // 设置余额 start
        // 查找最新一条记录的余额
        BizBankBill lastRecord = bizBankBillMapper.getLastRecord(companyQuery, accountQuery);
        BigDecimal lastBalance = lastRecord == null || lastRecord.getBalance() == null
            ? BigDecimal.ZERO : lastRecord.getBalance();

        // 设置上月结转
        bizBankBill.setPreMonthMoney(lastRecord == null || lastRecord.getPreMonthMoney() == null ? BigDecimal.ZERO : lastRecord.getPreMonthMoney());

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

        //  收费类型
        //3	借款
        //2	货款
        //1	费用
        // 收费方式 承兑
        if (!StringUtils.equalsIgnoreCase(bizBankBill.getPayWay(), "承兑")
            && StringUtils.equalsIgnoreCase(bizBankBill.getType(), "1")
            && "123".contains(model.getCollectionType())) {
            subjectBalanceService.increaseAmountBatch(model.getCollectionMoney());
        } else if (bizBankBill.getType().equals("2")) {
//            subjectBalanceService.decreaseAmountBatch(model.getCollectionMoney());
        }

        return ResultBean.success(insertId);
    }

    @Override
    @Transactional
    public ResultBean savePreMonthMoney() {

        BizBankBill bizBankBill = new BizBankBill();
        // 设置公司和账户，用来统计余额
        List<String> stringList = sysDictService.getSysDictByTypeCode(DictEnum.PAY_ACCOUNT.getCode()).stream()
            .map(SysDict::getName)
            .collect(Collectors.toList());

        String companyQuery = Constant.company;
        for (String accountQuery : stringList) {
            // 设置余额 start
            // 查找最新一条记录的余额
            BizBankBill lastRecord = bizBankBillMapper.getLastRecord(companyQuery, accountQuery);
            BigDecimal lastBalance = lastRecord == null || lastRecord.getBalance() == null
                ? BigDecimal.ZERO : lastRecord.getBalance();

            // `pay_account` varchar(64) DEFAULT '' COMMENT '收付款账户',
            //  `pay_company` varchar(64) DEFAULT '' COMMENT '付款单位',
            //  `collect_company` varchar(64) DEFAULT '' COMMENT '收款单位',
            bizBankBill.setType("1");
            bizBankBill.setCompany(companyQuery);
            bizBankBill.setAccount(accountQuery);
            bizBankBill.setPayAccount(accountQuery);
            bizBankBill.setPayCompany(companyQuery);
            bizBankBill.setCollectCompany(companyQuery);
            bizBankBill.setOperateDate(new Date());
            // 设置上月结转
            bizBankBill.setPreMonthMoney(lastBalance);
            bizBankBill.setBalance(lastBalance);
            bizBankBill.setRemark(DateUtils.getDate() + "月结");
            bizBankBill.setCreateTime(new Date());
            bizBankBill.setUpdateTime(new Date());
            int insertId = bizBankBillMapper.insertSelective(bizBankBill);
        }

        return ResultBean.success(1);
    }

    @Override
    @Transactional
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
    @Transactional
    public ResultBean update(BizBankBillUpDTO billBank) {

        BizBankBill bizBankBill = new BizBankBill();
        BeanUtils.copyProperties(billBank, bizBankBill);
        BizBankBill selectByPrimaryKey = bizBankBillMapper.selectByPrimaryKey(billBank.getId());

        switch (bizBankBill.getType()) {
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
    public ResultBean<PageDTO<BizBankBillRSDTO>> getList(BizBankBillDTO model) {
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
        if (model.getOperateDateStart() != null && model.getOperateDateEnd() != null) {
            // 区间
            criteria.andOperateDateBetween(model.getOperateDateStart(), model.getOperateDateEnd());
        } else if (model.getOperateDateStart() != null) {
            // 大于
            criteria.andOperateDateGreaterThanOrEqualTo(model.getOperateDateStart());
        } else if (model.getOperateDateEnd() != null) {
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
        PageDTO<BizBankBillRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);


        List<String> projectCodeList = pageData.getResult().stream()
            .map(BizBankBill::getProjectCode)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
        Map<String, String> projectCodeMap = new HashMap<>();
        if (CollectionUtil.isNotEmpty(projectCodeList)) {
            BizProjectBudgetExample bizProjectBudgetExample = new BizProjectBudgetExample();
            BizProjectBudgetExample.Criteria criteriaBizProjectBudgetExample = bizProjectBudgetExample.createCriteria();
            criteriaBizProjectBudgetExample.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
            criteriaBizProjectBudgetExample.andCodeIn(projectCodeList);
            projectCodeMap = bizProjectBudgetMapper.selectByExample(bizProjectBudgetExample)
                .stream()
                .collect(Collectors.toMap(BizProjectBudget::getCode, BizProjectBudget::getName,
                    (a, b) -> a));
        }

        Map<String, String> finalProjectCodeMap = projectCodeMap;


        Map<String, String> subjects_type_map = sysDictService.getSysDictByTypeCode(
                DictEnum.SUBJECTS_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

        List<BizBankBillRSDTO> bizBankBillRSDTOList = pageData.getResult().stream()
            .map(bizBankBill -> {
                BizBankBillRSDTO billRSDTO = new BizBankBillRSDTO();
                BeanUtil.copyProperties(bizBankBill, billRSDTO);

                BizSubjects bizSubjects = bizSubjectsMapper.selectByPrimaryKey(
                    bizBankBill.getSubject());

                billRSDTO.setSubjectType(bizSubjects != null ? bizSubjects.getType() : "");
                billRSDTO.setSubjectTypeName(bizSubjects != null ? subjects_type_map.get(bizSubjects.getType()) : "");

                billRSDTO.setProjectCodeName(
                    finalProjectCodeMap.getOrDefault(bizBankBill.getProjectCode(), ""));

                return billRSDTO;
            })
            .collect(Collectors.toList());
        pageDTO.setList(bizBankBillRSDTOList);
        return ResultBean.success(pageDTO);
    }

    @Override
    @Transactional
    public ResultBean transfer(BizBankBillTransferDTO model) {
        // 扣减
        BizBankBillAddDTO bizBankBillPay = buildBizBankBillAddPay(model);
        ResultBean savePay = save(bizBankBillPay);
        if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, savePay.getCode())) {
            log.error("司内转账支付：", savePay.getMessage());
            throw new BaseException(savePay.getMessage());
        }
        if (StringUtils.equals("1", model.getTransferType())) {
            BizBillAddDTO billAddDTO = buildBizBillAddDTO(model);
            billService.save(billAddDTO);
        } else if (StringUtils.equals("2", model.getTransferType())) {
            // 增加
            BizBankBillAddDTO bizBankBillCollection = buildBizBankBillAddCollection(model);
            ResultBean saveCollection = save(bizBankBillCollection);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, saveCollection.getCode())) {
                log.error("司内转账支付：", saveCollection.getMessage());
                throw new BaseException(saveCollection.getMessage());
            }
        } else if (StringUtils.equals("3", model.getTransferType())) {
            BizOtherBillAddDTO otherBillAddDTO = buildBizOtherBillAddCollection(model);
            ResultBean saveCollection = otherBillService.save(otherBillAddDTO);
            if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, saveCollection.getCode())) {
                log.error("司内转账支付：", saveCollection.getMessage());
                throw new BaseException(saveCollection.getMessage());
            }
        }

        return ResultBean.success(1);
    }


    public BizBillAddDTO buildBizBillAddDTO(BizBankBillTransferDTO model) {
        BizBillAddDTO bizBill = new BizBillAddDTO();
        bizBill.setType(BookingTypeEnum.cash_bill.getCode());
        bizBill.setCertificateNumber("");
        bizBill.setD(new Date());
        bizBill.setDeptId("");
        bizBill.setCollectionType(PayWayEnum.cash_pay.getDesc());
        bizBill.setCollectionMoney(model.getPayment());
        bizBill.setRemark("司内转账-收款 " + model.getPayment());
        bizBill.setString1(model.getTargetAccount());
        bizBill.setString2(model.getSourceAccount());

        return bizBill;
    }

    public BizBankBillAddDTO buildBizBankBillAddPay(BizBankBillTransferDTO model) {
        BizBankBillAddDTO bizBankBill = new BizBankBillAddDTO();
        // 付款
        bizBankBill.setType("2");
        bizBankBill.setCompany(Constant.company);
        bizBankBill.setCertificateNumber("");
        bizBankBill.setOperateDate(new Date());
        bizBankBill.setDeptId(0);
        bizBankBill.setPayWay(PayWayEnum.remittance_pay.getDesc());
        bizBankBill.setPaymentType(PayWayEnum.remittance_pay.getDesc());
        bizBankBill.setPayment(model.getPayment());
        bizBankBill.setRemark("司内转账-付款 " + model.getPayment());
        bizBankBill.setPayCompany(Constant.company);
        bizBankBill.setPayAccount(model.getSourceAccount());
        bizBankBill.setCollectCompany(Constant.company);
        return bizBankBill;
    }

    public BizBankBillAddDTO buildBizBankBillAddCollection(BizBankBillTransferDTO model) {
        BizBankBillAddDTO bizBankBill = new BizBankBillAddDTO();
        // 收款
        bizBankBill.setType("1");
        bizBankBill.setCompany(Constant.company);
        bizBankBill.setAccount(model.getTargetAccount());
        bizBankBill.setDeptId(0);
        bizBankBill.setCertificateNumber("");
        bizBankBill.setOperateDate(new Date());
        bizBankBill.setPayWay(PayWayEnum.remittance_pay.getDesc());
        bizBankBill.setPaymentType(PayWayEnum.remittance_pay.getDesc());
        // 负数的绝对值
        bizBankBill.setCollectionMoney(model.getPayment());
        bizBankBill.setRemark("司内转账-收款 " + model.getPayment());
        bizBankBill.setPayCompany(Constant.company);
        bizBankBill.setPayAccount(model.getTargetAccount());
        bizBankBill.setCollectCompany(Constant.company);
        // 1	费用
        //2	货款
        //3	借款
        //4	其他
        //1	费用
        //2	货款
        //3	借款
        //4	其他
        bizBankBill.setCollectionType("4");
        return bizBankBill;
    }

    public BizOtherBillAddDTO buildBizOtherBillAddCollection(BizBankBillTransferDTO model) {
        BizOtherBillAddDTO billAddDTO = new BizOtherBillAddDTO();
        // 收款
        billAddDTO.setType("1");
        billAddDTO.setCompany(Constant.company);
        billAddDTO.setAccount(model.getTargetAccount());
        billAddDTO.setDeptId(0);
        billAddDTO.setCertificateNumber("");
        billAddDTO.setOperateDate(new Date());
        billAddDTO.setPayWay(PayWayEnum.remittance_pay.getDesc());
        billAddDTO.setPaymentType(PayWayEnum.remittance_pay.getDesc());
        // 负数的绝对值
        billAddDTO.setCollectionMoney(model.getPayment());
        billAddDTO.setRemark("司内转账-收款 " + model.getPayment());
        billAddDTO.setPayCompany(Constant.company);
        billAddDTO.setPayAccount(model.getTargetAccount());
        billAddDTO.setCollectCompany(Constant.company);
        // 1	费用
        //2	货款
        //3	借款
        //4	其他
        //1	费用
        //2	货款
        //3	借款
        //4	其他
        billAddDTO.setCollectionType("4");
        return billAddDTO;
    }

}
