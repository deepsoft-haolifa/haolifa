package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.StockMapper;
import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.StockReqDTO;
import com.deepsoft.haolifa.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Override
    public boolean addReduceStock(EntryOutStorageDTO model) {
        return false;
    }

    @Override
    public boolean updateStock(StockReqDTO model) {
        return false;
    }

    @Override
    public int getStockInfo(String materialGraphNo, String productNo) {
        return 0;
    }

    @Override
    public ResultBean pageInfoStockWarn(Integer currentPage, Integer pageSize, String type) {
        return null;
    }
}
