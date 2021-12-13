package com.deepsoft.haolifa.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * 实体转换工具类
 */
public class BeanCopyUtils {

    private static Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<String, BeanCopier>();

    public static void copyProperties(Object source, Object target) {
        String beanKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }


    public static <S, T> List<T> copyPropertiesForNewList(Collection<S> sourceList, Supplier<T> creator) {
        if (org.springframework.util.CollectionUtils.isEmpty(sourceList)) {
            return new ArrayList();
        } else {
            Objects.requireNonNull(creator, "The creator is required.");
            List<T> targetList = new ArrayList();
            Iterator var3 = sourceList.iterator();

            while(var3.hasNext()) {
                S source = (S) var3.next();
                targetList.add(copyProperties(source, creator));
            }

            return targetList;
        }
    }

    public static <S, T> T copyProperties(S source, Supplier<T> creator) {
        Objects.requireNonNull(source, "The source is required.");
        Objects.requireNonNull(creator, "The creator is required.");
        T target = creator.get();
        Objects.requireNonNull(target, "The target is required.");
        org.springframework.beans.BeanUtils.copyProperties(source, target);
        return target;
    }
}
