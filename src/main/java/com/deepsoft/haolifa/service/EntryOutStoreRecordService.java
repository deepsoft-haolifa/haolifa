package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.storage.*;

import java.util.List;
import java.util.Map;

public interface EntryOutStoreRecordService {

    /**
     * 成品入库
     *
     * @return
     */
    int entryProduct(EntryProductStorageDTO model);

    /**
     * 成品出库
     *
     * @return
     */
    ResultBean outProduct(OutProductStorageDTO model);

    /**
     * 已经出库的数量
     * @return
     */
    int getOutProductCount(ProductStorageDto model);

    /**
     * 成品已出库数量
     * @return
     */
    Map<String,Integer> mapOutProductCount(List<String> orderNo);
    /**
     * 零件入库
     *
     * @return
     */
    int entryMaterial(EntryMaterialStorageDTO model);

    /**
     * 零件出库
     *
     * @return
     */
    int outMaterial(OutMaterialStorageDTO model);


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
