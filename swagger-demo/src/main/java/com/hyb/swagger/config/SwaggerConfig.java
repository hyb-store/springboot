package com.hyb.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {
    //配置多个分组，多个Docket实例即可
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.OAS_30).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.OAS_30).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.OAS_30).groupName("C");
    }

    //配置了swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");

        //通过environment.acceptsProfiles判断是否处于自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return  new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                //是否启用swagger 默认为true
                .enable(flag)
                .groupName("hyb")//配置api文档分组
                .select()
                //RequestHandlerSelectors 配置要扫描接口的方式
                //basePackage 指定要扫描的包
                //.apis(RequestHandlerSelectors.basePackage("com.hyb.swagger.controller"))
                //any() 扫描全部        any()不扫描
                //withClassAnnotation() 扫描类上的注解
                //withMethodAnnotation() 扫描方法上注解
                .apis(RequestHandlerSelectors.basePackage("com.hyb.swagger.controller"))
                //paths() 过滤什么路径
                //.paths(PathSelectors.ant("/hyb/**"))//相当于什么都没扫到
                .build();
    }

    //配置swagger信息apiInfo
    public ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("hyb", "", "");

        return new ApiInfo("Swagger的Api文档"
                , "Api文档"
                , "1.0"
                , "urn:tos"
                , contact
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList());

    }
}
