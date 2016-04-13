package com.ajisai.boom;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan(includeFilters = @ComponentScan.Filter(ControllerAdvice.class))
public class AjisaiTestContext extends WebMvcConfigurationSupport{
}
