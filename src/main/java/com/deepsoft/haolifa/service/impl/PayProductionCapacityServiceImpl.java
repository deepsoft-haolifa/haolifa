package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayProductionCapacityMapper;
import com.deepsoft.haolifa.dao.repository.PayProductionWorkshopMapper;
import com.deepsoft.haolifa.dao.repository.PayTeamMapper;
import com.deepsoft.haolifa.dao.repository.PayUserMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayProductCapacityDTO;
import com.deepsoft.haolifa.model.vo.PayProductCapacityVO;
import com.deepsoft.haolifa.service.PayProductionCapacityService;
import com.deepsoft.haolifa.util.BeanCopyUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 生产能力
 */
@Service
class PayProductionCapacityServiceImpl extends BaseService implements PayProductionCapacityService {
    @Resource
    private PayProductionCapacityMapper PayProductionCapacityMapper;
    @Resource
    private PayUserMapper payUserMapper;
    @Resource
    private PayTeamMapper payTeamMapper;
    @Resource
    private PayProductionWorkshopMapper payProductionWorkshopMapper;
    @Override
    public ResultBean pageInfo(PayProductCapacityDTO model) {
        PayProductionCapacityExample example = new PayProductionCapacityExample();
        PayProductionCapacityExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(model.getUserId())) {
            criteria.andUserIdEqualTo(model.getUserId());
        }
        if (Objects.nonNull(model.getTeamId())) {
            criteria.andUserIdEqualTo(model.getTeamId());
        }
        if (Objects.nonNull(model.getDepartId())) {
            criteria.andUserIdEqualTo(model.getDepartId());
        }
        example.setOrderByClause("id desc");
        Page<PayProductionCapacity> payProductionCapacities = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> PayProductionCapacityMapper.selectByExample(example));

        List<PayProductCapacityVO> payProductCapacityVOS = BeanCopyUtils.copyPropertiesForNewList(payProductionCapacities, () -> new PayProductCapacityVO());
        if (CollectionUtils.isNotEmpty(payProductCapacityVOS)) {
            payProductCapacityVOS.stream().forEach(capacity -> {
                PayUser payUser = payUserMapper.selectByPrimaryKey(capacity.getUserId());
                capacity.setUserName(Objects.isNull(payUser) ? "" : payUser.getUserName());
                PayTeam payTeam = payTeamMapper.selectByPrimaryKey(capacity.getTeamId());
                capacity.setTeamName(Objects.isNull(payTeam) ? "" : payTeam.getTeamName());
                PayProductionWorkshop payProductionWorkshop = payProductionWorkshopMapper.selectByPrimaryKey(capacity.getDepartId());
                capacity.setDepartName(Objects.isNull(payProductionWorkshop) ? "" : payProductionWorkshop.getDepartName());
            });
        }
        PageDTO<PayProductCapacityVO> pageDTO = new PageDTO<>();
        pageDTO.setList(payProductCapacityVOS);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean delete(Integer capacityId) {
        return ResultBean.success(PayProductionCapacityMapper.deleteByPrimaryKey(capacityId));
    }

    @Override
    public List<PayProductionCapacity> getList(PayProductCapacityDTO model) {
        PayProductionCapacityExample example = new PayProductionCapacityExample();
        PayProductionCapacityExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getDepartName())) {
            criteria.andDepartNameEqualTo(model.getDepartName());
        }
        return PayProductionCapacityMapper.selectByExample(example);
    }

    @Override
    public ResultBean save(PayProductCapacityDTO model) {
        PayProductionCapacity payTeam = new PayProductionCapacity();
        BeanUtils.copyProperties(model, payTeam);
        if (Objects.nonNull(payTeam.getDepartId())) {
            PayProductionWorkshop payProductionWorkshop = payProductionWorkshopMapper.selectByPrimaryKey(payTeam.getDepartId());
            payTeam.setDepartName(payProductionWorkshop.getDepartName());
        }
        payTeam.setCreateUser(getLoginUserName());
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setCreateTime(new Date());
        payTeam.setUpdateTime(new Date());
        PayProductionCapacityMapper.insert(payTeam);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer teamId) {
        return ResultBean.success(PayProductionCapacityMapper.selectByPrimaryKey(teamId));
    }

    @Override
    public ResultBean edit(PayProductCapacityDTO model) {
        PayProductionCapacity payTeam = new PayProductionCapacity();
        BeanUtils.copyProperties(model, payTeam);
        if (Objects.nonNull(payTeam.getDepartId())) {
            PayProductionWorkshop payProductionWorkshop = payProductionWorkshopMapper.selectByPrimaryKey(payTeam.getDepartId());
            payTeam.setDepartName(payProductionWorkshop.getDepartName());
        }
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setUpdateTime(new Date());
        PayProductionCapacityMapper.updateByPrimaryKeySelective(payTeam);
        return ResultBean.success(1);
    }
}
