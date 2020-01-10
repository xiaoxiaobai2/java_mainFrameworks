package com.zhanghao.controller;

import com.zhanghao.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@RequestMapping("Anno")
@Controller
@SessionAttributes("msg")
public class AnnoController {

    /**
     * testRequestParam   请求参数与形参名不一样
     * @param name
     * @return
     */
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam("username") String name){
        System.out.println(name);
        return "success";
    }

    /**
     * testRequestBody   获取请求体
     * @param body
     * @return
     */
    @RequestMapping("testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("body = " + body);
        return "success";
    }

    /**
     * testPathVariable   占位  restful
     * @param uid
     * @return
     */
    @RequestMapping("testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") int uid){
        System.out.println("uid = " + uid);
        return "success";
    }

    /**
     * testRequestHeader   获取请求头
     * @param header
     * @return
     */
    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader("Cookie") String header){
        System.out.println("header = " + header);
        return "success";
    }

    /**
     * testCookieValue   获取COOKIE
     * @param JSESSIONID
     * @return
     */
    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String JSESSIONID){
        System.out.println("JSESSIONID = " + JSESSIONID);
        return "success";
    }


    /**
     * testModelAttribute   在Controller执行之前执行，可以补全参数,
     *      模拟从数据库查找数据并补全，传递
     * @return
     */
//    @ModelAttribute
//    public User testModelAttribute(String username,int age){
//        User user = new User();
//        user.setUsername(username);
//        user.setAge(age);
//        user.setBirthday(new Date());
//        return user;
//    }


    /**
     * testModelAttribute   在Controller执行之前执行，可以补全参数,
     *      模拟从数据库查找数据并补全，传递
     * @return
     */
//    @ModelAttribute
//    public void testModelAttribute(String username, int age, Map<String,User> userMap){
//        User user = new User();
//        user.setUsername(username);
//        user.setAge(age);
//        user.setBirthday(new Date());
//        userMap.put("user",user);
//    }


//    @RequestMapping("testModelAttribute")
//    public String testModelAttribute(User user){
//        System.out.println("user = " + user);
//        return "success";
//    }

    @RequestMapping("testModelAttribute")
    public String testModelAttribute(@ModelAttribute("user") User user){
        System.out.println("user = " + user);
        return "success";
    }



    /**
     * testSessionAttributes
     * @param model
     * @return
     */
    @RequestMapping("testSessionAttributes")
    public String testSessionAttributes(ModelMap model){
        model.addAttribute("msg","妹妹");
        return "success";
    }

    /**
     * testSessionAttributes
     * @param model
     * @return
     */
    @RequestMapping("getSessionAttribute")
    public String getSessionAttribute(ModelMap model){
        String msg = (String) model.get("msg");
        System.out.println("msg = " + msg);
        return "success";
    }

    /**
     * testSessionAttributes
     * @param model
     * @return
     */
    @RequestMapping("deleteSessionAttribute")
    public String deleteSessionAttribute(SessionStatus status){
        status.setComplete();
        return "success";
    }

}
