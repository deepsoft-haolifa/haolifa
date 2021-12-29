package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.PurchaseOrderCompleteDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.receivable.PurchaseOrderReceivableRQDTO;
import com.deepsoft.haolifa.model.dto.finance.receivable.PurchaseOrderReceivableRSDTO;
import com.deepsoft.haolifa.model.dto.finance.standaccount.PurchaseOrderStandAccountRQDTO;
import com.deepsoft.haolifa.model.dto.finance.standaccount.PurchaseOrderStandAccountRSDTO;

public interface PurcahseOrderService {

  /**
   * 创建采购订单
   */
  ResultBean save(PurchaseOrderDTO model, Integer orderType);

  /**
   * 删除采购订单
   */
  ResultBean delete(String purchaseOrderNo);

  /**
   * 删除采购订单单项
   */
  ResultBean deleteItem(String purchaseOrderNo, String materialGraphNo);

  /**
   * 更新采购单
   */
  ResultBean update(PurchaseOrderDTO model);

  /**
   * 获取采购订单详情
   */
  ResultBean getInfo(Integer id);

  /**
   * 获取列表
   */
  ResultBean getList(PurchaseOrderListDTO model);

  /**
   * 列表
   * @param pageNum
   * @param pageSize
   * @param orderNo
   * @param createUserId
   * @return
   */
  ResultBean list(int pageNum, int pageSize, String orderNo, int createUserId, int status, Integer orderType, String supplierName, String startDate, String endDate);

  /**
   * 列表
   * @return
   */
  ResultBean<PurchaseOrderStandAccountRSDTO> standAccountList(PurchaseOrderStandAccountRQDTO purchaseOrderDTO);

  /**
   * 采购完成
   * @param model
   * @return
   */
  ResultBean complete(PurchaseOrderCompleteDTO model);

  /**
   * 发起审批
   * @param orderNo
   * @return
   */
  ResultBean approve(String orderNo, Integer orderType);

  /**
   * 生成送检单
   * @param formId
   * @return
   */
  ResultBean createInspect(Integer formId);

  void updateOrderStatus(Integer formId, Integer status);
}
