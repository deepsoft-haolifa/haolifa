//package com.deepsoft.haolifa.service.impl.finance.helper;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.*;
//import com.itextpdf.text.pdf.draw.DottedLineSeparator;
//import com.itextpdf.text.pdf.draw.LineSeparator;
//
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class PdfReport {// main测试
//    public static void main(String[] args) throws Exception {
//        try {
//            // 1.新建document对象
//            Document document = new Document(PageSize.A4);// 建立一个Document对象
//
//            // 2.建立一个书写器(Writer)与document对象关联
//            File file = new File("/Users/yuan/Desktop/复杂表格.pdf");
//            file.createNewFile();
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
////            writer.setPageEvent(new Watermark("HELLO ITEXTPDF"));// 水印
////            writer.setPageEvent(new MyHeaderFooter());// 页眉/页脚
////            writer.setEncryption("123".getBytes(), "123".getBytes(), PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
////            writer.setEncryption(null, null,  PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
//
//            // 3.打开文档
//            document.open();
//            document.addTitle("Title@PDF-Java");// 标题
//            document.addAuthor("Author@umiz");// 作者
//            document.addSubject("Subject@iText pdf sample");// 主题
//            document.addKeywords("Keywords@iTextpdf");// 关键字
//            document.addCreator("Creator@umiz`s");// 创建者
//
//            // 4.向文档中添加内容
//            new PdfReport().generatePDF(document);
//
//            // 5.关闭文档
//            document.close();
//
////            createTablePdf(new File("D:\\PDFDemo1.pdf"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 定义全局的字体静态变量
//    private static Font titlefont;
//    private static Font headfont;
//    private static Font keyfont;
//    private static Font textfont;
//
//    private static Font titleFont1;
//    private static Font subTitleFont1;
//    private static Font tableFont1;
//    // 最大宽度
//    private static int maxWidth = 520;
//    // 静态代码块
//    static {
//        try {
//            // 不同字体（这里定义为同一种字体：包含不同字号、不同style）
//            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//            titlefont = new Font(bfChinese, 16, Font.BOLD);
//            headfont = new Font(bfChinese, 14, Font.BOLD);
//            keyfont = new Font(bfChinese, 10, Font.BOLD);
//            textfont = new Font(bfChinese, 10, Font.NORMAL);
//
//             titleFont1 = new Font(bfChinese, 15, Font.BOLD);
//             subTitleFont1 = new Font(bfChinese, 10, Font.NORMAL);
//             tableFont1 = new Font(bfChinese, 13, Font.NORMAL);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 生成PDF文件
//    public void generatePDF(Document document) throws Exception {
//
//        // 段落
//        Paragraph paragraph = new Paragraph("美好的一天从早起开始！", titlefont);
//        paragraph.setAlignment(1); //设置文字居中 0靠左   1，居中     2，靠右
//        paragraph.setIndentationLeft(12); //设置左缩进
//        paragraph.setIndentationRight(12); //设置右缩进
//        paragraph.setFirstLineIndent(24); //设置首行缩进
//        paragraph.setLeading(20f); //行间距
//        paragraph.setSpacingBefore(5f); //设置段落上空白
//        paragraph.setSpacingAfter(10f); //设置段落下空白
//
//        // 直线
//        Paragraph p1 = new Paragraph();
//        p1.add(new Chunk(new LineSeparator()));
//
//        // 点线
//        Paragraph p2 = new Paragraph();
//        p2.add(new Chunk(new DottedLineSeparator()));
//
//        // 超链接
//        Anchor anchor = new Anchor("baidu");
//        anchor.setReference("www.baidu.com");
//
//        // 定位
//        Anchor gotoP = new Anchor("goto");
//        gotoP.setReference("#top");
//
//        // 添加图片
//        Image image = Image.getInstance("https://img-blog.csdn.net/20180801174617455?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNzg0ODcxMA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70");
//        image.setAlignment(Image.ALIGN_CENTER);
//        image.scalePercent(40); //依照比例缩放
//
//        // 表格
//        PdfPTable table = getPdfPTable1();
//
//        document.add(paragraph);
//        document.add(anchor);
//        document.add(p2);
//        document.add(gotoP);
//        document.add(p1);
//        document.add(table);
//        document.add(image);
//
//        // ==============色块===================
//        Paragraph paragraph1 = new Paragraph();
//        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 11.0f, Font.BOLD, BaseColor.WHITE);
//        Chunk chunk = new Chunk("Total Cost:", f);
////        chunk.setBackground(BaseColor.RED, 0.0f, 0.0f, 470.0f, 0.0f);
//        // red、green、blue
//        BaseColor baseColor = new BaseColor(255, 0, 0);
//        chunk.setBackground(baseColor, 0.0f, 0.0f, 470.0f, 0.0f);
//        //设置段落前后间距
////        paragraph1.setSpacingAfter(25);
////        paragraph1.setSpacingBefore(25);
////        //设置段段落居中
////        paragraph1.setAlignment(Element.ALIGN_CENTER);
////        //设置缩进
////        paragraph1.setIndentationLeft(250);
////        paragraph1.setIndentationRight(50);
//        paragraph1.add(chunk);
//        document.add(paragraph1);
//
//        // 表格2
//        PdfPTable table2 = createTable2();
//        document.add(table2);
//
//        // 表格2
//        PdfPTable table3 = createTable3();
//        document.add(table3);
//
//        // 表格4
//        Paragraph title = new Paragraph("柔柔弱弱柔柔弱弱让", titleFont1);
//        title.setAlignment(Element.ALIGN_CENTER);
//        Paragraph subTitle = new Paragraph("eeeeee\n\n\n", subTitleFont1);
//        subTitle.setAlignment(Element.ALIGN_CENTER);
//        document.add(title);
//        document.add(subTitle);
//        document.add(createTable(tableFont1));
//    }
//
//
//
//    private PdfPTable createTable2() throws DocumentException, IOException {
//        // 添加表格，4列
//        PdfPTable table = new PdfPTable(4);
//        // 设置表格宽度比例为100%
//        table.setWidthPercentage(100);
//        // 设置表格的宽度
//        table.setTotalWidth(300);
//        // 也可以每列分别设置宽度
//        float[] width = new float[] { 120, 120, 120, 120 };
//        table.setTotalWidth(width);
//        // 锁住宽度
//        table.setLockedWidth(true);
//        // 设置表格上面空白宽度
//        table.setSpacingBefore(10f);
//        // 设置表格下面空白宽度
//        table.setSpacingAfter(10f);
//        // 设置表格默认为无边框
////        table.getDefaultCell().setBorder(0);
//
//        // 构建每个单元格
////        String xx = "Cell 1";
////        String xx = "Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1 Cell 1";
////        PdfPCell cell1 = new PdfPCell(new Paragraph(xx));
//        Chunk chunk1 = new Chunk("Name 1");
//        Paragraph phrase = new Paragraph();
//        phrase.add(chunk1);
//        PdfPCell cell1 = new PdfPCell(phrase);
//        // 边框颜色
////        cell1.setBorderColor(BaseColor.BLUE);
//        // 设置背景颜色
////        cell1.setBackgroundColor(BaseColor.ORANGE);
//        // 设置跨两行
////        cell1.setRowspan(2);
//        // 设置距左边的距离
////        cell1.setPaddingLeft(10);
//        // 设置高度
////        cell1.setFixedHeight(50);
//        // 设置内容水平居中显示
//        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        // 设置垂直居中
//        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell1);
//
//        PdfPCell cell2 = new PdfPCell(new Paragraph("the name value"));
////        cell2.setBorderColor(BaseColor.GREEN);
////        cell2.setPaddingLeft(30);
//        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell2);
//
//        PdfPCell cell3 = new PdfPCell(new Paragraph("Date 1"));
////        cell3.setBorderColor(BaseColor.RED);
////        cell3.setPaddingLeft(10);
//        // 设置无边框
////        cell3.setBorder(Rectangle.NO_BORDER);
//        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell3);
//
//        PdfPCell cell4 = new PdfPCell(new Paragraph("2020/11/11"));
////        cell3.setBorderColor(BaseColor.RED);
////        cell3.setPaddingLeft(10);
//        // 设置无边框
////        cell3.setBorder(Rectangle.NO_BORDER);
//        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell4);
//
//        Paragraph phrase5 = new Paragraph();
//        Chunk chunk5 = new Chunk("XX Name ");
//        phrase5.add(chunk5);
//        PdfPCell cell5 = new PdfPCell(phrase5);
//        // 设置内容水平居中显示
//        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
//        // 设置垂直居中
//        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell5);
//
//        Paragraph phrase6 = new Paragraph();
//        phrase6.add(new Chunk("xxx"));
//        phrase6.add(Chunk.NEWLINE);
//        phrase6.add(new Chunk("ooo"));
//        phrase6.add(Chunk.NEWLINE);
//        phrase6.add(new Chunk("ooo"));
//        PdfPCell cell6 = new PdfPCell(phrase6);
//        // 设置内容水平居中显示
//        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
//        // 设置垂直居中
//        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell6);
//
//
//        // date 2
//        Paragraph phrase7 = new Paragraph();
//        phrase7.add(new Chunk("date 2 "));
//        PdfPCell cell7 = new PdfPCell(phrase7);
//        // 设置内容水平居中显示
//        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
//        // 设置垂直居中
//        cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell7);
//
//        Paragraph phrase8 = new Paragraph();
//        phrase8.add(new Chunk("2020/11/11"));
//        PdfPCell cell8 = new PdfPCell(phrase8);
//        // 设置内容水平居中显示
//        cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
//        // 设置垂直居中
//        cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell8);
//
//
//        // 占4列
//        // 在表格添加图片
//        Image img = Image.getInstance("/Users/yuan/Desktop/img.png");
////        img.setScaleToFitHeight(false);
//        // 图片大小
//        img.scalePercent(10.5f);
//        PdfPCell cellImg = new PdfPCell();
////        img.scalePercent(10);
////        img.scaleAbsolute(194,202);
////        PdfPCell cellImg = new PdfPCell(img, false);
////        cellImg.addElement(img);
//
//        Paragraph phraseImg = new Paragraph();
//        phraseImg.add(Chunk.NEWLINE);
//        phraseImg.add(Chunk.NEWLINE);
//        phraseImg.add(Chunk.NEWLINE);
//        phraseImg.add(Chunk.NEWLINE);
//        phraseImg.add(Chunk.NEWLINE);
//        phraseImg.add(Chunk.NEWLINE);
//        phraseImg.add(new Chunk("ooo"));
//        phraseImg.add(Chunk.NEWLINE);
//        phraseImg.add(new Chunk(img, 0, 0, true));
//        phraseImg.add(Chunk.NEWLINE);
//        phraseImg.add(new Chunk("rrrrr"));
//        cellImg.setPhrase(phraseImg);
//
//        // 占三行
////        cellImg.setRowspan(5);
//        // 占4列
//        cellImg.setColspan(4);
////        cellImg.setBorderColor(BaseColor.RED);
//
////        cellImg.setPaddingLeft(10);
////        cellImg.setFixedHeight(50);
//
//
//        cellImg.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cellImg.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cellImg);
//
//        // 增加一个条形码到表格
////        Barcode128 code128 = new Barcode128();
////        code128.setCode("14785236987541");
////        code128.setCodeType(Barcode128.CODE128);
////        // 生成条形码图片
////        Image code128Image = code128.createImageWithBarcode(cb, null, null);
//        // 加入到表格
////        PdfPCell cellcode = new PdfPCell(cellimg, true);
////        cellcode.setHorizontalAlignment(Element.ALIGN_CENTER);
////        cellcode.setVerticalAlignment(Element.ALIGN_MIDDLE);
////        cellcode.setFixedHeight(30);
////        table.addCell(cellcode);
////
////        PdfPCell cell5 = new PdfPCell(new Paragraph("Cell 5"));
////        cell5.setPaddingLeft(10);
////        // 设置占用列数
////        cell5.setColspan(2);
////        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
////        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
////        table.addCell(cell5);
//
//        return table;
//    }
//
//    private PdfPTable createTable3() throws DocumentException, IOException {
//        // 添加表格，4列
//        PdfPTable table = new PdfPTable(4);
//        // 设置表格宽度比例为100%
//        table.setWidthPercentage(50);
//        // 设置表格的宽度
//        table.setTotalWidth(500);
//        // 也可以每列分别设置宽度
//        float[] width = new float[] { 160, 70, 130, 100 };
//        table.setTotalWidth(width);
//        // 锁住宽度
//        table.setLockedWidth(true);
//        // 设置表格上面空白宽度
//        table.setSpacingBefore(10f);
//        // 设置表格下面空白宽度
//        table.setSpacingAfter(10f);
//        // 设置表格默认为无边框
//        table.getDefaultCell().setBorder(0);
//
//        // 构建每个单元格
//        PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
//        // 边框颜色
//        cell1.setBorderColor(BaseColor.BLUE);
//        // 设置背景颜色
//        cell1.setBackgroundColor(BaseColor.ORANGE);
//        // 设置跨两行
//        cell1.setRowspan(2);
//        // 设置距左边的距离
//        cell1.setPaddingLeft(10);
//        // 设置高度
//        cell1.setFixedHeight(20);
//        // 设置内容水平居中显示
//        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        // 设置垂直居中
//        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell1);
//
//        PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
//        cell2.setBorderColor(BaseColor.GREEN);
//        cell2.setPaddingLeft(10);
//        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell2);
//
//        PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
//        cell3.setBorderColor(BaseColor.RED);
//        cell3.setPaddingLeft(10);
//        // 设置无边框
//        cell3.setBorder(Rectangle.NO_BORDER);
//        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell3);
//
//        // 在表格添加图片
//        Image cellimg = Image.getInstance("/Users/yuan/Desktop/img.png");
//        PdfPCell cell4 = new PdfPCell(cellimg, true);
//        cell4.setBorderColor(BaseColor.RED);
//        cell4.setPaddingLeft(10);
//        cell4.setFixedHeight(30);
//        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell4);
//
//        // 增加一个条形码到表格
////        Barcode128 code128 = new Barcode128();
////        code128.setCode("14785236987541");
////        code128.setCodeType(Barcode128.CODE128);
////        // 生成条形码图片
////        Image code128Image = code128.createImageWithBarcode(cb, null, null);
//        // 加入到表格
//        PdfPCell cellcode = new PdfPCell(cellimg, true);
//        cellcode.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cellcode.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cellcode.setFixedHeight(30);
//        table.addCell(cellcode);
//
//        PdfPCell cell5 = new PdfPCell(new Paragraph("Cell 5"));
//        cell5.setPaddingLeft(10);
//        // 设置占用列数
//        cell5.setColspan(2);
//        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell5);
//
//        return table;
//    }
//
//    private PdfPTable getPdfPTable1() {
//        // 表格
//        PdfPTable table = createTable(new float[] { 40, 120, 120, 120, 80, 80 });
//        table.addCell(createCell("美好的一天", headfont, Element.ALIGN_LEFT, 6, false));
//        table.addCell(createCell("早上9:00", keyfont, Element.ALIGN_CENTER));
//        table.addCell(createCell("中午11:00", keyfont, Element.ALIGN_CENTER));
//        table.addCell(createCell("中午13:00", keyfont, Element.ALIGN_CENTER));
//        table.addCell(createCell("下午15:00", keyfont, Element.ALIGN_CENTER));
//        table.addCell(createCell("下午17:00", keyfont, Element.ALIGN_CENTER));
//        table.addCell(createCell("晚上19:00", keyfont, Element.ALIGN_CENTER));
//        Integer totalQuantity = 0;
//        for (int i = 0; i < 5; i++) {
//            table.addCell(createAnchor("起床", textfont));
//            table.addCell(createAnchorCell("吃午饭", textfont));
//            table.addCell(createAnchor2("午休", textfont));
//            table.addCell(createCell("下午茶", textfont));
//            table.addCell(createCell("回家", textfont));
//            table.addCell(createCell("吃晚饭", textfont));
//            totalQuantity ++;
//        }
//        table.addCell(createCell("总计", keyfont));
//        table.addCell(createCell("", textfont));
//        table.addCell(createCell("", textfont));
//        table.addCell(createCell("", textfont));
//        table.addCell(createCell(String.valueOf(totalQuantity) + "件事", textfont));
//        table.addCell(createCell("", textfont));
//        return table;
//    }
//
//
///**------------------------创建表格单元格的方法start----------------------------*/
//    /**
//     * 创建单元格(指定字体)
//     * @param value
//     * @param font
//     * @return
//     */
//    public PdfPCell createCell(String value, Font font) {
//        PdfPCell cell = new PdfPCell();
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setPhrase(new Phrase(value, font));
//        return cell;
//    }
//
//    /**
//     * 创建单元格(指定字体)
//     * @param value
//     * @param font
//     * @return
//     */
//    public PdfPCell createAnchor(String value, Font font) {
//        PdfPCell cell = new PdfPCell();
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        // 超链接
//        Anchor anchor = new Anchor("baidu");
//        anchor.setReference("https://www.baidu.com");
//        cell.setPhrase(anchor);
//        return cell;
//    }
//
//    /**
//     * 创建单元格(指定字体)
//     * @param value
//     * @param font
//     * @return
//     */
//    public PdfPCell createAnchor2(String value, Font font) {
//        PdfPCell cell = new PdfPCell();
////        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
////        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
////        // 超链接
////        Anchor anchor = new Anchor("baidu");
////        anchor.setReference("https://www.baidu.com");
////        cell.setPhrase(anchor);
//
//        Paragraph country = new Paragraph();
//        Anchor dest = new Anchor("ECEP201023084", new Font(Font.FontFamily.HELVETICA, 10, Font.UNDEFINED, BaseColor.BLUE));
//        dest.setName("CN");
//        dest.setReference("http://www.china.com");//external
//        country.add(dest);
////        country.add(String.format(": %d sites", 10000));
//        cell.addElement(country);
//        return cell;
//    }
//
//    /**
//     * 创建单元格(指定字体)
//     * @param value
//     * @param font
//     * @return
//     */
//    public PdfPCell createAnchorCell(String value, Font font) {
////        PdfPCell cell = new PdfPCell();
////        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
////        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
////        // 超链接
////        Anchor anchor = new Anchor("baidu");
////        anchor.setReference("www.baidu.com");
////        cell.setPhrase(anchor);
////        return cell;
//
//
//        Paragraph paragraph = new Paragraph();
//        Anchor anchor = new Anchor("我是百度链接", font);
//        anchor.setName("百度链接");
//        anchor.setReference("https://www.baidu.com");
//        paragraph.add(anchor);
//        PdfPCell lastCell = new PdfPCell(paragraph);
//        lastCell.setHorizontalAlignment(Element.ALIGN_LEFT);
//        lastCell.setBorder(Rectangle.NO_BORDER);
//        //lastCell.setColspan(tableSize);
//        return lastCell;
//    }
//
//    /**
//     * 创建单元格（指定字体、水平..）
//     * @param value
//     * @param font
//     * @param align
//     * @return
//     */
//    public PdfPCell createCell(String value, Font font, int align) {
//        PdfPCell cell = new PdfPCell();
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setHorizontalAlignment(align);
//        cell.setPhrase(new Phrase(value, font));
//        return cell;
//    }
//    /**
//     * 创建单元格（指定字体、水平居..、单元格跨x列合并）
//     * @param value
//     * @param font
//     * @param align
//     * @param colspan
//     * @return
//     */
//    public PdfPCell createCell(String value, Font font, int align, int colspan) {
//        PdfPCell cell = new PdfPCell();
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setHorizontalAlignment(align);
//        cell.setColspan(colspan);
//        cell.setPhrase(new Phrase(value, font));
//        return cell;
//    }
//    /**
//     * 创建单元格（指定字体、水平居..、单元格跨x列合并、设置单元格内边距）
//     * @param value
//     * @param font
//     * @param align
//     * @param colspan
//     * @param boderFlag
//     * @return
//     */
//    public PdfPCell createCell(String value, Font font, int align, int colspan, boolean boderFlag) {
//        PdfPCell cell = new PdfPCell();
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setHorizontalAlignment(align);
//        cell.setColspan(colspan);
//        cell.setPhrase(new Phrase(value, font));
//        cell.setPadding(3.0f);
//        if (!boderFlag) {
//            cell.setBorder(0);
//            cell.setPaddingTop(15.0f);
//            cell.setPaddingBottom(8.0f);
//        } else if (boderFlag) {
//            cell.setBorder(0);
//            cell.setPaddingTop(0.0f);
//            cell.setPaddingBottom(15.0f);
//        }
//        return cell;
//    }
//    /**
//     * 创建单元格（指定字体、水平..、边框宽度：0表示无边框、内边距）
//     * @param value
//     * @param font
//     * @param align
//     * @param borderWidth
//     * @param paddingSize
//     * @param flag
//     * @return
//     */
//    public PdfPCell createCell(String value, Font font, int align, float[] borderWidth, float[] paddingSize, boolean flag) {
//        PdfPCell cell = new PdfPCell();
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setHorizontalAlignment(align);
//        cell.setPhrase(new Phrase(value, font));
//        cell.setBorderWidthLeft(borderWidth[0]);
//        cell.setBorderWidthRight(borderWidth[1]);
//        cell.setBorderWidthTop(borderWidth[2]);
//        cell.setBorderWidthBottom(borderWidth[3]);
//        cell.setPaddingTop(paddingSize[0]);
//        cell.setPaddingBottom(paddingSize[1]);
//        if (flag) {
//            cell.setColspan(2);
//        }
//        return cell;
//    }
///**------------------------创建表格单元格的方法end----------------------------*/
//
//
///**--------------------------创建表格的方法start------------------- ---------*/
//    /**
//     * 创建默认列宽，指定列数、水平(居中、右、左)的表格
//     * @param colNumber
//     * @param align
//     * @return
//     */
//    public PdfPTable createTable(int colNumber, int align) {
//        PdfPTable table = new PdfPTable(colNumber);
//        try {
//            table.setTotalWidth(maxWidth);
//            table.setLockedWidth(true);
//            table.setHorizontalAlignment(align);
//            table.getDefaultCell().setBorder(1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return table;
//    }
//    /**
//     * 创建指定列宽、列数的表格
//     * @param widths
//     * @return
//     */
//    public PdfPTable createTable(float[] widths) {
//        PdfPTable table = new PdfPTable(widths);
//        try {
//            table.setTotalWidth(maxWidth);
//            table.setLockedWidth(true);
//            table.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.getDefaultCell().setBorder(1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return table;
//    }
//
//    /**
//     * 表格各种属性综合使用
//     *
//     * @throws IOException
//     * @throws DocumentException
//     */
//    public static void createTablePdf(File file) throws IOException, DocumentException {
//        Document document = new Document();
//        // 创建PdfWriter对象
//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
//        // 打开文档
//        document.open();
//
//        // 添加表格，4列
//        PdfPTable table = new PdfPTable(4);
//        // 设置表格宽度比例为%100
//        table.setWidthPercentage(100);
//        // 设置表格的宽度
//        table.setTotalWidth(500);
//        // 也可以每列分别设置宽度
//        table.setTotalWidth(new float[] { 160, 70, 130, 100 });
//        // 锁住宽度
//        table.setLockedWidth(true);
//        // 设置表格上面空白宽度
//        table.setSpacingBefore(10f);
//        // 设置表格下面空白宽度
//        table.setSpacingAfter(10f);
//        // 设置表格默认为无边框
//        table.getDefaultCell().setBorder(0);
//        PdfContentByte cb = writer.getDirectContent();
//
//        // 构建每个单元格
//        PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
//        // 边框颜色
//        cell1.setBorderColor(BaseColor.BLUE);
//        // 设置背景颜色
//        cell1.setBackgroundColor(BaseColor.ORANGE);
//        // 设置跨两行
//        cell1.setRowspan(2);
//        // 设置距左边的距离
//        cell1.setPaddingLeft(10);
//        // 设置高度
//        cell1.setFixedHeight(20);
//        // 设置内容水平居中显示
//        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        // 设置垂直居中
//        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell1);
//
//        PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
//        cell2.setBorderColor(BaseColor.GREEN);
//        cell2.setPaddingLeft(10);
//        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell2);
//
//        PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
//        cell3.setBorderColor(BaseColor.RED);
//        cell3.setPaddingLeft(10);
//        // 设置无边框
//        cell3.setBorder(Rectangle.NO_BORDER);
//        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell3);
//
//        // 在表格添加图片
//        Image cellimg = Image.getInstance("/Users/yuan/Desktop/img.png");
//        PdfPCell cell4 = new PdfPCell(cellimg, true);
//        cell4.setBorderColor(BaseColor.RED);
//        cell4.setPaddingLeft(10);
//        cell4.setFixedHeight(30);
//        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell4);
//
//        // 增加一个条形码到表格
//        Barcode128 code128 = new Barcode128();
//        code128.setCode("14785236987541");
//        code128.setCodeType(Barcode128.CODE128);
//        // 生成条形码图片
//        Image code128Image = code128.createImageWithBarcode(cb, null, null);
//        // 加入到表格
//        PdfPCell cellcode = new PdfPCell(code128Image, true);
//        cellcode.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cellcode.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cellcode.setFixedHeight(30);
//        table.addCell(cellcode);
//
//        PdfPCell cell5 = new PdfPCell(new Paragraph("Cell 5"));
//        cell5.setPaddingLeft(10);
//        // 设置占用列数
//        cell5.setColspan(2);
//        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell5);
//        document.add(table);
//        // 关闭文档
//        document.close();
//    }
//    /**
//     * 创建空白的表格
//     * @return
//     */
//    public PdfPTable createBlankTable() {
//        PdfPTable table = new PdfPTable(1);
//        table.getDefaultCell().setBorder(0);
//        table.addCell(createCell("", keyfont));
//        table.setSpacingAfter(20.0f);
//        table.setSpacingBefore(20.0f);
//        return table;
//    }
//
//    private static final String WINDOWS_FILEPATH = "D:\\";
//    private static final String LINUX_FILEPATH = "/usr/weaver/ecology/loyo/biddingContract/opinionPdf/";
//    // 宋体（对应css中的 属性 font-family: SimSun; /*宋体*/）
//    private static final String WINDOWS_FONTS = "C:\\Windows\\Fonts\\SIMSUN.TTC";
//    private static final String LINUX_FONTS = "/usr/share/fonts/SIMSUN.TTC";
//    private static final BaseColor BORDER_COLOR = BaseColor.BLACK;
//    // 表头背景色
//    private static final BaseColor HCELL_BACKGROUNDCOLOR = new BaseColor(111, 168, 220);// 175, 238, 238
//    private static final BaseColor BCELL_NAME_COLOR = new BaseColor(65, 105, 225);// 72, 209, 204
//    private static final BaseColor BCELL_OPINION_BACKGROUNDCOLOR = new BaseColor(220, 220, 220);
//    private static final float TABLE_BORDER_WIDTH = 0.5f;
//
//
//    public static PdfPTable createTable(Font font) throws Exception {
//        PdfPTable table = new PdfPTable(6);// 创建一个有6列的表格
//        createTHead(table, font);
//        createTBody(table, font);
//        return table;
//    }
//
//    public static void createTHead(PdfPTable table, Font font) throws Exception {
//        table.addCell(getHCell("姓名", font));
//        table.addCell(getHCell("部门", font));
//        table.addCell(getHCell("意见", font));
//        table.addCell(getHCell("接收人", font));
//        table.addCell(getHCell("审批时间", font));
//        table.addCell(getHCell("审批节点", font));
//    }
//
//    public static PdfPCell getHCell(String name, Font font) {
//        PdfPCell cell = new PdfPCell(new Phrase((name), font));
//        cell.setBorderColor(BORDER_COLOR);
//        cell.setBackgroundColor(HCELL_BACKGROUNDCOLOR);
//        cell.setBorderWidthTop(TABLE_BORDER_WIDTH);
//        cell.setBorderWidthBottom(TABLE_BORDER_WIDTH);
//        cell.setBorderWidthLeft(TABLE_BORDER_WIDTH);
//        cell.setBorderWidthRight(TABLE_BORDER_WIDTH);
//        return cell;
//    }
//
//    public static void createTBody(PdfPTable table, Font font) {
//        Font nameFont = new Font(font);
//        nameFont.setColor(BCELL_NAME_COLOR);
//        for (int i = 0; i < 3; i++) {
//            PdfPCell cell = new PdfPCell(new Phrase("张三", nameFont));
//            cell.setBorderWidth(TABLE_BORDER_WIDTH);
//            cell.setBorderColor(BORDER_COLOR);
//            table.addCell(cell);
//            table.addCell(getBCommonCell("管理部", font));
//            table.addCell(getBOpinionCell("同意", font));
//            table.addCell(getBCommonCell("张三", font));
//            table.addCell(getBCommonCell("2018-09-17 12:00:00", font));
//            table.addCell(getBCommonCell("A", font));
//        }
//    }
//
//    public static PdfPCell getBCommonCell(String value, Font font) {
//        PdfPCell cell = new PdfPCell(new Phrase(value, font));
//        cell.setBorderColor(BORDER_COLOR);
//        cell.setBorderWidthTop(TABLE_BORDER_WIDTH);
//        cell.setBorderWidthBottom(TABLE_BORDER_WIDTH);
//        cell.setBorderWidthLeft(TABLE_BORDER_WIDTH);
//        cell.setBorderWidthRight(TABLE_BORDER_WIDTH);
//        return cell;
//    }
//
//    public static PdfPCell getBOpinionCell(String value, Font font) {
//        PdfPCell cell = new PdfPCell(new Phrase(value, font));
//        cell.setBackgroundColor(BCELL_OPINION_BACKGROUNDCOLOR);
//        cell.setBorderColor(BORDER_COLOR);
//        cell.setBorderWidthTop(TABLE_BORDER_WIDTH);
//        cell.setBorderWidthBottom(TABLE_BORDER_WIDTH);
//        cell.setBorderWidthLeft(TABLE_BORDER_WIDTH);
//        cell.setBorderWidthRight(TABLE_BORDER_WIDTH);
//        return cell;
//    }
//
//    /**
//     *
//     * <br>
//     * <p>
//     * Description: 获取中文字体位置 <br>
//     * <p>
//     * <br/>
//     * <p>
//     *
//     * @return String 系统字体位置
//     */
//    private static String getChineseFont() {
//        String font1 = WINDOWS_FONTS;
//        // 判断系统类型，加载字体文件
//        String osName = getOsName();
//        if (osName.indexOf("linux") > -1) {
//            font1 = LINUX_FONTS;
//        }
//        if (!new File(font1).exists()) {
//            throw new RuntimeException("字体文件不存在,影响导出pdf中文显示！" + font1);
//        }
//        return font1;
//    }
//
//    /**
//     *
//     * <br>
//     * <p>
//     * Description: 根据系统类型自动选择文件路径 <br>
//     * <p>
//     * <br/>
//     * <p>
//     *
//     * @return
//     */
//    public static String getFilePath() {
//        String osName = getOsName();
//        if (osName.indexOf("linux") > -1) {
//            return LINUX_FILEPATH;
//        } else {
//            return WINDOWS_FILEPATH;
//        }
//    }
//
//    /**
//     *
//     * <br>
//     * <p>
//     * Description: 获取系统类型名 <br>
//     * <p>
//     * <br/>
//     * <p>
//     *
//     * @return
//     */
//    public static String getOsName() {
//        java.util.Properties prop = System.getProperties();
//        return prop.getProperty("os.name").toLowerCase();
//    }
//
//    /**
//     *
//     * <br>
//     * <p>
//     * Description: 给pdf文件添加水印 <br>
//     * <p>
//     * <br/>
//     * <p>
//     *
//     * @param InPdfFile
//     *            要加水印的原pdf文件路径
//     * @param outPdfFile
//     *            加了水印后要输出的路径
//     * @param markImagePath
//     *            水印图片路径
//     * @param imgWidth
//     *            图片横坐标
//     * @param imgHeight
//     *            图片纵坐标
//     * @throws Exception
//     */
//    public static void addPdfImgMark(String InPdfFile, String outPdfFile, String markImagePath, int imgWidth,
//                                     int imgHeight) throws Exception {
//        PdfReader reader = new PdfReader(InPdfFile, "PDF".getBytes());
//        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(new File(outPdfFile)));
//
//        PdfContentByte under;
//
//        PdfGState gs1 = new PdfGState();
//        gs1.setFillOpacity(0.3f);// 透明度设置
//
//        Image img = Image.getInstance(markImagePath);// 插入图片水印
//
//        img.setAbsolutePosition(imgWidth, imgHeight); // 坐标
//        img.setRotation(-20);// 旋转 弧度
//        img.setRotationDegrees(45);// 旋转 角度
//        img.scaleAbsolute(700, 80);// 自定义大小
//        // img.scalePercent(50);//依照比例缩放
//
//        int pageSize = reader.getNumberOfPages();// 原pdf文件的总页数
//        for (int i = 1; i <= pageSize; i++) {
//            under = stamp.getUnderContent(i);// 水印在之前文本下
//            // under = stamp.getOverContent(i);//水印在之前文本上
//            under.setGState(gs1);// 图片水印 透明度
//            under.addImage(img);// 图片水印
//        }
//
//        stamp.close();// 关闭
//    }
//
//    /**
//     *
//     * <br>
//     * <p>
//     * Description: 给pdf文件添加水印<br>
//     *
//     * @param InPdfFile
//     *            要加水印的原pdf文件路径
//     * @param outPdfFile
//     *            加了水印后要输出的路径
//     * @param textMark
//     *            水印文字
//     * @param textWidth
//     *            文字横坐标
//     * @param textHeight
//     *            文字纵坐标
//     * @throws Exception
//     */
//    public static void addPdfTextMark(String InPdfFile, String outPdfFile, String textMark, int textWidth,
//                                      int textHeight) throws Exception {
//        PdfReader reader = new PdfReader(InPdfFile, "PDF".getBytes());
//        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(new File(outPdfFile)));
//
//        PdfContentByte under;
//
//        BaseFont font = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1", "Identity-H", true);// 使用系统字体
//
//        int pageSize = reader.getNumberOfPages();// 原pdf文件的总页数
//        for (int i = 1; i <= pageSize; i++) {
//            under = stamp.getUnderContent(i);// 水印在之前文本下
//            // under = stamp.getOverContent(i);//水印在之前文本上
//            under.beginText();
//            under.setColorFill(new BaseColor(211,211,211));// 文字水印 颜色
//            under.setFontAndSize(font, 38);// 文字水印 字体及字号
//            under.setTextMatrix(textWidth, textHeight);// 文字水印 起始位置
//            under.showTextAligned(Element.ALIGN_CENTER, textMark, textWidth, textHeight, 45);
//            under.endText();
//        }
//        stamp.close();// 关闭
//    }
//}
//
