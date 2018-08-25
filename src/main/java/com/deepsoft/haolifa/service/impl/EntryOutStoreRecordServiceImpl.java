package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.EntryOutStoreRecordService;

public class EntryOutStoreRecordServiceImpl implements EntryOutStoreRecordService {
    @Override
    public int entryProduct(EntryOutStorageDTO model) {
        return 0;
    }

    @Override
    public int outProduct(EntryOutStorageDTO model) {
        return 0;
    }

    @Override
    public int entryMaterial(EntryOutStorageDTO model) {
        return 0;
    }

    @Override
    public int outMaterial(EntryOutStorageDTO model) {
        return 0;
    }

    @Override
    public ResultBean pageInfoEntryOutRecord(Integer currentPage, Integer pageSize, Integer type, Integer operationType, String productNo, String materialGraphNo, String orderNo) {
        return null;
    }
}
