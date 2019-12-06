import com.zhanghao.dao.UserDao;
import com.zhanghao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


/**
 * 测试  mybatis 的一级缓存  SqlSession对象
 *      当用同一个SqlSession对象 调用同一个查询  方法时   第二次直接将缓存的对象  返回
 *          可调用 clearCache 方法清除缓存
 *          当 mybatis 调用 曾删改 方法后自动清除一级缓存
 */
public class TestUser {
    /**
     * 添加Before，在执行测试用例之前执行此代码块
     */
    private InputStream is;
    private SqlSession sqlSession;
    private UserDao userDao;
    @Before
    public void init() throws Exception{
        //1、读取配置文件的字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、用SqlSessionFactoryBuilder()。build方法穿件SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3、创建SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        //4、调用getMapper方法撞见代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    /**
     * 测试查询  一个用户对应多个账户   延时查询
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception{
        //5、调用代理对象，执行查询所有方法
//        List<User> userList = userDao.findAll();
//        sout
    }

    /**
     * 测试  mybatis 的一级缓存  SqlSession对象
     *      当用同一个SqlSession对象 调用同一个查询  方法时   第二次直接将缓存的对象  返回
     *          可调用 clearCache 方法清除缓存
     *          当 mybatis 调用 曾删改 方法后自动清除一级缓存
     *
     * @throws Exception
     */
    @Test
    public void testFindById() throws Exception{
        //5、调用代理对象，执行查询所有方法

        User user = userDao.findById(43);
        System.out.println("user.hashCode = "+user.hashCode());

//        //手动清除一级缓存
//        sqlSession.clearCache();

        //调用曾删改防擦 自动清除一级缓存
        User updateUser = new User();
        updateUser.setId(43);
        updateUser.setUsername("小胡");
        userDao.update(updateUser);

        User user2 = userDao.findById(43);
        System.out.println("user2.hashCode = "+user2.hashCode());
        System.out.println(user==user2);

    }

    @Test
    public void testUpdate() throws Exception{
        //5、调用代理对象，执行查询所有方法

        User user = new User();
        user.setId(43);
        user.setUsername("小胡");
        userDao.update(user);
    }



    /**
     * 添加after注解，测试用例执行完后，执行此代码块
     *      释放资源
     */
    @After
    public void Destory() throws Exception{
        sqlSession.commit();
        //6、释放资源
        is.close();
        sqlSession.close();
    }
}
