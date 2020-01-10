package com.zhanghao.service.impl;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.domain.Account;
import com.zhanghao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {


    //持久层的接口不用注入，Spring 会自动生成代理
    @Autowired
    private AccountDao accountDao;
    public List<Account> findAll() {
        System.out.println("业务层查询所有。。。");
        return accountDao.findAll();
    }

    public void save(Account account) {
        accountDao.save(account);
    }
}
