package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizReimburseTravelDetail;
import com.deepsoft.haolifa.model.domain.BizReimburseTravelDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizReimburseTravelDetailMapper {
    int countByExample(BizReimburseTravelDetailExample example);

    int deleteByExample(BizReimburseTravelDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizReimburseTravelDetail record);

    int insertSelective(BizReimburseTravelDetail record);

    List<BizReimburseTravelDetail> selectByExample(BizReimburseTravelDetailExample example);

    BizReimburseTravelDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizReimburseTravelDetail record, @Param("example") BizReimburseTravelDetailExample example);

    int updateByExample(@Param("record") BizReimburseTravelDetail record, @Param("example") BizReimburseTravelDetailExample example);

    int updateByPrimaryKeySelective(BizReimburseTravelDetail record);

    int updateByPrimaryKey(BizReimburseTravelDetail record);
}