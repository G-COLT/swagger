package com.yida.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sun.java2d.cmm.Profile;

import java.util.ArrayList;

/**
 * @author Anttt
 * @version 1.0
 * @date 2020/5/18
 */
@Configuration
@EnableSwagger2
public class SsaggerConfig {


    @Autowired(required = false)
    Environment environment;

    @Bean
    public Docket docket(){
        // 设置要显示swagger的环境
       // Profiles profiles = Profiles.of("dev", "test");
        // 判断当前是处于该环境，通过 enable() 接收此参数判断是否要显示
       // boolean b = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户")
                .select().paths(PathSelectors.ant("/user/**"))
                //.apis(RequestHandlerSelectors.basePackage("com.yida.controller"))
                .build();
                //.enable(!b);// 配置是否启用Swagger，如果是false，在浏览器将无法访问
                //.apiInfo(apiInfo());

    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("你好")
                .select().paths(PathSelectors.ant("/hello/**"))
                .build();

    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("Anttt", "", "");
        return new ApiInfo(
                "Swagger文档",
                "这是Swagger文档",
                "1.0",
                "http://www.baidu.com",
                contact,
                "",
                "",
                new ArrayList<>());
    }

}
