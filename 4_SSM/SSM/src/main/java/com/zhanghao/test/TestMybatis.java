package com.zhanghao.test;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void testFindAll() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //执行方法
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println("account = " + account);
        }
        //释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testSave() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //执行方法

        Account account = new Account();
        account.setName("胡");
        account.setMoney(1000000d);
        accountDao.save(account);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        in.close();
    }
}
