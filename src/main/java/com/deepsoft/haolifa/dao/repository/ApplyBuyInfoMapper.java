package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ApplyBuyInfo;
import com.deepsoft.haolifa.model.domain.ApplyBuyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyBuyInfoMapper {
    long countByExample(ApplyBuyInfoExample example);

    int deleteByExample(ApplyBuyInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplyBuyInfo record);

    int insertSelective(ApplyBuyInfo record);

    List<ApplyBuyInfo> selectByExample(ApplyBuyInfoExample example);

    ApplyBuyInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplyBuyInfo record, @Param("example") ApplyBuyInfoExample example);

    int updateByExample(@Param("record") ApplyBuyInfo record, @Param("example") ApplyBuyInfoExample example);

    int updateByPrimaryKeySelective(ApplyBuyInfo record);

    int updateByPrimaryKey(ApplyBuyInfo record);
}