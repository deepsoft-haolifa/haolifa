package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizReimburseCostDetail;
import com.deepsoft.haolifa.model.domain.BizReimburseCostDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizReimburseCostDetailMapper {
    int countByExample(BizReimburseCostDetailExample example);

    int deleteByExample(BizReimburseCostDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizReimburseCostDetail record);

    int insertSelective(BizReimburseCostDetail record);

    List<BizReimburseCostDetail> selectByExample(BizReimburseCostDetailExample example);

    BizReimburseCostDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizReimburseCostDetail record, @Param("example") BizReimburseCostDetailExample example);

    int updateByExample(@Param("record") BizReimburseCostDetail record, @Param("example") BizReimburseCostDetailExample example);

    int updateByPrimaryKeySelective(BizReimburseCostDetail record);

    int updateByPrimaryKey(BizReimburseCostDetail record);
}