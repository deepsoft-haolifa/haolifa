package com.deepsoft.haolifa.util;

import cn.hutool.core.util.StrUtil;

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
}
