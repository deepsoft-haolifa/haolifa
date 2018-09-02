package com.deepsoft.haolifa.model.dto.redis;

import lombok.Data;

import java.util.List;

@Data
public class RedisLockMaterial {

    /**
     * 原料图号
     */
    private String materialGraphNo;

    private List<RedisMaterialInfo> list;
}
