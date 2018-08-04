package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SupplierEvaluationInfo;
import com.deepsoft.haolifa.model.domain.SupplierEvaluationInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierEvaluationInfoMapper {
    long countByExample(SupplierEvaluationInfoExample example);

    int deleteByExample(SupplierEvaluationInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SupplierEvaluationInfo record);

    int insertSelective(SupplierEvaluationInfo record);

    List<SupplierEvaluationInfo> selectByExample(SupplierEvaluationInfoExample example);

    SupplierEvaluationInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SupplierEvaluationInfo record, @Param("example") SupplierEvaluationInfoExample example);

    int updateByExample(@Param("record") SupplierEvaluationInfo record, @Param("example") SupplierEvaluationInfoExample example);

    int updateByPrimaryKeySelective(SupplierEvaluationInfo record);

    int updateByPrimaryKey(SupplierEvaluationInfo record);
}