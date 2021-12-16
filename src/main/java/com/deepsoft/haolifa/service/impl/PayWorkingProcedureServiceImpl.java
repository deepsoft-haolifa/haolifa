package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.collection.ArrayIter;
import com.deepsoft.haolifa.dao.repository.OrderProductAssociateMapper;
import com.deepsoft.haolifa.dao.repository.PayUserMapper;
import com.deepsoft.haolifa.dao.repository.PayUserRelationProcedureMapper;
import com.deepsoft.haolifa.dao.repository.PayWorkingProcedureMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayHourQuotaDTO;
import com.deepsoft.haolifa.model.dto.pay.PayProductCapacityDTO;
import com.deepsoft.haolifa.model.dto.pay.PayWorkingProcedureDTO;
import com.deepsoft.haolifa.model.vo.PayUserProcedureVO;
import com.deepsoft.haolifa.service.PayProductionCapacityService;
import com.deepsoft.haolifa.service.PayWorkingProcedureService;
import com.deepsoft.haolifa.util.BeanCopyUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 人员管理
 */
@Service
public class PayWorkingProcedureServiceImpl extends BaseService implements PayWorkingProcedureService {
    @Resource
    private PayWorkingProcedureMapper payWorkingProcedureMapper;
    @Resource
    private OrderProductAssociateMapper orderProductAssociateMapper;
    @Resource
    private PayUserMapper payUserMapper;
    @Resource
    private PayProductionCapacityService payProductionCapacityService;

    @Override
    public ResultBean pageInfo(PayWorkingProcedureDTO model) {
        PayWorkingProcedureExample example = new PayWorkingProcedureExample();
        PayWorkingProcedureExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(model.getSerial())) {
            criteria.andSerialEqualTo(model.getSerial());
        }
        if (StringUtils.isNotBlank(model.getWorkshopName())) {
            criteria.andWorkshopNameLike("%" + model.getWorkshopName() + "%");
        }
        if (StringUtils.isNotBlank(model.getWorkType())) {
            criteria.andWorkTypeLike("%" + model.getWorkType() + "%");
        }
        if (StringUtils.isNotBlank(model.getProductModel())) {
            criteria.andProductModelEqualTo(model.getProductModel());
        }
        if (StringUtils.isNotBlank(model.getPostCapability())) {
            criteria.andPostCapabilityLike("%" + model.getPostCapability() + "%");
        }
        if (StringUtils.isNotBlank(model.getPostName())) {
            criteria.andPostNameLike("%" + model.getPostName() + "%");
        }
        example.setOrderByClause("id desc");
        Page<PayWorkingProcedure> payWorkingProcedures = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> payWorkingProcedureMapper.selectByExample(example));
        PageDTO<PayWorkingProcedure> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payWorkingProcedures, pageDTO);
        pageDTO.setList(payWorkingProcedures);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean getAllList(PayWorkingProcedureDTO model) {
        PayWorkingProcedureExample example = new PayWorkingProcedureExample();
        PayWorkingProcedureExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(model.getSerial())) {
            criteria.andSerialEqualTo(model.getSerial());
        }
        if (StringUtils.isNotBlank(model.getWorkshopName())) {
            criteria.andWorkshopNameLike("%" + model.getWorkshopName() + "%");
        }
        if (StringUtils.isNotBlank(model.getWorkType())) {
            criteria.andWorkTypeLike("%" + model.getWorkType() + "%");
        }
        if (StringUtils.isNotBlank(model.getProductModel())) {
            criteria.andProductModelEqualTo(model.getProductModel());
        }
        if (StringUtils.isNotBlank(model.getPostCapability())) {
            criteria.andPostCapabilityLike("%" + model.getPostCapability() + "%");
        }
        if (StringUtils.isNotBlank(model.getPostName())) {
            criteria.andPostNameLike("%" + model.getPostName() + "%");
        }
        List<PayWorkingProcedure> payWorkingProcedures = payWorkingProcedureMapper.selectByExample(example);
        return ResultBean.success(payWorkingProcedures);
    }

    @Override
    public ResultBean save(PayWorkingProcedureDTO model) {
        PayWorkingProcedure payWorkingProcedure = new PayWorkingProcedure();
        BeanUtils.copyProperties(model, payWorkingProcedure);
        payWorkingProcedure.setCreateTime(new Date());
        payWorkingProcedure.setUpdateTime(new Date());
        payWorkingProcedure.setCreateUser(getLoginUserName());
        payWorkingProcedure.setUpdateUser(getLoginUserName());
        payWorkingProcedureMapper.insert(payWorkingProcedure);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        return ResultBean.success(payWorkingProcedureMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResultBean edit(PayWorkingProcedureDTO model) {
        PayWorkingProcedure payWorkingProcedure = new PayWorkingProcedure();
        BeanUtils.copyProperties(model, payWorkingProcedure);
        payWorkingProcedure.setUpdateTime(new Date());
        payWorkingProcedure.setUpdateUser(getLoginUserName());
        payWorkingProcedureMapper.updateByPrimaryKeySelective(payWorkingProcedure);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer id) {
        return ResultBean.success(payWorkingProcedureMapper.deleteByPrimaryKey(id));
    }

    @Override
    public ResultBean assignTask(String orderNo) {
        OrderProductAssociateExample example = new OrderProductAssociateExample();
        example.createCriteria().andOrderNoEqualTo(orderNo);
        List<OrderProductAssociate> list = orderProductAssociateMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            ResultBean.success(null);
        }
        List<PayProductionCapacity> payProductionCapacitieList = new ArrayList<>();
        for (OrderProductAssociate orderProductAssociate : list) {
            PayWorkingProcedureDTO payWorkingProcedure = new PayWorkingProcedureDTO();
            //
            String model = orderProductAssociate.getProductModel().substring(0, 4);
            payWorkingProcedure.setProductModel(model);
            List<PayWorkingProcedure> payWorkingProcedures = payWorkingProcedureMapper.selectList(payWorkingProcedure);
            if (CollectionUtils.isEmpty(payWorkingProcedures)) {
                continue;
            }
            for (PayWorkingProcedure procedure : payWorkingProcedures) {
                // 车间名称
                PayProductCapacityDTO payHourQuotaDTO = new PayProductCapacityDTO();
                payHourQuotaDTO.setDepartName(procedure.getWorkshopName());
                List<PayProductionCapacity> payProductionCapacities = payProductionCapacityService.getList(payHourQuotaDTO);
                if (CollectionUtils.isEmpty(payProductionCapacities)) {
                    continue;
                }
                payProductionCapacitieList.addAll(payProductionCapacities);
            }
        }
        List<PayProductionCapacity> distinctList = payProductionCapacitieList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(
            Comparator.comparing(PayProductionCapacity::getId))), ArrayList::new));
        List<PayUserProcedureVO> payUserProcedureVOS = BeanCopyUtils.copyPropertiesForNewList(distinctList, () -> new PayUserProcedureVO());
        payUserProcedureVOS.forEach(aa -> aa.setUserName(payUserMapper.selectByPrimaryKey(aa.getUserId()).getUserName()));
        return ResultBean.success(payUserProcedureVOS);
    }
}
