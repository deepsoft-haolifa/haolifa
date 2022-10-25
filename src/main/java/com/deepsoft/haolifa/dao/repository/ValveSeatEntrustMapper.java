package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ValveSeatEntrust;
import com.deepsoft.haolifa.model.domain.ValveSeatEntrustExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ValveSeatEntrustMapper {
    int countByExample(ValveSeatEntrustExample example);

    int deleteByExample(ValveSeatEntrustExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ValveSeatEntrust record);

    int insertSelective(ValveSeatEntrust record);

    List<ValveSeatEntrust> selectByExample(ValveSeatEntrustExample example);

    ValveSeatEntrust selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ValveSeatEntrust record, @Param("example") ValveSeatEntrustExample example);

    int updateByExample(@Param("record") ValveSeatEntrust record, @Param("example") ValveSeatEntrustExample example);

    int updateByPrimaryKeySelective(ValveSeatEntrust record);

    int updateByPrimaryKey(ValveSeatEntrust record);
}