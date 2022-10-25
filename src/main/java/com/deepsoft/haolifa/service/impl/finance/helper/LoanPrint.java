package com.deepsoft.haolifa.service.impl.finance.helper;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyInfoRSDTO;
import com.deepsoft.haolifa.util.BigDecimalUtils;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;

import java.math.BigDecimal;

import static com.itextpdf.text.PageSize.A5;

public class LoanPrint {

    static ThreadLocal<LoanApplyInfoRSDTO> threadLocal = new ThreadLocal<>();

    public static void print(LoanApplyInfoRSDTO loanApplyInfoRSDTO, HttpServletResponse response) throws Exception {

        try {
            threadLocal.set(loanApplyInfoRSDTO);

            // 分别设置左右上下的边距
            Document document = new Document(A5.rotate(), 10, 10, 10, 10);

            response.setContentType("application/pdf");

            PdfWriter pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());

            document.open();

//            ClassPathResource classPathResource = new ClassPathResource("static/msyh.ttf");
            BaseFont typeface = BaseFont.createFont("/home/haolifa/static/msyh.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//            BaseFont typeface = BaseFont.createFont("/Users/yuan/Desktop/work/haolifa/src/main/resources/static/msyh.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            Font font = new Font(typeface);

            font.setSize(ItextpdfUtil.titleSize);
            font.setColor(44, 44, 44);
            document.add(ItextpdfUtil.getElements(font, ItextpdfUtil.titleSize, 44, "山西好利阀机械制造有限公司"));


            Paragraph start2 = new Paragraph("借款单", font);
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

            document.add(ItextpdfUtil.getElements(font, 8, 164, "温馨提示：此报销金额以财务核定金额为准"));

            document.close();
            pdfWriter.close();

        } finally {
            // 使用完清除
            threadLocal.remove();
        }

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

        // 第二行
        h2(table, font);

        //第三行
        h3(table, font);

        // 第四行
        h4(table, font);

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
        table.setSpacingBefore(5);

        // 第7行
        h7(table, font);

        //第8行
        h8(table, font);

        return table;
    }

    private static void h1(PdfPTable table, Font font) {
        LoanApplyInfoRSDTO loanApplyInfoRSDTO = threadLocal.get();
        table.addCell(ItextpdfUtil.getPdfPCell("部门:  " + (loanApplyInfoRSDTO.getDeptName()==null?"":loanApplyInfoRSDTO.getDeptName()), font, 0, 8));
//        table.addCell(ItextpdfUtil.getPdfPCell("", font, 0, 24));
        String format ="    年  月  日";
        if (loanApplyInfoRSDTO.getLoanDate()!=null){
             format = DateUtil.format(loanApplyInfoRSDTO.getLoanDate(), "yyyy年MM月dd日");
        }
        Paragraph elements3 = new Paragraph(format, font);
        PdfPCell pdfPCell = new PdfPCell(elements3);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        pdfPCell.setBorder(0);
        pdfPCell.setMinimumHeight(20);
        pdfPCell.setLeading(2, 1);
        pdfPCell.setColspan(24);
        table.addCell(pdfPCell);
    }

    private static void h2(PdfPTable table, Font font) {
        table.addCell(ItextpdfUtil.getCell("项目经费号", font, 8));
        table.addCell(ItextpdfUtil.getCell("借款事由摘要", font, 12));
        table.addCell(ItextpdfUtil.getCell("出差地点", font, 4));
        table.addCell(ItextpdfUtil.getCell("天数 ", font, 4));
        table.addCell(ItextpdfUtil.getCell("人数 ", font, 4));
    }

    private static void h3(PdfPTable table, Font font) {
        LoanApplyInfoRSDTO loanApplyInfoRSDTO = threadLocal.get();

        PdfPCell pdfPCell10 = new PdfPCell();
        pdfPCell10.setColspan(8);
//        table.addCell(pdfPCell10);
        table.addCell(ItextpdfUtil.getCell("", font, 0.5f, 0, 0, 0, 8));
        table.addCell(ItextpdfUtil.getCell("", font, 0.5f, 0, 0, 0, 12));

        if (StringUtils.equalsIgnoreCase(loanApplyInfoRSDTO.getTravelFlag(), "1")) {
            table.addCell(ItextpdfUtil.getCell(loanApplyInfoRSDTO.getTravelArrAddress(), font, 4));
            table.addCell(ItextpdfUtil.getCell(loanApplyInfoRSDTO.getTravelDays() + "天", font, 4));
            table.addCell(ItextpdfUtil.getCell(loanApplyInfoRSDTO.getTravelPeoNum() + "人", font, 4));
        } else {
            table.addCell(ItextpdfUtil.getCell("", font, 4));
            table.addCell(ItextpdfUtil.getCell("", font, 4));
            table.addCell(ItextpdfUtil.getCell("", font, 4));
        }

        table.addCell(ItextpdfUtil.getCell(loanApplyInfoRSDTO.getProjectCode()+" "+loanApplyInfoRSDTO.getProjectCodeName(), font, 0.5f, 0, 0, 0, 8));
        table.addCell(ItextpdfUtil.getCell(loanApplyInfoRSDTO.getPurpose(), font, 0.5f, 0, 0, 0, 12));
        table.addCell(ItextpdfUtil.getCell("预计还款日期", font, 16));

        table.addCell(ItextpdfUtil.getCell("", font, 0.5f, 0, 0, 0, 8));
        table.addCell(ItextpdfUtil.getCell("", font, 0.5f, 0, 0, 0, 12));

        String format = "    年  月  日";
        if(loanApplyInfoRSDTO.getExpectRepaymentDate()!=null){
            format=DateUtil.format(loanApplyInfoRSDTO.getExpectRepaymentDate(), "yyyy年MM月dd日");
        }

        table.addCell(ItextpdfUtil.getCell(format, font, 16));
    }


    private static void h4(PdfPTable table, Font font) {
        LoanApplyInfoRSDTO loanApplyInfoRSDTO = threadLocal.get();

        table.addCell(ItextpdfUtil.getCell("借款金额（大写）", font, 9));

        String montrayUnit ="";
        String string ="";
        if (loanApplyInfoRSDTO.getAmount()!=null){
             montrayUnit = BigDecimalUtils.number2CNMontrayUnit(loanApplyInfoRSDTO.getAmount());
             string = loanApplyInfoRSDTO.getAmount().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        }

        Paragraph elementsD = new Paragraph(" " + montrayUnit, font);
        PdfPCell pdfPCellD = new PdfPCell(elementsD);
        pdfPCellD.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCellD.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCellD.setColspan(18);
        table.addCell(pdfPCellD);


        Paragraph elements = new Paragraph("¥ " + string, font);
        PdfPCell pdfPCell = new PdfPCell(elements);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        pdfPCell.setColspan(5);
        table.addCell(pdfPCell);
    }

    public static void main(String[] args) {
        BigDecimal b = new BigDecimal(100.00000);

        BigDecimal bigDecimal = b.setScale(2, BigDecimal.ROUND_HALF_UP);

        System.out.println(bigDecimal.toString());

    }


    public static void h6(Font font, PdfPTable table) {
        Paragraph elements1 = new Paragraph("总经理:", font);
        PdfPCell pdfPCell1 = new PdfPCell(elements1);
        pdfPCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell1.setColspan(11);
//        pdfPCell1.setBorderWidthLeft(0);
        pdfPCell1.setMinimumHeight(30);
        pdfPCell1.setBorderWidthRight(0);
        table.addCell(pdfPCell1);

        Paragraph elements2 = new Paragraph("部门（项目）负责人:", font);
        PdfPCell pdfPCell2 = new PdfPCell(elements2);
        pdfPCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell2.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell2.setColspan(11);
        pdfPCell2.setMinimumHeight(30);
        pdfPCell2.setBorderWidthLeft(0);
        pdfPCell2.setBorderWidthRight(0);
        table.addCell(pdfPCell2);


        Paragraph elements3 = new Paragraph("报销人:", font);
        PdfPCell pdfPCell3 = new PdfPCell(elements3);
        pdfPCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell3.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell3.setColspan(10);
        pdfPCell3.setMinimumHeight(30);
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
        LoanApplyInfoRSDTO loanApplyInfoRSDTO = threadLocal.get();

        Paragraph elements1 = new Paragraph("支付方式: " + loanApplyInfoRSDTO.getPayTypeCN(), font);
        PdfPCell pdfPCell1 = new PdfPCell(elements1);
        pdfPCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell1.setColspan(1);
//        pdfPCell1.setBorderWidthLeft(0);
        pdfPCell1.setMinimumHeight(50);
//        pdfPCell1.setBorderWidthRight(0);
        table.addCell(pdfPCell1);

        String f = "收款方名称： " + loanApplyInfoRSDTO.getAccountName() +
            "\r\t" +
            "\r\t" +
            "开  户  行：" + loanApplyInfoRSDTO.getBankOfDeposit() +
            "\r\t" +
            "\r\t" +
            "账      号：" + loanApplyInfoRSDTO.getCardNumber();
//        if (StringUtils.equalsIgnoreCase(loanApplyInfoRSDTO.getPayType(), "2")) {
//            f += "\r\t" +
//                "\r\t" +
//                "" + loanApplyInfoRSDTO.getAccountName() + " " + loanApplyInfoRSDTO.getLoanUserNo();
//        }

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