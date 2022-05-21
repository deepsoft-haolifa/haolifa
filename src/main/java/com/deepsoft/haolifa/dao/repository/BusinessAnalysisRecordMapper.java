package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BusinessAnalysisRecord;
import com.deepsoft.haolifa.model.domain.BusinessAnalysisRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessAnalysisRecordMapper {
    int countByExample(BusinessAnalysisRecordExample example);

    int deleteByExample(BusinessAnalysisRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusinessAnalysisRecord record);

    int insertSelective(BusinessAnalysisRecord record);

    List<BusinessAnalysisRecord> selectByExample(BusinessAnalysisRecordExample example);

    BusinessAnalysisRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusinessAnalysisRecord record, @Param("example") BusinessAnalysisRecordExample example);

    int updateByExample(@Param("record") BusinessAnalysisRecord record, @Param("example") BusinessAnalysisRecordExample example);

    int updateByPrimaryKeySelective(BusinessAnalysisRecord record);

    int updateByPrimaryKey(BusinessAnalysisRecord record);
}