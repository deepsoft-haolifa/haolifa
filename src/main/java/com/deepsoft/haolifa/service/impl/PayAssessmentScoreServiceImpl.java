package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayAssessmentScoreMapper;
import com.deepsoft.haolifa.dao.repository.PayUserMapper;
import com.deepsoft.haolifa.model.domain.PayAssessmentScore;
import com.deepsoft.haolifa.model.domain.PayAssessmentScoreExample;
import com.deepsoft.haolifa.model.domain.PayUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentQuotaDTO;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentScoreDTO;
import com.deepsoft.haolifa.service.PayAssessmentScoreService;
import com.deepsoft.haolifa.util.BeanCopyUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 考核指标
 */
@Service
public class PayAssessmentScoreServiceImpl extends BaseService implements PayAssessmentScoreService {
    @Resource
    private PayAssessmentScoreMapper payAssessmentScoreMapper;
    @Resource
    private PayUserMapper payUserMapper;

    @Override
    public ResultBean pageInfo(Integer pageNum, Integer pageSize) {
        PayAssessmentScoreExample example = new PayAssessmentScoreExample();
        Page<PayAssessmentScore> payTeams = PageHelper.startPage(pageNum, pageSize)
            .doSelectPage(() -> payAssessmentScoreMapper.selectByExample(example));
        List<PayAssessmentScoreDTO> scoreDTOList = BeanCopyUtils.copyPropertiesForNewList(payTeams, () -> new PayAssessmentScoreDTO());
        scoreDTOList.stream().forEach(score -> {
            PayUser payUser = payUserMapper.selectByPrimaryKey(score.getUserId());
            score.setUserName(Objects.isNull(payUser) ? "" : payUser.getUserName());
        });
        PageDTO<PayAssessmentScoreDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payTeams, pageDTO);
        pageDTO.setList(scoreDTOList);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean save(PayAssessmentScoreDTO model) {
        PayAssessmentScore payTeam = new PayAssessmentScore();
        BeanUtils.copyProperties(model, payTeam);
        payTeam.setScoreTime(new Date());
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
        payTeam.setScoreTime(new Date());
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
