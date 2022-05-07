package com.deepsoft.haolifa.service.impl;

import cn.hutool.poi.excel.ExcelWriter;
import com.deepsoft.haolifa.dao.repository.PayUserMapper;
import com.deepsoft.haolifa.dao.repository.PayWorkAttendanceMapper;
import com.deepsoft.haolifa.model.domain.PayUser;
import com.deepsoft.haolifa.model.domain.PayUserExample;
import com.deepsoft.haolifa.model.domain.PayWorkAttendance;
import com.deepsoft.haolifa.model.domain.PayWorkAttendanceExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWorkAttendancePageDTO;
import com.deepsoft.haolifa.service.PayWorkAttendanceService;
import com.deepsoft.haolifa.util.BeanCopyUtils;
import com.deepsoft.haolifa.util.ExcelUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
    @Resource
    private PayUserMapper payUserMapper;
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
        if (StringUtils.isNotBlank(model.getAttendYear())) {
            criteria.andAttendYearEqualTo(model.getAttendYear());
        }
        if (StringUtils.isNotBlank(model.getAttendMonth())) {
            criteria.andAttendMonthEqualTo(model.getAttendMonth());
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
            PayWorkAttendancePageDTO dto = new PayWorkAttendancePageDTO();
            dto.setAttendYear(payWorkAttendance.getAttendYear());
            dto.setAttendMonth(payWorkAttendance.getAttendMonth());
            dto.setUserId(payWorkAttendance.getUserId());
            List<PayWorkAttendance> list = getList(dto);
            if (Objects.isNull(payWorkAttendance.getUpdateTime())) {
                payWorkAttendance.setUpdateTime(new Date());
            }
            if (StringUtils.isEmpty(payWorkAttendance.getUpdateUser())) {
                payWorkAttendance.setUpdateUser(getLoginUserName());
            }
            if (CollectionUtils.isEmpty(list)) {
                if (Objects.isNull(payWorkAttendance.getCreateTime())) {
                    payWorkAttendance.setCreateTime(new Date());
                }
                if (StringUtils.isEmpty(payWorkAttendance.getCreateUser())) {
                    payWorkAttendance.setCreateUser(getLoginUserName());
                }
                payWorkAttendanceMapper.insert(payWorkAttendance);
            } else {
                PayWorkAttendanceExample example = new PayWorkAttendanceExample();
                example.createCriteria().andAttendYearEqualTo(payWorkAttendance.getAttendYear())
                        .andAttendMonthEqualTo(payWorkAttendance.getAttendMonth())
                            .andUserIdEqualTo(payWorkAttendance.getUserId());
                payWorkAttendanceMapper.updateByExampleSelective(payWorkAttendance, example);
            }
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
        payWorkAttendanceMapper.updateByPrimaryKeySelective(payWorkAttendance);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer id) {
        return ResultBean.success(payWorkAttendanceMapper.deleteByPrimaryKey(id));
    }

    @Override
    public ExcelWriter export(PayWorkAttendancePageDTO payWorkAttendancePageDTO) {
        List<PayWorkAttendance> payManagerCals = getList(payWorkAttendancePageDTO);
        List<PayWorkAttendancePageDTO> payWorkAttendancePageDTOS = BeanCopyUtils.copyPropertiesForNewList(payManagerCals, () -> new PayWorkAttendancePageDTO());
        ExcelWriter excelWriter = ExcelUtils.exportExcel(payWorkAttendancePageDTOS, PayWorkAttendancePageDTO.class);
        return excelWriter;
    }

    @Override
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void createAttendance(PayWorkAttendancePageDTO payWorkAttendancePageDTO) throws Exception {
        PayWorkAttendanceExample example = new PayWorkAttendanceExample();
        example.createCriteria().andAttendYearEqualTo(payWorkAttendancePageDTO.getAttendYear())
                .andAttendMonthEqualTo(payWorkAttendancePageDTO.getAttendMonth());
        List<PayWorkAttendance> payWorkAttendances = payWorkAttendanceMapper.selectByExample(example);
        if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(payWorkAttendances)) {
            throw new Exception("已生成"+payWorkAttendancePageDTO.getAttendMonth()+"月绩效，请重新选择");
        }
        List<PayUser> payUsers = payUserMapper.selectByExample(new PayUserExample());
        for (PayUser payUser : payUsers) {
            PayWorkAttendance payWorkAttendance = new PayWorkAttendance();
            payWorkAttendance.setSerial(0);
            payWorkAttendance.setDepartment(payUser.getDepartName());
            payWorkAttendance.setUserId(payUser.getId());
            payWorkAttendance.setAttendMonth(payWorkAttendancePageDTO.getAttendMonth());
            payWorkAttendance.setAttendYear(payWorkAttendancePageDTO.getAttendYear());
            payWorkAttendance.setUserName(payUser.getUserName());
            payWorkAttendance.setAttendanceDays(0);
            payWorkAttendance.setLateTimes(0);
            payWorkAttendance.setLeaveEarlyTimes(0);
            payWorkAttendance.setAbsenteeismTimes(0);
            payWorkAttendance.setMiddleDays(0);
            payWorkAttendance.setNightDays(0);
            payWorkAttendance.setBusinessTravelDays(0);
            payWorkAttendance.setCompassionateLeaveDays(0);
            payWorkAttendance.setSickLeaveDays(0);
            payWorkAttendance.setWorkOvertimeDays(0);
            payWorkAttendance.setLateAndLeaveTimes(0);
            payWorkAttendance.setRemark("");
            payWorkAttendance.setCreateUser(getLoginUserName());
            payWorkAttendance.setUpdateUser(getLoginUserName());
            payWorkAttendance.setCreateTime(new Date());
            payWorkAttendance.setUpdateTime(new Date());
            payWorkAttendanceMapper.insert(payWorkAttendance);
        }
    }

    private List<PayWorkAttendance> getList(PayWorkAttendancePageDTO model) {
        PayWorkAttendanceExample example = new PayWorkAttendanceExample();
        PayWorkAttendanceExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getDepartment())) {
            criteria.andDepartmentEqualTo(model.getDepartment());
        }
        if (StringUtils.isNotBlank(model.getUserName())) {
            criteria.andUserNameEqualTo(model.getUserName());
        }
        if (StringUtils.isNotBlank(model.getAttendYear())) {
            criteria.andAttendYearEqualTo(model.getAttendYear());
        }
        if (StringUtils.isNotBlank(model.getAttendMonth())) {
            criteria.andAttendMonthEqualTo(model.getAttendMonth());
        }
        if (Objects.nonNull(model.getUserId())) {
            criteria.andUserIdEqualTo(model.getUserId());
        }
        List<PayWorkAttendance> payWorkAttendances = payWorkAttendanceMapper.selectByExample(example);
        return payWorkAttendances;
    }
}
