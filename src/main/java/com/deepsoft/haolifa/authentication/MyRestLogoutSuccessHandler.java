package com.deepsoft.haolifa.authentication;

import org.apache.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhaozhihong
 * @create 2018-08-06 13:57
 * @desc 登出成功处理器
 **/
@Component
public class MyRestLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.setStatus(HttpStatus.SC_OK);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.write("{\"code\":\"0\", \"msg\":\"注销成功\"}");
        writer.flush();
        writer.close();
    }
}
