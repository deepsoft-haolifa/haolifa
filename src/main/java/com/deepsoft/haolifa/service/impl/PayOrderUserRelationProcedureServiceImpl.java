package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
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
import java.util.Objects;

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
            if (CommonEnum.WorkShopTypeEnum.PRODUCT.name.equals(workshopName)) {
                orderProductService.updateOrderTaskStatus(payOrderUserRelationProcedureDTO.getOrderId(), 1);
                OrderProductAssociate orderProductAssociate = orderProductAssociateMapper.selectByPrimaryKey(payOrderUserRelationProcedureDTO.getProductId());
                model = StringUtils.isEmpty(orderProductAssociate.getProductModel()) ? "" : orderProductAssociate.getProductModel().substring(0, 4);
                specifications = orderProductAssociate.getSpecifications();
            } else if (CommonEnum.WorkShopTypeEnum.SPRAY.name.equals(workshopName)) {
                sprayService.updateTaskStatus(payOrderUserRelationProcedureDTO.getOrderId(), 1);
                SprayItem sprayItem = sprayItemMapper.selectByPrimaryKey(payOrderUserRelationProcedureDTO.getProductId());
                model = sprayItem.getModel();
                specifications = sprayItem.getSpecifications();
            } else if (CommonEnum.WorkShopTypeEnum.MACHINING.name.equals(workshopName)) {
                entrustService.updateInspectTaskStatus(payOrderUserRelationProcedureDTO.getOrderId(), 1);
                Entrust entrust = entrustMapper.selectByPrimaryKey(payOrderUserRelationProcedureDTO.getProductId());
                model = entrust.getModel();
                specifications = entrust.getSpecifications();
            } else if (CommonEnum.WorkShopTypeEnum.AUTO_CONTROL.name.equals(workshopName)) {
                AutoControlEntrust entrust = autoControlEntrustMapper.selectByPrimaryKey(payOrderUserRelationProcedureDTO.getProductId());
                model = entrust.getModel();
                specifications = entrust.getSpecifications();
            } else if (CommonEnum.WorkShopTypeEnum.VALVE_SEAT_ENTRUST.name.equals(workshopName)) {
                ValveSeatEntrust entrust = valveSeatEntrustMapper.selectByPrimaryKey(payOrderUserRelationProcedureDTO.getProductId());
                model = entrust.getModel();
                specifications = entrust.getSpecifications();
            }
            PayHourQuotaDTO payHourQuotaDTO = new PayHourQuotaDTO();
            payHourQuotaDTO.setAppModel(model);
            payHourQuotaDTO.setAppSpecifications(specifications);
            payHourQuotaDTO.setPostCode(postCode);
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
        return ResultBean.success(1);

    }
}
