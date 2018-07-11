package com.deepsoft.haolifa.config;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.dto.ResultBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * @description: 统一异常处理
 **/
@ControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean processIouBaseException(NativeWebRequest request, Exception e) {
        if (e instanceof BaseException) {
            BaseException e2 = (BaseException) e;
            return new ResultBean(e2.getCode(), e2.getMessage(), null);
        } else {
            return new ResultBean(CommonEnum.ResponseEnum.SYSTEM_ERROR);
        }
    }
}

class BaseException extends RuntimeException {
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
