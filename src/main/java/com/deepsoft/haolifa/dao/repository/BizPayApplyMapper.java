package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizPayApply;
import com.deepsoft.haolifa.model.domain.BizPayApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizPayApplyMapper {
    int countByExample(BizPayApplyExample example);

    int deleteByExample(BizPayApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizPayApply record);

    int insertSelective(BizPayApply record);

    List<BizPayApply> selectByExample(BizPayApplyExample example);

    BizPayApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizPayApply record, @Param("example") BizPayApplyExample example);

    int updateByExample(@Param("record") BizPayApply record, @Param("example") BizPayApplyExample example);

    int updateByPrimaryKeySelective(BizPayApply record);

    int updateByPrimaryKey(BizPayApply record);
}