package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayProductionWorkshopMapper;
import com.deepsoft.haolifa.model.domain.PayProductionWorkshop;
import com.deepsoft.haolifa.model.domain.PayProductionWorkshopExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayProductionWorkshopDTO;
import com.deepsoft.haolifa.model.dto.pay.PayProductionWorkshopVO;
import com.deepsoft.haolifa.service.PayProductionWorkShopService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 部门管理
 */
@Service
public class PayProductionWorkShopServiceImpl extends BaseService implements PayProductionWorkShopService {
    @Resource
    private PayProductionWorkshopMapper payProductionWorkshopMapper;

    @Override
    public ResultBean pageInfo(PayProductionWorkshopVO model) {
        PayProductionWorkshopExample example = new PayProductionWorkshopExample();
        PayProductionWorkshopExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(model.getDepartName())) {
            criteria.andDepartNameLike("%" + model.getDepartName() + "%");
        }
        if (StringUtils.isNotBlank(model.getWorkType())) {
            criteria.andWorkTypeLike("%" + model.getWorkType() + "%");
        }
        if (StringUtils.isNotBlank(model.getPostName())) {
            criteria.andPostNameLike("%" + model.getPostName() + "%");
        }
        if (StringUtils.isNotEmpty(model.getPostName())) {
            Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getStartCreateTime());
            criteria.andCreateTimeGreaterThan(startDate);
        }
        if (StringUtils.isNotEmpty(model.getEndCreateTime())) {
            Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getEndCreateTime());
            criteria.andCreateTimeLessThan(endDate);
        }
        example.setOrderByClause("id desc");
        Page<PayProductionWorkshop> payTeams = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> payProductionWorkshopMapper.selectByExample(example));
        PageDTO<PayProductionWorkshop> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payTeams, pageDTO);
        pageDTO.setList(payTeams);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean save(PayProductionWorkshopDTO model) {
        PayProductionWorkshop payTeam = new PayProductionWorkshop();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setCreateUser(getLoginUserName());
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setCreateTime(new Date());
        payTeam.setUpdateTime(new Date());
        payProductionWorkshopMapper.insertSelective(payTeam);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer teamId) {
        return ResultBean.success(payProductionWorkshopMapper.selectByPrimaryKey(teamId));
    }

    @Override
    public ResultBean edit(PayProductionWorkshopDTO model) {
        PayProductionWorkshop payTeam = new PayProductionWorkshop();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setUpdateTime(new Date());
        payProductionWorkshopMapper.updateByPrimaryKeySelective(payTeam);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer workId) {
        return ResultBean.success(payProductionWorkshopMapper.deleteByPrimaryKey(workId));

    }

    @Override
    public ResultBean getList() {
        List<PayProductionWorkshop> payProductionWorkshops = payProductionWorkshopMapper.selectByExample(new PayProductionWorkshopExample());
        List<PayProductionWorkshopDTO> list = new ArrayList<>();
        for (PayProductionWorkshop payProductionWorkshop : payProductionWorkshops) {
            PayProductionWorkshopDTO dto = new PayProductionWorkshopDTO();
            BeanUtils.copyProperties(payProductionWorkshop, dto);
            list.add(dto);
        }
        return ResultBean.success(list);
    }
}
