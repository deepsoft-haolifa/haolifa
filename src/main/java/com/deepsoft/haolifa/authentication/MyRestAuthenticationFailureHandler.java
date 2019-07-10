package com.deepsoft.haolifa.authentication;

import com.deepsoft.haolifa.exception.ValidateCodeException;
import org.apache.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhaozhihong
 * @create 2018-08-06 14:33
 * @desc 登录失败处理
 **/
@Component
public class MyRestAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        response.setStatus(HttpStatus.SC_UNAUTHORIZED);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        if(exception instanceof ValidateCodeException)
            writer.write("{\"code\":\"2\", \"msg\":\""+exception.getMessage()+"\"}");
        if(exception instanceof BadCredentialsException)
            writer.write("{\"code\":\"3\", \"msg\":\"账号或密码错误\"}");
        writer.flush();
        writer.close();
    }
}
