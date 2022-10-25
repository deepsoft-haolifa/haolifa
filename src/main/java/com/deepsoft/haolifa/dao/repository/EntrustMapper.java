package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.Entrust;
import com.deepsoft.haolifa.model.domain.EntrustExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntrustMapper {
    int countByExample(EntrustExample example);

    int deleteByExample(EntrustExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Entrust record);

    int insertSelective(Entrust record);

    List<Entrust> selectByExample(EntrustExample example);

    Entrust selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Entrust record, @Param("example") EntrustExample example);

    int updateByExample(@Param("record") Entrust record, @Param("example") EntrustExample example);

    int updateByPrimaryKeySelective(Entrust record);

    int updateByPrimaryKey(Entrust record);
}