package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.dao.repository.StockMapper;
import com.deepsoft.haolifa.dao.repository.extend.StockExtendMapper;
import com.deepsoft.haolifa.model.domain.Stock;
import com.deepsoft.haolifa.model.domain.StockExample;
import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.storage.BatchNoListDTO;
import com.deepsoft.haolifa.model.dto.storage.MaterialBatchNoDTO;
import com.deepsoft.haolifa.service.StockService;
import com.deepsoft.haolifa.util.RandomUtils;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class StockServiceImpl extends BaseService implements StockService {

    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private StockExtendMapper stockExtendMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addStock(EntryOutStorageDTO model) {
        log.info("StockServiceImpl addStock:{}", model.toString());
        boolean result = false;
        Stock stock = null;
        StockExample example = new StockExample();
        StockExample.Criteria criteria = example.createCriteria();
        criteria.andRoomNoEqualTo(model.getRoomNo()).andRackNoEqualTo(model.getRackNo());
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
        // 如果有记录，更新
        if (stocks.size() > 0) {
            int update = 0;
            if (model.getType() == CommonEnum.StorageType.MATERIAL.code) {
                update = stockExtendMapper.addMaterialQuantity(model.getRoomNo(), model.getRackNo(), model.getMaterialGraphNo(), model.getMaterialBatchNo(), model.getQuantity());
            } else {
                update = stockExtendMapper.addProductQuantity(model.getRoomNo(), model.getRackNo(), model.getProductNo(), model.getQuantity());
            }
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
    @Transactional(rollbackFor = Exception.class)
    public boolean reduceStock(EntryOutStorageDTO model) {
        log.info("StockServiceImpl reduceStock:{}", model.toString());
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
            int update = 0;
            if (model.getType() == CommonEnum.StorageType.MATERIAL.code) {
                update = stockExtendMapper.reduceMaterialQuantity(model.getRoomNo(), model.getRackNo(), model.getMaterialGraphNo(), model.getMaterialBatchNo(), model.getQuantity());
            } else {
                update = stockExtendMapper.reduceProductQuantity(model.getRoomNo(), model.getRackNo(), model.getProductNo(), model.getQuantity());
            }
            if (update > 0) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public List<MaterialBatchNoDTO> listMaterialBatchNos(String roomNo, String rackNo, String materialGraphNo) {
        StockExample example = new StockExample();
        StockExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isBlank(materialGraphNo)) {
            return Collections.emptyList();
        }
        if (StringUtils.isNotBlank(roomNo)) {
            criteria.andRoomNoEqualTo(roomNo);
        }
        if (StringUtils.isNotBlank(rackNo)) {
            criteria.andRackNoEqualTo(rackNo);
        }
        criteria.andMaterialGraphNoEqualTo(materialGraphNo);
        criteria.andQuantityGreaterThan(0);
        List<Stock> stocks = stockMapper.selectByExample(example);
        if (stocks.size() > 0) {
            return JSON.parseArray(JSON.toJSONString(stocks), MaterialBatchNoDTO.class);
        }
        return new ArrayList<>();
    }

    @Override
    public List<MaterialBatchNoDTO> batchListNo(BatchNoListDTO model) {
        StockExample example = new StockExample();
        StockExample.Criteria criteria = example.createCriteria();
        criteria.andQuantityGreaterThan(0);
        if (StringUtils.isBlank(model.getGraphNo())) {
            return Collections.emptyList();
        }
//        if (model.getQty() != null) {
//            criteria.andQuantityGreaterThanOrEqualTo(model.getQty());
//        }
        if (StringUtils.isNotBlank(model.getBatchNo())) {
            criteria.andMaterialBatchNoEqualTo(model.getBatchNo());
        }
        criteria.andMaterialGraphNoEqualTo(model.getGraphNo());
        List<Stock> stocks = stockMapper.selectByExample(example);
        if (stocks.size() > 0) {
            return JSON.parseArray(JSON.toJSONString(stocks), MaterialBatchNoDTO.class);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Stock> infoStocks(String materialGraphNo, List<String> batchNoList, List<String> rackNoList) {
        StockExample example = new StockExample();
        StockExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(materialGraphNo)) {
            criteria.andMaterialGraphNoEqualTo(materialGraphNo);
        }
        if (CollectionUtil.isNotEmpty(batchNoList)) {
            criteria.andMaterialBatchNoIn(batchNoList);
        }
        if (CollectionUtil.isNotEmpty(rackNoList)) {
            criteria.andRackNoIn(rackNoList);
        }
        return stockMapper.selectByExample(example);
    }


    @Override
    public ResultBean pageInfoStockWarn(Integer currentPage, Integer pageSize, String type) {
        return null;
    }
}
