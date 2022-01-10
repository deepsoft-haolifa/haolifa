package com.deepsoft.haolifa.service.impl.finance;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizBankBillMapper;
import com.deepsoft.haolifa.dao.repository.BizOtherBillMapper;
import com.deepsoft.haolifa.dao.repository.OrderProductMapper;
import com.deepsoft.haolifa.dao.repository.PurchaseOrderMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillUpDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRSDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractListRQDTO;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.BankBillService;
import com.deepsoft.haolifa.service.finance.BillContractService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
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

    @Override
    public ResultBean contractList(ContractListRQDTO contractListRQDTO) {

        // 获取银行日记账中 收款 中的付款单位，未付款的完成销售订单
        ContractBillRSDTO bizBankBill = bizBankBillMapper.getBillContractById(contractListRQDTO.getId(), contractListRQDTO.getBillType());


        //销售合同
        OrderProductExample example = new OrderProductExample();
        OrderProductExample.Criteria criteria = example.createCriteria();
        //  todo 山西系统没有需求方列表 因此没有支付单位ID
        criteria.andDemandNameEqualTo(bizBankBill.getPayCompany());
        List<OrderProduct> orderProductList = orderProductMapper.selectByExample(example);
        //        如果已付金额=合同金额，则不显示
        orderProductList = orderProductList.stream()
            .filter(e -> e.getReceivedAccount().compareTo(e.getTotalPrice()) == 0)
            .collect(Collectors.toList());
//        BizProcessData newBizProcessData = new BizProcessData();
//        newBizProcessData.setString2(bizBankBill.getPayCompanyId());
//        newBizProcessData.setBizId(BizConstants.BIZ_contract);
//        List<BizProcessData> list = bizProcessDataService.selectBizProcessDataListRefBill(newBizProcessData);

        return null;
    }


}