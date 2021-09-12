package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayProductionWorkshop;
import com.deepsoft.haolifa.model.domain.PayProductionWorkshopExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayProductionWorkshopMapper {
    int countByExample(PayProductionWorkshopExample example);

    int deleteByExample(PayProductionWorkshopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayProductionWorkshop record);

    int insertSelective(PayProductionWorkshop record);

    List<PayProductionWorkshop> selectByExample(PayProductionWorkshopExample example);

    PayProductionWorkshop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayProductionWorkshop record, @Param("example") PayProductionWorkshopExample example);

    int updateByExample(@Param("record") PayProductionWorkshop record, @Param("example") PayProductionWorkshopExample example);

    int updateByPrimaryKeySelective(PayProductionWorkshop record);

    int updateByPrimaryKey(PayProductionWorkshop record);
}
