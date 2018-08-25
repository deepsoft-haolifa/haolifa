package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface EntryOutStoreRecordService {

    /**
     * 成品入库
     *
     * @return
     */
    int entryProduct(EntryOutStorageDTO model);

    /**
     * 成品出库
     *
     * @return
     */
    int outProduct(EntryOutStorageDTO model);

    /**
     * 零件入库
     *
     * @return
     */
    int entryMaterial(EntryOutStorageDTO model);

    /**
     * 零件出库
     *
     * @return
     */
    int outMaterial(EntryOutStorageDTO model);


    /**
     * 分页获取出入库记录
     *
     * @param currentPage     页码
     * @param pageSize        页数
     * @param type            1.成品；2：零件;
     * @param operationType   1.出库；2：入库;
     * @param productNo       产品号
     * @param materialGraphNo 零件号
     * @param orderNo         订单号
     * @return
     */
    ResultBean pageInfoEntryOutRecord(Integer currentPage, Integer pageSize,
                                      Integer type,
                                      Integer operationType,
                                      String productNo,
                                      String materialGraphNo,
                                      String orderNo);

}
