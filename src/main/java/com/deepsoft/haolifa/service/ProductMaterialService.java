package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ProductMaterialDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface ProductMaterialService {

    /**
     * 编辑成品零件配置（添加修改信息）
     *
     * @param productNo       产品No
     * @param model       产品No
     * @return
     */
    ResultBean editInfo(String productNo,ProductMaterialDTO model);


    /**
     * 删除成品零件配置
     *
     * @return
     */
    ResultBean delete(String productNo, String materialGraphNo);

    /**
     * 获取成品零件配置分页列表
     *
     * @param currentPage 页码
     * @param pageSize    页数
     * @return
     */
    ResultBean pageInfo(Integer currentPage, Integer pageSize, String productNo);

}
