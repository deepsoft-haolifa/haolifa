package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.*;

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
    ResultBean getInfo(Integer id);

    /**
     * 获取列表
     *
     * @param model
     * @return
     */
    ResultBean<PageDTO<ReimburseApplyRSDTO>> getList(ReimburseApplyRQDTO model);

    public ResultBean approve(Integer id);

    ResultBean pay(ReimburseApplyPayDTO payDTO);

}
