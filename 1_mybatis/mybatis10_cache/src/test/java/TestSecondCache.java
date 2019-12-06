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


public class TestSecondCache {
    /**
     * 添加Before，在执行测试用例之前执行此代码块
     */
    private InputStream is;
    private SqlSession sqlSession;
    private UserDao userDao;
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws Exception{
        //1、读取配置文件的字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、用SqlSessionFactoryBuilder()。build方法穿件SqlSessionFactory对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3、创建SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        //4、调用getMapper方法撞见代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    /**
     * 测试  mybatis 的二级缓存  sqlSessionFactory
     *      需要 三步开启    (domain 对象需要实现 Serializable接口  ，并且需要关闭一级缓存)
     *
     *      二级缓存  存储的是数据  而不是对象  当调用缓存时，创建一个新的对象，把存储的数据填充进去
     *
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception{
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserDao userDao1 = sqlSession1.getMapper(UserDao.class);
        List<User> users1 = userDao1.findAll();
//        System.out.println("users1 = " + users1);
        System.out.println("users1.hashcode = " + users1.hashCode());

        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserDao userDao2 = sqlSession2.getMapper(UserDao.class);
        List<User> users2 = userDao2.findAll();
        System.out.println("users2.hashcode = " + users2.hashCode());

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
