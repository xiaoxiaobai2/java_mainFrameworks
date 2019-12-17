package com.zhanghao.service.impl;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.domain.Account;
import com.zhanghao.service.AccountService;
import com.zhanghao.utils.TransactionManger;

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

    public Account findAccountByName(String name){
        return accountDao.findAccountByName(name);
    }

    public void transaction(String sourceName,String targetName,float money){
        // 查找源账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        //查找目标账户
        Account targetAccount = accountDao.findAccountByName(targetName);
        //修改原账户金额
        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        accountDao.update(sourceAccount);

//            int i=1/0;
        //修改目标账户金额
        targetAccount.setMoney(targetAccount.getMoney()+money);
        accountDao.update(targetAccount);
    }
}
