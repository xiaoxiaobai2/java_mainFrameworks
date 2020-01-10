package cn.itcast.travel.controller;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategroyService;
import cn.itcast.travel.service.impl.CategroyServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * 有关菜单栏的控制器
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategroyService categroyService;
    /**
     * 查找所有目录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/findAll.do")
    public @ResponseBody List<Category> findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("categroyService = " + categroyService);
        //获取目录
        response.setContentType("text/html;charset=utf-8");
        return categroyService.findAll();
    }
}
