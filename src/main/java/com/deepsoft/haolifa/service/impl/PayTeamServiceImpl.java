package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayTeamMapper;
import com.deepsoft.haolifa.model.domain.PayTeam;
import com.deepsoft.haolifa.model.domain.PayTeamExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayTeamDTO;
import com.deepsoft.haolifa.model.dto.pay.PayTeamVO;
import com.deepsoft.haolifa.service.PayTeamService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 人员管理
 */
@Service
public class PayTeamServiceImpl extends BaseService implements PayTeamService {
    @Resource
    private PayTeamMapper payTeamMapper;

    @Override
    public ResultBean pageInfo(PayTeamVO model) {
        PayTeamExample example = new PayTeamExample();
        PayTeamExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(model.getWorkshopId())) {
            criteria.andWorkshopIdEqualTo(model.getWorkshopId());
        }
        if (StringUtils.isNotBlank(model.getTeamName())) {
            criteria.andTeamNameLike("%" + model.getTeamName() + "%");
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
        Page<PayTeam> payTeams = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> payTeamMapper.selectByExample(example));
        PageDTO<PayTeam> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payTeams, pageDTO);
        pageDTO.setList(payTeams);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean save(PayTeamDTO model) {
        PayTeam payTeam = new PayTeam();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setCreateUser(getLoginUserName());
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setCreateTime(new Date());
        payTeam.setUpdateTime(new Date());
        payTeamMapper.insert(payTeam);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer teamId) {
        return ResultBean.success(payTeamMapper.selectByPrimaryKey(teamId));
    }

    @Override
    public ResultBean edit(PayTeamDTO model) {
        PayTeam payTeam = new PayTeam();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setUpdateTime(new Date());
        payTeamMapper.updateByPrimaryKeySelective(payTeam);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer teamId) {
        return ResultBean.success(payTeamMapper.deleteByPrimaryKey(teamId));
    }
}
