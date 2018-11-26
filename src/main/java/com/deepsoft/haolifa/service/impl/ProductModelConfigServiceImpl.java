package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.deepsoft.haolifa.cache.redis.RedisDao;
import com.deepsoft.haolifa.dao.repository.ProductModelConfigMapper;
import com.deepsoft.haolifa.model.domain.ProductModelConfig;
import com.deepsoft.haolifa.model.domain.ProductModelConfigExample;
import com.deepsoft.haolifa.service.ProductModelConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.deepsoft.haolifa.constant.CacheConsts.REDIS_KEY_PRODUCT_MODEL_RULE;


@Service
public class ProductModelConfigServiceImpl extends BaseService implements ProductModelConfigService {

    @Autowired
    private ProductModelConfigMapper productModelConfigMapper;

    @Autowired
    private RedisDao redisDao;

    final static String redisKey = REDIS_KEY_PRODUCT_MODEL_RULE;


    @Override
    public List<ProductModelConfig> getList(int type, String indexRule) {
        List<ProductModelConfig> productModelConfigs = null;
        String redisValue = redisDao.get(redisKey);
        if (StringUtils.isNotBlank(redisValue)) {
            productModelConfigs = JSONObject.parseObject(redisValue, new TypeReference<List<ProductModelConfig>>() {
            });
            if (type > 0 && StringUtils.isNotBlank(indexRule)) {
                productModelConfigs = productModelConfigs.stream().filter(e -> e.getType() == type).filter(e -> e.getIndexRule() == indexRule).collect(Collectors.toList());
            }
        } else {// 从数据库中查
            productModelConfigs = productModelConfigMapper.selectByExample(new ProductModelConfigExample());
            if (type > 0 && StringUtils.isNotBlank(indexRule)) {
                productModelConfigs = productModelConfigs.stream().filter(e -> e.getType() == type).filter(e -> e.getIndexRule() == indexRule).collect(Collectors.toList());
            }
            redisDao.set(redisKey, JSONObject.toJSONString(productModelConfigs));
            redisDao.expire(redisKey, 3600 * 24 * 30);
        }
        return productModelConfigs;
    }

    @Override
    public int add(ProductModelConfig model) {
        int insertSelective = productModelConfigMapper.insertSelective(model);
        if (insertSelective > 0) {
            redisDao.del(redisKey);
        }
        return insertSelective;
    }

    @Override
    public int delete(int type, String indexRule) {
        int delete = productModelConfigMapper.deleteByExample(new ProductModelConfigExample() {{
            or().andTypeEqualTo((byte) type).andIndexRuleEqualTo(indexRule);
        }});
        if (delete > 0) {
            redisDao.del(redisKey);
        }
        return delete;
    }

    @Override
    public int update(ProductModelConfig model) {
        int update = productModelConfigMapper.updateByPrimaryKeySelective(model);
        if (update > 0) {
            redisDao.del(redisKey);
        }
        return update;
    }
}
