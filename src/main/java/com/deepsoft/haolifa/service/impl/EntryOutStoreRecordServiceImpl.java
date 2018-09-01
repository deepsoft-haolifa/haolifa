package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.EntryOutStoreRecordMapper;
import com.deepsoft.haolifa.model.domain.EntryOutStoreRecord;
import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.storage.EntryMaterialStorageDTO;
import com.deepsoft.haolifa.model.dto.storage.EntryProductStorageDTO;
import com.deepsoft.haolifa.model.dto.storage.OutMaterialStorageDTO;
import com.deepsoft.haolifa.model.dto.storage.OutProductStorageDTO;
import com.deepsoft.haolifa.service.EntryOutStoreRecordService;
import com.deepsoft.haolifa.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class EntryOutStoreRecordServiceImpl extends BaseService implements EntryOutStoreRecordService {

    @Autowired
    private EntryOutStoreRecordMapper entryOutStoreRecordMapper;

    @Autowired
    private StockService stockService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int entryProduct(EntryProductStorageDTO model) {
        byte operationType = CommonEnum.OperationType.ENTRY.code;
        byte storageType = CommonEnum.StorageType.PRODUCT.code;
        String orderNo = model.getOrderNo();
        EntryOutStoreRecord entryOutStoreRecord = new EntryOutStoreRecord() {{
            setOperationType(operationType);
            setType(storageType);
            setCreateUser(getLoginUserId());
        }};
        BeanUtils.copyProperties(model, entryOutStoreRecord);
        // 插入出入库表
        int insert = entryOutStoreRecordMapper.insertSelective(entryOutStoreRecord);
        if (insert > 0) {
            EntryOutStorageDTO entryOutStorageDTO = new EntryOutStorageDTO() {{
                setProductNo(model.getProductNo());
                setOperationType((int) operationType);
                setType((int) storageType);
                setQuantity(model.getQuantity());
            }};
            // 增加减少库存
            stockService.addReduceStock(entryOutStorageDTO);
        }
        return insert;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int outProduct(OutProductStorageDTO model) {
        byte operationType = CommonEnum.OperationType.OUT.code;
        byte storageType = CommonEnum.StorageType.PRODUCT.code;
        // TODO 根据orderNo获取详情 客户代号和客户名称
        String orderNo = model.getOrderNo();
        String customeNo = "";
        String customeName = "";
        EntryOutStoreRecord entryOutStoreRecord = new EntryOutStoreRecord() {{
            setOperationType(operationType);
            setType(storageType);
            setCreateUser(getLoginUserId());
            setCustomerName(customeName);
            setCustomerNo(customeNo);
        }};
        BeanUtils.copyProperties(model, entryOutStoreRecord);
        // 插入出入库表
        int insert = entryOutStoreRecordMapper.insertSelective(entryOutStoreRecord);
        if (insert > 0) {
            EntryOutStorageDTO entryOutStorageDTO = new EntryOutStorageDTO() {{
                setProductNo(model.getProductNo());
                setOperationType((int) operationType);
                setType((int) storageType);
                setQuantity(model.getQuantity());

            }};
            // 增加减少库存
            stockService.addReduceStock(entryOutStorageDTO);
        }
        return insert;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int entryMaterial(EntryMaterialStorageDTO model) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int outMaterial(OutMaterialStorageDTO model) {
        return 0;
    }


    @Override
    public ResultBean pageInfoEntryOutRecord(Integer currentPage, Integer pageSize, Integer type, Integer operationType, String productNo, String materialGraphNo, String orderNo) {
        return null;
    }
}
