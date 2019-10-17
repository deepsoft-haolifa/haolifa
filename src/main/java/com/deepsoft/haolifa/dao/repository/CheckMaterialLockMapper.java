package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.CheckMaterialLock;
import com.deepsoft.haolifa.model.domain.CheckMaterialLockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckMaterialLockMapper {
    int countByExample(CheckMaterialLockExample example);

    int deleteByExample(CheckMaterialLockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CheckMaterialLock record);

    int insertSelective(CheckMaterialLock record);

    List<CheckMaterialLock> selectByExample(CheckMaterialLockExample example);

    CheckMaterialLock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckMaterialLock record, @Param("example") CheckMaterialLockExample example);

    int updateByExample(@Param("record") CheckMaterialLock record, @Param("example") CheckMaterialLockExample example);

    int updateByPrimaryKeySelective(CheckMaterialLock record);

    int updateByPrimaryKey(CheckMaterialLock record);
}