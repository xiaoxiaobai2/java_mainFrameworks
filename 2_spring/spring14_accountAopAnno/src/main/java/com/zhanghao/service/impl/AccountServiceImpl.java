package com.zhanghao.service.impl;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.domain.Account;
import com.zhanghao.service.AccountService;
import com.zhanghao.utils.TransactionManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")//业务层注解
public class AccountServiceImpl implements AccountService {

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

            int i=1/0;
        //修改目标账户金额
        targetAccount.setMoney(targetAccount.getMoney()+money);
        accountDao.update(targetAccount);
    }
}
