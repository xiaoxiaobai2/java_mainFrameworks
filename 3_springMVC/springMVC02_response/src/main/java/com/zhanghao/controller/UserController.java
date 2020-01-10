package com.zhanghao.controller;

import com.zhanghao.javabean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("testString")
    public String testString(){
        System.out.println("UserController.testString");
        return "success";
    }

    @RequestMapping("testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("UserController.testVoid");
        //转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        System.out.println(request.getContextPath());
        //重定向
        response.sendRedirect(request.getContextPath()+"/redirect.jsp");
        return ;
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("UserController.testModelAndView");
        ModelAndView modelAndView = new ModelAndView();
        //实际存储到request域中
        modelAndView.addObject("username","张浩");

        //设置要跳转到的页面，使用试图解析器
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("testDispatcherAndRedirect")
    public String testDispatcherAndRedirect(){
        System.out.println("UserController.testDispatcherAndRedirect");
//        return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/redirect.jsp";
    }


    @RequestMapping("testAjax")
    //导入jackson相关的包，会自动转换json和string
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("UserController.testAjax");
        System.out.println(user.toString());
        user.setUsername("xiaohu");
        return user;
    }


}
