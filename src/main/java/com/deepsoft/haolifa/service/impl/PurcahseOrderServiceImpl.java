package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.dao.repository.extend.PurchaseOrderItemExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PurcahseOrderService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PurcahseOrderServiceImpl extends BaseService implements PurcahseOrderService {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private PurchaseOrderItemMapper purchaseOrderItemMapper;
    @Autowired
    private PurchaseOrderItemExtendMapper itemExtendMapper;
    @Autowired
    private ProductPurchaseRecordMapper productPurchaseRecordMapper;

    @Override
    public ResultBean save(PurchaseOrderDTO model) {
        String purchaseOrderNo = "cgno_" + RandomUtils.orderNoStr();
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        BeanUtils.copyProperties(model, purchaseOrder);
        purchaseOrder.setPurchaseOrderNo(purchaseOrderNo);
        purchaseOrder.setCreateUserId(getLoginUserId());
        purchaseOrder.setDeliveryTime(DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getDeliveryTime()));
        purchaseOrder.setOperateTime(DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getOperateTime()));
        purchaseOrder.setConfirmTime(DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getConfirmTime()));
        log.info("添加订单内容：{}", JSON.toJSONString(purchaseOrder));
        purchaseOrderMapper.insertSelective(purchaseOrder);
        // 插入单项
        List<PurchaseOrderItem> items = model.getItemList().stream().map(item -> {
            PurchaseOrderItem orderItem = new PurchaseOrderItem();
            BeanUtils.copyProperties(item, orderItem);
            orderItem.setUnitPrice(new BigDecimal(item.getUnitPrice()));
            orderItem.setUnitWeight(new BigDecimal(item.getUnitWeight()));
            orderItem.setPurchaseOrderNo(purchaseOrderNo);
            return orderItem;
        }).collect(Collectors.toList());
        log.info("添加订单单项：{}", JSON.toJSONString(items));
        itemExtendMapper.batchInsertPurchaseOrderItem(items);

        Map<String,Object> result = new HashMap<>(8);
        result.put("formId",purchaseOrder.getId());
        result.put("formType",CommonEnum.FormType.PURCHASE_TYPE.code);
        result.put("formNo",purchaseOrder.getPurchaseOrderNo());
        return ResultBean.success(result);
    }

    @Override
    public ResultBean delete(String purchaseOrderNo) {
        // 删除采购订单
        PurchaseOrderExample purchaseOrderExample = new PurchaseOrderExample();
        purchaseOrderExample.or().andPurchaseOrderNoEqualTo(purchaseOrderNo);
        purchaseOrderMapper.deleteByExample(purchaseOrderExample);
        // 删除子项
        PurchaseOrderItemExample purchaseOrderItemExample = new PurchaseOrderItemExample();
        purchaseOrderItemExample.or().andPurchaseOrderNoEqualTo(purchaseOrderNo);
        purchaseOrderItemMapper.deleteByExample(purchaseOrderItemExample);
        // TODO 是否删除record表记录
        ProductPurchaseRecord productPurchaseRecord = new ProductPurchaseRecord();
        productPurchaseRecord.setPurchaseOrderNo("");
        ProductPurchaseRecordExample productPurchaseRecordExample = new ProductPurchaseRecordExample();
        productPurchaseRecordExample.or().andPurchaseOrderNoEqualTo(purchaseOrderNo);
        productPurchaseRecordMapper.updateByExampleSelective(productPurchaseRecord, productPurchaseRecordExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean deleteItem(String purchaseOrderNo, String materialGraphNo) {
        PurchaseOrderItemExample purchaseOrderItemExample = new PurchaseOrderItemExample();
        purchaseOrderItemExample.or().andPurchaseOrderNoEqualTo(purchaseOrderNo).andMaterialGraphNoEqualTo(materialGraphNo);
        purchaseOrderItemMapper.deleteByExample(purchaseOrderItemExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean update(PurchaseOrderDTO model) {
//        if (StringUtils.isAnyEmpty(model.getDeliveryTime(), model.getDemander(), model.getDemanderAddr(), model.getDemanderLinkman()
//                , model.getDemanderPhone(), model.getPurchaseOrderNo(), model.getSuppilerPhone(), model.getSupplierAddr(), model
// .getSupplierLinkman()
//                , model.getSupplierName(), model.getSupplierNo())) {
//            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
//        }
//        PurchaseOrder purchaseOrder = new PurchaseOrder();
//        BeanUtils.copyProperties(model, purchaseOrder);
//        PurchaseOrderExample purchaseOrderExample = new PurchaseOrderExample();
//        purchaseOrderExample.or().andPurchaseOrderNoEqualTo(model.getPurchaseOrderNo()).andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
//        purchaseOrderMapper.updateByExampleSelective(purchaseOrder, purchaseOrderExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        PurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(id);
        if (purchaseOrder == null)
            return ResultBean.success(CommonEnum.ResponseEnum.PURCHASE_NO_NOT_EXIST);
        PurchaseOrderItemExample purchaseOrderItemExample = new PurchaseOrderItemExample();
        purchaseOrderItemExample.or().andPurchaseOrderNoEqualTo(purchaseOrder.getPurchaseOrderNo());
        List<PurchaseOrderItem> purchaseOrderItemList = purchaseOrderItemMapper.selectByExample(purchaseOrderItemExample);
        if (purchaseOrderItemList == null) {
            purchaseOrderItemList = new ArrayList<>();
        }
        Map<String, Object> result = new HashMap<>(2);
        result.put("order", purchaseOrder);
        result.put("items", purchaseOrderItemList);
        return ResultBean.success(result);
    }

    @Override
    public ResultBean getList(PurchaseOrderListDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        PurchaseOrderExample purchaseOrderExample = new PurchaseOrderExample();
        PurchaseOrderExample.Criteria criteria = purchaseOrderExample.createCriteria();
        if (StringUtils.isNotEmpty(model.getPurchaseOrderNo())) {
            criteria.andPurchaseOrderNoLike("%" + model.getPurchaseOrderNo() + "%");
        }
        Page<PurchaseOrder> purchaseOrderList = PageHelper.startPage(model.getPageNum(), model.getPageSize())
                .doSelectPage(() -> purchaseOrderMapper.selectByExample(purchaseOrderExample));
        PageDTO<PurchaseOrder> purchaseOrderPageDTO = new PageDTO<>();
        BeanUtils.copyProperties(purchaseOrderList, purchaseOrderPageDTO);
        purchaseOrderPageDTO.setList(purchaseOrderList.getResult());
        return ResultBean.success(purchaseOrderPageDTO);
    }
}
