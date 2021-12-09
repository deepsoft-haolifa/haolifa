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
     * @param yearMonth 格式是：年-月
     * @return
     */
    public static String packYearMonthMapParam(String yearMonth) {
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


    public static String getLastYear(String year) {
        return String.valueOf(Integer.parseInt(year) - 1);
    }

}
