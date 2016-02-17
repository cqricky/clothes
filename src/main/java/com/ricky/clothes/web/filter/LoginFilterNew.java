package com.ricky.clothes.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by caiqing on 16/2/16.
 */
public class LoginFilterNew implements Filter {

    private Logger logger = LoggerFactory.getLogger(LoginFilterNew.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        logger.debug("start auth filter new ....");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        logger.debug("url: " + request.getRequestURL());

        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
