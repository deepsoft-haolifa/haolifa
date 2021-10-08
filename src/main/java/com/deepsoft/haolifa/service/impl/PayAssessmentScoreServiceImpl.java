package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayAssessmentScoreMapper;
import com.deepsoft.haolifa.model.domain.PayAssessmentScore;
import com.deepsoft.haolifa.model.domain.PayAssessmentScoreExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentQuotaDTO;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentScoreDTO;
import com.deepsoft.haolifa.service.PayAssessmentScoreService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
public class PayAssessmentScoreServiceImpl extends BaseService implements PayAssessmentScoreService {
    @Resource
    private PayAssessmentScoreMapper payAssessmentScoreMapper;

    @Override
    public ResultBean pageInfo(Integer pageNum, Integer pageSize) {
        PayAssessmentScoreExample example = new PayAssessmentScoreExample();
        Page<PayAssessmentScore> payTeams = PageHelper.startPage(pageNum, pageSize)
            .doSelectPage(() -> payAssessmentScoreMapper.selectByExample(example));
        PageDTO<PayAssessmentScore> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payTeams, pageDTO);
        pageDTO.setList(payTeams);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean save(PayAssessmentScoreDTO model) {
        PayAssessmentScore payTeam = new PayAssessmentScore();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setCreateUser(getLoginUserName());
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setCreateTime(new Date());
        payTeam.setUpdateTime(new Date());
        payAssessmentScoreMapper.insert(payTeam);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer teamId) {
        return ResultBean.success(payAssessmentScoreMapper.selectByPrimaryKey(teamId));
    }

    @Override
    public ResultBean edit(PayAssessmentScoreDTO model) {
        PayAssessmentScore payTeam = new PayAssessmentScore();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setUpdateUser(getLoginUserName());
        payTeam.setUpdateTime(new Date());
        payAssessmentScoreMapper.updateByPrimaryKeySelective(payTeam);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer scoreId) {
        return ResultBean.success(payAssessmentScoreMapper.deleteByPrimaryKey(scoreId));
    }
}
