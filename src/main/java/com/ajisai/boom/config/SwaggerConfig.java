package com.ajisai.boom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private final String PACKAGE_NAME = "com.ajisai.boom.controller";

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_NAME))
                .build()
                .apiInfo(build());
    }

    private ApiInfo build() {
        return new ApiInfoBuilder()
                .title("Ajisai Flower Service")
                .description("Practice in 2016 Spring ^_^")
                .termsOfServiceUrl("Terms of service")
                .contact(new Contact("Japan Ajisai", "ajisai-info.com", "dungntnew@gmail.com"))
                .license("License")
                .licenseUrl("")
                .version("0.0.1")
                .build();
    }
}
