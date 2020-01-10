package com.zhanghao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor() throws Exception{
        System.out.println("UserController.testInterceptor");
        return "success";
    }
}
