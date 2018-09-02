package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;

public interface ProductMaterialService {

    /**
     * 添加成品零件配置
     *
     * @param productNo       产品No
     * @param materialGraphNo 原料图号
     * @return
     */
    ResultBean saveInfo(String productNo, String materialGraphNo);


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
