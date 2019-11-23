package com.deepsoft.haolifa.model.dto;

import com.deepsoft.haolifa.constant.CommonEnum;
import lombok.Getter;

import java.text.MessageFormat;

/**
 * @className: BaseException
 * @description:
 * @author: hedong@ibeesaas.com
 * @date: 2018-07-12 20:06
 **/
public class BaseException extends RuntimeException {
    @Getter
    private String code;

    @Getter
    private final Object[] args;


    public BaseException(CommonEnum.ResponseEnum code, Object... args) {
        this(code, code.getMsg(), args);
    }

    public BaseException(CommonEnum.ResponseEnum code) {
        this(code, code.getMsg());
    }

    public BaseException(String code, String message) {
        this(code, message, new Object[0]);
    }

    public BaseException(String message) {
        this(CommonEnum.ResponseEnum.FAIL, message, new Object[0]);
    }


    public BaseException(CommonEnum.ResponseEnum code, String message, Object... args) {
        super(MessageFormat.format(message, args));
        this.code = code.getCode();
        this.args = args;
    }

    public BaseException(String code, String message, Object... args) {
        super(MessageFormat.format(message, args));
        this.code = code;
        this.args = args;
    }

    /**
     * 提高性能
     *
     * @return Throwable
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
