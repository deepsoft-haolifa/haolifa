package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayWagesMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.InspectHistoryDto;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayHourQuotaDTO;
import com.deepsoft.haolifa.model.dto.pay.PayWagesDTO;
import com.deepsoft.haolifa.model.dto.pay.PayWagesVO;
import com.deepsoft.haolifa.service.*;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 考核指标
 */
@Service
public class PayWagesServiceImpl extends BaseService implements PayWagesService {
    @Resource
    private PayWagesMapper payWagesMapper;
    @Resource
    private PayOrderUserRelationProcedureService payOrderUserRelationProcedureService;
    @Resource
    private InspectService inspectService;
    @Resource
    private PayHourQuotaService payHourQuotaService;
    @Resource
    private PayWagesRelationUserService payWagesRelationUserService;

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
    public ResultBean save(PayWages model) {
        model.setCreateUser(getLoginUserName());
        model.setUpdateUser(getLoginUserName());
        model.setCreateTime(new Date());
        model.setUpdateTime(new Date());
        payWagesMapper.insert(model);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer wagesId) {
        return ResultBean.success(payWagesMapper.selectByPrimaryKey(wagesId));
    }

    @Override
    public ResultBean edit(PayWages model) {
        model.setUpdateUser(getLoginUserName());
        model.setUpdateTime(new Date());
        payWagesMapper.updateByPrimaryKeySelective(model);
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
            if (Objects.isNull(payWage.getUpdateTime())) {
                payWage.setUpdateTime(new Date());
            }
            if (StringUtils.isEmpty(payWage.getCreateUser())) {
                payWage.setCreateUser(getLoginUserName());
            }
            if (StringUtils.isEmpty(payWage.getUpdateUser())) {
                payWage.setUpdateUser(getLoginUserName());
            }
            payWagesMapper.insert(payWage);
        }
    }

    @Override
    public ResultBean calculateSalary(PayWagesVO payWagesVO) {
        List<PayOrderUserRelationProcedure> payOrderUserRelationProcedureList = payOrderUserRelationProcedureService.getPayOrderUserRelationProcedureList();
        if (CollectionUtils.isEmpty(payOrderUserRelationProcedureList)) {
            return ResultBean.success(new ArrayList<>());
        }
        for (PayOrderUserRelationProcedure payOrderUserRelationProcedure : payOrderUserRelationProcedureList) {
            String orderId = payOrderUserRelationProcedure.getOrderId();
            Integer userId = payOrderUserRelationProcedure.getUserId();
            BigDecimal totalAmount = new BigDecimal("0");
            Integer qualifiedNumber = null;
            // 1: 零件质检记录
            List<InspectHistory> inspectHistoryDtos = inspectService.historyList(orderId, payWagesVO.getStartCreateTime(), payWagesVO.getEndCreateTime());
            if (null != inspectHistoryDtos && inspectHistoryDtos.size() > 0) {
                for (InspectHistory inspectHistory : inspectHistoryDtos) {
                    // 合格数量
                    qualifiedNumber = inspectHistory.getQualifiedNumber();
                    List<PayHourQuota> list = payHourQuotaService.getList(buildPayHourQuotaDTO(inspectHistory));
                    if (Objects.nonNull(list) && list.size() > 0) {
                        PayHourQuota payHourQuota = list.get(0);
                        // 价格
                        BigDecimal hourQuotaPrice = payHourQuota.getHourQuotaPrice();
                        BigDecimal amount = hourQuotaPrice.multiply(new BigDecimal(qualifiedNumber));
                        totalAmount = totalAmount.add(amount);
                    }

                }
            }
            PayWagesRelationUser payWagesRelationUser = new PayWagesRelationUser();
            payWagesRelationUser.setUserId(userId);
            List<PayWagesRelationUser> list = payWagesRelationUserService.getList(payWagesRelationUser);
            if (CollectionUtils.isEmpty(list)) {
                continue;
            }
            PayWages model = new PayWages();
            model.setId(list.get(0).getWagesId());
            model.setUpdateUser(getLoginUserName());
            model.setUpdateTime(new Date());
            model.setByPieceCount(qualifiedNumber);
            model.setByPieceMoney(totalAmount);
            payWagesMapper.updateByPrimaryKeySelective(model);
        }
        return null;
    }

    private PayHourQuotaDTO buildPayHourQuotaDTO(InspectHistory inspectHistoryDto) {
        PayHourQuotaDTO payHourQuotaDTO = new PayHourQuotaDTO();
        // D220-0050-01
        String materialGraphNo = inspectHistoryDto.getMaterialGraphNo();
        // 物料名称
        payHourQuotaDTO.setWorkType(inspectHistoryDto.getMaterialGraphName());
        String[] split = materialGraphNo.split("-");
        // 型号
        String type = split[0];
        // 规格
        String specs = "DN" + Integer.parseInt(split[1]);
        payHourQuotaDTO.setAppModel(type);
        payHourQuotaDTO.setAppSpecifications(specs);
        return payHourQuotaDTO;
    }

    public static void main(String[] args) {
        String materialGraphNo = "D220-0050-01";
        String[] split = materialGraphNo.split("-");
        // 型号
        String type = split[0];
        // 规格
        String specs = "DN" + Integer.parseInt(split[1]);
        System.out.println(type + "," + specs);
    }
}
