package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayAssessmentScoreRecord;
import com.deepsoft.haolifa.model.domain.PayAssessmentScoreRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayAssessmentScoreRecordMapper {
    int countByExample(PayAssessmentScoreRecordExample example);

    int deleteByExample(PayAssessmentScoreRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayAssessmentScoreRecord record);

    int insertSelective(PayAssessmentScoreRecord record);

    List<PayAssessmentScoreRecord> selectByExample(PayAssessmentScoreRecordExample example);

    PayAssessmentScoreRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayAssessmentScoreRecord record, @Param("example") PayAssessmentScoreRecordExample example);

    int updateByExample(@Param("record") PayAssessmentScoreRecord record, @Param("example") PayAssessmentScoreRecordExample example);

    int updateByPrimaryKeySelective(PayAssessmentScoreRecord record);

    int updateByPrimaryKey(PayAssessmentScoreRecord record);
}