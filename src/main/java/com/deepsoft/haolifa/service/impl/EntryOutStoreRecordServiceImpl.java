package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
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
import com.deepsoft.haolifa.model.dto.product.ProductRequestDTO;
import com.deepsoft.haolifa.model.dto.storage.*;
import com.deepsoft.haolifa.service.*;
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
import java.util.*;

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
    @Autowired
    private ProductService productService;


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
        }};
        BeanUtils.copyProperties(model, entryOutStoreRecord);
        // 获取价格，根据产品Id和订单号
        OrderProductAssociateExample associateExample = new OrderProductAssociateExample();
        associateExample.createCriteria().andOrderNoEqualTo(model.getOrderNo())
            .andProductNoEqualTo(model.getProductNo())
            .andSpecificationsEqualTo(model.getProductSpecifications())
            .andProductModelEqualTo(model.getProductModel());
        List<OrderProductAssociate> associates = associateMapper.selectByExample(associateExample);
        if (CollectionUtil.isNotEmpty(associates)) {
            OrderProductAssociate orderProductAssociate = associates.get(0);
            entryOutStoreRecord.setPrice(orderProductAssociate.getPrice());
        }
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
            OrderProductAssociateExample associateExample1 = new OrderProductAssociateExample();
            associateExample1.createCriteria().andOrderNoEqualTo(model.getOrderNo());
            List<OrderProductAssociate> associates1 = associateMapper.selectByExample(associateExample1);
            int orderProNumber = associates1.stream().map(OrderProductAssociate::getProductNumber).reduce(0, (a, b) -> a + b);
            log.info("entry product orderNo:{},orderProNumber:{},storeCount:{}", orderNo, orderProNumber, storeCount);
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
        final Integer quantity = model.getQuantity();
        // 待出库数量
        int outProductCount = Math.abs(quantity);

        // 只能小于入库数量，不能合并出库
        EntryOutStoreRecord storeRecord = entryOutStoreRecordMapper.selectByPrimaryKey(model.getId());
        if (ObjectUtil.isNotNull(storeRecord)) {
            if (outProductCount > storeRecord.getQuantity()) {
                return ResultBean.error(CommonEnum.ResponseEnum.OUT_PRODUCT_QUANTITY_LIMIT);
            }
        }
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
            setRecordId(model.getId());
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
                setQuantity(quantity);
            }};
            // 减少库存
            stockService.reduceStock(entryOutStorageDTO);

            // 如果outPlace为1 ，代表进入产品库
            if (model.getOutPlace() != null && model.getOutPlace() == 1) {
                // 添加或者更新成品库
                ProductRequestDTO productRequestDTO = new ProductRequestDTO();
                productRequestDTO.setSpecifications(model.getProductSpecifications());
                productRequestDTO.setProductNo(model.getProductNo());
                productRequestDTO.setProductModel(model.getProductModel());
                productRequestDTO.setQty(Math.abs(model.getQuantity()));
                productRequestDTO.setOrderNo(model.getOrderNo());
                productRequestDTO.setEntryOutRecordId(entryOutStoreRecord.getId());
                productService.addOrUpdateProduct(productRequestDTO);
            }
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
        }};
        BeanUtils.copyProperties(model, entryOutStoreRecord);
        entryOutStoreRecord.setPrice(material.getPrice());
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
        List<String> batchNoList = model.getBatchNoList();
        if (StringUtils.isBlank(materialBatchNo) && CollectionUtil.isEmpty(batchNoList)) {
            String pcTime = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            model.setMaterialBatchNo(pcTime);
        }
        if (CollectionUtil.isEmpty(batchNoList)) {
            batchNoList = Arrays.asList(materialBatchNo);
        }

        // 根据零件图号，批次号获取库房和库位
        final Integer quantity = model.getQuantity();
        // 判断库房是否有这么多数量
        List<Stock> stockList = stockService.infoStocks(materialGraphNo, batchNoList);
        if (CollectionUtil.isEmpty(stockList)) {
            log.error("not stock record by materialGraphNo:{},materialBatchNo:{}", materialGraphNo, materialBatchNo);
            return 0;
        } else {
            int sum = stockList.stream().mapToInt(Stock::getQuantity).sum();
            if (sum < Math.abs(quantity)) {
                log.error("not enough quantity sum:{}, materialGraphNo:{},materialBatchNo:{}", sum, materialGraphNo, materialBatchNo);
                return 0;
            }
        }
        int absQty = Math.abs(quantity);
        boolean isExit = false;
        for (Stock stock : stockList) {
            Integer stockQuantity = stock.getQuantity();
            int needQty = 0;
            if (absQty - stockQuantity <= 0) {
                needQty = absQty;
                absQty = 0;
            } else {
                needQty = stockQuantity;
                absQty = absQty - stockQuantity;
            }
            String roomNo = stock.getRoomNo();
            String rackNo = stock.getRackNo();
            // 插入出入库记录表
            EntryOutStoreRecord entryOutStoreRecord = new EntryOutStoreRecord();
            BeanUtils.copyProperties(model, entryOutStoreRecord);
            entryOutStoreRecord.setQuantity(-needQty);
            entryOutStoreRecord.setRackNo(rackNo);
            entryOutStoreRecord.setMaterialBatchNo(stock.getMaterialBatchNo());
            entryOutStoreRecord.setOperationType(operationType);
            entryOutStoreRecord.setType(storageType);
            entryOutStoreRecord.setCreateUser(getLoginUserId());
            int insert = entryOutStoreRecordMapper.insertSelective(entryOutStoreRecord);
            if (insert > 0) {
                EntryOutStorageDTO entryOutStorageDTO = new EntryOutStorageDTO();
                entryOutStorageDTO.setRoomNo(roomNo);
                entryOutStorageDTO.setRackNo(rackNo);
                entryOutStorageDTO.setMaterialBatchNo(materialBatchNo);
                entryOutStorageDTO.setMaterialGraphNo(materialGraphNo);
                entryOutStorageDTO.setOperationType(operationType);
                entryOutStorageDTO.setType(storageType);
                entryOutStorageDTO.setQuantity(-needQty);
                entryOutStorageDTO.setLockQuantity(-needQty);
                // 减少库存
                boolean reduceStock = stockService.reduceStock(entryOutStorageDTO);
                log.info("material reduce stock result:{},materialNo:{},batchNo:{},rackNo:{},quantity:{}", reduceStock,
                    materialGraphNo, materialBatchNo, rackNo, -needQty);
                // 如果该零件有锁定数量，先减少锁定数量，在减少当前库存量
                Material infoByGraphNo = materialService.getInfoByGraphNo(materialGraphNo);
                Integer lockQuantity = infoByGraphNo.getLockQuantity();
                if (lockQuantity == 0) {
                    // 更新零件的当前库存量
                    materialService.updateCurrentQuantity(materialGraphNo, -needQty);
                } else {
                    if (lockQuantity >= needQty) {
                        log.info("material reduce lockQuantity:{},quantity:{},graphNo:{}", lockQuantity, quantity, materialGraphNo);
                        materialService.updateLockQuantity(materialGraphNo, quantity);
                    } else {
                        int needCurrentQuantity = needQty - lockQuantity;
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
                        Entrust entrust = new Entrust();
                        entrust.setOutRoomStatus(CommonEnum.OutRoomStatus.OUT.type);
                        entrustMapper.updateByExampleSelective(entrust, entrustExample);
                    } else if (model.getType().equals(CommonEnum.materialOutType.SPRAY.type)) {
                        SprayItemExample sprayItemExample = new SprayItemExample();
                        sprayItemExample.or().andSprayNoEqualTo(busNo).andIdEqualTo(busId);
                        SprayItem sprayItem = new SprayItem();
                        sprayItem.setOutRoomStatus(CommonEnum.OutRoomStatus.OUT.type);
                        sprayItemMapper.updateByExampleSelective(sprayItem, sprayItemExample);
                    }
                }
            }

            if (isExit) {
                break;
            }
        }
        return 1;
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
            for (int i = 0; i < entryOutStoreRecords.size(); i++) {
                EntryOutStoreRecord entryOutStoreRecord = entryOutStoreRecords.get(i);
                ProductStorageListDTO productStorageListDTO = new ProductStorageListDTO();
                BeanUtils.copyProperties(entryOutStoreRecord, productStorageListDTO);
                if (entryOutStoreRecord.getOperationType() == OperationType.ENTRY.code) {
                    int isExecute = 0;// 默认可出库
                    // 获取已经出库的数量
                    Integer id = entryOutStoreRecord.getId();
                    Integer quantity = entryOutStoreRecord.getQuantity();
                    if (this.outProductCount(id) >= quantity) {
                        isExecute = 1;// 不可出库
                    } else {
                        String oneOrderNo = entryOutStoreRecord.getOrderNo();
                        String oneProductNo = entryOutStoreRecord.getProductNo();
                        // 已经入库
                        int entryStoreCount = getEntryProductCountByOrderNo(oneOrderNo, oneProductNo);
                        // 已经出库数量
                        int outStoreCount = getOutProductCountByOrderNo(oneOrderNo, oneProductNo);
                        if (entryStoreCount <= outStoreCount) {
                            isExecute = 1;// 不可出库
                        }
                    }
                    productStorageListDTO.setExecute(isExecute);
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

    /**
     * 判断是否展示出库按钮（成品出库列表）
     */
    private int outProductCount(int recordId) {
        EntryOutStoreRecordExample example = new EntryOutStoreRecordExample();
        example.or().andRecordIdEqualTo(recordId);
        List<EntryOutStoreRecord> entryOutStoreRecords = entryOutStoreRecordMapper.selectByExample(example);
        if (CollectionUtil.isNotEmpty(entryOutStoreRecords)) {
            int sum = entryOutStoreRecords.stream().mapToInt(EntryOutStoreRecord::getQuantity).sum();
            return Math.abs(sum);
        }
        return 0;
    }
}
