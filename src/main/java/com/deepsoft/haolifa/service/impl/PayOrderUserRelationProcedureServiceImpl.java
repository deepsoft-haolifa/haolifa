package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.enums.DictEnum;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayHourQuotaDTO;
import com.deepsoft.haolifa.model.dto.pay.PayOrderUserRelationProcedureDTO;
import com.deepsoft.haolifa.model.vo.pay.PayOrderUserRelationProcedureVO;
import com.deepsoft.haolifa.service.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 订单人员工序关联表
 */
@Service
public class PayOrderUserRelationProcedureServiceImpl extends BaseService implements PayOrderUserRelationProcedureService {
    @Resource
    private PayOrderUserRelationProcedureMapper payOrderUserRelationProcedureMapper;
    @Resource
    private PayWorkingProcedureMapper payWorkingProcedureMapper;
    @Resource
    private OrderProductService orderProductService;
    @Resource
    private SprayService sprayService;
    @Resource
    private SprayItemMapper sprayItemMapper;
    @Resource
    private EntrustService entrustService;
    @Resource
    private EntrustMapper entrustMapper;
    @Resource
    private OrderProductAssociateMapper orderProductAssociateMapper;
    @Resource
    private PayHourQuotaService payHourQuotaService;
    @Resource
    private AutoControlEntrustMapper autoControlEntrustMapper;
    @Resource
    private ValveSeatEntrustMapper valveSeatEntrustMapper;
    @Resource
    private SysDictService sysDictService;



    @Override
    public List<PayOrderUserRelationProcedure> getPayOrderUserRelationProcedureList(PayOrderUserRelationProcedure payOrderUserRelationProcedures) {
        PayOrderUserRelationProcedureExample payOrderUserRelationProcedureExample = new PayOrderUserRelationProcedureExample();
        PayOrderUserRelationProcedureExample.Criteria criteria = payOrderUserRelationProcedureExample.createCriteria();
        if (Objects.nonNull(payOrderUserRelationProcedures.getUserId())) {
            criteria.andUserIdEqualTo(payOrderUserRelationProcedures.getUserId());
        }
        List<PayOrderUserRelationProcedure> list = payOrderUserRelationProcedureMapper.selectByExample(payOrderUserRelationProcedureExample);
        return list;
    }

    @Override
    public ResultBean insertSelective(PayOrderUserRelationProcedureVO procedureVO) {
        List<PayOrderUserRelationProcedureDTO> payOrderUserRelationProcedureList = procedureVO.getPayOrderUserRelationProcedureList();
        if (CollectionUtils.isEmpty(payOrderUserRelationProcedureList)) {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL, "传的数据为空");
        }
        for (PayOrderUserRelationProcedureDTO payOrderUserRelationProcedureDTO : payOrderUserRelationProcedureList) {
            if (Objects.isNull(payOrderUserRelationProcedureDTO.getUserId())) {
                continue;
            }
            PayWorkingProcedure payWorkingProcedure = payWorkingProcedureMapper.selectByPrimaryKey(payOrderUserRelationProcedureDTO.getId());
            // 工序代码
            String postCode = payWorkingProcedure.getPostCode();
            // 车间名称
            String workshopName = payWorkingProcedure.getWorkshopName();
            // 型号
            String model = "";
            // 规格
            String specifications = "";
            // id类别
            String idCategory = "";
            if (CommonEnum.WorkShopTypeEnum.PRODUCT.name.equals(workshopName)) {
                orderProductService.updateOrderTaskStatus(payOrderUserRelationProcedureDTO.getOrderId(), 1);
                // 查出工种类别映射表 映射到图号首字母
                Map<String, String> dictMap = sysDictService.getSysDictByTypeCode(DictEnum.ORDER_WORK_TYPE.getCode()).stream()
                    .collect(Collectors.toMap(SysDict::getName, SysDict::getCode, (a, b) -> a));
                String workTypeCode = dictMap.get(payWorkingProcedure.getWorkType());
                OrderProductAssociateExample example = new OrderProductAssociateExample();
                example.or().andOrderNoEqualTo(payOrderUserRelationProcedureDTO.getOrderId());
                List<OrderProductAssociate> orderAssociates = orderProductAssociateMapper.selectByExample(example);
                for (OrderProductAssociate orderAssociate : orderAssociates) {
                    String productNo = orderAssociate.getProductNo();
                    String orderFirstType = productNo.substring(0, 1);
                    if (workTypeCode.endsWith(orderFirstType)) {
                        model = StringUtils.isEmpty(orderAssociate.getProductModel()) ? "" : orderAssociate.getProductModel().substring(0, 4);
                        specifications = orderAssociate.getSpecifications();
                        idCategory = orderAssociate.getProductNo().substring(0, 2);
                        payOrderUserRelationProcedureDTO.setProductId(orderAssociate.getId());
                        saveOrderBindProcedure(model, specifications, idCategory, postCode, payOrderUserRelationProcedureDTO);
                    }
                }
            } else if (CommonEnum.WorkShopTypeEnum.SPRAY.name.equals(workshopName)) {
                sprayService.updateTaskStatus(payOrderUserRelationProcedureDTO.getOrderId(), 1);
                SprayItem sprayItem = sprayItemMapper.selectByPrimaryKey(payOrderUserRelationProcedureDTO.getProductId());
                model = sprayItem.getModel();
                specifications = sprayItem.getSpecifications();
                saveOrderBindProcedure(model, specifications, idCategory, postCode, payOrderUserRelationProcedureDTO);
            } else if (CommonEnum.WorkShopTypeEnum.MACHINING.name.equals(workshopName)) {
                entrustService.updateInspectTaskStatus(payOrderUserRelationProcedureDTO.getOrderId(), 1);
                Entrust entrust = entrustMapper.selectByPrimaryKey(payOrderUserRelationProcedureDTO.getProductId());
                model = entrust.getModel();
                specifications = entrust.getSpecifications();
                saveOrderBindProcedure(model, specifications, idCategory, postCode, payOrderUserRelationProcedureDTO);
            } else if (CommonEnum.WorkShopTypeEnum.AUTO_CONTROL.name.equals(workshopName)) {
                AutoControlEntrust entrust = autoControlEntrustMapper.selectByPrimaryKey(payOrderUserRelationProcedureDTO.getProductId());
                model = entrust.getModel();
                specifications = entrust.getSpecifications();
                saveOrderBindProcedure(model, specifications, idCategory, postCode, payOrderUserRelationProcedureDTO);
            } else if (CommonEnum.WorkShopTypeEnum.VALVE_SEAT_ENTRUST.name.equals(workshopName)) {
                ValveSeatEntrust entrust = valveSeatEntrustMapper.selectByPrimaryKey(payOrderUserRelationProcedureDTO.getProductId());
                model = entrust.getModel();
                specifications = entrust.getSpecifications();
                saveOrderBindProcedure(model, specifications, idCategory, postCode, payOrderUserRelationProcedureDTO);
            }

        }
        return ResultBean.success(1);

    }

    private void saveOrderBindProcedure(String model, String specifications, String idCategory, String postCode, PayOrderUserRelationProcedureDTO payOrderUserRelationProcedureDTO) {
        PayHourQuotaDTO payHourQuotaDTO = new PayHourQuotaDTO();
        payHourQuotaDTO.setAppModel(model);
        payHourQuotaDTO.setAppSpecifications(specifications);
        payHourQuotaDTO.setPostCode(postCode);
        payHourQuotaDTO.setIdCategory(idCategory);
        List<PayHourQuota> list = payHourQuotaService.getList(payHourQuotaDTO);
        // 获取工时定额
        BigDecimal hourQuotaPrice = null;
        if (null != list && list.size() > 0) {
            PayHourQuota payHourQuota = list.get(0);
            hourQuotaPrice = payHourQuota.getHourQuotaPrice();
        }
        // 保存之前先删除以前的 数据
        PayOrderUserRelationProcedureExample example = new PayOrderUserRelationProcedureExample();
        example.createCriteria().andOrderIdEqualTo(payOrderUserRelationProcedureDTO.getOrderId())
            .andProcedureIdEqualTo(payOrderUserRelationProcedureDTO.getId())
            .andProductIdEqualTo(payOrderUserRelationProcedureDTO.getProductId());
        List<PayOrderUserRelationProcedure> payOrderUserRelationProcedures = payOrderUserRelationProcedureMapper.selectByExample(example);
        if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(payOrderUserRelationProcedures)) {
            payOrderUserRelationProcedures.stream().forEach(pp -> payOrderUserRelationProcedureMapper.deleteByPrimaryKey(pp.getId()));
        }
        PayOrderUserRelationProcedure procedure = new PayOrderUserRelationProcedure();
        procedure.setOrderId(payOrderUserRelationProcedureDTO.getOrderId());
        procedure.setHourPrice(hourQuotaPrice);
        procedure.setUserId(payOrderUserRelationProcedureDTO.getUserId());
        procedure.setProductId(payOrderUserRelationProcedureDTO.getProductId());
        procedure.setProcedureId(payOrderUserRelationProcedureDTO.getId());
        procedure.setCreateUser(getLoginUserName());
        procedure.setUpdateUser(getLoginUserName());
        procedure.setCreateTime(new Date());
        procedure.setUpdateTime(new Date());
        payOrderUserRelationProcedureMapper.insertSelective(procedure);
    }
}
