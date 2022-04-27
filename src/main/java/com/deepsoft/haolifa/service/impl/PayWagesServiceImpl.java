package com.deepsoft.haolifa.service.impl;

import cn.hutool.poi.excel.ExcelWriter;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.*;
import com.deepsoft.haolifa.service.*;
import com.deepsoft.haolifa.util.BeanCopyUtils;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.DateUtils;
import com.deepsoft.haolifa.util.ExcelUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 考核指标
 */
@Service
@Slf4j
public class PayWagesServiceImpl extends BaseService implements PayWagesService {
    @Resource
    private PayWagesMapper payWagesMapper;
    @Resource
    private PayOrderUserRelationProcedureService payOrderUserRelationProcedureService;
    @Resource
    private EntrustMapper entrustMapper;
    @Resource
    private OrderProductAssociateMapper orderProductAssociateMapper;
    @Resource
    private PayWagesRelationUserService payWagesRelationUserService;
    @Resource
    private ProInspectService proInspectService;
    @Resource
    private InspectService inspectService;
    @Resource
    private PayUserMapper payUserMapper;
    @Resource
    private PayWorkingProcedureMapper payWorkingProcedureMapper;
    @Resource
    private SprayService sprayService;
    @Resource
    private SprayItemMapper sprayItemMapper;
    @Resource
    private PayWagesSearchMapper payWagesSearchMapper;
    @Resource
    private PayOrderUserRelationProcedureMapper payOrderUserRelationProcedureMapper;
    @Resource
    private AutoControlEntrustMapper autoControlEntrustMapper;
    @Resource
    private ValveSeatEntrustMapper valveSeatEntrustMapper;
    @Resource
    private AutoControlEntrustService autoControlEntrustService;
    @Resource
    private ValveSeatEntrustService valveSeatEntrustService;
    @Resource
    private PayAssessmentScoreMapper payAssessmentScoreMapper;
    @Resource
    private PayWorkAttendanceMapper payWorkAttendanceMapper;

    @Override
    public ResultBean pageInfo(PayWagesDTO model) {
        PayWagesExample example = new PayWagesExample();
        PayWagesExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getDepartment())) {
            criteria.andDepartmentLike("%" + model.getDepartment() + "%");
        }
        if (StringUtils.isNotBlank(model.getUserName())) {
            criteria.andUserNameLike("%" + model.getUserName() + "%");
        }
        if (Objects.nonNull(model.getRequiredAttendanceDays()) && model.getRequiredAttendanceDays() > 0) {
            criteria.andRequiredAttendanceDaysEqualTo(model.getRequiredAttendanceDays());
        }
        if (Objects.nonNull(model.getActualAttendanceDays()) && model.getActualAttendanceDays() > 0) {
            criteria.andActualAttendanceDaysEqualTo(model.getActualAttendanceDays());
        }
        if (Objects.nonNull(model.getLateAndLeaveTimes()) && model.getLateAndLeaveTimes() > 0) {
            criteria.andLateAndLeaveTimesEqualTo(model.getLateAndLeaveTimes());
        }
        if (Objects.nonNull(model.getAbsenteeismTimes()) && model.getAbsenteeismTimes() > 0) {
            criteria.andAbsenteeismTimesEqualTo(model.getAbsenteeismTimes());
        }
        if (Objects.nonNull(model.getByPieceCount()) && model.getByPieceCount() > 0) {
            criteria.andByPieceCountEqualTo(model.getByPieceCount());
        }
        if (Objects.nonNull(model.getByPieceMoney())) {
            criteria.andByPieceMoneyEqualTo(model.getByPieceMoney());
        }
        if (Objects.nonNull(model.getTemporaryDispatchCount()) && model.getTemporaryDispatchCount() > 0) {
            criteria.andTemporaryDispatchCountEqualTo(model.getTemporaryDispatchCount());
        }
        if (Objects.nonNull(model.getTemporaryDispatchMoney())) {
            criteria.andTemporaryDispatchMoneyEqualTo(model.getTemporaryDispatchMoney());
        }
        if (Objects.nonNull(model.getOddJobCount()) && model.getOddJobCount() > 0) {
            criteria.andOddJobCountEqualTo(model.getOddJobCount());
        }
        if (Objects.nonNull(model.getOddJobMoney())) {
            criteria.andOddJobMoneyEqualTo(model.getOddJobMoney());
        }
        if (Objects.nonNull(model.getIndustrialWasteCount()) && model.getIndustrialWasteCount() > 0) {
            criteria.andIndustrialWasteCountEqualTo(model.getIndustrialWasteCount());
        }
        if (Objects.nonNull(model.getIndustrialWasteMoney())) {
            criteria.andIndustrialWasteMoneyEqualTo(model.getIndustrialWasteMoney());
        }
        if (StringUtils.isNotEmpty(model.getStartCreateTime())) {
            Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getStartCreateTime());
            criteria.andCreateTimeGreaterThan(startDate);
        }
        if (StringUtils.isNotEmpty(model.getEndCreateTime())) {
            Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getEndCreateTime());
            criteria.andCreateTimeLessThan(endDate);
        }
        example.setOrderByClause("id desc");
        Page<PayWages> payTeams = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> payWagesMapper.selectByExample(example));
        PageDTO<PayWages> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payTeams, pageDTO);
        pageDTO.setList(payTeams);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean save(PayWagesSaveVO model) {
        PayWages payWages = new PayWages();
        BeanUtils.copyProperties(model, payWages);
        payWages.setCreateUser(getLoginUserName());
        payWages.setUpdateUser(getLoginUserName());
        payWages.setCreateTime(new Date());
        payWages.setUpdateTime(new Date());
        payWagesMapper.insert(payWages);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer wagesId) {
        return ResultBean.success(payWagesMapper.selectByPrimaryKey(wagesId));
    }

    @Override
    public ResultBean edit(PayWagesSaveVO model) {
        PayWages payWages = new PayWages();
        BeanUtils.copyProperties(model, payWages);
        payWages.setUpdateUser(getLoginUserName());
        payWages.setUpdateTime(new Date());
        payWagesMapper.updateByPrimaryKeySelective(payWages);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer wagesId) {
        return ResultBean.success(payWagesMapper.deleteByPrimaryKey(wagesId));

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Async
    public void insert(List<PayWages> objects) {
        for (PayWages payWage : objects) {
            if (Objects.isNull(payWage.getCreateTime())) {
                payWage.setCreateTime(new Date());
            }
            if (StringUtils.isEmpty(payWage.getCreateUser())) {
                payWage.setCreateUser(getLoginUserName());
            }
            payWage.setUpdateTime(new Date());
            payWage.setUpdateUser(getLoginUserName());
            PayWages payWages = payWagesMapper.selectByPrimaryKey(payWage.getId());
            if (Objects.isNull(payWage)) {
                payWagesMapper.insert(payWage);
            } else {
                payWagesMapper.updateByPrimaryKeySelective(payWage);
            }
        }
    }

    @Override
    @Async
    public ResultBean calculateSalary(PayWagesVO payWagesVO) throws Exception {
        if (StringUtils.isBlank(payWagesVO.getYear()) || StringUtils.isBlank(payWagesVO.getMonth())) {
            throw new Exception("年份或月份不能为空");
        }
        String calDate = payWagesVO.getYear() + "-" + payWagesVO.getMonth() + "-01 " + "00:00:00";
        Date calTime = DateFormatterUtils.parseDateString(DateFormatterUtils.ONE_FORMATTERPATTERN, calDate);
        // 开始时间 上个月26号
        Calendar cal = Calendar.getInstance();
        cal.setTime(calTime);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 26);
        String s = DateFormatterUtils.formatterDateString(DateFormatterUtils.ZERO_FORMATTERPATTERN, cal.getTime());
        Date startTime = DateUtils.dateTime(DateFormatterUtils.ONE_FORMATTERPATTERN, s);

        // 开始时间 这个月25号
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(calTime);
        cal2.set(Calendar.DAY_OF_MONTH, 25);
        String str = DateFormatterUtils.formatterDateString(DateFormatterUtils.MAX_FORMATTERPATTERN, cal2.getTime());
        Date endTime = DateUtils.dateTime(DateFormatterUtils.ONE_FORMATTERPATTERN, str);
        List<PayWages> payWages = payWagesMapper.selectByExample(new PayWagesExample());
        for (PayWages payWage : payWages) {
            PayWagesRelationUser payWagesRelationUser = new PayWagesRelationUser();
            payWagesRelationUser.setWagesId(payWage.getId());
            List<PayWagesRelationUser> list = payWagesRelationUserService.getList(payWagesRelationUser);
            if (CollectionUtils.isEmpty(list)) {
                continue;
            }
            // 通过用户ID查工序订单用户关联表
            Integer userId = list.get(0).getUserId();
            PayUser payUser = payUserMapper.selectByPrimaryKey(userId);
            String userType = payUser.getUserType();
            // 处理考勤数据
            buildPayWorkAttendanceInfo(userId, payWagesVO, payWage);
            int totalCount = 0;
            // 基本工资
            BigDecimal minLiveSecurityFund = payWage.getMinLiveSecurityFund();
            BigDecimal totalAmount = new BigDecimal("0");

            // 去重入库数量
            Map<String, Integer> productMap = new HashMap<>();

            if (CommonEnum.UserType.UNMARRIED.type.equals(userType)) {
                PayOrderUserRelationProcedure payOrderUserRelationProcedure = new PayOrderUserRelationProcedure();
                payOrderUserRelationProcedure.setUserId(userId);
                // TODO 加一个时间
                List<PayOrderUserRelationProcedure> payOrderUserRelationProcedureList = payOrderUserRelationProcedureService.getPayOrderUserRelationProcedureList(payOrderUserRelationProcedure);
                // 每个人做了那些工序
                for (PayOrderUserRelationProcedure procedure : payOrderUserRelationProcedureList) {
                    // 工序价格
                    BigDecimal hourPrice = procedure.getHourPrice();
                    if (Objects.isNull(hourPrice) || hourPrice.equals(new BigDecimal("0.000"))) {
                        continue;
                    }
                    // 订单号
                    String orderId = procedure.getOrderId();
                    // 工序ID获取工序
                    Integer procedureId = procedure.getProcedureId();
                    PayWorkingProcedure payWorkingProcedure = payWorkingProcedureMapper.selectByPrimaryKey(procedureId);
                    // 车间名称
                    String workshopName = payWorkingProcedure.getWorkshopName();
                    if (CommonEnum.WorkShopTypeEnum.PRODUCT.name.equals(workshopName)) {
                        OrderProductAssociate orderProductAssociate = orderProductAssociateMapper.selectByPrimaryKey(procedure.getProductId());
                        PayCalculateDTO proInspectRecord = buildPayCalculateDTO(orderId, orderProductAssociate.getProductNo(), startTime, endTime);
                        List<ProInspectRecord> proInspectList = proInspectService.getProInspectList(proInspectRecord);
                        if (CollectionUtils.isEmpty(proInspectList)) {
                            continue;
                        }
                        int qualifiedNumberTotal = 0;
                        BigDecimal multiplyPrice = new BigDecimal("0");
                        for (ProInspectRecord inspectRecord : proInspectList) {
                            // 合格数量x工序价格+基本工资
                            Integer qualifiedNumber = inspectRecord.getQualifiedNumber();
                            qualifiedNumberTotal = qualifiedNumberTotal + qualifiedNumber;
                            // 去重数量
                            productMap.put(inspectRecord.getId() + orderId, qualifiedNumber);
                            totalCount = totalCount + qualifiedNumber;
                            BigDecimal multiply = hourPrice.multiply(new BigDecimal(qualifiedNumber));
                            multiplyPrice = multiplyPrice.add(multiply);
                            totalAmount = totalAmount.add(multiply);
                        }
                        procedure.setTotalCount(qualifiedNumberTotal);
                        procedure.setTotalPrice(multiplyPrice);
                        payOrderUserRelationProcedureMapper.updateByPrimaryKeySelective(procedure);
                    } else if (CommonEnum.WorkShopTypeEnum.SPRAY.name.equals(workshopName)) {
                        SprayItem sprayItem = sprayItemMapper.selectByPrimaryKey(procedure.getProductId());
                        PayCalculateDTO payCalculateDTO = buildPayCalculateDTO(orderId, sprayItem.getSprayedGraphNo(), startTime, endTime);
                        List<SprayInspectHistory> sprayInspectHistoryList = sprayService.getSprayInspectHistoryList(payCalculateDTO);
                        if (CollectionUtils.isEmpty(sprayInspectHistoryList)) {
                            continue;
                        }
                        int qualifiedNumberTotal = 0;
                        BigDecimal multiplyPrice = new BigDecimal("0");
                        for (SprayInspectHistory sprayInspectHistory : sprayInspectHistoryList) {
                            Integer qualifiedNumber = sprayInspectHistory.getQualifiedNumber();
                            qualifiedNumberTotal = qualifiedNumberTotal + qualifiedNumber;
                            // 去重数量
                            productMap.put(sprayInspectHistory.getId() + orderId, qualifiedNumber);
                            // 合格数量x工序价格+基本工资
                            totalCount = totalCount + qualifiedNumber;
                            BigDecimal multiply = hourPrice.multiply(new BigDecimal(qualifiedNumber));
                            multiplyPrice = multiplyPrice.add(multiply);
                            totalAmount = totalAmount.add(multiply);
                        }
                        procedure.setTotalCount(qualifiedNumberTotal);
                        procedure.setTotalPrice(multiplyPrice);
                        payOrderUserRelationProcedureMapper.updateByPrimaryKeySelective(procedure);
                    } else if (CommonEnum.WorkShopTypeEnum.MACHINING.name.equals(workshopName)) {
                        Entrust entrust = entrustMapper.selectByPrimaryKey(procedure.getProductId());
                        PayCalculateDTO payCalculateDTO = buildPayCalculateDTO(orderId, entrust.getProcessedGraphNo(), startTime, endTime);
                        List<InspectHistory> inspectHistories = inspectService.getInspectHistoryList(payCalculateDTO);
                        if (CollectionUtils.isEmpty(inspectHistories)) {
                            continue;
                        }
                        int qualifiedNumberTotal = 0;
                        BigDecimal multiplyPrice = new BigDecimal("0");
                        for (InspectHistory inspectHistory : inspectHistories) {
                            // 合格数量x工序价格+基本工资
                            Integer qualifiedNumber = inspectHistory.getQualifiedNumber();
                            // 去重数量
                            productMap.put(inspectHistory.getId() + orderId, qualifiedNumber);
                            qualifiedNumberTotal = qualifiedNumberTotal + qualifiedNumber;
                            totalCount = totalCount + qualifiedNumber;
                            BigDecimal multiply = hourPrice.multiply(new BigDecimal(qualifiedNumber));
                            multiplyPrice = multiplyPrice.add(multiply);
                            totalAmount = totalAmount.add(multiply);
                        }
                        procedure.setTotalCount(qualifiedNumberTotal);
                        procedure.setTotalPrice(multiplyPrice);
                        payOrderUserRelationProcedureMapper.updateByPrimaryKeySelective(procedure);
                    } else if (CommonEnum.WorkShopTypeEnum.AUTO_CONTROL.name.equals(workshopName)) {
                        AutoControlEntrust entrust = autoControlEntrustMapper.selectByPrimaryKey(procedure.getProductId());
                        PayCalculateDTO payCalculateDTO = buildPayCalculateDTO(orderId, entrust.getGraphNo(), startTime, endTime);
                        payCalculateDTO.setStorageStatus(null);
                        List<AutoControlInspectHistory> inspectHistories = autoControlEntrustService.getInspectHistoryList(payCalculateDTO);
                        if (CollectionUtils.isEmpty(inspectHistories)) {
                            continue;
                        }
                        int qualifiedNumberTotal = 0;
                        BigDecimal multiplyPrice = new BigDecimal("0");
                        for (AutoControlInspectHistory inspectHistory : inspectHistories) {
                            // 合格数量x工序价格+基本工资
                            Integer qualifiedNumber = inspectHistory.getQualifiedNumber();
                            qualifiedNumberTotal = qualifiedNumberTotal + qualifiedNumber;
                            // 去重数量
                            productMap.put(inspectHistory.getId() + orderId, qualifiedNumber);
                            totalCount = totalCount + qualifiedNumber;
                            BigDecimal multiply = hourPrice.multiply(new BigDecimal(qualifiedNumber));
                            multiplyPrice = multiplyPrice.add(multiply);
                            totalAmount = totalAmount.add(multiply);
                        }
                        procedure.setTotalCount(qualifiedNumberTotal);
                        procedure.setTotalPrice(multiplyPrice);
                        payOrderUserRelationProcedureMapper.updateByPrimaryKeySelective(procedure);
                    } else if (CommonEnum.WorkShopTypeEnum.VALVE_SEAT_ENTRUST.name.equals(workshopName)) {
                        ValveSeatEntrust entrust = valveSeatEntrustMapper.selectByPrimaryKey(procedure.getProductId());
                        PayCalculateDTO payCalculateDTO = buildPayCalculateDTO(orderId, entrust.getGraphNo(), startTime, endTime);
                        List<ValveSeatInspectHistory> inspectHistories = valveSeatEntrustService.getInspectHistoryList(payCalculateDTO);
                        if (CollectionUtils.isEmpty(inspectHistories)) {
                            continue;
                        }
                        int qualifiedNumberTotal = 0;
                        BigDecimal multiplyPrice = new BigDecimal("0");
                        for (ValveSeatInspectHistory inspectHistory : inspectHistories) {
                            // 合格数量x工序价格+基本工资
                            Integer qualifiedNumber = inspectHistory.getQualifiedNumber();
                            qualifiedNumberTotal = qualifiedNumberTotal + qualifiedNumber;
                            // 去重数量
                            productMap.put(inspectHistory.getId() + orderId, qualifiedNumber);
                            totalCount = totalCount + qualifiedNumber;
                            BigDecimal multiply = hourPrice.multiply(new BigDecimal(qualifiedNumber));
                            multiplyPrice = multiplyPrice.add(multiply);
                            totalAmount = totalAmount.add(multiply);

                        }
                        procedure.setTotalCount(qualifiedNumberTotal);
                        procedure.setTotalPrice(multiplyPrice);
                        payOrderUserRelationProcedureMapper.updateByPrimaryKeySelective(procedure);
                    }
                }
            } else if (CommonEnum.UserType.MARRIED.type.equals(userType)) {
                // 查询工资查询表
                PayWagesSearchExample example = new PayWagesSearchExample();
                PayWagesSearchExample.Criteria criteria = example.createCriteria();
                criteria.andUserIdEqualTo(userId);
                criteria.andWagesYearEqualTo(payWagesVO.getYear());
                criteria.andWagesMonthEqualTo(payWagesVO.getMonth());
                List<PayWagesSearch> payWagesSearches = payWagesSearchMapper.selectByExample(example);
                if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(payWagesSearches)) {
                    PayWagesSearch payWagesSearch = payWagesSearches.get(0);
                    payWage.setUpdateUser(getLoginUserName());
                    payWage.setUpdateTime(new Date());
                    payWage.setRequiredAttendanceDays(DateFormatterUtils.getCurrentCountDays(startTime, endTime));
                    payWage.setUpdateUser(getLoginUserName());
                    payWage.setUpdateTime(new Date());
                    payWage.setByPieceCount(0);
                    payWage.setByPieceMoney(new BigDecimal("0"));
                    payWage.setAccruedPerformanceSalary(payWagesSearch.getAccruedPerformanceSalary());
                    payWage.setTotalMoney(payWagesSearch.getTotalMoney());
                    // 计算扣分后的工资
                    BigDecimal calculateScorec = calculateScore(userId, payWagesVO, payWagesSearch.getTotalMoney());
                    payWage.setNetSalaryMoney(calculateScorec);
                    payWagesMapper.updateByPrimaryKeySelective(payWage);
                } else {
                    payWage.setUpdateUser(getLoginUserName());
                    payWage.setUpdateTime(new Date());
                    payWage.setRequiredAttendanceDays(DateFormatterUtils.getCurrentCountDays(startTime, endTime));
                    payWage.setUpdateUser(getLoginUserName());
                    payWage.setUpdateTime(new Date());
                    payWage.setByPieceCount(0);
                    payWage.setByPieceMoney(new BigDecimal("0"));
                    payWage.setTotalMoney(payWage.getMinLiveSecurityFund());
                    // 计算扣分后的工资
                    BigDecimal calculateScorec = calculateScore(userId, payWagesVO, minLiveSecurityFund);
                    payWage.setNetSalaryMoney(calculateScorec);
                    payWagesMapper.updateByPrimaryKeySelective(payWage);
                }
                continue;
            }
            minLiveSecurityFund = minLiveSecurityFund.add(totalAmount);
            // 计算扣分后的工资
            BigDecimal calculateScorec = calculateScore(userId, payWagesVO, minLiveSecurityFund);
            int priceCount = 0;
            for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
                priceCount = priceCount + entry.getValue();
            }
            payWage.setUpdateUser(getLoginUserName());
            payWage.setUpdateTime(new Date());
            payWage.setByPieceCount(priceCount);
            payWage.setByPieceMoney(totalAmount);
            payWage.setTotalMoney(minLiveSecurityFund);
            payWage.setNetSalaryMoney(calculateScorec);
            payWage.setRequiredAttendanceDays(DateFormatterUtils.getCurrentCountDays(startTime, endTime));
            payWagesMapper.updateByPrimaryKeySelective(payWage);
        }
        return null;
    }

    /**
     * 人员计算扣分项
     * @param userId
     * @param payWagesVO
     * @param minLiveSecurityFund
     * @return
     */
    private BigDecimal calculateScore(Integer userId, PayWagesVO payWagesVO, BigDecimal minLiveSecurityFund) {
        // 人员计算扣分项
        PayAssessmentScoreExample payAssessmentScoreExample = new PayAssessmentScoreExample();
        payAssessmentScoreExample.createCriteria().andUserIdEqualTo(userId).andScoreYearEqualTo(payWagesVO.getYear())
            .andScoreMonthEqualTo(payWagesVO.getMonth());
        BigDecimal multiply = minLiveSecurityFund;
        List<PayAssessmentScore> payAssessmentScores = payAssessmentScoreMapper.selectByExample(payAssessmentScoreExample);
        if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(payAssessmentScores)) {
            PayAssessmentScore payAssessmentScore = payAssessmentScores.get(0);
            Integer score = payAssessmentScore.getScore();
            BigDecimal bigDecimal = new BigDecimal(score);
            BigDecimal divide = bigDecimal.divide(new BigDecimal("100"));
            // 扣完分工资
            multiply = minLiveSecurityFund.multiply(divide);
        }
        return multiply;
    }

    /**
     * 处理考勤数据
     * @param userId
     * @param payWagesVO
     * @param payWage
     */
    private void buildPayWorkAttendanceInfo(Integer userId, PayWagesVO payWagesVO, PayWages payWage) {
        PayWorkAttendanceExample payWorkAttendanceExample = new PayWorkAttendanceExample();
        payWorkAttendanceExample.createCriteria().andUserIdEqualTo(userId).andAttendYearEqualTo(payWagesVO.getYear()).andAttendMonthEqualTo(payWagesVO.getMonth());
        List<PayWorkAttendance> payWorkAttendances = payWorkAttendanceMapper.selectByExample(payWorkAttendanceExample);
        if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(payWorkAttendances)) {
            PayWorkAttendance payWorkAttendance = payWorkAttendances.get(0);
            payWage.setActualAttendanceDays(payWorkAttendance.getAttendanceDays());
            payWage.setLateAndLeaveTimes(payWorkAttendance.getLateAndLeaveTimes());
            payWage.setAbsenteeismTimes(payWorkAttendance.getAbsenteeismTimes());
        }
    }

    private PayCalculateDTO buildPayCalculateDTO(String orderId, String productNo, Date startTime, Date endTime) {
        PayCalculateDTO proInspectRecord = new PayCalculateDTO();
        proInspectRecord.setOrderNo(orderId);
        proInspectRecord.setProductNo(productNo);
        // 已入库的单子
        proInspectRecord.setStorageStatus((byte) 2);
        proInspectRecord.setStartTime(startTime);
        proInspectRecord.setEndTime(endTime);
        return proInspectRecord;
    }


    public ResultBean test(Integer userId) {
        PayWagesRelationUser payWagesRelationUser = new PayWagesRelationUser();
        payWagesRelationUser.setUserId(userId);
        List<PayWagesRelationUser> list = payWagesRelationUserService.getList(payWagesRelationUser);
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("1111");
        }
        System.out.println("22222");
        return null;
    }

    @Override
    public void createWages(PayWagesVO payWagesVO) throws Exception {
        if (StringUtils.isBlank(payWagesVO.getYear()) || StringUtils.isBlank(payWagesVO.getMonth())) {
            throw new Exception("年份或月份不能为空");
        }
        List<PayWages> payWages = payWagesMapper.selectByExample(new PayWagesExample());
        for (PayWages payWage : payWages) {
            // 先查关联表
            PayWagesRelationUser payWagesRelationUser = new PayWagesRelationUser();
            payWagesRelationUser.setWagesId(payWage.getId());
            List<PayWagesRelationUser> list = payWagesRelationUserService.getList(payWagesRelationUser);
            if (CollectionUtils.isEmpty(list)) {
                log.info("PayWagesRelationUser is null, wagesId:{}", payWage.getId());
                continue;
            }
            Integer userId = list.get(0).getUserId();
            // 生成工资列表
            PayWagesSearchExample example = new PayWagesSearchExample();
            PayWagesSearchExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            criteria.andWagesYearEqualTo(payWagesVO.getYear());
            criteria.andWagesMonthEqualTo(payWagesVO.getMonth());
            List<PayWagesSearch> payWagesSearches = payWagesSearchMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(payWagesSearches)) {
                PayWagesSearch payWagesSearch = new PayWagesSearch();
                BeanCopyUtils.copyProperties(payWage, payWagesSearch);
                payWagesSearch.setUserId(userId);
                payWagesSearch.setId(null);
                payWagesSearch.setWagesYear(payWagesVO.getYear());
                payWagesSearch.setWagesMonth(payWagesVO.getMonth());
                payWagesSearch.setCreateTime(new Date());
                payWagesSearch.setUpdateTime(new Date());
                payWagesSearch.setCreateUser(getLoginUserName());
                payWagesSearch.setUpdateUser(getLoginUserName());
                payWagesSearchMapper.insertSelective(payWagesSearch);
            } else {
                PayWagesSearch payWagesSearch = new PayWagesSearch();
                BeanCopyUtils.copyProperties(payWage, payWagesSearch);
                payWagesSearch.setUserId(userId);
                payWagesSearch.setId(payWagesSearches.get(0).getId());
                payWagesSearch.setUpdateTime(new Date());
                payWagesSearch.setUpdateUser(getLoginUserName());
                payWagesSearchMapper.updateByPrimaryKeySelective(payWagesSearch);
            }
        }

    }

    @Override
    public ExcelWriter export() {
        List<PayWages> payWages = payWagesMapper.selectByExample(new PayWagesExample());
        List<PayWagesExcelVO> payWagesExcelVOS = BeanCopyUtils.copyPropertiesForNewList(payWages, () -> new PayWagesExcelVO());
        ExcelWriter excelWriter = ExcelUtils.exportExcel(payWagesExcelVOS, PayWagesExcelVO.class);
        return excelWriter;
    }

}
