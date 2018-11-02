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
        SYSTEM_ERROR("0003", "网络请求错误，请稍后再试"),

        SYSTEM_EXCEPTION("0004", "系统异常"),
        UPLOAD_PIC_EXT_ERROR("0005", "图片上传参数格式有误"),

        //用户登陆错误
        LOGIN_ERROR("1001", "登陆错误"),

        // 库房货位已经存在
        STORE_ROOM_NO_EXISTS("2001", "库房号已经存在"),

        STORE_ROOM_RACK_EXISTS("2002", "库位已经存在"),
        MATERIAL_GRAPH_NO_EXISTS("2003", "零件图号已经存在"),
        PRODUCT_NO_EXISTS("2004", "成品号已经存在"),

        // 采购计划、请购单、采购单模块错误码开头3***
        PURCHASE_NUMBER_NOT_ZERO("3000", "原料采购数量不能为0"),

        PURCHASE_NO_NOT_EXIST("3001","采购单不存在"),

        RESOURCE_NOT_EXIST("3404","资源不存在"),

        SUPPLIER_NO_WRONG("3002","供应商编号格式不正确"),

        STEP_INCONFORMITY("4001","处理节点与当前节点不一致"),
        STEP_BACK_ERROR("4002","无可退回节点"),
        FLOW_IS_OVER("4003","流程已结束"),
        BACK_STEP_NOT_EXIST("4004","未指定退回节点")
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
        AUDIT_PASS((byte)1),
        AUDIT_NO_PASS((byte)0),
        AUDIT_BACK((byte)2),
        FLOW_INIT((byte)3),
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
        // 创建
        CREATE((byte) 0),
        //是
        YES((byte) 1);

        public final byte code;

        OrderStatus(byte code) {
            this.code = code;
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
}
