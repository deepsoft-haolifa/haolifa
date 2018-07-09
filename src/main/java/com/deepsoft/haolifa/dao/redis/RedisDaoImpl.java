package com.deepsoft.haolifa.dao.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisDaoImpl
 * @date: 2017-11-24 10:03
 */
@Repository
@Slf4j
public class RedisDaoImpl implements RedisDao {

    private final static int RETRY_TIMES = 3;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean exists(String key) {
        log.info("exists==>key={}", key);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.hasKey(key)).get();
    }

    @Override
    public String get(String key) {
        log.info("get==>key={}", key);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForValue().get(key)).get();
    }

    @Override
    public void set(String key, String value) {
        log.info("set==>key={}; value={}", key, value);
        TryBase.ofr(RETRY_TIMES, () -> stringRedisTemplate.opsForValue().set(key, value));
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit unit) {
        log.info("set==>key={}; set={}; timeOut={}; unit={}", key, value, timeout, unit);
        TryBase.ofr(RETRY_TIMES, () -> stringRedisTemplate.boundValueOps(key).set(value, timeout, unit));
    }

    @Override
    public Long incrBy(String key, long delta) {
        log.info("incrBy==>key={}; delta={}", key, delta);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForValue().increment(key, delta)).get();
    }

    @Override
    public void del(String key) {
        log.info("del==>key={}", key);
        TryBase.ofr(RETRY_TIMES, () -> stringRedisTemplate.delete(key));
    }

    @Override
    public void expire(String key, long second) {
        log.info("expire==>key={}; second={}", key, second);
        TryBase.ofr(RETRY_TIMES, () -> stringRedisTemplate.expire(key, second, TimeUnit.SECONDS));
    }

    @Override
    public Long ttl(String key) {
        log.info("ttl==>key={}", key);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.getExpire(key)).get();
    }

    @Override
    public Object hget(String key, String field) {
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForHash().hasKey(key, field)).get()
                ? String.valueOf(TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForHash().get(key, field)).get())
                : null;
    }

    @Override
    public Long hashSize(String key) {
        log.info("hashSize==>key={}", key);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForHash().size(key)).get();
    }

    @Override
    public Map<String, String> getHash(String redisKey) {
        return getHashKeyStartsWith(redisKey, null);
    }

    @Override
    public Map<String, String> getHashKeyStartsWith(String redisKey, String hashKeyPrefix) {
        log.info("getHashKeyStartsWith==>key={}; hashKeyPrefix={}", redisKey, hashKeyPrefix);
        Map<String, String> hash = new HashMap<>();
        List<String> hashKeys = getHashKeys(redisKey);
        if (CollectionUtils.isEmpty(hashKeys)) {
            return hash;
        }
        for (String hashKey : hashKeys) {
            if ("" != hashKeyPrefix && !hashKey.startsWith(hashKeyPrefix)) {
                continue;
            }
            String value = getHash(redisKey, hashKey);
            if (Objects.nonNull(value) && "" != value) {
                hash.put(hashKey, value);
            }
        }
        return hash;
    }


    @Override
    public List<String> getHashKeys(String redisKey) {
        log.info("getHashKeys==>key={}", redisKey);
        List<String> hashKeys = new ArrayList<>();
        Set<Object> keys = TryBase.ofc(
                RETRY_TIMES,
                () -> stringRedisTemplate.opsForHash().keys(redisKey)
        ).get();
        if (CollectionUtils.isEmpty(keys)) {
            return hashKeys;
        }
        for (Object key : keys) {
            hashKeys.add(String.valueOf(key));
        }
        return hashKeys;
    }

    @Override
    public Map<String, String> getHashKeyEndsWith(String redisKey, String hashKeySuffix) {
        log.info("getHashKeyEndsWith==>key={}; hashKeySuffix={}", redisKey, hashKeySuffix);
        Map<String, String> hash = new HashMap<>();
        List<String> hashKeys = getHashKeys(redisKey);
        if (CollectionUtils.isEmpty(hashKeys)) {
            return hash;
        }
        for (String hashKey : hashKeys) {
            if ("" != hashKeySuffix && !hashKey.endsWith(hashKeySuffix)) {
                continue;
            }
            String value = getHash(redisKey, hashKey);
            if (Objects.nonNull(value)) {
                hash.put(hashKey, value);
            }
        }
        return hash;
    }

    @Override
    public String getHash(String redisKey, String hashKey) {
        log.info("getHash==>key={}; field={}", redisKey, hashKey);
        return TryBase.ofc(RETRY_TIMES,
                () -> stringRedisTemplate.opsForHash().hasKey(redisKey, hashKey)).get() ?
                String.valueOf(TryBase.ofc(RETRY_TIMES,
                        () -> stringRedisTemplate.opsForHash().get(redisKey, hashKey)).get()) :
                null;
    }

    @Override
    public void putHash(String redisKey, String hashKey, String hashValue) {
        log.info("putHash==>key={}; field={}; value={}", redisKey, hashKey, hashValue);
        TryBase.ofr(
                RETRY_TIMES,
                () -> stringRedisTemplate.opsForHash().put(redisKey, hashKey, hashValue)
        );
    }

    @Override
    public void putHash(String redisKey, Map<String, String> map) {
        log.info("putHash==>key={}; map={}", redisKey, map);
        TryBase.ofr(
                RETRY_TIMES,
                () -> stringRedisTemplate.opsForHash().putAll(redisKey, map)
        );
    }

    @Override
    public void delHash(String redisKey, String hashKey) {
        log.info("delHash==>key={}; field={}", redisKey, hashKey);
        TryBase.ofr(
                RETRY_TIMES,
                () -> stringRedisTemplate.opsForHash().delete(redisKey, hashKey)
        );
    }

    @Override
    public String hset(String key, String field, Object value) {
        log.info("hset==>key={}; field={}; value={}", key, field, value);
        TryBase.ofr(RETRY_TIMES, () -> stringRedisTemplate.opsForHash().put(key, field, value));
        return key;
    }

    @Override
    public void hmset(String key, Map<String, String> tuple) {
        log.info("hmset==>key={}; tuple={}", key, tuple);
        TryBase.ofr(RETRY_TIMES, () -> stringRedisTemplate.opsForHash().putAll(key, tuple));
    }

    @Override
    public void hincrBy(String key, String field, long delta) {
        log.info("hincrBy==>key={}; field={}; delta={}", key, field, delta);
        TryBase.ofr(RETRY_TIMES, () -> stringRedisTemplate.opsForHash().increment(key, field, delta));
    }

    @Override
    public Set<Object> hkeys(String key) {
        log.info("hkeys==>key={}", key);
        Set<Object> keys = TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForHash().keys(key)).get();
        return keys;
    }

    @Override
    public Map<String, Object> hgetAll(String key) {
        log.info("hgetAll==>key={}", key);
        Map<Object, Object> objectMap = TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForHash().entries(key)).get();
        Map<String, Object> returnMap = new HashMap<>();
        for (Map.Entry<Object, Object> entry : objectMap.entrySet()) {
            returnMap.put(entry.getKey().toString(), entry.getValue());
        }
        return returnMap;
    }

    @Override
    public boolean hexists(String key, String field) {
        log.info("hexists==>key={}; field={}", key, field);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForHash().hasKey(key, field)).get();
    }

    @Override
    public boolean sismember(String key, Object value) {
        log.info("sismember==>key={}; value={}", key, value);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForSet().isMember(key, value)).get();
    }

    @Override
    public Set<String> smembers(String key) {
        log.info("smembers==>key={}", key);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForSet().members(key)).get();
    }


    @Override
    public void removesetkv(String key, String... values) {
        log.info("removesetkv==>key={}; values={}", key, Arrays.toString(values));
        TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForSet().remove(key, values));
    }

    @Override
    public long setsize(String key) {
        log.info("setsize==>key={}", key);
        return stringRedisTemplate.opsForSet().size(key);
    }

    @Override
    public void convertAndSend(String channel, String message) {
        log.info("convertAndSend==>channel={}; message={}", channel, message);
        stringRedisTemplate.convertAndSend(channel, message);
    }

    @Override
    public String rPopAndLpush(String key, String keyBak) {
        log.info("rPopAndLpush==>key={}; keyBak={}", key, keyBak);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForList().rightPopAndLeftPush(key, keyBak)).get();
    }

    @Override
    public Long lPush(String key, String value) {
        log.info("lPush==>key={}; value={}", key, value);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForList().leftPush(key, value)).get();
    }

    @Override
    public Long listRemove(String key, String value) {
        log.info("listRemove==>key={}; value={}", key, value);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForList().remove(key, 0L, value)).get();
    }

    @Override
    public Long getListLen(String key) {
        log.info("getListLen==>key={}", key);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.opsForList().size(key)).get();
    }

    @Override
    public void sadd(String key, String... values) {
        log.info("getListLen==>key={}; values={}", key, Arrays.asList(values));
        TryBase.ofr(RETRY_TIMES, () -> stringRedisTemplate.opsForSet().add(key, values));
    }

    @Override
    public List<String> scanParams(String pattern) {
        log.info("getListLen==>pattern={}", pattern);
        return TryBase.ofc(RETRY_TIMES, () -> stringRedisTemplate.execute(new RedisCallback<List<String>>() {
            @Override
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
                List<String> list = new ArrayList<>();
                StringRedisConnection stringRedisConnection = (StringRedisConnection) connection;
                ScanOptions scanOptions = ScanOptions.scanOptions().match(pattern).count(connection.dbSize()).build();
                Cursor<byte[]> c = stringRedisConnection.scan(scanOptions);
                while (c.hasNext()) {
                    list.add(new String(c.next()));

                }
                return list;
            }
        })).get();
    }


}
