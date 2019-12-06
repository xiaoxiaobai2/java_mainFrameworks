import com.zhanghao.dao.UserDao;
import com.zhanghao.domain.QueryVo;
import com.zhanghao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试动态Sql  语句   where if  for each
 */
public class TestMybatis {
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
     * 测试动态sql  where  if
     * @throws Exception
     */
    @Test
    public void testFindByName() throws Exception{
        //5、调用代理对象，执行查询所有方法
        User user =new User();
        user.setName("%张%");
        user.setUid(5);
        List<User> users = userDao.findByName(user);
        System.out.println("users = " + users);
    }


    /**
     * 测试动态sql  where  if  foreach 子查询
     * @throws Exception
     */
    @Test
    public void testFindInUids() throws Exception{
        //5、调用代理对象，执行查询所有方法
        List<Integer> uids = new ArrayList<Integer>();
        uids.add(5);
        uids.add(6);
        QueryVo queryVo = new QueryVo(uids);
        List<User> users = userDao.findInUids(queryVo);
        System.out.println("users = " + users);
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
