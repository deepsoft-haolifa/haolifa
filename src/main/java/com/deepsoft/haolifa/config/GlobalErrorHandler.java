package com.deepsoft.haolifa.config;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.dto.BaseException;
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
            return new ResultBean(CommonEnum.ResponseEnum.SYSTEM_ERROR.code, e.getMessage(),null);
        }
    }
}

