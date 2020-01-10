package com.zhanghao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @RequestMapping(path = "/hello")
    public String helloSpringmvc(){
        System.out.println("Hello Spring MVC!");
        return "success";
    }

    /**
     * 获取原生request 和  response
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(path = "/getRequest")
    public String getRequest(HttpServletRequest request, HttpServletResponse response){
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        System.out.println("Hello Spring MVC!");
        return "success";
    }
}
