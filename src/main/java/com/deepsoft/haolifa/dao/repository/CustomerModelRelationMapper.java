package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.CustomerModelRelation;
import com.deepsoft.haolifa.model.domain.CustomerModelRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerModelRelationMapper {
    int countByExample(CustomerModelRelationExample example);

    int deleteByExample(CustomerModelRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerModelRelation record);

    int insertSelective(CustomerModelRelation record);

    List<CustomerModelRelation> selectByExample(CustomerModelRelationExample example);

    CustomerModelRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerModelRelation record, @Param("example") CustomerModelRelationExample example);

    int updateByExample(@Param("record") CustomerModelRelation record, @Param("example") CustomerModelRelationExample example);

    int updateByPrimaryKeySelective(CustomerModelRelation record);

    int updateByPrimaryKey(CustomerModelRelation record);
}