package cn.itcast.travel.controller;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    /**
     * 分页展示路线
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/findRoute.do")
    public @ResponseBody PageBean<Route> findRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("RouteServlet.findRoute");
        System.out.println("routeService = " + routeService);



        //获取参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        String rnameStr = request.getParameter("rname");

        if (rnameStr!=null && !rnameStr.equalsIgnoreCase("null") && rnameStr.length()>0){
            if (!(rnameStr.charAt(0)=='%'))
                rnameStr = "%" +rnameStr +"%";
        }

        System.out.println("RouteServlet.findRoute---rname = " + rnameStr);
        System.out.println(cidStr);

        int cid = 5;//如果没找到值，这个就是默认值
        if (cidStr != null && cidStr.length() > 0 && !cidStr.equalsIgnoreCase("null")) {
            cid = Integer.valueOf(cidStr);
        }

        int currentPage = 1;//如果没找到值，这个就是默认值
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.valueOf(currentPageStr);
        }

        int pageSize = 5;//如果没找到值，这个就是默认值
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.valueOf(pageSizeStr);
        }
        if (rnameStr.equalsIgnoreCase("null")) {
            rnameStr = null;
        }
        //查询路线封装到pageBean
        return routeService.pageQuery(cid, currentPage, pageSize, rnameStr);
    }

    /**
     * 根据Id查询线路的详细信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/findRouteInf.do")
    public @ResponseBody Route findRouteInf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取线路id
        System.err.println("RouteServlet.findRouteInf");
        String rid = request.getParameter("rid");
        //获取到含有图片列表、卖家信息的路线对象;
        System.out.println("Integer.valueOf(rid) = " + Integer.valueOf(rid));
        return routeService.findRouteInf(Integer.valueOf(rid));
    }

    /**
     * 根据rid查询是否已经收藏
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/findFavorite.do")
    public @ResponseBody boolean findFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RouteController.findFavorite");

        String rid = request.getParameter("rid");
        System.out.println("rid = " + rid);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        boolean flag;
        if (user == null) {
            flag = false;
            System.err.println("当前未登陆！");
        } else {
            int uid = user.getUid();
            System.out.println("uid = " + uid);
            flag = routeService.isFavorite(Integer.valueOf(rid), uid);
        }
        return flag;
    }

    /**
     * 添加收藏
     *
     * @param request
     */
    @RequestMapping("/addFavorite.do")
    public @ResponseBody boolean addFavorite(HttpServletRequest request){
        System.out.println("RouteController.addFavorite");
        String rid = request.getParameter("rid");
        System.out.println(rid);
        //获取当前登陆的用户，前面已经判断过是否登陆，此处不用再判断
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();
        routeService.addFavorite(Integer.parseInt(rid), uid);
        return true;
    }

    /**
     * 查找我收藏的线路
     *
     * @param request
     */
    @RequestMapping("/findMyFavorite.do")
    public @ResponseBody List<Route> findMyFavorite(HttpServletRequest request){
        System.out.println("RouteController.findMyFavorite");

        //获取当前而当登陆的用户
        User user = (User) request.getSession().getAttribute("user");
        //拿到UID
        int uid = user.getUid();
        //通过Uid找到该用户收藏的线路,并返回
        return routeService.findMyFavorite(uid);
    }


    /**
     * 查找所有符合要求的线路，并按照收藏数量进行排序
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/findAllRoute.do")
    public @ResponseBody PageBean<Route> findAllRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RouteController.findAllRoute");

        //获取参数
        String rnameStr = request.getParameter("rname");
        String maxPriceStr = request.getParameter("maxPrice");
        String minPriceStr = request.getParameter("minPrice");
        String currentPageStr = request.getParameter("currentPage");

        if (rnameStr!=null && !rnameStr.equalsIgnoreCase("null") && rnameStr.length()>0){
            if (!(rnameStr.charAt(0)=='%'))
                rnameStr = "%" +rnameStr +"%";
        }

        System.out.println("rnameStr = " + rnameStr);
        int currentPage = 1;
        if (currentPageStr!=null&&currentPageStr.length()>0){
            currentPage = Integer.parseInt(currentPageStr);
        }
        int maxPrice = -1;
        if (maxPriceStr!=null&&maxPriceStr.length()>0){
            maxPrice = Integer.parseInt(maxPriceStr);
        }
        int minPrice = -1;
        if (minPriceStr!=null&&minPriceStr.length()>0){
            minPrice = Integer.parseInt(minPriceStr);
        }
        int pageSize = 8;
        int cid = 5;

        return routeService.findAllRoute(maxPrice, minPrice, rnameStr, currentPage, cid, pageSize);
    }
}
