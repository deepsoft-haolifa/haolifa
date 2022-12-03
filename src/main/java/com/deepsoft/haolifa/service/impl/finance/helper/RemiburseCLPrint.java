package com.deepsoft.haolifa.service.impl.finance.helper;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.ReimburseApplyDetailDTO;
import com.deepsoft.haolifa.util.BigDecimalUtils;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import static com.itextpdf.text.PageSize.A5;

public class RemiburseCLPrint {


    static ThreadLocal<ReimburseApplyDetailDTO> threadLocal = new ThreadLocal<>();

    public static void print(ReimburseApplyDetailDTO reimburseApplyDetailDTO, HttpServletResponse response) throws Exception {

        try {
            threadLocal.set(reimburseApplyDetailDTO);

            // 分别设置左右上下的边距
            Document document = new Document(A5.rotate(), 10, 10, 10, 10);

            response.setContentType("application/pdf");

            PdfWriter pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());

            document.open();

//            ClassPathResource classPathResource = new ClassPathResource("static/msyh.ttf");
            BaseFont typeface = BaseFont.createFont("/home/haolifa/static/msyh.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//            BaseFont typeface = BaseFont.createFont("/Users/yuan/Desktop/work/haolifa/src/main/resources/static/msyh.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            Font font = new Font(typeface);

            document.add(ItextpdfUtil.getElements(font, 13, 44, "山西好利阀机械制造有限公司"));

            Paragraph start2 = new Paragraph("差旅费报销单", font);
            start2.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(start2);


            font.setSize(9);
            font.setColor(44, 44, 44);

            PdfPTable table1 = getPdfPTable1(font);
            document.add(table1);

            // 虚线
            ItextpdfUtil.xx(document, font);

            PdfPTable table2 = getPdfPTable2(font);
            document.add(table2);

            document.add(ItextpdfUtil.getElements(font, 6, 164, "温馨提示：此报销金额以财务核定金额为准"));

            document.close();
            pdfWriter.close();

        } finally {
            // 使用完清除
            threadLocal.remove();
        }

    }



    public static void main(String[] args) throws IOException, DocumentException {

        // 分别设置左右上下的边距
        Document document = new Document(A5.rotate(), 10, 10, 10, 10);

        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("/Users/yuan/Desktop/复杂表格.pdf"));

        document.open();

        BaseFont typeface = BaseFont.createFont("/Users/yuan/Desktop/workgit/itext/src/main/resources/static/msyh.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(typeface);

        document.add(ItextpdfUtil.getElements(font, 10, 44, "山西好利阀机械制造有限公司"));

        Paragraph start2 = new Paragraph("差旅报销单", font);
        start2.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(start2);


        font.setSize(8);
        font.setColor(44, 44, 44);

        PdfPTable table1 = getPdfPTable1(font);
        document.add(table1);

        // 虚线
        ItextpdfUtil.xx(document, font);

        PdfPTable table2 = getPdfPTable2(font);
        document.add(table2);

        document.add(ItextpdfUtil.getElements(font, 5, 164, "温馨提示：此报销金额以财务核定金额为准"));

        document.close();
        pdfWriter.close();


    }

    private static PdfPTable getPdfPTable1(Font font) throws DocumentException {
        // 先创建六列的表格
        PdfPTable table = new PdfPTable(32);
        // 设置每列的列宽
//        table.setTotalWidth(new float[]{300, 350, 120, 80, 100});
        // 设置居中
        table.setHorizontalAlignment(Element.ALIGN_CENTER);  //水平居中
        table.setSpacingBefore(5);
        table.setSpacingAfter(0);

        // 第一行
        h1(table, font);
//
//        // 第二行
        h2(table, font);
//
//        //第三行
        h3(table, font);
//
//        // n
        hn(table, font);
//
//        // 第四行
        h4(table, font);
//
//        // 第五行
        h5(table, font);
//
//
//        // 第六行
        h6(font, table);
        return table;
    }

    private static PdfPTable getPdfPTable2(Font font) throws DocumentException {
        // 先创建六列的表格
        PdfPTable table = new PdfPTable(4);
        // 设置每列的列宽
        table.setTotalWidth(new float[]{1, 1, 1, 1});
        // 设置居中
        table.setHorizontalAlignment(Element.ALIGN_CENTER);  //水平居中
        //
        table.setSpacingBefore(5);

        // 第7行
        h7(table, font);

        //第8行
        h8(table, font);

        return table;
    }

    private static void h1(PdfPTable table, Font font) {
        ReimburseApplyDetailDTO reimburseApplyDetailDTO = threadLocal.get();

        table.addCell(ItextpdfUtil.getPdfPCell("部门:  "+ (reimburseApplyDetailDTO.getDeptName() ==null?"":reimburseApplyDetailDTO.getDeptName()), font, 0, 11));
        table.addCell(ItextpdfUtil.getPdfPCell("项目经费号: "+reimburseApplyDetailDTO.getProjectCode()+""+reimburseApplyDetailDTO.getProjectCodeName(), font, 0, 11));

        String format = "    年  月  日";
        if (reimburseApplyDetailDTO.getReimburseDate()!=null){
             format = DateUtil.format(reimburseApplyDetailDTO.getReimburseDate(), "yyyy年MM月dd日");
        }

//        Paragraph elements3 = new Paragraph("报销人: "+reimburseApplyDetailDTO.getReimburseUserName(), font);
        Paragraph elements3 = new Paragraph(format, font);
        PdfPCell pdfPCell = new PdfPCell(elements3);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        pdfPCell.setBorder(0);
        pdfPCell.setMinimumHeight(20);
        pdfPCell.setLeading(2, 1);
        pdfPCell.setColspan(10);
        table.addCell(pdfPCell);

        // 普通报销 + 借款冲抵100元 摘要
        if (reimburseApplyDetailDTO.getLoanId()!=null){
            String s = "差旅报销借款冲抵"+reimburseApplyDetailDTO.getOffsetAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toString()
                +"元"+reimburseApplyDetailDTO.getRemark();
            table.addCell(ItextpdfUtil.getPdfPCell("" + s, font, 0, 32));
        }


    }

    private static void h2(PdfPTable table, Font font) {
        ReimburseApplyDetailDTO reimburseApplyDetailDTO = threadLocal.get();
        table.addCell(ItextpdfUtil.getCell("出差人", font, 4));
        table.addCell(ItextpdfUtil.getCell(reimburseApplyDetailDTO.getTravelUserName(), font, 12));
        table.addCell(ItextpdfUtil.getCell("事由", font, 4));
        table.addCell(ItextpdfUtil.getCell(reimburseApplyDetailDTO.getRemark(), font, 12));
    }

    private static void h3(PdfPTable table, Font font) {
        table.addCell(ItextpdfUtil.getCell("起止时间及地点", font, 14));
        table.addCell(ItextpdfUtil.getCell("交通费", font, 7));
        table.addCell(ItextpdfUtil.getCell("出差补贴", font, 5));
        table.addCell(ItextpdfUtil.getCell("其他项目", font, 6));
    }

    private static void hn(PdfPTable table, Font font) {
        table.addCell(ItextpdfUtil.getCell("月", font,2));
        table.addCell(ItextpdfUtil.getCell("日", font,2));
        table.addCell(ItextpdfUtil.getCell("起点", font, 3));
        table.addCell(ItextpdfUtil.getCell("月", font,2));
        table.addCell(ItextpdfUtil.getCell("日", font,2));
        table.addCell(ItextpdfUtil.getCell("终点", font, 3));

        table.addCell(ItextpdfUtil.getCell("交通工具", font, 2));
        table.addCell(ItextpdfUtil.getCell("单据张数", font, 2));
        table.addCell(ItextpdfUtil.getCell("金额", font, 3));

        table.addCell(ItextpdfUtil.getCell("天数", font, 2));
        table.addCell(ItextpdfUtil.getCell("金额", font, 3));


        table.addCell(ItextpdfUtil.getCell("项目名称", font, 2));
        table.addCell(ItextpdfUtil.getCell("金额", font, 4));

        ReimburseApplyDetailDTO reimburseApplyDetailDTO = threadLocal.get();

        reimburseApplyDetailDTO.getReimburseTravelDetailRSDTOList()
            .forEach(de -> {
                table.addCell(ItextpdfUtil.getCell(DateUtil.format(de.getDepTime(),"MM"), font,2));
                table.addCell(ItextpdfUtil.getCell(DateUtil.format(de.getDepTime(),"dd"), font,2));
                table.addCell(ItextpdfUtil.getCell(de.getDepAddress(), font, 3));
                table.addCell(ItextpdfUtil.getCell(DateUtil.format(de.getArrTime(),"MM"), font,2));
                table.addCell(ItextpdfUtil.getCell(DateUtil.format(de.getArrTime(),"dd"), font,2));
                table.addCell(ItextpdfUtil.getCell(de.getArrAddress(), font, 3));

                table.addCell(ItextpdfUtil.getCell(de.getVehicleCN(), font, 2));
                table.addCell(ItextpdfUtil.getCell(de.getVehicleDocNum()+"", font, 2));
                table.addCell(ItextpdfUtil.getCell(de.getVehicleAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toString()+"", font, 3));

                table.addCell(ItextpdfUtil.getCell(de.getTravelDays()+"", font, 2));
                table.addCell(ItextpdfUtil.getCell(de.getTravelSubsidyAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toString()+"", font, 3));


                table.addCell(ItextpdfUtil.getCell(de.getProjectTypeCN(), font, 2));
                table.addCell(ItextpdfUtil.getCell(de.getProjectAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toString()+"", font, 4));


            });

        if (reimburseApplyDetailDTO.getReimburseTravelDetailRSDTOList().size() <= 4){
            for (int i = 0; i <  4 - reimburseApplyDetailDTO.getReimburseTravelDetailRSDTOList().size(); i++) {
                table.addCell(ItextpdfUtil.getCell("", font,2));
                table.addCell(ItextpdfUtil.getCell("", font,2));
                table.addCell(ItextpdfUtil.getCell("", font, 3));
                table.addCell(ItextpdfUtil.getCell("", font,2));
                table.addCell(ItextpdfUtil.getCell("", font,2));
                table.addCell(ItextpdfUtil.getCell("", font, 3));

                table.addCell(ItextpdfUtil.getCell("", font, 2));
                table.addCell(ItextpdfUtil.getCell("", font, 2));
                table.addCell(ItextpdfUtil.getCell("", font, 3));

                table.addCell(ItextpdfUtil.getCell("", font, 2));
                table.addCell(ItextpdfUtil.getCell("", font, 3));


                table.addCell(ItextpdfUtil.getCell("", font, 2));
                table.addCell(ItextpdfUtil.getCell("", font, 4));
            }
        }


    }

    private static void h4(PdfPTable table, Font font) {
        ReimburseApplyDetailDTO reimburseApplyDetailDTO = threadLocal.get();

        table.addCell(ItextpdfUtil.getCell("预约报销总金额（大写）", font, 9));

        String montrayUnit = "";
        if (reimburseApplyDetailDTO.getAmount()!=null){
             montrayUnit = BigDecimalUtils.number2CNMontrayUnit(reimburseApplyDetailDTO.getAmount());
        }


        Paragraph elementsD = new Paragraph(" "+ montrayUnit, font);
        PdfPCell pdfPCellD = new PdfPCell(elementsD);
        pdfPCellD.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCellD.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCellD.setColspan(18);
        table.addCell(pdfPCellD);

        String montrayUnit2 = "";
        if (reimburseApplyDetailDTO.getAmount()!=null){
            montrayUnit2 = reimburseApplyDetailDTO.getAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        }

        Paragraph elements = new Paragraph("¥" + montrayUnit2, font);
        PdfPCell pdfPCell = new PdfPCell(elements);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        pdfPCell.setColspan(5);
        table.addCell(pdfPCell);
    }

    private static void h5(PdfPTable table, Font font) {
        table.addCell(ItextpdfUtil.getCell("实际报销总金额（大写）", font, 9));

        Paragraph elementsD = new Paragraph(" ", font);
        PdfPCell pdfPCellD = new PdfPCell(elementsD);
        pdfPCellD.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCellD.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCellD.setColspan(18);
        table.addCell(pdfPCellD);


        Paragraph elements = new Paragraph(" ", font);
        PdfPCell pdfPCell = new PdfPCell(elements);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        pdfPCell.setColspan(5);
        table.addCell(pdfPCell);
    }


    public static void h6(Font font, PdfPTable table) {
        Paragraph elements1 = new Paragraph("总经理:", font);
        PdfPCell pdfPCell1 = new PdfPCell(elements1);
        pdfPCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell1.setColspan(11);
//        pdfPCell1.setBorderWidthLeft(0);
        pdfPCell1.setMinimumHeight(25);
        pdfPCell1.setBorderWidthRight(0);
        table.addCell(pdfPCell1);

        Paragraph elements2 = new Paragraph("部门（项目）负责人:", font);
        PdfPCell pdfPCell2 = new PdfPCell(elements2);
        pdfPCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell2.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell2.setColspan(10);
        pdfPCell2.setMinimumHeight(25);
        pdfPCell2.setBorderWidthLeft(0);
        pdfPCell2.setBorderWidthRight(0);
        table.addCell(pdfPCell2);


        Paragraph elements3 = new Paragraph("报销人:", font);
        PdfPCell pdfPCell3 = new PdfPCell(elements3);
        pdfPCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell3.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell3.setColspan(11);
        pdfPCell3.setMinimumHeight(25);
        pdfPCell3.setBorderWidthLeft(0);
//        pdfPCell6.setBorderWidthRight(0);
        table.addCell(pdfPCell3);
    }

    private static void h7(PdfPTable table, Font font) {
        Paragraph elements1 = new Paragraph("财务主管:", font);
        PdfPCell pdfPCell1 = new PdfPCell(elements1);
        pdfPCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell1.setColspan(2);
//        pdfPCell1.setBorderWidthLeft(0);
        pdfPCell1.setMinimumHeight(20);
//        pdfPCell1.setBorderWidthRight(0);
        table.addCell(pdfPCell1);

        Paragraph elements3 = new Paragraph("审核:", font);
        PdfPCell pdfPCell3 = new PdfPCell(elements3);
        pdfPCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell3.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell3.setColspan(2);
        pdfPCell3.setMinimumHeight(20);
//        pdfPCell3.setBorderWidthLeft(0);
//        pdfPCell6.setBorderWidthRight(0);
        table.addCell(pdfPCell3);
    }

    private static void h8(PdfPTable table, Font font) {
        ReimburseApplyDetailDTO reimburseApplyDetailDTO = threadLocal.get();

        Paragraph elements1 = new Paragraph("支付方式: " + reimburseApplyDetailDTO.getPayTypeCN(), font);
        PdfPCell pdfPCell1 = new PdfPCell(elements1);
        pdfPCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell1.setColspan(1);
//        pdfPCell1.setBorderWidthLeft(0);
        pdfPCell1.setMinimumHeight(50);
//        pdfPCell1.setBorderWidthRight(0);
        table.addCell(pdfPCell1);

        String f =
            "收款方名称：" + reimburseApplyDetailDTO.getAccountName() +
            ";\t         " +
            "开户行\t：" + reimburseApplyDetailDTO.getBankOfDeposit() +
            "\r\t" +
            "\r\t" +
            "账\t\t号：" + reimburseApplyDetailDTO.getCardNumber();

        Paragraph elements3 = new Paragraph(f, font);
        PdfPCell pdfPCell3 = new PdfPCell(elements3);
        pdfPCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell3.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell3.setColspan(3);
        pdfPCell3.setMinimumHeight(50);
//        pdfPCell3.setBorderWidthLeft(0);
//        pdfPCell6.setBorderWidthRight(0);
        table.addCell(pdfPCell3);
    }



}
