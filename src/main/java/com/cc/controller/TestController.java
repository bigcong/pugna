package com.cc.controller;

import com.cc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bigcong on 15/12/22.
 */
@RestController
public class TestController {
    @Autowired
    TestService testService;
    @RequestMapping(value = "/test")
    public Map test(HttpServletRequest request, String t) {
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("t", t);
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        map.put(t,testService.test(t));
        map.put("t", t);
        return map;
    }


}
