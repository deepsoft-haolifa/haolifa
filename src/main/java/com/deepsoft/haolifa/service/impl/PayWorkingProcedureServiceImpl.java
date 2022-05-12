package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWorkingProcedureDTO;
import com.deepsoft.haolifa.model.vo.pay.PayWorkingProcedureUserVO;
import com.deepsoft.haolifa.model.vo.pay.ProcedureUserVO;
import com.deepsoft.haolifa.service.PayProductionCapacityService;
import com.deepsoft.haolifa.service.PayWorkingProcedureService;
import com.deepsoft.haolifa.service.SprayService;
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
    private ValveSeatEntrustMapper valveSeatEntrustMapper;
    @Resource
    private PayUserMapper payUserMapper;
    @Resource
    private PayProductionCapacityService payProductionCapacityService;
    @Resource
    private SprayService sprayService;
    @Resource
    private EntrustMapper entrustMapper;
    @Resource
    private PayOrderUserRelationProcedureMapper payOrderUserRelationProcedureMapper;
    @Resource
    private AutoControlEntrustMapper autoControlEntrustMapper;

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
            criteria.andProductModelLike("%" + model.getProductModel() + "%");
        }
        if (StringUtils.isNotBlank(model.getPostCapability())) {
            criteria.andPostCapabilityLike("%" + model.getPostCapability() + "%");
        }
        if (StringUtils.isNotBlank(model.getPostName())) {
            criteria.andPostNameLike("%" + model.getPostName() + "%");
        }
        if (StringUtils.isNotBlank(model.getPostCode())) {
            criteria.andPostCodeLike("%" + model.getPostCode() + "%");
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
        if (StringUtils.isNotBlank(model.getPostCode())) {
            criteria.andPostCodeLike("%" + model.getPostCode() + "%");
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
    public ResultBean save(List<PayWorkingProcedureDTO> list) {
        for (PayWorkingProcedureDTO payWorkingProcedureDTO : list) {
            PayWorkingProcedure payWorkingProcedure = new PayWorkingProcedure();
            BeanUtils.copyProperties(payWorkingProcedureDTO, payWorkingProcedure);
            payWorkingProcedure.setCreateTime(new Date());
            payWorkingProcedure.setUpdateTime(new Date());
            payWorkingProcedure.setCreateUser(getLoginUserName());
            payWorkingProcedure.setUpdateUser(getLoginUserName());
            payWorkingProcedureMapper.insert(payWorkingProcedure);
        }
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
        // 工序对应人的列表
        List<PayWorkingProcedureUserVO> payWorkingProcedureUserVOS = new ArrayList<>();
        if (CommonEnum.WorkShopTypeEnum.PRODUCT.code.equals(type)) {
            // 生产装配订单
            OrderProductAssociateExample example = new OrderProductAssociateExample();
            example.createCriteria().andOrderNoEqualTo(orderNo);
            List<OrderProductAssociate> list = orderProductAssociateMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(list)) {
                ResultBean.success(null);
            }
            // 循环所有产品
            for (OrderProductAssociate orderProductAssociate : list) {
                // 产品型号
                String model = orderProductAssociate.getProductModel().substring(0, 4);
                buildProductAndUser(payWorkingProcedureUserVOS, model, CommonEnum.WorkShopTypeEnum.PRODUCT.name, orderProductAssociate.getId(), orderNo, null);
            }
        } else if (CommonEnum.WorkShopTypeEnum.SPRAY.code.equals(type)) {
            // 喷涂订单
            List<SprayItem> sprayItems = (List<SprayItem>) sprayService.getItemsList(orderNo).getResult();
            for (SprayItem sprayItem : sprayItems) {
                String model = sprayItem.getModel();
                String materialName = sprayItem.getMaterialName();
                buildProductAndUser(payWorkingProcedureUserVOS, model, CommonEnum.WorkShopTypeEnum.SPRAY.name, sprayItem.getId(), orderNo, materialName);
            }
        } else if (CommonEnum.WorkShopTypeEnum.MACHINING.code.equals(type)) {
            // 机加工订单
            EntrustExample example = new EntrustExample();
            EntrustExample.Criteria criteria = example.createCriteria();
            criteria.andEntrustNoEqualTo(orderNo);
            List<Entrust> entrusts = entrustMapper.selectByExample(example);
            // 待质检的 单子直接分配任务
            for (Entrust entrust : entrusts) {
                String model = entrust.getModel();
                String materialClassifyName = entrust.getMaterialGraphName();
                buildProductAndUser(payWorkingProcedureUserVOS, model, CommonEnum.WorkShopTypeEnum.MACHINING.name, entrust.getId(), orderNo, materialClassifyName);
            }
        } else if (CommonEnum.WorkShopTypeEnum.AUTO_CONTROL.code.equals(type)) {
            // 自控订单
            AutoControlEntrustExample example = new AutoControlEntrustExample();
            AutoControlEntrustExample.Criteria criteria = example.createCriteria();
            criteria.andEntrustNoEqualTo(orderNo);
            List<AutoControlEntrust> entrusts = autoControlEntrustMapper.selectByExample(example);
            // 待质检的 单子直接分配任务
            for (AutoControlEntrust entrust : entrusts) {
                String model = entrust.getModel();
                String materialClassifyName = entrust.getWorkType();
                buildProductAndUser(payWorkingProcedureUserVOS, model, CommonEnum.WorkShopTypeEnum.AUTO_CONTROL.name, entrust.getId(), orderNo, materialClassifyName);
            }
        } else if (CommonEnum.WorkShopTypeEnum.VALVE_SEAT_ENTRUST.code.equals(type)) {
            // 橡胶订单
            ValveSeatEntrustExample example = new ValveSeatEntrustExample();
            ValveSeatEntrustExample.Criteria criteria = example.createCriteria();
            criteria.andEntrustNoEqualTo(orderNo);
            List<ValveSeatEntrust> entrusts = valveSeatEntrustMapper.selectByExample(example);
            // 待质检的 单子直接分配任务
            for (ValveSeatEntrust entrust : entrusts) {
                String model = entrust.getModel();
                buildProductAndUser(payWorkingProcedureUserVOS, model, CommonEnum.WorkShopTypeEnum.VALVE_SEAT_ENTRUST.name, entrust.getId(), orderNo, null);
            }
        }
        if (CollectionUtils.isEmpty(payWorkingProcedureUserVOS)) {
            return ResultBean.error(CommonEnum.ResponseEnum.ASSIGN_TASK_CHECK);
        }
        List<PayWorkingProcedureUserVO> distinctList = payWorkingProcedureUserVOS.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(
            Comparator.comparing(PayWorkingProcedureUserVO::getId))), ArrayList::new));
        return ResultBean.success(distinctList);
    }

    /**
     * 分配任务时 查看详情参数拼装
     *
     * @param payWorkingProcedureUserVOS
     * @param orderNo
     */
    private void wrapperPayWorkingProcedureUserVOS(List<PayWorkingProcedureUserVO> payWorkingProcedureUserVOS, String orderNo) {
        PayOrderUserRelationProcedureExample example = new PayOrderUserRelationProcedureExample();
        example.createCriteria().andOrderIdEqualTo(orderNo);
        List<PayOrderUserRelationProcedure> payOrderUserRelationProcedures = payOrderUserRelationProcedureMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(payOrderUserRelationProcedures)) {
            return;
        }
        for (PayOrderUserRelationProcedure payOrderUserRelationProcedure : payOrderUserRelationProcedures) {
            PayWorkingProcedure payWorkingProcedure = payWorkingProcedureMapper.selectByPrimaryKey(payOrderUserRelationProcedure.getProcedureId());
            PayWorkingProcedureUserVO payWorkingProcedureUserVO = new PayWorkingProcedureUserVO();
            payWorkingProcedureUserVO.setPostCapability(payWorkingProcedure.getPostCapability());
            payWorkingProcedureUserVO.setPostCode(payWorkingProcedure.getPostCode());
            payWorkingProcedureUserVO.setPostName(payWorkingProcedure.getPostName());
            payWorkingProcedureUserVO.setOrderNo(orderNo);
            List<ProcedureUserVO> procedureUserVOS = new ArrayList<>();
            ProcedureUserVO procedureUserVO = new ProcedureUserVO();
            procedureUserVO.setUserId(payOrderUserRelationProcedure.getUserId());
            PayUser payUser = payUserMapper.selectByPrimaryKey(payOrderUserRelationProcedure.getUserId());
            procedureUserVO.setUserName(Objects.isNull(payUser) ? "" : payUser.getUserName());
            procedureUserVOS.add(procedureUserVO);
            payWorkingProcedureUserVO.setUserList(procedureUserVOS);
            payWorkingProcedureUserVOS.add(payWorkingProcedureUserVO);
        }
    }

    private void buildProductAndUser(List<PayWorkingProcedureUserVO> payWorkingProcedureUserVOS, String model, String workShopName, Integer productId, String orderNo, String workType) {
        PayWorkingProcedureDTO payWorkingProcedure = new PayWorkingProcedureDTO();
        payWorkingProcedure.setProductModel(model);
        payWorkingProcedure.setWorkshopName(workShopName);
        if (StringUtils.isNotBlank(workType)) {
            payWorkingProcedure.setWorkType(workType);
        }
        List<PayWorkingProcedure> payWorkingProcedures = payWorkingProcedureMapper.selectList(payWorkingProcedure);
        for (PayWorkingProcedure workingProcedure : payWorkingProcedures) {
            // copy 工序人员表
            PayWorkingProcedureUserVO payWorkingProcedureUserVO = new PayWorkingProcedureUserVO();
            BeanUtils.copyProperties(workingProcedure, payWorkingProcedureUserVO);
            payWorkingProcedureUserVO.setOrderNo(orderNo);
            payWorkingProcedureUserVO.setProductId(productId);
            payWorkingProcedureUserVOS.add(payWorkingProcedureUserVO);
            // 查询分配的任务
            PayOrderUserRelationProcedureExample example = new PayOrderUserRelationProcedureExample();
            example.createCriteria().andOrderIdEqualTo(orderNo)
                .andProcedureIdEqualTo(workingProcedure.getId())
                .andProductIdEqualTo(productId);
            List<PayOrderUserRelationProcedure> payOrderUserRelationProcedures = payOrderUserRelationProcedureMapper.selectByExample(example);
            if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(payOrderUserRelationProcedures)) {
                PayOrderUserRelationProcedure payOrderUserRelationProcedure = payOrderUserRelationProcedures.get(0);
                payWorkingProcedureUserVO.setUserId(payOrderUserRelationProcedure.getUserId());
                payWorkingProcedureUserVO.setTotalPrice(payOrderUserRelationProcedure.getTotalPrice());
                payWorkingProcedureUserVO.setTotalCount(payOrderUserRelationProcedure.getTotalCount());
            }
            // 找人员
            List<ProcedureUserVO> procedureUserVOS = payProductionCapacityService.getListByCapacityCode(workingProcedure.getPostCode());
            if (CollectionUtils.isEmpty(procedureUserVOS) && procedureUserVOS.size() == 0) {
                log.info("通过工序找人员为空");
                continue;
            }
            // 用户名称匹配
            payWorkingProcedureUserVO.setUserList(procedureUserVOS);
        }
    }
}
