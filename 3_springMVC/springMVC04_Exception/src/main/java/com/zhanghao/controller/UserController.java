package com.zhanghao.controller;

import com.zhanghao.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws Exception{
        System.out.println("UserController.testException");
        try {
            int i=1/0;
        } catch (Exception e) {
            e.printStackTrace();
            //抛出自定义的异常，由异常处理器解决
            throw new SysException("除数不能为0");
        }
        return "success";
    }
}
