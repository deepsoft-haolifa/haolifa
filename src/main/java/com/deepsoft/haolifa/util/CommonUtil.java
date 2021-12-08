package com.deepsoft.haolifa.util;

import cn.hutool.core.util.StrUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.dto.BaseException;

import java.util.HashMap;
import java.util.Map;

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
            haspMap.put("endDate", year + "12-25");
        }
        return haspMap;
    }

    /**
     * 获取某年某月的数据
     *
     * @param startMonth 格式是：年-月
     * @param endMonth   格式是：年-月
     * @return
     */
    public static Map<String, Object> packYearMonthMapParam(String startMonth, String endMonth) {
        if (StrUtil.isBlank(startMonth) || StrUtil.isBlank(endMonth)) {
            throw new BaseException("年份，月份不能为空");
        }
        Map<String, Object> haspMap = new HashMap<>();
        String startYear = startMonth.substring(0, 4);
        String startMonthStr = startMonth.substring(5, 7);
        String endYear = endMonth.substring(0, 4);
        String endMonthStr = endMonth.substring(5, 7);
        int startIMonth = Integer.parseInt(startMonthStr);
        if (startIMonth == 1) {
            haspMap.put("startDate", Integer.parseInt(startYear) - 1 + "-12-26");
        } else {
            haspMap.put("startDate", startYear + "-" + (startIMonth - 1) + "-26");
        }
        int endIMonth = Integer.parseInt(endMonthStr);
        if (endIMonth == 1) {
            haspMap.put("endDate", Integer.parseInt(endYear) - 1 + "-12-26");
        } else {
            haspMap.put("endDate", endYear + "-" + (endIMonth - 1) + "-26");
        }
        return haspMap;
    }


    public static String getLastYear(String year) {
        return String.valueOf(Integer.parseInt(year) - 1);
    }

    public static void main(String[] args) {
        System.out.println(packYearMonthMapParam("2021-10", "2021-12"));
    }
}
