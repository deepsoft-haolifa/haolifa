package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.InvoiceCreateDTO;
import com.deepsoft.haolifa.model.dto.InvoiceDTO;
import com.deepsoft.haolifa.model.dto.InvoiceListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

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
     * @param id
     * @param invoiceNo
     * @return
     */
    ResultBean updateInvoiceNo(Integer id, String invoiceNo);

    /**
     * 查询发票详情
     * @param id
     * @return
     */
    ResultBean info(Integer id);
}