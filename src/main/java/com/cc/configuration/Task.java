package com.cc.configuration;

import com.cc.service.Dota2MatchDetailsService;
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
    Dota2MatchDetailsService dota2MatchDetailsService;


    @Scheduled(cron = "0/600 * * * * ?") // 每2分钟执行一次
    public void matchHistory() {
        System.out.println("开始时间为:" + new Date());
        //dota2MatchDetailsService.matchHistory();


        System.out.println("结束时间为:" + new Date());

    }

    /**
     * 表示每个星期三中午12点
     */
    @Scheduled(cron = "0 0 12 ? * WED") //
    public void heros() {
        System.out.println("开始时间为:" + new Date());
        dota2MatchDetailsService.heroes();

        System.out.println("结束时间为:" + new Date());

    }
}
