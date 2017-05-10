package com.cc.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by cong.cui on 16/5/30 上午11:43.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=3600)
public class RedisSessionConfig {
}

