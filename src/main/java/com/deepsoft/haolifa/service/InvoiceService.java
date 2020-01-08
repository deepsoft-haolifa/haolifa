package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.*;

public interface InvoiceService {
    /**
     * 添加财务记录
     * @param model
     * @return
     */
    ResultBean save(InvoiceCreateDTO model);

    /**
     * 删除财务记录
     * @param id
     * @return
     */
    ResultBean delete(int id);

    /**
     * 更新财务记录
     * @param model
     * @return
     */
    ResultBean update(InvoiceDTO model);

    /**
     * 获取财务记录列表
     * @param modelList
     * @param origin
     * @return
     */
    ResultBean getList(int origin, InvoiceListDTO modelList);

    /**
     * 填写发票编号
     * @return
     */
    ResultBean updateInvoiceNo(InvoiceStatusDTO statusDTO);

    /**
     * 查询发票详情
     * @param id
     * @return
     */
    ResultBean info(Integer id);

    /**
     * 更新发票状态
     * @param statusDTO
     * @return
     */
    int updateStatus(InvoiceStatusDTO statusDTO);
}
