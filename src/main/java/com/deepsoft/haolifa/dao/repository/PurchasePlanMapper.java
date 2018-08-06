package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PurchasePlan;
import com.deepsoft.haolifa.model.domain.PurchasePlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchasePlanMapper {
    long countByExample(PurchasePlanExample example);

    int deleteByExample(PurchasePlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchasePlan record);

    int insertSelective(PurchasePlan record);

    List<PurchasePlan> selectByExample(PurchasePlanExample example);

    PurchasePlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PurchasePlan record, @Param("example") PurchasePlanExample example);

    int updateByExample(@Param("record") PurchasePlan record, @Param("example") PurchasePlanExample example);

    int updateByPrimaryKeySelective(PurchasePlan record);

    int updateByPrimaryKey(PurchasePlan record);
}