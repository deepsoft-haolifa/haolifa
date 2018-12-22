package com.deepsoft.haolifa.constant;


/**
 * @description: 常规枚举类
 **/
public class CommonEnum {

    /**
     * 返回给前端的信息枚举；规则如下：
     * 1.返回的code定义为4位数字；
     * 2.返回的message用中文标识；
     * 通用模块 0 开头；用户模块 1开头；生产流程 2 开头；采购流程 3开头；
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

        // 库房货位已经存在
        STORE_ROOM_NO_EXISTS("2001", "库房号已经存在"),

        STORE_ROOM_RACK_EXISTS("2002", "库位已经存在"),
        MATERIAL_GRAPH_NO_EXISTS("2003", "零件图号已经存在"),
        PRODUCT_NO_EXISTS("2004", "成品号已经存在"),

        // 采购计划、请购单、采购单模块错误码开头3***
        PURCHASE_NUMBER_NOT_ZERO("3000", "原料采购数量不能为0"),

        PURCHASE_NO_NOT_EXIST("3001", "采购单不存在"),
        PURCHASE_NO_EXIST("3002", "订单已存在"),

        RESOURCE_NOT_EXIST("3404", "资源不存在"),

        SUPPLIER_NO_WRONG("3002", "供应商编号格式不正确"),

        STEP_INCONFORMITY("4001", "处理节点与当前节点不一致"),
        STEP_BACK_ERROR("4002", "无可退回节点"),
        FLOW_IS_OVER("4003", "流程已结束"),
        BACK_STEP_NOT_EXIST("4004", "未指定退回节点");

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
        FLOW_INIT((byte) 3),;

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
        AuditING((byte) 1, "审批中"),
        CHECK_MATERIAL((byte) 2, "核料中"),
        WAIT_PRODUCTION((byte) 3, "待生产"),
        WAIT_MATERIAL((byte) 4, "待领料"),
        PRODUCTION((byte) 5, "生产中"),
        SUSPEND_PRODUCTION((byte) 6, "生产暂停"),
        PRODUCTION_FINISH((byte) 7, "生产完成"),
        TEST((byte) 8, "质检中"),
        STORAGE_FINISH((byte) 9, "已入库"),
        APPLY_DELIVERY((byte) 10, "申请发货"),
        DELIVERY_FINISH((byte) 11, "发货完成"),;

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
        System.out.println(OrderStatus.getCodeAndDesc());
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
        FATI((byte) 1),
        // 阀座
        FAZUO((byte) 2),
        // 阀板
        FABAN((byte) 3),
        // 上阀杆
        FAGAN((byte) 4),
        // 阀体压力
        FATI_YALI((byte) 5),
        // 通用零件
        TONG_YONG((byte) 6),;

        public final byte code;

        ProductModelType(byte code) {
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
        // 释放料
        RELEASE((byte) 3),;

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
        QI_TA((byte) 5, "其他"),;

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
        NO_COMMIT_0((byte)0),
        AUDITING_1((byte) 1),
        DEALING_2((byte) 2),
        HANDLED_3((byte) 3),
        AUDIT_NO_PASS_4((byte) 4);

        public final byte code;

        EntrustStatus(byte code) {
            this.code = code;
        }


    }
}
