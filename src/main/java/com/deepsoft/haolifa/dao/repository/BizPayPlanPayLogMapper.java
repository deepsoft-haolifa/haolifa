package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizPayPlanPayLog;
import com.deepsoft.haolifa.model.domain.BizPayPlanPayLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizPayPlanPayLogMapper {
    int countByExample(BizPayPlanPayLogExample example);

    int deleteByExample(BizPayPlanPayLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizPayPlanPayLog record);

    int insertSelective(BizPayPlanPayLog record);

    List<BizPayPlanPayLog> selectByExample(BizPayPlanPayLogExample example);

    BizPayPlanPayLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizPayPlanPayLog record, @Param("example") BizPayPlanPayLogExample example);

    int updateByExample(@Param("record") BizPayPlanPayLog record, @Param("example") BizPayPlanPayLogExample example);

    int updateByPrimaryKeySelective(BizPayPlanPayLog record);

    int updateByPrimaryKey(BizPayPlanPayLog record);
}