package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayWagesSearch;
import com.deepsoft.haolifa.model.domain.PayWagesSearchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayWagesSearchMapper {
    int countByExample(PayWagesSearchExample example);

    int deleteByExample(PayWagesSearchExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayWagesSearch record);

    int insertSelective(PayWagesSearch record);

    List<PayWagesSearch> selectByExample(PayWagesSearchExample example);

    PayWagesSearch selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayWagesSearch record, @Param("example") PayWagesSearchExample example);

    int updateByExample(@Param("record") PayWagesSearch record, @Param("example") PayWagesSearchExample example);

    int updateByPrimaryKeySelective(PayWagesSearch record);

    int updateByPrimaryKey(PayWagesSearch record);
}