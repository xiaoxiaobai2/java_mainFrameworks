package test.testSSM;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.CategroyService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpring {
    @Test
    public void testCategroy(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        CategroyService categroyService = ac.getBean("categroyService", CategroyService.class);
        List<Category> all = categroyService.findAll();
        for (Category category : all) {
            System.out.println(category);
        }
    }

    @Test
    public void testRouteService(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        RouteService routeService = ac.getBean("routeService", RouteService.class);
        Route routeInf = routeService.findRouteInf(1);
        System.out.println("routeInf = " + routeInf);
    }

    @Test
    public void testUserService(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        User user = userDao.findByUsername("zhanghao");
        System.out.println("user = " + user);
    }
}
