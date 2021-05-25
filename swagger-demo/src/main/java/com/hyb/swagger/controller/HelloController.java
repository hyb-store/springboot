package com.hyb.swagger.controller;

import com.hyb.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //只要我们的接口中，返回值中存在实体类，他就会被扫描到swagger中
    @PostMapping("/user")
    public User user(){
        return new User();
    }

    //Operation接口,放在方法上
    @ApiOperation("HelloController控制类")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }

    //Operation接口,放在方法上
    @ApiOperation("Post控制类")
    @PostMapping("/postt")
    public User postt(@ApiParam("用户") User user){
        return user;
    }

}
