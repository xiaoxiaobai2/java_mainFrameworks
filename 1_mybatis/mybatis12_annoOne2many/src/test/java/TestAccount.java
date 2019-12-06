import com.zhanghao.dao.AccountDao;
import com.zhanghao.dao.UserDao;
import com.zhanghao.domain.Account;
import com.zhanghao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class TestAccount {
    public static void main(String[] args) throws Exception{
        //1、获取字节输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、获取工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4、获取代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //5、用代理对象调用方法
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
        //6、释放资源
        sqlSession.close();
        is.close();
    }
}
