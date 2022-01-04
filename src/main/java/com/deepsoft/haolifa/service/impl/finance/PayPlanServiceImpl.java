package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.enums.BookingTypeEnum;
import com.deepsoft.haolifa.enums.OrderPayStatusEnum;
import com.deepsoft.haolifa.enums.PayWayEnum;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.payapp.PayApplyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.payplan.*;
import com.deepsoft.haolifa.model.dto.finance.payplanlog.BizPayPlanPayLogDTO;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.BankBillService;
import com.deepsoft.haolifa.service.finance.BillService;
import com.deepsoft.haolifa.service.finance.OtherBillService;
import com.deepsoft.haolifa.service.finance.PayPlanService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PayPlanServiceImpl implements PayPlanService {

    @Autowired
    private BizPayPlanMapper bizPayPlanMapper;
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private SysDictService sysDictService;

    @Autowired
    private BizPayPlanPayLogMapper bizPayPlanPayLogMapper;

    @Autowired
    private BizBillMapper bizBillMapper;

    @Autowired
    private BizBankBillMapper bizBankBillMapper;

    @Autowired
    private BizOtherBillMapper bizOtherBillMapper;

    @Autowired
    private BillService billService;

    @Autowired
    private BankBillService bankBillService;

    @Autowired
    private OtherBillService otherBillService;

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
    public ResultBean update(BizPayPlanPayDTO planPayDTO) {

        CustomUser customUser = sysUserService.selectLoginUser();

        BizPayPlan record = buildBizPayPlan(planPayDTO, customUser);
        int update = bizPayPlanMapper.updateByPrimaryKeySelective(record);
        if (update < 1){
            return ResultBean.error(CommonEnum.ResponseEnum.SYSTEM_EXCEPTION);
        }

        BizPayPlan bizPayPlan = bizPayPlanMapper.selectByPrimaryKey(record.getId());
        PurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(Integer.parseInt(bizPayPlan.getContractId()));

        // 1 支付方式
        planPayDTO.getPayWayList()
            .forEach(payWayDTO -> {
                BizPayPlanPayLog payPlanPayLog = buildBizPayPlanPayLog(customUser, bizPayPlan, purchaseOrder, payWayDTO);
                bizPayPlanPayLogMapper.insert(payPlanPayLog);
            });
        // 2 记账方式
        planPayDTO.getPayWayList().stream()
            .forEach(payWayDTO -> {

                BookingTypeEnum bookingTypeEnum = BookingTypeEnum.valueOfCode(payWayDTO.getBookingType());
                switch (bookingTypeEnum) {
                    case cash_bill:
                        BizBillAddDTO bizBill = buildBizBillAddDTO(bizPayPlan, payWayDTO, bookingTypeEnum);
                        billService.save(bizBill);
                        break;
                    case bank_bill:
                        BizBankBillAddDTO bizBankBillAddDTO = buildBizBankBillAddDTO(bizPayPlan, payWayDTO, bookingTypeEnum);
                        bankBillService.save(bizBankBillAddDTO);
                        break;
                    case other_bill:
                        BizOtherBillAddDTO   bizBillAddDTO = buildBizOtherBillAddDTO(bizPayPlan, payWayDTO, bookingTypeEnum);
                        otherBillService.save(bizBillAddDTO);
                        break;
                    default:

                        break;
                }
            });


        planPayDTO.getPayWayList()
            .forEach(payWayDTO -> {
            BizPayPlanPayLog payPlanPayLog = buildBizPayPlanPayLog(customUser, bizPayPlan, purchaseOrder, payWayDTO);
            bizPayPlanPayLogMapper.insert(payPlanPayLog);
        });


        // 付款完成后，将采购订单的状态更新为已付款
        PurchaseOrder purchaseOrderU = new PurchaseOrder();
        purchaseOrderU.setId(Integer.parseInt(bizPayPlan.getContractId()));
        //  支付状态 1 未付款 2 部分付款 3 付款完成
        BigDecimal currentPaid = purchaseOrder.getPaidAccount().add(bizPayPlan.getApplyAmount());

        BigDecimal totalPrice = purchaseOrder.getTotalPrice();
        Byte payStatus = null;
        if (totalPrice.doubleValue() >= currentPaid.doubleValue()){
            payStatus = Byte.valueOf(OrderPayStatusEnum.all_pay.getCode());
        }else {
            payStatus = Byte.valueOf(OrderPayStatusEnum.partial_pay.getCode());
        }

        purchaseOrderU.setPayStatus(payStatus);
        purchaseOrderU.setPaidAccount(currentPaid);
        int selective = purchaseOrderMapper.updateByPrimaryKeySelective(purchaseOrderU);

        return ResultBean.success(update);
    }

    private BizOtherBillAddDTO buildBizOtherBillAddDTO(BizPayPlan bizPayPlan, BizPayPlanPayDTO.PayWayDTO payWayDTO, BookingTypeEnum bookingTypeEnum) {
        BizOtherBillAddDTO bizBill = new BizOtherBillAddDTO();
        bizBill.setType(bookingTypeEnum.getCode());
        bizBill.setCertificateNumber(bizPayPlan.getApplyNo());
        bizBill.setOperateDate(bizPayPlan.getPayDate());
        bizBill.setPaymentType(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        bizBill.setPayment(payWayDTO.getAmount());
        bizBill.setRemark(bizPayPlan.getRemark());
        bizBill.setCollectCompany(bizPayPlan.getApplyCollectionCompany());
        bizBill.setPayCompany(bizPayPlan.getPayCompany());
        return bizBill;
    }

    private BizBankBillAddDTO buildBizBankBillAddDTO(BizPayPlan bizPayPlan, BizPayPlanPayDTO.PayWayDTO payWayDTO, BookingTypeEnum bookingTypeEnum) {
        BizBankBillAddDTO bizBill = new BizBankBillAddDTO();
        bizBill.setType(bookingTypeEnum.getCode());
        bizBill.setCertificateNumber(bizPayPlan.getApplyNo());
        bizBill.setOperateDate(bizPayPlan.getPayDate());
        bizBill.setPaymentType(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        bizBill.setPayment(payWayDTO.getAmount());
        bizBill.setRemark(bizPayPlan.getRemark());
        bizBill.setCollectCompany(bizPayPlan.getApplyCollectionCompany());
        bizBill.setPayCompany(bizPayPlan.getPayCompany());
        return bizBill;
    }

    private BizBillAddDTO buildBizBillAddDTO(BizPayPlan bizPayPlan, BizPayPlanPayDTO.PayWayDTO payWayDTO, BookingTypeEnum bookingTypeEnum) {
        BizBillAddDTO bizBill = new BizBillAddDTO();
        bizBill.setType(bookingTypeEnum.getCode());
        bizBill.setCertificateNumber(bizPayPlan.getApplyNo());
        bizBill.setD(bizPayPlan.getPayDate());
        bizBill.setPaymentType(PayWayEnum.valueOfCode(payWayDTO.getCode()).getDesc());
        bizBill.setPayment(payWayDTO.getAmount());
        bizBill.setRemark(bizPayPlan.getRemark());
        bizBill.setString1(bizPayPlan.getApplyCollectionCompany());
        bizBill.setString2(bizPayPlan.getPayCompany());
        return bizBill;
    }

    private BizPayPlan buildBizPayPlan(BizPayPlanPayDTO planPayDTO, CustomUser customUser) {
        // 1 更新付款计划状态
        BizPayPlan record = new BizPayPlan();
        BeanUtils.copyProperties(planPayDTO,record);

        //  添加付款方式日志表
        record.setPayWay(JSON.toJSONString(planPayDTO.getPayWayList()));

        String bookingType = planPayDTO.getPayWayList().stream()
            .map(BizPayPlanPayDTO.PayWayDTO::getBookingType)
            .distinct()
            .collect(Collectors.joining(","));
        record.setBookingType(bookingType);
        record.setUpdateTime(new Date());
        record.setUpdateUser(customUser.getId());
        return record;
    }

    private BizPayPlanPayLog buildBizPayPlanPayLog(CustomUser customUser, BizPayPlan bizPayPlan, PurchaseOrder purchaseOrder, BizPayPlanPayDTO.PayWayDTO payWayDTO) {
        BizPayPlanPayLog payPlanPayLog = new BizPayPlanPayLog();
        payPlanPayLog.setPayPlanId((long) bizPayPlan.getId());
        payPlanPayLog.setPayWay(payWayDTO.getCode());
        payPlanPayLog.setApplyAmount(payWayDTO.getAmount());
        payPlanPayLog.setBookingType(payWayDTO.getBookingType());
        payPlanPayLog.setContractId(purchaseOrder.getId().toString());
        payPlanPayLog.setContractNo(purchaseOrder.getPurchaseOrderNo());
        payPlanPayLog.setCreateTime(new Date());
        payPlanPayLog.setCreateUser(customUser.getId());
        return payPlanPayLog;
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
        //数据状态 2 审核中  3 出纳付款
        if (StringUtils.isNotEmpty(model.getDataStatus())) {
            criteria.andDataStatusEqualTo(model.getDataStatus());
        }

        bizPayPlanExample.setOrderByClause("id desc");
        Page<BizPayPlan> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizPayPlanMapper.selectByExample(bizPayPlanExample);
            });

        Map<Long, List<BizPayPlanPayLog>> bizPayPlanPayLogListMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(pageData.getResult())) {
          List<Long> idList = pageData.getResult().stream().map(bizPayPlan->(long)bizPayPlan.getId()).collect(Collectors.toList());
            BizPayPlanPayLogExample bizPayPlanPayLogExample = new BizPayPlanPayLogExample();
            BizPayPlanPayLogExample.Criteria planPayLogExampleCriteria = bizPayPlanPayLogExample.createCriteria();
            planPayLogExampleCriteria.andPayPlanIdIn(idList);
            List<BizPayPlanPayLog> bizPayPlanPayLogs = bizPayPlanPayLogMapper.selectByExample(bizPayPlanPayLogExample);
            bizPayPlanPayLogListMap = bizPayPlanPayLogs.stream().collect(Collectors.groupingBy(BizPayPlanPayLog::getPayPlanId));
        }


        PageDTO<BizPayPlanRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);

        Map<Long, List<BizPayPlanPayLog>> finalBizPayPlanPayLogListMap = bizPayPlanPayLogListMap;
        List<BizPayPlanRSDTO> payApplyRSDTOList = pageData.getResult().stream()
            .map(bizPayApply -> {
                BizPayPlanRSDTO payApply = new BizPayPlanRSDTO();
                BeanUtils.copyProperties(bizPayApply, payApply);

                List<BizPayPlanPayLog> payPlanPayLogList = finalBizPayPlanPayLogListMap.get((long) payApply.getId());

                List<BizPayPlanPayLogDTO> bizPayPlanPayLogDTOS = new ArrayList<>();
                if(CollectionUtils.isNotEmpty(payPlanPayLogList)){
                    bizPayPlanPayLogDTOS = payPlanPayLogList.stream()
                        .map(bizPayPlanPayLog -> {
                            BizPayPlanPayLogDTO payPlanPayLogDTO = new BizPayPlanPayLogDTO();
                            BeanUtils.copyProperties(bizPayPlanPayLog, payPlanPayLogDTO);
                            payPlanPayLogDTO.setPayWay(PayWayEnum.valueOfCode(payPlanPayLogDTO.getPayWay()).getDesc());
                            payPlanPayLogDTO.setBookingType(BookingTypeEnum.valueOfCode(payPlanPayLogDTO.getBookingType()).getDesc());
                            return payPlanPayLogDTO;
                        })
                        .collect(Collectors.toList());
                }
                payApply.setPayWayList(bizPayPlanPayLogDTOS);

                List<String> asList = new ArrayList<>();
                if (StringUtils.isNotEmpty(payApply.getBookingType())){
                    asList = Arrays.asList(payApply.getBookingType().split(",").clone());
                }
                payApply.setBookingTypeList(asList);

                return payApply;
            })
            .collect(Collectors.toList());

        pageDTO.setList(payApplyRSDTOList);
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

    @Override
    public ResultBean<BookingTypeRSDTO> getAllPayWayList() {

        Map<BookingTypeEnum, List<PayWayEnum>> typeEnumPayWayEnumMap = Arrays.stream(PayWayEnum.values())
            .collect(Collectors.groupingBy(PayWayEnum::getBookingTypeEnum));

        List<BookingTypeRSDTO> bookingTypeRSDTOList = typeEnumPayWayEnumMap.entrySet().stream()
            .map(entry -> {
                BookingTypeEnum bookingTypeEnum = entry.getKey();

                BookingTypeRSDTO bookingTypeRSDTO = new BookingTypeRSDTO();
                bookingTypeRSDTO.setCode(bookingTypeEnum.getCode());
                bookingTypeRSDTO.setDesc(bookingTypeEnum.getDesc());

                List<BookingTypeRSDTO.PayWay> payWayList = entry.getValue().stream()
                    .map(payWayEnum -> {
                        BookingTypeRSDTO.PayWay payWay = new BookingTypeRSDTO.PayWay();
                        payWay.setCode(payWayEnum.getCode());
                        payWay.setDesc(payWayEnum.getDesc());
                        return payWay;
                    })
                    .collect(Collectors.toList());
                bookingTypeRSDTO.setWayList(payWayList);

                return bookingTypeRSDTO;
            })
            .collect(Collectors.toList());

        return ResultBean.success(bookingTypeRSDTOList);
    }


}
