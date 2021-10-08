package com.deepsoft.haolifa.util;

import cn.hutool.poi.excel.ExcelReader;
import com.deepsoft.haolifa.annotation.ExcelHandle;
import com.google.common.collect.Maps;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @Author liuyaofei
 * @Date create in 下午2:49 2021/9/11
 * @description 导入、导出
 */
public class ExcelUtils {

    public static List<?> importExcelReadColumn(InputStream inputStream, Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        Map<String, String> headerMap = Maps.newHashMap();
        for (Field field : declaredFields) {
            ExcelHandle annotation = field.getAnnotation(ExcelHandle.class);
            if (annotation == null) {
                continue;
            }
            headerMap.put(annotation.name(), field.getName());
        }
        ExcelReader writer = cn.hutool.poi.excel.ExcelUtil.getReader(inputStream);
        writer.setHeaderAlias(headerMap);
        List<?> list = writer.readAll(clazz);
        return list;
    }
}
