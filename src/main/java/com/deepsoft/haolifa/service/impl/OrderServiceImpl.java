package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.OrderMapper;
import com.deepsoft.haolifa.model.domain.Order;
import com.deepsoft.haolifa.model.domain.OrderExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.OrderService;
import com.deepsoft.haolifa.util.Base64Utils;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;


@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ResultBean uploadOrderExcel(String base64Source) {
        Order order = new Order();
        if (StringUtils.isBlank(base64Source)) {
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        byte[] bytes = Base64Utils.base64ToByte(base64Source);
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
             HSSFWorkbook sheets = new HSSFWorkbook(inputStream);) {
            HSSFSheet sheet = sheets.getSheetAt(0);
            log.info("upload order excel row num:{}", sheet.getLastRowNum());
            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                String cellValue = "";
                HSSFRow row = sheet.getRow(i);
                if (null != row) {
                    HSSFCell cell = row.getCell(1);
                    if (null != cell) {
                        CellType cellTypeEnum = cell.getCellTypeEnum();
                        switch (cellTypeEnum) {
                            case STRING:
                                String stringCellValue = cell.getStringCellValue();
                                boolean number = NumberUtils.isNumber(stringCellValue);
                                cellValue = number ? new Double(stringCellValue).toString() : stringCellValue;
                                boolean digits = NumberUtils.isDigits(stringCellValue);
                                cellValue = digits ? stringCellValue : cellValue;
                                break;
                            case NUMERIC:
                                cellValue = new BigDecimal(cell.getNumericCellValue()).toString();
                                if (cellValue.contains(".")) {
                                    cellValue = Double.toString(cell.getNumericCellValue());
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
                switch (i) {
                    case 1:
                        order.setDemandName(cellValue);
                        break;
                    case 2:
                        order.setDemandAgentName(cellValue);
                        break;
                    case 3:
                        order.setDemandTelphone(cellValue);
                        break;
                    case 4:
                        order.setDemandFax(cellValue);
                        break;
                    case 5:
                        order.setDemandAddress(cellValue);
                        break;
                    case 6:
                        order.setSupplyName(cellValue);
                        break;
                    case 7:
                        order.setSupplyAgentName(cellValue);
                        break;
                    case 8:
                        order.setSupplyTelphone(cellValue);
                        break;
                    case 9:
                        order.setSupplyFax(cellValue);
                        break;
                    case 10:
                        order.setSupplyAddress(cellValue);
                        break;
                    case 11:
                        order.setContractNumber(cellValue);
                        break;
                    case 12:
                        order.setContractSignDate(cellValue);
                        break;
                    case 13:
                        order.setProductNo(cellValue);
                        break;
                    case 14:
                        order.setProductName(cellValue);
                        break;
                    case 15:
                        order.setLable(cellValue);
                        break;
                    case 16:
                        order.setSpecifications(cellValue);
                        break;
                    case 17:
                        order.setProductColor(cellValue);
                        break;
                    case 18:
                        order.setProductNumber(Integer.valueOf(cellValue));
                        break;
                    case 19:
                        order.setPrice(new BigDecimal(cellValue));
                        break;
                    case 20:
                        order.setTotalPrice(new BigDecimal(cellValue));
                        break;
                    case 21:
                        order.setDiscountTotalPrice(new BigDecimal(cellValue));
                        break;
                    case 22:
                        order.setMaterialDescription(cellValue);
                        break;
                    case 23:
                        order.setProductRemark(cellValue);
                        break;
                    case 24:
                        order.setPurchaseFeedbackTime(cellValue);
                        break;
                    case 25:
                        order.setProductionFeedbackTime(cellValue);
                        break;
                    case 26:
                        order.setSpecialRequire(cellValue);
                        break;
                    case 27:
                        order.setCargoInformation(cellValue);
                        break;
                    case 28:
                        order.setSignBoard(cellValue);
                        break;
                    case 29:
                        order.setAcceptanceCriteria(cellValue);
                        break;
                    case 30:
                        order.setWarrantyPeriod(cellValue);
                        break;
                    case 31:
                        order.setPackagingspecification(cellValue);
                        break;
                    case 32:
                        order.setTransportType(cellValue);
                        break;
                    case 33:
                        order.setDeliveryTime(cellValue);
                        break;
                    case 34:
                        order.setReceiptInfo(cellValue);
                        break;
                    case 35:
                        order.setPaymentMethod(cellValue);
                        break;
                    case 36:
                        order.setFreight(cellValue);
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("upload order excel end|order:{}", order.toString());
        return ResultBean.success(order);
    }


    @Override
    public ResultBean saveOrderInfo(Order order) {
        String orderNo = RandomUtils.orderNoStr();
        log.info("save order info start|orderNo:{},model:{}", orderNo, order.toString());
        order.setOrderNo(orderNo);
        // todo 换成当前登录人Id
        order.setCreateUser(1);
        order.setOrderStatus(CommonEnum.OrderStatus.CREATE.code);
        int insert = orderMapper.insertSelective(order);
        log.info("save order info end|orderNo:{},result:{}", orderNo, insert);
        return ResultBean.success(insert);
    }

    @Override
    public int updateOrderStatus(String orderNo, byte status) {
        log.info("update order status start|orderNo:{},status:{}", orderNo, status);
        Order record = new Order();
        record.setOrderStatus(status);
        OrderExample example = new OrderExample();
        example.or().andOrderNoEqualTo(orderNo);
        int update = orderMapper.updateByExampleSelective(record, example);
        log.info("update order status end|orderNo:{},status:{},result:{}", orderNo, status, update);
        return 0;
    }

    @Override
    public Order getOrderInfo(String orderNo) {
        return null;
    }

    @Override
    public Page<Order> pageOrder(Page page) {
        return null;
    }
}
