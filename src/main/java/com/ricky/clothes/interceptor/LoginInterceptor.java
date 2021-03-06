package com.ricky.clothes.interceptor;

import com.ricky.clothes.constant.GlobalConstant;
import com.ricky.clothes.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by caiqing on 16/2/17.
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("start login interceptor ....");
        logger.debug("interceptor url: " + request.getRequestURL());
        String requestUrl = request.getRequestURL().toString();
        logger.debug("getStatus: " + response.getStatus());

        if(response.getStatus() == HttpStatus.NOT_FOUND.value() && !requestUrl.contains("/404")) {
            request.getRequestDispatcher("/404").forward(request, response);
            return false;
        } else if(requestUrl.contains("/admin/login") || requestUrl.contains("/templates/login.html") || requestUrl.contains("/error") || requestUrl.contains("/404") || requestUrl.contains("/clothesApi")) {
            return true;
        } else {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute(GlobalConstant.LOGIN_USER);
            if(user == null) {
                response.sendRedirect("/admin/login");
                return false;
            } else {
                return true;
            }
        }

    }
}
