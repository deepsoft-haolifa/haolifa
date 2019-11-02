package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.MaterialRequisition;
import com.deepsoft.haolifa.model.domain.MaterialRequisitionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialRequisitionMapper {
    int countByExample(MaterialRequisitionExample example);

    int deleteByExample(MaterialRequisitionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MaterialRequisition record);

    int insertSelective(MaterialRequisition record);

    List<MaterialRequisition> selectByExample(MaterialRequisitionExample example);

    MaterialRequisition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MaterialRequisition record, @Param("example") MaterialRequisitionExample example);

    int updateByExample(@Param("record") MaterialRequisition record, @Param("example") MaterialRequisitionExample example);

    int updateByPrimaryKeySelective(MaterialRequisition record);

    int updateByPrimaryKey(MaterialRequisition record);
}