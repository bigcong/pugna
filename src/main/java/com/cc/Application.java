package com.cc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;


@MapperScan("com.cc.mapper")
@SpringBootApplication
@EnableCaching
//@EnableDiscoveryClient
//@EnableFeignClients
@EnableScheduling
public class Application {
    private final RedisSerializer serializer = new StringRedisSerializer();


    @Bean
    RedisTemplate<Object, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public RedisCacheManager redisCacheManager(JedisConnectionFactory jedisConnectionFactory) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate(jedisConnectionFactory));
        redisCacheManager.setUsePrefix(true);
        redisCacheManager.setCachePrefix(cacheName -> serializer.serialize((String.format("vienna.%s:", cacheName))));
        redisCacheManager.setDefaultExpiration(600);//10分钟的缓存
        return redisCacheManager;

    }


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(new Object[]{Application.class}, args);
    }

}