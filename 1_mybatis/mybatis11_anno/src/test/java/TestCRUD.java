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

public class TestCRUD {
    private SqlSession sqlSession;
    private UserDao userDao;
    private InputStream is;
    /**
     * 初始化  在Test之前自动运行
     */
    @Before
    public void init() throws Exception{
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
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

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("张三");
        user.setAddress("西安");
        userDao.insert(user);
    }

    @Test
    public void testDelete(){
        userDao.deleteById(42);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(50);
        user.setUsername("update");
        user.setAddress("西安");
        userDao.update(user);
    }

    @Test
    public void testFindByName(){
        System.out.println("TestCRUD.testFindByName");
        List<User> users = userDao.findByName("%小%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println("total = " + total);
    }
}
