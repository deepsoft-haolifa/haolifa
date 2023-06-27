package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ProductionDailyPlanMapper;
import com.deepsoft.haolifa.dao.repository.ProductionDailyPlanMapper;
import com.deepsoft.haolifa.dao.repository.ValveSeatInspectHistoryMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.Accessory;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.InspectReason;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.order.OrderProductDTO;
import com.deepsoft.haolifa.model.dto.pay.PayCalculateDTO;
import com.deepsoft.haolifa.model.dto.productionPlan.ProductionDailyPlanConditionDto;
import com.deepsoft.haolifa.model.dto.productionPlan.ProductionDailyPlanReqDto;
import com.deepsoft.haolifa.model.dto.valveSeat.*;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.PayOrderUserRelationProcedureService;
import com.deepsoft.haolifa.service.ProductionDailyPlanService;
import com.deepsoft.haolifa.service.ProductionDailyPlanService;
import com.deepsoft.haolifa.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

import static com.deepsoft.haolifa.constant.CacheKey.VS_ENTRUST_NO_KEY;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.VS_NO_PREFIX_AC;

/**
 * @author murphy.he
 **/
@Slf4j
@Service
public class ProductionDailyPlanServiceImpl extends BaseService implements ProductionDailyPlanService {

    @Resource
    private ProductionDailyPlanMapper productionDailyPlanMapper;

    @Resource
    private OrderProductService orderProductService;

    @Override
    public int add(ProductionDailyPlanReqDto reqDto) {
        judgeSameOrder(reqDto.getOrderNo(), null);

        ProductionDailyPlan model = new ProductionDailyPlan();
        BeanUtil.copyProperties(reqDto, model);
        // 设置订单里面的相关信息
        getOrderInfo(model);
        model.setCreateUser(getLoginUserId());
        return productionDailyPlanMapper.insertSelective(model);
    }




    @Override
    public int update(ProductionDailyPlanReqDto reqDto) {
        judgeSameOrder(reqDto.getOrderNo(), reqDto.getId());

        ProductionDailyPlan model = new ProductionDailyPlan();
        // 设置订单里面的相关信息
        BeanUtil.copyProperties(reqDto, model);

        getOrderInfo(model);
        model.setUpdateUser(getLoginUserId());
        return productionDailyPlanMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(Integer id) {
        ProductionDailyPlan model = productionDailyPlanMapper.selectByPrimaryKey(id);
        if (!model.getPlanStatus().equals(CommonEnum.ProductionPlanStatus.WAIT.code)) {
            throw new BaseException("只有待完成才能操作");
        }
        return productionDailyPlanMapper.deleteByPrimaryKey(id);

    }

    @Override
    public PageDTO<ProductionDailyPlan> pageList(ProductionDailyPlanConditionDto pageDto) {
        ProductionDailyPlanExample example = new ProductionDailyPlanExample();
        ProductionDailyPlanExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(pageDto.getOrderNo())) {
            criteria.andOrderNoNotLike("%" + pageDto.getOrderNo() + "%");
        }
        if (StringUtils.isNotEmpty(pageDto.getPlanStatus())) {
            criteria.andPlanStatusEqualTo(pageDto.getPlanStatus());
        }
        if (Objects.nonNull(pageDto.getPlanDate())) {
            criteria.andPlanDateEqualTo(pageDto.getPlanDate());
        }
        if (Objects.nonNull(pageDto.getPlanFinishDate())) {
            criteria.andPlanFinishDateEqualTo( pageDto.getPlanDate());
        }

        Page<ProductionDailyPlan> pageList = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize(), "id desc")
            .doSelectPage(() -> productionDailyPlanMapper.selectByExample(example));
        PageDTO<ProductionDailyPlan> pageDtos = new PageDTO<>();
        BeanUtils.copyProperties(pageList, pageDtos);
        pageDtos.setList(pageList);
        return pageDtos;
    }

    /**
     * 获取订单号的信息
     * @param model
     */
    private void getOrderInfo(ProductionDailyPlan model) {
        String orderNo = model.getOrderNo();
        OrderProductDTO orderProductInfo = orderProductService.getOrderProductInfo(orderNo);
        model.setDeliveryDate(orderProductInfo.getDeliveryDate());
        model.setOrderNumber(orderProductInfo.getTotalCount());
    }
    /**
     * 判断订单号是否已经有日计划
     * @param orderNo 订单号
     * @param id 主键id 有值代表更新，无值代表新增
     */
    private void judgeSameOrder(String orderNo, Integer id) {
        ProductionDailyPlanExample example = new ProductionDailyPlanExample();
        ProductionDailyPlanExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<ProductionDailyPlan> productionDailyPlans = productionDailyPlanMapper.selectByExample(example);
        if (CollectionUtil.isNotEmpty(productionDailyPlans)) {
            ProductionDailyPlan productionDailyPlan = productionDailyPlans.get(0);
            // 如果是添加（id=null）或者是更新的id的orderNo不一样
            if (null == id || !id.equals(productionDailyPlan.getId())) {
                throw new BaseException("该订单号已经有生产日计划");
            }
        }
    }
}
