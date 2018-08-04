package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.UnqualifiedProInfo;
import com.deepsoft.haolifa.model.domain.UnqualifiedProInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UnqualifiedProInfoMapper {
    long countByExample(UnqualifiedProInfoExample example);

    int deleteByExample(UnqualifiedProInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UnqualifiedProInfo record);

    int insertSelective(UnqualifiedProInfo record);

    List<UnqualifiedProInfo> selectByExample(UnqualifiedProInfoExample example);

    UnqualifiedProInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UnqualifiedProInfo record, @Param("example") UnqualifiedProInfoExample example);

    int updateByExample(@Param("record") UnqualifiedProInfo record, @Param("example") UnqualifiedProInfoExample example);

    int updateByPrimaryKeySelective(UnqualifiedProInfo record);

    int updateByPrimaryKey(UnqualifiedProInfo record);
}