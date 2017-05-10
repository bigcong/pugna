package com.cc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalController {

    /**
     * 用于处理异常的
     *
     * @return
     */
    @ExceptionHandler({Exception.class})
    public Map<String, Object> exception(Exception e) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stats", -1);
        map.put("info", "服务器发生异常了");
        map.put("data", e.getMessage());
        return map;
    }

    @RequestMapping("testException")
    public void test() throws Exception {
        throw new Exception("出错了！");
    }

}
