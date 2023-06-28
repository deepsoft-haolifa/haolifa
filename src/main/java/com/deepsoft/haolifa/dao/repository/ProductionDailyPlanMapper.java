package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ProductionDailyPlan;
import com.deepsoft.haolifa.model.domain.ProductionDailyPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductionDailyPlanMapper {
    int countByExample(ProductionDailyPlanExample example);

    int deleteByExample(ProductionDailyPlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductionDailyPlan record);

    int insertSelective(ProductionDailyPlan record);

    List<ProductionDailyPlan> selectByExample(ProductionDailyPlanExample example);

    ProductionDailyPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductionDailyPlan record, @Param("example") ProductionDailyPlanExample example);

    int updateByExample(@Param("record") ProductionDailyPlan record, @Param("example") ProductionDailyPlanExample example);

    int updateByPrimaryKeySelective(ProductionDailyPlan record);

    int updateByPrimaryKey(ProductionDailyPlan record);
}