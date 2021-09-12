package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayAssessmentQuotaRelationUser;
import com.deepsoft.haolifa.model.domain.PayAssessmentQuotaRelationUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayAssessmentQuotaRelationUserMapper {
    int countByExample(PayAssessmentQuotaRelationUserExample example);

    int deleteByExample(PayAssessmentQuotaRelationUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayAssessmentQuotaRelationUser record);

    int insertSelective(PayAssessmentQuotaRelationUser record);

    List<PayAssessmentQuotaRelationUser> selectByExample(PayAssessmentQuotaRelationUserExample example);

    PayAssessmentQuotaRelationUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayAssessmentQuotaRelationUser record, @Param("example") PayAssessmentQuotaRelationUserExample example);

    int updateByExample(@Param("record") PayAssessmentQuotaRelationUser record, @Param("example") PayAssessmentQuotaRelationUserExample example);

    int updateByPrimaryKeySelective(PayAssessmentQuotaRelationUser record);

    int updateByPrimaryKey(PayAssessmentQuotaRelationUser record);
}
