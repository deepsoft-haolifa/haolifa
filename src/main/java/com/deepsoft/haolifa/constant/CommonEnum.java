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

        DATA_NOT_FOUND("0006", "数据不存在"),
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
        OUT_PRODUCT_COUNT_ERROR("2006", "订单成品出库数量大于入库数量"),
        MATERIAL_GRAPH_NO_NOT_EXIST("2007", "零件库中无此图号"),
        MATERIAL_HANDLED_GRAPH_NO_NOT_EXIST("2008", "零件库中无此加工后图号"),
        ORDER_NO_NOT_EXIST("2009", "库中无此订单"),
        OUT_PRODUCT_NO_COUNT_ERROR("2010", "这个订单号，这个成品号的出库数量不能大于它的入库数量"),
        OUT_PRODUCT_QUANTITY_LIMIT("2011", "成品出库数量不能大于入库记录数量，请确认"),
        MATERIAL_GRAPH_NO_CAN_NOT_MODIFY("2012", "零件图号不允许修改"),


        // 采购计划、请购单、采购单模块错误码开头3***
        PURCHASE_NUMBER_NOT_ZERO("3000", "原料采购数量不能为0"),

        PURCHASE_NO_NOT_EXIST("3001", "采购单不存在"),
        PURCHASE_NO_EXIST("3002", "订单已存在"),

        RESOURCE_NOT_EXIST("3404", "资源不存在"),

        SUPPLIER_NO_WRONG("3002", "供应商编号格式不正确"),
        SUPPLIER_GRAPH_NO_ERROR("3003", "供应商添加产品图号不在零件库中"),

        STEP_INCONFORMITY("4001", "处理节点与当前节点不一致"),
        STEP_BACK_ERROR("4002", "无可退回节点"),
        FLOW_IS_OVER("4003", "流程已结束"),
        BACK_STEP_NOT_EXIST("4004", "未指定退回节点"),
        FLOW_EXIST("4005", "该表单已存在审批流程"),
        REMOVE_FILE_ONLY_SELF("4006", "只有自己上传的附件才能删除"),

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
        DELIVERY_ORDERNO_NOT_EXIST("4016", "发货通知单订单号不存在"),
        REJECT_MATERIAL_HANDLED_NUMBER_ERROR("4017", "不合格品未进行全部处理"),
        ORDER_PRO_INSPECT_NUM_ERROR("4018", "检验合格数已超出订单总数量"),
        PURCHASE_PRO_INSPECT_NUM_ERROR("4019", "检验合格数已超出采购总数量"),
        INSPECT_UNQUALIFIED_EMPTY_ERROR("4020", "不合格原因不能为空"),
        PAY_TOTAL_COUNT_ERROR("4021", "收付款总金额不能大于合同总金额"),
        ORDER_SIGLE_PRO_INSPECT_NUM_ERROR("4022", "检验合格数单项已超出订单单项总数量"),
        USER_NAME_EXISTS("4023", "不能添加重复的用户名称"),
        DELIVERY_COUNT_LESS_THAN_PURCHASE_COUNT("4024", "【{0}】 送检数量不能大于采购数量"),
        DELIVERY_COUNT_THAN_PURCHASE_COUNT_HISTORY("4025", "该图号检验合格数+不合格数不能大于送检单上的送检数量"),
        ADD_INSPECT_RECORD("4026", "请先添加检验记录"),
        DELIVERY_RECORD_NOT_ADD("4027", "发货通知单审核不通过不能添加发货记录"),
        INSPECT_COMPELETE_LIMIT("4028", "【{0}】该报检单还未检验完成，不能点击质检完成"),

        MATERIAL_GRAPH_NO_NOT_EXIST_1("5001", "【{0}】 不存在零件库中，请确认"),
        MATERIAL_REQUISITION_EXIST("5002", "这个订单的领料单已经保存过，请确认"),
        PRODUCT_COUNT_ERROR("5003", "数量不够扣减"),
        FILE_IS_NULL("5004", "文件为空请重新选择"),
        ID_CARD_INVALID("5005", "身份证校验失败");

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

    /**
     * 出入库零件类型
     */
    public enum MaterialType {
        // 成品
        MATERIAL((byte) 0),
        // 零星零件
        SPRADIC((byte) 1);

        public final byte code;

        MaterialType(byte code) {
            this.code = code;
        }
    }

    public enum FlowId {

        ORDER_PRODUCT_FLOW(1, "生产流程"),
        PURCHASE_FLOW(2, "采购流程"),
        SUPPLIER_FLOW(3, "供应商合格审批"),
        REPLACE_FLOW(4, "替换料审批"),
        ENTRUST_FLOW(5, "外部委托审批流程"),
        APYAPP_FLOW(10, "付款申请审批流程");

        public int id;
        public String desc;

        FlowId(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }
    }

    public enum FormType {

        DEFAULT_TYPE((byte) 0, "默认"),
        PRODUCT_TYPE((byte) 1, "订单合同"),
        ENTRUST_TYPE((byte) 2, "委托加工合同"),
        PURCHASE_TYPE((byte) 3, "采购合同"),
        REPLACE_TYPE((byte) 4, "替换料"),
        SUPPLIER_TYPE((byte) 5, "供应商审批"),
        PAYAPP_TYPE((byte) 10, "付款申请审批");


        public final int code;
        public final String desc;

        FormType(byte code, String desc) {
            this.code = code;
            this.desc = desc;
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

    public enum InspectHistoryType {
        //送检
        SEND_INSPECT((byte) 1),
        // 机加工
        ENTRUST((byte) 2);
        public final byte code;

        InspectHistoryType(byte code) {
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
        // 喷涂质检状态：0 创建 1 加工中 2 质检完成
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
        PAYMENT_TYPE("PAYMENT_TYPE", "付款类型"),
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
        }
    }

    /**
     * 供应商产品类型
     */
    public enum SupplierProType {
        VALVE_BODY(1, "阀体"),
        VALVE_SEAT(2, "阀座"),
        VALVE_PLATE(3, "阀板"),
        VALVE_ROD(4, "阀杆"),
        PARTS_COMMON(5, "通用零件"),
        DRIVE(6, "驱动"),
        STANDRAD_COMPONENT(7, "标准件"),
        OTHER(8, "其它原件");

        private int type;
        private String name;

        SupplierProType(int type, String name) {
            this.type = type;
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    /**
     * 核料锁定料类型
     */
    public enum CheckMaterialLockType {
        ENTRUST((byte) 1, "机加工"),
        SPRAY((byte) 2, "喷涂");

        public final byte type;
        public final String name;

        CheckMaterialLockType(byte type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    /**
     * 车间类型
     */
    public enum WorkshopType {
        INTERNAL_1((byte) 1, "内部车间1"),
        INTERNAL_2((byte) 3, "内部车间2"),
        EXTERNAL((byte) 2, "外部车间");
        public final byte type;
        public final String name;

        WorkshopType(byte type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    /**
     * 零件类型
     */
    public enum MaterialGraphType {
        NORMAL(1, "正常件"),
        M(2, "毛坯件"),
        J(3, "机加工件");
        public final int type;
        public final String name;

        MaterialGraphType(int type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    /**
     * 委托加工类型
     */
    public enum BusType {
        ORDER_REQUIRE((byte) 1, "订单需求"),
        PRODUCT_INVENTORY((byte) 2, "生产库存");
        public final byte type;
        public final String name;

        BusType(byte type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    /**
     * 出库状态
     */
    public enum OutRoomStatus {
        NOT_OUT((byte) 1, "未出库"),
        OUT((byte) 2, "已出库");
        public final byte type;
        public final String name;

        OutRoomStatus(byte type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    /**
     * material_requisition
     * 零件待出库type
     */
    public enum materialOutType {
        MATERIAL_REQUISITION((byte) 1, "订单领料"),
        ENTRUST((byte) 2, "机加工委托"),
        SPRAY((byte) 3, "喷涂委托");
        public final byte type;
        public final String name;

        materialOutType(byte type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    /**
     * material_requisition
     * 学历type 1:小学、2:初中、3:中专、4:高中、5:大专、6:本科、7:硕士、8:博士
     */
    public enum EducationType {
        PRIMARY_SCHOOL((byte) 1, "小学"),
        JUNIOR_HIGH_SCHOOL((byte) 1, "初中"),
        SECONDARY_SPECIALIZED_SCHOOL((byte) 1, "中专"),
        HIGH_SCHOOL((byte) 1, "高中"),
        JUNIOR_COLLEGE((byte) 1, "大专"),
        UNDERGRADUATE((byte) 1, "本科"),
        MASTER((byte) 1, "硕士"),
        DOCTOR((byte) 1, "博士"),
        ;
        public final byte type;
        public final String name;
        EducationType(byte type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    /**
     * marry_status
     * 婚姻状态 1:未婚 2:已婚 3:离异 4:丧偶
     */
    public enum MarryStatusType {
        UNMARRIED((byte) 1, "未婚"),
        MARRIED((byte) 1, "已婚"),
        DIVORCE((byte) 1, "离异"),
        WIDOWED((byte) 1, "丧偶"),

        ;
        public final byte type;
        public final String name;
        MarryStatusType(byte type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    /**
     * UserType
     * 人员类型 0：生产，1:管理
     */
    public enum UserType {
        UNMARRIED("0", "生产"),
        MARRIED("1", "管理"),

        ;
        public final String type;
        public final String name;
        UserType(String type, String name) {
            this.type = type;
            this.name = name;
        }
    }


    /*** 财务管理模块 start**/

    /***
     *
     */
    public enum DelFlagEnum {
        YES("0", "存在"),
        NO("2", "删除");
        public final String code;
        public final String name;
        DelFlagEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }


    /*** 财务管理模块 end**/

    /***
     *
     */
    public enum WorkShopTypeEnum {
        PRODUCT("1", "装配车间"),
        SPRAY("2", "喷涂车间"),
        MACHINING("3", "机加工车间");
        public final String code;
        public final String name;
        WorkShopTypeEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /*** 财务管理模块 end**/

    /***
     *
     */
    public enum TypeOfWorkEnum {
        VALVE_ASSEMBLY("1", "阀门装配"),
        VALVE_BODY("2", "阀体"),
        VALVE_PLATE("3", "阀板"),
        SEMI_FINISHED_VALVE_BODY("4", "阀体半成品"),
        SEMI_FINISHED_VALVE_PLATE("5", "阀板半成品"),
        VALVE_SEAT_MACHINING("6", "阀座加工"),
        ACTUATOR_MACHINING("7", "执行器加工"),
        ;
        public final String code;
        public final String name;
        TypeOfWorkEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }
}
