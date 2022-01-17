package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizReimburseApply;
import com.deepsoft.haolifa.model.domain.BizReimburseApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizReimburseApplyMapper {
    int countByExample(BizReimburseApplyExample example);

    int deleteByExample(BizReimburseApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizReimburseApply record);

    int insertSelective(BizReimburseApply record);

    List<BizReimburseApply> selectByExample(BizReimburseApplyExample example);

    BizReimburseApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizReimburseApply record, @Param("example") BizReimburseApplyExample example);

    int updateByExample(@Param("record") BizReimburseApply record, @Param("example") BizReimburseApplyExample example);

    int updateByPrimaryKeySelective(BizReimburseApply record);

    int updateByPrimaryKey(BizReimburseApply record);
}