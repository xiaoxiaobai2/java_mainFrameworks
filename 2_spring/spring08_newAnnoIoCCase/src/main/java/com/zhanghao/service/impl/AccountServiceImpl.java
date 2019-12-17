package com.zhanghao.service.impl;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.domain.Account;
import com.zhanghao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
    注解 业务逻辑层
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    /*
        在核心容器中查找 类型形同的参数注入
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
