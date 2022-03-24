package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayAssessmentQuotaMapper;
import com.deepsoft.haolifa.dao.repository.PayAssessmentScoreMapper;
import com.deepsoft.haolifa.dao.repository.PayAssessmentScoreRecordMapper;
import com.deepsoft.haolifa.dao.repository.PayUserMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.RoleDTO;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentQuotaDTO;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentScoreDTO;
import com.deepsoft.haolifa.model.vo.PayAssessmentScoreRecordVO;
import com.deepsoft.haolifa.service.PayAssessmentScoreService;
import com.deepsoft.haolifa.service.RoleService;
import com.deepsoft.haolifa.util.BeanCopyUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    @Resource
    private PayAssessmentQuotaMapper payAssessmentQuotaMapper;
    @Resource
    private PayAssessmentScoreRecordMapper payAssessmentScoreRecordMapper;
    @Resource
    private RoleService roleService;

    private static final int TOTAL_SCORE = 100;

    @Override
    public ResultBean pageInfo(Integer pageNum, Integer pageSize) {
        PayAssessmentScoreExample example = new PayAssessmentScoreExample();
        PayAssessmentScoreExample.Criteria criteria = example.createCriteria();
        CustomUser customUser = sysUserService.selectLoginUser();
        if (Objects.nonNull(customUser) && Objects.nonNull(customUser.getId())) {
            List<RoleDTO> rolesByUserId = roleService.getRolesByUserId(customUser.getId());
            // 当前人员的 下级
            if (!rolesByUserId.stream().map(RoleDTO::getRoleName)
                .collect(Collectors.toList()).contains("ROLE_ADMIN")) {
                SysUser sysUser = sysUserService.getSysUser(customUser.getId());
                PayUserExample payUserExample = new PayUserExample();
                payUserExample.createCriteria().andSuperiorIdEqualTo(sysUser.getPostId());
                List<PayUser> payUsers = payUserMapper.selectByExample(payUserExample);
                if (CollectionUtils.isEmpty(payUsers)) {
                    return ResultBean.success(null);
                }
                List<Integer> userIds = payUsers.stream().map(pay -> pay.getId()).collect(Collectors.toList());
                criteria.andUserIdIn(userIds);
            }
        }
        Page<PayAssessmentScore> payTeams = PageHelper.startPage(pageNum, pageSize)
            .doSelectPage(() -> payAssessmentScoreMapper.selectByExample(example));
        List<PayAssessmentScoreDTO> scoreDTOList = BeanCopyUtils.copyPropertiesForNewList(payTeams, () -> new PayAssessmentScoreDTO());
        scoreDTOList.stream().forEach(score -> {
            PayUser payUser = payUserMapper.selectByPrimaryKey(score.getUserId());
            score.setUserName(Objects.isNull(payUser) ? "" : payUser.getUserName());
            PayAssessmentQuota payAssessmentQuota = payAssessmentQuotaMapper.selectByPrimaryKey(score.getAssessmentId());
            score.setAssessmentName(Objects.isNull(payAssessmentQuota) ? "" : payAssessmentQuota.getQuotaContent());
        });
        PageDTO<PayAssessmentScoreDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payTeams, pageDTO);
        pageDTO.setList(scoreDTOList);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean save(PayAssessmentScoreDTO model) {
        PayAssessmentScore payTeam = new PayAssessmentScore();
        // 正整数取反 为负数
        int absScore = abs(model.getScore());
        BeanUtils.copyProperties(model, payTeam);
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        LocalDate localDate2 = LocalDate.of(year, month, 25);
        if (localDate.isAfter(localDate2)) {
            month.plus(1);
        }
        String monthValue = String.valueOf(month.getValue());
        if (monthValue.length() == 1) {
            monthValue = "0" + monthValue;
        }
        PayAssessmentScoreExample example = new PayAssessmentScoreExample();
        example.createCriteria().andUserIdEqualTo(model.getUserId()).andScoreYearEqualTo(String.valueOf(year))
            .andScoreMonthEqualTo(monthValue);
        List<PayAssessmentScore> payAssessmentScores = payAssessmentScoreMapper.selectByExample(example);
        Integer scoreId = null;
        if (CollectionUtils.isEmpty(payAssessmentScores)) {
            int score = TOTAL_SCORE - model.getScore();
            payTeam.setScoreTime(new Date());
            payTeam.setCreateUser(getLoginUserName());
            payTeam.setUpdateUser(getLoginUserName());
            payTeam.setCreateTime(new Date());
            payTeam.setUpdateTime(new Date());
            payTeam.setScoreYear(String.valueOf(year));
            payTeam.setScoreMonth(monthValue);
            payTeam.setScore(score);
            payAssessmentScoreMapper.insert(payTeam);
            scoreId = payTeam.getId();
        } else {
            PayAssessmentScore payAssessmentScore = payAssessmentScores.get(0);
            scoreId = payAssessmentScore.getId();
            int i = payAssessmentScore.getScore() - model.getScore();
            if (i < 0) {
                i = 0;
            }
            payAssessmentScore.setScore(i);
            payAssessmentScoreMapper.updateByPrimaryKey(payAssessmentScore);
        }
        PayAssessmentScoreRecord record = new PayAssessmentScoreRecord();
        record.setScore(absScore);
        record.setScoreId(scoreId);
        record.setScoreTime(new Date());
        record.setCreateUser(getLoginUserName());
        record.setUpdateUser(getLoginUserName());
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        payAssessmentScoreRecordMapper.insert(record);
        return ResultBean.success(1);
    }

    public int abs(int a) {
        return (a < 0) ? a : -a;
    }
    @Override
    public ResultBean getInfo(Integer scoreId) {
        PayAssessmentScore payAssessmentScore = payAssessmentScoreMapper.selectByPrimaryKey(scoreId);

        PayAssessmentScoreRecordExample payAssessmentScoreRecordExample = new PayAssessmentScoreRecordExample();
        payAssessmentScoreRecordExample.createCriteria().andScoreIdEqualTo(scoreId);
        List<PayAssessmentScoreRecord> payAssessmentScoreRecords = payAssessmentScoreRecordMapper.selectByExample(payAssessmentScoreRecordExample);

        List<PayAssessmentScoreRecordVO> list = Lists.newArrayList();
        for (PayAssessmentScoreRecord payAssessmentScoreRecord : payAssessmentScoreRecords) {
            PayAssessmentQuota payAssessmentQuota = payAssessmentQuotaMapper.selectByPrimaryKey(payAssessmentScore.getAssessmentId());
            PayAssessmentScoreRecordVO vo = BeanCopyUtils.copyProperties(payAssessmentQuota, () -> new PayAssessmentScoreRecordVO());
            vo.setScore(payAssessmentScoreRecord.getScore());
            list.add(vo);
        }
        return ResultBean.success(list);
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
