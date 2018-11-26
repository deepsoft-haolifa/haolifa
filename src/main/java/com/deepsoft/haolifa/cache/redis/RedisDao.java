package com.deepsoft.haolifa.cache.redis;

import com.alibaba.fastjson.TypeReference;
import com.deepsoft.haolifa.cache.CacheKeyManager;
import com.deepsoft.haolifa.cache.NoCacheLoadCallBack;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisDao
 * @date: 2017-11-24 10:03
 */
public interface RedisDao {

    boolean exists(String key);

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit unit);

    Long incrBy(String key, long delta);

    void del(String key);

    void expire(String key, long second);

    Long ttl(String key);

    Object hget(String key, String field);

    Long hashSize(String key);

    List<String> getHashKeys(String redisKey);

    Map<String, String> getHashKeyStartsWith(String redisKey, String hashKeyPrefix);

    Map<String, String> getHashKeyEndsWith(String redisKey, String hashKeySuffix);

    String getHash(String redisKey, String hashKey);

    @Deprecated
    Map<String, String> getHash(String redisKey);

    void putHash(String redisKey, String hashKey, String hashValue);

    void putHash(String redisKey, Map<String, String> map);

    void delHash(String redisKey, String hashKey);

    String hset(String key, String field, Object value);

    void hmset(String key, Map<String, String> map);

    void hincrBy(String key, String field, long data);

    Set<Object> hkeys(String key);

    Map<String, Object> hgetAll(String key);

    boolean hexists(String key, String field);

    boolean sismember(String key, Object value);

    Set<String> smembers(String key);

    void sadd(String key, String... values);

    List<String> scanParams(String pattern);

    void removesetkv(String key, String... values);

    long setsize(String key);

    void convertAndSend(String channel, String message);

    String rPopAndLpush(String key, String keyBak);

    Long lPush(String key, String value);

    Long listRemove(String key, String value);

    Long getListLen(String key);

    <T> T queryCache(CacheKeyManager.CacheKeyVo cacheKeyVo, TypeReference<T> clazz, NoCacheLoadCallBack<T> callback);


}
