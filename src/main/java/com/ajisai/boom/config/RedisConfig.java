package com.ajisai.boom.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig {
    private String keyPrefix;
    private Map<String, Object> redisCache = new  java.util.HashMap <String, Object>();
}
