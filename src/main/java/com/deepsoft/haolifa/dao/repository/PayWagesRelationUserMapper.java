package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayWagesRelationUser;
import com.deepsoft.haolifa.model.domain.PayWagesRelationUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayWagesRelationUserMapper {
    int countByExample(PayWagesRelationUserExample example);

    int deleteByExample(PayWagesRelationUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayWagesRelationUser record);

    int insertSelective(PayWagesRelationUser record);

    List<PayWagesRelationUser> selectByExample(PayWagesRelationUserExample example);

    PayWagesRelationUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayWagesRelationUser record, @Param("example") PayWagesRelationUserExample example);

    int updateByExample(@Param("record") PayWagesRelationUser record, @Param("example") PayWagesRelationUserExample example);

    int updateByPrimaryKeySelective(PayWagesRelationUser record);

    int updateByPrimaryKey(PayWagesRelationUser record);
}
