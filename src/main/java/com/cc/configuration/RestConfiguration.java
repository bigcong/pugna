package com.cc.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cong on 2017/7/24.
 */
@Configuration
public class RestConfiguration {
    @Value("${steam.key}")
    private String steamKey;


    @Bean
    public RestTemplate restOperations() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(5000);
        requestFactory.setConnectTimeout(5000);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        //HttpHeaders headers = new HttpHeaders();
        // MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        // headers.setContentType(type);
        //headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        // restTemplate.setInterceptors(Arrays.asList(new LoggingRequestInterceptor()));
        return restTemplate;
    }
}
