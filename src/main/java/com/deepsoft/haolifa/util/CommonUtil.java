package com.deepsoft.haolifa.util;

import cn.hutool.core.util.StrUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.dto.BaseException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author murphy.he
 **/
public class CommonUtil {

    public static Map<String, Object> packMapParam(String year, String month) {
        Map<String, Object> haspMap = new HashMap<>();
        if (StrUtil.isNotBlank(year)) {
            haspMap.put("year", year);
            if (StrUtil.isNotBlank(month)) {
                int iMonth = Integer.parseInt(month);
                if (iMonth == 1) {
                    haspMap.put("startTime", Integer.parseInt(year) - 1 + "-12-26");
                } else {
                    haspMap.put("startTime", year + "-" + (iMonth - 1) + "-26");
                }
                haspMap.put("endTime", year + "-" + month + "-25");
            }
        }
        return haspMap;
    }

    /**
     * 获取某一年的数据（是从上一年的12-26到今年的12-25）
     *
     * @param year
     * @return
     */
    public static Map<String, Object> packYearMapParam(String year) {
        if (StrUtil.isBlank(year)) {
            throw new BaseException("年份不能为空");
        }
        Map<String, Object> haspMap = new HashMap<>();
        if (StrUtil.isNotBlank(year)) {
            haspMap.put("startDate", getLastYear(year) + "-12-26");
            haspMap.put("endDate", year + "-12-25");
        }
        return haspMap;
    }

    /**
     * 获取某年某月的数据
     *
     * @param yearMonth 格式是：年-月
     * @return
     */
    public static String packYearMonthMapParamStart(String yearMonth) {
        if (StrUtil.isBlank(yearMonth)) {
            throw new BaseException("年份，月份不能为空");
        }
        String startYear = yearMonth.substring(0, 4);
        String startMonthStr = yearMonth.substring(5, 7);
        int startIMonth = Integer.parseInt(startMonthStr);
        if (startIMonth == 1) {
            return Integer.parseInt(startYear) - 1 + "-12-26";
        } else {
            return startYear + "-" + (startIMonth - 1) + "-26";
        }
    }

    /**
     * 获取某年某月的数据
     *
     * @param yearMonth 格式是：年-月
     * @return
     */
    public static String packYearMonthMapParamEnd(String yearMonth) {
        if (StrUtil.isBlank(yearMonth)) {
            throw new BaseException("年份，月份不能为空");
        }
        String startYear = yearMonth.substring(0, 4);
        String startMonthStr = yearMonth.substring(5, 7);
        return startYear + "-" + startMonthStr + "-25";
    }


    public static String getLastYear(String year) {
        return String.valueOf(Integer.parseInt(year) - 1);
    }

    public static String IDCardValidate(String IDStr) {
        String tipInfo = "";// 记录错误信息
        String Ai = "";
        // 判断号码的长度 15位或18位
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            tipInfo = "身份证号码长度应该为15位或18位。";
            return tipInfo;
        }
        // 18位身份证前17位位数字，如果是15位的身份证则所有号码都为数字
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (isNumeric(Ai) == false) {
            tipInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
            return tipInfo;
        }
        return tipInfo;
    }

    /**
     * 判断字符串是否为数字,0-9重复0次或者多次
     *
     * @param strnum
     * @return
     */
    private static boolean isNumeric(String strnum) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(strnum);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

}
