package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyAddDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyUpDTO;

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
    ResultBean getInfo(Integer id);

    /**
     * 获取列表
     *
     * @param model
     * @return
     */
    ResultBean getList(LoanApplyRQDTO model);

    public ResultBean approve(Integer id);
}
