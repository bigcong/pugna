package com.cc.configuration.interceptor;

import com.cc.entity.SystemLog;
import com.cc.entity.User;
import com.cc.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bigcong on 15/11/27.
 */
@Component
public class LogInterceptor implements HandlerInterceptor {
    @Autowired
    private SystemLogService systemLogService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        SystemLog systemLog = new SystemLog();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        systemLog.setCreateDate(dateFormat.format(new Date()));
        User user = (User) request.getSession().getAttribute("user");
        systemLog.setLogContent(getRemortIP(request));
        if (user != null) {
            systemLog.setCreatePeople(user.getUserId());
            systemLog.setUpdatePeople(user.getUserId());
            systemLog.setUserId(user.getUserId());
        }
        systemLog.setLogDate(dateFormat.format(new Date()));
        systemLog.setLogLevel(0);
        systemLog.setLogType("request_log");
        systemLog.setLogUrl(request.getRequestURI());
        systemLog.setUpdateDate(dateFormat.format(new Date()));

        systemLogService.insert(systemLog);

        return true;

    }

    public String getRemortIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");

        String remoteAddr = request.getRemoteAddr();


        System.out.println(request.getHeaderNames());
        System.out.println("getRemoteHost" + request.getRemoteHost());
        System.out.println("X-Real-Ip" + request.getHeader("X-Real-IP"));
        System.out.println("X-Forwarded-For" + request.getHeader("X-Forwarded-For"));



        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
