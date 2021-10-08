package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayUser;
import com.deepsoft.haolifa.model.domain.PayUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayUserMapper {
    int countByExample(PayUserExample example);

    int deleteByExample(PayUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayUser record);

    int insertSelective(PayUser record);

    List<PayUser> selectByExample(PayUserExample example);

    PayUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayUser record, @Param("example") PayUserExample example);

    int updateByExample(@Param("record") PayUser record, @Param("example") PayUserExample example);

    int updateByPrimaryKeySelective(PayUser record);

    int updateByPrimaryKey(PayUser record);
}
