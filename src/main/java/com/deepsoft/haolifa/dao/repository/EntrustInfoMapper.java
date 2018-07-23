package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.EntrustInfo;
import com.deepsoft.haolifa.model.domain.EntrustInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntrustInfoMapper {
    long countByExample(EntrustInfoExample example);

    int deleteByExample(EntrustInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EntrustInfo record);

    int insertSelective(EntrustInfo record);

    List<EntrustInfo> selectByExample(EntrustInfoExample example);

    EntrustInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EntrustInfo record, @Param("example") EntrustInfoExample example);

    int updateByExample(@Param("record") EntrustInfo record, @Param("example") EntrustInfoExample example);

    int updateByPrimaryKeySelective(EntrustInfo record);

    int updateByPrimaryKey(EntrustInfo record);
}