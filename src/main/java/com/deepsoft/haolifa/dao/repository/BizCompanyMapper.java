package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizCompany;
import com.deepsoft.haolifa.model.domain.BizCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizCompanyMapper {
    int countByExample(BizCompanyExample example);

    int deleteByExample(BizCompanyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BizCompany record);

    int insertSelective(BizCompany record);

    List<BizCompany> selectByExample(BizCompanyExample example);

    BizCompany selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BizCompany record, @Param("example") BizCompanyExample example);

    int updateByExample(@Param("record") BizCompany record, @Param("example") BizCompanyExample example);

    int updateByPrimaryKeySelective(BizCompany record);

    int updateByPrimaryKey(BizCompany record);
}