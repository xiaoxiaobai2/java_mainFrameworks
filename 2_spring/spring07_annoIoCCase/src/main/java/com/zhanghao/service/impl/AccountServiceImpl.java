package com.zhanghao.service.impl;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.domain.Account;
import com.zhanghao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    /*
        自动注入，类型相同的
     */
    @Autowired
    private AccountDao accountDao;

    public void saveAccount(Account account) {
        accountDao.insert(account);
    }

    public List<Account> findAllAccount() {
        return accountDao.findAll();
    }

    public Account findAccountById(int id) {
        return accountDao.findById(id);
    }

    public void deleteAccount(int id) {
        accountDao.delete(id);
    }

    public void updateAccount(Account account) {
        accountDao.update(account);
    }
}
