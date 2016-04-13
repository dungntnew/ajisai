package com.ajisai.boom.config;

import com.ajisai.boom.interceptor.MDCInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

@Configuration
public class AppConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    HandlerInterceptor mdcInterceptor() {
        return new MDCInterceptor();
    }
}
