package com.zhanghao.service.impl;

import com.zhanghao.dao.UserDao;
import com.zhanghao.dao.daoImpl.UserDaoImpl;
import com.zhanghao.factory.BeanFactory;
import com.zhanghao.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
    private int i = 1;
    public void saveUser() {
        System.out.println(i);
        userDao.saveUser();
        i++;
    }
}
