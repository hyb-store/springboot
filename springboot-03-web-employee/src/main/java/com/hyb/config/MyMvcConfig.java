package com.hyb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //视图跳转
    //如果要扩展springmvc，官方建议这么做
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hyb").setViewName("test");
    }
}
