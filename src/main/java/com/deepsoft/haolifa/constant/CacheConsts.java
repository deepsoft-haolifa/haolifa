package com.deepsoft.haolifa.constant;

/**
 * @description: 缓存相关常量（redisKey）
 **/
public class CacheConsts {

    public static final int RETRY_TIMES = 3;

    /**
     * haolifa demo
     */
    public static final String REDIS_KEY__USERBASE_INFO = "deepsoft:haolifa:userBaseInfo:";

    /**
     * 核料，锁定的零件（包括数量和库位）
     */
    public static final String REDIS_KEY_LOCK_MATERIAL = "deepsoft:haolifa:lockMaterial:";
}
