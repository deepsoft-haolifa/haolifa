package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayManagerCal;
import com.deepsoft.haolifa.model.domain.PayManagerCalExample;
import java.util.List;

import com.deepsoft.haolifa.model.dto.pay.PayManagerCalDTO;
import org.apache.ibatis.annotations.Param;

public interface PayManagerCalMapper {
    int countByExample(PayManagerCalExample example);

    int deleteByExample(PayManagerCalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayManagerCal record);

    int insertSelective(PayManagerCal record);

    List<PayManagerCal> selectByExample(PayManagerCalExample example);

    PayManagerCal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayManagerCal record, @Param("example") PayManagerCalExample example);

    int updateByExample(@Param("record") PayManagerCal record, @Param("example") PayManagerCalExample example);

    int updateByPrimaryKeySelective(PayManagerCal record);

    int updateByPrimaryKey(PayManagerCal record);

    List<PayManagerCal> selectList(PayManagerCalDTO payManagerCalDTO);

}
