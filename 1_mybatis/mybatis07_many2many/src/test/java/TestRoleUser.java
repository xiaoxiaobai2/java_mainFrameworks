import com.zhanghao.dao.RoleDao;
import com.zhanghao.dao.UserDao;
import com.zhanghao.domain.Role;
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
 *
 */
public class TestRoleUser {
    /**
     * 添加Before，在执行测试用例之前执行此代码块
     */
    private InputStream is;
    private SqlSession sqlSession;
    private RoleDao roleDao;
    @Before
    public void init() throws Exception{
        //1、读取配置文件的字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、用SqlSessionFactoryBuilder()。build方法穿件SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3、创建SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        //4、调用getMapper方法撞见代理对象
        roleDao = sqlSession.getMapper(RoleDao.class);
    }

    /**
     * 测试查询  多个角色对应多个用户
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception{
        //5、调用代理对象，执行查询所有方法
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println("--角色信息--");
            System.out.println(role.toString());
            System.out.println(role.getUsers());
        }
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
