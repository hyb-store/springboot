package com.hyb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//在templates目录下的所有页面，只能通过controller来跳转
//需要模板引擎的支持 thymeleaf
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("msg","hello,springboot");
        return "test";
    }
}
