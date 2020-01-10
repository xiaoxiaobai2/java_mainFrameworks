package com.zhanghao.controller;

import com.zhanghao.pojo.Account;
import com.zhanghao.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(Account account){
        System.out.println("account = " + account);
        return "success";
    }

    @RequestMapping("/testConvert")
    public String testConvert(User user){
        System.out.println("user = " + user);
        return "success";
    }
}
