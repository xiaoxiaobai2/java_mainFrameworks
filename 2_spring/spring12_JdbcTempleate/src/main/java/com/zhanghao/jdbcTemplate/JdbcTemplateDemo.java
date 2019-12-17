package com.zhanghao.jdbcTemplate;

import com.zhanghao.dao.impl.AccountDaoImpl;
import com.zhanghao.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateDemo {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountDaoImpl accountDao = ac.getBean("accountDao", AccountDaoImpl.class);
        List<Account> accounts = accountDao.findAll();
        Account accountById = accountDao.findById(8);

        for (Account account : accounts) {
            System.out.println(account);
        }

        System.out.println("accountById = " + accountById);
    }
}
