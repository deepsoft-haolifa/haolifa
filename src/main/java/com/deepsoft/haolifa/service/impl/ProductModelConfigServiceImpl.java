package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.deepsoft.haolifa.cache.CacheKeyManager;
import com.deepsoft.haolifa.cache.NoCacheLoadCallBack;
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


@Service
public class ProductModelConfigServiceImpl extends BaseService implements ProductModelConfigService {

    @Autowired
    private ProductModelConfigMapper productModelConfigMapper;

    @Autowired
    private RedisDao redisDao;


    @Override
    public List<ProductModelConfig> getList(String type, String indexRule) {

        List<ProductModelConfig> productModelConfigs = redisDao.queryCache(CacheKeyManager.cacheKeyProductModelRule(), new TypeReference<List<ProductModelConfig>>() {
        }, new NoCacheLoadCallBack<List<ProductModelConfig>>() {
            @Override
            public List<ProductModelConfig> load() throws Exception {
                return productModelConfigMapper.selectByExample(new ProductModelConfigExample());
            }
        });
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(indexRule)) {
            productModelConfigs = productModelConfigs.stream().filter(e -> e.getMaterialType().equals(type)).filter(e -> e.getIndexRule() == indexRule).collect(Collectors.toList());
        }
        return productModelConfigs;
    }

    @Override
    public int add(ProductModelConfig model) {
        int insertSelective = productModelConfigMapper.insertSelective(model);
        if (insertSelective > 0) {
            redisDao.del(CacheKeyManager.cacheKeyProductModelRule().key);
        }
        return insertSelective;
    }

    @Override
    public int delete(String type, String indexRule) {
        int delete = productModelConfigMapper.deleteByExample(new ProductModelConfigExample() {{
            or().andMaterialTypeEqualTo(type).andIndexRuleEqualTo(indexRule);
        }});
        if (delete > 0) {
            redisDao.del(CacheKeyManager.cacheKeyProductModelRule().key);
        }
        return delete;
    }

    @Override
    public int update(ProductModelConfig model) {
        int update = productModelConfigMapper.updateByPrimaryKeySelective(model);
        if (update > 0) {
            redisDao.del(CacheKeyManager.cacheKeyProductModelRule().key);
        }
        return update;
    }
}
