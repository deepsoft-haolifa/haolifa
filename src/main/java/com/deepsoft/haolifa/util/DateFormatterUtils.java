package com.deepsoft.haolifa.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatterUtils {

    public static final String ONE_FORMATTERPATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String TWO_FORMATTERPATTERN = "yyyy-MM-dd";
    public static final String THREE_FORMATTERPATTERN = "yyyy MM dd HH:mm:ss";
    public static final String THIRD_FORMATTERPATTERN = "yyyyMMdd";

    public static LocalDateTime getLocalDateTime(Date date) {
        if (date == null)
            return LocalDateTime.now();
        return date.toInstant().atZone(ZoneOffset.systemDefault()).toLocalDateTime();
    }

    public static DateTimeFormatter getDateTimeFormatter(String formatter) {
        return DateTimeFormatter.ofPattern(formatter);
    }

    public static String formatterDateString(String formatter,Date date) {
        return getDateTimeFormatter(formatter).format(getLocalDateTime(date));
    }

    public static Date parseDateString(String formatter, String dateString) {
        if(dateString.length() == 10 || dateString.length() == 8) {
            return Date.from(LocalDate.parse(dateString,getDateTimeFormatter(formatter)).atStartOfDay().toInstant(ZoneOffset.UTC));
        }
        return Date.from(LocalDateTime.parse(dateString, getDateTimeFormatter(formatter)).toInstant(ZoneOffset.UTC));
    }

    /**
     * 获取当前年份
     * @return
     */
    public static int getCurrentYear(LocalDate localDate) {
        int year = localDate.getYear();
        return year;
    }

    /**
     * 获取当前月份
     * @return
     */
    public static Month getCurrentMonth(LocalDate localDate) {
        Month month = localDate.getMonth();
        return month;
    }



    public static void main(String[] args) {
        System.out.println("yyyy-MM-dd HH:mm:ss:"+formatterDateString(THREE_FORMATTERPATTERN,null));
        System.out.println("yyyy-MM-dd :"+parseDateString(TWO_FORMATTERPATTERN,"2018-09-10"));
        System.out.println("yyyy-MM-dd HH:mm:ss:"+parseDateString(ONE_FORMATTERPATTERN,"2018-08-15 21:55:32"));
        System.out.println("yyyyMMdd"+parseDateString(THIRD_FORMATTERPATTERN,"2018-08-15 21:55:32"));
    }
}
