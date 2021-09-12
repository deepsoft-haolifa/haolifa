package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayTeam;
import com.deepsoft.haolifa.model.domain.PayTeamExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayTeamMapper {
    int countByExample(PayTeamExample example);

    int deleteByExample(PayTeamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayTeam record);

    int insertSelective(PayTeam record);

    List<PayTeam> selectByExample(PayTeamExample example);

    PayTeam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayTeam record, @Param("example") PayTeamExample example);

    int updateByExample(@Param("record") PayTeam record, @Param("example") PayTeamExample example);

    int updateByPrimaryKeySelective(PayTeam record);

    int updateByPrimaryKey(PayTeam record);
}
