package com.hyb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//如果你想diy一些定制化的功能。只要写这个组件，把它交给springboot，springboot会帮我们自动装备
//扩展springmvc  dispatchservlet
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
//------------------------------------------------------------------------
//    //实现了视图解析器接口的类，我们可以将其看作视图解析器
//    @Bean
//    public ViewResolver myViewResolver(){
//        return new MyViewResolver();
//    }
//
//    //自定义一个自己的视图解析器MyViewResolver
//    public static class MyViewResolver implements ViewResolver {
//        @Override
//        public View resolveViewName(String s, Locale locale) throws Exception {
//            return null;
//        }
//    }
//---------------------------------------------------------------------

    //视图跳转
    //如果要扩展springmvc，官方建议这么做
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hyb").setViewName("test");
    }
}
