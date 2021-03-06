package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SupplierPorductDTO;
import com.deepsoft.haolifa.model.dto.SupplierProductListDTO;

import java.util.List;

public interface SupplierProductService {
    /**
     * 添加产品
     * @param listModel
     * @return
     */
    ResultBean save(List<SupplierPorductDTO> listModel) ;

    /**
     * 删除产品
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新产品
     * @param model
     * @return
     */
    ResultBean update(SupplierPorductDTO model);

    /**
     * 获取详情
     * @param id
     * @return
     */
    ResultBean getInfo(Integer id);

    /**
     * 获取列表
     * @param model
     * @return
     */
    ResultBean getList(SupplierProductListDTO model);
}
