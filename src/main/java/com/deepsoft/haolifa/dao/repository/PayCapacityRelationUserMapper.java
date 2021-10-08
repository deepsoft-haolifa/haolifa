package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayCapacityRelationUser;
import com.deepsoft.haolifa.model.domain.PayCapacityRelationUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayCapacityRelationUserMapper {
    int countByExample(PayCapacityRelationUserExample example);

    int deleteByExample(PayCapacityRelationUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayCapacityRelationUser record);

    int insertSelective(PayCapacityRelationUser record);

    List<PayCapacityRelationUser> selectByExample(PayCapacityRelationUserExample example);

    PayCapacityRelationUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayCapacityRelationUser record, @Param("example") PayCapacityRelationUserExample example);

    int updateByExample(@Param("record") PayCapacityRelationUser record, @Param("example") PayCapacityRelationUserExample example);

    int updateByPrimaryKeySelective(PayCapacityRelationUser record);

    int updateByPrimaryKey(PayCapacityRelationUser record);
}
