package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.FinanceDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface FinanceService {
    /**
     * 添加财务记录
     * @param model
     * @return
     */
    ResultBean save(FinanceDTO model);

    /**
     * 删除财务记录
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新财务记录
     * @param model
     * @return
     */
    ResultBean update(FinanceDTO model);

    /**
     * 获取财务记录列表
     * @param currentPage
     * @param pageSize
     * @param orderNo
     * @return
     */
    ResultBean getList(Integer currentPage, Integer pageSize, String orderNo);
}
