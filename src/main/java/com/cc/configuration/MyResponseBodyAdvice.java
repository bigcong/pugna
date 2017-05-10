package com.cc.configuration;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cong.cui on 29/12/2016 3:01 PM.
 */
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

        if (returnType.getMethod().getName().contains("list") || returnType.getMethod().getName().equals("save")||returnType.getMethod().getName().endsWith("Map")) {
            return true;
        } else {
            return false;
        }


    }


    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        Map<String, Object> result = new HashMap<>();

        result.put("message", "响应成功");
        result.put("data", body);
        result.put("status", 200);

        return result;
    }
}
