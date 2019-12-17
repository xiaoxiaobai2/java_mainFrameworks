package com.zhanghao.dao;

import com.zhanghao.domain.Account;

import java.util.List;

/**
 * 持久层接口
 */
public interface AccountDao {
    List<Account> findAll();
    Account findById(int id);
}
