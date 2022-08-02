package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayOrderRelationMoreUser;
import com.deepsoft.haolifa.model.domain.PayOrderRelationMoreUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayOrderRelationMoreUserMapper {
    int countByExample(PayOrderRelationMoreUserExample example);

    int deleteByExample(PayOrderRelationMoreUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayOrderRelationMoreUser record);

    int insertSelective(PayOrderRelationMoreUser record);

    List<PayOrderRelationMoreUser> selectByExample(PayOrderRelationMoreUserExample example);

    PayOrderRelationMoreUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayOrderRelationMoreUser record, @Param("example") PayOrderRelationMoreUserExample example);

    int updateByExample(@Param("record") PayOrderRelationMoreUser record, @Param("example") PayOrderRelationMoreUserExample example);

    int updateByPrimaryKeySelective(PayOrderRelationMoreUser record);

    int updateByPrimaryKey(PayOrderRelationMoreUser record);
}