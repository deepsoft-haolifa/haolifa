package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SupplierEvaluationRecord;
import com.deepsoft.haolifa.model.domain.SupplierEvaluationRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierEvaluationRecordMapper {
    long countByExample(SupplierEvaluationRecordExample example);

    int deleteByExample(SupplierEvaluationRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SupplierEvaluationRecord record);

    int insertSelective(SupplierEvaluationRecord record);

    List<SupplierEvaluationRecord> selectByExample(SupplierEvaluationRecordExample example);

    SupplierEvaluationRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SupplierEvaluationRecord record, @Param("example") SupplierEvaluationRecordExample example);

    int updateByExample(@Param("record") SupplierEvaluationRecord record, @Param("example") SupplierEvaluationRecordExample example);

    int updateByPrimaryKeySelective(SupplierEvaluationRecord record);

    int updateByPrimaryKey(SupplierEvaluationRecord record);
}