import com.zhanghao.dao.AccountDao;
import com.zhanghao.dao.UserDao;
import com.zhanghao.domain.Account;
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
public class TestAccount {
    /**
     * 添加Before，在执行测试用例之前执行此代码块
     */
    private InputStream is;
    private SqlSession sqlSession;
    private AccountDao accountDao;
    @Before
    public void init() throws Exception{
        //1、读取配置文件的字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、用SqlSessionFactoryBuilder()。build方法穿件SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3、创建SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        //4、调用getMapper方法撞见代理对象
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    /**
     * 需要先开启延时加载  关闭同时加载所有属性
     *      测试 一对一  延时加载
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception{
        //5、调用代理对象，执行查询所有方法
        List<Account> accountList = accountDao.findAll();
//        for (Account account : accountList) {
//            System.out.println(account.toString());
//            System.out.println(account.getUser());
//        }
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
