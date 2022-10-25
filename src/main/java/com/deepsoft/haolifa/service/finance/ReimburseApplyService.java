package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.enums.LoanApplyStatusEnum;
import com.deepsoft.haolifa.enums.ReimburseApplyStatusEnum;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.*;

import java.util.List;

public interface ReimburseApplyService {
    /**
     * 添加
     *
     * @param model
     * @return
     */
    ResultBean save(ReimburseApplyAddDTO model);


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
    ResultBean update(ReimburseApplyUpDTO model);

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    ResultBean<ReimburseApplyDetailDTO> getInfo(Integer id);

    /**
     * 获取列表
     *
     * @param model
     * @return
     */
    ResultBean<PageDTO<ReimburseApplyRSDTO>> getList(ReimburseApplyRQDTO model);

    public int auditReplaceMaterial(String item_id, ReimburseApplyStatusEnum auditResult);

    public ResultBean approve(Integer id);

    ResultBean<Integer>  pay(ReimburseApplyPayDTO payDTO);

}
