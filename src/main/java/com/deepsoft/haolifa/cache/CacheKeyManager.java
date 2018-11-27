package com.deepsoft.haolifa.cache;

import java.util.concurrent.TimeUnit;

/**
 * 缓存key管理类
 */
public class CacheKeyManager {
    /**
     * order cache
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
