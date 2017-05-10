package com.cc.service.impl;

import com.cc.service.TestService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestImpl implements TestService {


    @Override
    @Cacheable(key = "333",value = "4444")
    public String test(String a) {
        return a;
    }
}