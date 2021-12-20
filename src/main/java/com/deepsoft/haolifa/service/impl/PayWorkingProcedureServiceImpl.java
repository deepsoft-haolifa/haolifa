package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.OrderProductAssociateMapper;
import com.deepsoft.haolifa.dao.repository.PayUserMapper;
import com.deepsoft.haolifa.dao.repository.PayUserRelationProcedureMapper;
import com.deepsoft.haolifa.dao.repository.PayWorkingProcedureMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWorkingProcedureDTO;
import com.deepsoft.haolifa.model.vo.pay.PayWorkingProcedureUserVO;
import com.deepsoft.haolifa.model.vo.pay.ProcedureUserVO;
import com.deepsoft.haolifa.service.PayProductionCapacityService;
import com.deepsoft.haolifa.service.PayWorkingProcedureService;
import com.deepsoft.haolifa.util.BeanCopyUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PayWorkingProcedureServiceImpl extends BaseService implements PayWorkingProcedureService {
    @Resource
    private PayWorkingProcedureMapper payWorkingProcedureMapper;
    @Resource
    private OrderProductAssociateMapper orderProductAssociateMapper;
    @Resource
    private PayUserMapper payUserMapper;
    @Resource
    private PayProductionCapacityService payProductionCapacityService;
    @Resource
    private PayUserRelationProcedureMapper payUserRelationProcedureMapper;

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
    public ResultBean assignTask(String orderNo, String type) {
        OrderProductAssociateExample example = new OrderProductAssociateExample();
        example.createCriteria().andOrderNoEqualTo(orderNo);
        List<OrderProductAssociate> list = orderProductAssociateMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            ResultBean.success(null);
        }
        List<PayWorkingProcedure> payWorkingProcedures = new ArrayList<>();
        // 工序对应人的列表
        List<PayWorkingProcedureUserVO> payWorkingProcedureUserVOS = new ArrayList<>();
        // 循环所有产品
        for (OrderProductAssociate orderProductAssociate : list) {
            PayWorkingProcedureDTO payWorkingProcedure = new PayWorkingProcedureDTO();
            // 产品型号
            String model = orderProductAssociate.getProductModel().substring(0, 4);
            payWorkingProcedure.setProductModel(model);

            if (CommonEnum.WorkShopTypeEnum.PRODUCT.code.equals(type)) {
                // 生产装配订单
                payWorkingProcedure.setWorkshopName(CommonEnum.WorkShopTypeEnum.PRODUCT.name);
                payWorkingProcedures = payWorkingProcedureMapper.selectList(payWorkingProcedure);
            } else if (CommonEnum.WorkShopTypeEnum.SPRAY.code.equals(type)) {
                // 喷涂订单
                payWorkingProcedure.setWorkshopName(CommonEnum.WorkShopTypeEnum.SPRAY.name);
                payWorkingProcedures = payWorkingProcedureMapper.selectList(payWorkingProcedure);
            } else if (CommonEnum.WorkShopTypeEnum.MACHINING.code.equals(type)) {
                // 机加工订单
                payWorkingProcedure.setWorkshopName(CommonEnum.WorkShopTypeEnum.MACHINING.name);
                payWorkingProcedures = payWorkingProcedureMapper.selectList(payWorkingProcedure);
            }

            for (PayWorkingProcedure workingProcedure : payWorkingProcedures) {
                // copy 工序人员表
                PayWorkingProcedureUserVO payWorkingProcedureUserVO = new PayWorkingProcedureUserVO();
                BeanUtils.copyProperties(workingProcedure, payWorkingProcedureUserVO);
                payWorkingProcedureUserVO.setOrderNo(orderNo);
                payWorkingProcedureUserVO.setProductId(orderProductAssociate.getId());
                payWorkingProcedureUserVOS.add(payWorkingProcedureUserVO);
                // 找人员
                List<PayProductionCapacity> listByUserIdList = payProductionCapacityService.getListByCapacityCode(workingProcedure.getPostCode());
                if (CollectionUtils.isEmpty(listByUserIdList) && listByUserIdList.size() == 0) {
                    log.info("通过工序找人员为空");
                    continue;
                }
                List<ProcedureUserVO> procedureUserVOS = BeanCopyUtils.copyPropertiesForNewList(listByUserIdList, () -> new ProcedureUserVO());
                // 用户名称匹配
                procedureUserVOS.forEach(pp -> pp.setUserName(Objects.isNull(payUserMapper.selectByPrimaryKey(pp.getUserId())) ? "" : payUserMapper.selectByPrimaryKey(pp.getUserId()).getUserName()));
                payWorkingProcedureUserVO.setUserList(procedureUserVOS);
            }
        }
        if (CollectionUtils.isEmpty(payWorkingProcedureUserVOS)) {
            return ResultBean.success(null);
        }
        List<PayWorkingProcedureUserVO> distinctList = payWorkingProcedureUserVOS.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(
            Comparator.comparing(PayWorkingProcedureUserVO::getId))), ArrayList::new));
        return ResultBean.success(distinctList);
    }
}
