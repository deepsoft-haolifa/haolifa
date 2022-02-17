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
    private OrderProductMapper orderProductMapper;
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
    private SprayMapper sprayMapper;

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
            // 先查询订单状态
            OrderProductExample orderProductExample = new OrderProductExample();
            orderProductExample.createCriteria().andOrderNoEqualTo(orderNo);
            List<OrderProduct> orderProducts = orderProductMapper.selectByExample(orderProductExample);
            OrderProduct orderProduct = orderProducts.get(0);
            // 装配订单只有生产中才可以分配任务
            if (CommonEnum.OrderStatus.PRODUCTION.code == orderProduct.getOrderStatus()) {
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
            } else {
                // 直接返回已分配的 数据
                wrapperPayWorkingProcedureUserVOS(payWorkingProcedureUserVOS, orderNo);
                return ResultBean.success(payWorkingProcedureUserVOS);
            }
        } else if (CommonEnum.WorkShopTypeEnum.SPRAY.code.equals(type)) {
            // 喷涂订单
            SprayExample sprayExample = new SprayExample();
            sprayExample.createCriteria().andSprayNoEqualTo(orderNo);
            Spray spray = sprayMapper.selectByExample(sprayExample).get(0);
            // 待质检的 单子直接分配任务
            if (0 == spray.getInspectStatus()) {
                List<SprayItem> sprayItems = (List<SprayItem>) sprayService.getItemsList(orderNo).getResult();
                for (SprayItem sprayItem : sprayItems) {
                    String model = sprayItem.getModel();
                    String materialName = sprayItem.getMaterialName();
                    buildProductAndUser(payWorkingProcedureUserVOS, model, CommonEnum.WorkShopTypeEnum.SPRAY.name, sprayItem.getId(), orderNo, materialName);
                }
            } else {
                // 直接返回已分配的 数据
                wrapperPayWorkingProcedureUserVOS(payWorkingProcedureUserVOS, orderNo);
                return ResultBean.success(payWorkingProcedureUserVOS);
            }
        } else if (CommonEnum.WorkShopTypeEnum.MACHINING.code.equals(type)) {
            // 机加工订单
            EntrustExample example = new EntrustExample();
            EntrustExample.Criteria criteria = example.createCriteria();
            criteria.andEntrustNoEqualTo(orderNo);
            List<Entrust> entrusts = entrustMapper.selectByExample(example);
            // 待质检的 单子直接分配任务
            if (0 == entrusts.get(0).getInspectStatus()) {
                for (Entrust entrust : entrusts) {
                    String model = entrust.getModel();
                    String materialClassifyName = entrust.getMaterialClassifyName();
                    buildProductAndUser(payWorkingProcedureUserVOS, model, CommonEnum.WorkShopTypeEnum.SPRAY.name, entrust.getId(), orderNo, materialClassifyName);
                }
            } else {
                // 直接返回已分配的 数据
                wrapperPayWorkingProcedureUserVOS(payWorkingProcedureUserVOS, orderNo);
                return ResultBean.success(payWorkingProcedureUserVOS);
            }
        }
        if (CollectionUtils.isEmpty(payWorkingProcedureUserVOS)) {
            return ResultBean.success(null);
        }
        List<PayWorkingProcedureUserVO> distinctList = payWorkingProcedureUserVOS.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(
            Comparator.comparing(PayWorkingProcedureUserVO::getId))), ArrayList::new));
        return ResultBean.success(distinctList);
    }

    /**
     * 分配任务时 查看详情参数拼装
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
}
