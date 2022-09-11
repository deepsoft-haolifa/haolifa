package com.deepsoft.haolifa.service.impl.finance.helper;
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

import static com.itextpdf.text.PageSize.A5;
import static com.itextpdf.text.Rectangle.RIGHT;

public class ItextpdfUtil {
    public static PdfPCell getCell(String text, Font font) {
        Paragraph elements = new Paragraph(text, font);
        PdfPCell pdfPCell = new PdfPCell(elements);
//        pdfPCell.setBorder(RIGHT);
        pdfPCell.setMinimumHeight(20);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell.setLeading(2, 1);
        return pdfPCell;
    }

    public static PdfPCell getCell(String text, Font font, Integer colspan) {
        Paragraph elements = new Paragraph(text, font);
        PdfPCell pdfPCell = new PdfPCell(elements);
//        pdfPCell.setBorder(RIGHT);
        pdfPCell.setMinimumHeight(20);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell.setLeading(2, 1);
        pdfPCell.setColspan(colspan);
        return pdfPCell;
    }

    public static PdfPCell getCell(String text, Font font, float borderWidthLeft, float borderWidthRight,
                                   float borderWidthTop,float borderWidthBottom, Integer colspan) {
        Paragraph elements = new Paragraph(text, font);
        PdfPCell pdfPCell = new PdfPCell(elements);
        pdfPCell.setMinimumHeight(20);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell.setLeading(2, 1);
        pdfPCell.setBorder(RIGHT);
        pdfPCell.setBorderWidthLeft(borderWidthLeft);
        pdfPCell.setBorderWidthRight(borderWidthRight);
        pdfPCell.setBorderWidthTop(borderWidthTop);
        pdfPCell.setBorderWidthBottom(borderWidthBottom);
        pdfPCell.setColspan(colspan);
        return pdfPCell;
    }

    public static PdfPCell getPdfPCell(String text, Font font, Integer border, Integer colspan) {
        Paragraph elements = new Paragraph(text, font);
        PdfPCell pdfPCell = new PdfPCell(elements);
        pdfPCell.setBorder(border);
        pdfPCell.setMinimumHeight(20);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfPCell.setLeading(2, 1);
        pdfPCell.setColspan(colspan);
        return pdfPCell;
    }

    public static void xx(Document document, Font font) throws DocumentException {
        CustomDashedLineSeparator separator = new CustomDashedLineSeparator();
        separator.setDash(5);
        separator.setGap(5);
        separator.setOffset(-10);
        separator.setPercentage(80);
        separator.setLineWidth((float) 1);
        Chunk linebreak = new Chunk(separator);
        document.add(linebreak);

        Paragraph end0 = new Paragraph("虚线以下由财务人员填写", font);
        end0.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(end0);
    }


    public static void h6(Font font, PdfPTable table) {
        Paragraph elements1 = new Paragraph("总经理:", font);
        PdfPCell pdfPCell1 = new PdfPCell(elements1);
        pdfPCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        pdfPCell1.setColspan(3);
//        pdfPCell1.setBorderWidthLeft(0);
        pdfPCell1.setMinimumHeight(30);
        pdfPCell1.setBorderWidthRight(0);
        table.addCell(pdfPCell1);

        Paragraph elements2 = new Paragraph("部门（项目）负责人:", font);
        PdfPCell pdfPCell2 = new PdfPCell(elements2);
        pdfPCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
//        pdfPCell2.setColspan(3);
        pdfPCell2.setMinimumHeight(40);
        pdfPCell2.setBorderWidthLeft(0);
        pdfPCell2.setBorderWidthRight(0);
        table.addCell(pdfPCell2);


        Paragraph elements3 = new Paragraph("报销人:", font);
        PdfPCell pdfPCell3 = new PdfPCell(elements3);
        pdfPCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell3.setColspan(3);
        pdfPCell3.setMinimumHeight(30);
        pdfPCell3.setBorderWidthLeft(0);
//        pdfPCell6.setBorderWidthRight(0);
        table.addCell(pdfPCell3);
    }

    public static Paragraph getElements(Font font, int fontSize, int color, String text) {
        font.setSize(fontSize);
        font.setColor(color, color, color);
        Paragraph end = new Paragraph(text, font);
        end.setAlignment(Paragraph.ALIGN_CENTER);
        return end;
    }

}
