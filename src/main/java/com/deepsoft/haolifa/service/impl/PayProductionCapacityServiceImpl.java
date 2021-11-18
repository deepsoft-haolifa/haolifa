package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayProductionCapacityMapper;
import com.deepsoft.haolifa.model.domain.PayProductionCapacity;
import com.deepsoft.haolifa.model.domain.PayProductionCapacityExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayProductCapacityDTO;
import com.deepsoft.haolifa.service.PayProductionCapacityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 考核指标
 */
@Service
class PayProductionCapacityServiceImpl extends BaseService implements PayProductionCapacityService {
    @Resource
    private PayProductionCapacityMapper payProductionCapacityMapper;

    @Override
    public ResultBean pageInfo(Integer pageSize, Integer pageNumber, String capacityName, String capacityCode) {
        PayProductionCapacityExample example = new PayProductionCapacityExample();
        PayProductionCapacityExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(capacityName)) {
            criteria.andCapacityNameLike("%" + capacityName + "%");
        }
        if (StringUtils.isNotBlank(capacityCode)) {
            criteria.andCapacityCodeLike("%" + capacityCode + "%");
        }
        example.setOrderByClause("id desc");
        Page<PayProductionCapacity> payTeams = PageHelper.startPage(pageNumber, pageSize)
            .doSelectPage(() -> payProductionCapacityMapper.selectByExample(example));
        PageDTO<PayProductionCapacity> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payTeams, pageDTO);
        pageDTO.setList(payTeams);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean delete(Integer capacityId) {
        return ResultBean.success(payProductionCapacityMapper.deleteByPrimaryKey(capacityId));
    }

    @Override
    public ResultBean save(PayProductCapacityDTO model) {
        PayProductionCapacity payTeam = new PayProductionCapacity();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setCreateUser(getLoginUserName());
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setCreateTime(new Date());
        payTeam.setUpdateTime(new Date());
        payProductionCapacityMapper.insert(payTeam);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer teamId) {
        return ResultBean.success(payProductionCapacityMapper.selectByPrimaryKey(teamId));
    }

    @Override
    public ResultBean edit(PayProductCapacityDTO model) {
        PayProductionCapacity payTeam = new PayProductionCapacity();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setUpdateTime(new Date());
        payProductionCapacityMapper.updateByPrimaryKeySelective(payTeam);
        return ResultBean.success(1);
    }
}
