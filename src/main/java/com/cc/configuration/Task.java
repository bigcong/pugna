package com.cc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by cong on 2017/7/27.
 */
@Component
public class Task {

    @Autowired
    RestTemplate restTemplate;


    @Scheduled(cron = "0/60 * * * * ?") // 每2分钟执行一次
    public void scanMessage() {
        System.out.println("开始时间为:" + new Date());

        restTemplate.getForObject("http://localhost:8090/pugna/dota2/gg", String.class);
        System.out.println("结束时间为:" + new Date());

    }
}
