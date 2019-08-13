package com.deepsoft.haolifa.constant;

public class CacheKey {

  public static String INSPECT_NO_KEY = "deepsoft:haolifa:cache:inspectNo:%s";
  public static String BATCH_NUM_KEY = "deepsoft:haolifa:cache:batchNum:%s";
  public static String SPRAY_NO_KEY = "deepsoft:haolifa:cache:sprayNo:%s";
  public static String ENTRUST_NO_KEY = "deepsoft:haolifa:cache:entrustNo:%s";
  public static String DELIVERY_NO_KEY = "deepsoft:haolifa:cache:deliveryNo:%s";
  public static String TOTAL_INVENTORY_MATERIAL = "total_inventory_material";
  public static String TOTAL_MONEY_ORDER = "total_money_order";
  /*
  采购订单质检合格数
   */
  public static String QUALIFIED_NUMBER_PURCHASE_ORDER = "qualified_number_purchase_order:%s";
  /*
  采购订单 已付货款
   */
  public static String PAID_ACCOUNT_PURCHASE_ORDER = "paid_account_purchase_order:%s";
  /*
  采购订单让步接受数量
   */
  public static String  ACCEPT_COUNT_PURCHASE_ORDER = "accept_count_purchase_order:%s";
  /*
  采购订单退货数量
   */
  public static String BACK_COUNT_PURCHASE_ORDER = "back_count_purchase_order:%s";
  /*
  采购订单加工数量
   */
  public static  String PROCESS_COUNT_PURCHASE_ORDER = "process_count_purchase_order:%s";
  /*
  采购订单加工费用
   */
  public static String PROCESS_CHARGES_PURCHASE_ORDER = "process_charges_purchase_order:%s";
  /*
  生产订单 检验合格数量
   */
  public static String ORDER_PRODUCT_QUALIFIED_NUMBER = "order_product_qualified_number:%s";
  /*
  生产订单 已发货数量
   */
  public static String ORDER_PRODUCT_DELIVERED_NUMBER = "order_product_delivered_number:%s";
  /*
  生产订单 压力检测合格数量
   */
  public static String ORDER_PRODUCT_PRESSURE_QUALIFIED_NUMBER = "order_product_pressure_qualified_number:%s";
  /*
  生产订单 已收款金额
   */
  public static String ORDER_PRODUCT_RECEIVED_ACCOUNT = "order_product_received_account:%s";
  /*

   */
}
