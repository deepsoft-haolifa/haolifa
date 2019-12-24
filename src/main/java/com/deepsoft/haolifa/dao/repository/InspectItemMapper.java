package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.InspectItem;
import com.deepsoft.haolifa.model.domain.InspectItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InspectItemMapper {
    int countByExample(InspectItemExample example);

    int deleteByExample(InspectItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InspectItem record);

    int insertSelective(InspectItem record);

    List<InspectItem> selectByExample(InspectItemExample example);

    InspectItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InspectItem record, @Param("example") InspectItemExample example);

    int updateByExample(@Param("record") InspectItem record, @Param("example") InspectItemExample example);

    int updateByPrimaryKeySelective(InspectItem record);

    int updateByPrimaryKey(InspectItem record);
}