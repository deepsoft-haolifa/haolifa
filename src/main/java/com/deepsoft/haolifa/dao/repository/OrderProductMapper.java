package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.OrderProduct;
import com.deepsoft.haolifa.model.domain.OrderProductExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrderProductMapper {
    int countByExample(OrderProductExample example);

    int deleteByExample(OrderProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderProduct record);

    int insertSelective(OrderProduct record);

    List<OrderProduct> selectByExample(OrderProductExample example);

    OrderProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderProduct record, @Param("example") OrderProductExample example);

    int updateByExample(@Param("record") OrderProduct record, @Param("example") OrderProductExample example);

    int updateByPrimaryKeySelective(OrderProduct record);

    int updateByPrimaryKey(OrderProduct record);


    List<OrderProduct> selectByMap(@Param("query") Map<String,Object> query);
}
