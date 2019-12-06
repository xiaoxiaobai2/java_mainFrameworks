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
    private SqlSession sqlSession;
    private UserDao userDao;
    private SqlSessionFactory sqlSessionFactory;
    private InputStream is;
    /**
     * 初始化  在Test之前自动运行
     */
    @Before
    public void init() throws Exception{
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    /**
     * 释放资源  test 完成后自动运行
     */
    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        if (is!=null){
            is.close();
        }
    }

    /**
     * 测试 mybatis  用注解   的方式使用二级缓存
     *    1、在配置文件中开启
     *    2、 在dao  中加入@CacheNamespace(blocking = true)注解
     *    3、释放一级缓存
     */
    @Test
    public void testFindAll(){
        System.out.println("TestCRUD.testFindByName");
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserDao userDao1 = sqlSession1.getMapper(UserDao.class);
        User user1 = userDao1.findById(41);
        System.out.println("user1 = " + user1);
        //释放一级缓存
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserDao userDao2 = sqlSession2.getMapper(UserDao.class);
        User user2 = userDao2.findById(41);
        System.out.println("user2 = " + user2);
    }
}
