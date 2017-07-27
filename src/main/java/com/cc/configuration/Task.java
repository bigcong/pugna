package com.cc.configuration;

import com.cc.service.impl.Dota2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by cong on 2017/7/27.
 */
@Component
public class Task {
    @Autowired
    Dota2Service dota2Service;


    @Scheduled(cron = "0/600 * * * * ?") // 每2分钟执行一次
    public void scanMessage() {
        System.out.println("开始时间为:" + new Date());
        dota2Service.matchHistory();
        System.out.println("结束时间为:" + new Date());

    }
}
