package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizAssets;
import com.deepsoft.haolifa.model.domain.BizAssetsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizAssetsMapper {
    int countByExample(BizAssetsExample example);

    int deleteByExample(BizAssetsExample example);

    int deleteByPrimaryKey(Long assetsId);

    int insert(BizAssets record);

    int insertSelective(BizAssets record);

    List<BizAssets> selectByExample(BizAssetsExample example);

    BizAssets selectByPrimaryKey(Long assetsId);

    int updateByExampleSelective(@Param("record") BizAssets record, @Param("example") BizAssetsExample example);

    int updateByExample(@Param("record") BizAssets record, @Param("example") BizAssetsExample example);

    int updateByPrimaryKeySelective(BizAssets record);

    int updateByPrimaryKey(BizAssets record);
}