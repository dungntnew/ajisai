package com.ajisai.boom.listener;

import com.ajisai.boom.config.setting.RedisSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupListener.class);

    @Autowired
    private RedisSetting redisConfig;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    }
}
