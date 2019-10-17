package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CacheKey.TOTAL_INVENTORY_MATERIAL;
import static com.deepsoft.haolifa.constant.CacheKey.TOTAL_MONEY_ORDER;

import com.deepsoft.haolifa.cache.redis.RedisDaoImpl;
import com.deepsoft.haolifa.constant.CommonEnum.Consts;
import com.deepsoft.haolifa.dao.repository.MaterialMapper;
import com.deepsoft.haolifa.dao.repository.OrderProductMapper;
import com.deepsoft.haolifa.model.domain.Material;
import com.deepsoft.haolifa.model.domain.MaterialExample;
import com.deepsoft.haolifa.model.domain.OrderProduct;
import com.deepsoft.haolifa.model.domain.OrderProductExample;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.StatisticsService;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {

  @Autowired
  private MaterialMapper materialMapper;
  @Autowired
  private OrderProductMapper orderProductMapper;
  @Autowired
  private RedisDaoImpl redisDao;

  @Override
  public ResultBean totalInventory() {
    Double totalInvertory = 0.0;
    String redisValue = redisDao.get(TOTAL_INVENTORY_MATERIAL);
    if(StringUtils.isNotEmpty(redisValue)) {
      return ResultBean.success(Double.valueOf(redisValue));
    } else {
      MaterialExample example = new MaterialExample();
      example.createCriteria().andIsDeleteEqualTo(Consts.NO.code);
      List<Material> materials = materialMapper.selectByExample(example);
      for (int i = 0; i < materials.size(); i++) {
        Material material = materials.get(i);
        totalInvertory += material.getPrice().doubleValue() * (material.getCurrentQuantity() + material.getLockQuantity());
      }
      redisDao.set(TOTAL_INVENTORY_MATERIAL, totalInvertory.toString(),12l, TimeUnit.HOURS);
    }
    return ResultBean.success(totalInvertory);
  }

  @Override
  public ResultBean totalOrders() {
    Double totalMoney = 0.0;
    String redisTotalMoney = redisDao.get(TOTAL_MONEY_ORDER);
    if(StringUtils.isNotEmpty(redisTotalMoney)) {
      return ResultBean.success(Double.valueOf(redisTotalMoney));
    } else {
      List<OrderProduct> orderProducts = orderProductMapper.selectByExample(new OrderProductExample());
      for (int i = 0; i < orderProducts.size(); i++) {
        totalMoney += orderProducts.get(i).getTotalPrice().doubleValue();
      }
    }
    return ResultBean.success(totalMoney);
  }
}