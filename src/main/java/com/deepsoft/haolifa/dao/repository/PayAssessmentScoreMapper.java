package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayAssessmentScore;
import com.deepsoft.haolifa.model.domain.PayAssessmentScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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