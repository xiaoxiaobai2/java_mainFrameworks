package com.zhanghao.service;

import com.zhanghao.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccount();
    Account findAccountById(int id);
    void transaction(String sourceName,String targetName,float money);
}
