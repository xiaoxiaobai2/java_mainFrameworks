package com.zhanghao.ui;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.service.Service;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        Service serviceImpl = ac.getBean("serviceImpl", Service.class);
        serviceImpl.saveAccount();
//        System.out.println(serviceImpl);
//
//        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
//        System.out.println("accountDao = " + accountDao);
        ac.close();
    }
}
