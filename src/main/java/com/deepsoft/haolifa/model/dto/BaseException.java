package com.deepsoft.haolifa.model.dto;

import com.deepsoft.haolifa.constant.CommonEnum;

/**
 * @className: BaseException
 * @description:
 * @author: hedong@ibeesaas.com
 * @date: 2018-07-12 20:06
 **/
public class BaseException extends RuntimeException {
    private String code;

    public BaseException(CommonEnum.ResponseEnum responseEnum) {
        super(responseEnum.msg);
        this.code = responseEnum.code;
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String message) {
        super(message);
        this.code = CommonEnum.ResponseEnum.FAIL.code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
