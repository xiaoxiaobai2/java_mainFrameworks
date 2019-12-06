import com.zhanghao.dao.UserDao;
import com.zhanghao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class TestAnno {
    public static void main(String[] args) throws Exception{
        //1、获取字节输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、获取工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4、获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5、用代理对象调用方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
        //6、释放资源
        sqlSession.close();
        is.close();
    }
}
