package com.deepsoft.haolifa.authentication;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.model.domain.SysLoginLog;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.validator.ValidateCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @author zhaozhihong
 * @create 2018-08-06 11:32
 * @desc 登陆成功后的处理器
 **/
@Component
@Slf4j
public class MyRestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private SysUserService userService;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private HttpSession httpSession;

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        CustomUser customUser = userService.selectLoginUser();
        log.info("customeUser:{}, time:", customUser, new Date());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ServletOutputStream outputStream = response.getOutputStream();
        String json = JSONObject.toJSONString(ResultBean.success(userService.selectUserInfo()));
        outputStream.write(json.getBytes());
        outputStream.flush();
        outputStream.close();


        // 登录成功添加登录日志
        SysLoginLog sysLog = new SysLoginLog();
        sysLog.setRealName(customUser.getRealName());
        sysLog.setUserId(customUser.getId());
        applicationEventPublisher.publishEvent(sysLog);

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest == null) {
            clearAuthenticationAttributes(request);
            return;
        }
        String targetUrlParam = getTargetUrlParameter();
        if (isAlwaysUseDefaultTargetUrl()
                || (targetUrlParam != null && StringUtils.hasText(request.getParameter(targetUrlParam)))) {
            requestCache.removeRequest(request, response);
            clearAuthenticationAttributes(request);
            return;
        }

        clearAuthenticationAttributes(request);
        httpSession.removeAttribute(ValidateCode.IMAGE_VALIDATE_CODE);
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }

}
