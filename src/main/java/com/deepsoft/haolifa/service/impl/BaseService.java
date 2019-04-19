package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CacheKey.INSPECT_NO_KEY;

import com.deepsoft.haolifa.cache.redis.RedisDao;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
    @Autowired
    RedisDao redisDao;
    @Autowired
    SysUserService sysUserService;
    /**
     * 获取登录用户id
     *
     * @return
     */
    protected int getLoginUserId() {
        CustomUser customUser = sysUserService.selectLoginUser();
        return customUser != null ? customUser.getId() : 1;
    }

    protected String createSerialNumber(String prefix, String keyTemplate) {
        StringBuilder stringBuilder = new StringBuilder();
        String dateStr = DateFormatterUtils.formatterDateString(DateFormatterUtils.THIRD_FORMATTERPATTERN, new Date());
        String redisKey = String.format(keyTemplate, dateStr);
        long serialNumber = redisDao.incrBy(String.format(keyTemplate, dateStr), 1l);
        redisDao.expire(redisKey, TimeUnit.DAYS, 1);
        stringBuilder
            .append(prefix)
            .append(dateStr)
            .append(serialNumber);
        return stringBuilder.toString();
    }
}
