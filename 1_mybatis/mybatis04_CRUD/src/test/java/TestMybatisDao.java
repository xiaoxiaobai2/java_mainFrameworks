import com.zhanghao.dao.impl.UserDaoDaoImpl;
import com.zhanghao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestMybatisDao {
    /**
     * 测试自己实现dao
     * @throws IOException
     */
    @Test
    public void testMybatisDao() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        UserDaoDaoImpl userDaoDao = new UserDaoDaoImpl(sqlSessionFactory);
        List<User> users = userDaoDao.findAll();
        System.out.println("users = " + users);
    }
}
