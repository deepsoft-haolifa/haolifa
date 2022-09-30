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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import static com.itextpdf.text.PageSize.A5;

public class RemiburseBXPrint {

    static ThreadLocal<ReimburseApplyDetailDTO> threadLocal = new ThreadLocal<>();

    public static void print(ReimburseApplyDetailDTO reimburseApplyDetailDTO, HttpServletResponse response) throws Exception {

        try {
            threadLocal.set(reimburseApplyDetailDTO);

            // 分别设置左右上下的边距
            Document document = new Document(A5.rotate(), 10, 10, 10, 10);

            response.setContentType("application/pdf");

            PdfWriter pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());

            document.open();

            BaseFont typeface = BaseFont.createFont("/home/haolifa/static/msyh.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            Font font = new Font(typeface);

            font.setSize(ItextpdfUtil.titleSize);
            font.setColor(44, 44, 44);
            document.add(ItextpdfUtil.getElements(font, ItextpdfUtil.titleSize, 44, "山西好利阀机械制造有限公司"));

            Paragraph start2 = new Paragraph("经费报销单", font);
            start2.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(start2);


            font.setSize(ItextpdfUtil.bodySize);
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
//        Document document = new Document(A5, 25, 25, 25, 25);
        Document document = new Document(A5.rotate(), 0, 0, 0, 0);

        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("/Users/yuan/Desktop/复杂表格.pdf"));

        document.open();

        ClassPathResource classPathResource = new ClassPathResource("static/msyh.ttf");
        BaseFont typeface = BaseFont.createFont(classPathResource.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(typeface);

        font.setSize(10);
        font.setColor(44, 44, 44);
        document.add(ItextpdfUtil.getElements(font, 10, 44, "山西好利阀机械制造有限公司"));


        Paragraph start2 = new Paragraph("经费报销单", font);
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
        PdfPTable table = new PdfPTable(5);
        // 设置每列的列宽
        table.setTotalWidth(new float[]{300, 350, 120, 80, 100});
        // 设置居中
        table.setHorizontalAlignment(Element.ALIGN_CENTER);  //水平居中
        table.setSpacingBefore(5);
        table.setSpacingAfter(0);

        // 第一行
        h1(table, font);

        // 第二行
        h2(table, font);

        //第三行
        h3(table, font);

        // 第四行
        h4(table, font);

        // 第五行
        h5(table, font);

        // 第六行
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
        table.setSpacingBefore(10);

        // 第7行
        h7(table, font);

        //第8行
        h8(table, font);

        return table;
    }

    private static void h1(PdfPTable table, Font font) {
        ReimburseApplyDetailDTO reimburseApplyDetailDTO = threadLocal.get();

        table.addCell(ItextpdfUtil.getPdfPCell("部门:  " + reimburseApplyDetailDTO.getDeptName(), font, 0, 1));
//        table.addCell(ItextpdfUtil.getPdfPCell("", font, 0, 4));

        String format = DateUtil.format(reimburseApplyDetailDTO.getReimburseDate(), "yyyy年MM月dd日");
        Paragraph elements3 = new Paragraph(format, font);
        PdfPCell pdfPCell = new PdfPCell(elements3);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        pdfPCell.setBorder(0);
        pdfPCell.setMinimumHeight(20);
        pdfPCell.setLeading(2, 1);
        pdfPCell.setColspan(4);
        table.addCell(pdfPCell);

        // 普通报销 + 借款冲抵100元 摘要

        if (reimburseApplyDetailDTO.getLoanId()!=null){
            String s = "普通报销借款冲抵"+reimburseApplyDetailDTO.getOffsetAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toString()
                +"元"+reimburseApplyDetailDTO.getRemark();
            table.addCell(ItextpdfUtil.getPdfPCell("" + s, font, 0, 5));
        }

    }

    private static void h2(PdfPTable table, Font font) {
        table.addCell(ItextpdfUtil.getCell("项目经费号          ", font));
        table.addCell(ItextpdfUtil.getCell("支出内容摘要         ", font));
        table.addCell(ItextpdfUtil.getCell("票据张数", font));
        table.addCell(ItextpdfUtil.getCell("金额 ", font));
        table.addCell(ItextpdfUtil.getCell("备注 ", font));
    }

    private static void h3(PdfPTable table, Font font) {
        ReimburseApplyDetailDTO reimburseApplyDetailDTO = threadLocal.get();


        reimburseApplyDetailDTO.getReimburseCostDetailRSDTOList()
            .forEach(de -> {
                table.addCell(ItextpdfUtil.getCell(de.getSubjectsType() + de.getSubjectsTypeName(), font));
                table.addCell(ItextpdfUtil.getCell(de.getRemark(), font));
                table.addCell(ItextpdfUtil.getCell(de.getDocNum() + "", font));
                table.addCell(ItextpdfUtil.getCell(de.getAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "", font));
                table.addCell(ItextpdfUtil.getCell(reimburseApplyDetailDTO.getRemark(), font));
            });

        if (reimburseApplyDetailDTO.getReimburseCostDetailRSDTOList().size() <= 4) {
            for (int i = 0; i < 4 - reimburseApplyDetailDTO.getReimburseCostDetailRSDTOList().size(); i++) {
                table.addCell(ItextpdfUtil.getCell("", font));
                table.addCell(ItextpdfUtil.getCell("", font));
                table.addCell(ItextpdfUtil.getCell("", font));
                table.addCell(ItextpdfUtil.getCell("", font));
                table.addCell(ItextpdfUtil.getCell("", font));
            }
        }
    }

    private static void h4(PdfPTable table, Font font) {
        ReimburseApplyDetailDTO reimburseApplyDetailDTO = threadLocal.get();

        table.addCell(ItextpdfUtil.getCell("预约报销总金额（大写）", font));
        table.addCell(ItextpdfUtil.getCell(" "+BigDecimalUtils.number2CNMontrayUnit(reimburseApplyDetailDTO.getAmount()), font));
        Paragraph elements = new Paragraph("¥" + reimburseApplyDetailDTO.getAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toString(), font);
        PdfPCell pdfPCell = new PdfPCell(elements);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        pdfPCell.setColspan(3);
        table.addCell(pdfPCell);
    }

    private static void h5(PdfPTable table, Font font) {
        table.addCell(ItextpdfUtil.getCell("实际报销总金额（大写）", font));
        table.addCell(ItextpdfUtil.getCell("", font));
        Paragraph elements2 = new Paragraph("", font);
        PdfPCell pdfPCell2 = new PdfPCell(elements2);
        pdfPCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        pdfPCell2.setColspan(3);
        table.addCell(pdfPCell2);
    }

    public static void h6(Font font, PdfPTable table) {
        Paragraph elements1 = new Paragraph("总经理:", font);
        PdfPCell pdfPCell1 = new PdfPCell(elements1);
        pdfPCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
//        pdfPCell1.setColspan(3);
//        pdfPCell1.setBorderWidthLeft(0);
        pdfPCell1.setMinimumHeight(25);
        pdfPCell1.setBorderWidthRight(0);
        table.addCell(pdfPCell1);

        Paragraph elements2 = new Paragraph("部门（项目）负责人:", font);
        PdfPCell pdfPCell2 = new PdfPCell(elements2);
        pdfPCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell2.setHorizontalAlignment(Element.ALIGN_LEFT);
//        pdfPCell2.setColspan(3);
        pdfPCell2.setMinimumHeight(25);
        pdfPCell2.setBorderWidthLeft(0);
        pdfPCell2.setBorderWidthRight(0);
        table.addCell(pdfPCell2);


        Paragraph elements3 = new Paragraph("报销人:", font);
        PdfPCell pdfPCell3 = new PdfPCell(elements3);
        pdfPCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell3.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell3.setColspan(3);
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
        pdfPCell1.setMinimumHeight(30);
//        pdfPCell1.setBorderWidthRight(0);
        table.addCell(pdfPCell1);

        Paragraph elements3 = new Paragraph("审核:", font);
        PdfPCell pdfPCell3 = new PdfPCell(elements3);
        pdfPCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell3.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell3.setColspan(2);
        pdfPCell3.setMinimumHeight(30);
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
