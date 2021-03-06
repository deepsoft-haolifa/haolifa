package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.ProductMaterial;
import com.deepsoft.haolifa.model.dto.ResultBean;

import java.util.List;

public interface ProductMaterialService {

    /**
     * 根据成品号获取关联的零件列表
     *
     * @param productNo 产品No
     * @return
     */
    List<ProductMaterial> getMaterialListByNo(String productNo);


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