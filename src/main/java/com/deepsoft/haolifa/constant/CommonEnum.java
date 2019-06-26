package com.deepsoft.haolifa.constant;


import java.util.HashMap;
import java.util.Map;

/**
 * @description: 常规枚举类
 **/
public class CommonEnum {

  /**
   * 返回给前端的信息枚举；规则如下： 1.返回的code定义为4位数字； 2.返回的message用中文标识； 通用模块 0 开头；用户模块 1开头；生产流程 2 开头；采购流程 3开头；
   */
  public enum ResponseEnum {
    //成功
    SUCCESS("0000", "success"),
    //失败
    FAIL("0001", "fail"),
    //参数错误
    PARAM_ERROR("0002", "参数错误"),
    //系统异常
    SYSTEM_ERROR("0003", "系统异常，请稍后再试"),

    SYSTEM_EXCEPTION("0004", "系统异常"),
    UPLOAD_PIC_EXT_ERROR("0005", "图片上传参数格式有误"),

    //用户登陆错误
    LOGIN_ERROR("1001", "登陆错误"),
    //生产订单重复
    ORDER_NO_EXISTS("1002", "订单号已经存在，不能重复上传"),
    // 订单状态已经发起审批，不能删除
    ORDER_STATUS_NOT_DELETE("1003", "订单状态已经发起审批，不能删除"),

    // 库房货位已经存在
    STORE_ROOM_NO_EXISTS("2001", "库房号已经存在"),

    STORE_ROOM_RACK_EXISTS("2002", "库位已经存在"),
    MATERIAL_GRAPH_NO_EXISTS("2003", "零件图号已经存在"),
    PRODUCT_NO_EXISTS("2004", "成品号已经存在"),
    MATERIAL_NOT_ENOUGH("2005", "该零件库存不足"),
    OUT_PRODUCT_COUNT_ERROR("2006", "成品出库数量大于入库数量"),
    MATERIAL_GRAPH_NO_NOT_EXIST("2007", "零件库中无此图号"),
    MATERIAL_HANDLED_GRAPH_NO_NOT_EXIST("2008", "零件库中无此加工后图号"),
    ORDER_NO_NOT_EXIST("2009", "库中无此订单"),

    // 采购计划、请购单、采购单模块错误码开头3***
    PURCHASE_NUMBER_NOT_ZERO("3000", "原料采购数量不能为0"),

    PURCHASE_NO_NOT_EXIST("3001", "采购单不存在"),
    PURCHASE_NO_EXIST("3002", "订单已存在"),

    RESOURCE_NOT_EXIST("3404", "资源不存在"),

    SUPPLIER_NO_WRONG("3002", "供应商编号格式不正确"),

    STEP_INCONFORMITY("4001", "处理节点与当前节点不一致"),
    STEP_BACK_ERROR("4002", "无可退回节点"),
    FLOW_IS_OVER("4003", "流程已结束"),
    BACK_STEP_NOT_EXIST("4004", "未指定退回节点"),
    FLOW_EXIST("4005", "该表单已存在审批流程"),

    FILE_NAME_EXIST("5001", "上传的文件名已经存在，请换个名称上传"),

    FLOW_INSTANCE_NOT_EXIST("4005", "该表单不存在审批流程"),

    MATERIAL_REPORT_IS_NULL("4006", "请至少上传一份材质报告"),
    INSPECT_TESTNUMBER_IS_ZERO("4007", "检测数量不能为0"),
    UNQUALIFIED_REASON_IS_EMPTY("4008", "不合格品大于0，不合格原因不能为空"),
    UNQUALIFIED_REASON_NUMBER_NO_CONSISTENCY("4009", "不合格品数量与不合格原因总数不一致"),
    ENTRUST_PARAMS_VALIDATE_ERROR("4010", "请填写完整信息"),
    ENTRUST_PARAMS_NUMBER_ERROR("4011", "委托数量必须大于0"),
    INSPECT_QUALIFIED_NUMBER_ERROR("4012", "检验合格数量不能大于送检数"),
    ENTRUST_QUALIFIED_NUMBER_ERROR("4013", "检验合格数量不能大于委托加工数"),
    SPRAY_QUALIFIED_NUMBER_ERROR("4014", "检验合格数量不能大于喷涂加工数"),
    INSPECT_RECORD_DATA_ERROR("4015", "检验数据不正确：合格与不合格品总数不等于检测数量"),
    DELIVERY_ORDERNO_NOT_EXIST("4016", "发货通知单订单号不存在")
    ;

    public final String code;

    public final String msg;

    public String getCode() {
      return code;
    }

    public String getMsg() {
      return msg;
    }

    ResponseEnum(String code, String msg) {
      this.code = code;
      this.msg = msg;
    }
  }

  /**
   * 常量枚举
   */
  public enum Consts {
    //否
    NO((byte) 0),
    //是
    YES((byte) 1),
    AUDIT_PASS((byte) 1),
    AUDIT_NO_PASS((byte) 0),
    AUDIT_BACK((byte) 2),
    FLOW_INIT((byte) 3),
    ;

    public final byte code;

    Consts(byte code) {
      this.code = code;
    }

  }

  /**
   * 订单状态
   */
  public enum OrderStatus {
    CREATE((byte) 0, "创建"),
    AUDIT_ORDER_ING((byte) 1, "审批中"),
    CHECK_MATERIAL((byte) 2, "核料中"),
    AUDIT_REPLACE_MATERIAL((byte) 3, "替换料审批中"),
    CHECK_MATERIAL_COMPLETE((byte) 4, "核料完成"),
    WAIT_PRODUCTION((byte) 5, "待生产"),
    WAIT_MATERIAL((byte) 6, "待领料"),
    PRODUCTION((byte) 7, "生产中"),
    SUSPEND_PRODUCTION((byte) 8, "生产暂停"),
    PRODUCTION_FINISH((byte) 9, "生产完成"),
    TEST((byte) 10, "质检中"),
    STORAGE_FINISH((byte) 11, "已入库"),
    APPLY_DELIVERY((byte) 12, "申请发货"),
    DELIVERY_FINISH((byte) 13, "发货完成"),
    AUDIT_ORDER_CLOSE((byte) 14, "审核不通过"),
    ;

    public final byte code;
    public final String desc;

    OrderStatus(byte code, String desc) {
      this.code = code;
      this.desc = desc;
    }

    public static String getCodeAndDesc() {
      StringBuilder codeAndDesc = new StringBuilder();
      OrderStatus[] orderStatus = OrderStatus.values();
      for (OrderStatus e : orderStatus) {
        codeAndDesc.append(e.code).append(":").append(e.desc).append(";");
      }
      return codeAndDesc.toString();
    }
  }

  public static void main(String[] args) {
    System.out.println(SysDictTypeEnum.FILE_TYPE.code);
  }

  /**
   * 出入库操作类型
   */
  public enum OperationType {
    // 出库
    OUT((byte) 1),
    //入库
    ENTRY((byte) 2);

    public final byte code;

    OperationType(byte code) {
      this.code = code;
    }
  }

  /**
   * 出入库品种类型
   */
  public enum StorageType {
    // 成品
    PRODUCT((byte) 1),
    // 零件
    MATERIAL((byte) 2);

    public final byte code;

    StorageType(byte code) {
      this.code = code;
    }
  }

  public enum FormType {

    DEFAULT_TYPE((byte) 0),
    PRODUCT_TYPE((byte) 1),
    APPLYBUY_TYPE((byte) 2),
    PURCHASE_TYPE((byte) 3),
    INSPECT_TYPE((byte) 4),
    PROINSPECT_TYPE((byte) 5),
    MATERIALINSPECT_TYPE((byte) 6),
    INVOICE_TYPE((byte) 7),
    DELIVER_TYPE((byte) 8),
    ENTRUST_TYPE((byte) 9);

    public final byte code;

    FormType(byte code) {
      this.code = code;
    }
  }

  /**
   * 产品型号规则配置
   */
  public enum ProductModelType {

    // 阀体
    FATI("fati", 1),
    // 阀座
    FAZUO("fazuo", 2),
    // 阀板
    FABAN("faban", 3),
    // 上阀杆
    FAGAN("fagan", 4),
    // 阀体压力
    FATI_YALI("fatiyali", 0),
    // 通用零件
    TONG_YONG("tongyong", 5),
    ;

    public final String code;

    public final int classifyId;

    ProductModelType(String code, int classifyId) {
      this.code = code;
      this.classifyId = classifyId;
    }
  }

  /**
   * 产品类型配置
   */
  public enum ProductType {
    // 蝶阀
    D("D"),
    // 止回阀
    H("H"),
    ;
    public final String code;

    ProductType(String code) {
      this.code = code;
    }
  }

  /**
   * 核料状态
   */
  public enum CheckMaterialStatus {

    // 核料成功
    SUCCESS((byte) 1),
    // 缺料，走采购
    NEED_PURCHASE((byte) 2),
    // 替换料
    REPLACE((byte) 3),
    // 释放料
    RELEASE((byte) 4),
    ;

    public final byte code;

    CheckMaterialStatus(byte code) {
      this.code = code;
    }
  }

  /**
   * 核料状态
   */
  public enum DeliveryClassify {
    ORDER((byte) 1, "销售订单"),
    // 缺料，走采购
    SH_ORDER((byte) 2, "售后订单"),
    // 释放料
    WDH((byte) 3, "外调货"),
    TYX((byte) 4, "调压箱"),
    QI_TA((byte) 5, "其他"),
    ;

    public final byte code;
    public final String msg;

    DeliveryClassify(byte code, String msg) {
      this.code = code;
      this.msg = msg;
    }
  }

  public enum InspectStatus {
    SAVE((byte) 1),
    WAIT_INSPECT((byte) 2),
    INSPECTED((byte) 3),
    STOCK_PENDING((byte) 4),
    STOCKED((byte) 5);

    public final byte code;

    InspectStatus(byte code) {
      this.code = code;
    }


  }

  public enum EntrustStatus {
    NO_COMMIT_0((byte) 0),
    AUDITING_1((byte) 1),
    AUDIT_PASS_WAITING_2((byte) 2),
    DEALING_3((byte) 3),
    HANDLED_4((byte) 4),
    AUDIT_NO_PASS_5((byte) 5),
    INSPECT_COMPLETE((byte) 6);

    public final byte code;

    EntrustStatus(byte code) {
      this.code = code;
    }


  }

  public enum InspectHistoryStatus {

    WAITING_STORE_1((byte) 1),
    BEEN_STORE_2((byte) 2);
    public final byte code;

    InspectHistoryStatus(byte code) {
      this.code = code;
    }
  }

  public enum SupplierIsQualified {

    WAITING_AUDIT_0((byte) 0),
    QUALIFIED_1((byte) 1),
    NO_QUALIFIED_2((byte) 2),
    AUDITING_3((byte) 3);

    public final byte code;

    SupplierIsQualified(byte code) {
      this.code = code;
    }
  }

  public enum SprayStatus {
    // 喷涂状态：0 创建 1 加工中 2 质检完成 3 加工完成 4 暂停加工
    SPRAY_CREATE((byte) 0),
    SPRAY_MACHINE((byte) 1),
    SPRAY_COMPLETE_INSPECT((byte) 2),
    SPRAY_COMPLETE_MACHINE((byte) 3),
    SPRAY_STOP_MACHINE((byte) 4);

    public final byte code;

    SprayStatus(byte code) {
      this.code = code;
    }
  }

  public enum Inspect2Status {
    // 喷涂状态：0 创建 1 加工中 2 质检完成 3 加工完成 4 暂停加工
    waiting_handle((byte) 0),
    handling((byte) 1),
    handled((byte) 2);

    public final byte code;

    Inspect2Status(byte code) {
      this.code = code;
    }
  }

  public enum DeliverStatus {
    DELIVER_NO_BEGIN_0((byte) 0),
    DELIVER_PART_1((byte) 1),
    DELIVER_COMPLETE_2((byte) 2);

    private byte code;

    DeliverStatus(byte code) {
      this.code = code;
    }

    public byte getCode() {
      return code;
    }

    public void setCode(byte code) {
      this.code = code;
    }
  }


  /**
   * 字典类型枚举
   */
  public enum SysDictTypeEnum {
    FILE_TYPE("FILE_TYPE", "文件类型"),
    ;

    public String code;
    public String name;

    SysDictTypeEnum(String code, String name) {
      this.code = code;
      this.name = name;
    }
  }

  /**
   * 质检零件类型 采购零件/ 内部机加工零件
   */
  public enum InspectMaterialType {

    PURCHASE_MATERIAL_TYPE_1((byte) 1),
    ENTRUST_MATERIAL_TYPE_2((byte) 2);

    private byte code;

    InspectMaterialType(byte code) {
      this.code = code;
    }


    public byte getCode() {
      return code;
    }

    public void setCode(byte code) {
      this.code = code;
    }}

}
