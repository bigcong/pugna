package com.cc.configuration.interceptor;

import com.cc.entity.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bigcong on 15/11/19.
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.setContentType("text/html;charset=utf-8");

            PrintWriter out = response.getWriter();
            Gson g = new Gson();
            Map<String, Object> map = new HashMap();
            map.put("status", 501);
            map.put("message", "登录信息已经过期!");
            out.print(g.toJson(map));
            out.flush();
            out.close();
            return false;
        } else {
            System.out.println("dddddddd" + new Gson().toJson(request.getCookies()));

            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
