package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayHourQuotaMapper;
import com.deepsoft.haolifa.model.domain.PayHourQuota;
import com.deepsoft.haolifa.model.domain.PayHourQuotaExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayHourQuotaDTO;
import com.deepsoft.haolifa.service.PayHourQuotaService;
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
public class PayHourQuotaServiceImpl extends BaseService implements PayHourQuotaService {
    @Resource
    private PayHourQuotaMapper payHourQuotaMapper;

    @Override
    public ResultBean pageInfo(PayHourQuotaDTO model) {
        PayHourQuotaExample example = new PayHourQuotaExample();
        PayHourQuotaExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(model.getWorkshopName())) {
            criteria.andWorkshopNameLike("%" + model.getWorkshopName() + "%");
        }
        if (StringUtils.isNotBlank(model.getWorkType())) {
            criteria.andWorkTypeLike("%" + model.getWorkType() + "%");
        }
        if (StringUtils.isNotBlank(model.getPostCode())) {
            criteria.andPostCodeEqualTo("%" + model.getPostCode() + "%");
        }
        example.setOrderByClause("id desc");
        Page<PayHourQuota> payTeams = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> payHourQuotaMapper.selectByExample(example));
        PageDTO<PayHourQuota> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payTeams, pageDTO);
        pageDTO.setList(payTeams);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean save(PayHourQuotaDTO model) {
        PayHourQuota payTeam = new PayHourQuota();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setCreateUser(getLoginUserName());
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setCreateTime(new Date());
        payTeam.setUpdateTime(new Date());
        payHourQuotaMapper.insert(payTeam);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        return ResultBean.success(payHourQuotaMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResultBean edit(PayHourQuotaDTO model) {
        PayHourQuota payTeam = new PayHourQuota();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setUpdateTime(new Date());
        payHourQuotaMapper.updateByPrimaryKeySelective(payTeam);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer id) {
        return ResultBean.success(payHourQuotaMapper.deleteByPrimaryKey(id));

    }
}
