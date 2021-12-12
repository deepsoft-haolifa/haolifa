package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayAssessmentQuota;
import com.deepsoft.haolifa.model.domain.PayAssessmentQuotaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayAssessmentQuotaMapper {
    int countByExample(PayAssessmentQuotaExample example);

    int deleteByExample(PayAssessmentQuotaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayAssessmentQuota record);

    int insertSelective(PayAssessmentQuota record);

    List<PayAssessmentQuota> selectByExample(PayAssessmentQuotaExample example);

    PayAssessmentQuota selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayAssessmentQuota record, @Param("example") PayAssessmentQuotaExample example);

    int updateByExample(@Param("record") PayAssessmentQuota record, @Param("example") PayAssessmentQuotaExample example);

    int updateByPrimaryKeySelective(PayAssessmentQuota record);

    int updateByPrimaryKey(PayAssessmentQuota record);
}