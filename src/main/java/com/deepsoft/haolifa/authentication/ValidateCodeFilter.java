package com.deepsoft.haolifa.authentication;

import com.deepsoft.haolifa.exception.ValidateCodeException;
import com.deepsoft.haolifa.validator.ValidateCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class ValidateCodeFilter extends GenericFilterBean {

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private HttpSession httpSession;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if(StringUtils.equals("/haolifa/login", request.getRequestURI())
                && StringUtils.equals(request.getMethod(), "POST")){
            try {
                validate(new ServletWebRequest(request));
            } catch(ValidateCodeException e){
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;//当失败时则不执行后面的过滤器
            }
        }

        chain.doFilter(req, res);

    }


    private void validate(ServletWebRequest request) throws ServletRequestBindingException {
        ValidateCode codeInSession = (ValidateCode)httpSession.getAttribute(ValidateCode.IMAGE_VALIDATE_CODE);

        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");

        if("".equals(codeInRequest)){
            throw new ValidateCodeException("验证码不能为空");
        }


        if(codeInSession == null){
            throw new ValidateCodeException("验证码不存在");
        }

        if(codeInSession.isExpried()){
            httpSession.removeAttribute(ValidateCode.IMAGE_VALIDATE_CODE);
            throw new ValidateCodeException("验证码已过期");
        }

        if(!StringUtils.equals(codeInSession.getCode(), codeInRequest)){
            throw new ValidateCodeException("验证码不匹配");
        }

        httpSession.removeAttribute(ValidateCode.IMAGE_VALIDATE_CODE);
    }
}
