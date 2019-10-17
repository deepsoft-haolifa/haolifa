package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.PriceProduct;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.price.PriceProductConditionDTO;


public interface PriceProductService {

    /**
     * 添加
     *{
     *   "accessories": "手柄",
     *   "accessoriesPrice": "6",
     *   "connectionMode": "7A",
     *   "drive": "Sb",
     *   "drivePrice": "15",
     *   "fabanMaterial": "N",
     *   "fabanPrice": "12",
     *   "fatiMaterial": "Z",
     *   "fatiPrice": "28",
     *   "fazhouMaterial": "416J",
     *   "fazhouPrice": "7",
     *   "fazuoPrice": "7",
     *   "haoliModel": "220DSb7A1X3N-16",
     *   "model": "220D",
     *   "nominalPressure": "16",
     *   "priceBook": "67.76055",
     *   "productPrice": "68",
     *   "remark": "",
     *   "sealForm": "X3",
     *   "specifications": "DN50",
     *   "structuralStyle": "1",
     *   "totalPrice": "75"
     *
     * }
     * @param model
     * @return
     */
    ResultBean saveInfo(PriceProduct model);


    /**
     * 更新
     *
     * @param model
     * @return
     */
    ResultBean updateInfo(PriceProduct model);

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
    PriceProduct getInfo(int id);

    /**
     * 获取产品价格信息
     *
     * @return
     */
    PriceProduct getInfoByProductId(String productId,String productModel);


    /**
     * 获取分页列表
     * @return
     */
    ResultBean pageInfo(PriceProductConditionDTO priceProductConditionDTO);
}
