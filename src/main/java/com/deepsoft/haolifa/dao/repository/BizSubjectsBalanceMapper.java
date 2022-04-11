package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizSubjectsBalance;
import com.deepsoft.haolifa.model.domain.BizSubjectsBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizSubjectsBalanceMapper {
    int countByExample(BizSubjectsBalanceExample example);

    int deleteByExample(BizSubjectsBalanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizSubjectsBalance record);

    int insertSelective(BizSubjectsBalance record);

    List<BizSubjectsBalance> selectByExample(BizSubjectsBalanceExample example);

    BizSubjectsBalance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizSubjectsBalance record, @Param("example") BizSubjectsBalanceExample example);

    int updateByExample(@Param("record") BizSubjectsBalance record, @Param("example") BizSubjectsBalanceExample example);

    int updateByPrimaryKeySelective(BizSubjectsBalance record);

    int updateByPrimaryKey(BizSubjectsBalance record);
}