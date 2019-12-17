package com.zhanghao.service.impl;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.domain.Account;
import com.zhanghao.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

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
