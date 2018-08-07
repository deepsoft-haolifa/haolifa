package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SupplierRequestDTO;

public interface SupplierService {
    /**
     * 保存供应商信息
     * @param model
     * @return
     */
    ResultBean saveInfo(SupplierRequestDTO model);

    /**
     * 更新供应商信息
     * @param model
     * @return
     */
    ResultBean updateInfo(SupplierRequestDTO model);

    /**
     * 删除供应商
     * @param id
     * @return
     */
    ResultBean deleteInfo(Integer id);

    /**
     * 获取供应商详情
     * @param id
     * @return
     */
    ResultBean getInfo(Integer id);

    /**
     * 获取供应商列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    ResultBean getList(Integer currentPage, Integer pageSize,String supplierName,String supplierNo);
}
