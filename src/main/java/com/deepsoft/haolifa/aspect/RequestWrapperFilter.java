package com.deepsoft.haolifa.aspect;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class RequestWrapperFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if (request instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) request;
            requestWrapper = new BufferedServletRequestWrapper(req);
        }
        if (requestWrapper != null) {
            chain.doFilter(requestWrapper, response);
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
