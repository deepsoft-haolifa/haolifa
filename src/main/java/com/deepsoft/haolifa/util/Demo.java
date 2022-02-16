package com.deepsoft.haolifa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author liuyaofei
 * @Date create in 下午8:53 2022/2/16
 * @description
 */
public class Demo {

    public static void main(String[] args) throws ParseException {
        String calDate = "2022-02-01";
        Date calTime = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, calDate);
        // 开始时间 上个月26号
        Calendar cal = Calendar.getInstance();
        cal.setTime(calTime);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 26);
        Date startTime = cal.getTime();
        // 开始时间 这个月25号
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(calTime);
        cal2.set(Calendar.DAY_OF_MONTH, 25);
        Date endTime = cal2.getTime();
        int daysBetween= (int) ((endTime.getTime()-startTime.getTime()+1000000)/(60*60*24*1000));

        System.out.println("1987-01-01 与 2010-01-01 相隔 "+daysBetween+" 天");

    }



}
