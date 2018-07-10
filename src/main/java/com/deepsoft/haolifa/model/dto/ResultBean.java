package com.deepsoft.haolifa.model.dto;



import com.deepsoft.haolifa.constant.CommonEnum;

import java.io.Serializable;

/**
 * 自定义响应结构
 */
public class ResultBean implements Serializable {

    /**
     * 响应业务状态
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应中的数据
     */
    private Object result;


    public ResultBean() {
        super();
    }

    public ResultBean(String code, String message, Object result) {
        super();
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ResultBean(Object result) {
        this.result = result;
        this.code = CommonEnum.ResponseEnum.SUCCESS.code;
        this.message = CommonEnum.ResponseEnum.SUCCESS.msg;
    }


    public static ResultBean error(CommonEnum.ResponseEnum responseEnum) {
        String code = responseEnum.code;
        String message = responseEnum.msg;
        return new ResultBean(code, message, null);
    }

    public static ResultBean error(CommonEnum.ResponseEnum responseEnum, String message) {
        String code = responseEnum.code;
        return new ResultBean(code, message, null);
    }

    public static ResultBean success(Object result) {
        return new ResultBean(result);
    }

    public ResultBean(CommonEnum.ResponseEnum responseEnum) {
        this.code = responseEnum.code;
        this.message = responseEnum.msg;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
