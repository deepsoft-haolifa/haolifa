package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayProductionWorkshopMapper;
import com.deepsoft.haolifa.dao.repository.PayTeamMapper;
import com.deepsoft.haolifa.dao.repository.PayUserMapper;
import com.deepsoft.haolifa.model.domain.PayUser;
import com.deepsoft.haolifa.model.domain.PayUserExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayUserDTO;
import com.deepsoft.haolifa.service.PayUserService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
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
 * @description 人员管理
 */
@Service
public class PayUserServiceImpl extends BaseService implements PayUserService {
    @Resource
    private PayUserMapper payUserMapper;
    @Resource
    private PayTeamMapper payTeamMapper;
    @Resource
    private PayProductionWorkshopMapper payProductionWorkshopMapper;

    @Override
    public ResultBean pageInfo(PayUserDTO model) {
        PayUserExample example = new PayUserExample();
        PayUserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getUserName())) {
            criteria.andUserNameLike("%" + model.getUserName() + "%");
        }
        if (null != model.getSex() && model.getSex() > 0) {
            criteria.andSexEqualTo(model.getSex());
        }
        if (StringUtils.isNotBlank(model.getNation())) {
            criteria.andNationLike("%" + model.getNation() + "%");
        }
        if (StringUtils.isNotBlank(model.getPoliticalOutlook())) {
            criteria.andPoliticalOutlookLike("%" + model.getPoliticalOutlook() + "%");
        }
        if (StringUtils.isNotBlank(model.getBloodType())) {
            criteria.andBloodTypeEqualTo(model.getBloodType());
        }
        if (StringUtils.isNotBlank(model.getHealth())) {
            criteria.andHealthLike("%" + model.getHealth() + "%");
        }
        if (Objects.nonNull(model.getMarryStatus()) && model.getMarryStatus() > 0) {
            criteria.andMarryStatusEqualTo(model.getMarryStatus());
        }
        if (StringUtils.isNotBlank(model.getUniversityFrom())) {
            criteria.andUniversityFromLike("%" + model.getUniversityFrom() + "%");
        }
        if (StringUtils.isNotBlank(model.getMajor())) {
            criteria.andMajorLike("%" + model.getMajor() + "%");
        }
        if (Objects.nonNull(model.getEducation()) && model.getEducation() > 0) {
            criteria.andEducationEqualTo(model.getMarryStatus());
        }
        if (StringUtils.isNotEmpty(model.getStartGraduationTime())) {
            Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getStartGraduationTime());
            criteria.andGraduationTimeGreaterThan(startDate);
        }
        if (StringUtils.isNotEmpty(model.getEndGraduationTime())) {
            Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getEndGraduationTime());
            criteria.andGraduationTimeLessThan(endDate);
        }
        if (StringUtils.isNotEmpty(model.getStartWorkingTime())) {
            Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getStartWorkingTime());
            criteria.andWorkingTimeGreaterThan(startDate);
        }
        if (StringUtils.isNotEmpty(model.getEndWorkingTime())) {
            Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getEndWorkingTime());
            criteria.andWorkingTimeLessThan(endDate);
        }
        if (StringUtils.isNotBlank(model.getPhone())) {
            criteria.andPhoneEqualTo(model.getPhone());
        }
        if (Objects.nonNull(model.getTeamId())) {
            criteria.andTeamIdEqualTo(model.getTeamId());
        }
        if (Objects.nonNull(model.getPostId())) {
            criteria.andPostIdEqualTo(model.getPostId());
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
        Page<PayUser> payUsers = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> payUserMapper.selectByExample(example));
//        List<PayUserDTO> list = Lists.newArrayList();
//        payUsers.forEach(payUser -> {
//            PayUserDTO payUserDTO = new PayUserDTO();
//            BeanUtils.copyProperties(payUser, payUserDTO);
//            payUserDTO.setTeamName(payTeamMapper.selectByPrimaryKey(payUser.getTeamId()).getTeamName());
//            payUserDTO.setPostName(payProductionWorkshopMapper.selectByPrimaryKey(payUser.getPostId()).getPostName());
//            list.add(payUserDTO);
//        });
        PageDTO<PayUser> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payUsers, pageDTO);
        pageDTO.setList(payUsers);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean save(PayUserDTO model) {
        PayUser payUser = new PayUser();
        BeanUtils.copyProperties(model, payUser);
        payUser.setCreateTime(new Date());
        payUser.setUpdateTime(new Date());
        payUser.setCreateUser(getLoginUserName());
        payUser.setUpdateUser(getLoginUserName());
        payUserMapper.insert(payUser);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer userId) {
        return ResultBean.success(payUserMapper.selectByPrimaryKey(userId));
    }

    @Override
    public ResultBean edit(PayUserDTO model) {
        PayUser payUser = new PayUser();
        BeanUtils.copyProperties(model, payUser);
        payUser.setUpdateTime(new Date());
        payUser.setUpdateUser(getLoginUserName());
        payUserMapper.updateByPrimaryKeySelective(payUser);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer userId) {
        return ResultBean.success(payUserMapper.deleteByPrimaryKey(userId));
    }
}
