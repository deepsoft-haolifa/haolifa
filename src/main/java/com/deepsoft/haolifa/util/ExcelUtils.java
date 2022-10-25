package com.deepsoft.haolifa.util;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.deepsoft.haolifa.annotation.ExcelHandle;
import org.apache.commons.collections4.CollectionUtils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author liuyaofei
 * @Date create in 下午2:49 2021/9/11
 * @description 导入、导出
 */
public class ExcelUtils {

    private static final String EXCEL_SUFFIX = ".xls";

    private static final String PATH = "/tmp/";

    public static List<?> importExcelReadColumn(InputStream inputStream, Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        Map<String, String> headerMap = new HashMap<>();
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

    public static ExcelWriter exportExcel(List list, Class<?> clazz) {
        String fileName = PATH + System.currentTimeMillis() + EXCEL_SUFFIX;

        cn.hutool.poi.excel.ExcelWriter writer = ExcelUtil.getWriter(fileName,"sheet");
        writer.autoSizeColumn(0);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            ExcelHandle annotations = field.getAnnotation(ExcelHandle.class);
            if (annotations != null) {
                writer.addHeaderAlias(field.getName(), annotations.name());
            }
        }
        writer.setOnlyAlias(true);
        writer.write(list, true);
        return writer;
    }
}
