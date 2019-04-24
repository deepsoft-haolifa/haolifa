package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.OrderFile;
import com.deepsoft.haolifa.model.domain.OrderFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderFileMapper {
    int countByExample(OrderFileExample example);

    int deleteByExample(OrderFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderFile record);

    int insertSelective(OrderFile record);

    List<OrderFile> selectByExample(OrderFileExample example);

    OrderFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderFile record, @Param("example") OrderFileExample example);

    int updateByExample(@Param("record") OrderFile record, @Param("example") OrderFileExample example);

    int updateByPrimaryKeySelective(OrderFile record);

    int updateByPrimaryKey(OrderFile record);
}