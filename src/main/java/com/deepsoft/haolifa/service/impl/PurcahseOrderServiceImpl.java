package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PurcahseOrderService;
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
    private ApplyBuyMapper applyBuyMapper;
    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private ProductPurchaseRecordMapper productPurchaseRecordMapper;

    @Override
    public ResultBean save(PurchaseOrderDTO model) {
        String purchaseOrderNo = "cgno" + RandomUtils.orderNoStr();
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        BeanUtils.copyProperties(model,purchaseOrder);
        purchaseOrder.setPurchaseOrderNo(purchaseOrderNo);
        purchaseOrderMapper.insertSelective(purchaseOrder);
        ApplyBuyExample applyBuyExample = new ApplyBuyExample();
        applyBuyExample.or().andApplyNoEqualTo(model.getApplyBuyNo()).andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        List<ApplyBuy> applyBuyList = applyBuyMapper.selectByExample(applyBuyExample);
        List<String> materialGrapgNoList = applyBuyList.stream().map(ApplyBuy::getMaterialGraphNo).distinct().collect(Collectors.toList());

        Map<String,ApplyBuy> tempApplyBuy = new HashMap<>();
        applyBuyList.stream().forEach(applyBuy -> tempApplyBuy.put(applyBuy.getMaterialGraphNo(),applyBuy));

        MaterialExample materialExample = new MaterialExample();
        materialExample.or().andGraphNoIn(materialGrapgNoList);
        List<Material> materialList = materialMapper.selectByExample(materialExample);
        List<PurchaseOrderItem> purchaseOrderItemList = materialList.stream().map(material -> {
            ApplyBuy applyBuy = tempApplyBuy.get(material.getGraphNo());
            PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
            purchaseOrderItem.setMaterial(material.getMaterial());
            purchaseOrderItem.setMaterialGraphNo(material.getGraphNo());
            purchaseOrderItem.setNumber(applyBuy.getNumber());
            purchaseOrderItem.setProductName(material.getName());
            purchaseOrderItem.setRemark(applyBuy.getRemark());
            purchaseOrderItem.setSpecification(material.getSpecifications());
            purchaseOrderItem.setUnit(material.getUnit());
            purchaseOrderItem.setUnitPrice(material.getPrice());
            // TODO 无单重字段，需要添加
            purchaseOrderItem.setUnitWeight(new BigDecimal(0));
            return purchaseOrderItem;
        }).collect(Collectors.toList());
        purchaseOrderItemMapper.batchInsertPurchaseOrderItem(purchaseOrderItemList);
        return ResultBean.success(purchaseOrderNo);
    }

    @Override
    public ResultBean delete(String purchaseOrderNo) {
        // 删除采购订单
        PurchaseOrderExample purchaseOrderExample = new PurchaseOrderExample();
        purchaseOrderExample.or().andPurchaseOrderNoEqualTo(purchaseOrderNo);
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setIsDelete(CommonEnum.Consts.YES.code);
        purchaseOrderMapper.updateByExampleSelective(purchaseOrder, purchaseOrderExample);
        // 删除子项
        PurchaseOrderItemExample purchaseOrderItemExample = new PurchaseOrderItemExample();
        purchaseOrderItemExample.or().andPurchaseOrderNoEqualTo(purchaseOrderNo);
        purchaseOrderItemMapper.deleteByExample(purchaseOrderItemExample);
        // TODO 是否删除record表记录
        ProductPurchaseRecord productPurchaseRecord = new ProductPurchaseRecord();
        productPurchaseRecord.setPurchaseOrderNo("");
        ProductPurchaseRecordExample productPurchaseRecordExample = new ProductPurchaseRecordExample();
        productPurchaseRecordExample.or().andPurchaseOrderNoEqualTo(purchaseOrderNo);
        productPurchaseRecordMapper.updateByExampleSelective(productPurchaseRecord,productPurchaseRecordExample);
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
        if (StringUtils.isAnyEmpty(model.getDeliveryTime(), model.getDemander(), model.getDemanderAddr(), model.getDemanderLinkman()
                , model.getDemanderPhone(), model.getPurchaseOrderNo(), model.getSuppilerPhone(), model.getSupplierAddr(), model.getSupplierLinkman()
                , model.getSupplierName(), model.getSupplierNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        BeanUtils.copyProperties(model, purchaseOrder);
        PurchaseOrderExample purchaseOrderExample = new PurchaseOrderExample();
        purchaseOrderExample.or().andPurchaseOrderNoEqualTo(model.getPurchaseOrderNo()).andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        purchaseOrderMapper.updateByExampleSelective(purchaseOrder, purchaseOrderExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(String purchaseOrderNo) {
        PurchaseOrderExample purchaseOrderExample = new PurchaseOrderExample();
        purchaseOrderExample.or().andIsDeleteEqualTo(CommonEnum.Consts.NO.code).andPurchaseOrderNoEqualTo(purchaseOrderNo);
        List<PurchaseOrder> purchaseOrderList = purchaseOrderMapper.selectByExample(purchaseOrderExample);
        PurchaseOrder purchaseOrder = null;
        if (purchaseOrderList != null && purchaseOrderList.size() > 0) {
            purchaseOrder = purchaseOrderList.get(0);
        }
        if (purchaseOrder == null)
            return ResultBean.success(CommonEnum.ResponseEnum.PURCHASE_NO_NOT_EXIST);
        PurchaseOrderItemExample purchaseOrderItemExample = new PurchaseOrderItemExample();
        purchaseOrderItemExample.or().andPurchaseOrderNoEqualTo(purchaseOrderNo);
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
        Page<PurchaseOrder> purchaseOrderList = PageHelper.startPage(model.getPageNum(), model.getPageSize())
                .doSelectPage(() -> purchaseOrderMapper.selectByExample(purchaseOrderExample));
        PageDTO<PurchaseOrder> purchaseOrderPageDTO = new PageDTO<>();
        BeanUtils.copyProperties(purchaseOrderList, purchaseOrderPageDTO);
        purchaseOrderPageDTO.setList(purchaseOrderList.getResult());
        return ResultBean.success(purchaseOrderPageDTO);
    }
}
