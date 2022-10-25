package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.Product;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.product.OutProductDTO;
import com.deepsoft.haolifa.model.dto.product.ProductConditionDTO;
import com.deepsoft.haolifa.model.dto.product.ProductRequestDTO;
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
    ResultBean delete(int id, String productNo);


    /**
     * 获取主键Id成品详情
     *
     * @return
     */
    Product getInfo(int id);

    /**
     * 获取no成品详情
     *
     * @return
     */
    Product getInfoByNo(String productNo);

    /**
     * 获取成品详情信息（包含关联的零件信息）
     *
     * @param id
     * @return
     */
    ProductRequestDTO getProductAllInfo(int id);

    /**
     * 获取成品分页列表
     *
     * @return
     */
    ResultBean<PageDTO<Product>> pageInfo(ProductConditionDTO model);

    /**
     * 成品出库，添加/更新成品库存
     *
     * @return
     */
    boolean addOrUpdateProduct(ProductRequestDTO model);

    /**
     * 成品库出库
     *
     * @return
     */
    boolean outProduct(OutProductDTO model);
}
