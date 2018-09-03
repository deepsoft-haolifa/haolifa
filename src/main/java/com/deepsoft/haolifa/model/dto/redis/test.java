package com.deepsoft.haolifa.model.dto.redis;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {

        List<RedisLockMaterial> redisLockMaterials = new ArrayList<>();
        RedisLockMaterial redisLockMaterial = new RedisLockMaterial();
        redisLockMaterial.setMaterialGraphNo("123");
        List<RedisMaterialInfo> redisMaterialInfos = new ArrayList<>();
        RedisMaterialInfo redisMaterialInfo = new RedisMaterialInfo() {{
            setStoreRoomId(1);
            setStoreRoomRackId(2);
            setStoreRoomRackNo("123");
            setLockQuantity(100);
        }};
        redisMaterialInfos.add(redisMaterialInfo);
        redisLockMaterial.setList(redisMaterialInfos);

        RedisLockMaterial redisLockMaterial1 = new RedisLockMaterial();
        redisLockMaterial1.setMaterialGraphNo("234");
        List<RedisMaterialInfo> redisMaterialInfos1 = new ArrayList<>();
        RedisMaterialInfo redisMaterialInfo1 = new RedisMaterialInfo() {{
            setStoreRoomId(1);
            setStoreRoomRackId(2);
            setStoreRoomRackNo("123");
            setLockQuantity(100);
        }};
        redisMaterialInfos1.add(redisMaterialInfo1);
        redisLockMaterial1.setList(redisMaterialInfos1);

        redisLockMaterials.add(redisLockMaterial);
        redisLockMaterials.add(redisLockMaterial1);

        System.out.println(JSONObject.toJSON(redisLockMaterials));
    }
}
