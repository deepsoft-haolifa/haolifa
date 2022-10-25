package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.OrderProductAssociate;
import com.deepsoft.haolifa.model.domain.OrderProductAssociateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderProductAssociateMapper {
    int countByExample(OrderProductAssociateExample example);

    int deleteByExample(OrderProductAssociateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderProductAssociate record);

    int insertSelective(OrderProductAssociate record);

    List<OrderProductAssociate> selectByExample(OrderProductAssociateExample example);

    OrderProductAssociate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderProductAssociate record, @Param("example") OrderProductAssociateExample example);

    int updateByExample(@Param("record") OrderProductAssociate record, @Param("example") OrderProductAssociateExample example);

    int updateByPrimaryKeySelective(OrderProductAssociate record);

    int updateByPrimaryKey(OrderProductAssociate record);
}