package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizLoanApply;
import com.deepsoft.haolifa.model.domain.BizLoanApplyExample;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplySumRSDTO;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizLoanApplyMapper {
    int countByExample(BizLoanApplyExample example);

    int deleteByExample(BizLoanApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizLoanApply record);

    int insertSelective(BizLoanApply record);

    List<BizLoanApply> selectByExample(BizLoanApplyExample example);

    BizLoanApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizLoanApply record, @Param("example") BizLoanApplyExample example);

    int updateByExample(@Param("record") BizLoanApply record, @Param("example") BizLoanApplyExample example);

    int updateByPrimaryKeySelective(BizLoanApply record);

    int updateByPrimaryKey(BizLoanApply record);

    LoanApplySumRSDTO listSummary(@Param("query")LoanApplyRQDTO model);



}
