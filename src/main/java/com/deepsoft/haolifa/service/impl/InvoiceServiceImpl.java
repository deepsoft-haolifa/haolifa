package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.InvoiceMapper;
import com.deepsoft.haolifa.model.domain.Invoice;
import com.deepsoft.haolifa.model.domain.InvoiceExample;
import com.deepsoft.haolifa.model.dto.InvoiceCreateDTO;
import com.deepsoft.haolifa.model.dto.InvoiceDTO;
import com.deepsoft.haolifa.model.dto.InvoiceListDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.InvoiceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class InvoiceServiceImpl extends BaseService implements InvoiceService {

  @Autowired
  InvoiceMapper invoiceMapper;

  @Override
  public ResultBean save(InvoiceCreateDTO model) {
    if (validateIsEmpty(model)) {
      return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
    }
    Map<String, Object> result = new HashMap<>(8);
    Invoice invoice = new Invoice();
    invoice.setStatus(model.getStatus().byteValue());
    invoice.setType(model.getType().byteValue());
    invoice.setOrderNo(model.getOrderNo());
    invoice.setRemark(model.getRemark());
    invoice.setTotalAmount(new BigDecimal(model.getTotalAmount()));
    invoice.setId(model.getId());
    invoice.setInvoiceNo(model.getInvoiceNo());
    invoice.setCreateUserId(getLoginUserId());
    invoice.setInvoiceCompany(model.getInvoiceCompany());
    invoice.setInvoiceIssuing(model.getInvoiceIssuing());
    if(model.getType() == 1) {
      invoice.setConstractParty(model.getInvoiceCompany());
    } else {
      invoice.setConstractParty(model.getInvoiceIssuing());
    }
    if(invoice.getId() != null ) {
      invoiceMapper.updateByPrimaryKeySelective(invoice);
    } else {
      invoiceMapper.insertSelective(invoice);
      result.put("formId", invoice.getId());
      result.put("formNo", invoice.getInvoiceNo());
      result.put("formType", CommonEnum.FormType.INVOICE_TYPE.code);
    }
    return ResultBean.success(result);
  }

  private boolean validateIsEmpty(InvoiceCreateDTO model) {
    if (StringUtils.isEmpty(model.getOrderNo())) {
      return true;
    }
    if (model.getTotalAmount() == null || model.getTotalAmount() == 0) {
      return true;
    }
    if (model.getStatus() == null) {
      return true;
    }
    if (model.getType() == null) {
      return true;
    }
    return false;

  }

  @Override
  public ResultBean delete(int id) {
    invoiceMapper.deleteByPrimaryKey(id);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean update(InvoiceDTO model) {
    Invoice invoice = new Invoice();
    BeanUtils.copyProperties(model, invoice);
    invoice.setTotalAmount(new BigDecimal(model.getTotalAmount()));
    int update = invoiceMapper.updateByPrimaryKeySelective(invoice);
    return ResultBean.success(update);
  }

  @Override
  public ResultBean updateInvoiceNo(Integer id, String invoiceNo) {
    Invoice invoice = new Invoice();
    invoice.setInvoiceNo(invoiceNo);
    invoice.setId(id);
    invoice.setStatus((byte)2);// 已开票
    invoiceMapper.updateByPrimaryKeySelective(invoice);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean getList(int origin, InvoiceListDTO modelList) {
    if (modelList.getPageNum() == null || modelList.getPageNum() == 0) {
      modelList.setPageNum(1);
    }
    if (modelList.getPageSize() == null || modelList.getPageSize() == 0) {
      modelList.setPageSize(10);
    }
    InvoiceExample invoiceExample = new InvoiceExample();
    InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
    criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
//    if(origin == 0) {
////      经管申请
//      criteria.andCreateUserIdEqualTo(getLoginUserId());
//    }
    if (StringUtils.isNotEmpty(modelList.getOrderNo())) {
      criteria.andOrderNoLike("%" + modelList.getOrderNo() + "%");
    }
    if (modelList.getStatus() !=0) {
      criteria.andStatusEqualTo(modelList.getStatus().byteValue());
    }
    if(StringUtils.isNotEmpty(modelList.getContractParty())) {
      criteria.andConstractPartyLike("%"+modelList.getContractParty()+"%");
    }
    if(modelList.getType() != 0) {
      criteria.andTypeEqualTo(modelList.getType().byteValue());
    }
    criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
    Page<Invoice> pageData = PageHelper.startPage(modelList.getPageNum(), modelList.getPageSize())
        .doSelectPage(() -> invoiceMapper.selectByExample(invoiceExample));
    PageDTO<Invoice> pageDTO = new PageDTO<>();
    BeanUtils.copyProperties(pageData, pageDTO);
    pageDTO.setList(pageData.getResult());
    return ResultBean.success(pageDTO);
  }

  @Override
  public ResultBean info(Integer id) {
    return ResultBean.success(invoiceMapper.selectByPrimaryKey(id));
  }
}
