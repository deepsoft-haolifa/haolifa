package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.model.domain.BizBillContract;
import com.deepsoft.haolifa.model.domain.BizBillContractExample;
import com.deepsoft.haolifa.model.domain.OrderProduct;
import com.deepsoft.haolifa.model.domain.OrderProductExample;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractAddOrUpDTO;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractRQDTO;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractRSDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRSDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractListRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractListRSDTO;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.BillContractService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BillContractServiceImpl implements BillContractService {

    @Autowired
    private BizBankBillMapper bizBankBillMapper;

    @Autowired
    private BizOtherBillMapper bizOtherBillMapper;

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private OrderProductMapper orderProductMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private BizBillContractMapper bizBillContractMapper;


    /***
     * 查询合同分解列表
     * @param billDTO
     * @return
     */
    @Override
    public ResultBean getBillContractList(ContractBillRQDTO billDTO) {
        Page<ContractBillRSDTO> pageData = PageHelper
            .startPage(billDTO.getPageNum(), billDTO.getPageSize())
            .doSelectPage(() -> {
                bizBankBillMapper.getBillContractList(billDTO);
            });

        PageDTO<ContractBillRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }

    /***
     * 查询合同分解-合同列表
     * @param contractListRQDTO
     * @return
     */
    @Override
    public ResultBean orderContractList(ContractListRQDTO contractListRQDTO) {

        // 获取银行日记账中 收款 中的付款单位，未付款的完成销售订单
        ContractBillRSDTO bizBankBill = bizBankBillMapper.getBillContractById(contractListRQDTO.getId(), contractListRQDTO.getBillType());

        //销售合同
        OrderProductExample example = new OrderProductExample();
        OrderProductExample.Criteria criteria = example.createCriteria();
        //  todo 山西系统没有需求方列表 因此没有支付单位ID
        criteria.andDemandNameEqualTo(bizBankBill.getPayCompany());
        List<OrderProduct> orderProductList = orderProductMapper.selectByExample(example);
        //  如果已付金额=合同金额，则不显示
        orderProductList = orderProductList.stream()
            .filter(e -> e.getReceivedAccount().compareTo(e.getTotalPrice()) == 0)
            .collect(Collectors.toList());

        List<ContractListRSDTO> rsDTOList = orderProductList.stream()
            .map(orderProduct -> {
                ContractListRSDTO rsdto = new ContractListRSDTO();
                BeanUtils.copyProperties(orderProduct, rsdto);
                return rsdto;
            })
            .collect(Collectors.toList());
        return ResultBean.success(rsDTOList);
    }

    /****
     * 查询合同分解-分解详情
     * @param bizBillContract
     * @return
     */
    @Override
    public ResultBean selectBizBillContractList(BillContractRQDTO bizBillContract) {
        BizBillContractExample example = buildBizBillContractExample(bizBillContract.getBillId(),
            bizBillContract.getBillType(), bizBillContract.getOrderId(), bizBillContract.getOrderNo());
        List<BizBillContract> bizBillContractList = bizBillContractMapper.selectByExample(example);
        List<BillContractRSDTO> billContractRSDTOList = bizBillContractList.stream()
            .map(bc -> {
                BillContractRSDTO billContractRSDTO = new BillContractRSDTO();
                BeanUtils.copyProperties(bc, billContractRSDTO);
                return billContractRSDTO;
            })
            .collect(Collectors.toList());

        return ResultBean.success(billContractRSDTOList);
    }

    @Override
    public ResultBean addOrUpContract(BillContractAddOrUpDTO billContract) {

        log.info("add addContract rq:{}", JSON.toJSONString(billContract));
        //一.判断合同的金额是否够分
        // 1. 查询合同的总价
        OrderProductExample example = buildOrderProductExample(billContract);
        List<OrderProduct> orderProductList = orderProductMapper.selectByExample(example);
        OrderProduct orderProduct = orderProductList.stream().findFirst().orElse(null);
        BigDecimal contractAmount = orderProduct.getTotalPrice();
        // 2. 查询该合同已经分解的金额
        BizBillContractExample bizBillContractExample = buildBizBillContractExample(billContract.getBillId(), billContract.getBillType(),
            billContract.getOrderId(), billContract.getOrderNo());
        List<BizBillContract> bizBillContractList = bizBillContractMapper.selectByExample(bizBillContractExample);

        BigDecimal splitAmount = bizBillContractList.stream()
            .filter(e -> !e.getId().equals(billContract.getId()))
            .map(BizBillContract::getAmount)
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO)
            .add(billContract.getAmount());
        if (contractAmount.compareTo(splitAmount) > 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "此合同的已付金额+这次分解的金额 大于合同金额");
        }


        //二.判断银行日记账的金额是否够分
        // 1. 查询银行日记账的总价
        ContractBillRSDTO billRSDTO = bizBankBillMapper.getBillContractById(Integer.parseInt(String.valueOf(billContract.getBillId())),
            String.valueOf(billContract.getBillType()));
        BigDecimal collectionMoney = billRSDTO.getCollectionMoney();
        // 2. 查询合同已经分解的金额
        BizBillContractExample bizBillContractExample2 = buildBizBillContractExample(billContract.getBillId(), billContract.getBillType());
        List<BizBillContract> bizBillContractList2 = bizBillContractMapper.selectByExample(bizBillContractExample2);
        BigDecimal totalAmount = bizBillContractList2.stream()
            .filter(e -> !e.getId().equals(billContract.getId()))
            .map(BizBillContract::getAmount)
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO)
            .add(billContract.getAmount());
        // logger.info("add contract totalAmount:{},dataAmount:{},billId:{}", totalAmount, alreadyAmount, billId);
        if (totalAmount.compareTo(collectionMoney) > 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "已分配金额+这次分解的金额 大于此笔收款金额");
        }


        CustomUser customUser = sysUserService.selectLoginUser();

        BizBillContract bizBillContract = new BizBillContract();
        if (billContract.getId() != null) {
            bizBillContract = bizBillContractMapper.selectByPrimaryKey(billContract.getId());
        }
        bizBillContract.setBillId(billContract.getBillId());
        bizBillContract.setBillType(billContract.getBillType());
        bizBillContract.setAmount(billContract.getAmount());
        bizBillContract.setBookKeeper(customUser.getId() + "");
        bizBillContract.setRemark(billContract.getRemark());
        if (billContract.getId() != null) {
            bizBillContract.setCreateTime(new Date());
            bizBillContract.setCreateUser(customUser.getId());
            bizBillContractMapper.insertSelective(bizBillContract);
        } else {
            bizBillContract.setUpdateTime(new Date());
            bizBillContract.setUpdateUser(customUser.getId());
            bizBillContractMapper.updateByPrimaryKeySelective(bizBillContract);
        }
//         todo  应该放在审核的地方
//        //判断合同分解是否完成
//        BizBankBill updateBill = new BizBankBill();
//        if (totalAmount >= collectionMoney) {
//            // 将分解状态更改为分解完成
//            updateBill.setContractStatus("1");
//        } else {
//            updateBill.setContractStatus("0");
//        }
//        updateBill.setContractUser(ShiroUtils.getSysUser().getUserName());
//        updateBill.setBillId(bizBankBill.getBillId());
//        bizBankBillService.updateBizBankBill(updateBill);
//
//        // 更新合同的回款状态
//        BizProcessData updateProcessData = new BizProcessData();
//        updateProcessData.setDataId(Long.parseLong(dataId));
//        if (splitAmount.compareTo(contractAmount) < 0) {
//            updateProcessData.setString17(Constant.collectionStatus.PART);
//        } else {
//            updateProcessData.setString17(Constant.collectionStatus.ALREADY);
//        }
//        bizProcessDataService.updateBizProcessData(updateProcessData);
        return ResultBean.success(1);
    }

    private OrderProductExample buildOrderProductExample(BillContractAddOrUpDTO billContract) {
        OrderProductExample example = new OrderProductExample();
        OrderProductExample.Criteria criteria = example.createCriteria();
        if (billContract.getOrderId() != null) {
            criteria.andIdEqualTo(Integer.valueOf(String.valueOf(billContract.getOrderId())));
        }
        if (StringUtils.isNotEmpty(billContract.getOrderNo())) {
            criteria.andOrderNoEqualTo(billContract.getOrderNo());
        }
        return example;
    }

    private BizBillContractExample buildBizBillContractExample(Long billId2, Byte billType, Long orderId, String orderNo) {
        BizBillContractExample example = new BizBillContractExample();
        BizBillContractExample.Criteria criteria = example.createCriteria();

        criteria.andBillIdEqualTo(billId2);
        criteria.andBillTypeEqualTo(billType);
        if (orderId != null) {
            criteria.andOrderIdEqualTo(orderId);
        }
        if (StringUtils.isNotEmpty(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        return example;
    }

    private BizBillContractExample buildBizBillContractExample(Long billId2, Byte billType) {
        BizBillContractExample example = new BizBillContractExample();
        BizBillContractExample.Criteria criteria = example.createCriteria();

        criteria.andBillIdEqualTo(billId2);
        criteria.andBillTypeEqualTo(billType);
        return example;
    }


}
