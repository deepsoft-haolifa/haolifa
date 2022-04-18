package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizPayPlan;
import com.deepsoft.haolifa.model.domain.BizPayPlanExample;
import java.util.List;

import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanSummaryRQDTO;
import org.apache.ibatis.annotations.Param;

public interface BizPayPlanMapper {
    int countByExample(BizPayPlanExample example);

    int deleteByExample(BizPayPlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizPayPlan record);

    int insertSelective(BizPayPlan record);

    List<BizPayPlan> selectByExample(BizPayPlanExample example);

    BizPayPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizPayPlan record, @Param("example") BizPayPlanExample example);

    int updateByExample(@Param("record") BizPayPlan record, @Param("example") BizPayPlanExample example);

    int updateByPrimaryKeySelective(BizPayPlan record);

    int updateByPrimaryKey(BizPayPlan record);


    // sql
    List<BizPayPlan> selectListGroupBy(@Param("query") BizPayPlanSummaryRQDTO query);

}
