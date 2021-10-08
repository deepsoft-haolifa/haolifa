package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayWages;
import com.deepsoft.haolifa.model.domain.PayWagesExample;
import com.deepsoft.haolifa.model.dto.pay.PayWagesDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayWagesMapper {
    int countByExample(PayWagesExample example);

    int deleteByExample(PayWagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayWages record);

    int insertSelective(PayWages record);

    List<PayWages> selectByExample(PayWagesExample example);

    PayWages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayWages record, @Param("example") PayWagesExample example);

    int updateByExample(@Param("record") PayWages record, @Param("example") PayWagesExample example);

    int updateByPrimaryKeySelective(PayWages record);

    int updateByPrimaryKey(PayWages record);
}
