package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SysLoginLog;
import com.deepsoft.haolifa.model.domain.SysLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLoginLogMapper {
    int countByExample(SysLoginLogExample example);

    int deleteByExample(SysLoginLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    List<SysLoginLog> selectByExample(SysLoginLogExample example);

    SysLoginLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysLoginLog record, @Param("example") SysLoginLogExample example);

    int updateByExample(@Param("record") SysLoginLog record, @Param("example") SysLoginLogExample example);

    int updateByPrimaryKeySelective(SysLoginLog record);

    int updateByPrimaryKey(SysLoginLog record);
}