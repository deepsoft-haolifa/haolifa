package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.enums.DictEnum;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.RoleDTO;
import com.deepsoft.haolifa.model.dto.pay.PayCalculateDTO;
import com.deepsoft.haolifa.model.dto.pay.PayHourQuotaDTO;
import com.deepsoft.haolifa.model.dto.pay.PayOrderUserRelationProcedureDTO;
import com.deepsoft.haolifa.model.vo.pay.PayOrderUserRelationProcedureVO;
import com.deepsoft.haolifa.service.*;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PayOrderUserRelationProcedureServiceImpl extends BaseService implements PayOrderUserRelationProcedureService {
    @Resource
    private PayOrderUserRelationProcedureMapper payOrderUserRelationProcedureMapper;
    @Resource
    private PayOrderRelationMoreUserMapper payOrderRelationMoreUserMapper;
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
    @Resource
    private ProInspectService proInspectService;
    @Resource
    private InspectService inspectService;
    @Resource
    private AutoControlEntrustService autoControlEntrustService;
    @Resource
    private ValveSeatEntrustService valveSeatEntrustService;
    @Resource
    private RoleService roleService;


    @Override
    public List<PayOrderUserRelationProcedure> getPayOrderUserRelationProcedureList(PayOrderUserRelationProcedure payOrderUserRelationProcedures) {
        PayOrderUserRelationProcedureExample payOrderUserRelationProcedureExample = new PayOrderUserRelationProcedureExample();
        PayOrderUserRelationProcedureExample.Criteria criteria = payOrderUserRelationProcedureExample.createCriteria();
        if (Objects.nonNull(payOrderUserRelationProcedures.getUserId())) {
            criteria.andUserIdEqualTo(payOrderUserRelationProcedures.getUserId());
        }
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(payOrderUserRelationProcedures.getOrderId())) {
            criteria.andOrderIdEqualTo(payOrderUserRelationProcedures.getOrderId());
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
            if (CollectionUtils.isEmpty(payOrderUserRelationProcedureDTO.getUserId())) {
                continue;
            }
            PayWorkingProcedure payWorkingProcedure = payWorkingProcedureMapper.selectByPrimaryKey(payOrderUserRelationProcedureDTO.getId());
            // 校验是否开始质检 如果是系统管理员则不需校验
            boolean administrators = false;
            List<RoleDTO> rolesByUserId = roleService.getRolesByUserId(getLoginUserId());
            for (RoleDTO role : rolesByUserId) {
                if ("ROLE_ADMIN".equals(role.getRoleName())) {
                    administrators = true;
                    break;
                }
            }
            if (!administrators && checkHaveInspectHistory(payWorkingProcedure.getWorkshopName(), payOrderUserRelationProcedureDTO.getOrderId())) {
                return ResultBean.error(CommonEnum.ResponseEnum.ASSIGN_TASK_SAVE_CHECK);
            }
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

    private boolean checkHaveInspectHistory(String workshopName, String orderId) {
        CommonEnum.WorkShopTypeEnum workShopType = CommonEnum.WorkShopTypeEnum.getWorkShopTypeByName(workshopName);
        if (Objects.isNull(workShopType)) {
            log.info("checkHaveInspectHistory workShopTypeByName is null, orderId:{}", orderId);
            return true;
        }
        PayCalculateDTO payCalculateDTO = new PayCalculateDTO();
        payCalculateDTO.setOrderNo(orderId);
        switch (workShopType) {
            case PRODUCT:
                List<ProInspectRecord> proInspectList = proInspectService.getProInspectList(payCalculateDTO);
                if (CollectionUtils.isEmpty(proInspectList)) {
                    return false;
                }
                break;
            case SPRAY:
                List<SprayInspectHistory> sprayInspectHistoryList = sprayService.getSprayInspectHistoryList(payCalculateDTO);
                if (CollectionUtils.isEmpty(sprayInspectHistoryList)) {
                    return false;
                }
                break;
            case MACHINING:
                List<InspectHistory> inspectHistories = inspectService.getInspectHistoryList(payCalculateDTO);
                if (CollectionUtils.isEmpty(inspectHistories)) {
                    return false;
                }
                break;
            case AUTO_CONTROL:
                List<AutoControlInspectHistory> autoControlInspectHistories = autoControlEntrustService.getInspectHistoryList(payCalculateDTO);
                if (CollectionUtils.isEmpty(autoControlInspectHistories)) {
                    return false;
                }
                break;
            case VALVE_SEAT_ENTRUST:
                List<ValveSeatInspectHistory> valveSeatInspectHistories = valveSeatEntrustService.getInspectHistoryList(payCalculateDTO);
                if (CollectionUtils.isEmpty(valveSeatInspectHistories)) {
                    return false;
                }
                break;
            default:
                return true;
        }
        return true;
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

        List<PayOrderRelationMoreUser> payOrderRelationMoreUsers = null;
        // 保存之前先删除以前的 数据
        PayOrderUserRelationProcedureExample example = new PayOrderUserRelationProcedureExample();
        example.createCriteria().andOrderIdEqualTo(payOrderUserRelationProcedureDTO.getOrderId())
            .andProcedureIdEqualTo(payOrderUserRelationProcedureDTO.getId())
            .andProductIdEqualTo(payOrderUserRelationProcedureDTO.getProductId());
        List<PayOrderUserRelationProcedure> payOrderUserRelationProcedures = payOrderUserRelationProcedureMapper.selectByExample(example);
        for (PayOrderUserRelationProcedure payOrderUserRelationProcedure : payOrderUserRelationProcedures) {
            payOrderUserRelationProcedureMapper.deleteByPrimaryKey(payOrderUserRelationProcedure.getId());
            // 若果是检验的话
            // 先删除所有管理任务绑定的多人表
            if (CollectionUtils.isEmpty(payOrderRelationMoreUsers)) {
                PayOrderRelationMoreUserExample userExample1 = new PayOrderRelationMoreUserExample();
                userExample1.createCriteria().andRelationProcedureIdEqualTo(payOrderUserRelationProcedure.getId());
                payOrderRelationMoreUsers = payOrderRelationMoreUserMapper.selectByExample(userExample1);
            }
        }
        if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(payOrderUserRelationProcedures)) {
            payOrderUserRelationProcedures.stream().forEach(dd -> {
                // 先删除所有管理任务绑定的多人表
                PayOrderRelationMoreUserExample userExample = new PayOrderRelationMoreUserExample();
                userExample.createCriteria().andRelationProcedureIdEqualTo(dd.getId());
                payOrderRelationMoreUserMapper.deleteByExample(userExample);
            });
        }
        PayOrderUserRelationProcedure procedure = new PayOrderUserRelationProcedure();
        procedure.setOrderId(payOrderUserRelationProcedureDTO.getOrderId());
        procedure.setHourPrice(hourQuotaPrice);
        procedure.setUserId(payOrderUserRelationProcedureDTO.getUserId().get(0));
        procedure.setProductId(payOrderUserRelationProcedureDTO.getProductId());
        procedure.setProcedureId(payOrderUserRelationProcedureDTO.getId());
        procedure.setCreateUser(getLoginUserName());
        procedure.setUpdateUser(getLoginUserName());
        procedure.setCreateTime(new Date());
        procedure.setUpdateTime(new Date());
        int i = payOrderUserRelationProcedureMapper.insertSelective(procedure);
        if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(payOrderRelationMoreUsers)) {
            for (PayOrderRelationMoreUser payOrderRelationMoreUser : payOrderRelationMoreUsers) {
                payOrderRelationMoreUser.setRelationProcedureId(procedure.getId());
                payOrderRelationMoreUser.setCreateTime(payOrderRelationMoreUser.getCreateTime());
                payOrderRelationMoreUser.setUpdateTime(new Date());
                payOrderRelationMoreUser.setUpdateUser(getLoginUserName());
                payOrderRelationMoreUserMapper.insertSelective(payOrderRelationMoreUser);
            }
        }
        if (i == 1 && Objects.nonNull(payOrderUserRelationProcedureDTO.getIsCheckFlag()) && 1 == payOrderUserRelationProcedureDTO.getIsCheckFlag()) {
            PayOrderRelationMoreUser user = new PayOrderRelationMoreUser();
            user.setUserId(procedure.getUserId());
            user.setRelationProcedureId(procedure.getId());
            user.setQualifiedNumber(payOrderUserRelationProcedureDTO.getQualifiedNumber());
            user.setCreateTime(new Date());
            user.setCreateUser(getLoginUserName());
            payOrderRelationMoreUserMapper.insertSelective(user);
        } else if (i == 1 && payOrderUserRelationProcedureDTO.getUserId().size() > 1) {
            // 新增多人任务
            List<Integer> userIdList = payOrderUserRelationProcedureDTO.getUserId();
            for (Integer integer : userIdList) {
                PayOrderRelationMoreUser user = new PayOrderRelationMoreUser();
                user.setUserId(integer);
                user.setRelationProcedureId(procedure.getId());
                user.setCreateTime(new Date());
                user.setCreateUser(getLoginUserName());
                payOrderRelationMoreUserMapper.insertSelective(user);
            }
        }

    }
}
