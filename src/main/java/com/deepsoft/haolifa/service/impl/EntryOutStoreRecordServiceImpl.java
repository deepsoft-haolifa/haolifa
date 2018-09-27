package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CacheConsts;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.redis.RedisDao;
import com.deepsoft.haolifa.dao.repository.EntryOutStoreRecordMapper;
import com.deepsoft.haolifa.model.domain.EntryOutStoreRecord;
import com.deepsoft.haolifa.model.domain.EntryOutStoreRecordExample;
import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.redis.RedisLockMaterial;
import com.deepsoft.haolifa.model.dto.storage.EntryMaterialStorageDTO;
import com.deepsoft.haolifa.model.dto.storage.EntryProductStorageDTO;
import com.deepsoft.haolifa.model.dto.storage.OutMaterialStorageDTO;
import com.deepsoft.haolifa.model.dto.storage.OutProductStorageDTO;
import com.deepsoft.haolifa.service.EntryOutStoreRecordService;
import com.deepsoft.haolifa.service.MaterialService;
import com.deepsoft.haolifa.service.StockService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
public class EntryOutStoreRecordServiceImpl extends BaseService implements EntryOutStoreRecordService {

    @Autowired
    private EntryOutStoreRecordMapper entryOutStoreRecordMapper;

    @Autowired
    private StockService stockService;
    @Autowired
    private MaterialService materialService;

    @Autowired
    private RedisDao redisDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int entryProduct(EntryProductStorageDTO model) {
        log.info("EntryOutStoreRecordServiceImpl entryProduct start model:{}", model.toString());
        byte operationType = CommonEnum.OperationType.ENTRY.code;
        byte storageType = CommonEnum.StorageType.PRODUCT.code;
        String orderNo = model.getOrderNo();
        EntryOutStoreRecord entryOutStoreRecord = new EntryOutStoreRecord() {{
            setOperationType(operationType);
            setType(storageType);
            setCreateUser(getLoginUserId());
            setRecordId(RandomUtils.uuidStr());
        }};
        BeanUtils.copyProperties(model, entryOutStoreRecord);
        // 插入出入库记录表
        int insert = entryOutStoreRecordMapper.insertSelective(entryOutStoreRecord);
        if (insert > 0) {
            EntryOutStorageDTO entryOutStorageDTO = new EntryOutStorageDTO() {{
                setStoreRoomId(model.getStoreRoomId());
                setStoreRoomRackNo(model.getStoreRoomRackNo());
                setProductNo(model.getProductNo());
                setOperationType(operationType);
                setType(storageType);
                setQuantity(model.getQuantity());
            }};
            // 增加库存
            boolean result = stockService.addReduceStock(entryOutStorageDTO);
            log.info("EntryOutStoreRecordServiceImpl entryProduct add stock result:{}", result);
        }
        return insert;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int outProduct(OutProductStorageDTO model) {
        log.info("EntryOutStoreRecordServiceImpl outProduct start model:{}", model.toString());
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
            setRecordId(RandomUtils.uuidStr());
        }};
        BeanUtils.copyProperties(model, entryOutStoreRecord);
        // 插入出入库表
        int insert = entryOutStoreRecordMapper.insertSelective(entryOutStoreRecord);
        if (insert > 0) {
            EntryOutStorageDTO entryOutStorageDTO = new EntryOutStorageDTO() {{
                setStoreRoomId(model.getStoreRoomId());
                setStoreRoomRackNo(model.getStoreRoomRackNo());
                setProductNo(model.getProductNo());
                setOperationType(operationType);
                setType(storageType);
                setQuantity(model.getQuantity());
            }};
            // 减少库存
            stockService.addReduceStock(entryOutStorageDTO);
        }
        return insert;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int entryMaterial(EntryMaterialStorageDTO model) {
        log.info("EntryOutStoreRecordServiceImpl entryMaterial start model:{}", model.toString());
        byte operationType = CommonEnum.OperationType.ENTRY.code;
        byte storageType = CommonEnum.StorageType.MATERIAL.code;
        String orderNo = model.getOrderNo();
        final String materialGraphNo = model.getMaterialGraphNo();
        final Integer quantity = model.getQuantity();
        EntryOutStoreRecord entryOutStoreRecord = new EntryOutStoreRecord() {{
            setOperationType(operationType);
            setType(storageType);
            setCreateUser(getLoginUserId());
            setRecordId(RandomUtils.uuidStr());
        }};
        BeanUtils.copyProperties(model, entryOutStoreRecord);
        // 插入出入库记录表
        int insert = entryOutStoreRecordMapper.insertSelective(entryOutStoreRecord);
        if (insert > 0) {
            EntryOutStorageDTO entryOutStorageDTO = new EntryOutStorageDTO() {{
                setStoreRoomId(model.getStoreRoomId());
                setStoreRoomRackNo(model.getStoreRoomRackNo());
                setMaterialGraphNo(materialGraphNo);
                setOperationType(operationType);
                setType(storageType);
                setQuantity(quantity);
            }};
            // 增加库存
            stockService.addReduceStock(entryOutStorageDTO);
            // 更新零件的当前库存量
            materialService.updateCurrentQuantity(materialGraphNo, quantity);
        }
        return insert;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int outMaterial(OutMaterialStorageDTO model) {
        log.info("EntryOutStoreRecordServiceImpl outMaterial start model:{}", model.toString());
        byte operationType = CommonEnum.OperationType.OUT.code;
        byte storageType = CommonEnum.StorageType.MATERIAL.code;
        final String orderNo = model.getOrderNo();
        final String materialGraphNo = model.getMaterialGraphNo();
        final Integer quantity = model.getQuantity();
        // todo 根据orderNo获取核料时候，锁定原料的数量和库位（从redis中）
        String lockMaterial = redisDao.get(CacheConsts.REDIS_KEY_LOCK_MATERIAL + orderNo);
        List<RedisLockMaterial> redisLockMaterials = JSONObject.parseArray(lockMaterial, RedisLockMaterial.class);

        EntryOutStoreRecord entryOutStoreRecord = new EntryOutStoreRecord() {{
            setOperationType(operationType);
            setType(storageType);
            setCreateUser(getLoginUserId());
            setRecordId(RandomUtils.uuidStr());
        }};
        BeanUtils.copyProperties(model, entryOutStoreRecord);
        // 插入出入库记录表
        int insert = entryOutStoreRecordMapper.insertSelective(entryOutStoreRecord);
        if (insert > 0) {
            EntryOutStorageDTO entryOutStorageDTO = new EntryOutStorageDTO() {{
                setStoreRoomId(model.getStoreRoomId());
                setStoreRoomRackNo(model.getStoreRoomRackNo());
                setMaterialGraphNo(materialGraphNo);
                setOperationType(operationType);
                setType(storageType);
                setQuantity(quantity);
                setLockQuantity(quantity);

            }};
            // 减少库存
            stockService.addReduceStock(entryOutStorageDTO);
            // 更新零件的当前库存量
            materialService.updateCurrentQuantity(materialGraphNo, quantity);
        }
        return insert;
    }


    @Override
    public ResultBean pageInfoEntryOutRecord(Integer currentPage, Integer pageSize, Integer type, Integer operationType, String productNo, String materialGraphNo, String orderNo) {
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 20 : pageSize;

        EntryOutStoreRecordExample example = new EntryOutStoreRecordExample();
        EntryOutStoreRecordExample.Criteria criteria = example.createCriteria();
        if (type > 0) {
            criteria.andTypeEqualTo(type.byteValue());
        }
        if (operationType > 0) {
            criteria.andOperationTypeEqualTo(operationType.byteValue());
        }
        if (StringUtils.isNotBlank(productNo)) {
            criteria.andProductNoEqualTo(productNo);
        }
        if (StringUtils.isNotBlank(materialGraphNo)) {
            criteria.andMaterialGraphNoEqualTo(materialGraphNo);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        example.setOrderByClause("create_time desc");
        Page<EntryOutStoreRecord> entryOutStoreRecords = PageHelper.startPage(currentPage, pageSize)
                .doSelectPage(() -> entryOutStoreRecordMapper.selectByExample(example));

        PageDTO<EntryOutStoreRecord> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(entryOutStoreRecords, pageDTO);
        pageDTO.setList(entryOutStoreRecords);
        return ResultBean.success(pageDTO);
    }
}
