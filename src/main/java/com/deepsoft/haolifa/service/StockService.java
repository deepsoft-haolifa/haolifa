package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.Stock;
import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.storage.BatchNoListDTO;
import com.deepsoft.haolifa.model.dto.storage.MaterialBatchNoDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StockService {

    /**
     * 零件，成品增加库存
     * <p>
     * 如果增加库存，quantity字段是正数
     *
     * @return
     */
    boolean addStock(EntryOutStorageDTO model);

    /**
     * 零件，成品减少库存
     * <p>
     * ；减少库存，quantity字段传负数
     *
     * @return
     */
    boolean reduceStock(EntryOutStorageDTO model);

    /**
     * 根据库房，库位，图号获取批次号列表（当前库存大于0）
     */
    List<MaterialBatchNoDTO> listMaterialBatchNos(String roomNo, String rackNo, String materialGraphNo);

    /**
     * 批次号列表
     */
    List<MaterialBatchNoDTO> batchListNo(BatchNoListDTO model);


    /**
     * 根据批次号，图号，获取库存列表信息
     *
     * @param materialGraphNo
     * @return
     */
    List<Stock> infoStocks(String materialGraphNo, List<String> materialBatchNo,List<String> rackNoList);


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
