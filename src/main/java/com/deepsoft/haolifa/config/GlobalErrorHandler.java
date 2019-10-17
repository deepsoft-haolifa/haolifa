package com.deepsoft.haolifa.config;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * @description: 统一异常处理
 **/
@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public ResultBean processException(NativeWebRequest request, Exception e) {
    ResultBean resultBean = new ResultBean();
    if (e instanceof BaseException) {
      BaseException e2 = (BaseException) e;
      resultBean.setCode(e2.getCode());
      resultBean.setMessage(e2.getMessage());
      return resultBean;
    } else {
      log.error("system error *--*--*", e);
      resultBean.setCode(CommonEnum.ResponseEnum.SYSTEM_ERROR.getCode());
      resultBean.setMessage(CommonEnum.ResponseEnum.SYSTEM_ERROR.getMsg() + ": " + e.getMessage());
      return resultBean;
    }
  }
}

