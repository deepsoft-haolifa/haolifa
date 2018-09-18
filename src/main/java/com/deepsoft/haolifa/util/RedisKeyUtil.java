package com.deepsoft.haolifa.util;

import com.deepsoft.haolifa.constant.CacheConsts;

public class RedisKeyUtil {

    public static String getUserKey(Integer userId){
        return CacheConsts.REDIS_KEY_USER_CACHE + userId;
    }

}
