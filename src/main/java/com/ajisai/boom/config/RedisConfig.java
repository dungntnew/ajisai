package com.ajisai.boom.config;

import com.ajisai.boom.config.setting.RedisSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

    @Autowired
    private RedisSetting redisSetting;
}
