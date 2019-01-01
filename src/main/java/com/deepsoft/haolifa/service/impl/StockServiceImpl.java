package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.StockMapper;
import com.deepsoft.haolifa.model.domain.Stock;
import com.deepsoft.haolifa.model.domain.StockExample;
import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.StockService;
import com.deepsoft.haolifa.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class StockServiceImpl extends BaseService implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addReduceStock(EntryOutStorageDTO model) {
        log.info("StockServiceImpl addReduceStock:{}", model.toString());
        boolean result = false;
        Stock stock = null;
        StockExample example = new StockExample();
        StockExample.Criteria criteria = example.createCriteria();
        criteria.andRoomNoEqualTo(model.getRoomNo())
                .andRackNoEqualTo(model.getRackNo());
        // 零件才有批次号的概念
        if (model.getType() == CommonEnum.StorageType.MATERIAL.code) {
            criteria.andMaterialBatchNoEqualTo(model.getMaterialBatchNo());

        }
        if (StringUtils.isNotBlank(model.getProductNo())) {
            criteria.andProductNoEqualTo(model.getProductNo());
        }
        if (StringUtils.isNotBlank(model.getMaterialGraphNo())) {
            criteria.andMaterialGraphNoEqualTo(model.getMaterialGraphNo());
        }
        List<Stock> stocks = stockMapper.selectByExample(example);
        if (stocks.size() > 0) {
            stock = stocks.get(0);
            //更新库存数量
            if (null != model.getQuantity() && model.getQuantity() != 0) {
                stock.setQuantity(stock.getQuantity() + model.getQuantity());
            }
//            // 更新锁定数量
//            if (null != model.getLockQuantity() && model.getLockQuantity() != 0) {
//                stock.setLockQuantity(stock.getLockQuantity() + model.getLockQuantity());
//            }
            stock.setUpdateTime(new Date());
            int update = stockMapper.updateByExampleSelective(stock, example);
            if (update > 0) {
                result = true;
            }
        } else {
            stock = new Stock();
            BeanUtils.copyProperties(model, stock);
            stock.setCreateUser(getLoginUserId());
            int insert = stockMapper.insertSelective(stock);
            if (insert > 0) {
                result = true;
            }
        }
        return result;
    }


    @Override
    public ResultBean pageInfoStockWarn(Integer currentPage, Integer pageSize, String type) {
        return null;
    }
}
