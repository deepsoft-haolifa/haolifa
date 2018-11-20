package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.CheckMaterialLogMapper;
import com.deepsoft.haolifa.dao.repository.OrderProductAssociateMapper;
import com.deepsoft.haolifa.dao.repository.OrderProductMapper;
import com.deepsoft.haolifa.dao.repository.extend.OrderExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.MaterialService;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.ProductMaterialService;
import com.deepsoft.haolifa.service.ProductModelConfigService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class OrderProductServiceImpl extends BaseService implements OrderProductService {
    @Autowired
    private OrderProductMapper orderProductMapper;
    @Autowired
    private ProductMaterialService productMaterialService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private OrderExtendMapper orderMaterialExtendMapper;
    @Autowired
    private CheckMaterialLogMapper checkMaterialLogMapper;
    @Autowired
    private OrderProductAssociateMapper orderProductAssociateMapper;
    @Autowired
    private OrderExtendMapper orderExtendMapper;

    @Autowired
    private ProductModelConfigService productModelConfigService;

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
    public ResultBean saveOrderProductInfo(OrderProductDTO orderProductDTO) {
        OrderProduct orderProduct = new OrderProduct();
        String orderProductNo = "op_" + RandomUtils.orderNoStr();
        log.info("save orderProduct info start|orderProductNo:{},model:{}", orderProductNo, JSONObject.toJSONString(orderProduct));
        orderProductDTO.setOrderNo(orderProductNo);
        // 属性copy复制
        BeanUtils.copyProperties(orderProductDTO, orderProduct);
        orderProduct.setCreateUser(getLoginUserId());
        orderProduct.setOrderStatus(CommonEnum.OrderStatus.CREATE.code);
        int insert = orderProductMapper.insertSelective(orderProduct);
        if (insert > 0) {
            // 批量插入订单产品关联表
            orderExtendMapper.insertBatchOrderProduct(orderProductDTO.getOrderProductAssociates());
        }
        log.info("save orderProduct info end|orderProductNo:{},result:{}", orderProductNo, insert);
        return ResultBean.success(insert);
    }

    @Override
    public int updateOrderProductStatus(String orderProductNo, byte status) {
        log.info("update orderProduct status start|orderProductNo:{},status:{}", orderProductNo, status);
        OrderProduct record = new OrderProduct();
        record.setOrderStatus(status);
        OrderProductExample example = new OrderProductExample();
        example.or().andOrderNoEqualTo(orderProductNo);
        int update = orderProductMapper.updateByExampleSelective(record, example);
        log.info("update orderProduct status end|orderProductNo:{},status:{},result:{}", orderProductNo, status, update);
        return 0;
    }

    @Override
    public OrderProductDTO getOrderProductInfo(String orderNo) {
        OrderProductDTO orderProductDTO = new OrderProductDTO();
        OrderProductExample example = new OrderProductExample();
        example.or().andOrderNoEqualTo(orderNo);
        List<OrderProduct> orderProducts = orderProductMapper.selectByExample(example);
        if (orderProducts.size() > 0) {
            OrderProduct orderProduct = orderProducts.get(0);
            BeanUtils.copyProperties(orderProductDTO, orderProduct);
            // 获取订单关联成品列表
            List<OrderProductAssociate> orderProductAssociates = orderProductAssociateMapper.selectByExample(new OrderProductAssociateExample() {{
                or().andOrderNoEqualTo(orderNo);
            }});
            List<OrderProductAssociate> orderProductAssociateDTOS = new ArrayList<>();
            BeanUtils.copyProperties(orderProductAssociateDTOS, orderProductAssociates);
            orderProductDTO.setOrderProductAssociates(orderProductAssociateDTOS);
        }
        return orderProductDTO;
    }

    @Override
    public List<OrderProductAssociate> getOrderProductList(String orderNo) {
        // 获取订单关联成品列表
        List<OrderProductAssociate> orderProductAssociates = orderProductAssociateMapper.selectByExample(new OrderProductAssociateExample() {{
            or().andOrderNoEqualTo(orderNo);
        }});
        return orderProductAssociates;
    }


    @Override
    public ResultBean pageOrderProduct(Integer currentPage, Integer pageSize, String orderNo, int status) {
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 20 : pageSize;

        OrderProductExample example = new OrderProductExample();
        OrderProductExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        if (status > 0) {
            criteria.andOrderStatusEqualTo((byte) status);
        }
        example.setOrderByClause("create_time desc");
        Page<OrderProduct> materials = PageHelper.startPage(currentPage, pageSize)
                .doSelectPage(() -> orderProductMapper.selectByExample(example));

        PageDTO<OrderProduct> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(materials, pageDTO);
        pageDTO.setList(materials);
        return ResultBean.success(pageDTO);
    }


    /**
     * 根据型号和规格获取原料（阀体，阀板，阀座）
     *
     * @param productModel
     * @param specifications
     * @return
     */
    public List<String> getMaterials(String productModel, String specifications) {
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


        // 获取全部规则列表
        List<ProductModelConfig> modelConfigs = productModelConfigService.getList(0, "");
        // 获取阀板规则
        List<ProductModelConfig> fabanModelConfig = modelConfigs.stream().filter(e -> e.getIndexRule() == faban && e.getType() == CommonEnum.ProductModelType.FABAN.code).collect(Collectors.toList());
        // 获取阀座规则
        List<ProductModelConfig> fazuoModelConfig = modelConfigs.stream().filter(e -> e.getIndexRule() == fazuo && e.getType() == CommonEnum.ProductModelType.FAZUO.code).collect(Collectors.toList());
        // 获取阀体规则
        List<ProductModelConfig> fatiModelConfig = modelConfigs.stream().filter(e -> e.getIndexRule() == fati && e.getType() == CommonEnum.ProductModelType.FABTI.code).collect(Collectors.toList());
        // 获取阀体规则
        List<ProductModelConfig> fatiYaliModelConfig = modelConfigs.stream().filter(e -> e.getIndexRule() == fatiyali && e.getType() == CommonEnum.ProductModelType.FATI_YALI.code).collect(Collectors.toList());

        // 根据型号和规格，获取图号列表
        List<Material> listByModelAndSpec = materialService.getListByModelAndSpec(smallModel, specifications);
        // 获取符合阀板的列表

        // 获取符合阀座的列表

        // 获取符合阀体的列表

        // todo 根据条件获取图号
        return null;
    }

    public static void main(String[] args) {
        String productModel = "270DD7A1XH-16Q";
        int lastIndexOf = productModel.lastIndexOf("-");
        String fati = "";
        System.out.println(fati);
    }

    /**
     * 核料，核心逻辑（根据前端表单传来的数据）
     *
     * @param orderMaterialDTOS
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int checkMaterial(List<OrderMaterialDTO> orderMaterialDTOS) {
        // 核料状态
        int checkState = 0;
        String checkResult = "";
        int currentUser = getLoginUserId();
        // 核料
        List<OrderMaterial> orderMaterialList = new ArrayList<>();
        // 替换料列表
        List<OrderMaterial> replaceMaterialList = new ArrayList<>();
        // 缺料，需要购买的零件列表及数量
        List<OrderMaterial> needBuyMaterialList = new ArrayList<>();
        String orderNo = "";
        try {
            String productNo = "";
            // 需要成品的数量
            Integer productNumber = 0;

            // 获取一个成品所需的零件
            for (OrderMaterialDTO orderMaterialDTO : orderMaterialDTOS) {
                orderNo = orderMaterialDTO.getOrderNo();
                String materialGraphNo = orderMaterialDTO.getMaterialGraphNo();
                Integer materialCount = orderMaterialDTO.getMaterialCount();
                String replaceMaterialGraphNo = orderMaterialDTO.getReplaceMaterialGraphNo();
                // 获取零件的库存
                Material infoByGraphNo = materialService.getInfoByGraphNo(materialGraphNo);
                Integer currentQuantity = infoByGraphNo.getCurrentQuantity();
                // 需要的零件数量
                int needCount = productNumber * materialCount;
                if (currentQuantity >= needCount) {
                    String finalOrderNo = orderNo;
                    orderMaterialList.add(new OrderMaterial() {{
                        setCreateUser(currentUser);
                        setOrderNo(finalOrderNo);
                        setMaterialGraphNo(materialGraphNo);
                        setMaterialCount(materialCount);
                    }});
                } else {
                    // 缺料列表
                    needBuyMaterialList.add(new OrderMaterial() {{
                        setMaterialCount(materialCount);
                        setMaterialGraphNo(replaceMaterialGraphNo);
                    }});
                    // 缺料查找是否有替换料
                    if (StringUtils.isBlank(replaceMaterialGraphNo)) {
                        // 无料可以替换，需要走采购流程
                        checkState = 1;
                        checkResult += "【" + materialGraphNo + "库存不足，且无替换料】";
                    } else {
                        Material replaceGraphNoInfo = materialService.getInfoByGraphNo(replaceMaterialGraphNo);
                        if (replaceGraphNoInfo.getCurrentQuantity() >= needCount) {
                            checkResult += "【" + materialGraphNo + "库存不足，有替换料】";
                            // 如果已经确定缺料了，核料状态就不能改变了
                            if (checkState != 1) {
                                checkState = 2;
                            }
                            replaceMaterialList.add(new OrderMaterial() {{
                                setMaterialCount(materialCount);
                                setMaterialGraphNo(replaceMaterialGraphNo);
                            }});
                        } else {
                            // 如果替换料库存也不足，那就只能走采购
                            checkState = 1;
                        }
                    }
                }
            }
            if (checkState == 0) {
                if (orderMaterialList != null && orderMaterialList.size() > 0) {
                    // 核料成功，插入核料表
                    orderMaterialExtendMapper.insertBatchOrderMaterial(orderMaterialList);
                    for (OrderMaterial orderMaterial : orderMaterialList) {
                        // 更新零件当前库存和锁定库存
                        String materialGraphNo = orderMaterial.getMaterialGraphNo();
                        int materialCount = orderMaterial.getMaterialCount();
                        materialService.updateCurrentQuantity(materialGraphNo, (-1) * materialCount);
                        materialService.updateLockQuantity(materialGraphNo, materialCount);
                    }
                }
            }
        } catch (Exception e) {
            log.error("核料过程中出现的异常，orderNo:{}", orderNo, e);
        } finally {
            // 添加核料日志
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
        return checkState;
    }
}
