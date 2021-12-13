package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayWorkAttendanceMapper;
import com.deepsoft.haolifa.model.domain.PayWorkAttendance;
import com.deepsoft.haolifa.model.domain.PayWorkAttendanceExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWorkAttendancePageDTO;
import com.deepsoft.haolifa.service.PayWorkAttendanceService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author liuyaofei
 * @Date create in 上午11:41 2021/9/11
 * @description
 */
@Service
public class PayWorkAttendanceServiceImpl extends BaseService implements PayWorkAttendanceService {

    @Resource
    private PayWorkAttendanceMapper payWorkAttendanceMapper;
    @Override
    public ResultBean pageInfo(PayWorkAttendancePageDTO model) {
        PayWorkAttendanceExample example = new PayWorkAttendanceExample();
        PayWorkAttendanceExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getDepartment())) {
            criteria.andDepartmentLike("%" + model.getDepartment() + "%");
        }
        if (StringUtils.isNotBlank(model.getUserName())) {
            criteria.andUserNameLike("%" + model.getUserName() + "%");
        }
        if (Objects.nonNull(model.getAttendanceDays())) {
            criteria.andAttendanceDaysEqualTo(model.getAttendanceDays());
        }
        if (Objects.nonNull(model.getLateTimes())) {
            criteria.andLateTimesEqualTo(model.getLateTimes());
        }
        if (Objects.nonNull(model.getLeaveEarlyTimes())) {
            criteria.andLeaveEarlyTimesEqualTo(model.getLeaveEarlyTimes());
        }
        if (Objects.nonNull(model.getAbsenteeismTimes())) {
            criteria.andAbsenteeismTimesEqualTo(model.getAbsenteeismTimes());
        }
        if (Objects.nonNull(model.getMiddleDays())) {
            criteria.andMiddleDaysEqualTo(model.getMiddleDays());
        }
        if (Objects.nonNull(model.getNightDays())) {
            criteria.andNightDaysEqualTo(model.getNightDays());
        }
        if (Objects.nonNull(model.getBusinessTravelDays())) {
            criteria.andBusinessTravelDaysEqualTo(model.getBusinessTravelDays());
        }
        if (Objects.nonNull(model.getCompassionateLeaveDays())) {
            criteria.andCompassionateLeaveDaysEqualTo(model.getCompassionateLeaveDays());
        }
        if (Objects.nonNull(model.getSickLeaveDays())) {
            criteria.andSickLeaveDaysEqualTo(model.getSickLeaveDays());
        }
        if (Objects.nonNull(model.getWorkOvertimeDays())) {
            criteria.andWorkOvertimeDaysEqualTo(model.getWorkOvertimeDays());
        }
        if (Objects.nonNull(model.getLateAndLeaveTimes())) {
            criteria.andLateAndLeaveTimesEqualTo(model.getLateAndLeaveTimes());
        }
        if (Objects.nonNull(model.getNightDays())) {
            criteria.andNightDaysEqualTo(model.getNightDays());
        }
        if (Objects.nonNull(model.getNightDays())) {
            criteria.andNightDaysEqualTo(model.getNightDays());
        }
        if (StringUtils.isNotBlank(model.getCreateUser())) {
            criteria.andCreateUserLike("%" + model.getCreateUser() + "%");
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
        Page<PayWorkAttendance> payWorkAttendances = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> payWorkAttendanceMapper.selectByExample(example));

        PageDTO<PayWorkAttendance> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payWorkAttendances, pageDTO);
        pageDTO.setList(payWorkAttendances);
        return ResultBean.success(pageDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Async
    public void insert(List<PayWorkAttendance> payWorkAttendances) {
        for (PayWorkAttendance payWorkAttendance : payWorkAttendances) {
            if (Objects.isNull(payWorkAttendance.getCreateTime())) {
                payWorkAttendance.setCreateTime(new Date());
            }
            if (Objects.isNull(payWorkAttendance.getUpdateTime())) {
                payWorkAttendance.setUpdateTime(new Date());
            }
            if (StringUtils.isEmpty(payWorkAttendance.getCreateUser())) {
                payWorkAttendance.setCreateUser(getLoginUserName());
            }
            if (StringUtils.isEmpty(payWorkAttendance.getUpdateUser())) {
                payWorkAttendance.setUpdateUser(getLoginUserName());
            }
            payWorkAttendanceMapper.insert(payWorkAttendance);
        }
    }

    @Override
    public ResultBean save(PayWorkAttendancePageDTO model) {
        PayWorkAttendance payWorkAttendance = new PayWorkAttendance();
        BeanUtils.copyProperties(model, payWorkAttendance);
        payWorkAttendance.setCreateTime(new Date());
        payWorkAttendance.setUpdateTime(new Date());
        payWorkAttendance.setCreateUser(getLoginUserName());
        payWorkAttendance.setUpdateUser(getLoginUserName());
        payWorkAttendanceMapper.insert(payWorkAttendance);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        return ResultBean.success(payWorkAttendanceMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResultBean edit(PayWorkAttendancePageDTO model) {
        PayWorkAttendance payWorkAttendance = new PayWorkAttendance();
        BeanUtils.copyProperties(model, payWorkAttendance);
        payWorkAttendance.setUpdateTime(new Date());
        payWorkAttendance.setUpdateUser(getLoginUserName());
        return ResultBean.success(payWorkAttendanceMapper.updateByPrimaryKeySelective(payWorkAttendance));
    }

    @Override
    public ResultBean delete(Integer id) {
        return ResultBean.success(payWorkAttendanceMapper.deleteByPrimaryKey(id));
    }
}
