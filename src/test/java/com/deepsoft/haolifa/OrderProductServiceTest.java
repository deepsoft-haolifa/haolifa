package com.deepsoft.haolifa;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.dao.repository.SysRoleMapper;
import com.deepsoft.haolifa.dao.repository.SysUserMapper;
import com.deepsoft.haolifa.model.domain.OrderProductAssociate;
import com.deepsoft.haolifa.model.domain.SysRole;
import com.deepsoft.haolifa.model.domain.SysRoleExample;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.dto.FileUploadDTO;
import com.deepsoft.haolifa.model.dto.UserBaseDTO;
import com.deepsoft.haolifa.model.dto.order.GenerateOrderDTO;
import com.deepsoft.haolifa.model.dto.order.OrderProductDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.order.OrderUploadDTO;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.util.Base64Utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class OrderProductServiceTest extends BaseApplicationTests {

    @Autowired
    private OrderProductService orderService;

    @Test
    public void uploadOrderExcelTest() {
        String fileBase64Str = Base64Utils.encryptToBase64("d:\\123.xlsx");
        OrderUploadDTO fileUploadDTO = new OrderUploadDTO();
        fileUploadDTO.setBase64Source(fileBase64Str);
        fileUploadDTO.setFileName("HX1812029-X417-H-ST.xlsx");
        ResultBean resultBean = orderService.uploadOrderProduct(fileUploadDTO);
    }

    @Test
    public void generateOrder() {
//        OrderProductAssociate orderProductAssociate1=new OrderProductAssociate();
//        orderProductAssociate1.setPrice(new BigDecimal("1.00"));
//        System.out.println(orderProductAssociate1.getPrice());


        GenerateOrderDTO generateOrderDTO = new GenerateOrderDTO() {{
            setContractSignDate("2019-03-14");
            setDemandName("北京好利阀业集团有限公司");
            setSupplyName("山西好利阀机械制造有限公司");
            setOrderContractNo("555555");
            setTransportMode("货运");
        }};

        List<OrderProductAssociate> list = new ArrayList();
        list.add(new OrderProductAssociate() {{
            setProductName("手柄对夹密封型中线垂直板蝶阀");
            setProductNo("DSb7A1X3N-16Q-DN65 ");
        }});
        generateOrderDTO.setOrderProductAssociates(list);
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
        File file = new File("d:\\abc.xlsx");
        try {
            FileOutputStream fos2 = new FileOutputStream(file);
            outputStream.writeTo(fos2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void addUser() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("d://user.csv")));
        String line = null;
        while (null != (line = bufferedReader.readLine())) {
            String[] split = line.split(",");
            String name = split[0];
            SysUser sysUser = new SysUser() {{
                setPassword(passwordEncoder.encode("123456"));
                setRealName(name);
                setUsername(split[1]);
            }};
            int insert = sysUserMapper.insertSelective(sysUser);
            Integer id = sysUser.getId();
            List<SysRole> sysRoles = sysRoleMapper.selectByExample(new SysRoleExample() {{
                or().andDescriptionEqualTo(name);
            }});
            SysRole sysRole = sysRoles.get(0);
            sysUserService.insertUserRole(id, new Integer[]{sysRole.getId()});
        }

    }

}
