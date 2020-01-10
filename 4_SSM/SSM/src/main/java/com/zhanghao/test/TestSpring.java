package com.zhanghao.test;

import com.zhanghao.domain.Account;
import com.zhanghao.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * 测试Spring 框架
 */
public class TestSpring {


    @Test
    public void run1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println("account = " + account);
        }
    }

    @Test
    public void testSave(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        Account account = new Account();
        account.setName("呼呼");
        account.setMoney(9999d);
        accountService.save(account);
    }
}
