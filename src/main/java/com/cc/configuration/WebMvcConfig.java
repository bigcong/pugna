package com.cc.configuration;

import com.cc.configuration.interceptor.LogInterceptor;
import com.cc.configuration.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by bigcong on 15/11/27.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    LogInterceptor logInterceptor;

    @Autowired
    SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //session 过滤
        //registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns("/blog/**").excludePathPatterns("/login/**").excludePathPatterns("/messageBoard/**").excludePathPatterns("/systemLog/day7Chart");
        //添加系统日志
        registry.addInterceptor(logInterceptor).addPathPatterns("/blog/**");

    }


}
