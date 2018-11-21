package com.deepsoft.haolifa.constant;

/**
 * @description: 缓存相关常量（redisKey）
 **/
public class CacheConsts {

    public static final int RETRY_TIMES = 3;

    /**
     * 成品模型redis
     */
    public static final String REDIS_KEY_PRODUCT_MODEL_RULE = "deepsoft:haolifa:cache:productModelRule";

    /**
     * 核料，锁定的零件（包括数量和库位）
     */
    public static final String REDIS_KEY_LOCK_MATERIAL = "deepsoft:haolifa:lockMaterial:";

    /**
     * 用户缓存
     */
    public static final String REDIS_KEY_USER_CACHE = "deepsoft:haolifa:cache:user：";
}
