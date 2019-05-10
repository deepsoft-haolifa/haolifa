package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CommonEnum.OrderStatus.PRODUCTION_FINISH;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.cache.redis.RedisDao;
import com.deepsoft.haolifa.dao.repository.EntryOutStoreRecordMapper;
import com.deepsoft.haolifa.dao.repository.OrderProductAssociateMapper;
import com.deepsoft.haolifa.model.domain.EntryOutStoreRecord;
import com.deepsoft.haolifa.model.domain.EntryOutStoreRecordExample;
import com.deepsoft.haolifa.model.domain.OrderProductAssociate;
import com.deepsoft.haolifa.model.domain.OrderProductAssociateExample;
import com.deepsoft.haolifa.model.domain.Stock;
import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.storage.EntryMaterialStorageDTO;
import com.deepsoft.haolifa.model.dto.storage.EntryProductStorageDTO;
import com.deepsoft.haolifa.model.dto.storage.OutMaterialStorageDTO;
import com.deepsoft.haolifa.model.dto.storage.OutProductStorageDTO;
import com.deepsoft.haolifa.service.EntryOutStoreRecordService;
import com.deepsoft.haolifa.service.MaterialService;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.StockService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
  @Autowired
  private MaterialService materialService;
  @Autowired
  private OrderProductAssociateMapper associateMapper;
  @Autowired
  private OrderProductService orderProductService;

  @Autowired
  private RedisDao redisDao;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public int entryProduct(EntryProductStorageDTO model) {
    log.info("EntryOutStoreRecordServiceImpl entryProduct start model:{}", model.toString());
    byte operationType = CommonEnum.OperationType.ENTRY.code;
    byte storageType = CommonEnum.StorageType.PRODUCT.code;
    String orderNo = model.getOrderNo();
    // 保证数量是正数
    model.setQuantity(Math.abs(model.getQuantity()));
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
        setRoomNo(model.getRoomNo());
        setRackNo(model.getRackNo());
        setProductNo(model.getProductNo());
        setProductModel(model.getProductModel());
        setProductSpecifications(model.getProductSpecifications());
        setOperationType(operationType);
        setType(storageType);
        setQuantity(model.getQuantity());
      }};
      // 增加库存
      boolean result = stockService.addStock(entryOutStorageDTO);
      log.info("EntryOutStoreRecordServiceImpl entryProduct add stock result:{}", result);
      // 统计入库数量-->变更订单状态（生产完成）
      EntryOutStoreRecordExample recordExample = new EntryOutStoreRecordExample();
      recordExample.createCriteria().andOrderNoEqualTo(model.getOrderNo());
      List<EntryOutStoreRecord> recordList = entryOutStoreRecordMapper.selectByExample(recordExample);
      int storeCount = recordList.stream().map(EntryOutStoreRecord::getQuantity).reduce(0, (a, b) -> a + b);
      OrderProductAssociateExample associateExample = new OrderProductAssociateExample();
      associateExample.createCriteria().andOrderNoEqualTo(model.getOrderNo());
      List<OrderProductAssociate> associates = associateMapper.selectByExample(associateExample);
      int orderProNumber = associates.stream().map(OrderProductAssociate::getProductNumber).reduce(0, (a, b) -> a + b);
      if(orderProNumber <= storeCount) {
        orderProductService.updateOrderProductStatus(model.getOrderNo(), PRODUCTION_FINISH.code);
      }
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
    // 保证数量是负数
    model.setQuantity(-Math.abs(model.getQuantity()));
    String customerNo = "";
    String customerName = "";
    EntryOutStoreRecord entryOutStoreRecord = new EntryOutStoreRecord() {{
      setOperationType(operationType);
      setType(storageType);
      setCreateUser(getLoginUserId());
      setCustomerName(customerName);
      setCustomerNo(customerNo);
      setRecordId(RandomUtils.uuidStr());
    }};
    BeanUtils.copyProperties(model, entryOutStoreRecord);
    // 插入出入库表
    int insert = entryOutStoreRecordMapper.insertSelective(entryOutStoreRecord);
    if (insert > 0) {
      EntryOutStorageDTO entryOutStorageDTO = new EntryOutStorageDTO() {{
        setRoomNo(model.getRoomNo());
        setRackNo(model.getRackNo());
        setProductNo(model.getProductNo());
        setProductModel(model.getProductModel());
        setProductSpecifications(model.getProductSpecifications());
        setOperationType(operationType);
        setType(storageType);
        setQuantity(model.getQuantity());
      }};
      // 减少库存
      stockService.reduceStock(entryOutStorageDTO);
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
    // 保证数量是正数
    model.setQuantity(Math.abs(model.getQuantity()));
    final String materialGraphNo = model.getMaterialGraphNo();
    // 如果不传入批次号，就给个默认批次号
    if (StringUtils.isBlank(model.getMaterialBatchNo())) {
      model.setMaterialBatchNo("默认批次号");
    }
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
        setRoomNo(model.getRoomNo());
        setRackNo(model.getRackNo());
        setMaterialBatchNo(model.getMaterialBatchNo());
        setMaterialGraphNo(materialGraphNo);
        setOperationType(operationType);
        setType(storageType);
        setQuantity(quantity);
      }};
      // 增加库存
      stockService.addStock(entryOutStorageDTO);
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
    // 保证数量是负数
    model.setQuantity(-Math.abs(model.getQuantity()));
    final String materialGraphNo = model.getMaterialGraphNo();
    final String materialBatchNo = model.getMaterialBatchNo();
    final String roomNo = model.getRoomNo();
    final String rackNo = model.getRackNo();
    if (StringUtils.isBlank(materialBatchNo)) {
      model.setMaterialBatchNo("默认批次号");
    }
    final Integer quantity = model.getQuantity();
    // 判断库房是否有这么多数量
    Stock stock = stockService.infoStocks(roomNo, rackNo, materialGraphNo, materialBatchNo);
    if (stock == null) {
      log.error("not stock record by roomNo:{},rackNo:{},materialGraphNo:{},materialBatchNo:{}", roomNo, rackNo,
          materialGraphNo, materialBatchNo);
      return 0;
    }
    if (stock.getQuantity() < Math.abs(quantity)) {
      log.warn("not enough quantity  by roomNo:{},rackNo:{},materialGraphNo:{},materialBatchNo:{}", roomNo, rackNo,
          materialGraphNo, materialBatchNo);
      return 0;
    }

    // 插入出入库记录表
    EntryOutStoreRecord entryOutStoreRecord = new EntryOutStoreRecord() {{
      setOperationType(operationType);
      setType(storageType);
      setCreateUser(getLoginUserId());
      setRecordId(RandomUtils.uuidStr());
    }};
    BeanUtils.copyProperties(model, entryOutStoreRecord);
    int insert = entryOutStoreRecordMapper.insertSelective(entryOutStoreRecord);

    if (insert > 0) {
      EntryOutStorageDTO entryOutStorageDTO = new EntryOutStorageDTO() {{
        setRoomNo(roomNo);
        setRackNo(rackNo);
        setMaterialBatchNo(materialBatchNo);
        setMaterialGraphNo(materialGraphNo);
        setOperationType(operationType);
        setType(storageType);
        setQuantity(quantity);
        setLockQuantity(quantity);

      }};
      // 减少库存
      stockService.reduceStock(entryOutStorageDTO);
      // 更新零件的当前库存量
      materialService.updateCurrentQuantity(materialGraphNo, quantity);
    }
    return insert;
  }


  @Override
  public ResultBean pageInfoEntryOutRecord(Integer currentPage, Integer pageSize, Integer type, Integer operationType,
      String productNo, String materialGraphNo, String orderNo) {
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
      criteria.andOrderNoLike("%" + orderNo + "%");
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
