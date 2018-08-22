package com.deepsoft.haolifa.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: BodyHttpRequestFilter
 * @author: dingfugang
 * @date: 2017-11-24 10:02
 */
@Component
public class BodyHttpRequestFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(BodyHttpRequestFilter.class);

    public BodyHttpRequestFilter() {
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if (req instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) req;

            requestWrapper = new BufferedServletRequestWrapper((HttpServletRequest) request);
        }
        if (requestWrapper != null) {
            logger.debug("doFilter: do custom body http request wrapper.");
            chain.doFilter(requestWrapper, resp);
        } else {
            chain.doFilter(req, resp);
        }

    }
    @Override
    public void destroy() {
    }
}
