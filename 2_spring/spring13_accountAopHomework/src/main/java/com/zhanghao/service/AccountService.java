package com.zhanghao.service;

import com.zhanghao.domain.Account;

import java.util.List;

public interface AccountService {
    void saveAccount(Account account);
    List<Account> findAllAccount();
    Account findAccountById(int id);
    void deleteAccount(int id);
    void updateAccount(Account account);
    Account findAccountByName(String name);
    void transaction(String sourceName,String targetName,float money);
}
