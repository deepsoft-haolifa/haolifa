package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.deepsoft.haolifa.cache.CacheKeyManager;
import com.deepsoft.haolifa.cache.NoCacheLoadCallBack;
import com.deepsoft.haolifa.cache.redis.RedisDao;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.dao.repository.extend.OrderExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.material.MaterialQuantityDTO;
import com.deepsoft.haolifa.model.dto.material.MaterialResultDTO;
import com.deepsoft.haolifa.model.dto.order.*;
import com.deepsoft.haolifa.service.*;
import com.deepsoft.haolifa.util.Base64;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.QiniuUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.sql.ResultSetMetaData;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.math.BigDecimal;
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
    private OrderMaterialMapper orderMaterialMapper;
    @Autowired
    private OrderFileMapper orderFileMapper;
    @Autowired
    private OrderProductAssociateMapper orderProductAssociateMapper;
    @Autowired
    private OrderExtendMapper orderExtendMapper;
    @Autowired
    private ProductModelConfigService productModelConfigService;
    @Autowired
    private ApplyBuyService applyBuyService;
    @Autowired
    private EntrustService entrustService;
    @Autowired
    private GraphNoRelService graphNoRelService;
    @Autowired
    private CustomerModelRelationService customerModelRelationService;
    @Lazy
    @Autowired
    FlowInstanceService flowInstanceService;

    @Override
    public ResultBean generateOrder(GenerateOrderDTO generateOrderDTO) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        // region 设置第二行的样式
        Font fontTitle = workbook.createFont();
        fontTitle.setFontHeightInPoints((short) 18); //字体大小
        fontTitle.setBold(true); //粗体显示
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(fontTitle);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);// 居中显示
        // endregion

        CellStyle cellStyleCommon = workbook.createCellStyle();
        cellStyleCommon.setWrapText(true);// 设置自动换行
        cellStyleCommon.setAlignment(HorizontalAlignment.CENTER);// 居中显示

        CellStyle cellStyleCommon1 = workbook.createCellStyle();
        cellStyleCommon1.setAlignment(HorizontalAlignment.CENTER);// 居中显示

        CellStyle cellStyleCommon2 = workbook.createCellStyle();
        cellStyleCommon2.setWrapText(true);// 设置自动换行
        //参数说明：1：开始行 2：结束行  3：开始列 4：结束列
        //比如我要合并 第二行到第四行的    第六列到第八列     sheet.addMergedRegion(new CellRangeAddress(1,3,5,7));

        // 第一行
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 10));
        XSSFRow row0 = sheet.createRow(0);
        XSSFCell cell0 = row0.createCell(0);
        cell0.setCellValue("如无问题，请尽快回传及付款，以免影响交货期！回传电话：010-67171220。");
        // 第二行
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 10));
        XSSFRow row1 = sheet.createRow(1);
        XSSFCell cell1 = row1.createCell(0);
        cell1.setCellStyle(cellStyle);
        cell1.setCellValue("产品购销合同");
        // 第三行
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 4));
        XSSFRow row2 = sheet.createRow(2);
        XSSFCell cell2 = row2.createCell(1);
        cell2.setCellValue("需 方：" + generateOrderDTO.getDemandName());
        // 第四行
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 1, 4));
        XSSFRow row3 = sheet.createRow(3);
        XSSFCell cell3 = row3.createCell(1);
        cell3.setCellValue("供 方：" + generateOrderDTO.getSupplyName());
        // 第五行
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 1, 4));
        XSSFRow row4 = sheet.createRow(4);
        XSSFCell cell4 = row4.createCell(1);
        cell4.setCellValue("平台编码：" + generateOrderDTO.getOrderContractNo());

        // 第六行
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 1, 4));
        XSSFRow row5 = sheet.createRow(5);
        XSSFCell cell5 = row5.createCell(1);
        cell5.setCellValue("签订日期：" + generateOrderDTO.getContractSignDate());

        // 第七行
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 10));
        XSSFRow row6 = sheet.createRow(6);
        XSSFCell cell6 = row6.createCell(0);
        cell6.setCellStyle(cellStyleCommon);
        cell6.setCellValue("为保障买卖双方的合法权益，根据《合同法》及有关法律规定，买卖双方经友好协商，一致同意按下列条款签订本合同。");

        // 第八行
        XSSFRow row7 = sheet.createRow(7);
        XSSFCell cell7 = row7.createCell(0);
        cell7.setCellValue("一、");
        XSSFCell cell71 = row7.createCell(1);
        cell71.setCellValue("供货内容：");

        //region 产品列表

        // 第九行
        XSSFRow row8 = sheet.createRow(8);
        XSSFCell cell8 = row8.createCell(0);
        cell8.setCellValue("序号");
        XSSFCell cell81 = row8.createCell(1);
        cell81.setCellValue("产品ID");
        XSSFCell cell82 = row8.createCell(2);
        cell82.setCellValue("名称");
        XSSFCell cell83 = row8.createCell(3);
        cell83.setCellValue("标签属性");
        XSSFCell cell84 = row8.createCell(4);
        cell84.setCellValue("规格");
        XSSFCell cell85 = row8.createCell(5);
        cell85.setCellValue("颜色");
        XSSFCell cell86 = row8.createCell(6);
        cell86.setCellValue("数量");
        XSSFCell cell87 = row8.createCell(7);
        cell87.setCellValue("单价");
        XSSFCell cell88 = row8.createCell(8);
        cell88.setCellValue("合计");
        XSSFCell cell89 = row8.createCell(9);
        cell89.setCellValue("材质");
        XSSFCell cell810 = row8.createCell(10);
        cell810.setCellValue("备注");

        List<OrderProductAssociate> orderProductAssociates = generateOrderDTO.getOrderProductAssociates();
        // 产品从第10行开始
        int productStartRow = 9;
        int index = 1;
        for (OrderProductAssociate orderProductAssociate : orderProductAssociates) {
            XSSFRow row = sheet.createRow(productStartRow);
            XSSFCell cellP0 = row.createCell(0);
            cellP0.setCellStyle(cellStyleCommon1);
            cellP0.setCellValue(index);
            XSSFCell cellP1 = row.createCell(1);
            cellP1.setCellStyle(cellStyleCommon);
            cellP1.setCellValue(orderProductAssociate.getProductNo());
            XSSFCell cellP2 = row.createCell(2);
            cellP2.setCellStyle(cellStyleCommon);
            cellP2.setCellValue(orderProductAssociate.getProductName());
            XSSFCell cellP3 = row.createCell(3);
            cellP3.setCellStyle(cellStyleCommon);
            cellP3.setCellValue(orderProductAssociate.getLable());
            XSSFCell cellP4 = row.createCell(4);
            cellP4.setCellStyle(cellStyleCommon);
            cellP4.setCellValue(orderProductAssociate.getSpecifications());
            XSSFCell cellP5 = row.createCell(5);
            cellP5.setCellStyle(cellStyleCommon);
            cellP5.setCellValue(orderProductAssociate.getProductColor());
            XSSFCell cellP6 = row.createCell(6);
            cellP6.setCellStyle(cellStyleCommon);
            if (null != orderProductAssociate.getProductNumber()) {
                cellP6.setCellValue(orderProductAssociate.getProductNumber());
            }
            XSSFCell cellP7 = row.createCell(7);
            cellP7.setCellStyle(cellStyleCommon);
            if (null != orderProductAssociate.getPrice()) {
                cellP7.setCellValue(orderProductAssociate.getPrice().toString());
            }
            XSSFCell cellP8 = row.createCell(8);
            cellP8.setCellStyle(cellStyleCommon);
            if (null != orderProductAssociate.getTotalPrice()) {
                cellP8.setCellValue(orderProductAssociate.getTotalPrice().toString());
            }
            XSSFCell cellP9 = row.createCell(9);
            cellP9.setCellStyle(cellStyleCommon);
            cellP9.setCellValue(orderProductAssociate.getMaterialDescription());
            XSSFCell cellP10 = row.createCell(10);
            cellP10.setCellStyle(cellStyleCommon);
            cellP10.setCellValue(orderProductAssociate.getProductRemark());

            index++;
            productStartRow++;

        }
        // endregion

        // 合计
        XSSFRow rowHJ = sheet.createRow(productStartRow);
        sheet.addMergedRegion(new CellRangeAddress(productStartRow, productStartRow, 1, 3));
        XSSFCell cellHJ = rowHJ.createCell(1);
        cellHJ.setCellValue("合计");
        XSSFCell cellHJPrice = rowHJ.createCell(6);
        cellHJPrice.setCellStyle(cellStyleCommon);
        if (null != generateOrderDTO.getTotalPrice()) {
            cellHJPrice.setCellValue(generateOrderDTO.getTotalPrice().toString());
        }
        // 优惠后价格
        int otherRow1 = productStartRow + 1;
        sheet.addMergedRegion(new CellRangeAddress(otherRow1, otherRow1, 1, 3));
        XSSFRow rowYHJG = sheet.createRow(otherRow1);
        XSSFCell cellHJJG = rowYHJG.createCell(1);
        cellHJJG.setCellValue("优惠后价格");
        XSSFCell cellHJJGPrice = rowYHJG.createCell(6);
        cellHJJGPrice.setCellStyle(cellStyleCommon);
        if (null != generateOrderDTO.getDiscountTotalPrice()) {
            cellHJJGPrice.setCellValue(generateOrderDTO.getDiscountTotalPrice().toString());
        }
        // 以上含税价格
        int otherRow2 = productStartRow + 2;
        sheet.addMergedRegion(new CellRangeAddress(otherRow2, otherRow2, 1, 3));
        XSSFRow rowYSJG = sheet.createRow(otherRow2);
        XSSFCell cellYSJG = rowYSJG.createCell(1);
        cellYSJG.setCellValue("以上价格均为含税价格");

        // 特殊要求
        int otherRowIndex3 = productStartRow + 3;
        XSSFRow otherRow3 = sheet.createRow(otherRowIndex3);
        XSSFCell cellTSYQ0 = otherRow3.createCell(0);
        cellTSYQ0.setCellStyle(cellStyleCommon);
        cellTSYQ0.setCellValue("二、");
        XSSFCell cellTSYQ1 = otherRow3.createCell(1);
        cellTSYQ1.setCellStyle(cellStyleCommon);
        cellTSYQ1.setCellValue("特殊要求：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex3, otherRowIndex3, 2, 10));
        XSSFCell cellTSYQ2 = otherRow3.createCell(2);
        cellTSYQ2.setCellStyle(cellStyleCommon);
        cellTSYQ2.setCellValue(generateOrderDTO.getSpecialRequire());
        // 随货资料，标牌
        int otherRowIndex4 = productStartRow + 4;
        XSSFRow otherRow4 = sheet.createRow(otherRowIndex4);
        XSSFCell cellSHZL0 = otherRow4.createCell(0);
        cellSHZL0.setCellStyle(cellStyleCommon);
        cellSHZL0.setCellValue("三、");
        XSSFCell cellSHZL1 = otherRow4.createCell(1);
        cellSHZL1.setCellStyle(cellStyleCommon);
        cellSHZL1.setCellValue("随货资料：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex4, otherRowIndex4, 2, 5));
        XSSFCell cellSHZL2 = otherRow4.createCell(2);
        cellSHZL2.setCellStyle(cellStyleCommon);
        cellSHZL2.setCellValue(generateOrderDTO.getCargoInformation());
        XSSFCell cellSHZL3 = otherRow4.createCell(6);
        cellSHZL3.setCellStyle(cellStyleCommon);
        cellSHZL3.setCellValue("标 牌：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex4, otherRowIndex4, 7, 10));
        XSSFCell cellSHZL4 = otherRow4.createCell(7);
        cellSHZL4.setCellStyle(cellStyleCommon);
        cellSHZL4.setCellValue(generateOrderDTO.getSignBoard());
        // 验收标准
        int otherRowIndex5 = productStartRow + 5;
        XSSFRow otherRow5 = sheet.createRow(otherRowIndex5);
        XSSFCell cellYSBZ0 = otherRow5.createCell(0);
        cellYSBZ0.setCellStyle(cellStyleCommon);
        cellYSBZ0.setCellValue("四、");
        XSSFCell cellYSBZ1 = otherRow5.createCell(1);
        cellYSBZ1.setCellStyle(cellStyleCommon);
        cellYSBZ1.setCellValue("验收标准：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex5, otherRowIndex5, 2, 10));
        XSSFCell cellYSBZ2 = otherRow5.createCell(2);
        cellYSBZ2.setCellStyle(cellStyleCommon);
        cellYSBZ2.setCellValue(generateOrderDTO.getAcceptanceCriteria());
        // 质量保证
        int otherRowIndex6 = productStartRow + 6;
        XSSFRow otherRow6 = sheet.createRow(otherRowIndex6);
        XSSFCell cellZLBZ0 = otherRow6.createCell(0);
        cellZLBZ0.setCellStyle(cellStyleCommon);
        cellZLBZ0.setCellValue("五、");
        XSSFCell cellZLBZ1 = otherRow6.createCell(1);
        cellZLBZ1.setCellStyle(cellStyleCommon);
        cellZLBZ1.setCellValue("质量保证：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex6, otherRowIndex6, 2, 10));
        XSSFCell cellZLBZ2 = otherRow6.createCell(2);
        cellZLBZ2.setCellStyle(cellStyleCommon);
        cellZLBZ2.setCellValue(generateOrderDTO.getWarrantyPeriod());
        // 包装规范，运输方式
        int otherRowIndex7 = productStartRow + 7;
        XSSFRow otherRow7 = sheet.createRow(otherRowIndex7);
        XSSFCell cellBZGF0 = otherRow7.createCell(0);
        cellBZGF0.setCellStyle(cellStyleCommon);
        cellBZGF0.setCellValue("六、");
        XSSFCell cellBZGF1 = otherRow7.createCell(1);
        cellBZGF1.setCellStyle(cellStyleCommon);
        cellBZGF1.setCellValue("包装规范：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex7, otherRowIndex7, 2, 5));
        XSSFCell cellBZGF2 = otherRow7.createCell(2);
        cellBZGF2.setCellValue(generateOrderDTO.getPackagingSpecification());
        XSSFCell cellBZGF3 = otherRow7.createCell(6);
        cellBZGF3.setCellStyle(cellStyleCommon);
        cellBZGF3.setCellValue("运输方式：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex7, otherRowIndex7, 7, 10));
        XSSFCell cellBZGF4 = otherRow7.createCell(7);
        cellBZGF4.setCellValue(generateOrderDTO.getTransportMode());
        // 发货日期，收货信息
        int otherRowIndex8 = productStartRow + 8;
        XSSFRow otherRow8 = sheet.createRow(otherRowIndex8);
        XSSFCell cellFHRQ0 = otherRow8.createCell(0);
        cellFHRQ0.setCellStyle(cellStyleCommon);
        cellFHRQ0.setCellValue("七、");
        XSSFCell cellFHRQ1 = otherRow8.createCell(1);
        cellFHRQ1.setCellStyle(cellStyleCommon);
        cellFHRQ1.setCellValue("发货日期：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex8, otherRowIndex8, 2, 5));
        XSSFCell cellFHRQ2 = otherRow8.createCell(2);
        cellFHRQ2.setCellValue(generateOrderDTO.getDeliveryDate());
        XSSFCell cellFHRQ3 = otherRow8.createCell(6);
        cellFHRQ3.setCellStyle(cellStyleCommon);
        cellFHRQ3.setCellValue("收货信息：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex8, otherRowIndex8, 7, 10));
        XSSFCell cellFHRQ4 = otherRow8.createCell(7);
        cellFHRQ4.setCellValue(generateOrderDTO.getReceivingInformation());
        // 付款方式，运费承担
        int otherRowIndex9 = productStartRow + 9;
        XSSFRow otherRow9 = sheet.createRow(otherRowIndex9);
        XSSFCell cellFKFS0 = otherRow9.createCell(0);
        cellFKFS0.setCellStyle(cellStyleCommon);
        cellFKFS0.setCellValue("八、");
        XSSFCell cellFKFS1 = otherRow9.createCell(1);
        cellFKFS1.setCellStyle(cellStyleCommon);
        cellFKFS1.setCellValue("付款方式：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex9, otherRowIndex9, 2, 5));
        XSSFCell cellFKFS2 = otherRow9.createCell(2);
        cellFKFS2.setCellValue(generateOrderDTO.getPaymentMethod());
        XSSFCell cellFKFS3 = otherRow9.createCell(6);
        cellFKFS3.setCellStyle(cellStyleCommon);
        cellFKFS3.setCellValue("运费承担：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex9, otherRowIndex9, 7, 10));
        XSSFCell cellFKFS4 = otherRow9.createCell(7);
        cellFKFS4.setCellValue(generateOrderDTO.getFreightCharges());

        // 违约责任
        int otherRowIndex10 = productStartRow + 10;
        XSSFRow otherRow10 = sheet.createRow(otherRowIndex10);
        XSSFCell cellWYZR0 = otherRow10.createCell(0);
        cellWYZR0.setCellStyle(cellStyleCommon);
        cellWYZR0.setCellValue("九、");
        XSSFCell cellWYZR1 = otherRow10.createCell(1);
        cellWYZR1.setCellStyle(cellStyleCommon);
        cellWYZR1.setCellValue("违约责任：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex10, otherRowIndex10, 2, 10));
        XSSFCell cellWYZR2 = otherRow10.createCell(2);
        if (StringUtils.isNotBlank(generateOrderDTO.getLiabilityForBreach())) {
            cellWYZR2.setCellValue(generateOrderDTO.getLiabilityForBreach());
        } else {
            cellWYZR2.setCellValue("合同签订后，买卖双方严格执行双方所签订合同的条款，其中一方不履行或不完全履行合同者应承担相应的法律责任。");
        }
        // 十
        int otherRowIndex11 = productStartRow + 11;
        XSSFRow otherRow11 = sheet.createRow(otherRowIndex11);
        XSSFCell cell111 = otherRow11.createCell(0);
        cell111.setCellStyle(cellStyleCommon);
        cell111.setCellValue("十、");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex11, otherRowIndex11, 1, 10));
        XSSFCell cell112 = otherRow11.createCell(1);
        cell112.setCellValue("解决合同纠纷方式：双方协商解决，解决不成由买方所在工商局经济合同仲裁委员会仲裁或法院起诉。");
        // 十一
        int otherRowIndex12 = productStartRow + 12;
        XSSFRow otherRow12 = sheet.createRow(otherRowIndex12);
        XSSFCell cell121 = otherRow12.createCell(0);
        cell121.setCellStyle(cellStyleCommon);
        cell121.setCellValue("十一、");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex12, otherRowIndex12, 1, 10));
        XSSFCell cell122 = otherRow12.createCell(1);
        cell122.setCellValue("本合同一式贰份，双方各执一份，双方盖章后生效（传真件有效）。");

        // 最后
        int otherRowIndex13 = productStartRow + 13;
        XSSFRow otherRow13 = sheet.createRow(otherRowIndex13);
        XSSFCell cell131 = otherRow13.createCell(1);
        cell131.setCellStyle(cellStyleCommon2);
        cell131.setCellValue("需    方：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex13, otherRowIndex13, 2, 5));
        XSSFCell cell132 = otherRow13.createCell(2);
        cell132.setCellValue(generateOrderDTO.getDemandName());
        XSSFCell cell136 = otherRow13.createCell(6);
        cell136.setCellStyle(cellStyleCommon2);
        cell136.setCellValue("供    方：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex13, otherRowIndex13, 7, 10));
        XSSFCell cell137 = otherRow13.createCell(7);
        cell137.setCellValue(generateOrderDTO.getSupplyName());

        int otherRowIndex14 = productStartRow + 14;
        XSSFRow otherRow14 = sheet.createRow(otherRowIndex14);
        XSSFCell cell141 = otherRow14.createCell(1);
        cell141.setCellStyle(cellStyleCommon2);
        cell141.setCellValue("委托代理人：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex14, otherRowIndex14, 2, 5));
        XSSFCell cell142 = otherRow14.createCell(2);
        cell142.setCellValue(generateOrderDTO.getDemandAgentName());
        XSSFCell cell146 = otherRow14.createCell(6);
        cell146.setCellStyle(cellStyleCommon2);
        cell146.setCellValue("委托代理人：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex14, otherRowIndex14, 7, 10));
        XSSFCell cell147 = otherRow14.createCell(7);
        cell147.setCellValue(generateOrderDTO.getSupplyAgentName());

        int otherRowIndex15 = productStartRow + 15;
        XSSFRow otherRow15 = sheet.createRow(otherRowIndex15);
        XSSFCell cell151 = otherRow15.createCell(1);
        cell151.setCellStyle(cellStyleCommon2);
        cell151.setCellValue("电    话：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex15, otherRowIndex15, 2, 5));
        XSSFCell cell152 = otherRow15.createCell(2);
        cell152.setCellValue(generateOrderDTO.getDemandPhone());
        XSSFCell cell156 = otherRow15.createCell(6);
        cell156.setCellStyle(cellStyleCommon2);
        cell156.setCellValue("电    话：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex15, otherRowIndex15, 7, 10));
        XSSFCell cell157 = otherRow15.createCell(7);
        cell157.setCellValue(generateOrderDTO.getSupplyPhone());

        int otherRowIndex16 = productStartRow + 16;
        XSSFRow otherRow16 = sheet.createRow(otherRowIndex16);
        XSSFCell cell161 = otherRow16.createCell(1);
        cell161.setCellStyle(cellStyleCommon2);
        cell161.setCellValue("传    真：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex16, otherRowIndex16, 2, 5));
        XSSFCell cell162 = otherRow16.createCell(2);
        cell162.setCellValue(generateOrderDTO.getDemandFax());
        XSSFCell cell166 = otherRow16.createCell(6);
        cell166.setCellStyle(cellStyleCommon2);
        cell166.setCellValue("传    真：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex16, otherRowIndex16, 7, 10));
        XSSFCell cell167 = otherRow16.createCell(7);
        cell167.setCellValue(generateOrderDTO.getSupplyFax());

        int otherRowIndex17 = productStartRow + 17;
        XSSFRow otherRow17 = sheet.createRow(otherRowIndex17);
        XSSFCell cell171 = otherRow17.createCell(1);
        cell171.setCellStyle(cellStyleCommon2);
        cell171.setCellValue("地    址：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex17, otherRowIndex17, 2, 5));
        XSSFCell cell172 = otherRow17.createCell(2);
        cell172.setCellValue(generateOrderDTO.getDemandAddress());
        XSSFCell cell176 = otherRow17.createCell(6);
        cell176.setCellStyle(cellStyleCommon2);
        cell176.setCellValue("地    址：");
        sheet.addMergedRegion(new CellRangeAddress(otherRowIndex17, otherRowIndex17, 7, 10));
        XSSFCell cell177 = otherRow17.createCell(7);
        cell177.setCellValue(generateOrderDTO.getSupplyAddress());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String extendFileUrl = QiniuUtil.uploadFile(outputStream.toByteArray(),
                System.currentTimeMillis() + "-" + generateOrderDTO.getOrderContractNo() + ".xlsx");
        log.info("generate file url:{}", extendFileUrl);
        return ResultBean.success(extendFileUrl);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultBean uploadOrderProduct(OrderUploadDTO orderUploadDTO) {
        String base64Source = orderUploadDTO.getBase64Source();
        String fileName = orderUploadDTO.getFileName();
        String deliveryDate = orderUploadDTO.getDeliveryDate();
        OrderProduct orderProduct = new OrderProduct();
        if (StringUtils.isBlank(base64Source)) {
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        String indexStr = "base64,";
        int in = base64Source.lastIndexOf(indexStr) + indexStr.length();
        String replaceStr = base64Source.substring(0, in);
        base64Source = base64Source.replaceAll(replaceStr, "");
        byte[] bytes = Base64.decodeBytes(base64Source);
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        Workbook workbook = null;
        try {
            workbook = new HSSFWorkbook(is);
        } catch (Exception ex) {
            // 解决read error异常
            try {
                is = new ByteArrayInputStream(bytes);
                workbook = new XSSFWorkbook(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Sheet sheet = workbook.getSheetAt(0);
            log.info("upload orderProduct excel row num:{}", sheet.getLastRowNum());
            // 获取合同订单号,在第五行,第二列
            String orderContractNo = "";
            Row noRow = sheet.getRow(4);
            if (null != noRow) {
                Cell cell = noRow.getCell(1);
                String cellValue = getCellValue(cell);
                if (StringUtils.isNotBlank(cellValue)) {
                    String[] split = cellValue.split("：");
                    if (split.length > 1) {
                        orderContractNo = split[1];
                    }
                }
            }

            if (StringUtils.isBlank(orderContractNo)) {
                throw new BaseException(ResponseEnum.PARAM_ERROR.code, "上传的表格中，平台编号不能为空");
            }
            // 判断订单号在系统中是否存在
            OrderProductExample orderProductExample = new OrderProductExample();
            OrderProductExample.Criteria criteria = orderProductExample.createCriteria();
            criteria.andOrderContractNoEqualTo(orderContractNo);
            long countByExample = orderProductMapper.countByExample(orderProductExample);
            if (countByExample > 0) {
                throw new BaseException(CommonEnum.ResponseEnum.ORDER_NO_EXISTS);
            }

            // 获取需方,在第3行,第二列
            String demandName = "";
            Row demandNameRow = sheet.getRow(2);
            if (null != demandNameRow) {
                Cell cell = demandNameRow.getCell(1);
                String cellValue = getCellValue(cell);
                if (StringUtils.isNotBlank(cellValue)) {
                    String[] split = cellValue.split("：");
                    if (split.length > 1) {
                        demandName = split[1];
                    }
                }
            }
            // 获取供应方,在第4行,第二列
            String supplyName = "";
            Row supplyNameRow = sheet.getRow(3);
            if (null != supplyNameRow) {
                Cell cell = supplyNameRow.getCell(1);
                String cellValue = getCellValue(cell);
                if (StringUtils.isNotBlank(cellValue)) {
                    String[] split = cellValue.split("：");
                    if (split.length > 1) {
                        supplyName = split[1];
                    }
                }
            }
            // 获取订单产品列表
            List<OrderProductAssociate> orderProductAssociates = new ArrayList<>();
            // 从第十行开始，获取“特殊要求”那一行之前三行,(从第十行到lastRowNum,就是所有产品的行数)
            int lastRowNum = 10;
            for (int i = 10; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                if (null != row) {
                    Cell cell = row.getCell(1);
                    String cellValue = getCellValue(cell);
                    if (StringUtils.isNotBlank(cellValue)) {
                        if (cellValue.contains("特殊要求")) {
                            lastRowNum = i - 3;
                            break;
                        }
                    }
                }
            }
            for (int i = 9; i < lastRowNum; i++) {
                OrderProductAssociate orderProductAssociate = new OrderProductAssociate();
                Row row = sheet.getRow(i);
                if (null != row) {
                    // 第一列，产品Id[DSb7A1X3N-10Q-DN50]
                    Cell cell1 = row.getCell(1);
                    orderProductAssociate.setProductNo(getCellValue(cell1));
                    if (Objects.isNull(getCellValue(cell1))) {
                        throw new BaseException(ResponseEnum.PARAM_ERROR.code, "上传的表格中，产品ID不能为空");
                    }
                    // 第二列，产品名称[手柄对夹密封型中线垂直板蝶阀]
                    Cell cell2 = row.getCell(2);
                    orderProductAssociate.setProductName(getCellValue(cell2));
                    // 第三列，标签属性[等级:A;系列:D270A]
                    Cell cell3 = row.getCell(3);
                    String cellValue3 = getCellValue(cell3);
                    orderProductAssociate.setLable(cellValue3);
                    // 截取出产品型号
                    if (cellValue3.contains("系列:")) {
                        String productModel = cellValue3.substring(cellValue3.lastIndexOf("系列:") + 3, cellValue3.length());
                        orderProductAssociate.setProductModel(productModel);
                    }
                    // 第四列，规格[DN50]
                    Cell cell4 = row.getCell(4);
                    orderProductAssociate.setSpecifications(getCellValue(cell4));
                    if (Objects.isNull(getCellValue(cell4))) {
                        throw new BaseException(ResponseEnum.PARAM_ERROR.code, "上传的表格中，规格不能为空");
                    }
                    // 第五列，颜色[蓝色(RAL5010)]
                    Cell cell5 = row.getCell(5);
                    orderProductAssociate.setProductColor(getCellValue(cell5));
                    // 第六列，数量
                    Cell cell6 = row.getCell(6);
                    String cellValue6 = getCellValue(cell6);
                    orderProductAssociate.setProductNumber(Integer.valueOf(cellValue6));
                    if (Objects.isNull(getCellValue(cell6))) {
                        throw new BaseException(ResponseEnum.PARAM_ERROR.code, "上传的表格中，数量不能为空");
                    }
                    // 第7列，单价
                    Cell cell7 = row.getCell(7);
                    String cellValue7 = getCellValue(cell7);
                    if (StringUtils.isNotBlank(cellValue7)) {
                        if (cellValue7.contains("￥")) {
                            cellValue7 = cellValue7.replaceAll("￥", "");
                        }
                        orderProductAssociate.setPrice(new BigDecimal(cellValue7));
                    } else {
                        throw new BaseException(ResponseEnum.PARAM_ERROR.code, "上传的表格中，单价不能为空");
                    }
                    // 第8列，合计
                    Cell cell8 = row.getCell(8);
                    String cellValue8 = getCellValue(cell8);
                    if (StringUtils.isNotBlank(cellValue8)) {
                        if (cellValue8.contains("￥")) {
                            cellValue8 = cellValue8.replaceAll("￥", "");
                        }
                        orderProductAssociate.setTotalPrice(new BigDecimal(cellValue8));
                    }
                    // 第9列，材质
                    Cell cell9 = row.getCell(9);
                    orderProductAssociate.setMaterialDescription(getCellValue(cell9));
                    // 第10列，备注
                    Cell cell10 = row.getCell(10);
                    orderProductAssociate.setProductRemark(getCellValue(cell10));

                    // 将价格隐藏
                    cell7.setCellValue("");
                    cell8.setCellValue("");
                    orderProductAssociates.add(orderProductAssociate);
                }
            }
            // 如果没有填写发货日期，从excel表格中获取发货日期
            if (StringUtils.isBlank(deliveryDate)) {
                for (int i = lastRowNum; i < sheet.getLastRowNum() + 1; i++) {
                    Row row = sheet.getRow(i);
                    if (null != row) {
                        Cell cell = row.getCell(1);
                        String cellValue = getCellValue(cell);
                        if (StringUtils.isNotBlank(cellValue)) {
                            if (cellValue.contains("发货日期")) {
                                Cell cell2 = row.getCell(2);
                                deliveryDate = getCellValue(cell2);
                                break;
                            }
                        }
                    }
                }
            }

            // 将后面合计的价格隐藏
            for (int i = lastRowNum; i < lastRowNum + 3; i++) {
                Row row = sheet.getRow(i);
                if (null != row) {
                    Cell cell7 = row.getCell(7);
                    cell7.setCellValue("");
                    Cell cell8 = row.getCell(8);
                    cell8.setCellValue("");
                }
            }
            // 将数据赋值
            OrderProductDTO orderProductDTO = new OrderProductDTO();
            orderProductDTO.setDemandName(demandName);
            orderProductDTO.setSupplyName(supplyName);
            orderProductDTO.setOrderContractNo(orderContractNo);
            orderProductDTO.setOrderProductAssociates(orderProductAssociates);
            //将合同上传到7牛文件服务器
            String fileUrl = QiniuUtil.uploadFile(base64Source, fileName);
            orderProductDTO.setOrderContractExtendUrl(fileUrl);
            // 将价格隐藏的合同上传到服务器
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            String extendFileUrl = QiniuUtil
                    .uploadFile(outputStream.toByteArray(), System.currentTimeMillis() + "-noPrice-" + fileName);
            orderProductDTO.setOrderContractUrl(extendFileUrl);
            orderProductDTO.setDeliveryDate(deliveryDate);
            return saveOrderProductInfo(orderProductDTO);
        } catch (Exception e) {
            log.error("upload orderProduct excel exception|orderProduct:{}", JSONObject.toJSONString(orderProduct), e);
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @Override
    public ResultBean uploadOrderFiles(String orderNo, List<OrderUploadDTO> orderUploadDTOs) {
        if (StringUtils.isBlank(orderNo) || orderUploadDTOs == null && orderUploadDTOs.size() > 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        for (OrderUploadDTO orderUploadDTO : orderUploadDTOs) {
            String base64Source = orderUploadDTO.getBase64Source();
            String fileName = orderUploadDTO.getFileName();
            String fileUrl = QiniuUtil.uploadFile(base64Source, fileName);
            OrderFile orderFile = new OrderFile() {{
                setFileUrl(fileUrl);
                setOrderNo(orderNo);
                setFileName(fileName.substring(0, fileName.indexOf(".")));
            }};
            orderFileMapper.insertSelective(orderFile);
        }
        return ResultBean.success(null);
    }

    @Override
    public ResultBean delOrderFiles(int fileId) {
        orderFileMapper.deleteByPrimaryKey(fileId);
        return ResultBean.success(null);
    }

    @Override
    public ResultBean getOrderFiles(String orderNo) {
        OrderFileExample orderFileExample = new OrderFileExample();
        OrderFileExample.Criteria criteria = orderFileExample.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<OrderFile> orderFiles = orderFileMapper.selectByExample(orderFileExample);
        return ResultBean.success(orderFiles);
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
//        orderProduct.setCreateUser(getLoginUserId());
        orderProduct.setCreateUser(1);
        orderProduct.setOrderStatus(CommonEnum.OrderStatus.CREATE.code);
        int count = orderProductDTO.getOrderProductAssociates().stream().map(OrderProductAssociate::getProductNumber)
                .reduce(0, (a, b) -> a + b);
        double totalPrice = orderProductDTO.getOrderProductAssociates().stream().map(item ->
                item.getProductNumber().doubleValue() * item.getPrice().doubleValue()
        ).reduce(0.0, (a, b) -> a + b);
        orderProduct.setTotalCount(count);
        orderProduct.setTotalPrice(new BigDecimal(totalPrice));
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

    public static void main(String[] args) {

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
        if (StringUtils.isNotBlank(orderUpdateDTO.getDeliveryDate())) {
            record.setDeliveryDate(orderUpdateDTO.getDeliveryDate());
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
    @Transactional(rollbackFor = Exception.class)
    public ResultBean deleteOrderInfo(int id) {
        if (id > 0) {
            OrderProduct orderProduct = orderProductMapper.selectByPrimaryKey(id);
            if (orderProduct != null) {
                Byte orderStatus = orderProduct.getOrderStatus();
                if (orderStatus != CommonEnum.OrderStatus.CREATE.code
                        && orderStatus != CommonEnum.OrderStatus.AUDIT_ORDER_CLOSE.code) {
                    return ResultBean.error(CommonEnum.ResponseEnum.ORDER_STATUS_NOT_DELETE);
                }
            }
            int delete = orderProductMapper.deleteByPrimaryKey(id);

            // 删除 流程实例
            flowInstanceService.deleteFlowInstance(orderProduct.getOrderNo());
            if (delete > 0) {
                // 刪除订单管理的产品
                OrderProductAssociateExample example = new OrderProductAssociateExample();
                example.or().andOrderNoEqualTo(orderProduct.getOrderNo());
                orderProductAssociateMapper.deleteByExample(example);
                return ResultBean.success(delete);
            } else {
                return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
            }
        }
        return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
    }

    @Transactional(rollbackFor = Exception.class)
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
                    List<OrderProductAssociate> orderProductAssociates = orderProductAssociateMapper
                            .selectByExample(new OrderProductAssociateExample() {{
                                or().andOrderNoEqualTo(orderNo);
                            }});
                    orderProductAssociates.forEach(e -> {
                        e.setPrice(BigDecimal.ZERO);
                        e.setTotalPrice(BigDecimal.ZERO);
                    });
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
        if (model.getOrderStatus() != null && model.getOrderStatus() > -1) {
            criteria.andOrderStatusEqualTo(model.getOrderStatus());
        }
        if (model.getOrderStatusList() != null && model.getOrderStatusList().size() > 0) {
            criteria.andOrderStatusIn(model.getOrderStatusList());
        }
        if (model.getDeliverStatus() != null && model.getDeliverStatus() > -1) {
            criteria.andDeliverStatusEqualTo(model.getDeliverStatus());
        }
        if (StringUtils.isNotBlank(model.getDemandName())) {
            criteria.andDemandNameLike("%" + model.getDemandName() + "%");
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
        List<OrderProductAssociate> orderProductAssociates = orderProductAssociateMapper
                .selectByExample(new OrderProductAssociateExample() {{
                    or().andOrderNoEqualTo(orderNo);
                }});
        for (OrderProductAssociate orderProductAssociate : orderProductAssociates) {
            String productNo = orderProductAssociate.getProductNo();
            String productModel = orderProductAssociate.getProductModel();
            String specifications = orderProductAssociate.getSpecifications();
            ProductCheckMaterialListDTO productCheckMaterialListDTO = new ProductCheckMaterialListDTO();
            // 根据型号和规格获取可选零件列表（核料用）
            List<MaterialTypeListDTO> materials = getTypeMaterials(productNo, productModel, specifications);
            BeanUtils.copyProperties(orderProductAssociate, productCheckMaterialListDTO);
            productCheckMaterialListDTO.setListDTOS(materials);
            list.add(productCheckMaterialListDTO);
        }
        return list;
    }

    /**
     * 根据型号和规格获取原料（阀体，阀板，阀座,阀杆）
     */
    public List<MaterialTypeListDTO> getTypeMaterials(String productNo, String productModel, String specifications) {
        // 1.获取规格,截取数字，保留四位数，前面补0（DN65=>0065）
//        String spec = String.format("%04d", Integer.parseInt(specifications.replaceAll("[^0-9]", "")));
        // 成品型号示例（270DD7A1XH-16Q）

        // 获取产品类型（D：蝶阀；H：止回阀；）
        String productType = productModel.substring(0, 1);
        String smallModel = "";
        if (productType.equals(CommonEnum.ProductType.H.code)) {
            smallModel = "H77";
        } else {
            if (productModel.length() >= 4) {
                smallModel = productModel.substring(0, 4);
            }

        }

        // 产品号（D  Sb 7A 1 X3 N-10 Q-DN50 或者 H 77 X3 R-10 Q-DN50）
        productNo = productNo.replaceAll(" ", "");// 去掉空格
        int lastIndexOf = productNo.lastIndexOf("-");
        int indexOf = productNo.indexOf("-");
        String fati = "", fatiyali = "", faban = "", fazuo = "";
        String fatiGroup = productNo.substring(indexOf + 1, lastIndexOf);
        int fatiGroupLength = fatiGroup.length();
        if (fatiGroup.contains("150LB")) {
            fatiyali = fatiGroup.substring(0, 5);
            fati = fatiGroup.substring(5, fatiGroupLength);
        } else if (fatiGroup.contains("10K")) {
            fatiyali = fatiGroup.substring(0, 3);
            fati = fatiGroup.substring(3, fatiGroupLength);
        } else {
            fatiyali = fatiGroup.substring(0, 2);
            fati = fatiGroup.substring(2, fatiGroupLength);
        }
        String fabanRule = productNo.substring(indexOf - 1, indexOf);
        // 判断- 前一位，是否是a,b,d,L。如果是，说明阀板是两位英文，否则是一位
        String[] fabanRules = new String[]{"a", "b", "d", "L"};
        if (Arrays.asList(fabanRules).contains(fabanRule)) {
            faban = productNo.substring(indexOf - 2, indexOf);
            fazuo = productNo.substring(indexOf - 4, indexOf - 2);
        } else {
            faban = productNo.substring(indexOf - 1, indexOf);
            fazuo = productNo.substring(indexOf - 3, indexOf - 1);
        }

        // 获取阀体规则
        List<String> fatiModelConfig = new ArrayList<>();
        // 获取阀体压力规则
        List<String> fatiYaliModelConfig = new ArrayList<>();
        // 获取阀座规则
        List<String> fazuoModelConfig = new ArrayList<>();
        // 获取阀板规则
        List<String> fabanModelConfig = new ArrayList<>();

        // 获取全部规则列表
        List<ProductModelConfig> modelConfigs = productModelConfigService.getList("", "");
        if (modelConfigs != null && modelConfigs.size() > 0) {
            for (ProductModelConfig e : modelConfigs) {
                final String indexRule = e.getIndexRule();
                final String materialType = e.getMaterialType();
                final String productTypeRule = e.getProductType();
                if (indexRule.equals(fati) && materialType.equals("fati") && productTypeRule.equals(productType)) {
                    fatiModelConfig.add(e.getMaterialGraphNoStr());
                } else if (indexRule.equals(fatiyali) && materialType.equals("fatiyali") && productTypeRule
                        .equals(productType)) {
                    fatiYaliModelConfig.add(e.getMaterialGraphNoStr());
                } else if (indexRule.equals(fazuo) && materialType.equals("fazuo") && productTypeRule.equals(productType)) {
                    fazuoModelConfig.add(e.getMaterialGraphNoStr());
                } else if (indexRule.equals(faban) && materialType.equals("faban") && productTypeRule.equals(productType)) {
                    fabanModelConfig.add(e.getMaterialGraphNoStr());
                }
            }

        }

        // 获取符合阀体的列表(D270-0050-01-00Qa-aF05-01-001)
        List<MaterialResultDTO> fatiCollect = new ArrayList<>();
        List<MaterialResultDTO> fatiCollectEmpty = new ArrayList<>();
        // 获取符合阀座的列表(D270-0050-02-E0-01)
        List<MaterialResultDTO> fazuoCollect = new ArrayList<>();
        List<MaterialResultDTO> fazuoCollectEmpty = new ArrayList<>();
        // 获取符合阀板的列表(D270-0050-03-Hc-02-00)
        List<MaterialResultDTO> fabanCollect = new ArrayList<>();
        List<MaterialResultDTO> fabanCollectEmpty = new ArrayList<>();
        // 获取符合阀杆的列表
        List<MaterialResultDTO> faganCollect = new ArrayList<>();
        // 获取通用零件列表的列表
        List<MaterialResultDTO> tongyongCollect = new ArrayList<>();

        // 根据型号和规格，获取图号列表
        // 阀体图号列表
        List<Material> fatiMaterialList = materialService
                .getListByMultiModelAndSpec(CommonEnum.ProductModelType.FATI.classifyId, smallModel, specifications);
        if (fatiMaterialList != null && fatiMaterialList.size() > 0) {
            // 去除尾部带数字的阀体图号
            fatiMaterialList = fatiMaterialList.stream().filter(e -> e.getGraphNo().endsWith("M") || e.getGraphNo().endsWith("J") || e.getGraphNo().endsWith("B")).collect(Collectors.toList());
            for (Material e : fatiMaterialList) {
                String graphNo = e.getGraphNo();
                String name = e.getName();
                Integer currentQuantity = e.getCurrentQuantity();
                MaterialResultDTO materialResultDTO = new MaterialResultDTO();
                materialResultDTO.setCurrentQuantity(currentQuantity);
                materialResultDTO.setMaterialName(name);
                materialResultDTO.setGraphNo(graphNo);
                materialResultDTO.setSupportQuantity(e.getSupportQuantity());

                String[] split = graphNo.split("-");
                if (split.length > 4) {
                    //阀体材质,阀体压力 都满足
                    if (fatiModelConfig.size() > 0) {
                        String fatiPro = split[3];
                        // 如果是蝶阀，需要将00Qa前面的00去掉核料
                        if (!productType.equals(CommonEnum.ProductType.H.code)) {
                            fatiPro = split[3].replaceAll("[0-9]", "");
                        }
                        if (fatiModelConfig.contains(fatiPro) && fatiYaliModelConfig
                                .contains(split[4].substring(0, 1))) {
                            fatiCollect.add(materialResultDTO);
                        }
                    }
                }
                fatiCollectEmpty.add(materialResultDTO);
            }
        }
        // 如果没有符合规则的阀体，则把型号，规则找到的阀体，展示出来
//        if (CollectionUtils.isEmpty(fatiCollect) && !CollectionUtils.isEmpty(fatiCollectEmpty)) {
//            fatiCollect.addAll(fatiCollectEmpty);
//        }

        // 阀座图号列表
        List<Material> fazuoMaterialList = materialService
                .getListByMultiModelAndSpec(CommonEnum.ProductModelType.FAZUO.classifyId, smallModel, specifications);
        if (fazuoMaterialList != null && fazuoMaterialList.size() > 0) {
            for (Material e : fazuoMaterialList) {
                String graphNo = e.getGraphNo();
                String name = e.getName();
                Integer currentQuantity = e.getCurrentQuantity();
                MaterialResultDTO materialResultDTO = new MaterialResultDTO();
                materialResultDTO.setCurrentQuantity(currentQuantity);
                materialResultDTO.setMaterialName(name);
                materialResultDTO.setGraphNo(graphNo);
                materialResultDTO.setSupportQuantity(e.getSupportQuantity());

                String[] split = graphNo.split("-");
                // 止回阀没有阀座
                if (!productType.equals(CommonEnum.ProductType.H.code)) {
                    if (fazuoModelConfig.size() > 0) {
                        if (split.length > 3 && fazuoModelConfig.contains(split[3])) {
                            fazuoCollect.add(materialResultDTO);
                        }
                    }
                    fazuoCollectEmpty.add(materialResultDTO);
                }
            }
        }
        if (CollectionUtils.isEmpty(fazuoCollect) && !CollectionUtils.isEmpty(fazuoCollectEmpty)) {
            fazuoCollect.addAll(fazuoCollectEmpty);
        }

        // 阀板图号列表
        List<Material> fabanMaterialList = materialService
                .getListByMultiModelAndSpec(CommonEnum.ProductModelType.FABAN.classifyId, smallModel, specifications);
        if (fabanMaterialList != null && fabanMaterialList.size() > 0) {
            for (Material e : fabanMaterialList) {
                String graphNo = e.getGraphNo();
                String name = e.getName();
                Integer currentQuantity = e.getCurrentQuantity();
                MaterialResultDTO materialResultDTO = new MaterialResultDTO();
                materialResultDTO.setCurrentQuantity(currentQuantity);
                materialResultDTO.setMaterialName(name);
                materialResultDTO.setGraphNo(graphNo);
                materialResultDTO.setSupportQuantity(e.getSupportQuantity());

                String[] split = graphNo.split("-");
                if (fabanModelConfig.size() > 0) {
                    if (split.length > 3 && fabanModelConfig.contains(split[3])) {
                        fabanCollect.add(materialResultDTO);
                    }
                }
                fabanCollectEmpty.add(materialResultDTO);
            }
        }
        if (CollectionUtils.isEmpty(fabanCollect) && !CollectionUtils.isEmpty(fabanCollectEmpty)) {
            fabanCollect.addAll(fabanCollectEmpty);
        }

        // 阀杆图号列表
        List<Material> faganMaterialList = materialService
                .getListByMultiModelAndSpec(CommonEnum.ProductModelType.FAGAN.classifyId, smallModel, specifications);
        if (faganMaterialList != null && faganMaterialList.size() > 0) {
            faganMaterialList.forEach(e -> {
                String graphNo = e.getGraphNo();
                String name = e.getName();
                Integer currentQuantity = e.getCurrentQuantity();
                MaterialResultDTO materialResultDTO = new MaterialResultDTO();
                materialResultDTO.setCurrentQuantity(currentQuantity);
                materialResultDTO.setMaterialName(name);
                materialResultDTO.setGraphNo(graphNo);
                materialResultDTO.setSupportQuantity(e.getSupportQuantity());
                faganCollect.add(materialResultDTO);
            });
        }

        // 根据型号和规格，获取通用图号列表(一个通用图号对应多个型号和规格)
        List<Material> tongyongList = materialService
                .getListByMultiModelAndSpec(CommonEnum.ProductModelType.TONG_YONG.classifyId, smallModel, specifications);
        if (tongyongList != null && tongyongList.size() > 0) {
            tongyongList.forEach(e -> {
                MaterialResultDTO materialResultDTO = new MaterialResultDTO();
                materialResultDTO.setCurrentQuantity(e.getCurrentQuantity());
                materialResultDTO.setMaterialName(e.getName());
                materialResultDTO.setGraphNo(e.getGraphNo());
                materialResultDTO.setSupportQuantity(e.getSupportQuantity());
                tongyongCollect.add(materialResultDTO);
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
        return listDTOS;
    }


    /**
     * 第一次核料，核心逻辑（根据前端表单传来的数据）
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<OrderCheckMaterialDTO> checkMaterial(String orderNo,
                                                     List<ProductCheckMaterialListDTO> productCheckMaterialListDTOList) {
        List<OrderCheckMaterialDTO> orderCheckMaterialDTOS = new ArrayList<>();
        List<CheckMaterialLog> checkMaterialLogs = new ArrayList<>();
        // 核料总状态（0.全部成功；1.只要有一个零件是失败的,就是失败的）
        int currentUser = getLoginUserId();
        try {
            // 需要核料的零件
            Map<String, MaterialQuantityDTO> materialsMap = new HashMap<>();
            //通用零件特殊处理，不参与实际核料，直接库存充足
            Map<String, MaterialQuantityDTO> tongyongMaterialsMap = new HashMap<>();

            // 将订单中所有产品需要的零件合并起来
            productCheckMaterialListDTOList.stream().forEach(e -> {
                Integer productNumber = e.getProductNumber();
                List<MaterialTypeListDTO> listDTOS = e.getListDTOS();
                listDTOS.stream().forEach(a -> {
                    // 通用料
                    String type = a.getType();
                    if (type.equals(CommonEnum.ProductModelType.TONG_YONG.code)) {
                        List<MaterialResultDTO> list = a.getList();
                        list.stream().forEach(b -> {
                            int materialCount = productNumber * b.getSupportQuantity();
                            String graphNo = b.getGraphNo();
                            if (tongyongMaterialsMap.containsKey(graphNo)) {
                                MaterialQuantityDTO materialQuantityDTO = tongyongMaterialsMap.get(graphNo);
                                Integer quantity = materialQuantityDTO.getQuantity();
                                materialQuantityDTO.setQuantity(quantity + materialCount);
                                tongyongMaterialsMap.put(graphNo, materialQuantityDTO);
                            } else {
                                MaterialQuantityDTO materialQuantityDTO = new MaterialQuantityDTO();
                                materialQuantityDTO.setQuantity(materialCount);
                                materialQuantityDTO.setGraphNo(graphNo);
                                materialQuantityDTO.setType(type);
                                materialQuantityDTO.setMaterialName(b.getMaterialName());
                                tongyongMaterialsMap.put(graphNo, materialQuantityDTO);
                            }
                        });
                    } else {
                        List<MaterialResultDTO> list = a.getList();
                        list.stream().forEach(b -> {
                            String graphNo = b.getGraphNo();
                            int materialCount = productNumber * b.getSupportQuantity();
                            if (materialsMap.containsKey(graphNo)) {
                                MaterialQuantityDTO materialQuantityDTO = materialsMap.get(graphNo);
                                Integer quantity = materialQuantityDTO.getQuantity();
                                materialQuantityDTO.setQuantity(quantity + materialCount);
                                materialsMap.put(graphNo, materialQuantityDTO);
                            } else {
                                MaterialQuantityDTO materialQuantityDTO = new MaterialQuantityDTO();
                                materialQuantityDTO.setQuantity(materialCount);
                                materialQuantityDTO.setGraphNo(graphNo);
                                materialQuantityDTO.setMaterialName(b.getMaterialName());
                                materialQuantityDTO.setType(type);
                                materialsMap.put(graphNo, materialQuantityDTO);
                            }
                        });
                    }
                });
            });

            log.info("checkMaterial tongyong orderNo:{}, material count:{},common material count:{}", orderNo,
                    tongyongMaterialsMap.size(), materialsMap.size());
            // 循环通用零件，直接成功
            Iterator<Map.Entry<String, MaterialQuantityDTO>> tongyongIterator = tongyongMaterialsMap.entrySet().iterator();
            while (tongyongIterator.hasNext()) {
                OrderCheckMaterialDTO orderCheckMaterialDTO = new OrderCheckMaterialDTO();
                Map.Entry<String, MaterialQuantityDTO> next = tongyongIterator.next();
                String materialGraphNo = next.getKey();
                MaterialQuantityDTO materialQuantityDTO = next.getValue();
                orderCheckMaterialDTO.setCheckStatus(CommonEnum.CheckMaterialStatus.SUCCESS.code);
                orderCheckMaterialDTO.setCheckResultMsg("核料成功");
                orderCheckMaterialDTO.setMaterialGraphNo(materialGraphNo);
                orderCheckMaterialDTO.setMaterialName(materialQuantityDTO.getMaterialName());
                orderCheckMaterialDTO.setMaterialCount(materialQuantityDTO.getQuantity());
                orderCheckMaterialDTO.setOrderNo(orderNo);
                orderCheckMaterialDTOS.add(orderCheckMaterialDTO);
            }

            // 循环所需的原料，进行核料
            Iterator<Map.Entry<String, MaterialQuantityDTO>> entryIterator = materialsMap.entrySet().iterator();
            while (entryIterator.hasNext()) {
                int lackMaterialCount = 0;
                Byte checkStatus = 0;
                String checkResult = "";
                // 替换料充足的核料结果
                List<OrderCheckMaterialDTO> replaceList = new ArrayList<>();
                OrderCheckMaterialDTO orderCheckMaterialDTO = new OrderCheckMaterialDTO();
                String graphNo = "", graphNoWithJ = "", graphNoWithM = "", graphNoWithB = "";
                Material materialInfo = null, materialInfoWithJ = null, materialInfoWithM = null, materialInfoWithNum = null, materialInfoWithB = null;
                int currentQuantity = 0, currentQuantityWithJ = 0, currentQuantityWithM = 0, currentQuantityWithNum = 0, currentQuantityWithB = 0;

                Map.Entry<String, MaterialQuantityDTO> next = entryIterator.next();
                graphNo = next.getKey();

                MaterialQuantityDTO materialQuantityDTO = next.getValue();
                Integer materialCount = materialQuantityDTO.getQuantity();
                // 获取零件类型（阀体，阀座等）
                String type = materialQuantityDTO.getType();
                // 如果零件类型是阀体，需要查询零件库里面图号带J，带M的库存；
                if (type.equals(CommonEnum.ProductModelType.FATI.code)) {
                    graphNoWithJ = graphNo.substring(0, graphNo.lastIndexOf("-") + 1).concat("00J");
                    graphNoWithM = graphNo.substring(0, graphNo.lastIndexOf("-") + 1).concat("00M");
                    // 如果是止回阀，
                    if (graphNo.startsWith(CommonEnum.ProductType.H.code)) {
                        // 先核带B的，需要将图号转换成QaEa,
                        graphNoWithB = graphNo.substring(0, graphNo.lastIndexOf("-") + 1).concat("00B").replaceAll("00Qa", "QaEa");
                        // 如果机加工，毛坯图号 需要将QaEa转换成00Qa
                        graphNoWithJ = graphNo.replaceAll("QaEa", "00Qa");
                        graphNoWithM = graphNo.replaceAll("QaEa", "00Qa");
                        materialInfoWithB = materialService.getInfoByGraphNo(graphNoWithB);
                        currentQuantityWithB = materialInfoWithB != null ? materialInfoWithB.getCurrentQuantity() : 0;
                        currentQuantity += currentQuantityWithB;
                    }


//                    // 如果选择的是带M的图号（需要看下他对应的J的图号是什么）
//                    if (graphNo.endsWith("M")) {
//                        List<GraphNoRel> graphNoRels = graphNoRelService.listByGraphNoM(graphNo);
//                        if(graphNoRels.size()>0){
//                            // 如果选择的毛坯件有多个机加工件，循环获取多个机加工件的数量
//                        }
//                    }
                    if (currentQuantity < materialCount) {
                        materialInfoWithJ = materialService.getInfoByGraphNo(graphNoWithJ);
                        currentQuantityWithJ = materialInfoWithJ != null ? materialInfoWithJ.getCurrentQuantity() : 0;
                        currentQuantity += currentQuantityWithJ;
                        log.info("checkMaterial fati check info,orderNo:{},needMaterialCount:{},graphNo:{},graphNoJ:{},quantityJ:{},quantity:{}",
                                orderNo, materialCount, graphNo, graphNoWithJ, currentQuantityWithJ, currentQuantity);
                        // 如果阀体带J的图号库存小于要求的数量，查询正在机加工中的零件数量
                        if (currentQuantity < materialCount) {
                            //查询正在机加工的数量
                            int jingCount = entrustService.obtainEntrustNumber(graphNoWithM);
                            currentQuantityWithJ = currentQuantityWithJ + jingCount;
                            currentQuantity += currentQuantityWithJ;
                            log.info(
                                    "checkMaterial fati check info ,orderNo:{},graphNo:{},graphNoJ:{},quantityJ:{},jijiagong:{},"
                                            + "quantity:{}",
                                    orderNo, graphNo, graphNoWithJ, currentQuantityWithJ, jingCount, currentQuantity);
                            // 如果库存中机加工和正在机加工的数量还小于要求的数量，查询库存中带M的库存
                            if (currentQuantity < materialCount) {
                                materialInfoWithM = materialService.getInfoByGraphNo(graphNoWithM);
                                if (materialInfoWithM != null) {
                                    currentQuantityWithM = materialInfoWithM.getCurrentQuantity();
                                } else {
                                    materialInfoWithM = new Material();
                                    materialInfoWithM.setName("阀体毛坯（系统中暂无）");
                                }
                                currentQuantity += currentQuantityWithM;
                                log.info(
                                        "checkMaterial fati check info ,orderNo:{},graphNo:{},graphNoJ:{},quantityJ:{},quantityM:{},"
                                                + "quantity:{}",
                                        orderNo, graphNo, graphNoWithJ, currentQuantityWithJ, currentQuantityWithM, currentQuantity);
                                if (currentQuantity < materialCount) {
                                    lackMaterialCount = materialCount - currentQuantity;
                                } else {
                                    currentQuantityWithM = materialCount - currentQuantityWithJ - currentQuantityWithB;
                                }
                            } else {
                                currentQuantityWithJ = materialCount - currentQuantityWithB;
                            }
                        } else {
                            currentQuantityWithJ = materialCount - currentQuantityWithB;
                        }
                    } else {
                        currentQuantityWithB = materialCount;
                    }
                } else if (type.equals(CommonEnum.ProductModelType.FABAN.code)) {
                    // 如果零件类型是阀板，需要查询零件里面带数字，带J，带M的库存；
                    //如果选择的阀板不是J和M结尾的，会查一下带数字的库存
                    if (!graphNo.endsWith("J") && !graphNo.endsWith("M")) {
                        materialInfoWithNum = materialService.getInfoByGraphNo(graphNo);
                        currentQuantityWithNum = materialInfoWithNum.getCurrentQuantity();
                        currentQuantity += currentQuantityWithNum;
                    }
                    log.info("checkMaterial faban check info ,orderNo:{},needMaterialCount:{},graphNo:{},quantity:{}", orderNo,
                            materialCount, graphNo, currentQuantityWithNum);
                    if (currentQuantity < materialCount) {
                        graphNoWithJ = graphNo.substring(0, graphNo.lastIndexOf("-") + 1).concat("0J");
                        materialInfoWithJ = materialService.getInfoByGraphNo(graphNoWithJ);
                        if (materialInfoWithJ != null) {
                            currentQuantityWithJ = materialInfoWithJ.getCurrentQuantity();
                        }
                        currentQuantity += currentQuantityWithJ;
                        log.info("checkMaterial faban check info,orderNo:{},graphNo:{},graphNoJ:{},quantityJ:{},quantity:{}",
                                orderNo, graphNo, graphNoWithJ, currentQuantityWithJ, currentQuantity);
                        // 如果阀体带J的图号库存小于要求的数量，查询正在机加工中的零件数量
                        if (currentQuantity < materialCount) {
                            graphNoWithM = graphNo.substring(0, graphNo.lastIndexOf("-") + 1).concat("0M");
                            //查询正在机加工的数量
                            int jingCount = entrustService.obtainEntrustNumber(graphNoWithM);
                            currentQuantityWithJ = currentQuantityWithJ + jingCount;
                            currentQuantity += jingCount;
                            log.info(
                                    "checkMaterial faban check info ,orderNo:{},graphNo:{},graphNoJ:{},quantityJ:{},jijiagong:{},"
                                            + "quantity:{}",
                                    orderNo, graphNo, graphNoWithJ, currentQuantityWithJ, jingCount, currentQuantity);
                            // 如果库存中机加工和正在机加工的数量还小于要求的数量，查询库存中带M的库存
                            if (currentQuantity < materialCount) {
                                materialInfoWithM = materialService.getInfoByGraphNo(graphNoWithM);
                                if (materialInfoWithM != null) {
                                    currentQuantityWithM = materialInfoWithM.getCurrentQuantity();
                                } else {
                                    materialInfoWithM = new Material();
                                    materialInfoWithM.setName("蝶板毛坯（系统中暂无）");
                                }
                                currentQuantity += currentQuantityWithM;
                                log.info(
                                        "checkMaterial faban check info ,orderNo:{},graphNo:{},graphNoJ:{},quantityJ:{},quantityM:{},"
                                                + "quantity:{}",
                                        orderNo, graphNo, graphNoWithJ, currentQuantityWithJ, currentQuantityWithM, currentQuantity);
                                if (currentQuantity < materialCount) {
                                    lackMaterialCount = materialCount - currentQuantity;
                                } else {
                                    currentQuantityWithM = materialCount - currentQuantityWithJ - currentQuantityWithNum;
                                }
                            } else {
                                currentQuantityWithJ = materialCount - currentQuantityWithNum;
                            }
                        } else {
                            currentQuantityWithJ = materialCount - currentQuantityWithNum;
                        }
                    } else {
                        currentQuantityWithNum = materialCount;
                    }
                } else {
                    // 如果是其他类型，则按照图号查询；
                    materialInfo = materialService.getInfoByGraphNo(graphNo);
                    currentQuantity = materialInfo.getCurrentQuantity();
                    if (currentQuantity < materialCount) {
                        lackMaterialCount = materialCount - currentQuantity;
                    } else {
                        currentQuantity = materialCount;
                    }
                }

                // 带数字的图号
                if (currentQuantityWithNum > 0) {
                    checkResult = "核料成功";
                    checkStatus = CommonEnum.CheckMaterialStatus.SUCCESS.code;
                    orderCheckMaterialDTO = new OrderCheckMaterialDTO();
                    orderCheckMaterialDTO.setLackMaterialCount(0);
                    orderCheckMaterialDTO.setCheckStatus(checkStatus);
                    orderCheckMaterialDTO.setCheckResultMsg(checkResult);
                    orderCheckMaterialDTO.setMaterialGraphNo(graphNo);
                    orderCheckMaterialDTO.setMaterialName(materialInfoWithNum.getName());
                    orderCheckMaterialDTO.setMaterialCount(currentQuantityWithNum);
                    orderCheckMaterialDTO.setOrderNo(orderNo);
                    orderCheckMaterialDTOS.add(orderCheckMaterialDTO);
                }
                // 带B的图号
                if (currentQuantityWithB > 0) {
                    checkResult = "核料成功";
                    checkStatus = CommonEnum.CheckMaterialStatus.SUCCESS.code;
                    orderCheckMaterialDTO = new OrderCheckMaterialDTO();
                    orderCheckMaterialDTO.setLackMaterialCount(0);
                    orderCheckMaterialDTO.setCheckStatus(checkStatus);
                    orderCheckMaterialDTO.setCheckResultMsg(checkResult);
                    orderCheckMaterialDTO.setMaterialGraphNo(graphNoWithB);
                    orderCheckMaterialDTO.setMaterialName(materialInfoWithB.getName());
                    orderCheckMaterialDTO.setMaterialCount(currentQuantityWithB);
                    orderCheckMaterialDTO.setOrderNo(orderNo);
                    orderCheckMaterialDTOS.add(orderCheckMaterialDTO);
                }
                // 机加工图号
                if (currentQuantityWithJ > 0) {
                    checkResult = "核料成功";
                    checkStatus = CommonEnum.CheckMaterialStatus.SUCCESS.code;
                    orderCheckMaterialDTO = new OrderCheckMaterialDTO();
                    orderCheckMaterialDTO.setLackMaterialCount(0);
                    orderCheckMaterialDTO.setCheckStatus(checkStatus);
                    orderCheckMaterialDTO.setCheckResultMsg(checkResult);
                    orderCheckMaterialDTO.setMaterialGraphNo(graphNoWithJ);
                    orderCheckMaterialDTO.setMaterialName(materialInfoWithJ.getName());
                    orderCheckMaterialDTO.setMaterialCount(currentQuantityWithJ);
                    orderCheckMaterialDTO.setOrderNo(orderNo);
                    orderCheckMaterialDTOS.add(orderCheckMaterialDTO);
                }
                // 毛坯件图号
                if (materialInfoWithM != null) {
                    if (lackMaterialCount > 0) {
                        checkResult = "库存不足";
                        checkStatus = CommonEnum.CheckMaterialStatus.NEED_PURCHASE.code;
                    } else {
                        checkResult = "核料成功";
                        checkStatus = CommonEnum.CheckMaterialStatus.SUCCESS.code;
                    }
                    orderCheckMaterialDTO = new OrderCheckMaterialDTO();
                    orderCheckMaterialDTO.setLackMaterialCount(lackMaterialCount);
                    orderCheckMaterialDTO.setCheckStatus(checkStatus);
                    orderCheckMaterialDTO.setCheckResultMsg(checkResult);
                    orderCheckMaterialDTO.setMaterialGraphNo(graphNoWithM);
                    orderCheckMaterialDTO.setMaterialName(materialInfoWithM.getName());
                    orderCheckMaterialDTO.setMaterialCount(currentQuantityWithM + lackMaterialCount);
                    orderCheckMaterialDTO.setOrderNo(orderNo);
                    orderCheckMaterialDTOS.add(orderCheckMaterialDTO);
                }
                if (materialInfo != null) {
                    if (lackMaterialCount > 0) {
                        checkResult = "库存不足";
                        checkStatus = CommonEnum.CheckMaterialStatus.NEED_PURCHASE.code;
                        // 如果缺料，将可替换料充足的零件返回给前端
                        String replaceGraphNos = materialInfo.getReplaceGraphNos();
                        if (StringUtils.isNotBlank(replaceGraphNos)) {
                            String[] split = replaceGraphNos.split(",");
                            if (split.length > 0) {
                                for (String replaceGraphNo : split) {
                                    Material replaceMaterialInfo = materialService.getInfoByGraphNo(replaceGraphNo);
                                    if (replaceMaterialInfo != null) {
                                        if (replaceMaterialInfo.getCurrentQuantity() >= materialCount) {
                                            OrderCheckMaterialDTO replaceOrderCheckMaterialDTO = new OrderCheckMaterialDTO();
                                            checkStatus = CommonEnum.CheckMaterialStatus.REPLACE.code;
                                            checkResult = "替换料核料成功，替换料零件余量充足";
                                            replaceOrderCheckMaterialDTO.setCheckStatus(checkStatus);
                                            replaceOrderCheckMaterialDTO.setCheckResultMsg(checkResult);
                                            replaceOrderCheckMaterialDTO.setMaterialGraphNo(replaceGraphNo);
                                            replaceOrderCheckMaterialDTO.setMaterialName(replaceMaterialInfo.getName());
                                            replaceOrderCheckMaterialDTO.setMaterialCount(materialCount);
                                            replaceOrderCheckMaterialDTO.setOrderNo(orderNo);
                                            replaceList.add(replaceOrderCheckMaterialDTO);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        checkResult = "核料成功";
                        checkStatus = CommonEnum.CheckMaterialStatus.SUCCESS.code;
                    }
                    orderCheckMaterialDTO = new OrderCheckMaterialDTO();
                    orderCheckMaterialDTO.setReplaceGraphNoList(replaceList);
                    orderCheckMaterialDTO.setLackMaterialCount(lackMaterialCount);
                    orderCheckMaterialDTO.setCheckStatus(checkStatus);
                    orderCheckMaterialDTO.setCheckResultMsg(checkResult);
                    orderCheckMaterialDTO.setMaterialGraphNo(graphNo);
                    orderCheckMaterialDTO.setMaterialName(materialInfo.getName());
                    orderCheckMaterialDTO.setMaterialCount(currentQuantity + lackMaterialCount);
                    orderCheckMaterialDTO.setOrderNo(orderNo);
                    orderCheckMaterialDTOS.add(orderCheckMaterialDTO);
                }

                // 添加核料日志记录
//                int finalCheckState = checkStatus;
//                String finalCheckResult = checkResult;
//                Integer finalCurrentQuantity = currentQuantity;
//                String finalGraphNo = graphNo;
//                checkMaterialLogs.add(new CheckMaterialLog() {
//                    {
//                        setMaterialGraphNo(finalGraphNo);
//                        setCurrentMaterialCount(finalCurrentQuantity);
//                        setNeedMaterialCount(materialCount);
//                        setCheckUserId(currentUser);
//                        setOrderNo(orderNo);
//                        setCheckResult(finalCheckResult);
//                        setCheckState(String.valueOf(finalCheckState));
//                    }
//                });
            }
            // 批量插入审核日志
//            orderExtendMapper.insertBatchCheckLog(checkMaterialLogs);
        } catch (Exception e) {
            log.error("核料过程中出现的异常，orderNo:{}", orderNo, e);
        }
        return orderCheckMaterialDTOS;
    }

    // region 暂时废弃，替换料初步核料会提供
//
//    /**
//     * 替换料核料
//     *
//     * @return
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public List<OrderCheckMaterialDTO> checkReplaceMaterial(String orderNo, List<OrderCheckMaterialDTO>
//    orderCheckMaterialDTOS) {
//        // 核料总状态（0.全部成功；1.只要有一个零件是失败的；2.有替换料的零件，其余全成功）
//        int checkState = 0;
//        String checkResult = "";
//        int currentUser = getLoginUserId();
//        try {
//            // 循环所需的原料，进行核料
//            for (OrderCheckMaterialDTO orderCheckMaterialDTO : orderCheckMaterialDTOS) {
//                List<MaterialResultDTO> replaceGraphNoList = orderCheckMaterialDTO.getReplaceGraphNoList();
//                if (replaceGraphNoList != null && replaceGraphNoList.size() > 0) {
//                    for (MaterialResultDTO materialResultDTO : replaceGraphNoList) {
//                        Integer materialCount = orderCheckMaterialDTO.getMaterialCount();
//                        // 获取替换料零件的库存
//                        String replaceMaterialGraphNo = materialResultDTO.getGraphNo();
//                        Material replaceGraphNoInfo = materialService.getInfoByGraphNo(replaceMaterialGraphNo);
//                        Integer replaceGraphNoInfoCurrentQuantity = replaceGraphNoInfo.getCurrentQuantity();
//                        if (replaceGraphNoInfoCurrentQuantity >= materialCount) {
//                            orderCheckMaterialDTO.setCheckStatus(CommonEnum.CheckMaterialStatus.SUCCESS.code);
//                            orderCheckMaterialDTO.setCheckResultMsg("核料成功，该零件替换料充足，可走替换料方案");
//                            checkResult += "【替换料{" + replaceMaterialGraphNo + "}库存充足】,";
//                            if (checkState != 1) {
//                                checkState = 2;
//                            }
//                        }
//                    }
//                }
//                orderCheckMaterialDTO.setIsReplace(CommonEnum.Consts.YES.code);
//            }
//        } catch (Exception e) {
//            log.error("替换料核料过程中出现的异常，orderNo:{}", orderNo, e);
//        } finally {
//            // 添加核料日志记录
//            int finalCheckState = checkState;
//            String finalCheckResult = checkResult;
//            String finalOrderNo = orderNo;
//            CheckMaterialLog checkMaterialLog = new CheckMaterialLog() {{
//                setCheckUserId(currentUser);
//                setOrderNo(finalOrderNo);
//                setCheckResult(finalCheckResult);
//                setCheckState(String.valueOf(finalCheckState));
//            }};
//            checkMaterialLogMapper.insertSelective(checkMaterialLog);
//        }
//        return orderCheckMaterialDTOS;
//    }
// endregion

    /**
     * 核料通过,锁定零件（核料员点击下一步）
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int checkPass(List<OrderCheckMaterialDTO> orderCheckMaterialDTOS) {
        String orderNo = "";
        // 是否有替换料
        boolean isExistsReplace = false;
        //  如果核料成功，也需要核料点下一步，才往下走
        if (orderCheckMaterialDTOS != null && orderCheckMaterialDTOS.size() > 0) {
            orderNo = orderCheckMaterialDTOS.get(0).getOrderNo();
            // 如果核料完成，不能重复核料确认
            OrderProductDTO orderProductInfo = getOrderProductInfo(orderNo);
            if (orderProductInfo != null && orderProductInfo.getOrderStatus()
                    .equals(CommonEnum.OrderStatus.CHECK_MATERIAL_COMPLETE.code)) {
                return 0;
            }
            for (OrderCheckMaterialDTO orderCheckMaterialDTO : orderCheckMaterialDTOS) {
                // 核料成功，插入核料表
                OrderMaterial orderMaterial = new OrderMaterial();
                BeanUtils.copyProperties(orderCheckMaterialDTO, orderMaterial);
                String replaceMaterialNo = "";
                // 判断缺料，是否有可替换料，将替换料插入核料表
                List<OrderCheckMaterialDTO> replaceGraphNoList = orderCheckMaterialDTO.getReplaceGraphNoList();
                if (replaceGraphNoList != null && replaceGraphNoList.size() > 0) {
                    OrderCheckMaterialDTO orderCheckMaterialDTO1 = replaceGraphNoList.get(0);
                    replaceMaterialNo = orderCheckMaterialDTO1.getMaterialGraphNo();
                    String replaceMaterialName = orderCheckMaterialDTO1.getMaterialName();
                    orderMaterial.setReplaceMaterialGraphNo(replaceMaterialNo);
                    orderMaterial.setReplaceMaterialName(replaceMaterialName);
                }
                String materialGraphNo = orderCheckMaterialDTO.getMaterialGraphNo();
                String materialName = orderCheckMaterialDTO.getMaterialName();
                int lackMaterialCount = orderCheckMaterialDTO.getLackMaterialCount();
                int materialCount = orderCheckMaterialDTO.getMaterialCount();
                Byte checkStatus = orderCheckMaterialDTO.getCheckStatus();
                // 根据订单号和零件号查询，是否已经存在记录
                OrderMaterialExample example = new OrderMaterialExample();
                example.or().andOrderNoEqualTo(orderNo).andMaterialGraphNoEqualTo(materialGraphNo);
                List<OrderMaterial> orderMaterials = orderMaterialMapper.selectByExample(example);
                if (orderMaterials != null && orderMaterials.size() > 0) {
                    OrderMaterial orderMaterialQuery = orderMaterials.get(0);
                    orderMaterial.setId(orderMaterialQuery.getId());
                    // 重新核料，将数据重新设置更新
                    orderMaterialMapper.updateByExampleSelective(orderMaterial, example);
                    // 如果重新核料完成，料的状态是释放，需要重新扣减库存表
                    if (orderMaterialQuery.getCheckStatus() == CommonEnum.CheckMaterialStatus.RELEASE.code) {
                        if (lackMaterialCount > 0) {
                            // 如果有替换料，也需要将替换料锁定（数量是缺少的数量）
                            if (StringUtils.isNotBlank(replaceMaterialNo)) {
                                materialService.updateCurrentQuantity(replaceMaterialNo, (-1) * lackMaterialCount);
                                materialService.updateLockQuantity(replaceMaterialNo, lackMaterialCount);
                            } else {
                                // 如果缺料，将需要的总量减去缺少的量，锁定部分零件。更新零件当前库存和锁定库存
                                int lockCount = materialCount - lackMaterialCount;
                                materialService.updateCurrentQuantity(materialGraphNo, (-1) * lockCount);
                                materialService.updateLockQuantity(materialGraphNo, lockCount);
                            }
                        } else {
                            // 通用零件核料不锁定数量
                            Material infoByGraphNo = materialService.getInfoByGraphNo(materialGraphNo);
                            if (infoByGraphNo != null
                                    && infoByGraphNo.getMaterialClassifyId() != CommonEnum.ProductModelType.TONG_YONG.classifyId) {
                                materialService.updateCurrentQuantity(materialGraphNo, (-1) * materialCount);
                                materialService.updateLockQuantity(materialGraphNo, materialCount);
                            }
                        }
                    }
                } else {
                    int insert = orderMaterialMapper.insertSelective(orderMaterial);
                    if (lackMaterialCount > 0) {
                        // 如果有替换料，也需要将替换料锁定（数量是缺少的数量）
                        if (StringUtils.isNotBlank(replaceMaterialNo)) {
                            materialService.updateCurrentQuantity(replaceMaterialNo, (-1) * lackMaterialCount);
                            materialService.updateLockQuantity(replaceMaterialNo, lackMaterialCount);
                        } else {
                            // 如果缺料，将需要的总量减去缺少的量，锁定部分零件。更新零件当前库存和锁定库存
                            int lockCount = materialCount - lackMaterialCount;
                            materialService.updateCurrentQuantity(materialGraphNo, (-1) * lockCount);
                            materialService.updateLockQuantity(materialGraphNo, lockCount);
                        }
                    } else {
                        // 通用零件核料不锁定数量
                        Material infoByGraphNo = materialService.getInfoByGraphNo(materialGraphNo);
                        if (infoByGraphNo != null
                                && infoByGraphNo.getMaterialClassifyId() != CommonEnum.ProductModelType.TONG_YONG.classifyId) {
                            materialService.updateCurrentQuantity(materialGraphNo, (-1) * materialCount);
                            materialService.updateLockQuantity(materialGraphNo, materialCount);
                        }
                    }
                }
                Integer id = orderMaterial.getId();

                // 缺料的零件，发起请购
                if (checkStatus == CommonEnum.CheckMaterialStatus.NEED_PURCHASE.code) {
                    // 判断缺料，是否有可替换料
                    if (replaceGraphNoList != null && replaceGraphNoList.size() > 0) {
                        isExistsReplace = true;
                        for (OrderCheckMaterialDTO checkMaterialDTO : replaceGraphNoList) {
                            // 替换料，发起替换料审批流程
                            if (checkMaterialDTO.getCheckStatus() == CommonEnum.CheckMaterialStatus.REPLACE.code) {
                                FlowInstanceDTO flowInstanceDTO = new FlowInstanceDTO();
                                flowInstanceDTO.setFormId(id);
                                flowInstanceDTO.setFlowId(4);
                                flowInstanceDTO.setFormNo("");
                                flowInstanceDTO.setFormType(10);
                                flowInstanceDTO.setSummary("核料过程中-替换料表单");
                                flowInstanceService.create(flowInstanceDTO);
                            }
                        }
                    } else {
                        String finalOrderNo = orderNo;
                        ApplyBuyDTO applyBuyDTO = new ApplyBuyDTO() {{
                            setProductOrderNo(finalOrderNo);
                            List<ApplyBuyItem> list = new ArrayList<>();
                            ApplyBuyItem applyBuyItem = new ApplyBuyItem() {{
                                setMaterialGraphNo(materialGraphNo);
                                setMaterialName(materialName);
                                setPurchaseNumber(lackMaterialCount);
                            }};
                            list.add(applyBuyItem);
                            setItemList(list);
                        }};
                        applyBuyService.save(applyBuyDTO);
                    }
                }

            }
            // 将订单状态改为替换料审核,如果有替换料
            if (isExistsReplace) {
                updateOrderProductStatus(orderNo, CommonEnum.OrderStatus.AUDIT_REPLACE_MATERIAL.code);
            } else {
                // 将订单状态改为核料完成
                updateOrderProductStatus(orderNo, CommonEnum.OrderStatus.CHECK_MATERIAL_COMPLETE.code);
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
            orderMaterialDTOS.stream().filter(e -> e.getCheckStatus() != CommonEnum.CheckMaterialStatus.RELEASE.code)
                    .forEach(e -> {
                        // 将核料状态改为【释放料】
                        String materialGraphNo = e.getMaterialGraphNo();
                        String replaceMaterialGraphNo = e.getReplaceMaterialGraphNo();
                        orderMaterialMapper.updateByExampleSelective(new OrderMaterial() {{
                            setCheckStatus(CommonEnum.CheckMaterialStatus.RELEASE.code);
                        }}, new OrderMaterialExample() {{
                            or().andOrderNoEqualTo(orderNo).andMaterialGraphNoEqualTo(materialGraphNo);
                        }});
                        // 将原料表释放
                        int materialCount = e.getMaterialCount();
                        if (StringUtils.isNotBlank(replaceMaterialGraphNo)) {
                            materialService.updateCurrentQuantity(replaceMaterialGraphNo, materialCount);
                            materialService.updateLockQuantity(replaceMaterialGraphNo, (-1) * materialCount);
                        } else {
                            materialService.updateCurrentQuantity(materialGraphNo, materialCount);
                            materialService.updateLockQuantity(materialGraphNo, (-1) * materialCount);
                        }
                    });
        }

        return 0;
    }

// endregion

    @Override
    public List<OrderMaterialDTO> listOrderMaterial(String orderNo) {
        if (StringUtils.isNotBlank(orderNo)) {
            List<OrderMaterialDTO> orderMaterialDTOS = orderExtendMapper.listOrderMaterial(orderNo);
            if (null != orderMaterialDTOS && orderMaterialDTOS.size() > 0) {
                return orderMaterialDTOS.stream().filter(e -> e.getCheckStatus() != CommonEnum.CheckMaterialStatus.RELEASE.code)
                        .collect(Collectors.toList());
            }
        }
        return null;
    }

    @Override
    public List<String> listOrderNo(String orderStatus) {
        return orderExtendMapper.listOrderNo(orderStatus);
    }

    @Override
    public List<OrderMaterialDTO> listReplaceMaterial(String orderNo) {
        List<OrderMaterialDTO> orderMaterialDTOS = listOrderMaterial(orderNo);
        return orderMaterialDTOS.stream().filter(e -> StringUtils.isNotBlank(e.getReplaceMaterialGraphNo()))
                .collect(Collectors.toList());
    }

    @Override
    public OrderMaterialDTO infoReplaceMaterial(int id) {
        OrderMaterial orderMaterial = orderMaterialMapper.selectByPrimaryKey(id);
//        Material infoByGraphNo = materialService.getInfoByGraphNo(orderMaterial.getMaterialGraphNo());
        OrderMaterialDTO orderMaterialDTO = new OrderMaterialDTO();
        BeanUtils.copyProperties(orderMaterial, orderMaterialDTO);
        return orderMaterialDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int auditReplaceMaterial(CheckReplaceMaterialAuditDTO model) {
        // 替换料审批完成,将替换料换成主料
        OrderMaterial orderMaterial = orderMaterialMapper.selectByPrimaryKey(model.getOrderMaterialId());
        String orderNo = orderMaterial.getOrderNo();
        String materialGraphNo = orderMaterial.getMaterialGraphNo();
        String materialName = orderMaterial.getMaterialName();
        String replaceMaterialName = orderMaterial.getReplaceMaterialName();
        String replaceMaterialGraphNo = orderMaterial.getReplaceMaterialGraphNo();
        // 判断信息是否都完全
        if (StringUtils.isAnyBlank(materialGraphNo, replaceMaterialGraphNo)) {
            log.error("auditReplaceMaterial graphNo is null");
            return 0;
        }

        Byte auditResult = orderMaterial.getAuditResult();
        if (auditResult > 0) {
            log.error("auditReplaceMaterial has audit final status,id:{}", model.getOrderMaterialId());
            return 0;
        }

        orderMaterial.setAuditResult(model.getAuditResult());
        if (model.getAuditResult() == CommonEnum.Consts.AUDIT_PASS.code) {
            // 更新状态为替换
            orderMaterial.setCheckStatus(CommonEnum.CheckMaterialStatus.REPLACE.code);
//            orderMaterial.setMaterialName(replaceMaterialName);
//            orderMaterial.setMaterialGraphNo(replaceMaterialGraphNo);
//            orderMaterial.setReplaceMaterialName(materialName);
//            orderMaterial.setReplaceMaterialGraphNo(materialGraphNo);
        }
        orderMaterialMapper.updateByPrimaryKeySelective(orderMaterial);

        // 查看这个订单号的替换料是否都审核完毕
        OrderMaterialExample example = new OrderMaterialExample();
        example.or().andOrderNoEqualTo(orderNo);
        List<OrderMaterial> orderMaterials = orderMaterialMapper.selectByExample(example);
        // 找出该订单下的替换料是否都审核完成(替换料图号不为空，审核状态大于0)
        boolean allMatch = orderMaterials.stream().filter(e -> StringUtils.isNotBlank(e.getReplaceMaterialGraphNo()))
                .allMatch(e -> e.getAuditResult() > 0);
        if (allMatch) {
            // 都审批完成，将订单状态改为核料完成
            updateOrderProductStatus(orderNo, CommonEnum.OrderStatus.CHECK_MATERIAL_COMPLETE.code);
        }
        return 0;
    }


    private String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell != null) {
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
                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {// 如果是日期格式
                        cellValue = DateFormatterUtils.formatterDateString("yyyy-MM-dd", cell.getDateCellValue());
                    } else {
                        cellValue = new BigDecimal(cell.getNumericCellValue()).toString();
                        if (cellValue.contains(".")) {
                            cellValue = Double.toString(cell.getNumericCellValue());
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return cellValue;
    }

    @Override
    public ResultBean updateOrderDeliverStatus(String orderNo, int status, Integer deliveredNumber) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setDeliverStatus((byte) status);
        if (deliveredNumber != null && deliveredNumber > 0) {
            // 更新已发货数量
            orderProduct.setDeliveredNumber(deliveredNumber);
        }
        OrderProductExample example = new OrderProductExample();
        example.createCriteria().andOrderNoEqualTo(orderNo);
        return ResultBean.success(orderProductMapper.updateByExampleSelective(orderProduct, example));
    }

    @Override
    public ResultBean uploadAccessory(String orderNo, List<Accessory> accessories) {
        if (StringUtils.isEmpty(orderNo) || CollectionUtils.isEmpty(accessories)) {
            return ResultBean.error(ResponseEnum.PARAM_ERROR);
        }
        OrderProduct orderProduct = new OrderProduct();
        OrderProductExample example = new OrderProductExample();
        example.createCriteria().andOrderNoEqualTo(orderNo);
        orderProduct.setAccessory(JSON.toJSONString(accessories));
        orderProductMapper.updateByExampleSelective(orderProduct, example);
        return ResultBean.success(accessories);
    }

    @Override
    public ResultBean getAccessory(String orderNo) {
        if (StringUtils.isEmpty(orderNo)) {
            return ResultBean.error(ResponseEnum.PARAM_ERROR);
        }
        List<Accessory> accessories = new ArrayList<>();
        OrderProductExample example = new OrderProductExample();
        example.createCriteria().andOrderNoEqualTo(orderNo);
        List<OrderProduct> orderProducts = orderProductMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(orderProducts) && orderProducts.size() > 0) {
            String accessary = orderProducts.get(0).getAccessory();
            if (StringUtils.isNotEmpty(accessary)) {
                accessories.addAll(JSON.parseArray(accessary, Accessory.class));
            }
        }
        return ResultBean.success(accessories);
    }

    @Override
    public ResultBean updateOrderDemand(String orderNo, String demandName) {
        if (StringUtils.isEmpty(orderNo)) {
            return ResultBean.error(ResponseEnum.PARAM_ERROR);
        }
        OrderProductExample example = new OrderProductExample();
        example.createCriteria().andOrderNoEqualTo(orderNo);
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setDemandName(demandName);
        orderProductMapper.updateByExampleSelective(orderProduct, example);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getOrderNoListByquery(Integer type, Integer status, String orderNo) {
        if (status == null) {
            return ResultBean.error(ResponseEnum.PARAM_ERROR);
        }
        OrderProductExample orderProductExample = new OrderProductExample();
        OrderProductExample.Criteria criteria = orderProductExample.createCriteria();
        if (type == 0) {
            // 查询发货状态
            criteria.andDeliverStatusEqualTo(status.byteValue());
        }
        if (type == 1) {
            // 查询 订单流转状态
            criteria.andOrderStatusEqualTo(status.byteValue());
        }
        if (StringUtils.isNotEmpty(orderNo)) {
            criteria.andOrderNoLike("%" + orderNo + "%");
        }
        List<OrderProduct> orderProducts = orderProductMapper.selectByExample(orderProductExample);
        if (CollectionUtils.isEmpty(orderProducts)) {
            ResultBean.success(new ArrayList<>());
        }
        List<String> orderNoList = orderProducts.stream().map(OrderProduct::getOrderNo).collect(Collectors.toList());
        return ResultBean.success(orderNoList);
    }
}
