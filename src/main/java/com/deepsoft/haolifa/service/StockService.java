package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.StockReqDTO;

public interface StockService {

    /**
     * 零件，成品增加或者减少库存
     * <p>
     * 如果增加库存，quantity字段是正数；减少库存，quantity字段传负数
     *
     * @return
     */
    boolean addReduceStock(EntryOutStorageDTO model);


    /**
     * 修改安全库存信息
     *
     * @return
     */
    boolean updateStock(StockReqDTO model);

    /**
     * 获取某个零件或者成品的库存
     *
     * @param materialGraphNo 零件图号
     * @param productNo       产品号
     * @return
     */
    int getStockInfo(String materialGraphNo, String productNo);


    /**
     * 分页获取预警库存
     *
     * @param currentPage 页码
     * @param pageSize    页数
     * @param type        1.成品；2：零件;
     * @return
     */
    ResultBean pageInfoStockWarn(Integer currentPage, Integer pageSize, String type);
}
