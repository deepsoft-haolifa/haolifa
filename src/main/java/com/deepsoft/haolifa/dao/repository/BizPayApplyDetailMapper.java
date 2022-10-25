package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizPayApplyDetail;
import com.deepsoft.haolifa.model.domain.BizPayApplyDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizPayApplyDetailMapper {
    int countByExample(BizPayApplyDetailExample example);

    int deleteByExample(BizPayApplyDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizPayApplyDetail record);

    int insertSelective(BizPayApplyDetail record);

    List<BizPayApplyDetail> selectByExample(BizPayApplyDetailExample example);

    BizPayApplyDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizPayApplyDetail record, @Param("example") BizPayApplyDetailExample example);

    int updateByExample(@Param("record") BizPayApplyDetail record, @Param("example") BizPayApplyDetailExample example);

    int updateByPrimaryKeySelective(BizPayApplyDetail record);

    int updateByPrimaryKey(BizPayApplyDetail record);
}