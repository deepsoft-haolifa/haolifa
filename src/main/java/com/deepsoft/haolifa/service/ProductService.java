package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.Product;
import com.deepsoft.haolifa.model.dto.ProductConditionDTO;
import com.deepsoft.haolifa.model.dto.ProductRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

/**
 * 成品管理接口
 */
public interface ProductService {

    /**
     * 添加成品信息
     *
     * @param model
     * @return
     */
    ResultBean saveInfo(ProductRequestDTO model);


    /**
     * 更新成品配置
     *
     * @param model
     * @return
     */
    ResultBean updateInfo(ProductRequestDTO model);

    /**
     * 删除成品配置
     *
     * @return
     */
    ResultBean delete(int id);


    /**
     * 获取主键Id成品详情
     *
     * @return
     */
    Product getInfo(int id);

    /**
     * 获取成品分页列表
     * @param pageNum 页码
     * @param pageNum 页数
     * @param productConditionDTO 查询条件
     * @return
     */
    ResultBean pageInfo(Integer pageNum, Integer pageSize, ProductConditionDTO productConditionDTO);
}
