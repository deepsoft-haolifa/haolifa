package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.cache.redis.RedisDao;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.OperationType;
import com.deepsoft.haolifa.constant.CommonEnum.StorageType;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.storage.*;
import com.deepsoft.haolifa.service.EntryOutStoreRecordService;
import com.deepsoft.haolifa.service.MaterialService;
import com.deepsoft.haolifa.service.OrderProductService;
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
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.deepsoft.haolifa.constant.CommonEnum.OrderStatus.PRODUCTION_FINISH;


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
    private EntrustMapper entrustMapper;
    @Autowired
    private MaterialRequisitionMapper materialRequisitionMapper;
    @Autowired
    private SprayItemMapper sprayItemMapper;


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
            int storeCount = getEntryProductCountByOrderNo(orderNo, "");
            OrderProductAssociateExample associateExample = new OrderProductAssociateExample();
            associateExample.createCriteria().andOrderNoEqualTo(model.getOrderNo());
            List<OrderProductAssociate> associates = associateMapper.selectByExample(associateExample);
            int orderProNumber = associates.stream().map(OrderProductAssociate::getProductNumber).reduce(0, (a, b) -> a + b);
            if (orderProNumber <= storeCount) {
                orderProductService.updateOrderProductStatus(model.getOrderNo(), PRODUCTION_FINISH.code);
            }
        }
        return insert;
    }

    /**
     * 根据订单号获取成品入库数
     */
    private int getEntryProductCountByOrderNo(String orderNo, String productNo) {
        EntryOutStoreRecordExample recordExample = new EntryOutStoreRecordExample();
        EntryOutStoreRecordExample.Criteria criteria = recordExample.createCriteria();
        criteria.andOrderNoEqualTo(orderNo)
            .andOperationTypeEqualTo(CommonEnum.OperationType.ENTRY.code)
            .andTypeEqualTo(CommonEnum.StorageType.PRODUCT.code);
        if (StringUtils.isNotBlank(productNo)) {
            criteria.andProductNoEqualTo(productNo);
        }

        List<EntryOutStoreRecord> recordList = entryOutStoreRecordMapper.selectByExample(recordExample);
        int storeCount = recordList.stream().map(EntryOutStoreRecord::getQuantity).reduce(0, (a, b) -> a + b);
        return storeCount;
    }

    /**
     * 根据订单号获取成品出库数
     */
    private int getOutProductCountByOrderNo(String orderNo, String productNo) {
        EntryOutStoreRecordExample recordExample = new EntryOutStoreRecordExample();
        EntryOutStoreRecordExample.Criteria criteria = recordExample.createCriteria();
        criteria.andOrderNoEqualTo(orderNo)
            .andOperationTypeEqualTo(CommonEnum.OperationType.OUT.code)
            .andTypeEqualTo(CommonEnum.StorageType.PRODUCT.code);
        if (StringUtils.isNotBlank(productNo)) {
            criteria.andProductNoEqualTo(productNo);
        }
        List<EntryOutStoreRecord> recordList = entryOutStoreRecordMapper.selectByExample(recordExample);
        int storeCount = recordList.stream().map(EntryOutStoreRecord::getQuantity).reduce(0, (a, b) -> a + b);
        storeCount = Math.abs(storeCount);
        return storeCount;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultBean outProduct(OutProductStorageDTO model) {
        log.info("EntryOutStoreRecordServiceImpl outProduct start model:{}", model.toString());
        byte operationType = CommonEnum.OperationType.OUT.code;
        byte storageType = CommonEnum.StorageType.PRODUCT.code;
        String orderNo = model.getOrderNo();
        String productNo = model.getProductNo();
        // 待出库数量
        int outProductCount = Math.abs(model.getQuantity());
        // 获取这个订单，这个成品号的入库数量，出库数量不能大于入库数量
        // 入库数量
        int entryOrderProductCount = getEntryProductCountByOrderNo(orderNo, productNo);
        // 已经出库数量
        int outOrderProductCount = getOutProductCountByOrderNo(orderNo, productNo);

        log.info("outProduct productNo already count:{},out count:{},orderNo:{},productNo:{}", outOrderProductCount, outProductCount, orderNo, productNo);
        if (outOrderProductCount + outProductCount > entryOrderProductCount) {
            log.error("outProduct productNo out count more than entry count，orderNo:{},productNo:{}", orderNo, productNo);
            return ResultBean.error(CommonEnum.ResponseEnum.OUT_PRODUCT_NO_COUNT_ERROR);
        }

        // 根据订单号获取入库数量，不能多出库
        // 入库数量,
        int entryProductCount = getEntryProductCountByOrderNo(orderNo, "");
        // 已经出库数量
        int storeCount = getOutProductCountByOrderNo(orderNo, "");
        log.info("outProduct already count:{},out count:{},orderNo:{}", storeCount, outProductCount, orderNo);
        if (storeCount + outProductCount > entryProductCount) {
            log.error("outProduct out count more than entry count，orderNo:{}", orderNo);
            return ResultBean.error(CommonEnum.ResponseEnum.OUT_PRODUCT_COUNT_ERROR);
        }


        // 保证数量是负数
        model.setQuantity(-outProductCount);
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
        // 查询单价
        OrderProductAssociateExample associateExample = new OrderProductAssociateExample();
        OrderProductAssociateExample.Criteria criteria = associateExample.createCriteria();
        criteria.andProductNoEqualTo(entryOutStoreRecord.getProductNo())
//        .andProductModelEqualTo(entryOutStoreRecord.getProductModel())
//        .andSpecificationsEqualTo(entryOutStoreRecord.getProductSpecifications())
            .andOrderNoEqualTo(entryOutStoreRecord.getOrderNo());
        List<OrderProductAssociate> associates = associateMapper.selectByExample(associateExample);
        if (!CollectionUtils.isEmpty(associates)) {
            entryOutStoreRecord.setPrice(associates.get(0).getPrice());
        } else {
            log.error("outProduct get product price null,orderNo:{},productNo:{} ", orderNo, entryOutStoreRecord.getProductNo());
        }
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
        return ResultBean.success(null);
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
        // 校验库中是否存在该零件号
        Material material = materialService.getInfoByGraphNo(materialGraphNo);
        if (material == null) {
            throw new BaseException(CommonEnum.ResponseEnum.MATERIAL_GRAPH_NO_NOT_EXIST);
        }
        // 如果不传入批次号，就给个默认批次号
        if (StringUtils.isBlank(model.getMaterialBatchNo())) {
            String pcTime = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            model.setMaterialBatchNo(pcTime);
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
            // 更新零件的当前库存量(如果是订单需求的入库，则将其入锁定料，不能再次被核料)
            if (model.getBusType() != null && model.getBusType().equals(CommonEnum.BusType.ORDER_REQUIRE.type)) {
                log.info("material entry busNo:{},batchNumber:{},graphNo:{},quantity:{}", model.getBusNo(), model.getMaterialBatchNo(), materialGraphNo, quantity);
                materialService.updateLockQuantity(materialGraphNo, quantity);
            } else {
                materialService.updateCurrentQuantity(materialGraphNo, quantity);
            }
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
            String pcTime = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            model.setMaterialBatchNo(pcTime);
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
        EntryOutStoreRecord entryOutStoreRecord = new EntryOutStoreRecord();
        BeanUtils.copyProperties(model, entryOutStoreRecord);
        entryOutStoreRecord.setOperationType(operationType);
        entryOutStoreRecord.setType(storageType);
        entryOutStoreRecord.setCreateUser(getLoginUserId());
        entryOutStoreRecord.setRecordId(RandomUtils.uuidStr());
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
            boolean reduceStock = stockService.reduceStock(entryOutStorageDTO);
            log.info("material reduce stock result:{},materialNo:{},batchNo:{},rackNo:{},quantity:{}", reduceStock,
                materialGraphNo, materialBatchNo, rackNo, quantity);
            // 如果该零件有锁定数量，先减少锁定数量，在减少当前库存量
            Material infoByGraphNo = materialService.getInfoByGraphNo(materialGraphNo);
            Integer lockQuantity = infoByGraphNo.getLockQuantity();
            if (lockQuantity == 0) {
                // 更新零件的当前库存量
                materialService.updateCurrentQuantity(materialGraphNo, quantity);
            } else {
                if (lockQuantity >= Math.abs(quantity)) {
                    log.info("material reduce lockQuantity:{},quantity:{},graphNo:{}", lockQuantity, quantity, materialGraphNo);
                    materialService.updateLockQuantity(materialGraphNo, quantity);
                } else {
                    int needCurrentQuantity = Math.abs(quantity) - lockQuantity;
                    log.info("this not appear material reduce lock quantity:{},needCurrentQuantity:{},graphNo:{}", lockQuantity,
                        needCurrentQuantity, materialGraphNo);
                    materialService.updateLockQuantity(materialGraphNo, -lockQuantity);
                    materialService.updateCurrentQuantity(materialGraphNo, -needCurrentQuantity);
                }
            }

            // 如果是有单号的入库，将其出库状态修改
            String busNo = model.getBusNo();
            Integer busId = model.getBusId();
            if (StringUtils.isNotBlank(busNo) && model.getType() != null && model.getType() > 0) {
                if (model.getType().equals(CommonEnum.materialOutType.MATERIAL_REQUISITION.type)) {
                    MaterialRequisitionExample requisitionExample = new MaterialRequisitionExample();
                    requisitionExample.or().andOrderNoEqualTo(busNo).andIdEqualTo(busId);
                    MaterialRequisition materialRequisition = new MaterialRequisition();
                    materialRequisition.setOutRoomStatus(CommonEnum.OutRoomStatus.OUT.type);
                    materialRequisitionMapper.updateByExampleSelective(materialRequisition, requisitionExample);
                } else if (model.getType().equals(CommonEnum.materialOutType.ENTRUST.type)) {
                    EntrustExample entrustExample = new EntrustExample();
                    entrustExample.or().andEntrustNoEqualTo(busNo).andIdEqualTo(busId);
                    ;
                    Entrust entrust = new Entrust();
                    entrust.setOutRoomStatus(CommonEnum.OutRoomStatus.OUT.type);
                    entrustMapper.updateByExampleSelective(entrust, entrustExample);
                } else if (model.getType().equals(CommonEnum.materialOutType.SPRAY.type)) {
                    SprayItemExample sprayItemExample = new SprayItemExample();
                    sprayItemExample.or().andSprayNoEqualTo(busNo).andIdEqualTo(busId);
                    ;
                    SprayItem sprayItem = new SprayItem();
                    sprayItem.setOutRoomStatus(CommonEnum.OutRoomStatus.OUT.type);
                    sprayItemMapper.updateByExampleSelective(sprayItem, sprayItemExample);
                }
            }
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

        if (type.byteValue() == StorageType.PRODUCT.code) {
            // 成品
            List<ProductStorageListDTO> productStorageListDTOS = new ArrayList<>();
            PageDTO<ProductStorageListDTO> pageDTO = new PageDTO<>();
            Map<String, Integer> executeMap = new HashMap<>();
            for (int i = 0; i < entryOutStoreRecords.size(); i++) {
                EntryOutStoreRecord entryOutStoreRecord = entryOutStoreRecords.get(i);
                ProductStorageListDTO productStorageListDTO = new ProductStorageListDTO();
                BeanUtils.copyProperties(entryOutStoreRecord, productStorageListDTO);
                if (entryOutStoreRecord.getOperationType() == OperationType.ENTRY.code) {
                    String oneOrderNo = entryOutStoreRecord.getOrderNo();
                    if (executeMap.containsKey(oneOrderNo)) {
                        productStorageListDTO.setExecute(executeMap.get(oneOrderNo));
                    } else {
                        // 入库数量
                        int entryProductCount = getEntryProductCountByOrderNo(oneOrderNo, "");
                        // 已经出库数量
                        int storeCount = getOutProductCountByOrderNo(oneOrderNo, "");
                        int isExecute = 0; // 默认可出库
                        if (entryProductCount <= storeCount) {
                            isExecute = 1;// 不可出库
                        }
                        productStorageListDTO.setExecute(isExecute);
                        executeMap.put(oneOrderNo, isExecute);
                    }
                } else {
                    productStorageListDTO.setExecute(0);
                }
                productStorageListDTOS.add(productStorageListDTO);
            }
            BeanUtils.copyProperties(entryOutStoreRecords, pageDTO);
            pageDTO.setList(productStorageListDTOS);
            return ResultBean.success(pageDTO);

        } else {
            PageDTO<EntryOutStoreRecord> pageDTO = new PageDTO<>();
            BeanUtils.copyProperties(entryOutStoreRecords, pageDTO);
            pageDTO.setList(entryOutStoreRecords);
            return ResultBean.success(pageDTO);
        }

    }
}
