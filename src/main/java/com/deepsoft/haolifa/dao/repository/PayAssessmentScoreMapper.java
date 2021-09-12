package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayAssessmentScore;
import com.deepsoft.haolifa.model.domain.PayAssessmentScoreExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayAssessmentScoreMapper {
    int countByExample(PayAssessmentScoreExample example);

    int deleteByExample(PayAssessmentScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayAssessmentScore record);

    int insertSelective(PayAssessmentScore record);

    List<PayAssessmentScore> selectByExample(PayAssessmentScoreExample example);

    PayAssessmentScore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayAssessmentScore record, @Param("example") PayAssessmentScoreExample example);

    int updateByExample(@Param("record") PayAssessmentScore record, @Param("example") PayAssessmentScoreExample example);

    int updateByPrimaryKeySelective(PayAssessmentScore record);

    int updateByPrimaryKey(PayAssessmentScore record);
}
