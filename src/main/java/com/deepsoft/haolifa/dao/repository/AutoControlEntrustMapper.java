package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.AutoControlEntrust;
import com.deepsoft.haolifa.model.domain.AutoControlEntrustExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoControlEntrustMapper {
    int countByExample(AutoControlEntrustExample example);

    int deleteByExample(AutoControlEntrustExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AutoControlEntrust record);

    int insertSelective(AutoControlEntrust record);

    List<AutoControlEntrust> selectByExample(AutoControlEntrustExample example);

    AutoControlEntrust selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AutoControlEntrust record, @Param("example") AutoControlEntrustExample example);

    int updateByExample(@Param("record") AutoControlEntrust record, @Param("example") AutoControlEntrustExample example);

    int updateByPrimaryKeySelective(AutoControlEntrust record);

    int updateByPrimaryKey(AutoControlEntrust record);
}