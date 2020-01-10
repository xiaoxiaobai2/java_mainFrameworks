package test.testSSM;

import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAndMybatis {
    @Test
    public void testSpringAndMybatis(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        User loginUser = new User();
        loginUser.setUsername("zhanghao");
        loginUser.setPassword("daaasdaaaa");
        User login = userService.login(loginUser);
        System.out.println("login = " + login);
    }
}
