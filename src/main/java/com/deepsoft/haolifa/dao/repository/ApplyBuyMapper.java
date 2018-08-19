package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ApplyBuy;
import com.deepsoft.haolifa.model.domain.ApplyBuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyBuyMapper {
    long countByExample(ApplyBuyExample example);

    int deleteByExample(ApplyBuyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplyBuy record);

    int insertSelective(ApplyBuy record);

    List<ApplyBuy> selectByExample(ApplyBuyExample example);

    ApplyBuy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplyBuy record, @Param("example") ApplyBuyExample example);

    int updateByExample(@Param("record") ApplyBuy record, @Param("example") ApplyBuyExample example);

    int updateByPrimaryKeySelective(ApplyBuy record);

    int updateByPrimaryKey(ApplyBuy record);

    /**
     * 批量插入请购单记录
     * @param applyBuyList
     */
    void batchInsertApplyBuy(List<ApplyBuy> applyBuyList);
}