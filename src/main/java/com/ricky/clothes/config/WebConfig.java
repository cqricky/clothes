package com.ricky.clothes.config;

import com.ricky.clothes.interceptor.LoginInterceptor;
import com.ricky.clothes.web.filter.LoginFilterNew;
import com.ricky.clothes.web.filter.Loginfilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by caiqing on 16/2/16.
 */
public class WebConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean1() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        Loginfilter loginfilter = new Loginfilter();
        filterRegistrationBean.setFilter(loginfilter);
        filterRegistrationBean.addUrlPatterns("/tags/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        LoginFilterNew loginfilter = new LoginFilterNew();
        filterRegistrationBean.setFilter(loginfilter);
        filterRegistrationBean.addUrlPatterns("/tags/*");
        filterRegistrationBean.setOrder(3);
        return filterRegistrationBean;
    }


}
