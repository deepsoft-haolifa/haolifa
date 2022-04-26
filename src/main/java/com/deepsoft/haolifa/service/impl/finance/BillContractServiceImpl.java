package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.enums.BillContractStatusEnum;
import com.deepsoft.haolifa.enums.BillTypeEnum;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractAddOrUpDTO;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractAuditDTO;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractRQDTO;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractRSDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.*;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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


    @Autowired
    private SysDepartmentMapper departmentMapper;

    /***
     * 查询合同分解列表
     * @param billDTO
     * @return
     */
    @Override
    public ResultBean<PageDTO<ContractBillRSDTO>> getBillContractList(ContractBillRQDTO billDTO) {
        Page<ContractBillRSDTO> pageData = PageHelper
            .startPage(billDTO.getPageNum(), billDTO.getPageSize())
            .doSelectPage(() -> {
                bizBankBillMapper.getBillContractList(billDTO);
            });

        PageDTO<ContractBillRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);


        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream()
            .collect(Collectors.toMap(SysDepartment::getId, Function.identity()));

        //  只显示 已付金额 < 合同金额
        List<ContractBillRSDTO> rsDTOList = pageData.getResult().stream()
            .map(orderProduct -> {
                ContractBillRSDTO rsdto = new ContractBillRSDTO();
                BeanUtils.copyProperties(orderProduct, rsdto);

                String contractStatusCN = "";
                if (StringUtils.equalsIgnoreCase("0", rsdto.getContractStatus())) {
                    contractStatusCN = "未完成";
                } else if (StringUtils.equalsIgnoreCase("1", rsdto.getContractStatus())) {
                    contractStatusCN = "完成";
                }

                rsdto.setContractStatusCN(contractStatusCN);
                SysDepartment sysDepartment = sysDepartmentMap.get(rsdto.getDeptId());
                rsdto.setDeptName(sysDepartment.getDeptName());
                return rsdto;
            })
            .collect(Collectors.toList());

        pageDTO.setList(rsDTOList);
        return ResultBean.success(pageDTO);
    }

    /***
     * 查询合同分解-合同列表
     * @param contractListRQDTO
     * @return
     */
    @Override
    public ResultBean<PageDTO<ContractListRSDTO>> orderContractList(ContractListRQDTO contractListRQDTO) {
        if (contractListRQDTO.getId() == null) {
            return ResultBean.success(new PageDTO<>());
        }
        if (contractListRQDTO.getPageNum() == null || contractListRQDTO.getPageNum() == 0) {
            contractListRQDTO.setPageNum(1);
        }
        if (contractListRQDTO.getPageSize() == null || contractListRQDTO.getPageSize() == 0) {
            contractListRQDTO.setPageSize(10);
        }

        // 获取银行日记账中 收款 中的付款单位，未付款的完成销售订单
        ContractBillRSDTO bizBankBill = bizBankBillMapper.getBillContractById(contractListRQDTO.getId(), contractListRQDTO.getBillType());

        //销售合同
        Map<String, Object> query = new HashMap<>();
        query.put("demandName", bizBankBill.getPayCompany());
        if (StringUtils.isNotEmpty(contractListRQDTO.getOrderNo())) {
            query.put("orderNo", contractListRQDTO.getOrderNo());
        }
        if (StringUtils.isNotEmpty(contractListRQDTO.getOrderContractNo())) {
            query.put("orderContractNo", contractListRQDTO.getOrderContractNo());
        }
        Page<OrderProduct> pageData = PageHelper
            .startPage(contractListRQDTO.getPageNum(), contractListRQDTO.getPageSize())
            .doSelectPage(() -> {
                orderProductMapper.selectByMap(query);
            });

        PageDTO<ContractListRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);

        //  只显示 已付金额 < 合同金额
        List<ContractListRSDTO> rsDTOList = pageData.getResult().stream()
            .filter(e -> e.getReceivedAccount().compareTo(e.getTotalPrice()) < 0)
            .map(orderProduct -> {
                ContractListRSDTO rsdto = new ContractListRSDTO();
                BeanUtils.copyProperties(orderProduct, rsdto);
                rsdto.setBillType(bizBankBill.getBillType());
                return rsdto;
            })
            .collect(Collectors.toList());

        pageDTO.setList(rsDTOList);
        return ResultBean.success(pageDTO);
    }

    /****
     * 查询合同分解-分解详情
     * @param bizBillContract
     * @return
     */
    @Override
    public ResultBean<PageDTO<BillContractRSDTO>> selectBizBillContractList(BillContractRQDTO bizBillContract) {

        if (bizBillContract.getPageNum() == null || bizBillContract.getPageNum() == 0) {
            bizBillContract.setPageNum(1);
        }
        if (bizBillContract.getPageSize() == null || bizBillContract.getPageSize() == 0) {
            bizBillContract.setPageSize(10);
        }


        BizBillContractExample example = buildBizBillContractExample(bizBillContract.getBillId(),
            bizBillContract.getBillType(), bizBillContract.getOrderId(), bizBillContract.getOrderNo(),null);

        Page<BizBillContract> pageData = PageHelper
            .startPage(bizBillContract.getPageNum(), bizBillContract.getPageSize())
            .doSelectPage(() -> {
                bizBillContractMapper.selectByExample(example);
            });

        PageDTO<BillContractRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);

        List<BillContractRSDTO> billContractRSDTOList = pageData.getResult().stream()
            .map(bc -> {
                BillContractRSDTO billContractRSDTO = new BillContractRSDTO();
                BeanUtils.copyProperties(bc, billContractRSDTO);
                // 审批状态（0未审批；1.通过；2.不通过
                String auditStatusCN = "";
                if (StringUtils.equalsIgnoreCase("0", billContractRSDTO.getAuditStatus()+"")) {
                    auditStatusCN = "未审批";
                } else if (StringUtils.equalsIgnoreCase("1", billContractRSDTO.getAuditStatus()+"")) {
                    auditStatusCN = "通过";
                } else if (StringUtils.equalsIgnoreCase("2", billContractRSDTO.getAuditStatus()+"")) {
                    auditStatusCN = "不通过";
                }
                billContractRSDTO.setAuditStatusCN(auditStatusCN);
                return billContractRSDTO;
            })
            .collect(Collectors.toList());

        pageDTO.setList(billContractRSDTOList);
        return ResultBean.success(pageDTO);
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
            billContract.getOrderId(),billContract.getOrderNo(),new Byte("1"));
        List<BizBillContract> bizBillContractList = bizBillContractMapper.selectByExample(bizBillContractExample);

        BigDecimal splitAmount = bizBillContractList.stream()
            .filter(e -> !e.getId().equals(billContract.getId()))
            .map(BizBillContract::getAmount)
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO)
            .add(billContract.getAmount());
        if (contractAmount.compareTo(splitAmount) < 0) {
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
        if (collectionMoney.compareTo(totalAmount) < 0) {
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
        bizBillContract.setOrderId(billContract.getOrderId());
        bizBillContract.setOrderNo(billContract.getOrderNo());
        if (billContract.getId() == null) {
            bizBillContract.setCreateTime(new Date());
            bizBillContract.setCreateUser(customUser.getId());
            bizBillContractMapper.insertSelective(bizBillContract);
        } else {
            bizBillContract.setUpdateTime(new Date());
            bizBillContract.setUpdateUser(customUser.getId());
            bizBillContractMapper.updateByPrimaryKeySelective(bizBillContract);
        }

        return ResultBean.success(1);
    }

    @Override
    public ResultBean removeContract(int id) {
        BizBillContract bizBillContract = bizBillContractMapper.selectByPrimaryKey(id);
        ContractBillUpRQDTO contractBillUpRQDTO = new ContractBillUpRQDTO();
        contractBillUpRQDTO.setId(Integer.parseInt(String.valueOf(bizBillContract.getBillId())));
        contractBillUpRQDTO.setBillType(bizBillContract.getBillType().toString());
        contractBillUpRQDTO.setContractStatus(BillContractStatusEnum.decompose_un.getCode());
        int i = updateStatusBy(contractBillUpRQDTO);
        return ResultBean.success(1);
    }

    private Integer updateStatusBy(ContractBillUpRQDTO contractBillUpRQDTO) {
        BillTypeEnum billTypeEnum = BillTypeEnum.valueOfCode(contractBillUpRQDTO.getBillType());
        Integer i = 0;
        switch (billTypeEnum) {
            case bank_bill: {
                BizBankBill bizBankBill = new BizBankBill();
                bizBankBill.setId(contractBillUpRQDTO.getId());
                if (contractBillUpRQDTO.getContractUser() != null) {
                    bizBankBill.setContractUser(contractBillUpRQDTO.getContractUser());
                }
                bizBankBill.setContractStatus(contractBillUpRQDTO.getContractStatus());
                i = bizBankBillMapper.updateByPrimaryKeySelective(bizBankBill);
                break;
            }
            case other_bill: {
                BizOtherBill otherBill = new BizOtherBill();
                otherBill.setId(contractBillUpRQDTO.getId());
                if (contractBillUpRQDTO.getContractUser() != null) {
                    otherBill.setContractStatus(contractBillUpRQDTO.getContractStatus());
                }
                otherBill.setContractStatus(contractBillUpRQDTO.getContractStatus());
                i = bizOtherBillMapper.updateByPrimaryKeySelective(otherBill);
                break;
            }
        }
        return i;
    }

    @Override
    public ResultBean auditContract(BillContractAuditDTO billContract) {
        CustomUser customUser = sysUserService.selectLoginUser();

        BizBillContract bizBillContract = bizBillContractMapper.selectByPrimaryKey(billContract.getId());

        // 审核通过
        if (StringUtils.equalsIgnoreCase("1", billContract.getAuditStatus().toString())) {

            //二.判断银行日记账的金额是否够分
            // 1. 查询银行日记账的总价
            ContractBillRSDTO billRSDTO = bizBankBillMapper.getBillContractById(Integer.parseInt(String.valueOf(bizBillContract.getBillId())),
                String.valueOf(bizBillContract.getBillType()));
            BigDecimal collectionMoney = billRSDTO.getCollectionMoney();
            // 2. 查询合同已经分解的金额
            BizBillContractExample bizBillContractExample2 = buildBizBillContractExample(bizBillContract.getBillId(), bizBillContract.getBillType());
            List<BizBillContract> bizBillContractList2 = bizBillContractMapper.selectByExample(bizBillContractExample2);
            BigDecimal totalAmount = bizBillContractList2.stream()
                .filter(e -> !e.getId().equals(bizBillContract.getId()))
                .map(BizBillContract::getAmount)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .add(bizBillContract.getAmount());


            //判断合同分解是否完成
            ContractBillUpRQDTO contractBillUpRQDTO = new ContractBillUpRQDTO();
            if (totalAmount.compareTo(collectionMoney) >= 0) {
                // 将分解状态更改为分解完成
                contractBillUpRQDTO.setContractStatus(BillContractStatusEnum.decompose_done.getCode());
            } else {
                contractBillUpRQDTO.setContractStatus(BillContractStatusEnum.decompose_un.getCode());
            }
            contractBillUpRQDTO.setContractUser(customUser.getId());
            contractBillUpRQDTO.setId(Integer.parseInt(String.valueOf(bizBillContract.getBillId())));
            contractBillUpRQDTO.setBillType(bizBillContract.getBillType().toString());
            int i = updateStatusBy(contractBillUpRQDTO);


            //一.判断合同的金额是否够分
            // 1. 查询合同的总价
            OrderProduct orderProduct = orderProductMapper.selectByPrimaryKey(Integer.parseInt(String.valueOf(bizBillContract.getOrderId())));
            // 更新合同的回款状态 todo 没有回款状态 目前仅更新回款金额
            OrderProduct orderProductUp = new OrderProduct();
            orderProductUp.setId(Integer.parseInt(String.valueOf(bizBillContract.getOrderId())));
            BigDecimal receivedAccount = orderProduct.getReceivedAccount() == null ? BigDecimal.ZERO : orderProduct.getReceivedAccount();
            BigDecimal add = receivedAccount.add(bizBillContract.getAmount());
            orderProductUp.setReceivedAccount(add);
            orderProductMapper.updateByPrimaryKeySelective(orderProductUp);
        }


        BizBillContract bizBillContractUp = new BizBillContract();
        bizBillContractUp.setId(billContract.getId());
        bizBillContractUp.setAuditStatus(billContract.getAuditStatus());
        bizBillContractUp.setUpdateUser(customUser.getId());
        bizBillContractUp.setUpdateTime(new Date());
        bizBillContractUp.setRemark(billContract.getRemark());
        int i = bizBillContractMapper.updateByPrimaryKeySelective(bizBillContractUp);

        return ResultBean.success(i);
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

    private BizBillContractExample buildBizBillContractExample(Long billId2, Byte billType, Long orderId, String orderNo,Byte auditStatus) {
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
        if (auditStatus !=null) {
            criteria.andAuditStatusEqualTo(auditStatus);
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
