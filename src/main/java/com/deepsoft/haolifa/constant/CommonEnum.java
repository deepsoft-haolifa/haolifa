package com.deepsoft.haolifa.constant;


/**
 * @description: 常规枚举类
 **/
public class CommonEnum {

    /**
     * 返回给前端的信息枚举；规则如下：
     * 1.返回的code定义为4位数字；
     * 2.返回的message用中文标识；
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
        //用户登陆错误
        LOGIN_ERROR("1001", "登陆错误");

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
        YES((byte) 1);

        public final byte code;

        Consts(byte code) {
            this.code = code;
        }

    }

}
