package test.testSSM;

import cn.itcast.travel.dao.*;
import cn.itcast.travel.domain.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TesrMybatis {

    @Test
    public void testUserDao() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

//        User insertUser = new User();
//        insertUser.setUsername("zhangtian");
//        insertUser.setPassword("123456");
//        insertUser.setName("田");
//        insertUser.setBirthday("2019-11-26");
//        insertUser.setTelephone("11111");
//        insertUser.setEmail("123");
//        userDao.insertUser(insertUser);
//        sqlSession.commit();
//
//        User byUsername = userDao.findByUsername("zhangtian");
//        System.out.println("byUsername = " + byUsername);

//        List<User> allUser = userDao.findAllUser();
//        System.out.println("allUser = " + allUser);


        User byCode = userDao.findByCode("6b2d7e0f994a46f88a5247b884338d88");
        System.out.println("byCode = " + byCode);
    }

    @Test
    public void testCategoryDao() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CategroyDao categroyDao = sqlSession.getMapper(CategroyDao.class);
        List<Category> all = categroyDao.findAll();
        for (Category category : all) {
            System.out.println("category = " + category);
        }
    }

    @Test
    public void testFavoriteDao() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        FavoriteDao favoriteDao = sqlSession.getMapper(FavoriteDao.class);
        List<Favorite> byuid = favoriteDao.findByuid(13);
        for (Favorite favorite : byuid) {
            System.out.println("favorite = " + favorite);
        }
    }

    @Test
    public void testRouteDao() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RouteDao routeDao = sqlSession.getMapper(RouteDao.class);

        List<Route> routeByPage = routeDao.findRouteByPage(5, 1, 5, "%西安%");
        for (Route route : routeByPage) {
            System.out.println("route = " + route);
        }

//        int totalRoute = routeDao.findTotalRoute(5, "");
//        System.out.println("totalRoute = " + totalRoute);

//        Route routeById = routeDao.findRouteById(1);
//        System.out.println("routeById = " + routeById);

//        int allRouteNum = routeDao.findAllRouteNum(5, 9999, 0, "%西安%");
//        System.out.println("allRouteNum = " + allRouteNum);

//        List<Route> allRoutePage = routeDao.findAllRoutePage(5, 5000, 3000, "%西安%", 1, 10);
//        for (Route route : allRoutePage) {
//            System.out.println("route = " + route);
//        }
    }

    @Test
    public void testSellerDao() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SellerDao sellerDao = sqlSession.getMapper(SellerDao.class);
        Seller byId = sellerDao.findById(1);
        System.out.println("byId = " + byId);
    }


    @Test
    public void test(){
        String s="abcdef";
        System.out.println(s.charAt(0));
        System.out.println(s.indexOf('c'));
//        char x='%';
//        System.out.println(x);
    }
}
