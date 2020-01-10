package com.zhanghao.service;

import com.zhanghao.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    void save(Account account);
}
