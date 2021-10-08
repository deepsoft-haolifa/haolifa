package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayAssessmentQuotaMapper;
import com.deepsoft.haolifa.model.domain.PayAssessmentQuota;
import com.deepsoft.haolifa.model.domain.PayAssessmentQuotaExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentQuotaDTO;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentQuotaVO;
import com.deepsoft.haolifa.service.PayAssessmentQuotaService;
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
public class PayAssessmentQuotaServiceImpl extends BaseService implements PayAssessmentQuotaService {
    @Resource
    private PayAssessmentQuotaMapper payAssessmentQuotaMapper;

    @Override
    public ResultBean pageInfo(PayAssessmentQuotaVO model) {
        PayAssessmentQuotaExample example = new PayAssessmentQuotaExample();
        PayAssessmentQuotaExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getProjectName())) {
            criteria.andProjectNameLike("%" + model.getProjectName() + "%");
        }
        example.setOrderByClause("id desc");
        Page<PayAssessmentQuota> payTeams = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> payAssessmentQuotaMapper.selectByExample(example));
        PageDTO<PayAssessmentQuota> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payTeams, pageDTO);
        pageDTO.setList(payTeams);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean save(PayAssessmentQuotaDTO model) {
        PayAssessmentQuota payTeam = new PayAssessmentQuota();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setCreateUser(getLoginUserName());
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setCreateTime(new Date());
        payTeam.setUpdateTime(new Date());
        payAssessmentQuotaMapper.insert(payTeam);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer teamId) {
        return ResultBean.success(payAssessmentQuotaMapper.selectByPrimaryKey(teamId));
    }

    @Override
    public ResultBean edit(PayAssessmentQuotaDTO model) {
        PayAssessmentQuota payTeam = new PayAssessmentQuota();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setUpdateTime(new Date());
        payAssessmentQuotaMapper.updateByPrimaryKeySelective(payTeam);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer quotaId) {
        return ResultBean.success(payAssessmentQuotaMapper.deleteByPrimaryKey(quotaId));
    }
}
