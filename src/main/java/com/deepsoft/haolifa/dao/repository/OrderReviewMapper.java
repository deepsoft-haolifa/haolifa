package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.OrderReview;
import com.deepsoft.haolifa.model.domain.OrderReviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderReviewMapper {
    long countByExample(OrderReviewExample example);

    int deleteByExample(OrderReviewExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderReview record);

    int insertSelective(OrderReview record);

    List<OrderReview> selectByExample(OrderReviewExample example);

    OrderReview selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderReview record, @Param("example") OrderReviewExample example);

    int updateByExample(@Param("record") OrderReview record, @Param("example") OrderReviewExample example);

    int updateByPrimaryKeySelective(OrderReview record);

    int updateByPrimaryKey(OrderReview record);
}