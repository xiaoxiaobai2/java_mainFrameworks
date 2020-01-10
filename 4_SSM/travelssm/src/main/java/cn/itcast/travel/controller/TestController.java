package cn.itcast.travel.controller;

import cn.itcast.travel.service.CategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {


    @Autowired
    private CategroyService categroyService;
    @RequestMapping("/test.do")
    public String test(){
        System.out.println(categroyService);
        return "test";
    }
}
