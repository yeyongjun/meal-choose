package com.develop.meal.server.config;

import com.develop.meal.common.AppConst;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;


/**
 * Created by Yitar on 2017/2/23.
 * swagger config
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan("com.develop.meal")
public class SwaggerConfig2 {

    @Bean
    public Docket configure() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(AppConst.SERVICE_NAME +"-real")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.develop.meal"))
                .paths(PathSelectors.any())
                .build().pathMapping("/").apiInfo(apiInfo())
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false).enableUrlTemplating(false);
    }


    private ApiInfo apiInfo() {
        return ApiInfo.DEFAULT;
    }
}
