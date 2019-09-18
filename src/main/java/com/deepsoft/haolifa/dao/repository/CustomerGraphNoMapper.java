package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.CustomerGraphNo;
import com.deepsoft.haolifa.model.domain.CustomerGraphNoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerGraphNoMapper {
    int countByExample(CustomerGraphNoExample example);

    int deleteByExample(CustomerGraphNoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerGraphNo record);

    int insertSelective(CustomerGraphNo record);

    List<CustomerGraphNo> selectByExample(CustomerGraphNoExample example);

    CustomerGraphNo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerGraphNo record, @Param("example") CustomerGraphNoExample example);

    int updateByExample(@Param("record") CustomerGraphNo record, @Param("example") CustomerGraphNoExample example);

    int updateByPrimaryKeySelective(CustomerGraphNo record);

    int updateByPrimaryKey(CustomerGraphNo record);
}