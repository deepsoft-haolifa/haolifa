package com.deepsoft.haolifa.cache;

import java.util.concurrent.TimeUnit;

/**
 * 缓存key管理类
 */
public class CacheKeyManager {
    /**
     * 订单缓存
     *
     * @return
     */
    public static CacheKeyVo cacheKeyOrderInfo(String orderNo) {
        return new CacheKeyVo("deepsoft:haolifa:cache:orderInfo:" + orderNo, 5L, TimeUnit.DAYS);
    }

    /**
     * 成品模型规则（解析成品由哪些零件组成的规则）redis
     *
     * @return
     */
    public static CacheKeyVo cacheKeyProductModelRule() {
        return new CacheKeyVo("deepsoft:haolifa:cache:productModelRule", 60L, TimeUnit.DAYS);
    }

    /**
     * 用户缓存
     */
    public static CacheKeyVo cacheKeyUserCache(int userId) {
        return new CacheKeyVo("deepsoft:haolifa:cache:user:", 60L, TimeUnit.DAYS);
    }

    /**
     * 核料过程中 正在机加工和正在喷涂的数量
     * 1. 初步核料的时候，如果有正在机加工和正在喷涂的图号，会添加这个redis；重新选择初步核料，要清空这个redis
     * 2. 然后再点核料成功的时候，会根据订单号获取这个订单有多少正在机加工和正在喷涂的，把数量锁定；
     * 3. 数量锁定完，这个redis 就可以删除；
     */
    public static CacheKeyVo dbKeylockQuantity(String orderNo) {
        return new CacheKeyVo("deepsoft:haolifa:db:lockQuantity:" + orderNo, 12L, TimeUnit.HOURS);
    }


    public static class CacheKeyVo {
        public String key;
        public Long timeOut;
        public TimeUnit timeUnit;
        public Long seconds;

        /**
         * @param key
         * @param timeOut seconds
         */
        CacheKeyVo(String key, Long timeOut, TimeUnit timeUnit) {
            this.key = key;
            this.timeOut = timeOut;
            this.timeUnit = timeUnit;
            switch (timeUnit) {
                case SECONDS:
                    this.seconds = this.timeOut;
                    break;
                case MINUTES:
                    this.seconds = this.timeOut * 60;
                    break;
                case HOURS:
                    this.seconds = this.timeOut * 60 * 60;
                    break;
                case DAYS:
                    this.seconds = this.timeOut * 60 * 60 * 24;
                    break;
                default:
                    break;
            }
        }
    }
}
