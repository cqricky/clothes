package com.ricky.clothes.config;

import com.ricky.clothes.web.filter.Loginfilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by caiqing on 16/2/16.
 */
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        Loginfilter loginfilter = new Loginfilter();
        filterRegistrationBean.setFilter(loginfilter);
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }
}
