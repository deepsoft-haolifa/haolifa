package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizPayApplyDetailMapper;
import com.deepsoft.haolifa.dao.repository.BizPayApplyMapper;
import com.deepsoft.haolifa.dao.repository.BizPayPlanMapper;
import com.deepsoft.haolifa.dao.repository.PurchaseOrderMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.FlowInstanceDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.payapp.*;
import com.deepsoft.haolifa.service.FlowInstanceService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.UploadPurchaseExcelService;
import com.deepsoft.haolifa.service.finance.PayApplyService;
import com.deepsoft.haolifa.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.deepsoft.haolifa.constant.CommonEnum.FlowId.APYAPP_FLOW;
import static com.deepsoft.haolifa.constant.CommonEnum.FormType.PAYAPP_TYPE;

@Service
@Slf4j
public class PayApplyServiceImpl implements PayApplyService {


    @Autowired
    private BizPayPlanMapper bizPayPlanMapper;
    @Autowired
    private BizPayApplyMapper bizPayApplyMapper;

    @Autowired
    private BizPayApplyDetailMapper bizPayApplyDetailMapper;

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private SysUserService sysUserService;
    @Lazy
    @Autowired
    private FlowInstanceService flowInstanceService;

    @Autowired
    private UploadPurchaseExcelService uploadPurchaseExcelService;

    @Override
    // @Transient
    public ResultBean save(PayApplyAddDTO model) {
        log.info("PayPlanService savePayApp start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }

        if (CollectionUtils.isEmpty(model.getApplyDetailAddDTOList())){
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }

        long count = model.getApplyDetailAddDTOList().stream()
            .map(PayApplyDetailAddDTO::getApplyPayCompany)
            .distinct()
            .count();
        if (count>1){
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }


        Date currentDate = new Date();

        BizPayApply payApply = buildBizPayApply(model, currentDate);
        int insertId = bizPayApplyMapper.insertSelective(payApply);

        model.getApplyDetailAddDTOList().stream()
            .forEach(payApplyDetailAddDTO -> {
                BizPayApplyDetail payApplyDetail =
                    buildBizPayApplyDetail(currentDate, payApplyDetailAddDTO);
                bizPayApplyDetailMapper.insertSelective(payApplyDetail);
            });
        return ResultBean.success(insertId);
    }

    private BizPayApplyDetail buildBizPayApplyDetail(Date currentDate, PayApplyDetailAddDTO payApplyDetailAddDTO) {
        BizPayApplyDetail payApplyDetail = new BizPayApplyDetail();
        BeanUtils.copyProperties(payApplyDetailAddDTO, payApplyDetail);
        payApplyDetail.setCreateTime(currentDate);
        payApplyDetail.setUpdateTime(currentDate);
        payApplyDetail.setDelFlag(CommonEnum.DelFlagEnum.YES.code);
        payApplyDetail.setCreateUser(sysUserService.selectLoginUser().getId());
        payApplyDetail.setUpdateUser(sysUserService.selectLoginUser().getId());
        return payApplyDetail;
    }

    private BizPayApply buildBizPayApply(PayApplyAddDTO model, Date currentDate) {
        BizPayApply payApply = new BizPayApply();

        payApply.setCreateTime(currentDate);
        payApply.setUpdateTime(currentDate);
        // `status`  DEFAULT '1' COMMENT '审核状态：1 待审批 2 审批中 3 付款中 4 审批不通过 5 付款完成',
        payApply.setStatus("0");
        payApply.setTotalPrice(payApply.getTotalPrice());
        payApply.setRemark(payApply.getRemark());
        String applyPayCompany = model.getApplyDetailAddDTOList().stream()
            .map(PayApplyDetailAddDTO::getApplyPayCompany)
            .distinct()
            .findFirst()
            .orElse(null);

        payApply.setApplyPayCompany(applyPayCompany);
        payApply.setApplyTime(currentDate);
        payApply.setDelFlag(CommonEnum.DelFlagEnum.YES.code);
        //payApply.setApplyNo("PP" + DateUtils.dateTimeNow() + RandomStringUtils.randomNumeric(3));
        payApply.setCreateUser(sysUserService.selectLoginUser().getId());
        payApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        return payApply;
    }

    @Override
    public ResultBean delete(Integer id) {
        //int delete = bizPayApplyMapper.deleteByPrimaryKey(id);

        BizPayApply payApply = new BizPayApply();
        payApply.setId(id);
        payApply.setDelFlag(CommonEnum.DelFlagEnum.NO.code);
        payApply.setUpdateTime(new Date());
        payApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizPayApplyMapper.updateByPrimaryKeySelective(payApply);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean update(BizPayApply payApply) {
        payApply.setUpdateTime(new Date());
        payApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizPayApplyMapper.updateByPrimaryKeySelective(payApply);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        BizPayApply payApply = bizPayApplyMapper.selectByPrimaryKey(id);

        if (payApply !=null){
            PayApplyRSDTO payApplyRSDTO = new PayApplyRSDTO();
            BeanUtils.copyProperties(payApply,payApplyRSDTO);

            // 查询付款申请详情
            BizPayApplyDetailExample example = new BizPayApplyDetailExample();
            BizPayApplyDetailExample.Criteria criteria = example.createCriteria();
            criteria.andPayApplyIdEqualTo((long) id);
            List<BizPayApplyDetail> payApplyDetailList = bizPayApplyDetailMapper.selectByExample(example);

            List<PayApplyDetailRSDTO> applyDetailRSDTOList = payApplyDetailList.stream()
                .map(bizPayApplyDetail -> {
                    PayApplyDetailRSDTO applyDetailRSDTO = new PayApplyDetailRSDTO();
                    BeanUtils.copyProperties(bizPayApplyDetail, applyDetailRSDTO);
                    return applyDetailRSDTO;
                })
                .collect(Collectors.toList());
            payApplyRSDTO.setApplyDetailRSDTOList(applyDetailRSDTOList);
            return ResultBean.success(payApplyRSDTO);
        }

        return ResultBean.success(payApply);
    }

    @Override
    public ResultBean<PayApplyRSDTO> getList(PayApplyRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizPayApplyExample bizPayApplyExample = new BizPayApplyExample();
        BizPayApplyExample.Criteria criteria = bizPayApplyExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        // 申请状态 ==
        if (StringUtils.isNotEmpty(model.getStatus())) {
            criteria.andStatusEqualTo(model.getStatus());
        }

        bizPayApplyExample.setOrderByClause("id desc");
        Page<BizPayApply> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizPayApplyMapper.selectByExample(bizPayApplyExample);
            });


        Map<Long, List<PayApplyDetailRSDTO>> applyDetailRSDTOMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(pageData.getResult())){
            List<Long> payApplyIdList = pageData.getResult().stream()
                .map(bizPayApply->(long)bizPayApply.getId())
                .collect(Collectors.toList());

            // 查询付款申请详情
            BizPayApplyDetailExample bizPayApplyDetailExample = new BizPayApplyDetailExample();
            BizPayApplyDetailExample.Criteria bizPayApplyDetailExampleCriteria = bizPayApplyDetailExample.createCriteria();
            bizPayApplyDetailExampleCriteria.andPayApplyIdIn(payApplyIdList);
            List<BizPayApplyDetail> payApplyDetailList = bizPayApplyDetailMapper.selectByExample(bizPayApplyDetailExample);

             applyDetailRSDTOMap = payApplyDetailList.stream()
                 .map(bizPayApplyDetail -> {
                     PayApplyDetailRSDTO applyDetailRSDTO = new PayApplyDetailRSDTO();
                     BeanUtils.copyProperties(bizPayApplyDetail, applyDetailRSDTO);
                     return applyDetailRSDTO;
                 })
                .collect(Collectors.groupingBy(PayApplyDetailRSDTO::getPayApplyId));
        }




        PageDTO<PayApplyRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        Map<Long, List<PayApplyDetailRSDTO>> finalApplyDetailRSDTOMap = applyDetailRSDTOMap;
        List<PayApplyRSDTO> payApplyRSDTOList = pageData.getResult().stream()
            .map(bizPayApply -> {
                PayApplyRSDTO payApply = new PayApplyRSDTO();
                BeanUtils.copyProperties(bizPayApply, payApply);
                payApply.setApplyDetailRSDTOList(finalApplyDetailRSDTOMap.get((long)bizPayApply.getId()));
                return payApply;
            })
            .collect(Collectors.toList());
        pageDTO.setList(payApplyRSDTOList);
        return ResultBean.success(pageDTO);
    }


    @Override
    public ResultBean approve(Integer id) {

        // 查询&修改 付款申请
        BizPayApply payApply = bizPayApplyMapper.selectByPrimaryKey(id);
        payApply.setStatus("2");
        payApply.setUpdateUser(sysUserService.selectLoginUser().getId());
        payApply.setUpdateTime(new Date());
        bizPayApplyMapper.updateByPrimaryKeySelective(payApply);

        // 查询付款申请详情
        BizPayApplyDetailExample example = new BizPayApplyDetailExample();
        BizPayApplyDetailExample.Criteria criteria = example.createCriteria();
        criteria.andPayApplyIdEqualTo((long) id);
        List<BizPayApplyDetail> payApplyDetailList = bizPayApplyDetailMapper.selectByExample(example);

        Map<Integer, BizPayApplyDetail> bizPayApplyDetailMap = payApplyDetailList.stream()
            .collect(Collectors.toMap(BizPayApplyDetail::getPurchaseOrderId, Function.identity(), (a, b) -> a));

        List<Integer> purchaseOrderIdList = payApplyDetailList.stream()
            .map(BizPayApplyDetail::getPurchaseOrderId)
            .collect(Collectors.toList());

        // 查询订单
        PurchaseOrderExample purchaseOrderExample = new PurchaseOrderExample();
        PurchaseOrderExample.Criteria purchaseOrderExampleCriteria = purchaseOrderExample.createCriteria();
        purchaseOrderExampleCriteria.andIdIn(purchaseOrderIdList);
        List<PurchaseOrder> purchaseOrderList = purchaseOrderMapper.selectByExample(purchaseOrderExample);


        // 添加付款计划
        purchaseOrderList.stream()
            .forEach(purchaseOrder -> {
                BizPayPlan payPlan = buildBizPayPlan(payApply, bizPayApplyDetailMap, purchaseOrder);
                bizPayPlanMapper.insertSelective(payPlan);
            });

        // 添加申请流程
        FlowInstanceDTO flowInstanceDTO = buildFlowInstanceDTO(id);
        flowInstanceService.create(flowInstanceDTO);
        return ResultBean.success(1);
    }

    private FlowInstanceDTO buildFlowInstanceDTO(Integer id) {
        FlowInstanceDTO flowInstanceDTO = new FlowInstanceDTO();
        flowInstanceDTO.setFlowId(APYAPP_FLOW.id);
        flowInstanceDTO.setSummary("采购付款审批");
        flowInstanceDTO.setFormType(PAYAPP_TYPE.code);
        flowInstanceDTO.setFormNo(id + "");
        flowInstanceDTO.setFormId(id);
        return flowInstanceDTO;
    }

    private BizPayPlan buildBizPayPlan(BizPayApply payApply, Map<Integer, BizPayApplyDetail> bizPayApplyDetailMap, PurchaseOrder purchaseOrder) {
        BizPayPlan payPlan = new BizPayPlan();

        payPlan.setPayDataId((long) payApply.getId());
        payPlan.setApplyNo("PP" + DateUtils.dateTimeNow() + RandomStringUtils.randomNumeric(3));
        payPlan.setApplyDate(payApply.getApplyTime());
        payPlan.setContractId(purchaseOrder.getId() + "");
        payPlan.setContractNo(purchaseOrder.getPurchaseOrderNo());
        payPlan.setContractPayWay(purchaseOrder.getPayType());
        payPlan.setApplyPayCompany(purchaseOrder.getDemander());
        payPlan.setApplyCollectionCompany(purchaseOrder.getSupplierName());
        payPlan.setApplyAmount(bizPayApplyDetailMap.get(purchaseOrder.getId()).getPrice());
        payPlan.setPayCompany(purchaseOrder.getDemander());
        payPlan.setStatus("0");
        payPlan.setDataStatus("0");
        Date currentDate = new Date();
        payPlan.setCreateTime(currentDate);
        payPlan.setUpdateTime(currentDate);
        payPlan.setDelFlag(CommonEnum.DelFlagEnum.YES.code);
        payPlan.setCreateUser(sysUserService.selectLoginUser().getId());
        payPlan.setUpdateUser(sysUserService.selectLoginUser().getId());

//                payPlan.setRemark("");
//                payPlan.setPayAccount();
//                payPlan.setPayWay();
//                payPlan.setPaymentType();
//                payPlan.setPayDate();
//                payPlan.setBookingType();
        return payPlan;
    }


}