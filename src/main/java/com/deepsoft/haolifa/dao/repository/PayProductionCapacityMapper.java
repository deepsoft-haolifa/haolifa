package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayProductionCapacity;
import com.deepsoft.haolifa.model.domain.PayProductionCapacityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayProductionCapacityMapper {
    int countByExample(PayProductionCapacityExample example);

    int deleteByExample(PayProductionCapacityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayProductionCapacity record);

    int insertSelective(PayProductionCapacity record);

    List<PayProductionCapacity> selectByExample(PayProductionCapacityExample example);

    PayProductionCapacity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayProductionCapacity record, @Param("example") PayProductionCapacityExample example);

    int updateByExample(@Param("record") PayProductionCapacity record, @Param("example") PayProductionCapacityExample example);

    int updateByPrimaryKeySelective(PayProductionCapacity record);

    int updateByPrimaryKey(PayProductionCapacity record);
}