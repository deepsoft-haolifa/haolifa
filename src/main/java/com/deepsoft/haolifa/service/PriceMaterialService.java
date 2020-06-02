package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.Material;
import com.deepsoft.haolifa.model.domain.PriceMaterial;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.price.PriceMaterialConditionDTO;
import com.deepsoft.haolifa.model.dto.price.PriceProductConditionDTO;


public interface PriceMaterialService {

    /**
     * 添加
     * @param model
     * @return
     */
    ResultBean saveInfo(PriceMaterial model);

    /**
     * 更新
     *
     * @param model
     * @return
     */
    ResultBean updateInfo(PriceMaterial model);

    /**
     * 删除
     *
     * @return
     */
    ResultBean delete(int id);


    /**
     * 获取主键Id详情
     *
     * @return
     */
    PriceMaterial getInfo(int id, String materialGraphNo);


    /**
     * 获取分页列表
     * @return
     */
    ResultBean pageInfo(PriceMaterialConditionDTO priceMaterialConditionDTO);

    /**
     * 更新
     *
     * @param model
     * @return
     */
    void updatePriceByMaterial(Material model);
}
