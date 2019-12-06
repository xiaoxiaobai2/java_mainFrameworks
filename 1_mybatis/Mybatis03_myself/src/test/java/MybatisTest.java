import com.zhanghao.dao.UserDao;
import com.zhanghao.domain.User;
import com.zhanghao.mybatis.io.Resources;
import com.zhanghao.mybatis.sqlsession.SqlSession;
import com.zhanghao.mybatis.sqlsession.SqlSessionFactoryBuilder;
import com.zhanghao.mybatis.sqlsession.SqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Mybatis入门
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1、读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3、使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4、使用SqlSession对象创建Dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);

        //5、使用代理对象执行方法
        List<User> userList = userDao.findAll();
        System.out.println(userList);
        List<User> userList2 = userDao.findById(5);
        System.out.println(userList2);

        //6、释放资源
        session.close();
        is.close();
    }
}
