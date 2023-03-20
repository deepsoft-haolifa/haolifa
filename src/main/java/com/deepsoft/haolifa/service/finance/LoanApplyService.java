package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.enums.LoanApplyStatusEnum;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.loanapply.*;

import java.math.BigDecimal;
import java.util.List;

public interface LoanApplyService {
    /**
     * 添加
     *
     * @param model
     * @return
     */
    ResultBean save(LoanApplyAddDTO model);


    /**
     * 删除
     *
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新
     *
     * @param model
     * @return
     */
    ResultBean update(LoanApplyUpDTO model);

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    ResultBean<LoanApplyInfoRSDTO> getInfo(Integer id);

    /**
     * 获取列表
     *
     * @param model
     * @return
     */
    ResultBean<PageDTO<LoanApplyRSDTO>> getList(LoanApplyRQDTO model);

    LoanApplySumRSDTO listSummary(LoanApplyRQDTO model);

    public ResultBean<List<LoanApplyRSDTO>> getLoanApplyList(LoanApplyRQDTO model);

    public int auditReplaceMaterial(String item_id, LoanApplyStatusEnum auditResult);

    public ResultBean approve(Integer id);

    ResultBean pay(LoanApplyPayDTO loanApplyPayDTO);


    public ResultBean<Integer> repaymentAmount(Integer loanId, BigDecimal offsetAmount);

    public ResultBean<Integer> fallbackRepaymentAmount(Integer loanId, BigDecimal offsetAmount);

}
