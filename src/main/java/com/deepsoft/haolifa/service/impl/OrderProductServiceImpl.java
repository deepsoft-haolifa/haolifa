package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.deepsoft.haolifa.cache.CacheKeyManager;
import com.deepsoft.haolifa.cache.NoCacheLoadCallBack;
import com.deepsoft.haolifa.cache.redis.RedisDao;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.dao.repository.extend.OrderExtendMapper;
import com.deepsoft.haolifa.model.dto.OrderMaterialDTO;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.condition.OrderConditionDTO;
import com.deepsoft.haolifa.service.MaterialService;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.ProductMaterialService;
import com.deepsoft.haolifa.service.ProductModelConfigService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class OrderProductServiceImpl extends BaseService implements OrderProductService {
    @Autowired
    private OrderProductMapper orderProductMapper;
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private OrderExtendMapper orderMaterialExtendMapper;
    @Autowired
    private OrderMaterialMapper orderMaterialMapper;
    @Autowired
    private CheckMaterialLogMapper checkMaterialLogMapper;
    @Autowired
    private OrderProductAssociateMapper orderProductAssociateMapper;
    @Autowired
    private OrderExtendMapper orderExtendMapper;
    @Autowired
    private ProductModelConfigService productModelConfigService;
    @Autowired
    private MaterialRequisitionMapper materialRequisitionMapper;

    @Override
    public ResultBean uploadOrderProductExcel(String base64Source) {
//        OrderProduct orderProduct = new OrderProduct();
//        if (StringUtils.isBlank(base64Source)) {
//            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
//        }
//        byte[] bytes = Base64Utils.base64ToByte(base64Source);
//        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
//             HSSFWorkbook sheets = new HSSFWorkbook(inputStream);) {
//            HSSFSheet sheet = sheets.getSheetAt(0);
//            log.info("upload orderProduct excel row num:{}", sheet.getLastRowNum());
//            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
//                String cellValue = "";
//                HSSFRow row = sheet.getRow(i);
//                if (null != row) {
//                    HSSFCell cell = row.getCell(1);
//                    if (null != cell) {
//                        CellType cellTypeEnum = cell.getCellTypeEnum();
//                        switch (cellTypeEnum) {
//                            case STRING:
//                                String stringCellValue = cell.getStringCellValue();
//                                boolean number = NumberUtils.isNumber(stringCellValue);
//                                cellValue = number ? new Double(stringCellValue).toString() : stringCellValue;
//                                boolean digits = NumberUtils.isDigits(stringCellValue);
//                                cellValue = digits ? stringCellValue : cellValue;
//                                break;
//                            case NUMERIC:
//                                cellValue = new BigDecimal(cell.getNumericCellValue()).toString();
//                                if (cellValue.contains(".")) {
//                                    cellValue = Double.toString(cell.getNumericCellValue());
//                                }
//                                break;
//                            default:
//                                break;
//                        }
//                    }
//                }
//                switch (i) {
//                    case 1:
//                        orderProduct.setDemandName(cellValue);
//                        break;
//                    case 2:
//                        orderProduct.setDemandAgentName(cellValue);
//                        break;
//                    case 3:
//                        orderProduct.setDemandTelphone(cellValue);
//                        break;
//                    case 4:
//                        orderProduct.setDemandFax(cellValue);
//                        break;
//                    case 5:
//                        orderProduct.setDemandAddress(cellValue);
//                        break;
//                    case 6:
//                        orderProduct.setSupplyName(cellValue);
//                        break;
//                    case 7:
//                        orderProduct.setSupplyAgentName(cellValue);
//                        break;
//                    case 8:
//                        orderProduct.setSupplyTelphone(cellValue);
//                        break;
//                    case 9:
//                        orderProduct.setSupplyFax(cellValue);
//                        break;
//                    case 10:
//                        orderProduct.setSupplyAddress(cellValue);
//                        break;
//                    case 11:
//                        orderProduct.setContractNumber(cellValue);
//                        break;
//                    case 12:
//                        orderProduct.setContractSignDate(cellValue);
//                        break;
//                    case 13:
//                        orderProduct.setProductNo(cellValue);
//                        break;
//                    case 14:
//                        orderProduct.setProductName(cellValue);
//                        break;
//                    case 15:
//                        orderProduct.setLable(cellValue);
//                        break;
//                    case 16:
//                        orderProduct.setSpecifications(cellValue);
//                        break;
//                    case 17:
//                        orderProduct.setProductColor(cellValue);
//                        break;
//                    case 18:
//                        orderProduct.setProductNumber(Integer.valueOf(cellValue));
//                        break;
//                    case 19:
//                        orderProduct.setPrice(new BigDecimal(cellValue));
//                        break;
//                    case 20:
//                        orderProduct.setTotalPrice(new BigDecimal(cellValue));
//                        break;
//                    case 21:
//                        orderProduct.setDiscountTotalPrice(new BigDecimal(cellValue));
//                        break;
//                    case 22:
//                        orderProduct.setMaterialDescription(cellValue);
//                        break;
//                    case 23:
//                        orderProduct.setProductRemark(cellValue);
//                        break;
//                    case 24:
//                        orderProduct.setPurchaseFeedbackTime(cellValue);
//                        break;
//                    case 25:
//                        orderProduct.setProductionFeedbackTime(cellValue);
//                        break;
//                    case 26:
//                        orderProduct.setSpecialRequire(cellValue);
//                        break;
//                    case 27:
//                        orderProduct.setCargoInformation(cellValue);
//                        break;
//                    case 28:
//                        orderProduct.setSignBoard(cellValue);
//                        break;
//                    case 29:
//                        orderProduct.setAcceptanceCriteria(cellValue);
//                        break;
//                    case 30:
//                        orderProduct.setWarrantyPeriod(cellValue);
//                        break;
//                    case 31:
//                        orderProduct.setPackagingSpecification(cellValue);
//                        break;
//                    case 32:
//                        orderProduct.setTransportType(cellValue);
//                        break;
//                    case 33:
//                        orderProduct.setDeliveryTime(cellValue);
//                        break;
//                    case 34:
//                        orderProduct.setReceiptInfo(cellValue);
//                        break;
//                    case 35:
//                        orderProduct.setPaymentMethod(cellValue);
//                        break;
//                    case 36:
//                        orderProduct.setFreight(cellValue);
//                        break;
//                    default:
//                        break;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        log.info("upload orderProduct excel end|orderProduct:{}", JSONObject.toJSONString(orderProduct));
        return ResultBean.success(null);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultBean saveOrderProductInfo(OrderProductDTO orderProductDTO) {
        OrderProduct orderProduct = new OrderProduct();
        String orderNo = orderProductDTO.getOrderContractNo();
        log.info("save orderProduct info start|orderNo:{},model:{}", orderNo, JSONObject.toJSONString(orderProduct));
        if (null != getOrderProductInfo(orderNo)) {
            return ResultBean.error(CommonEnum.ResponseEnum.ORDER_NO_EXISTS);
        }
        orderProductDTO.setOrderNo(orderNo);
        // 属性copy复制
        BeanUtils.copyProperties(orderProductDTO, orderProduct);
        orderProduct.setCreateUser(getLoginUserId());
        orderProduct.setOrderStatus(CommonEnum.OrderStatus.CREATE.code);
        int insert = orderProductMapper.insertSelective(orderProduct);
        if (insert > 0) {
            // 批量插入订单产品关联表
            List<OrderProductAssociate> list = orderProductDTO.getOrderProductAssociates();
            list.stream().forEach(e -> {
                e.setOrderNo(orderNo);
                orderProductAssociateMapper.insertSelective(e);
            });
        }
        log.info("save orderProduct info end|orderNo:{},result:{}", orderNo, insert);
        return ResultBean.success(insert);
    }


    @Override
    public ResultBean updateOrderInfo(OrderUpdateDTO orderUpdateDTO) {
        String orderNo = orderUpdateDTO.getOrderNo();
        if (StringUtils.isBlank(orderNo)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }

        OrderProduct record = new OrderProduct();
        if (StringUtils.isNotBlank(orderUpdateDTO.getTechnicalRequire())) {
            record.setTechnicalRequire(orderUpdateDTO.getTechnicalRequire());
        }
        if (StringUtils.isNotBlank(orderUpdateDTO.getPurchaseFeedbackTime())) {
            record.setPurchaseFeedbackTime(orderUpdateDTO.getPurchaseFeedbackTime());
        }
        if (StringUtils.isNotBlank(orderUpdateDTO.getFinishFeedbackTime())) {
            record.setFinishFeedbackTime(orderUpdateDTO.getFinishFeedbackTime());
        }
        if (StringUtils.isNotBlank(orderUpdateDTO.getAssemblyShop())) {
            record.setAssemblyShop(orderUpdateDTO.getAssemblyShop());
        }
        if (StringUtils.isNotBlank(orderUpdateDTO.getAssemblyGroup())) {
            record.setAssemblyGroup(orderUpdateDTO.getAssemblyGroup());
        }

        OrderProductExample example = new OrderProductExample();
        example.or().andOrderNoEqualTo(orderNo);
        int update = orderProductMapper.updateByExampleSelective(record, example);
        if (update > 0) {
            //删除redis值
            redisDao.del(CacheKeyManager.cacheKeyOrderInfo(orderNo).key);
        }
        return ResultBean.success(update);
    }


    @Override
    public int updateOrderProductStatus(String orderNo, byte status) {
        log.info("update orderProduct status start|orderNo:{},status:{}", orderNo, status);
        OrderProduct record = new OrderProduct();
        record.setOrderStatus(status);
        OrderProductExample example = new OrderProductExample();
        example.or().andOrderNoEqualTo(orderNo);
        int update = orderProductMapper.updateByExampleSelective(record, example);
        if (update > 0) {
            // 删除redis值
            redisDao.del(CacheKeyManager.cacheKeyOrderInfo(orderNo).key);
        }
        return update;
    }

    @Override
    public OrderProductDTO getOrderProductInfo(String orderNo) {
        // 从redis中查，查不到从数据库中查
        return redisDao.queryCache(CacheKeyManager.cacheKeyOrderInfo(orderNo), new TypeReference<OrderProductDTO>() {
        }, new NoCacheLoadCallBack<OrderProductDTO>() {

            @Override
            public OrderProductDTO load() throws Exception {
                OrderProductDTO orderProductDTO = null;
                OrderProductExample example = new OrderProductExample();
                example.or().andOrderNoEqualTo(orderNo);
                List<OrderProduct> orderProducts = orderProductMapper.selectByExample(example);
                if (orderProducts.size() > 0) {
                    orderProductDTO = new OrderProductDTO();
                    OrderProduct orderProduct = orderProducts.get(0);
                    BeanUtils.copyProperties(orderProduct, orderProductDTO);
                    // 获取订单关联成品列表
                    List<OrderProductAssociate> orderProductAssociates = orderProductAssociateMapper.selectByExample(new OrderProductAssociateExample() {{
                        or().andOrderNoEqualTo(orderNo);
                    }});
                    orderProductDTO.setOrderProductAssociates(orderProductAssociates);
                }
                return orderProductDTO;
            }
        });

    }

    @Override
    public List<OrderProductAssociate> getOrderProductList(String orderNo) {
        return orderProductAssociateMapper.selectByExample(new OrderProductAssociateExample() {{
            or().andOrderNoEqualTo(orderNo);
        }});
    }


    @Override
    public ResultBean pageOrderProduct(OrderConditionDTO model) {
        OrderProductExample example = new OrderProductExample();
        OrderProductExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getOrderNo())) {
            criteria.andOrderNoLike("%" + model.getOrderNo() + "%");
        }
        if (model.getOrderStatus() > 0) {
            criteria.andOrderStatusEqualTo(model.getOrderStatus());
        }
        example.setOrderByClause("id desc");
        Page<OrderProduct> materials = PageHelper.startPage(model.getPageNum(), model.getPageSize())
                .doSelectPage(() -> orderProductMapper.selectByExample(example));

        PageDTO<OrderProduct> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(materials, pageDTO);
        pageDTO.setList(materials);
        return ResultBean.success(pageDTO);
    }


    // region #核料这一步的相关流程操作
    @Override
    public List<ProductCheckMaterialListDTO> getCheckOrderProductList(String orderNo) {
        List<ProductCheckMaterialListDTO> list = new ArrayList<>();
        // 获取订单关联成品列表
        List<OrderProductAssociate> orderProductAssociates = orderProductAssociateMapper.selectByExample(new OrderProductAssociateExample() {{
            or().andOrderNoEqualTo(orderNo);
        }});
        for (OrderProductAssociate orderProductAssociate : orderProductAssociates) {
            String productModel = orderProductAssociate.getProductModel();
            String specifications = orderProductAssociate.getSpecifications();
            ProductCheckMaterialListDTO productCheckMaterialListDTO = new ProductCheckMaterialListDTO();
            // 根据型号和规格获取可选零件列表（核料用）
            List<MaterialTypeListDTO> materials = getTypeMaterials(productModel, specifications);
            productCheckMaterialListDTO.setProductModel(productModel);
            productCheckMaterialListDTO.setSpecifications(specifications);
            productCheckMaterialListDTO.setProductNumber(orderProductAssociate.getProductNumber());
            productCheckMaterialListDTO.setListDTOS(materials);
            list.add(productCheckMaterialListDTO);
        }
        return list;
    }

    /**
     * 根据型号和规格获取原料（阀体，阀板，阀座,阀杆）
     *
     * @param productModel
     * @param specifications
     * @return
     */
    public List<MaterialTypeListDTO> getTypeMaterials(String productModel, String specifications) {
        // 1.获取规格,截取数字，保留四位数，前面补0（DN65=>0065）
        String spec = String.format("%04d", Integer.parseInt(specifications.replaceAll("[^0-9]", "")));
        // 成品型号示例（270DD7A1XH-16Q）
        // 2.获取型号的数据（270）
        String smallModel = "D" + productModel.substring(0, 3);
        int lastIndexOf = productModel.lastIndexOf("-");
        // 3.获取阀板材质(-前一位)
        String faban = productModel.substring(lastIndexOf - 1, lastIndexOf);
        // 4.获取阀座材质(-前两位)
        String fazuo = productModel.substring(lastIndexOf - 2, lastIndexOf - 1);
        // 5.获取阀体材质(最后一位)
        String fati = productModel.substring(productModel.length() - 1);
        // 6.获取阀体压力(-后两位)
        String fatiyali = productModel.substring(lastIndexOf + 1, lastIndexOf + 3);

        // 获取阀体规则
        List<String> fatiModelConfig = new ArrayList<>();
        // 获取阀体压力规则
        List<String> fatiYaliModelConfig = new ArrayList<>();
        // 获取阀座规则
        List<String> fazuoModelConfig = new ArrayList<>();
        // 获取阀板规则
        List<String> fabanModelConfig = new ArrayList<>();

        // 获取全部规则列表
        List<ProductModelConfig> modelConfigs = productModelConfigService.getList(0, "");
        if (modelConfigs != null && modelConfigs.size() > 0) {
            modelConfigs.stream().forEach(e -> {
                final String indexRule = e.getIndexRule();
                final Byte type = e.getType();
                if (indexRule.equals(fati) && type == CommonEnum.ProductModelType.FATI.code) {
                    fatiModelConfig.add(e.getMaterialGraphNoStr());
                } else if (indexRule.equals(fatiyali) && type == CommonEnum.ProductModelType.FATI_YALI.code) {
                    fatiYaliModelConfig.add(e.getMaterialGraphNoStr());
                } else if (indexRule.equals(fazuo) && type == CommonEnum.ProductModelType.FAZUO.code) {
                    fazuoModelConfig.add(e.getMaterialGraphNoStr());
                } else if (indexRule.equals(faban) && type == CommonEnum.ProductModelType.FABAN.code) {
                    fabanModelConfig.add(e.getMaterialGraphNoStr());
                }
            });
        }

        // 获取符合阀体的列表(D270-0050-01-00Qa-aF05-01-001)
        List<String> fatiCollect = new ArrayList<>();
        // 获取符合阀座的列表(D270-0050-02-E0-01)
        List<String> fazuoCollect = new ArrayList<>();
        // 获取符合阀板的列表(D270-0050-03-Hc-02-00)
        List<String> fabanCollect = new ArrayList<>();
        // 获取符合阀杆的列表
        List<String> faganCollect = new ArrayList<>();
        // 获取通用零件列表的列表
        List<String> tongyongCollect = new ArrayList<>();

        // 根据型号和规格，获取图号列表
        List<Material> listByModelAndSpec = materialService.getListByModelAndSpec(smallModel, specifications);
        if (listByModelAndSpec != null && listByModelAndSpec.size() > 0) {
            listByModelAndSpec.stream().forEach(e -> {
                String graphNo = e.getGraphNo();
                String[] split = graphNo.split("-");
                if (split.length > 2) {
                    String noIndex = split[2];
                    if ("01".equals(noIndex)) {// 阀体
                        if (split.length > 4) {
                            //阀体材质,阀体压力 都满足
                            if (fatiModelConfig.contains(split[3].replaceAll("[0-9]", "")) && fatiYaliModelConfig.contains(split[4].substring(0, 1))) {
                                fatiCollect.add(graphNo);
                            }
                        }
                    } else if ("02".equals(noIndex)) {//阀座
                        if (split.length > 3 && fazuoModelConfig.contains(split[3])) {
                            fazuoCollect.add(graphNo);
                        }
                    } else if ("03".equals(noIndex)) {// 阀板
                        if (split.length > 3 && fabanModelConfig.contains(split[3])) {
                            fabanCollect.add(graphNo);
                        }
                    } else if ("04".equals(noIndex)) { // 上阀杆
                        faganCollect.add(graphNo);
                    }
                }

                // 获取通用零件列表
                //  获取零件分类
//                Integer materialClassifyId = e.getMaterialClassifyId();
//                if (materialClassifyId == 5) {
//                    tongyongCollect.add(graphNo);
//                }
            });
        }
        List<MaterialTypeListDTO> listDTOS = new ArrayList<>();
        listDTOS.add(new MaterialTypeListDTO() {{
            setType(CommonEnum.ProductModelType.FATI.code);
            setList(fatiCollect);
        }});
        listDTOS.add(new MaterialTypeListDTO() {{
            setType(CommonEnum.ProductModelType.FAZUO.code);
            setList(fazuoCollect);
        }});
        listDTOS.add(new MaterialTypeListDTO() {{
            setType(CommonEnum.ProductModelType.FABAN.code);
            setList(fabanCollect);
        }});
        listDTOS.add(new MaterialTypeListDTO() {{
            setType(CommonEnum.ProductModelType.FAGAN.code);
            setList(faganCollect);
        }});
        listDTOS.add(new MaterialTypeListDTO() {{
            setType(CommonEnum.ProductModelType.TONG_YONG.code);
            setList(tongyongCollect);
        }});

        //根据规格和型号获取通用零件
        return listDTOS;
    }


    /**
     * 第一次核料，核心逻辑（根据前端表单传来的数据）
     *
     * @param productCheckMaterialListDTOList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<OrderCheckMaterialDTO> checkMaterial(String orderNo, List<ProductCheckMaterialListDTO> productCheckMaterialListDTOList) {
        List<OrderCheckMaterialDTO> orderCheckMaterialDTOS = new ArrayList<>();
        List<CheckMaterialLog> checkMaterialLogs = new ArrayList<>();
        // 核料总状态（0.全部成功；1.只要有一个零件是失败的,就是失败的）
        int currentUser = getLoginUserId();
        try {
            // 需要核料的零件
            Map<String, Integer> materialsMap = new HashMap<>();
            //通用零件特殊处理，不参与实际核料，直接库存充足
            Map<String, Integer> tongyongMaterialsMap = new HashMap<>();

            // 将订单中所有产品需要的零件合并起来
            productCheckMaterialListDTOList.stream().forEach(e -> {
                Integer productNumber = e.getProductNumber();
                List<MaterialTypeListDTO> listDTOS = e.getListDTOS();
                listDTOS.stream().forEach(a -> {
                    // 通用料
                    if (a.getType() == CommonEnum.ProductModelType.TONG_YONG.code) {
                        List<String> list = a.getList();
                        list.stream().forEach(b -> {
                            if (tongyongMaterialsMap.containsKey(b)) {
                                tongyongMaterialsMap.put(b, tongyongMaterialsMap.get(b) + productNumber);
                            } else {
                                tongyongMaterialsMap.put(b, productNumber);
                            }
                        });
                    } else {
                        List<String> list = a.getList();
                        list.stream().forEach(b -> {
                            if (materialsMap.containsKey(b)) {
                                materialsMap.put(b, materialsMap.get(b) + productNumber);
                            } else {
                                materialsMap.put(b, productNumber);
                            }
                        });
                    }
                });
            });

            // 循环通用零件，直接成功
            Iterator<Map.Entry<String, Integer>> tongyongIterator = tongyongMaterialsMap.entrySet().iterator();
            while (tongyongIterator.hasNext()) {
                OrderCheckMaterialDTO orderCheckMaterialDTO = new OrderCheckMaterialDTO();
                Map.Entry<String, Integer> next = tongyongIterator.next();
                String materialGraphNo = next.getKey();
                Integer materialCount = next.getValue();
                orderCheckMaterialDTO.setCheckStatus(CommonEnum.CheckMaterialStatus.SUCCESS.code);
                orderCheckMaterialDTO.setCheckResultMsg("核料成功，该零件余量充足");
                orderCheckMaterialDTO.setMaterialGraphNo(materialGraphNo);
                orderCheckMaterialDTO.setMaterialCount(materialCount);
                orderCheckMaterialDTO.setOrderNo(orderNo);
                orderCheckMaterialDTOS.add(orderCheckMaterialDTO);
            }

            // 循环所需的原料，进行核料
            Iterator<Map.Entry<String, Integer>> entryIterator = materialsMap.entrySet().iterator();
            while (entryIterator.hasNext()) {
                Byte checkState = 0, isReplace = 0;
                int lackMaterialCount = 0;
                String checkResult = "";
                List<String> replaceList = new ArrayList<>();
                OrderCheckMaterialDTO orderCheckMaterialDTO = new OrderCheckMaterialDTO();
                Map.Entry<String, Integer> next = entryIterator.next();
                String materialGraphNo = next.getKey();
                Integer materialCount = next.getValue();
                // 获取零件的库存
                Material infoByGraphNo = materialService.getInfoByGraphNo(materialGraphNo);
                Integer currentQuantity = infoByGraphNo.getCurrentQuantity();
                if (currentQuantity >= materialCount) {
                    checkState = CommonEnum.CheckMaterialStatus.SUCCESS.code;
                    checkResult = "核料成功，该零件余量充足";
                } else {
                    // 如果缺料，将可替换料列表返回给前端
                    String replaceGraphNos = infoByGraphNo.getReplaceGraphNos();
                    if (StringUtils.isNotBlank(replaceGraphNos)) {
                        String[] split = replaceGraphNos.split(",");
                        replaceList=Arrays.asList(split);
                        isReplace = CommonEnum.Consts.YES.code;
                    }
                    // 无料可以替换，需要走采购流程
                    checkState = CommonEnum.CheckMaterialStatus.NEED_PURCHASE.code;
                    // 缺少的料的数量
                    lackMaterialCount = (materialCount - currentQuantity);
                    checkResult = "库存不足";
                }
                orderCheckMaterialDTO.setReplaceGraphNoList(replaceList);
                orderCheckMaterialDTO.setLackMaterialCount(lackMaterialCount);
                orderCheckMaterialDTO.setIsReplace(isReplace);
                orderCheckMaterialDTO.setCheckStatus(checkState);
                orderCheckMaterialDTO.setCheckResultMsg(checkResult);
                orderCheckMaterialDTO.setMaterialGraphNo(materialGraphNo);
                orderCheckMaterialDTO.setMaterialCount(materialCount);
                orderCheckMaterialDTO.setOrderNo(orderNo);
                orderCheckMaterialDTOS.add(orderCheckMaterialDTO);

                // 添加核料日志记录
                int finalCheckState = checkState;
                String finalCheckResult = checkResult;
                checkMaterialLogs.add(new CheckMaterialLog() {
                    {
                        setMaterialGraphNo(materialGraphNo);
                        setCurrentMaterialCount(currentQuantity);
                        setNeedMaterialCount(materialCount);
                        setCheckUserId(currentUser);
                        setOrderNo(orderNo);
                        setCheckResult(finalCheckResult);
                        setCheckState(String.valueOf(finalCheckState));
                    }
                });
            }
            // 批量插入审核日志
            orderExtendMapper.insertBatchCheckLog(checkMaterialLogs);
        } catch (Exception e) {
            log.error("核料过程中出现的异常，orderNo:{}", orderNo, e);
        }
        return orderCheckMaterialDTOS;
    }


    /**
     * 替换料核料
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<OrderCheckMaterialDTO> checkReplaceMaterial(String
                                                                    orderNo, List<OrderCheckMaterialDTO> orderCheckMaterialDTOS) {
        // 核料总状态（0.全部成功；1.只要有一个零件是失败的；2.有替换料的零件，其余全成功）
        int checkState = 0;
        String checkResult = "";
        int currentUser = getLoginUserId();
        try {
            // 循环所需的原料，进行核料
            for (OrderCheckMaterialDTO orderCheckMaterialDTO : orderCheckMaterialDTOS) {
                String replaceMaterialGraphNo = orderCheckMaterialDTO.getReplaceMaterialGraphNo();
                if (StringUtils.isNotBlank(replaceMaterialGraphNo)) {
                    Integer materialCount = orderCheckMaterialDTO.getMaterialCount();
                    // 获取替换料零件的库存
                    Material replaceGraphNoInfo = materialService.getInfoByGraphNo(replaceMaterialGraphNo);
                    Integer replaceGraphNoInfoCurrentQuantity = replaceGraphNoInfo.getCurrentQuantity();
                    if (replaceGraphNoInfoCurrentQuantity >= materialCount) {
                        orderCheckMaterialDTO.setIsReplace(CommonEnum.Consts.YES.code);
                        orderCheckMaterialDTO.setCheckStatus(CommonEnum.CheckMaterialStatus.SUCCESS.code);
                        orderCheckMaterialDTO.setCheckResultMsg("核料成功，该零件替换料充足，可走替换料方案");
                        checkResult += "【替换料{" + replaceMaterialGraphNo + "}库存充足】,";
                        if (checkState != 1) {
                            checkState = 2;
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("替换料核料过程中出现的异常，orderNo:{}", orderNo, e);
        } finally {
            // 添加核料日志记录
            int finalCheckState = checkState;
            String finalCheckResult = checkResult;
            String finalOrderNo = orderNo;
            CheckMaterialLog checkMaterialLog = new CheckMaterialLog() {{
                setCheckUserId(currentUser);
                setOrderNo(finalOrderNo);
                setCheckResult(finalCheckResult);
                setCheckState(String.valueOf(finalCheckState));
            }};
            checkMaterialLogMapper.insertSelective(checkMaterialLog);
        }
        return orderCheckMaterialDTOS;
    }


    /**
     * 核料通过,锁定零件（核料员点击下一步）
     *
     * @param orderCheckMaterialDTOS
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int checkPass(List<OrderCheckMaterialDTO> orderCheckMaterialDTOS) {
        //  如果核料成功，也需要核料点下一步，才往下走
        if (orderCheckMaterialDTOS != null && orderCheckMaterialDTOS.size() > 0) {
            // 核料成功，插入核料表
            orderMaterialExtendMapper.insertBatchOrderMaterial(orderCheckMaterialDTOS);


            for (OrderCheckMaterialDTO orderCheckMaterialDTO : orderCheckMaterialDTOS) {
                // 更新零件当前库存和锁定库存
                String materialGraphNo = orderCheckMaterialDTO.getMaterialGraphNo();
                int materialCount = orderCheckMaterialDTO.getMaterialCount();
                materialService.updateCurrentQuantity(materialGraphNo, (-1) * materialCount);
                materialService.updateLockQuantity(materialGraphNo, materialCount);
            }
            return 1;
        }
        return 0;
    }

    /**
     * 综合计划【不同意】，将核完的料释放
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int releaseMaterial(String orderNo) {
        // 获取核料清单
        List<OrderMaterialDTO> orderMaterialDTOS = listOrderMaterial(orderNo);
        if (null != orderMaterialDTOS && orderMaterialDTOS.size() > 0) {
            orderMaterialDTOS.stream().forEach(e -> {
                // 将核料状态改为【释放料】
                String materialGraphNo = e.getMaterialGraphNo();
                orderMaterialMapper.updateByExampleSelective(new OrderMaterial() {{
                    setCheckStatus(CommonEnum.CheckMaterialStatus.RELEASE.code);
                }}, new OrderMaterialExample() {{
                    or().andOrderNoEqualTo(orderNo).andMaterialGraphNoEqualTo(materialGraphNo);
                }});
                // 将原料表释放
                int materialCount = e.getMaterialCount();
                materialService.updateCurrentQuantity(materialGraphNo, materialCount);
                materialService.updateLockQuantity(materialGraphNo, (-1) * materialCount);
            });
        }

        return 0;
    }


    // endregion

    @Override
    public List<OrderMaterialDTO> listOrderMaterial(String orderNo) {
        if (StringUtils.isNotBlank(orderNo)) {
            return orderExtendMapper.listOrderMaterial(orderNo);
        }
        return null;
    }

    @Override
    public MaterialRequisitionDTO saveMaterialRequisition(MaterialRequisitionDTO model) {
        MaterialRequisitionDTO materialRequisitionDTO = new MaterialRequisitionDTO();
        MaterialRequisition record = new MaterialRequisition();
        BeanUtils.copyProperties(model, record);
        record.setCreateUser(getLoginUserId());
        record.setReceiveNo("mr_" + RandomUtils.orderNoStr());
        int insertSelective = materialRequisitionMapper.insertSelective(record);
        if (insertSelective > 0) {
            BeanUtils.copyProperties(model, materialRequisitionDTO);
            List<OrderMaterialDTO> orderMaterialDTOS = listOrderMaterial(model.getOrderNo());
            materialRequisitionDTO.setListOrderMaterial(orderMaterialDTOS);
            return materialRequisitionDTO;
        }
        return null;
    }

    @Override
    public MaterialRequisitionDTO infoMaterialRequisition(String orderNo, String receiveNo) {
        MaterialRequisitionDTO materialRequisitionDTO = new MaterialRequisitionDTO();
        MaterialRequisitionExample example = new MaterialRequisitionExample();
        MaterialRequisitionExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        if (StringUtils.isNotBlank(receiveNo)) {
            criteria.andReceiveNoEqualTo(receiveNo);
        }
        List<MaterialRequisition> materialRequisitions = materialRequisitionMapper.selectByExample(example);
        if (materialRequisitions.size() > 0) {
            MaterialRequisition materialRequisition = materialRequisitions.get(0);
            // 转换实体
            BeanUtils.copyProperties(materialRequisition, materialRequisitionDTO);
            List<OrderMaterialDTO> orderMaterialDTOS = listOrderMaterial(orderNo);
            materialRequisitionDTO.setListOrderMaterial(orderMaterialDTOS);
        }
        return materialRequisitionDTO;
    }
}
